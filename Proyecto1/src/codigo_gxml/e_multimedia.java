/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import execute.ui_imagen;
import execute.ui_reproductor;
import execute.ui_video;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_multimedia implements etiqueta{
    LinkedList<elemento> elementos;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    String tipo;
    
    public e_multimedia(LinkedList<elemento> elementos,int linea, int columna,String archivo)
    {
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("ALTO", var.altoIm);
        opcionales.put("ANCHO", var.altoVi);
        opcionales.put("AUTOPLAY", false);
    }
    @Override
    public Object GetGxmlObject() {
        switch(tipo)
        {
            case "IMAGEN":
            {
                //String ruta,int x,int y,Boolean autoplay,int alto,int ancho,String nombre
                return new ui_imagen(
                obligatorios.get("PATH").toString(),
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("AUTOPLAY").toString()),
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                obligatorios.get("NOMBRE").toString()
                );
            }
            case "MUSICA":
            {
                return new ui_reproductor(
                obligatorios.get("PATH").toString(),
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("AUTOPLAY").toString()),
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                obligatorios.get("NOMBRE").toString()
                );
            }
            default:
            {
                return new ui_video(
                obligatorios.get("PATH").toString(),
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("AUTOPLAY").toString()),
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                obligatorios.get("NOMBRE").toString()
                );
            }
        }
    }
    @Override
    public void Comprobar(mng_error e) {
        String invalidos= "";
        String aux="";
        for(elemento el:this.elementos)
        {
            if(el.tipo==var.nombre)
            {
                obligatorios.put("NOMBRE",el.valor);
            }else if(el.tipo==var.tipo)
            {
                obligatorios.put("TIPO",el.valor);
            }else if(el.tipo==var.x)
            {
                obligatorios.put("X",el.valor);
            }else if(el.tipo==var.y)
            {
                obligatorios.put("Y",el.valor);
            }else if(el.tipo==var.path)
            {
                obligatorios.put("PATH",el.valor);
            }else if(el.tipo==var.alto)
            {
                opcionales.put("ALTO",el.valor);
            }
            else if(el.tipo==var.ancho)
            {
                opcionales.put("ANCHO",el.valor);
            }else if(el.tipo==var.autoplay)
            {
                opcionales.put("AUTOPLAY",el.valor);
            }else
            {
                invalidos=invalidos+aux+var.elementos[el.tipo-100];
                aux=",";
                        
            }
        }
        aux="";
        String missing="";
        //comprobar que existan los obligatorios
        if(!obligatorios.containsKey("NOMBRE"))
        {
            missing="NOMBRE";aux=",";
        }
        if(!obligatorios.containsKey("PATH"))
        {
            missing=missing+aux+"PATH";aux=",";
        }
        if(!obligatorios.containsKey("X"))
        {
            missing=missing+aux+"X";aux=",";
        }
        if(!obligatorios.containsKey("Y"))
        {
            missing=missing+aux+"Y";aux=",";
        }
         if(!obligatorios.containsKey("TIPO"))
        {
            missing=missing+aux+"TIPO";aux=",";
        }else
        {
            String type=obligatorios.get("TIPO").toString().toUpperCase();
            if(!(type.equals("MUSICA")
                    ||type.equals("VIDEO")||type.equals("IMAGEN")))
            {
                e.AddError("El tipo \""+type+"\" no es valido para la etiqueta multimedia ", linea, columna, archivo, "SEMANTICO");
            }
            this.tipo=type;
        }
        if(!missing.equals(""))
        {
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta multimedia", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta multimedia", linea, columna, archivo, "SEMANTICO");
        }
    }
}
