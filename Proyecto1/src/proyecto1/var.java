/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import ts.NodoTipo;

/**
 *
 * @author Pamela Palacios
 */
public class var {
    /*valores por defecto*/
    public static String fuenteDef="Agency FB";
    public static int tamletra=12;
    public static String colorDef="#000000";
    //spinner
    public static int alto_spinner=25;
    public static int ancho_spiner=50;
    public static int incr_spinner=1;
    public static int max_spinner=3000;
    public static int min_spinner=-3000;
    public static int defecto_spinner=0;
    //textbox
    public static int alto_caja=25;
    public static int ancho_caja=50;
    public static int max_caja=3000;
    public static int min_caja=-3000;
    public static String defecto_caja="";
    //area
    public static int alto_area=75;
    public static int ancho_area=75;
    public static int max_area=3000;
    public static int min_area=-3000;
    public static String defecto_area="";
    //combobox
    public static int max_cb=3000;
    public static int min_cb=-3000;
    public static int alto_cb=25;
    public static int ancho_cb=75;
    public static String defecto_cb="";
    //texto
    public static int max_t=3000;
    public static int min_t=-3000;
    public static int alto_t=25;
    public static int ancho_t=75;
    //boton
    public static int alto_boton=25;
    public static int ancho_boton=75;
    //panel
    public static int alto_panel=25;
    public static int ancho_panel=75;
    public static String color_fondo="#FFFFFF";
    //ventana
    public static int alto_ven=500;
    public static int ancho_ven=500;
    //imagen
    public static int altoIm=200;
    public static int anchoIm=200;
    //musica
    public static int altoMu=40;
    public static int anchoMu=100;
    //video
    public static int altoVi=300;
    public static int anchoVi=300;
    //CONTROLADORES EN GENERAL
    public static int alto_controlador=25;
    public static int ancho_ontrolador=75;
    /*fin de valores x defecto */
    public static String valor_true="verdadero";
    public static String valor_false="falso";
    public static String archivo;
    public static int filaGlobal=0;
    public static int columnaGlobal=0;
    public static String ext_fs=".fs";
    public static String ext_gxml=".gxml";
    /*TIPO DE ELEMENTOS*/
    public static int id=100;
    public static int tipo=101;
    public static int color=102;
    public static int accionInicial=103;
    public static int accionFinal=104;
    public static int x=105;
    public static int y=106;
    public static int alto=107;
    public static int ancho=108;
    public static int borde=109;
    public static int nombre=110;
    public static int fuente=111;
    public static int tam=112;
    public static int negrita=113;
    public static int cursiva=114;
    public static int maximo=115;
    public static int minimo=116;
    public static int accion=117;
    public static int referencia=118;
    public static int path=119;
    public static int autoplay=120;
    public static int defecto=121;
    public static  String []  elementos={"ID","TIPO","COLOR","ACCIONINICIAL","ACCIONFINAL","X","Y","ALTO",
                "ANCHO","BORDE","NOMBRE","FUENTE","TAM","NEGRITA","CURSIVA","MAXIMO","MINIMO","ACCION",
                "REFERENCIA","RUTA","AUTOREPRODUCCION","DFECTO"};
    
    //public static int borde=122;
    
    /*de tipos*/
    public static int booleano=0;
    public static int entero=1;
    public static int decimal=2;
    public static int cadena=3;
    public static int arreglo=4;
    public static int objeto=5;
    public static int nulo=6;    
    public static int error=7;
    public static int vacio=8;
    public static int gxml=9;
    public static int ventana=10;
    public static int contenedor=11;
    public static int texto=12;
    public static int cajatexto=13;
    public static int areatexto=14;
    public static int controlnum=15;
    public static int desplegable=16;
    public static int boton=17;
    public static int imagen=18;
    public static int reproductor=19;
    public static int video=20;
    public static int heterogenea=21;
    public static int detener=-1;
    
    public static String t_booleano="booleano";
    public static String t_entero="entero";    
    public static String t_decimal="decimal";
    public static String t_cadena="cadena";
    public static String t_arreglo="";
    public static String t_objeto="objeto";
    public static String t_error="error";
    public static String t_nulo="nulo";
    public static String t_vacio="vacio";
    public static String t_gxml="Objeto gxml";    
    public static String t_ventana="UI Ventana";
    public static String t_contenedor="UI Contenedor";
    public static String t_texto="UI Texto";
    public static String t_cajatexto="UI CajaTexto";
    public static String t_areatexto="UI AreaTexto";
    public static String t_controlnum="UI ControlNumerico";
    public static String t_desplegable="UI Desplegable";
    public static String t_boton="UI Boton";
    public static String t_imagen="UI Imagen";
    public static String t_reproductor="UI Reproductor";
    public static String t_video="UI Video";
    public static String t_heterogeneo="Heterogeneo";
        
    public static NodoTipo tipo_booleano=new NodoTipo(booleano,t_booleano);
    public static NodoTipo tipo_entero=new NodoTipo(entero,t_entero);    
    public static NodoTipo tipo_decimal=new NodoTipo(decimal,t_decimal);
    public static NodoTipo tipo_cadena=new NodoTipo(cadena,t_cadena);
    public static NodoTipo tipo_arreglo=new NodoTipo(arreglo,"");
    public static NodoTipo tipo_error=new NodoTipo(error,t_error);
    public static NodoTipo tipo_nulo=new NodoTipo(nulo,t_nulo);
    public static NodoTipo tipo_vacio=new NodoTipo(vacio,t_vacio);
    public static NodoTipo tipo_gxml=new NodoTipo(gxml,t_gxml);
    public static NodoTipo tipo_ventana=new NodoTipo(ventana,t_ventana);
    public static NodoTipo tipo_contenedor=new NodoTipo(contenedor,t_contenedor);
    public static NodoTipo tipo_texto=new NodoTipo(texto,t_texto);
    public static NodoTipo tipo_cajatexto=new NodoTipo(cajatexto,t_cajatexto);
    public static NodoTipo tipo_areatexto=new NodoTipo(areatexto,t_areatexto);
    public static NodoTipo tipo_controlnum=new NodoTipo(controlnum,t_controlnum); 
    public static NodoTipo tipo_desplegable=new NodoTipo(desplegable,t_desplegable); 
    public static NodoTipo tipo_boton=new NodoTipo(boton,t_boton);  
    public static NodoTipo tipo_imagen=new NodoTipo(imagen,t_imagen); 
    public static NodoTipo tipo_reproductor=new NodoTipo(reproductor,t_reproductor); 
    public static NodoTipo tipo_video=new NodoTipo(video,t_video);
    public static NodoTipo tipo_heterogeneo=new NodoTipo(heterogenea,t_heterogeneo);
    public static NodoTipo tipo_detener=new NodoTipo(heterogenea,"");
    public static NodoTipo tipo_objeto=new NodoTipo(objeto,t_objeto);
}
