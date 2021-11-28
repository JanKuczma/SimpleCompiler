package com;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

import static com.Types.INT;

public class SExpressionsAnalyser extends SExpressionsBaseVisitor<Types>
{
    private Map<String, SExpressionsParser.DecContext> global_funcs = new HashMap<>();
    private Map<String, Types> local_vars = new HashMap<>();

    private SExpressionsParser.DecContext current_dec = null;
    private final SExpressionsToString toStrConverter = new SExpressionsToString();

    public String visitAndPrint(SExpressionsParser.ProgContext prog)
    {

        visit(prog);    // Discards the dummy return value.

        // At this point, we know for sure that there is at least a 'main' function.

        int index_main = 0;
        for (int i = 0; i < prog.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = prog.decs.get(i);
            if (dec.identifier().Idfr().getText().equals("main")) {
                index_main = i;
            }
        }

        SExpressionsParser.DecContext main = prog.decs.get(index_main);
        prog.decs.set(index_main, prog.decs.get(0));
        prog.decs.set(0, main);

        return toStrConverter.visitHighlight(prog, prog).replaceAll("\u001B\\[[;\\d]*m", "");   // Removes ANSI colours.

    }

    @Override public Types visitProg(SExpressionsParser.ProgContext ctx)
    {


        Boolean found_main = false;

        for (int i = 0; i < ctx.decs.size(); ++i) {
            SExpressionsParser.DecContext dec = ctx.decs.get(i);
            SExpressionsParser.IdentifierContext id = dec.identifier();
            SExpressionsParser.TypeContext type = dec.type();
            if (id.Idfr().getText().equals("main")) {
                found_main = true;
                //check the type of "main"
                if(!Types.toType(type).equals(INT)){
                    throw new TypeException().mainFuncError(ctx,dec,Types.toType(type));
                }
                //check if "main" has no params
                if(dec.params.size() != 0){
                    throw new TypeException().mainFuncError(dec,dec.params.get(0),
                            Types.toType(dec.params.get(0).type()));
                }
            }
            //check for duplicate function idfr
            if(global_funcs.containsKey(id.Idfr().getText())){
                throw new TypeException().duplicatedFuncError(ctx,id,Types.toType(type));
            }
            global_funcs.put(id.Idfr().getText(),dec);
        }

        //if main wasn't found
        if (!found_main) {
            throw new TypeException().noMainFuncError();
        }
        //check all the decs
        for (int i = 0; i < ctx.decs.size(); ++i){
            visit(ctx.decs.get(i));
        }
        return Types.UNKNOWN;   // This is just a dummy return value.
    }

    @Override public Types visitDec(SExpressionsParser.DecContext ctx)
    {
        // TODO: modify and complete this method.
        current_dec = ctx;
        SExpressionsParser.IdentifierContext id = ctx.identifier();
        SExpressionsParser.TypeContext type = ctx.type();
        for (int i = 0; i < ctx.params.size();i++) {
            SExpressionsParser.IdentifierContext param_id = ctx.params.get(i).identifier();
            SExpressionsParser.TypeContext param_type = ctx.params.get(i).type();
            //check for duplicate param idfrs
            if(local_vars.containsKey(param_id.Idfr().getText())){
                throw new TypeException().duplicatedVarError(ctx,param_id,Types.toType(param_type));
            }
            //check param type (only INT and BOOL allowed so no UNIT)
            if(Types.toType(param_type) == Types.UNIT){
                throw new TypeException().unitVarError(ctx,param_id,Types.toType(param_type));
            }
            local_vars.put(param_id.Idfr().getText(),Types.toType(param_type));
        }
        //visit function body, check type of the block == function type
        Types final_exp_type = visit(ctx.block());
        if(!final_exp_type.equals(Types.toType(type))){
            throw new TypeException().functionBodyError(ctx,
                    ctx.block().expr(ctx.block().expr().size()-1),final_exp_type);
        }
        //clear local vars from environment (symbol table)
        //so next fun_dec will have clear env
        local_vars.clear();
        return Types.toType(type);   // This is just a dummy return value.
    }

    @Override public Types visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitType(SExpressionsParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBlock(SExpressionsParser.BlockContext ctx)
    {
        // TODO: modify and complete this method.
        //a block may have no expressions so defautl is UNIT
        Types final_exp_type = Types.UNIT;
        for (int i = 0; i < ctx.exprs.size(); i++) {
            final_exp_type = visit(ctx.exprs.get(i));
        }
        //return Type of the last expression
        return final_exp_type;
    }

    @Override public Types visitIfExpr(SExpressionsParser.IfExprContext ctx)
    {
        // TODO: modify and complete this method.
        Types cond_t = visit(ctx.expr());
        Types block1_t = visit(ctx.block(0));
        Types block2_t = visit(ctx.block(1));
        //check if condition is type Bool
        if(!cond_t.equals(Types.BOOL)){
            throw new TypeException().conditionError(ctx,ctx.expr(),cond_t);
        }
        //check if both blocks have the same type
        if(!block1_t.equals(block2_t)){
            throw new TypeException().branchMismatchError(ctx,
                    ctx.block(0).expr(ctx.block(0).expr().size()-1),block1_t,
                    ctx.block(1).expr(ctx.block(1).expr().size()-1),block2_t);
        }
        return block1_t;
    }

    @Override public Types visitBinExpr(SExpressionsParser.BinExprContext ctx)
    {
        // TODO: modify and complete this method.

        SExpressionsParser.ExprContext operand1 = ctx.expr(0);
        SExpressionsParser.ExprContext operand2 = ctx.expr(1);
        Types operand1_t = visit(operand1);
        Types operand2_t = visit(operand2);

        Types return_type = switch(((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()){
            //arithmetic exprs
            case SExpressionsParser.Times:
            case SExpressionsParser.Div:
            case SExpressionsParser.Plus:
            case SExpressionsParser.Minus:
                if(!operand1_t.equals(INT) || !operand2_t.equals(INT)){
                    throw new TypeException().arithmeticError(ctx,operand1,operand1_t,operand2,operand2_t);
                }
                yield Types.INT;
            //comparisons exprs
            case SExpressionsParser.Eq:
            case SExpressionsParser.Less:
            case SExpressionsParser.Gtr:
            case SExpressionsParser.LessEq:
            case SExpressionsParser.GtrEq:
                if(!operand1_t.equals(INT) || !operand2_t.equals(INT)){
                    throw new TypeException().comparisonError(ctx,
                                operand1,operand1_t,operand2,operand2_t);
                }
                yield Types.BOOL;
            //Boolean exprs
            case SExpressionsParser.And:
            case SExpressionsParser.Or:
            case SExpressionsParser.Xor:
                if(!operand1_t.equals(Types.BOOL) || !operand2_t.equals(Types.BOOL)){
                    throw new TypeException().logicalError(ctx,
                                operand1,operand1_t,operand2,operand2_t);
                }
                yield Types.BOOL;
            default:
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
        };
        return return_type;
    }

    @Override public Types visitWhileExpr(SExpressionsParser.WhileExprContext ctx)
    {
        Types cond_t = visit(ctx.expr());
        Types block_t = visit(ctx.block());
        // check if the loop condition has type BOOL
        if(!cond_t.equals(Types.BOOL)){
            throw new TypeException().conditionError(ctx,ctx.expr(),cond_t);
        }
        //check if the loop's type is UNIT, e.i. last exp in the loopbody
        if(!block_t.equals(Types.UNIT)){
            throw new TypeException().loopBodyError(ctx,
                    ctx.block().expr(ctx.block().expr().size()-1),block_t);
        }

        return Types.UNIT;
    }

    @Override public Types visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx)
    {
        Types cond_t = visit(ctx.expr());
        Types block_t = visit(ctx.block());
        // check if the loop condition has type BOOL
        if(!cond_t.equals(Types.BOOL)){
            throw new TypeException().conditionError(ctx,ctx.expr(),cond_t);
        }
        //check if the loop's type is UNIT, e.i. last exp in the loopbody
        if(!block_t.equals(Types.UNIT)){
            throw new TypeException().loopBodyError(ctx,
                    ctx.block().expr(ctx.block().expr().size()-1),block_t);
        }

        return Types.UNIT;
    }

    @Override public Types visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx)
    {
        SExpressionsParser.ExprContext right = ctx.expr();
        SExpressionsParser.IdentifierContext left = ctx.identifier();
        //check if variable was declared
        if(!local_vars.containsKey(left.Idfr().getText())){
            throw new TypeException().undeclaredVarError(current_dec,left,Types.UNKNOWN);
        }
        Types left_t = local_vars.get(left.Idfr().getText());
        Types right_t = visit(right);
        //check if types match
        if(!left_t.equals(right_t)){
            throw new TypeException().assignmentError(ctx,left,left_t,right,right_t);
        }
        return Types.UNIT;
    }

    @Override public Types visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx)
    {
        Types f_type;
        //check if the function was defined
        if(!global_funcs.containsKey(ctx.identifier().Idfr().toString())){
            throw new TypeException().undeclaredFuncError(current_dec,ctx.identifier(),Types.UNKNOWN);
        } else {
            SExpressionsParser.DecContext fun_dec = global_funcs.get(ctx.identifier().Idfr().toString());
            f_type = Types.toType(fun_dec.type());
            //check if number of args is correct
            if(fun_dec.params.size()!=ctx.block().exprs.size()){
                throw new TypeException().argumentNumberError(ctx,ctx.block(),Types.UNKNOWN);
            }
            //check if types are correct
            for (int i = 0; i < ctx.block().exprs.size(); i++) {
                Types arg_t = visit(ctx.block().exprs.get(i));
                if(!Types.toType(fun_dec.params.get(i).type()).equals(arg_t)){
                    throw new TypeException().argumentError(ctx,ctx.block().exprs.get(i),arg_t);
                }
            }

        }
        return f_type;
    }

    @Override public Types visitBlockExpr(SExpressionsParser.BlockExprContext ctx)
    {
        //just visit the block
        return visit(ctx.block());
    }

    @Override public Types visitIdExpr(SExpressionsParser.IdExprContext ctx)
    {
        // check if variable was declared (i.e. passed as argument)
        if(!local_vars.containsKey(ctx.identifier().Idfr().getText())){
            throw new TypeException().undeclaredVarError(current_dec,ctx.identifier(),Types.UNKNOWN);
        }
        return local_vars.get(ctx.identifier().Idfr().getText());
    }

    @Override public Types visitIntExpr(SExpressionsParser.IntExprContext ctx)
    {
        return INT;
    }

    @Override public Types visitSkipExpr(SExpressionsParser.SkipExprContext ctx)
    {
        return Types.UNIT;
    }

    @Override public Types visitIdentifier(SExpressionsParser.IdentifierContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitInteger(SExpressionsParser.IntegerContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Types visitBinop(SExpressionsParser.BinopContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

}
