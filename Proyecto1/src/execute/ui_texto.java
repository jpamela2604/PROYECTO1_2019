/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.JLabel;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_texto extends JLabel{
     public Hashtable tabla;
    //obligatorios
    //String nombre;
    //String valor;
    /*int x;
    int y;*/
     //opcionales
    /*String fuente;
    int tam;
    String color;*/
    /*Boolean negrita;
    Boolean cursiva;*/
    /*no estoy segura*/
    /*int alto;
    int ancho;*/
    /*int maximo;
    int minimo;*/
    //sent accion;
    public ui_texto(String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)
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
       /* this.x=x;
        this.y=y;  */    
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.negrita=negrilla;
        this.cursiva=cursiva;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        //this.valor=valor;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,var.alto_t,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,var.ancho_t,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_t,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_t,false));
        this.setVisible(false);
        
    }
    public ui_texto(String nombre,int x,int y)
    {
        this.tabla=new Hashtable();
        //valor=nombre;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,nombre,false));        
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
       /* this.x=x;
        this.y=y;*/
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuenteDef,false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,var.tamletra,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        /*this.negrita=false;
        this.cursiva=false;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,var.alto_t,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,var.ancho_t,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_t,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_t,false));
        this.setVisible(false);
    }
    
    public void cargar()
    {
       
        int tam=Integer.valueOf(((Simbolo)tabla.get("TAMAÑO")).valor.toString());
        String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        Boolean negrita=Boolean.valueOf(((Simbolo)tabla.get("NEGRITA")).valor.toString());
        Boolean cursiva=Boolean.valueOf(((Simbolo)tabla.get("CURSIVA")).valor.toString());
        int font=0;
        if(negrita)
        {
            font=font+Font.BOLD;
        }
        if(cursiva)
        {
            font=font+Font.ITALIC;
        }
        this.setFont(new java.awt.Font(fuente, font, tam));
        this.setForeground(Color.decode(color));
        String valor=((Simbolo)tabla.get("VALOR")).valor.toString();
        this.setText(valor);
        int xx=Integer.valueOf(((Simbolo)tabla.get("X")).valor.toString());
        int yy=Integer.valueOf(((Simbolo)tabla.get("Y")).valor.toString());
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //setsize(width,height)
        this.setSize(ancho,alto);
        //setBounds(int x, int y, int width, int height)
        this.setBounds(xx, yy, ancho, alto);
        this.setVisible(true);
        this.repaint();
    }
    
}
