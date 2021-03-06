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
public class e_boton implements etiqueta{
    LinkedList<elemento> elementos;
    String texto;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    etiqueta ete;
    public e_boton(LinkedList<elemento> elementos,String texto,int linea, int columna,String archivo,etiqueta ete)
    {
        this.texto=texto;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("ALTO", Defecto.boton_alto);
        opcionales.put("ANCHO", Defecto.boton_ancho);
        opcionales.put("ACCION", "");
        opcionales.put("REF", "");
        this.ete=ete;
    }
    @Override
    public Object GetGxmlObject() {
        String id_texto="";
        if(ete!=null)
        {
            LinkedList<String> v=(LinkedList<String>)ete.GetGxmlObject();
            id_texto=v.get(0);
            texto=v.get(1);            
        }
        //String nombre,int x,int y,int alto,int ancho,String accion,String ref,Boolean IsEnviar,String valor
        return new ui_boton(obligatorios.get("NOMBRE").toString(),
        Integer.valueOf(obligatorios.get("X").toString()),
        Integer.valueOf(obligatorios.get("Y").toString()),
        Integer.valueOf(opcionales.get("ALTO").toString()),
        Integer.valueOf(opcionales.get("ANCHO").toString()),
        opcionales.get("ACCION").toString(),
        opcionales.get("REF").toString(),
                false,
                texto,
                id_texto
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
        if(ete!=null)
        {
            ete.Comprobar(e);
        }
    }
}
