package g_gxml;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+
er_cadena = [\"]([^\"])*[\"]
call = [{]([^}])*[}]
%cupsym simb
%class lexico_g
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
"Verdadero"             {return new Symbol(simb.verdadero,yyline,yycolumn,new String(yytext()));}
"Falso"                 {return new Symbol(simb.falso,yyline,yycolumn,new String(yytext()));}
"all"                   {return new Symbol(simb.all,yyline,yycolumn,new String(yytext()));}
"<Importar"             {return new Symbol(simb.i_imp,yyline,yycolumn,new String(yytext()));}
"</Importar"            {return new Symbol(simb.f_imp,yyline,yycolumn,new String(yytext()));}
"<Ventana"              {return new Symbol(simb.i_ven,yyline,yycolumn,new String(yytext()));}
"</Ventana"             {return new Symbol(simb.f_ven,yyline,yycolumn,new String(yytext()));}
"<Control"              {return new Symbol(simb.i_control,yyline,yycolumn,new String(yytext()));}
"</Control"             {return new Symbol(simb.f_control,yyline,yycolumn,new String(yytext()));}
"<Defecto"              {return new Symbol(simb.i_defecto,yyline,yycolumn,new String(yytext()));}
"</Defecto"             {return new Symbol(simb.f_defecto,yyline,yycolumn,new String(yytext()));}
"<ListaDatos"           {return new Symbol(simb.i_lista,yyline,yycolumn,new String(yytext()));}
"</ListaDatos"          {return new Symbol(simb.f_lista,yyline,yycolumn,new String(yytext()));}
"<Dato"                 {return new Symbol(simb.i_dato,yyline,yycolumn,new String(yytext()));}
"</Dato"                {return new Symbol(simb.f_dato,yyline,yycolumn,new String(yytext()));}
"Accion"                {return new Symbol(simb.accion,yyline,yycolumn,new String(yytext()));}
"Referencia"            {return new Symbol(simb.referencia,yyline,yycolumn,new String(yytext()));}
"Id"                    {return new Symbol(simb.id,yyline,yycolumn,new String(yytext()));}
"Tipo"                  {return new Symbol(simb.tipo,yyline,yycolumn,new String(yytext()));}
"Color"                 {return new Symbol(simb.color,yyline,yycolumn,new String(yytext()));}
"AccionInicial"         {return new Symbol(simb.ac_in,yyline,yycolumn,new String(yytext()));}
"AccionFinal"           {return new Symbol(simb.ac_fi,yyline,yycolumn,new String(yytext()));}
"Nombre"                {return new Symbol(simb.nombre,yyline,yycolumn,new String(yytext()));}
"X"                     {return new Symbol(simb.x,yyline,yycolumn,new String(yytext()));}
"Y"                     {return new Symbol(simb.y,yyline,yycolumn,new String(yytext()));}
"Alto"                  {return new Symbol(simb.alto,yyline,yycolumn,new String(yytext()));}
"Ancho"                 {return new Symbol(simb.ancho,yyline,yycolumn,new String(yytext()));}
"Fuente"                {return new Symbol(simb.fuente,yyline,yycolumn,new String(yytext()));}
"Tam"                   {return new Symbol(simb.tam,yyline,yycolumn,new String(yytext()));}
"Negrita"               {return new Symbol(simb.negrita,yyline,yycolumn,new String(yytext()));}
"Cursiva"               {return new Symbol(simb.cursiva,yyline,yycolumn,new String(yytext()));}
"Maximo"                {return new Symbol(simb.maximo,yyline,yycolumn,new String(yytext()));}
"Minimo"                {return new Symbol(simb.minimo,yyline,yycolumn,new String(yytext()));}
"Auto-Reproduccion"     {return new Symbol(simb.autoplay,yyline,yycolumn,new String(yytext()));}
"Path"                  {return new Symbol(simb.path,yyline,yycolumn,new String(yytext()));}
">"                     {return new Symbol(simb.mayor,yyline,yycolumn,new String(yytext()));}
"="                     {return new Symbol(simb.is,yyline,yycolumn,new String(yytext()));}
"ID"                    {return new Symbol(simb.id,yyline,yycolumn,new String(yytext()));}
{er_entero}             {return new Symbol(simb.er_entero,yyline,yycolumn,new String(yytext()));}
{er_cadena}             {return new Symbol(simb.er_cadena,yyline,yycolumn,new String(yytext().substring(1, yytext().length()-1)));}
{call}                  {return new Symbol(simb.call,yyline,yycolumn,new String(yytext()));}
{er_id}                 {return new Symbol(simb.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}