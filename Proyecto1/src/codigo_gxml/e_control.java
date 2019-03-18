/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import codigo_fs.Array;
import errors.mng_error;
import execute.ui_ControlNumerico;
import execute.ui_areaTexto;
import execute.ui_cajaTexto;
import execute.ui_desplegable;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class e_control implements etiqueta {
    LinkedList<elemento> elementos;
    LinkedList<etiqueta> opciones;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    String tipo;
    public e_control(LinkedList<elemento> elementos,LinkedList<etiqueta> opciones,int linea, int columna,String archivo)
    {
        this.opciones=opciones;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("COLOR", Defecto.controlador_color);
        opcionales.put("ALTO", Defecto.controlador_alto);
        opcionales.put("ANCHO", Defecto.controlador_ancho);
        opcionales.put("FUENTE", Defecto.controlador_fuente);
        opcionales.put("TAM", Defecto.controlador_tam);
        opcionales.put("NEGRITA", false);
        opcionales.put("CURSIVA", false);
        opcionales.put("MAXIMO", Defecto.maximo);
        opcionales.put("MINIMO", Defecto.minimo);
    }
    @Override
    public Object GetGxmlObject() {
        String defecto="";
        LinkedList<Simbolo>valores=new LinkedList();
        Array  ar=new Array(valores);
        for(etiqueta eti:opciones)
        {
            Object o=eti.GetGxmlObject();
            if(o instanceof  Array)
            {
                ar=(Array)o;
            }else
            {
                defecto=o.toString();
            }
        }
        switch(this.tipo)
        {
            case "NUMERICO":
            {
                
                return new ui_ControlNumerico(
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                opcionales.get("FUENTE").toString(),
                Integer.valueOf(opcionales.get("TAM").toString()),
                opcionales.get("COLOR").toString(),  
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("NEGRITA").toString()),
                Boolean.valueOf(opcionales.get("CURSIVA").toString()),
                tryParseInt(defecto),
                obligatorios.get("NOMBRE").toString(),
                Integer.valueOf(opcionales.get("MAXIMO").toString()),
                Integer.valueOf(opcionales.get("MINIMO").toString())
                );
            }
            case "TEXTOAREA":
            {
                return new ui_areaTexto(
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                opcionales.get("FUENTE").toString(),
                Integer.valueOf(opcionales.get("TAM").toString()),
                opcionales.get("COLOR").toString(),  
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("NEGRITA").toString()),
                Boolean.valueOf(opcionales.get("CURSIVA").toString()),
                defecto,
                obligatorios.get("NOMBRE").toString(),
                Integer.valueOf(opcionales.get("MAXIMO").toString()),
                Integer.valueOf(opcionales.get("MINIMO").toString())
                );
            }
            case "TEXTO":
            {//CAJA DE TEXTO
                /*int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre,
             int maximo,int minimo
                */
                return new ui_cajaTexto(
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                opcionales.get("FUENTE").toString(),
                Integer.valueOf(opcionales.get("TAM").toString()),
                opcionales.get("COLOR").toString(),  
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("NEGRITA").toString()),
                Boolean.valueOf(opcionales.get("CURSIVA").toString()),
                defecto,
                obligatorios.get("NOMBRE").toString(),
                Integer.valueOf(opcionales.get("MAXIMO").toString()),
                Integer.valueOf(opcionales.get("MINIMO").toString())
                );
            }
            default:
            {
                /*(int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre,
             int maximo,int minimo,Array lista) */
                return new ui_desplegable(
                Integer.valueOf(opcionales.get("ALTO").toString()),
                Integer.valueOf(opcionales.get("ANCHO").toString()),
                opcionales.get("FUENTE").toString(),
                Integer.valueOf(opcionales.get("TAM").toString()),
                opcionales.get("COLOR").toString(),  
                Integer.valueOf(obligatorios.get("X").toString()),
                Integer.valueOf(obligatorios.get("Y").toString()),
                Boolean.valueOf(opcionales.get("NEGRITA").toString()),
                Boolean.valueOf(opcionales.get("CURSIVA").toString()),
                defecto,
                obligatorios.get("NOMBRE").toString(),
                Integer.valueOf(opcionales.get("MAXIMO").toString()),
                Integer.valueOf(opcionales.get("MINIMO").toString()),
                        ar
                );
            }
                
        }
    }
    int tryParseInt(String value) {  
     try {  
         
         return  Integer.parseInt(value); 
      } catch (NumberFormatException e) {  
         return 0;  
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
            this.tipo=type;
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
    }
}
