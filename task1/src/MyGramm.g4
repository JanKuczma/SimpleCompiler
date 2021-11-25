grammar MyGramm;

//parser
prog :	dec+ ;
dec :	type=(IntType | BoolType | UnitType) Idfr LParen vardec RParen block #FunDecl;
vardec : (vardecne (Comma vardecne)*)?;
vardecne : type=(IntType | BoolType | UnitType) Idfr;
block :	LBrace exp (Semicolon exp)* RBrace;
exp :	Idfr ':=' exp # Asgmt
    |	LParen exp binop=('=='|'<'|'<='|'>'|'>='|'+'|'-'|'*'|'/'|'&&'|'||'|'^^') exp RParen # BinOpExp
    |	Idfr LParen args RParen # FunInvoc
    |	block # BlockLabel
    |	If exp Then block Else block # IfStmt
    |	While exp Do block #WhileLoop
    |	Repeat block Until exp #RepeatLoop
    |	Skip #SkipExp
    |	IntLit #Num
    |   Idfr #Var;
args : (exp (Comma exp)*)?;

//lexer
LParen : '(';
RParen : ')';
LBrace: '{';
RBrace: '}';
Comma : ',';
Colon : ':';
Semicolon: ';';
While : 'while';
Do    : 'do';
Repeat: 'repeat';
Until : 'until';
If    : 'if';
Then  : 'then';
Else  : 'else';
Assign : ':=';
Eq    :	'==';
Less  : '<';
LessEq:  '<=';
Gtr   : '>';
GtrEq : '>=';
Plus  : '+';
Minus : '-';
Times : '*';
Div   : '/';
And   : '&&';
Or    : '||';
Xor   : '^^';
IntType : 'int';
BoolType : 'bool';
UnitType: 'unit';
Skip: 'skip';
Idfr: [a-z][A-Za-z0-9_]*;
IntLit: '0' | [1-9][0-9]*;
WL: [ \n\r\t]+ -> skip ;