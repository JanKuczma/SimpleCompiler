package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeGen extends SExpressionsBaseVisitor<String>{

    private ArrayList<String> code_list = new ArrayList<>(); // for the code
    private Map<String, SExpressionsParser.DecContext> fun_table = new HashMap<>(); //needed to know args relational positions
    private SExpressionsParser.DecContext current_f = null; // needed in case of FunInvocation in fun declarations
    private int label_no = 0; //after the first call of newLabel() it'll be incremented to 1
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
        //generate code for fun decs
        for (int i = 1; i < ctx.decs.size(); i++) {
            fun_table.put(ctx.decs.get(i).identifier().Idfr().getText(), ctx.decs.get(i));
        }
        for (int i = 1; i < ctx.decs.size(); i++) {
            visit(ctx.decs.get(i));
        }
        //hop to main
        code_list.add("main_label: ");
        current_f = ctx.decs.get(0);
        visit(ctx.decs.get(0).block());
        for (int i = 0; i < Macro.values().length; i++) code += Macro.values()[i].instructions; // put the macros
        for (int i = 0; i < code_list.size(); i++) code += code_list.get(i) + "\n"; // concat the instrs
        return code;    // return code
    }

    @Override
    public String visitDec(SExpressionsParser.DecContext ctx) {
        current_f = ctx;
        code_list.add(ctx.identifier().Idfr().getText() + "_label:");// create label for the control link
            //the "Label" is added to avoid situation where someone defined function with name e.g. label_1
        visit(ctx.block());
        code_list.add("ret");
        return "";
    }

    @Override
    public String visitFunInvocExpr(SExpressionsParser.FunInvocExprContext ctx) {
        //activation record
        SExpressionsParser.DecContext previous = current_f; // needed to calc arg - FP offset
        current_f = fun_table.get(ctx.identifier().Idfr().getText());
		code_list.add("sw   ra, 0(sp)"); //<-- 4(sp)'old // push caller's ret address/space for ret val
        code_list.add("addi sp, sp, -4");
        code_list.add("sw   sp, 0(sp)"); //<-- 4(FP)  // push the current SP
		code_list.add("addi sp, sp, -4");
        code_list.add("sw   fp, 0(sp)"); //<--FP    //push caller's FP
        code_list.add("addi sp, sp, -4");

        //push the arguments
        visit(ctx.block());
        code_list.add("mv  fp,  sp");       //set new FP (current SP - no of args*4 +4)
        code_list.add("addi fp, fp, " + (current_f.params.size()*(4)+4));
        // no variables can be declared except function parameters so no local vars

        code_list.add("jal " +  ctx.identifier().Idfr().getText() + "_label"); // control link

        current_f=previous;
        code_list.add("lw   sp, 4(fp)");    //restore SP
        code_list.add("lw   ra, 4(sp)");    //restore caller's ra
        code_list.add("sw   a0, 4(sp)");    //push the ret val (for 'unit' type it'll be just garbage)
        code_list.add("lw   fp, 0(fp)");    //restore caller's FP
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
        int offset = 0;     //then calc the offset from the FP
        for (int i = 0; i < current_f.params.size(); i++) {
            if(ctx.identifier().Idfr().getText().equals(current_f.params.get(i).identifier().Idfr().getText()))
                offset = (-4*i)-4;
        }
        //and then pop the value that is to be assigned and update the variable
        code_list.add(Macro.Pop.name() + " a0");
        code_list.add("sw a0, " + offset + "(fp)");
        return "";
    }

    @Override
    public String visitBlockExpr(SExpressionsParser.BlockExprContext ctx) {
        visit(ctx.block());
        return "";
    }

    @Override
    public String visitIdExpr(SExpressionsParser.IdExprContext ctx) {
        int offset = 0; // similar to AsgmtExp except we get a "copy" of the variable
        for (int i = 0; i < current_f.params.size(); i++) {     // and push it onto stack
            if(ctx.identifier().Idfr().getText().equals(current_f.params.get(i).identifier().Idfr().getText()))
            offset = (-4*i)-4;
        }
        code_list.add("lw a0, "+ offset +"(fp)");
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
