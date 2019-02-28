/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.Array;
import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComboBox;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_desplegable extends JComboBox{
     public Hashtable tabla;
    //obligatorios
    //String nombre;
    //String defecto;
    /*int x;
    int y;*/
     //opcionales
    /*String fuente;
    int tam;
    String color;*/
    /*Boolean negrita;
    Boolean cursiva;*/
    /*int alto;
    int ancho;*/
    /*int maximo;
    int minimo;*/
    //sent accion;
    public Array lista;
    public ui_desplegable(int alto,int ancho,Array lista,int x,int y,String defecto,String nombre)
    {
        this.tabla=new Hashtable();
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.lista=lista;
        /*this.x=x;
        this.y=y;*/
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        //this.defecto=defecto;
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,this.getFont().getFontName(),false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,this.getFont().getSize(),false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,"#000000",false));
        /*this.negrita=false;
        this.cursiva=false; */
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,3000,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,-3000,false));
        
    }
    public ui_desplegable(String nombre,int x,int y)
    {
        this.tabla=new Hashtable();
        this.lista=new Array(new LinkedList());
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*
        this.x=x;
        this.y=y;*/
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,this.getFont().getFontName(),false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,this.getFont().getSize(),false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,"#000000",false));
        /*this.negrita=false;
        this.cursiva=false;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,this.getSize().height,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,this.getSize().width,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,3000,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,-3000,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,"",false));
    }
    
    public void cargar()
    {
        //falta defecto!!!!!!
        int font=0;
         Boolean negrita=Boolean.valueOf(((Simbolo)tabla.get("NEGRITA")).valor.toString());
        Boolean cursiva=Boolean.valueOf(((Simbolo)tabla.get("CURSIVA")).valor.toString());
        if(negrita)
        {
            font=font+Font.BOLD;
        }
        if(cursiva)
        {
            font=font+Font.ITALIC;
        }
        int tam=Integer.valueOf(((Simbolo)tabla.get("TAMAÑO")).valor.toString());
        String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        this.setFont(new java.awt.Font(fuente, font, tam));
        this.setForeground(Color.decode(color));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        this.setSize(alto,ancho);
        
        for(Simbolo s:this.lista.valores)
        {
            this.addItem(s.valor.toString());
        }
    }
}
