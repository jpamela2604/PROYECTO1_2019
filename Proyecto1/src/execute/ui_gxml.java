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
public class ui_gxml implements ui{
    public LinkedList<ui_ventana> ventanas;
    public LinkedList<ruta> rutas;
    public ui_gxml()
    {
        this.ventanas=new LinkedList();
        this.rutas=new LinkedList();
    }
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {        
        for(ui_ventana ven:this.ventanas)
        {
            ven.getByTag(tag, valores);
        }
    }
    @Override
    public void getByNombre(String nombre,LinkedList<Simbolo>valores)
    {
        for(ui_ventana ven:this.ventanas)
        {
            ven.getByNombre(nombre, valores);
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
        for(ui_ventana ven:this.ventanas)
        {
            ven.getById(id, valores);
        }
    }
   
    @Override
    public String getTraduccion(String ventana,String panel)
    {
        String t="";
        for(ruta rut:rutas)
        {
            t=t+"importar(\""+rut.ruta+"\");\n";
        }
        for(ui_ventana bo:ventanas)
        {
            t=t+bo.getTraduccion("","");
            
        }
        
        return t;
    }
    @Override
    public void cargar()
    {
    }
    @Override
    public String getValor(String value)
    {
        return "";
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
