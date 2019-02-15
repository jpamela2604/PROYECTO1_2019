package g_fs;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+

%cupsym symbl
%class lexico_fs
%cup
%public
%line
%column
%ignorecase
%{
    public mng_error e = new mng_error();
%}

%%
<YYINITIAL>{
"ID"                    {return new Symbol(symbl.id,yyline,yycolumn,new String(yytext()));}
{er_entero}             {return new Symbol(symbl.er_entero,yyline,yycolumn,new String(yytext()));}
{er_id}                 {return new Symbol(symbl.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}
