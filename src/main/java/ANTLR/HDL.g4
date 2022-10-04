grammar HDL;

start : '.hardware' IDENTIFIER
        '.inputs' e1 += IDENTIFIER+
        '.outputs' e1 += IDENTIFIER+
        larg += latch*
        '.update' aarg += assignment+
        '.simulate' sarg += simulateArgs+
        EOF
        ;

latch : '.latch' e1 = IDENTIFIER '->' e2 = IDENTIFIER;

boolexpr : '!' e1 = boolexpr                                  #NOT
         | e1 = boolexpr '&&' e2 = boolexpr                       #AND
         | e1 = boolexpr '||' e2 = boolexpr                       #OR
         | '(' e1 = boolexpr ')'                              #Parentheses
         | x=IDENTIFIER	     	   # Variable
         ;

assignment : e1 = IDENTIFIER '=' e2 += boolexpr+
            ;

simulateArgs : e1 = IDENTIFIER '=' e2= CONST;

IDENTIFIER : [a-zA-Z_] [a-zA-Z0-9_]*;
CONST : [0-1]+;

WHITESPACE : [ \t\n\r]+ -> skip ;
COMMENT : '//' ~[\n]* -> skip ;
MULTILINECOMMENT :  '/*'  ( '*'~[/] | ~[*]  )* '*/' -> skip;