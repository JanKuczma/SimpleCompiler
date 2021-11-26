.macro PushImm ($number)
li a0, $number
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro Pop %reg
lw %reg, 4(sp)
addi sp, sp, 4
.end_macro
.macro Push %reg
sw %reg, (sp)
addi sp, sp, -4
.end_macro
.macro PlusMacro
Pop t1
Pop a0
add a0, a0, t1
Push a0
.end_macro
.macro MinusMacro
Pop t1
Pop a0
sub a0, a0, t1
Push a0
.end_macro
.macro DivMacro
Pop t1
Pop a0
div a0, a0, t1
Push a0
.end_macro
.macro TimesMacro
Pop t1
Pop a0
mul a0, a0, t1
Push a0
.end_macro
.macro GtrMacro
Pop t1
Pop a0
sgt a0, a0, t1
Push a0
.end_macro
.macro LessMacro
Pop t1
Pop a0
slt a0, a0, t1
Push a0
.end_macro
.macro EqMacro
Pop t1
Pop a0
sub t1, a0, t1
seqz a0, t1
Push a0
.end_macro
.macro GtrEqMacro
Pop t1
Pop a0
sub t1, a0, t1
sgtz a0, t1
seqz t1, t1
or a0, t1, a0
Push a0
.end_macro
.macro LessEqMacro
Pop t1
Pop a0
sub t1, t1, a0
sgtz a0, t1
seqz t1, t1
or a0, t1, a0
Push a0
.end_macro
.macro AndMacro
Pop t1
Pop a0
and a0, a0, t1
Push a0
.end_macro
.macro OrMacro
Pop t1
Pop a0
or a0, a0, t1
Push a0
.end_macro
.macro XorMacro
Pop t1
Pop a0
xor a0, a0, t1
Push a0
.end_macro
.macro JumpMacro %label
lw a0, 4(sp)
addi sp, sp, 4
bgtz a0, %label
.end_macro
.text
b main_label
fun_label:
lw a0, -4(fp) #load arg
Push a0
lw a0, -8(fp) #load arg
Push a0
EqMacro
JumpMacro label_1
PushImm 0
b label_2
label_1:
PushImm 8
PushImm 2
DivMacro
label_2:
ret
main_label:
sw   ra, 0(sp) #AR start
addi sp, sp, -4
sw   sp, 0(sp)
addi sp, sp, -4
sw   fp, 0(sp)
addi sp, sp, -4
PushImm 1
PushImm 1
PushImm 3
mv  fp,  sp
addi fp, fp, 16
jal fun_label #AR finish
lw   sp, 4(fp) #restoring SP
lw   ra, 4(sp) #restoring ra
sw   a0, 4(sp) #store ret val
lw   fp, 0(fp) #restoring FP