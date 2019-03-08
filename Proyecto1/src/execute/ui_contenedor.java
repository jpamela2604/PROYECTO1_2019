/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.Array;
import codigo_gdato.item;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    public ui_contenedor(int alto,int ancho,String color,Boolean borde,int x,int y,String id)
    {
        this.tabla=new Hashtable();
        //this.borde=false;
        this.tabla.put("BORDE", new Simbolo(var.tipo_booleano,borde,false));
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
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.setVisible(false);
    }
    public String getTraduccion(String ventana)
    {
        //CrearContenedor(Alto, Ancho, Color, Borde, X, Y)
        String name=((Simbolo)tabla.get("ID")).valor.toString();
        String nombre="Con_"+name;
       
        String c="var "+nombre+"="+ventana+".crearcontenedor("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((((Simbolo)tabla.get("BORDE")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+
                ");\n";
        c=c+nombre+".id=\""+name+"\";\n";
        for(ui_boton bo:botones)
        {
            c=c+bo.getTraduccion(ventana, nombre);            
        }
        for(ui_texto bo:textos)
        {
            c=c+bo.getTraduccion( nombre);    
        }
        for(ui_ControlNumerico bo:spinners)
        {
            c=c+bo.getTraduccion(ventana, nombre);    
        }
        for(ui_areaTexto bo:areas)
        {
            c=c+bo.getTraduccion(ventana, nombre);    
        }
        for(ui_cajaTexto bo:cajas)
        {
            c=c+bo.getTraduccion(ventana, nombre);    
        }
        for(ui_desplegable bo:combobox)
        {
            c=c+bo.getTraduccion(ventana, nombre);    
        }
        for(ui_imagen bo:imagenes)
        {
            c=c+bo.getTraduccion( nombre);    
        }
        for(ui_video bo:videos)
        {
            c=c+bo.getTraduccion( nombre);    
        }
        for(ui_reproductor bo:musica)
        {
            c=c+bo.getTraduccion( nombre);    
        }
        
        return c;
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
        this.setVisible(false);
    }
    
    
    
    public LinkedList<Simbolo> getByNombre(String Nombre)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();
        for(ui_texto t:textos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_texto,t));
            }
        }
        for(ui_ControlNumerico t:spinners)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_controlnum,t));
            }
        }
        for(ui_areaTexto t:areas)
        {
           if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_areatexto,t));
            }
        }
        for(ui_cajaTexto t:cajas)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_cajatexto,t));
            }
        }
        for(ui_desplegable t:combobox)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_desplegable,t));
            }
        }
        for(ui_imagen t:imagenes)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_imagen,t));
            }
        }
        for(ui_video t:videos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_video,t));
            }
        }
        for(ui_reproductor t:musica)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_reproductor,t));
            }
        }
        for(ui_boton t:botones)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
               elemntos.add(new Simbolo(var.tipo_boton,t));
            }
        }
        return elemntos;
    }
    public LinkedList<item> getValores()
    {
        LinkedList<item> valores=new LinkedList();
        for(ui_ControlNumerico t:spinners)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,t.getValue(),0,0,""));
        }
        for(ui_areaTexto t:areas)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,"\""+t.getText()+"\"",0,0,""));
        }
        for(ui_cajaTexto t:cajas)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,"\""+t.getText()+"\"",0,0,""));
        }
        for(ui_desplegable t:combobox)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            Array lista=(Array) ((Simbolo)t.tabla.get("LISTA")).valor;
            Simbolo v=lista.valores.get(t.getSelectedIndex());
            String valor="";
            if(v!=null)
            {
                if(v.tipo.indice==var.booleano)
                {
                    if(Boolean.valueOf(v.valor.toString()))
                    {
                        valor="verdadero";
                    }else
                    {
                        valor="falso";
                    }
                }else if(v.tipo.indice==var.nulo)
                {
                    valor="nulo";
                }
                else
                {
                    valor=v.valor.toString();
                }
                
                if(!(v.tipo.indice==var.entero||v.tipo.indice==var.decimal))
                {
                    valor="\""+valor+"\"";
                }
            }
            valores.add(new item(nombre,valor,0,0,""));
        }
        return valores;
    }
    public void cargar()
    {
        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setLayout(null);
        Boolean borde=Boolean.valueOf(((Simbolo)tabla.get("BORDE")).valor.toString());
        if(borde)
        {
            this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));        
        }
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        this.setBackground(Color.decode(color));
        /*
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        
        this.setPreferredSize(new Dimension(alto,ancho));
        
        int xxa=Integer.valueOf(((Simbolo)tabla.get("X")).valor.toString());
        int yya=Integer.valueOf(((Simbolo)tabla.get("Y")).valor.toString());
        this.setBounds(xxa, yya, ancho, alto);        
        
        this.setMaximumSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.repaint();*/
        int x=0;
        int y=0;
        int ancho=0;
        int alto=0;
        
        for(ui_texto t:textos)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            //t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_ControlNumerico t:spinners)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            //setlocation(x,y)
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_areaTexto t:areas)
        {
            t.cargar();
            JScrollPane sp = new JScrollPane();
            sp.getViewport().add(t);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            int altxo=Integer.valueOf(((Simbolo)t.tabla.get("ALTO")).valor.toString());
            int anchxo=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            //setBounds(int x, int y, int width, int height)
            sp.setBounds(xx, yy, anchxo, altxo);
            //t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(sp);
        }
        
        for(ui_cajaTexto t:cajas)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
       
        for(ui_desplegable t:combobox)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            //t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_imagen t:imagenes)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_video t:videos)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_reproductor t:musica)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        for(ui_boton t:botones)
        {
            t.cargar();
            int xx=Integer.valueOf(((Simbolo)t.tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)t.tabla.get("Y")).valor.toString());
            t.setLocation(xx, yy);
            if(xx>=x)
            {
                x=xx;
                ancho=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString());                
            }
            if(yy>=y)
            {
                y=yy;
                alto=Integer.valueOf(((Simbolo)t.tabla.get("ANCHO")).valor.toString()); 
            }
            this.add(t);
        }
        this.validate();
        ////new dimension(height,width)
        this.setPreferredSize(new Dimension(x+ancho+50,y+alto+50));
        this.validate();
        this.setVisible(true);
    }
    public LinkedList<Simbolo> getByTag(String tag)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();  
        switch(tag.toUpperCase())
        {
            case "TEXTO":
            {
                for(ui_texto con:this.textos)
                {
                    elemntos.add(new Simbolo(var.tipo_texto,con));
                }
            }break;
            case "CONTROLADOR":
            {
                for(ui_areaTexto con:this.areas)
                {
                    elemntos.add(new Simbolo(var.tipo_areatexto,con));
                }
                for(ui_cajaTexto con:this.cajas)
                {
                    elemntos.add(new Simbolo(var.tipo_cajatexto,con));
                }
                for(ui_desplegable con:this.combobox)
                {
                    elemntos.add(new Simbolo(var.tipo_desplegable,con));
                }
                for(ui_ControlNumerico con:this.spinners)
                {
                    elemntos.add(new Simbolo(var.tipo_controlnum,con));
                }
            }break;
            case "MULTIMEDIA":
            {
                for(ui_reproductor con:this.musica)
                {
                    elemntos.add(new Simbolo(var.tipo_reproductor,con));
                }
                for(ui_video con:this.videos)
                {
                    elemntos.add(new Simbolo(var.tipo_video,con));
                }
                for(ui_imagen con:this.imagenes)
                {
                    elemntos.add(new Simbolo(var.tipo_imagen,con));
                }
            }break;
            case "BOTON":
            {
                for(ui_boton con:this.botones)
                {
                    elemntos.add(new Simbolo(var.tipo_boton,con));
                }
            }break;
            case "ENVIAR":
            {
                for(ui_boton con:this.botones)
                {
                    elemntos.add(new Simbolo(var.tipo_boton,con));
                }
            }break;
            
        }
        return elemntos;
    }
    
}
