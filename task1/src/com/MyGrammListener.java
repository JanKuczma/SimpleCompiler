package com;// Generated from C:/Users/jmuzy/OneDrive - University of Sussex/Year 2/Compilers&CA/215748/task1/src\MyGramm.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammParser}.
 */
public interface MyGrammListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MyGrammParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MyGrammParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link MyGrammParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDecl(MyGrammParser.FunDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunDecl}
	 * labeled alternative in {@link MyGrammParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDecl(MyGrammParser.FunDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(MyGrammParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(MyGrammParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void enterVardecne(MyGrammParser.VardecneContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammParser#vardecne}.
	 * @param ctx the parse tree
	 */
	void exitVardecne(MyGrammParser.VardecneContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MyGrammParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MyGrammParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterAsgmt(MyGrammParser.AsgmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Asgmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitAsgmt(MyGrammParser.AsgmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinOpExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinOpExp(MyGrammParser.BinOpExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinOpExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinOpExp(MyGrammParser.BinOpExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFunInvoc(MyGrammParser.FunInvocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunInvoc}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFunInvoc(MyGrammParser.FunInvocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockLabel}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBlockLabel(MyGrammParser.BlockLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockLabel}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBlockLabel(MyGrammParser.BlockLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MyGrammParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MyGrammParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MyGrammParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MyGrammParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterRepeatLoop(MyGrammParser.RepeatLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RepeatLoop}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitRepeatLoop(MyGrammParser.RepeatLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSkipExp(MyGrammParser.SkipExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SkipExp}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSkipExp(MyGrammParser.SkipExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Num}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNum(MyGrammParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNum(MyGrammParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVar(MyGrammParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MyGrammParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVar(MyGrammParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MyGrammParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MyGrammParser.ArgsContext ctx);
}