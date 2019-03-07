/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ControlNumerico extends JSpinner{
    //obligatorios
   //String nombre;
    public Hashtable tabla;
    //int defecto;
    //int x;
    //int y;
    //opcionales
    //String fuente;
    //int tam;
    //String color;
    //Boolean negrita;
    //Boolean cursiva;
    //int alto;
    //int ancho;
    //int maximo;
    //int minimo;
   public ui_ControlNumerico (int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,int defecto,String nombre,
             int maximo,int minimo)
    {
        this.tabla=new Hashtable();
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
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
        this.y=y;       */ 
        /*this.negrita=negrilla;
        this.cursiva=cursiva;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        //this.defecto=defecto;
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,maximo,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,minimo,false));
        this.setVisible(false);
    }
    //Contenedor.CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)
    
    public String getTraduccion(String ventana,String panel)
    {
         String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre="numerico_"+name;
       
         String t="var "+nombre+ " = "+panel+ ".CrearControlNumerico("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+","+
                 ((Simbolo)tabla.get("MAXIMO")).valor.toString()+","+
                 ((Simbolo)tabla.get("MINIMO")).valor.toString()+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                 ((Simbolo)tabla.get("DEFECTO")).valor.toString()+",\""+
                ((Simbolo)tabla.get("NOMBRE")).valor.toString()+
        "\");\n";        
        //fuente
         t=t+nombre+".fuente=\""+((Simbolo)tabla.get("FUENTE")).valor.toString()+"\";\n";
        //tam
         t=t+nombre+".tamaño="+((Simbolo)tabla.get("TAMAÑO")).valor.toString()+";\n";
         //color
         t=t+nombre+".color=\""+((Simbolo)tabla.get("COLOR")).valor.toString()+"\";\n";
         //NEGRITA
         t=t+nombre+".negrita="+((((Simbolo)tabla.get("NEGRITA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
         //CURSIVA
         t=t+nombre+".cursiva="+((((Simbolo)tabla.get("CURSIVA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
        return t;
    }
    //Contenedor.CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)
    
    public ui_ControlNumerico(int alto,int ancho,int maximo,int minimo,int x,int y,int defecto,String nombre)
    {
        this.tabla=new Hashtable();
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        //this.alto=alto;
        //this.ancho=ancho;
        //this.maximo=maximo;
        //this.minimo=minimo;
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,maximo,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,minimo,false));
        //this.x=x;
        //this.y=y;
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        //this.defecto=defecto;
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_entero,defecto,false));
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        //this.fuente=this.getFont().getFontName();
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuente,false));
        this.tabla.put("TAMAÑO", new Simbolo(var.tipo_entero,var.tamletra,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        //this.color="#000000";
        /*this.negrita=false;
        this.cursiva=false;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        this.setVisible(false);
        
    }
    
    //sent accion;
    public void cargar()
    {
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
        
        
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //setsize(width,height)
        this.setSize(ancho,alto);
        //default value,lower bound,upper bound,increment by 
        int minimo=Integer.valueOf(((Simbolo)tabla.get("MINIMO")).valor.toString());
       
        int maximo=Integer.valueOf(((Simbolo)tabla.get("MAXIMO")).valor.toString());
        int def=Integer.valueOf(((Simbolo)tabla.get("DEFECTO")).valor.toString());
        this.setModel(new SpinnerNumberModel(def, minimo, maximo, var.incr_spinner));
        //this.setForeground(Color.decode(color));
        JComponent editor =(JSpinner.NumberEditor) this.getEditor();
        int n = editor.getComponentCount();
        for (int i=0; i<n; i++)
        {
            Component c = editor.getComponent(i);
            if (c instanceof JTextField)
            {
                c.setForeground(Color.decode(color));
            }
        }
        this.repaint();
        this.setVisible(true);
        
    }
}
