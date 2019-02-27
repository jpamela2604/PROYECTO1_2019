/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Pamela Palacios
 */
public class ui_contenedor extends JPanel{
    //elementos
    LinkedList<ui_texto> textos;
    /*controladores*/
    LinkedList<ui_ControlNumerico> spinners;
    LinkedList<ui_areaTexto> areas;
    LinkedList<ui_cajaTexto> cajas;
    LinkedList<ui_desplegable> combobox;
    /*multimedia*/
    LinkedList<ui_imagen> imagenes;
    LinkedList<ui_video> videos;
    LinkedList<ui_reproductor> musica;
    /*boton*/
    LinkedList<ui_boton> botones;
    //obligatorio
    String id;
    int x;
    int y;
    public ui_contenedor(String id,int x,int y)
    {
        this.id=id;
        this.x=x;
        this.y=y;
        this.textos=new LinkedList();
        this.spinners=new LinkedList();
        this.areas=new LinkedList();
        this.cajas=new LinkedList();
        this.combobox=new LinkedList();
        this.imagenes=new LinkedList();
        this.videos=new LinkedList();
        this.musica=new LinkedList();
        this.botones=new LinkedList();
        this.alto=500;
        this.ancho=500;
    }
    //opcionales
    int alto;
    int ancho;
    String color;
    Boolean borde;
    
    
    public LinkedList<JComponent> getByNombre(String Nombre)
    {
        LinkedList<JComponent> elemntos=new LinkedList();
        for(ui_texto t:textos)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_ControlNumerico t:spinners)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_areaTexto t:areas)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_cajaTexto t:cajas)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_desplegable t:combobox)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_imagen t:imagenes)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_video t:videos)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_reproductor t:musica)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        for(ui_boton t:botones)
        {
            if(t.nombre.equals(Nombre))
            {
                elemntos.add(t);
            }
        }
        return elemntos;
    }
    
    public void cargar()
    {
        this.setBackground(Color.decode(color));
        this.setPreferredSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        for(ui_texto t:textos)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_ControlNumerico t:spinners)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_areaTexto t:areas)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_cajaTexto t:cajas)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_desplegable t:combobox)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_imagen t:imagenes)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_video t:videos)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_reproductor t:musica)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
        for(ui_boton t:botones)
        {
            t.cargar();
            t.setLocation(t.x, t.y);
            this.add(t);
        }
    }
    
}
