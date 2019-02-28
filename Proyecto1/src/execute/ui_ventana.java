/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ventana extends JFrame{
    //ELEMENTOS
    public LinkedList<ui_contenedor> contenedores;
    public Hashtable tabla;
    //obligatorio
    //public String id;
    //public String tipo;//Principal,Secundaria
    //public int alto;
    //public int ancho;
    //opcional
    //public String color;
    //sent AccionInicial;
    //sent AccionFinal;
    public ui_ventana(String id,String tipo)
    {
        this.tabla=new Hashtable();
        this.contenedores=new LinkedList();
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,id,false));
        //this.id=id;
        //this.tipo=tipo;
        this.tabla.put("TIPO", new Simbolo(var.tipo_cadena,tipo,false));
        //this.alto=500;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,500,false));
        //this.ancho=500;
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,500,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,"",false));
        //this.color="";
    }
     public ui_ventana(String color,int alto,int ancho)
    {
        this.tabla=new Hashtable();
        this.contenedores=new LinkedList();
        //this.id="";
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,"",false));
        //this.tipo="SECUNDARIA";
        this.tabla.put("TIPO", new Simbolo(var.tipo_cadena,"SECUNDARIA",false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        //this.color=color;
        //this.ancho=ancho;
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        //this.alto=alto;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        
    }
    
    
    public void cargar()
    {
        this.getContentPane().setBackground(Color.decode(((Simbolo)tabla.get("COLOR")).valor.toString()));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        this.setPreferredSize(new Dimension(alto ,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.pack();
        for(ui_contenedor c:contenedores)
        {
            c.cargar();
            int xx=Integer.valueOf(((Simbolo)c.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)c.tabla.get("Y")).valor.toString());
            c.setLocation(xx, yy);
            this.add(c);
        }
        
    }  
    public LinkedList<JComponent> getByNombre(String Nombre)
    {
        LinkedList<JComponent> elemntos=new LinkedList();
        for(ui_contenedor c:this.contenedores)
        {
            LinkedList<JComponent> aux=c.getByNombre(Nombre);
            for(JComponent p:aux)
            {
                elemntos.add(p);
            }
        }     
        
        return elemntos;
    }
    
    public LinkedList<JComponent> getByID(String id)
    {
        LinkedList<JComponent> elemntos=new LinkedList();        
        for(ui_contenedor c:this.contenedores)
        {
            if(((Simbolo)c.tabla.get("ID")).valor.toString().equals(id))
            {
                elemntos.add(c);
            }
        }
        return elemntos;
    }
    
}
