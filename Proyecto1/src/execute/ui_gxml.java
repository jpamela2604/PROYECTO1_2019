/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_gxml.ruta;
import java.util.LinkedList;
import javax.swing.JComponent;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_gxml {
    public LinkedList<ui_ventana> ventanas;
    public LinkedList<ruta> rutas;
    public ui_gxml()
    {
        this.ventanas=new LinkedList();
        this.rutas=new LinkedList();
    }
    public String getTraduccion()
    {
        String t="";
        for(ruta rut:rutas)
        {
            t=t+"importar(\""+rut.ruta+"\");\n";
        }
        for(ui_ventana bo:ventanas)
        {
            t=t+bo.getTraduccion();
            
        }
        
        return t;
    }
    
    public LinkedList<JComponent> getByNombre(String Nombre)
    {
        LinkedList<JComponent> elemntos=new LinkedList();
        for(ui_ventana c:this.ventanas)
        {
            LinkedList<JComponent> aux=c.getByNombre(Nombre);
            for(JComponent p:aux)
            {
                elemntos.add(p);
            }
        }     
        
        return elemntos;
    }
    
    public LinkedList<Object> getByID(String id)
    {
        LinkedList<Object> elemntos=new LinkedList();        
        for(ui_ventana c:this.ventanas)
        {
            if(((Simbolo)c.tabla.get("ID")).valor.toString().equals(id))
            {
                elemntos.add(c);
            }
            LinkedList<JComponent> aux=c.getByID(id);
            for(JComponent p:aux)
            {
                elemntos.add(p);
            }
        }
        return elemntos;
    }
    public LinkedList<Object> getByTag(String tag)
    {
        LinkedList<Object> elemntos=new LinkedList(); 
        switch(tag.toUpperCase())
        {
            case "VENTANAS":
            {
                for(ui_ventana v:this.ventanas)
                {
                    elemntos.add(v);
                }
            }break;
            case "CONTENEDOR":
            {
                for(ui_ventana v:this.ventanas)
                {
                    for(ui_contenedor con:v.contenedores)
                    {
                        elemntos.add(con);
                    }
                }
            }break;
            
        }
        
        return elemntos;
    }
}
