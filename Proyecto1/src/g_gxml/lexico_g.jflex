package g_gxml;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

//er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+
er_cadena = [\"]([^\"])*[\"]
call = [{]([^}])*[}]
ComentarioMulti ="#$" ~ "$#" 
Comentario  ="##" [^\n]* [\n]
%cupsym simb
%class lexico_g
%cup
%public
%line
%column
%ignorecase
%state TODO,COMENTARIO,AUXILIAR,LINEA
%{
String todo;
    public mng_error e = new mng_error();
Boolean estoyTodo=true;
%}

%%
<YYINITIAL>{
"Verdadero"             {/*System.out.println("verdadero ");*/return new Symbol(simb.verdadero,yyline,yycolumn,new String(yytext()));}
"Falso"                 {/*System.out.println("falso ");*/return new Symbol(simb.falso,yyline,yycolumn,new String(yytext()));}
"<Texto"                {/*System.out.println("texto i ");*/return new Symbol(simb.i_texto,yyline,yycolumn,new String(yytext()));}
"<Importar"             {/*System.out.println("importar i ");*/return new Symbol(simb.i_imp,yyline,yycolumn,new String(yytext()));}
"<Ventana"              {/*System.out.println("ventana i ");*/estoyTodo=false;return new Symbol(simb.i_ven,yyline,yycolumn,new String(yytext()));}
"</Ventana"             {/*System.out.println("ventana f ");*/estoyTodo=false;return new Symbol(simb.f_ven,yyline,yycolumn,new String(yytext()));}
"<boton"                {/*System.out.println("boton i ");*/return new Symbol(simb.i_boton,yyline,yycolumn,new String(yytext()));}
"<enviar"               {/*System.out.println("enviar i ");*/return new Symbol(simb.i_enviar,yyline,yycolumn,new String(yytext()));}
"<contenedor"           {/*System.out.println("contenedor i ");*/estoyTodo=false;return new Symbol(simb.i_contenedor,yyline,yycolumn,new String(yytext()));}
"</contenedor"          {/*System.out.println("contenedor f ");*/estoyTodo=false;return new Symbol(simb.f_contenedor,yyline,yycolumn,new String(yytext()));}
"<Control"              {/*System.out.println("ctrl i ");*/estoyTodo=false;return new Symbol(simb.i_control,yyline,yycolumn,new String(yytext()));}
"</Control"             {/*System.out.println("ctrl f ");*/estoyTodo=false;return new Symbol(simb.f_control,yyline,yycolumn,new String(yytext()));}
"<Defecto"              {/*System.out.println("dfec i ");*/return new Symbol(simb.i_defecto,yyline,yycolumn,new String(yytext()));}
"<ListaDatos"           {/*System.out.println("lidatos i ");*/estoyTodo=false;return new Symbol(simb.i_lista,yyline,yycolumn,new String(yytext()));}
"</ListaDatos"          {/*System.out.println("lidatos f ");*/estoyTodo=false;return new Symbol(simb.f_lista,yyline,yycolumn,new String(yytext()));}
"<multimedia"           {/*System.out.println("multi i ");*/estoyTodo=false;return new Symbol(simb.i_multi,yyline,yycolumn,new String(yytext()));}
"</multimedia"          {/*System.out.println("multi f ");*/estoyTodo=false;return new Symbol(simb.f_multi,yyline,yycolumn,new String(yytext()));}
"<Dato"                 {/*System.out.println("dato i ");*/return new Symbol(simb.i_dato,yyline,yycolumn,new String(yytext()));}
"Accion"                {/*System.out.println("accion ");*/return new Symbol(simb.accion,yyline,yycolumn,new String(yytext()));}
"Referencia"            {/*System.out.println("ref ");*/return new Symbol(simb.referencia,yyline,yycolumn,new String(yytext()));}
"Id"                    {/*System.out.println("id ");*/return new Symbol(simb.id,yyline,yycolumn,new String(yytext()));}
"Tipo"                  {/*System.out.println("tipo ");*/return new Symbol(simb.tipo,yyline,yycolumn,new String(yytext()));}
"Color"                 {/*System.out.println("color ");*/return new Symbol(simb.color,yyline,yycolumn,new String(yytext()));}
"AccionInicial"         {/*System.out.println("accion inicial");*/return new Symbol(simb.ac_in,yyline,yycolumn,new String(yytext()));}
"AccionFinal"           {/*System.out.println("accion final");*/return new Symbol(simb.ac_fi,yyline,yycolumn,new String(yytext()));}
"Nombre"                {/*System.out.println("nombre ");*/return new Symbol(simb.nombre,yyline,yycolumn,new String(yytext()));}
"X"                     {/*System.out.println("x ");*/return new Symbol(simb.x,yyline,yycolumn,new String(yytext()));}
"Y"                     {/*System.out.println("y ");*/return new Symbol(simb.y,yyline,yycolumn,new String(yytext()));}
"Alto"                  {/*System.out.println("alto ");*/return new Symbol(simb.alto,yyline,yycolumn,new String(yytext()));}
"Ancho"                 {/*System.out.println("ancho ");*/return new Symbol(simb.ancho,yyline,yycolumn,new String(yytext()));}
"Fuente"                {/*System.out.println("fuente ");*/return new Symbol(simb.fuente,yyline,yycolumn,new String(yytext()));}
"borde"                {/*System.out.println("borde ");*/return new Symbol(simb.borde,yyline,yycolumn,new String(yytext()));}

"Tam"                   {/*System.out.println("tam ");*/return new Symbol(simb.tam,yyline,yycolumn,new String(yytext()));}
"Negrita"               {/*System.out.println("negrita ");*/return new Symbol(simb.negrita,yyline,yycolumn,new String(yytext()));}
"Cursiva"               {/*System.out.println("cursiva ");*/return new Symbol(simb.cursiva,yyline,yycolumn,new String(yytext()));}
"Maximo"                {/*System.out.println("maximo ");*/return new Symbol(simb.maximo,yyline,yycolumn,new String(yytext()));}
"Minimo"                {/*System.out.println("minimo ");*/return new Symbol(simb.minimo,yyline,yycolumn,new String(yytext()));}
"Auto-Reproduccion"     {/*System.out.println("auto ");*/return new Symbol(simb.autoplay,yyline,yycolumn,new String(yytext()));}
"Path"                  {/*System.out.println("path ");*/return new Symbol(simb.path,yyline,yycolumn,new String(yytext()));}
">"                     {if(estoyTodo){/*System.out.println("empieza todo ");*/todo="";yybegin(TODO);}else{/*System.out.println("> ");*/estoyTodo=true;return new Symbol(simb.mayor,yyline,yycolumn,new String(yytext()));}}
"="                     {/*System.out.println("= ");*/return new Symbol(simb.is,yyline,yycolumn,new String(yytext()));}
{er_entero}             {/*System.out.println("entero: "+yytext());*/return new Symbol(simb.er_entero,yyline,yycolumn,new String(yytext()));}
{er_cadena}             {/*System.out.println("cadena: "+yytext());*/return new Symbol(simb.er_cadena,yyline,yycolumn,new String(yytext().substring(1, yytext().length()-1).trim()));}
{call}                  {/*System.out.println("llamada: "+yytext());*/return new Symbol(simb.call,yyline,yycolumn,new String(yytext().substring(1, yytext().length()-1).trim()));}
{ComentarioMulti}       {/*System.out.println("comentario multi");*/}
{Comentario}            {/*System.out.println("comentario");*/}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}


<TODO>
{
    
    "##"    {yybegin(LINEA); } 
    "#$"    {yybegin(COMENTARIO); }
    "<"     {/*System.out.println("fin de todi ");*/yypushback(1); yybegin(AUXILIAR);/*System.out.println("fin de todo: "+todo);*/return new Symbol(simb.all,yyline,yycolumn,todo.trim());}
    [^]     {/*System.out.println("mas: "+yytext());*/ todo=todo+yytext();}
    
}
<LINEA>
{
    [^\n] {/*System.out.println("dentro de comentario: "+yytext());*/}
    [\n] {/*System.out.println("comentario");*/yybegin(TODO);}
}
<COMENTARIO>
{
    [^"$#"]  {/*System.out.println("dentro de comentario: "+yytext());*/}
    "$#" {/*System.out.println("comentario multi");*/yybegin(TODO);}
}

<AUXILIAR> "</Importar"            {/*System.out.println("imp f ");*/return new Symbol(simb.f_imp,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> "</Texto"               {/*System.out.println("txt f ");*/return new Symbol(simb.f_texto,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> "</Dato"                {/*System.out.println("dat f ");*/return new Symbol(simb.f_dato,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> "</Defecto"             {/*System.out.println("def f ");*/return new Symbol(simb.f_defecto,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> "</boton"               {/*System.out.println("bot f ");*/return new Symbol(simb.f_boton,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> "</enviar"              {/*System.out.println("emviar f ");*/return new Symbol(simb.f_enviar,yyline,yycolumn,new String(yytext()));}
<AUXILIAR> ">"            {/*System.out.println("regresa al inicio");*/yybegin(YYINITIAL);}
<AUXILIAR> {ComentarioMulti}       {/*System.out.println("comentario multi");*/}
<AUXILIAR> {Comentario}            {/*System.out.println("comentario");*/}
<AUXILIAR> [ \t\r\f\n]+            {}