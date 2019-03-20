package color_gxml;
import java_cup.*;
import java_cup.runtime.Symbol;
%%

//er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+
er_cadena = [\"]([^\"])*[\"]
call = [{]([^}])*[}]
ComentarioMulti ="#$" ~ "$#" 
Comentario  ="##" [^\n]* [\n]
%cupsym g_simb
%class g_lexico
%cup
%public
%line
%column
%ignorecase
%{
    public ColorT colorear=new ColorT();
    int contador=0;
%}

%%
<YYINITIAL>{
"<"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.menor,yyline,yycolumn,new String(yytext()));}
">"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.menor,yyline,yycolumn,new String(yytext()));}
"Verdadero"             {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}  
"Falso"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));} 
"Texto"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Importar"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Ventana"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"boton"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}   
"enviar"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"contenedor"            {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Control"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Defecto"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"ListaDatos"           {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"multimedia"            {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"/"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.menor,yyline,yycolumn,new String(yytext()));}
"Dato"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Accion"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Referencia"            {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Id"                    {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Tipo"                  {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Color"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"AccionInicial"         {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"AccionFinal"           {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Nombre"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"X"                     {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Y"                     {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Alto"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Ancho"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Fuente"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"borde"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Tam"                   {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Negrita"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Cursiva"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Maximo"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Minimo"                {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Auto-Reproduccion"    {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"Path"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.reservada,yyline,yycolumn,new String(yytext()));}
"="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(g_simb.menor,yyline,yycolumn,new String(yytext()));}
{er_entero}            {colorear.numero(contador,contador+yylength());contador=contador+yylength();}
{er_cadena}             {colorear.cadena(contador,contador+yylength());contador=contador+yylength();}
{call}                  {colorear.llamada(contador,contador+yylength());contador=contador+yylength();}
{ComentarioMulti}       {colorear.comentario(contador,contador+yylength());contador=contador+yylength();/*System.out.println("comentario multi");*/}
{Comentario}            {colorear.comentario(contador,contador+yylength());contador=contador+yylength();/*System.out.println("comentario");*/}
[ \t\r\f\n]+            {contador=contador+yylength();}
.                       { 
                            colorear.otro(contador,contador+yylength());contador=contador+yylength();
                            
                        }
}



