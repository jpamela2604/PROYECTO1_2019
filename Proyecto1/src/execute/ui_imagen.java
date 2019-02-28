/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_imagen extends JButton{
    public Hashtable tabla;
    //obligatorios
    /*String ruta;
    String nombre;
    int x;
    int y;
    //opcionales
    int ancho;
    int alto;
    Boolean auto_reproduccion;
    */
     public ui_imagen(String ruta,String nombre,int x,int y)
    {
        this.tabla=new Hashtable();
        //this.ruta=ruta;
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        //this.nombre=nombre;
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        //this.x=x;
        //this.y=y;
        //this.alto=this.getSize().height;
        //this.ancho=this.getSize().width;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,this.getSize().height,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,this.getSize().width,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,false,false));
        //auto_reproduccion=false;
    }
     
     public ui_imagen(String ruta,int x,int y,Boolean autoplay,int alto,int ancho)
    {
        this.tabla=new Hashtable();
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        //this.nombre="";
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        //this.x=x;
        //this.y=y;
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        //this.alto=alto;
        //this.ancho=alto;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,false,false));
        //auto_reproduccion=autoplay;
    }
    
    public void cargar()
    {
        this.setText("");
        this.setIcon(new ImageIcon(((Simbolo)tabla.get("RUTA")).valor.toString()));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        this.setSize(alto,ancho);
    }
}
