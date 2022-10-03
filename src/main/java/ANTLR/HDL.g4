grammar HDL;

start : e1 = cmd* EOF;

/*
expr : x = IDENTIFIER             #Variable
     | c = CONST                  #Constant
     | '!' e1 = expr              #NOT
     | e1 = expr '&&' e2 = expr   #AND
     | e1 = expr '||' e2 = expr   #OR
     | '(' e1 = expr ')'          #Parentheses


     | e1 = expr '->' e2 = expr   #Instantiate
     | IDENTIFIER '=' e1 = expr   #Assign
     | '.hardware' IDENTIFIER     #Hardware
     | '.inputs' IDENTIFIER       #Inputs
     | '.outputs' IDENTIFIER      #Outputs
     | '.latch' e1 = expr         #Latch
     | '.update'                  #Update
     | '.simulate'                #Simulate
     ;
     */

boolexpr : '!' e1 = boolexpr                                  #NOT
         | e1 = boolexpr '&&' e2 = boolexpr                       #AND
         | e1 = boolexpr '||' e2 = boolexpr                       #OR
         | '(' e1 = boolexpr ')'                              #Parentheses
         | c=CONST		     	   # Constant
         | x=IDENTIFIER	     	   # Variable
         ;

expr : e1 = IDENTIFIER '=' e2 = boolexpr+ #Assignment
     ;

identifiers : e1 = IDENTIFIER rest = identifiers #Sequence
            |                                    #NOP
            ;

cmd :        '.hardware' IDENTIFIER                         #Hardware
           | '.latch' e1 = IDENTIFIER '->' e2 = IDENTIFIER  #Latch
           | '.inputs' e1 = identifiers                     #Inputs
           | '.outputs' e1 = identifiers                    #Outputs
           | '.update' (expr)+                              #Update
           | '.simulate' (expr)+   #Simulate
           ;

IDENTIFIER : [a-zA-Z_] [a-zA-Z0-9_]*;
CONST : [0-1]+;

WHITESPACE : [ \t\n\r]+ -> skip ;
COMMENT : '//' ~[\n]* -> skip ;
MULTILINECOMMENT :  '/*'  ( '*'~[/] | ~[*]  )* '*/' -> skip;

