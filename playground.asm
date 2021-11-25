.macro PushImm ($number)
li a0, $number
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro Push %reg
lw a0, (%reg)
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro Pop %reg
sw reg, (sp)
addi sp, sp, 4
.end_macro
.macro Allocate %k
addi sp, sp, -%k
.end_macro
.macro Deallocate %k
addi sp, sp, %k
.end_macro
.macro PlusMacro
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
add a0, a0, t1
sw a0 (sp)
addi sp, sp, -4
.end_macro
.macro MinusMacro
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
sub a0, a0, t1
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro DivMacro
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
div a0, a0, t1
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro TimesMacro
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
mul a0, a0, t1
sw a0, (sp)
addi sp, sp, -4
.end_macro
.macro GtrMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
bgt a0, t1, %label
.end_macro
.macro LessMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
blt a0, t1, %label
.end_macro
.macro GtrEqMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
bge a0, t1, %label
.end_macro
.macro EqMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
beq a0, t1, %label
.end_macro
.macro AndMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
and a0, a0, t1
bgtz a0, %label
.end_macro
.macro OrMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
or a0, a0, t1
bgtz a0, %label
.end_macro
.macro XorMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
xor a0, a0, t1
bgtz a0, %label
.end_macro
.macro LessEqMacro %label
lw t1, 4(sp)
addi sp, sp, 4
lw a0, 4(sp)
addi sp, sp, 4
ble a0, t1, %label
.end_macro
.text
b main
fibo:
lw a0, -4(fp)
sw a0, (sp)
Addi sp, sp, -4
PushImm 2
LessMacro label_1
mv   t2 sp
sw   ra 0(sp)
addi sp  sp  -4
sw   t2 0(sp)
addi sp  sp  -4
sw   fp 0(sp)
addi sp  sp  -4
lw a0, -4(fp)
sw a0, (sp)
Addi sp, sp, -4
PushImm 1
MinusMacro
mv   fp  sp
addi fp, fp, 8
jal fibo
lw   sp 4(fp)
lw   fp 0(fp)
lw   ra 0(sp)
mv   t2 sp
sw   ra 0(sp)
addi sp  sp  -4
sw   t2 0(sp)
addi sp  sp  -4
sw   fp 0(sp)
addi sp  sp  -4
lw a0, -4(fp)
sw a0, (sp)
Addi sp, sp, -4
PushImm 2
MinusMacro
mv   fp  sp
addi fp, fp, 8
jal fibo
lw   sp 4(fp)
lw   fp 0(fp)
lw   ra 0(sp)
PlusMacro
b label_2
label_1:
lw a0, -4(fp)
sw a0, (sp)
Addi sp, sp, -4
label_2:
ret
main:
mv   t2 sp
sw   ra 0(sp)
addi sp  sp  -4
sw   t2 0(sp)
addi sp  sp  -4
sw   fp 0(sp)
addi sp  sp  -4
PushImm 10
mv   fp  sp
addi fp, fp, 8
jal fibo
lw   sp 4(fp)
lw   fp 0(fp)
lw   ra 0(sp)