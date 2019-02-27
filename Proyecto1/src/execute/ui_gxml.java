/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.util.LinkedList;
import javax.swing.JComponent;

/**
 *
 * @author Pamela Palacios
 */
public class ui_gxml {
    LinkedList<ui_ventana> ventanas;
    
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
            if(c.id.equals(id))
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
