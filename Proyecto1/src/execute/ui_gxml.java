/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_gxml.ruta;
import java.util.LinkedList;
import javax.swing.JComponent;
import proyecto1.var;
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
    
    public LinkedList<Simbolo> getByNombre(String Nombre)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();
        for(ui_ventana c:this.ventanas)
        {
            LinkedList<Simbolo> aux=c.getByNombre(Nombre);
            for(Simbolo p:aux)
            {
                elemntos.add(p);
            }
        }     
        
        return elemntos;
    }
    
    public LinkedList<Simbolo> getByID(String id)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();        
        for(ui_ventana c:this.ventanas)
        {
            if(((Simbolo)c.tabla.get("ID")).valor.toString().equals(id))
            {
                elemntos.add(new Simbolo(var.tipo_ventana,c));
            }
            LinkedList<Simbolo> aux=c.getByID(id);
            for(Simbolo p:aux)
            {
                elemntos.add(p);
            }
        }
        return elemntos;
    }
    public LinkedList<Simbolo> getByTag(String tag)
    {
        LinkedList<Simbolo> elemntos=new LinkedList(); 
        switch(tag.toUpperCase())
        {
            case "VENTANAS":
            {
                for(ui_ventana v:this.ventanas)
                {
                    elemntos.add(new Simbolo(var.tipo_ventana,v));
                }
            }break;
            default:
            {
                for(ui_ventana v:this.ventanas)
                {
                    LinkedList<Simbolo> el=v.getByTag(tag);
                    for(Simbolo s:el)
                    {
                        elemntos.add(s);
                    }
                }
            }break;
            
        }
        
        return elemntos;
    }
}
