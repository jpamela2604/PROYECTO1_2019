package color_fs;
import java_cup.*;
import java_cup.runtime.Symbol;
import color_gxml.ColorT;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+
er_decimal = [0-9]+[.] [0-9]+
er_cadena = ([\"]([^\"])*[\"])|([']([^'])*['])

ComentarioMulti ="/*" ~ "*/" 
Comentario  ="//" [^\n]* [\n]? 
%cupsym f_simb
%class f_lexico
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
"funcion"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}  
"selecciona"            {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}  
"caso"                  {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}  
"defecto"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"detener"               {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"retornar"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"si"                    {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"sino"                  {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"importar"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"imprimir"              {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"var"                   {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"verdadero"             {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"falso"                 {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
"nulo"                  {colorear.reservada(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.reservada,yyline,yycolumn,new String(yytext()));}
","                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"&&"                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"||"                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"!"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"+="			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"*="			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"-="			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"/="			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"--"			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"++"			{colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"=="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
">="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"<="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"!="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
">"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"<"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"+"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"-"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"*"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"^"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"/"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"{"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"}"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
":"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
";"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"."                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"?"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"("                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
")"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"["                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"]"                     {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
"="                    {colorear.simbolo(contador,contador+yylength());contador=contador+yylength();return new Symbol(f_simb.menor,yyline,yycolumn,new String(yytext()));}
{er_entero}             {colorear.numero(contador,contador+yylength());contador=contador+yylength();}
{er_decimal}             {colorear.numero(contador,contador+yylength());contador=contador+yylength();}
{er_id}                 {colorear.otro(contador,contador+yylength());contador=contador+yylength();}
{er_cadena}             {colorear.cadena(contador,contador+yylength());contador=contador+yylength();}
{ComentarioMulti}       {colorear.comentario(contador,contador+yylength());contador=contador+yylength();/*System.out.println("comentario multi");*/}
{Comentario}            {colorear.comentario(contador,contador+yylength());contador=contador+yylength();/*System.out.println("comentario multi");*/}
[ \t\r\f\n]+            {contador=contador+yylength();}
.                       {      
                            {colorear.otro(contador,contador+yylength());contador=contador+yylength();} 
                        }
}
