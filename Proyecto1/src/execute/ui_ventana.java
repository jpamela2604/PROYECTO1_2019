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
import javax.swing.JFrame;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ventana extends JFrame{
    //ELEMENTOS
    public LinkedList<ui_contenedor> contenedores;
    //obligatorio
    public String id;
    public String tipo;//Principal,Secundaria
    public int alto=500;
    public int ancho=500;
    //opcional
    public ui_ventana(String id,String tipo)
    {
        this.contenedores=new LinkedList();
        this.id=id;
        this.tipo=tipo;
    }
     public ui_ventana(String color,int alto,int ancho)
    {
        this.contenedores=new LinkedList();
        this.id="";
        this.tipo="SECUNDARIA";
        this.color=color;
        this.ancho=ancho;
        this.alto=alto;
        
    }
    public String color;
    //sent AccionInicial;
    //sent AccionFinal;
    
    public void cargar()
    {
        this.getContentPane().setBackground(Color.decode(color));
        this.setPreferredSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.setMaximumSize(new Dimension(alto,ancho));
        this.pack();
        for(ui_contenedor c:contenedores)
        {
            c.cargar();
            c.setLocation(c.x, c.y);
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
            if(id.equals(c.id))
            {
               elemntos.add(c);
            }
        }
        return elemntos;
    }
    
}
