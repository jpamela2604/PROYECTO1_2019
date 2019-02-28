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
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_contenedor extends JPanel{
     public Hashtable tabla;
    //elementos
    public LinkedList<ui_texto> textos;
    /*controladores*/
    public LinkedList<ui_ControlNumerico> spinners;
    public LinkedList<ui_areaTexto> areas;
    public LinkedList<ui_cajaTexto> cajas;
    public LinkedList<ui_desplegable> combobox;
    /*multimedia*/
    public LinkedList<ui_imagen> imagenes;
    public LinkedList<ui_video> videos;
    public LinkedList<ui_reproductor> musica;
    /*boton*/
    public LinkedList<ui_boton> botones;
    //obligatorio
    //String id;
    /*int x;
    int y;*/
    //opcionales
    /*int alto;
    int ancho;*/
    //String color;
    //Boolean borde;
    public ui_contenedor(String id,int x,int y)
    {
        this.tabla=new Hashtable();
        //this.borde=false;
        this.tabla.put("BORDE", new Simbolo(var.tipo_booleano,false,false));
        //this.id=id;
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,id,false));
        /*this.x=x;
        this.y=y;*/
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.textos=new LinkedList();
        this.spinners=new LinkedList();
        this.areas=new LinkedList();
        this.cajas=new LinkedList();
        this.combobox=new LinkedList();
        this.imagenes=new LinkedList();
        this.videos=new LinkedList();
        this.musica=new LinkedList();
        this.botones=new LinkedList();
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,this.getSize().height,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,this.getSize().width,false));
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,"#000000",false));
    }
    public ui_contenedor(int alto,int ancho,String color,Boolean borde,int x,int y)
    {
        this.tabla=new Hashtable();
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        //this.color=color;
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("BORDE", new Simbolo(var.tipo_booleano,borde,false));
        //this.borde=borde;        
        /*this.x=x;
        this.y=y;*/
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));        
        //this.id="";
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,"",false));
        this.textos=new LinkedList();
        this.spinners=new LinkedList();
        this.areas=new LinkedList();
        this.cajas=new LinkedList();
        this.combobox=new LinkedList();
        this.imagenes=new LinkedList();
        this.videos=new LinkedList();
        this.musica=new LinkedList();
        this.botones=new LinkedList();
        
    }
    
    
    
    public LinkedList<JComponent> getByNombre(String Nombre)
    {
        LinkedList<JComponent> elemntos=new LinkedList();
        for(ui_texto t:textos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_ControlNumerico t:spinners)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_areaTexto t:areas)
        {
           if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_cajaTexto t:cajas)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_desplegable t:combobox)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_imagen t:imagenes)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_video t:videos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_reproductor t:musica)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_boton t:botones)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        return elemntos;
    }
    
    public void cargar()
    {
        Boolean borde=Boolean.valueOf(((Simbolo)tabla.get("BORDE")).valor.toString());
        if(borde)
        {
            this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));        
        }
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        this.setBackground(Color.decode(color));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        this.setPreferredSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        for(ui_texto t:textos)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_ControlNumerico t:spinners)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_areaTexto t:areas)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_cajaTexto t:cajas)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_desplegable t:combobox)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_imagen t:imagenes)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_video t:videos)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_reproductor t:musica)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
        for(ui_boton t:botones)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            this.add(t);
        }
    }
    
}
