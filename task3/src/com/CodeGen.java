package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeGen extends SExpressionsBaseVisitor<String>{

    private ArrayList<String> code_list = new ArrayList<>(); // for the code to be concat at the end
        // (fun_idfr : [list of arg idfrs]) pairs
    private Map<String, ArrayList<String>> f_table = new HashMap<>(); //needed to know args relational positions
    private String current_f = "main"; // needed in case of FunInvocation in fun declarations
    private int label_no = 0;   //after the first call of newLabel() it'll be incremented to 1
                                // so the first label will be label_1
    private String newLabel(){
        label_no++;
        return "label_"+label_no;
    }

    @Override
    public String visitProg(SExpressionsParser.ProgContext ctx) {
        code_list.add(".text");
        String code = "";
        code_list.add("b main_label");
        //we need to store information about no of
        //declared params and their idfrs for each function
        //so we can later calc the offsets to find the val of variable
        //relative to position of FP
        for (int i = 1; i < ctx.decs.size(); i++) {
            f_table.put(ctx.decs.get(i).identifier().Idfr().getText(),new ArrayList<>());
            for (int j = 0; j < ctx.decs.get(i).params.size(); j++) {
                //f_table.get(current_f).add(nth_arg)
                f_table.get(ctx.decs.get(i).identifier().Idfr().getText()).add(ctx.decs.get(i).params.get(j).identifier().Idfr().getText());
            }

        }
        for (int i = 1; i < ctx.decs.size(); i++) {
            visit(ctx.decs.get(i));
        }
        //hop to main
        code_list.add("main_label: ");
        current_f = "main";
        visit(ctx.decs.get(0).block());
        for (int i = 0; i < Macro.values().length; i++) code += Macro.values()[i].instructions; // put the macros
        code += String.join("\n",code_list);    // concat the instrs
        return code;    // return code
    }

    @Override
    public String visitDec(SExpressionsParser.DecContext ctx) {
        current_f = ctx.identifier().Idfr().getText();
        code_list.add(current_f + "_label:");// create label for the control link
            //the "Label" is added to avoid situation where someone defined function with name e.g. label_1
        visit(ctx.block());
        code_list.add("ret");
        return "";
    }

    @Override
    public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        //activation record
        String previous = current_f; // needed to calc arg - FP offset
        current_f = ctx.identifier().Idfr().getText();
		code_list.add("sw   ra, 0(sp) #AR start"); //<-- 4(sp)'old // push caller's ret address/space for ret val
        code_list.add("addi sp, sp, -4");
        code_list.add("sw   sp, 0(sp)"); //<-- 4(FP)  // push the current SP
		code_list.add("addi sp, sp, -4");
        code_list.add("sw   fp, 0(sp)"); //<--FP    //push caller's FP
        code_list.add("addi sp, sp, -4");

        //push the arguments
        visit(ctx.block());
        code_list.add("mv  fp,  sp");       //set new FP (current SP - no of args*4 +4)
        code_list.add("addi fp, fp, " + (f_table.get(current_f).size()*(4)+4));
        // no variables can be declared except function parameters so no local vars

        code_list.add("jal " +  ctx.identifier().Idfr().getText() + "_label #AR finish"); // control link

        current_f=previous;
        code_list.add("lw   sp, 4(fp) #restoring SP");    //restore SP
        code_list.add("lw   ra, 4(sp) #restoring ra");    //restore caller's ra
        code_list.add("sw   a0, 4(sp) #store ret val");    //push the ret val (for 'unit' type it'll be just garbage)
        code_list.add("lw   fp, 0(fp) #restoring FP");    //restore caller's FP
        return "";
    }

    @Override
    public String visitTyped_idfr(SExpressionsParser.Typed_idfrContext ctx) {
        //just return the actual identifier
        return ctx.identifier().Idfr().getText();
    }

    @Override
    public String visitType(SExpressionsParser.TypeContext ctx) {
        //shouldn't be here
        return "";
    }

    @Override
    public String visitBlock(SExpressionsParser.BlockContext ctx) {
        // visit all the expresions in the block
        for (int i = 0; i < ctx.exprs.size(); i++) {
            visit(ctx.exprs.get(i));
        }
        return "";
    }

    @Override
    public String visitIfExpr(SExpressionsParser.IfExprContext ctx) {
        //labels for if and else
        String ifstmt = newLabel();
        String elsestmt = newLabel();
        visit(ctx.expr());
        //jumps to 'ifstmt' if exp is True
        code_list.add(Macro.Jump.name() + "Macro " + ifstmt);
        //otherwise goes through 'else'
        visit(ctx.block(1));
        //and jumps to the end of the statement (elsestmt label)
        code_list.add("b " + elsestmt);
        code_list.add(ifstmt+":");
        visit(ctx.block(0));
        code_list.add(elsestmt+":");
        return "";
    }

    @Override
    public String visitBinExpr(SExpressionsParser.BinExprContext ctx) {
        //simply visit the expressions and perform bin operation
        //by choosing appropriate macro
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        code_list.add(Macro.valueOf(visit(ctx.binop())).name() + "Macro");
        return "";
    }

    @Override
    public String visitWhileExpr(SExpressionsParser.WhileExprContext ctx) {
        //generate labels: 1 to loop, second one to exit the loop
        String w_loop = newLabel();
        String w_loop_e = newLabel();
        code_list.add("b " + w_loop_e);
        code_list.add(w_loop+":");
        visit(ctx.block());
        code_list.add(w_loop_e+":");
        visit(ctx.expr());
        code_list.add(Macro.Jump.name() + "Macro " + w_loop);
        return "";
    }

    @Override
    public String visitRepeatExpr(SExpressionsParser.RepeatExprContext ctx) {
        //similar to while loop, except that the block will be visited at least once
        String r_loop = newLabel();
        code_list.add(r_loop+":");
        visit(ctx.block());
        visit(ctx.expr());
        code_list.add(Macro.Jump.name() + "Macro " + r_loop);
        return "";
    }

    @Override
    public String visitAsgmtExpr(SExpressionsParser.AsgmtExprContext ctx) {
        code_list.add(visit(ctx.expr())); // first visit the expression
        //then calc the offset from the FP
        int offset = (-4*f_table.get(current_f).indexOf(ctx.identifier().Idfr().getText()))-4;
        //and then pop the value that is to be assigned and in place of old var val
        code_list.add(Macro.Pop.name() + " a0");
        code_list.add("sw a0, " + offset + "(fp) #store arg");
        return "";
    }

    @Override
    public String visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        visit(ctx.block());
        return "";
    }

    @Override
    public String visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        // similar to AsgmtExp except we get a "copy" of the variable
        int offset = (-4*f_table.get(current_f).indexOf(ctx.identifier().Idfr().getText()))-4;
        code_list.add("lw a0, "+ offset +"(fp) #load arg");
        code_list.add(Macro.Push.name() + " a0");
        return "";
    }

    @Override
    public String visitIntExpr(SExpressionsParser.IntExprContext ctx) {
        // any numbers = PushImm on the stack
        code_list.add(Macro.PushImm + " " + visit(ctx.integer()));
        return "";
    }

    @Override
    public String visitSkipExpr(SExpressionsParser.SkipExprContext ctx) {
        // just ignore skip
        return "";
    }

    @Override
    public String visitIdentifier(SExpressionsParser.IdentifierContext ctx) {
        //just return the identifier
        return ctx.Idfr().getText();
    }

    @Override
    public String visitInteger(SExpressionsParser.IntegerContext ctx) {
        // return the integer (as a string ofc)
        return ctx.IntLit().getText();
    }

    @Override
    public String visitBinop(SExpressionsParser.BinopContext ctx) {
        //returns the type of binop e.g. "Plus" or "Xor"
        return ctx.getText();
    }
}
