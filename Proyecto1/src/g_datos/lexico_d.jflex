package g_datos;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_cadena = [\"]([^\"])*[\"]
er_entero = [0-9]+
er_decimal = [0-9]+[.] [0-9]+
ComentarioMulti ="#$" ~ "$#" 
Comentario  ="##" [^\n]* [\n]
%cupsym simbolo
%class lexico_d
%cup
%public
%line
%column
%ignorecase

%{
String todo;
    public mng_error e = new mng_error();
    Boolean estoyTodo=true;
%}

%% 

<YYINITIAL>
{

"tipo"                  {return new Symbol(simbolo.tipo,yyline,yycolumn,new String(yytext()));}
"="                     {return new Symbol(simbolo.is,yyline,yycolumn,new String(yytext()));}
"<principal"            {estoyTodo=false;return new Symbol(simbolo.i_prin,yyline,yycolumn,new String(yytext()));}
"</principal"           {estoyTodo=false;return new Symbol(simbolo.f_prin,yyline,yycolumn,new String(yytext()));}
"</lista"               {estoyTodo=false;return new Symbol(simbolo.f_lista,yyline,yycolumn,new String(yytext()));}
"<lista"                {estoyTodo=false;return new Symbol(simbolo.i_lista,yyline,yycolumn,new String(yytext()));}
"<"                     {/*System.out.println("<");*/return new Symbol(simbolo.menor,yyline,yycolumn,new String(yytext()));}
">"                     {/*if(estoyTodo){todo="";yybegin(TODO);}else{estoyTodo=true;*/return new Symbol(simbolo.mayor,yyline,yycolumn,new String(yytext()));/*}*/}
"/"                     {return new Symbol(simbolo.slash,yyline,yycolumn,new String(yytext()));}
{er_entero}             {return new Symbol(simbolo.er_entero,yyline,yycolumn,new String(yytext()));}
{er_decimal}             {return new Symbol(simbolo.er_decimal,yyline,yycolumn,new String(yytext()));}
{er_cadena}             {/*System.out.println("cadena: "+yytext());*/return new Symbol(simbolo.er_cadena,yyline,yycolumn,new String(yytext()));}
{er_id}                 {/*System.out.println("id: "+yytext());*/return new Symbol(simbolo.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
{ComentarioMulti}       {/*System.out.println("comentario multi");*/}
{Comentario}            {/*System.out.println("comentario");*/}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;
//System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}