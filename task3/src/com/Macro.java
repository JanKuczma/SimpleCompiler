package com;

import java.util.ArrayList;

public enum Macro {
    // simply push integer val
    PushImm("""
            .macro PushImm ($number)
            li a0, $number
            sw a0, (sp)
            addi sp, sp, -4
            .end_macro
            """),
    //pop to chosen reg
    Pop("""
            .macro Pop %reg
            lw %reg, 4(sp)
            addi sp, sp, 4
            .end_macro
            """),
    //push from reg a0
    Push("""
            .macro Push %reg
            sw %reg, (sp)
            addi sp, sp, -4
            .end_macro
            """),
    //the following macros pop two items from the stack
    //perform bin operation on them and push the result
    Plus("""
            .macro PlusMacro
            Pop t1
            Pop a0
            add a0, a0, t1
            Push a0
            .end_macro
            """),
    Minus("""
            .macro MinusMacro
            Pop t1
            Pop a0
            sub a0, a0, t1
            Push a0
            .end_macro
            """),
    Div("""
            .macro DivMacro
            Pop t1
            Pop a0
            div a0, a0, t1
            Push a0
            .end_macro
            """),
    Times("""
            .macro TimesMacro
            Pop t1
            Pop a0
            mul a0, a0, t1
            Push a0
            .end_macro
            """),
    //conventionally False = 0, True = 1
    Gtr("""
            .macro GtrMacro
            Pop t1
            Pop a0
            sgt a0, a0, t1
            Push a0
            .end_macro
            """),
    Less("""
            .macro LessMacro
            Pop t1
            Pop a0
            slt a0, a0, t1
            Push a0
            .end_macro
            """),
    Eq("""
            .macro EqMacro
            Pop t1
            Pop a0
            sub t1, a0, t1
            seqz a0, t1
            Push a0
            .end_macro
            """),
    // the following two macros sub one val from second val
                                // (or other way around)
    // and check if the difference is GreaTeR OR EQual zero
    GtrEq("""
            .macro GtrEqMacro
            Pop t1
            Pop a0
            sub t1, a0, t1
            sgtz a0, t1
            seqz t1, t1
            or a0, t1, a0
            Push a0
            .end_macro
            """),
    LessEq("""
            .macro LessEqMacro
            Pop t1
            Pop a0
            sub t1, t1, a0
            sgtz a0, t1
            seqz t1, t1
            or a0, t1, a0
            Push a0
            .end_macro
            """),
    And("""
            .macro AndMacro
            Pop t1
            Pop a0
            and a0, a0, t1
            Push a0
            .end_macro
            """),
    Or("""
            .macro OrMacro
            Pop t1
            Pop a0
            or a0, a0, t1
            Push a0
            .end_macro
            """),
    Xor("""
            .macro XorMacro
            Pop t1
            Pop a0
            xor a0, a0, t1
            Push a0
            .end_macro
            """),
    // branch to specified label's address
    // if popped val is greater than zero (True)
    Jump("""
            .macro JumpMacro %label
            lw a0, 4(sp)
            addi sp, sp, 4
            bgtz a0, %label
            .end_macro
            """);

    final String instructions;
    Macro(String instructions) {
        this.instructions = instructions;
    }
}
