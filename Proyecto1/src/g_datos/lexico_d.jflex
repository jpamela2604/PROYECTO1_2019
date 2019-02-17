package g_datos;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+

%cupsym simbolo
%class lexico_d
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
"ID"                    {return new Symbol(simbolo.id,yyline,yycolumn,new String(yytext()));}
{er_entero}             {return new Symbol(simbolo.er_entero,yyline,yycolumn,new String(yytext()));}
{er_id}                 {return new Symbol(simbolo.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}
