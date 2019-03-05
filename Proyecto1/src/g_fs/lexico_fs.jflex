package g_fs;
import java_cup.*;
import java_cup.runtime.Symbol;
import errors.mng_error;
import proyecto1.var;
%%

er_id = [a-zA-Z_][a-zA-Z0-9_]*
er_entero = [0-9]+
er_decimal = [0-9]+[.] [0-9]+
er_cadena = ([\"]([^\"])*[\"])|([']([^'])*['])

ComentarioMulti ="/*" ~ "*/" 
Comentario  ="//" [^\n]* [\n]? 
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
"AlCerrar("            {return new Symbol(symbl.cerrar,yyline,yycolumn,new String(yytext()));}
"AlClic("              {return new Symbol(symbl.clic,yyline,yycolumn,new String(yytext()));}
"CrearVideo("          {return new Symbol(symbl.video,yyline,yycolumn,new String(yytext()));}
"CrearReproductor("    {return new Symbol(symbl.musica,yyline,yycolumn,new String(yytext()));}
"CrearImagen("         {return new Symbol(symbl.imagen,yyline,yycolumn,new String(yytext()));}
"CrearBoton("          {return new Symbol(symbl.boton,yyline,yycolumn,new String(yytext()));}
"CrearDesplegable("    {return new Symbol(symbl.desple,yyline,yycolumn,new String(yytext()));}
"CrearControlNumerico(" {return new Symbol(symbl.controln,yyline,yycolumn,new String(yytext()));}
"CrearAreaTexto("      {return new Symbol(symbl.area,yyline,yycolumn,new String(yytext()));}
"CrearCajaTexto("      {return new Symbol(symbl.caja,yyline,yycolumn,new String(yytext()));}
"CrearTexto("          {return new Symbol(symbl.texto,yyline,yycolumn,new String(yytext()));}
"CrearContenedor("     {return new Symbol(symbl.contenedor,yyline,yycolumn,new String(yytext()));}
"ObtenerPorEtiqueta("  {return new Symbol(symbl.ObtenerPorEtiqueta,yyline,yycolumn,new String(yytext()));}
"ObtenerPorId("        {return new Symbol(symbl.ObtenerPorId,yyline,yycolumn,new String(yytext()));}
"ObtenerPorNombre("    {return new Symbol(symbl.ObtenerPorNombre,yyline,yycolumn,new String(yytext()));}
"LeerGxml("            {return new Symbol(symbl.leerGxml,yyline,yycolumn,new String(yytext()));}
"filter("              {return new Symbol(symbl.filter,yyline,yycolumn,new String(yytext()));}
"map("                 {return new Symbol(symbl.map,yyline,yycolumn,new String(yytext()));}
"AlCargar("            {return new Symbol(symbl.cargar,yyline,yycolumn,new String(yytext()));}
"buscar("              {return new Symbol(symbl.buscar,yyline,yycolumn,new String(yytext()));}
"reduce("              {return new Symbol(symbl.reduce,yyline,yycolumn,new String(yytext()));}
"todos("               {return new Symbol(symbl.todos,yyline,yycolumn,new String(yytext()));}
"alguno("              {return new Symbol(symbl.alguno,yyline,yycolumn,new String(yytext()));}
"maximo()"              {return new Symbol(symbl.maximo,yyline,yycolumn,new String(yytext()));}
"minimo()"              {return new Symbol(symbl.minimo,yyline,yycolumn,new String(yytext()));}
"invertir()"           {return new Symbol(symbl.invertir,yyline,yycolumn,new String(yytext()));}
"crearArrayDesdeArchivo("   {return new Symbol(symbl.crearArrFile,yyline,yycolumn,new String(yytext()));}
"ascendente()"          {return new Symbol(symbl.ascendente,yyline,yycolumn,new String(yytext()));}
"descendente()"         {return new Symbol(symbl.descendente,yyline,yycolumn,new String(yytext()));}
"funcion"               {return new Symbol(symbl.funcion,yyline,yycolumn,new String(yytext()));}
"selecciona"            {return new Symbol(symbl.selecciona,yyline,yycolumn,new String(yytext()));}
"caso"                  {return new Symbol(symbl.caso,yyline,yycolumn,new String(yytext()));}
"defecto"               {return new Symbol(symbl.defecto,yyline,yycolumn,new String(yytext()));}
"detener"               {return new Symbol(symbl.detener,yyline,yycolumn,new String(yytext()));}
"retornar"              {return new Symbol(symbl.retornar,yyline,yycolumn,new String(yytext()));}
"si"                    {return new Symbol(symbl.si,yyline,yycolumn,new String(yytext()));}
"sino"                  {return new Symbol(symbl.sino,yyline,yycolumn,new String(yytext()));}
"importar"              {return new Symbol(symbl.importar,yyline,yycolumn,new String(yytext()));}
"imprimir"              {return new Symbol(symbl.imprimir,yyline,yycolumn,new String(yytext()));}
","                     {return new Symbol(symbl.coma,yyline,yycolumn,new String(yytext()));}
"var"                   {return new Symbol(symbl.varvar,yyline,yycolumn,new String(yytext()));}
"verdadero"             {return new Symbol(symbl.verdadero,yyline,yycolumn,new String(yytext()));}
"falso"                 {return new Symbol(symbl.falso,yyline,yycolumn,new String(yytext()));}
"nulo"                  {return new Symbol(symbl.nulo,yyline,yycolumn,new String(yytext()));}
"&&"                    {return new Symbol(symbl.op_and ,  yyline, yycolumn, new String(yytext()));}
"||"                    {return new Symbol(symbl.op_or ,  yyline, yycolumn, new String(yytext()));}
"!"                     {return new Symbol(symbl.op_not ,  yyline, yycolumn, new String(yytext()));}
"+="			{return new Symbol(symbl.a_mas,yyline,yycolumn,new String(yytext()));}
"*="			{return new Symbol(symbl.a_por,yyline,yycolumn,new String(yytext()));}
"-="			{return new Symbol(symbl.a_menos,yyline,yycolumn,new String(yytext()));}
"/="			{return new Symbol(symbl.a_div,yyline,yycolumn,new String(yytext()));}
"--"			{return new Symbol(symbl.decre,yyline,yycolumn,new String(yytext()));}
"++"			{return new Symbol(symbl.aumen,yyline,yycolumn,new String(yytext()));} 
"=="                    {return new Symbol(symbl.igual ,  yyline, yycolumn, new String(yytext()));}
">="                    {return new Symbol(symbl.mayori ,  yyline, yycolumn, new String(yytext()));}
"<="                    {return new Symbol(symbl.menori ,  yyline, yycolumn, new String(yytext()));}
"!="                    {return new Symbol(symbl.dif ,  yyline, yycolumn, new String(yytext()));}
">"                     {return new Symbol(symbl.mayor ,  yyline, yycolumn, new String(yytext()));}
"<"                     {return new Symbol(symbl.menor ,  yyline, yycolumn, new String(yytext()));} 
"+"                     {return new Symbol(symbl.mas ,  yyline, yycolumn, new String(yytext()));}
"-"                     {return new Symbol(symbl.menos ,  yyline, yycolumn, new String(yytext()));}
"*"                     {return new Symbol(symbl.mul ,  yyline, yycolumn, new String(yytext()));}
"^"                     {return new Symbol(symbl.pote ,  yyline, yycolumn, new String(yytext()));}
"/"                     {return new Symbol(symbl.divis ,  yyline, yycolumn, new String(yytext()));}
"{"                     {return new Symbol(symbl.llava ,  yyline, yycolumn, new String(yytext()));}
"}"                     {return new Symbol(symbl.llavc ,  yyline, yycolumn, new String(yytext()));}
":"                     {return new Symbol(symbl.dosptos ,  yyline, yycolumn, new String(yytext()));}
";"                     {return new Symbol(symbl.ptocoma ,  yyline, yycolumn, new String(yytext()));}
"."                     {return new Symbol(symbl.pto ,  yyline, yycolumn, new String(yytext()));}
"?"                     {return new Symbol(symbl.ques ,  yyline, yycolumn, new String(yytext()));}
"("                     {return new Symbol(symbl.para,  yyline, yycolumn, new String(yytext()));}
")"                     {return new Symbol(symbl.parc ,  yyline, yycolumn, new String(yytext()));}
"["                     {return new Symbol(symbl.cora,  yyline, yycolumn, new String(yytext()));}
"]"                     {return new Symbol(symbl.corc ,  yyline, yycolumn, new String(yytext()));}
"="                    {return new Symbol(symbl.is ,  yyline, yycolumn, new String(yytext()));}
{er_entero}             {return new Symbol(symbl.er_entero,yyline,yycolumn,new String(yytext()));}
{er_decimal}             {return new Symbol(symbl.er_decimal,yyline,yycolumn,new String(yytext()));}
{er_id}                 {return new Symbol(symbl.er_id,yyline,yycolumn,new String(yytext().toUpperCase()));}
{er_cadena}             {return new Symbol(symbl.er_cadena,yyline,yycolumn,new String(yytext().substring(1, yytext().length()-1)));}
{ComentarioMulti}       {}
{Comentario}            {}
[ \t\r\f\n]+            {}
.                       {      
                            Integer li=yyline+1;
                            Integer co=yycolumn+1;System.out.println("Error Lexico:js " + yytext() + "  linea: " +li + " columna: " + co);
                            //
                            e.AddError("Caracter invalido "+yytext(),li,co,var.archivo,"LEXICO"); 
                        }
}
