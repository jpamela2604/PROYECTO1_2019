/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_contenedor implements etiqueta{
    LinkedList<etiqueta> etiquetas;
    LinkedList<elemento> elementos;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    public e_contenedor(LinkedList<elemento> elementos,LinkedList<etiqueta> etiquetas,int linea, int columna,String archivo)
    {
        this.etiquetas=etiquetas;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("COLOR", var.color_fondo);
        opcionales.put("ALTO", var.alto_panel);
        opcionales.put("ANCHO", var.ancho_panel);
        opcionales.put("BORDE", false);
    }
    @Override
    public Object Comprobar(mng_error e) {
        String invalidos= "";
        String aux="";
        for(elemento el:this.elementos)
        {
            if(el.tipo==var.id)
            {
                obligatorios.put("ID",el.valor);
            }else if(el.tipo==var.x)
            {
                obligatorios.put("X",el.valor);
            }else if(el.tipo==var.y)
            {
                obligatorios.put("Y",el.valor);
            }else if(el.tipo==var.color)
            {
                opcionales.put("COLOR",el.valor);
            }else if(el.tipo==var.alto)
            {
                opcionales.put("ALTO",el.valor);
            }
            else if(el.tipo==var.ancho)
            {
                opcionales.put("ANCHO",el.valor);
            }else if(el.tipo==var.borde)
            {
                opcionales.put("BORDE",el.valor);
            }else
            {
                invalidos=invalidos+aux+var.elementos[el.tipo-100];
                aux=",";
                        
            }
        }
        aux="";
        String missing="";
        //comprobar que existan los obligatorios
        if(!obligatorios.containsKey("ID"))
        {
            missing="ID";aux=",";
        }
        if(!obligatorios.containsKey("X"))
        {
            missing=missing+aux+"X";aux=",";
        }
        if(!obligatorios.containsKey("Y"))
        {
            missing=missing+aux+"Y";aux=",";
        }
        if(!missing.equals(""))
        {
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta contenedor", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta contenedor ", linea, columna, archivo, "SEMANTICO");
        }
        
        for(etiqueta eti:etiquetas)
        {
            eti.Comprobar(e);
        }
        
        return null;
    }
}
