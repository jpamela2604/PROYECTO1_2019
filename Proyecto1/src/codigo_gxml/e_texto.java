/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import execute.ui_texto;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_texto implements etiqueta{
    LinkedList<elemento> elementos;
    String texto;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    public e_texto(LinkedList<elemento> elementos,String texto,int linea, int columna,String archivo)
    {
        this.texto=texto;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("COLOR", var.colorDef);
        opcionales.put("FUENTE", var.fuenteDef);
        opcionales.put("TAM", var.tamletra);
        opcionales.put("NEGRITA", false);
        opcionales.put("CURSIVA", false);
    }
    @Override
    public Object GetGxmlObject() {
        /*ui_texto(String nombre,String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)*/
        return new ui_texto(
                obligatorios.get("NOMBRE").toString(),
                opcionales.get("FUENTE").toString(),
                Integer.valueOf(opcionales.get("TAM").toString()),
                opcionales.get("COLOR").toString(),
        Integer.valueOf(obligatorios.get("X").toString()),
        Integer.valueOf(obligatorios.get("Y").toString()),
        Boolean.valueOf(opcionales.get("NEGRITA").toString()),
        Boolean.valueOf(opcionales.get("CURSIVA").toString()),
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
            }else if(el.tipo==var.color)
            {
                opcionales.put("COLOR",el.valor);
            }else if(el.tipo==var.fuente)
            {
                opcionales.put("FUENTE",el.valor);
            }
            else if(el.tipo==var.tam)
            {
                opcionales.put("TAM",el.valor);
            }else if(el.tipo==var.negrita)
            {
                opcionales.put("NEGRITA",el.valor);
            }else if(el.tipo==var.cursiva)
            {
                opcionales.put("CURSIVA",el.valor);
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
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta texto", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta texto", linea, columna, archivo, "SEMANTICO");
        }
    }
}
