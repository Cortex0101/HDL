grammar HDL;

start : e1 = expr* EOF;

expr : x = IDENTIFIER             #Variable
     | c = CONST                  #Constant
     | '!' e1 = expr              #NOT
     | e1 = expr '&&' e2 = expr   #AND
     | e1 = expr '||' e2 = expr   #OR
     | e1 = expr '->' e2 = expr   #Instantiate
     | IDENTIFIER '=' e1 = expr   #Assign
     | '(' e1 = expr ')'          #Parentheses
     | '.hardware' IDENTIFIER     #CMDHardware
     | '.inputs' IDENTIFIER       #CMDInputs
     | '.outputs' IDENTIFIER      #CMDOutputs
     | '.latch' e1 = expr         #CMDLatch
     | '.update'                  #CMDUpdate
     | '.simulate'                #CMDSimulate
     ;

IDENTIFIER : [a-zA-Z_] [a-zA-Z0-9_]*;
CONST : [0-1]+;

WHITESPACE : [ \t\n\r]+ -> skip ;
COMMENT : '//' ~[\n]* -> skip ;
MULTILINECOMMENT :  '/*'  ( '*'~[/] | ~[*]  )* '*/' -> skip;

