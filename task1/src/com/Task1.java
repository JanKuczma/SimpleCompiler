package com;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Task1 {
    public static void main(String[] args) throws Exception {
        // create a CharStream that reads from standard input
        CharStream input = CharStreams.fromStream(System.in);
        // create a lexer that feeds off of input CharStream
        MyGrammar3Lexer lexer = new MyGrammar3Lexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        MyGrammParser parser = new MyGrammParser(tokens);
        ParseTree tree = parser.prog(); // begin parsing at prog rule
        Converter converter = new Converter();
        System.out.println(G5035_S_Expression_PrettyPrinter.prettyPrint(converter.visit(tree)));
    }
}
