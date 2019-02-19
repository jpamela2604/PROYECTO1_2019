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
    /*de tipos*/
    public static int booleano=0;
    public static int numero=1;
    public static int cadena=2;
    public static int arreglo=3;
    public static int objeto=4;
    public static int nulo=5;    
    public static int indefinido=6;
    public static int error=7;
    
    
    public static String t_booleano="booleano";
    public static String t_numero="numero";
    public static String t_cadena="cadena";
    public static String t_arreglo="";
    public static String t_objeto="objeto";
    public static String t_error="error";
    public static String t_nulo="nulo";
    public static String t_indefinido="indefinido";
    public static NodoTipo tipo_booleano=new NodoTipo(booleano,t_booleano);
    public static NodoTipo tipo_numero=new NodoTipo(numero,t_numero);
    public static NodoTipo tipo_cadena=new NodoTipo(cadena,t_cadena);
    public static NodoTipo tipo_error=new NodoTipo(error,t_error);
    public static NodoTipo tipo_nulo=new NodoTipo(nulo,t_nulo);
    public static NodoTipo tipo_indefinido=new NodoTipo(indefinido,t_indefinido);
}
