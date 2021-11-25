package com;

public class Converter extends MyGrammBaseVisitor<String>{

    //to print 'Idfr("idfr")'
    private String custom_idfr(String idfr){
        return MyGrammParser.VOCABULARY.getSymbolicName(MyGrammParser.Idfr)
                +"(\"" + idfr + "\")";
    }
    //to print 'IntLit(x)'
    private String custom_int(String x){
        return MyGrammParser.VOCABULARY.getSymbolicName(MyGrammParser.IntLit)
                +"(" + x + ")";
    }
    //visit first dec, if more iterate and close with []
    @Override
    public String visitProg(MyGrammParser.ProgContext ctx){
        String fun_list = "[" + visit(ctx.dec(0)) ;
        for (int i = 1; i < ctx.getChildCount(); i++) {
            fun_list += "," + visit(ctx.dec(i));
        }
        return fun_list + "]";
    }
    @Override
    public String visitFunDecl(MyGrammParser.FunDeclContext ctx){
        return "[FunDecl," + custom_idfr(ctx.Idfr().getText()) +","
                + MyGrammParser.VOCABULARY.getSymbolicName(ctx.type.getType())
                +","+ visit(ctx.vardec()) +","+ visit(ctx.block())+"]";
    }

    @Override
    public String visitVardec(MyGrammParser.VardecContext ctx){
        String var_list = "[";
        for (int i = 0; i < ctx.vardecne().size(); i++) {
            var_list += visit(ctx.vardecne(i));
            if(i < ctx.vardecne().size()-1) var_list += ",";
        }
        return var_list + "]";
    }
    @Override
    public String visitVardecne(MyGrammParser.VardecneContext ctx){
        return "[" + custom_idfr(ctx.Idfr().getText())+","
                + MyGrammParser.VOCABULARY.getSymbolicName(ctx.type.getType())+"]";
    }

    @Override
    public String visitBlock(MyGrammParser.BlockContext ctx){
        String exp_list = "["+ visit(ctx.exp(0));
        for (int i = 1; i < ctx.exp().size(); i++) {
            exp_list+= "," + visit(ctx.exp(i));
        }
        return exp_list + "]";
    }

    @Override
    public String visitVar(MyGrammParser.VarContext ctx){

        return custom_idfr(ctx.Idfr().getText());
    }

    @Override
    public String visitNum(MyGrammParser.NumContext ctx){
        return custom_int(ctx.IntLit().getText());
    }

    @Override
    public String visitAsgmt(MyGrammParser.AsgmtContext ctx){
        return "[Asgmt," + custom_idfr(ctx.Idfr().getText())+ "," + visit(ctx.exp()) + "]";
    }

    @Override
    public String visitBinOpExp(MyGrammParser.BinOpExpContext ctx){
        return "[BinOpExpr," + MyGrammParser.VOCABULARY.getSymbolicName(ctx.binop.getType())
                +","+ visit(ctx.exp(0)) +","+ visit(ctx.exp(1)) + "]";
    }

    @Override
    public String visitFunInvoc(MyGrammParser.FunInvocContext ctx){

        return "[FunInvoc," + custom_idfr(ctx.Idfr().getText())
                            + "," + visit(ctx.args()) + "]";
    }

    @Override
    public String visitIfStmt(MyGrammParser.IfStmtContext ctx){
        return "[IfStmt," + visit(ctx.exp()) +","+ visit(ctx.block(0)) +","+ visit(ctx.block(1))+"]";
    }

    @Override
    public String visitWhileLoop(MyGrammParser.WhileLoopContext ctx){
        return "[WhileLoop," + visit(ctx.exp()) +","+ visit(ctx.block()) +"]";
    }

    @Override
    public String visitRepeatLoop(MyGrammParser.RepeatLoopContext ctx){
        return "[RepeatLoop," + visit(ctx.exp()) +","+ visit(ctx.block()) +"]";
    }

    @Override
    public String visitSkipExp(MyGrammParser.SkipExpContext ctx){ return MyGrammParser.VOCABULARY.getSymbolicName(ctx.Skip().getSymbol().getType()); }

    @Override
    public String visitArgs(MyGrammParser.ArgsContext ctx){
        String arg_list = "[";
        for (int i = 0; i < ctx.exp().size(); i++) {
            arg_list += visit(ctx.exp(i));
            if( i < ctx.exp().size()-1) arg_list += ",";
        }
        return arg_list + "]";
    }
    @Override
    public String visitBlockLabel(MyGrammParser.BlockLabelContext ctx){ return visit(ctx.block());}

}
