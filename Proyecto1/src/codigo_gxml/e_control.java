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
public class e_control implements etiqueta {
    LinkedList<elemento> elementos;
    LinkedList<Object> opciones;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    public e_control(LinkedList<elemento> elementos,LinkedList<Object> opciones,int linea, int columna,String archivo)
    {
        this.opciones=opciones;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("COLOR", var.colorDef);
        opcionales.put("ALTO", var.alto_controlador);
        opcionales.put("ANCHO", var.ancho_ontrolador);
        opcionales.put("FUENTE", var.fuenteDef);
        opcionales.put("TAM", var.tamletra);
        opcionales.put("NEGRITA", false);
        opcionales.put("CURSIVA", false);
        opcionales.put("MAXIMO", var.max_area);
        opcionales.put("MINIMO", var.min_area);
        opcionales.put("ACCION", "");
    }
    @Override
    public Object Comprobar(mng_error e) {
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
            }else if(el.tipo==var.maximo)
            {
                opcionales.put("MAXIMO",el.valor);
            }else if(el.tipo==var.minimo)
            {
                opcionales.put("MINIMO",el.valor);
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
         if(!obligatorios.containsKey("TIPO"))
        {
            missing=missing+aux+"TIPO";aux=",";
        }else
        {
            String type=obligatorios.get("TIPO").toString().toUpperCase();
            if(!(type.equals("TEXTO")
                    ||type.equals("NUMERICO")||type.equals("TEXTOAREA")||type.equals("DESPLEGABLE")))
            {
                e.AddError("El tipo \""+type+"\" no es valido para la etiqueta Control ", linea, columna, archivo, "SEMANTICO");
            }
        }
        if(!missing.equals(""))
        {
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta Control", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta Control", linea, columna, archivo, "SEMANTICO");
        }
        return null;
    }
}
