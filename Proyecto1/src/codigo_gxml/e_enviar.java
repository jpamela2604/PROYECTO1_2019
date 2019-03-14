/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import execute.ui_boton;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_enviar implements etiqueta{
    LinkedList<elemento> elementos;
    String texto;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    public e_enviar(LinkedList<elemento> elementos,String texto,int linea, int columna,String archivo)
    {
        this.texto=texto;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("ALTO", 100);
        opcionales.put("ANCHO", 100);
        opcionales.put("ACCION", "");
        opcionales.put("REF", "");
    }
    @Override
    public Object GetGxmlObject() {
        return new ui_boton(obligatorios.get("NOMBRE").toString(),
        Integer.valueOf(obligatorios.get("X").toString()),
        Integer.valueOf(obligatorios.get("Y").toString()),
        Integer.valueOf(opcionales.get("ALTO").toString()),
        Integer.valueOf(opcionales.get("ANCHO").toString()),
        opcionales.get("ACCION").toString(),
        opcionales.get("REF").toString(),
                true,
                texto
        );
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
            }else if(el.tipo==var.x)
            {
                obligatorios.put("X",el.valor);
            }else if(el.tipo==var.y)
            {
                obligatorios.put("Y",el.valor);
            }else if(el.tipo==var.alto)
            {
                opcionales.put("ALTO",el.valor);
            }
            else if(el.tipo==var.ancho)
            {
                opcionales.put("ANCHO",el.valor);
            }else if(el.tipo==var.referencia)
            {
                opcionales.put("REF",el.valor);
            }else if(el.tipo==var.accion)
            {
                opcionales.put("ACCION",el.valor);
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
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta multimedia", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta multimedia", linea, columna, archivo, "SEMANTICO");
        }
    }
}
