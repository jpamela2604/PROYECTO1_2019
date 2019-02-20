package g_datos;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_cadena = [\"]([^\"])*[\"]

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
"<principal"            {return new Symbol(simbolo.i_prin,yyline,yycolumn,new String(yytext()));}
"</principal"           {return new Symbol(simbolo.f_prin,yyline,yycolumn,new String(yytext()));}
"</lista"               {return new Symbol(simbolo.f_lista,yyline,yycolumn,new String(yytext()));}
"<lista tipo="          {return new Symbol(simbolo.i_lista,yyline,yycolumn,new String(yytext()));}
"</"                    {return new Symbol(simbolo.inf,yyline,yycolumn,new String(yytext()));}
"<"                     {return new Symbol(simbolo.menor,yyline,yycolumn,new String(yytext()));}
">"                     {return new Symbol(simbolo.mayor,yyline,yycolumn,new String(yytext()));}
"all"                   {return new Symbol(simbolo.all,yyline,yycolumn,new String(yytext()));}
{er_cadena}             {return new Symbol(simbolo.er_cadena,yyline,yycolumn,new String(yytext()));}
{er_id}                 {return new Symbol(simbolo.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}
