/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.util.Hashtable;
import javax.swing.JButton;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_boton extends JButton{
     public Hashtable tabla;
    //obligatorios
    //String nombre;
    /*int x;
    int y;*/
    /*String fuente;
    int tam;
    String color;*/
    //opcionales
    /*int alto;
    int ancho;*/
    //String referencia;
    //String valor;
    //sent llamada;
    public ui_boton(String nombre,int x,int y)
    {
        this.tabla=new Hashtable();
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        /*this.x=x;
        this.y=y; */
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,this.getSize().height,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,this.getSize().width,false));
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
       this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,this.getFont().getFontName(),false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,this.getFont().getSize(),false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,"#000000",false));
        //referencia="";
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,"",false));
        //valor=nombre;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,nombre,false));
    }
    public ui_boton(String fuente,int tam,String color,int x,int y,String ref,String valor,int alto,int ancho)
    {
        this.tabla=new Hashtable();
        //this.nombre="";
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        /*this.fuente=fuente;
        this.tam=tam;
        this.color=color;*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,tam,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.x=x;
        this.y=y;*/
        //this.referencia=ref;
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,ref,false));
        //this.valor=valor;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        
        
    }
    public void cargar()
    {
        int tam=Integer.valueOf(((Simbolo)tabla.get("TAMAÑO")).valor.toString());
        String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        String valor=((Simbolo)tabla.get("VALOR")).valor.toString();
        this.setText(valor);
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        this.setSize(alto,ancho);
        this.setFont(new java.awt.Font(fuente, 0, tam));
        this.setBackground(Color.decode(color));
    }
}
