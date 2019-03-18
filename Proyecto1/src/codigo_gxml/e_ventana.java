/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import execute.ui_contenedor;
import execute.ui_ventana;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_ventana implements etiqueta{
    LinkedList<etiqueta> contenedores;
    LinkedList<elemento> elementos;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    Hashtable opcionales;
    public e_ventana(LinkedList<elemento> elementos,LinkedList<etiqueta> contenedores,int linea, int columna,String archivo)
    {
        this.contenedores=contenedores;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
        opcionales=new Hashtable();
        opcionales.put("COLOR", Defecto.ver_color);
        opcionales.put("ACCIONINICIAL", "");
        opcionales.put("ACCIONFINAL", "");
    }
    @Override
    public Object GetGxmlObject() {
        //(String id,String tipo,String color,String inicial,String fin)
        ui_ventana ven=new ui_ventana(
        obligatorios.get("ID").toString(),
        obligatorios.get("TIPO").toString(),
        opcionales.get("COLOR").toString(),
        opcionales.get("ACCIONINICIAL").toString(),
        opcionales.get("ACCIONFINAL").toString()
        );
        for(etiqueta eti:this.contenedores)
        {
            ui_contenedor CON=(ui_contenedor)eti.GetGxmlObject();
            ven.contenedores.add(CON);
        }
        
        return ven;
    }
    @Override
    public void Comprobar(mng_error e) {
        String invalidos= "";
        String aux="";
        for(elemento el:this.elementos)
        {
            if(el.tipo==var.id)
            {
                obligatorios.put("ID",el.valor);
            }else if(el.tipo==var.tipo)
            {
                obligatorios.put("TIPO",el.valor);
            }else if(el.tipo==var.color)
            {
                opcionales.put("COLOR",el.valor);
            }else if(el.tipo==var.accionInicial)
            {
                opcionales.put("ACCIONINICIAL",el.valor);
            }
            else if(el.tipo==var.accionFinal)
            {
                opcionales.put("ACCIONFINAL",el.valor);
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
         if(!obligatorios.containsKey("TIPO"))
        {
            missing=missing+aux+"TIPO";aux=",";
        }else
        {
            String type=obligatorios.get("TIPO").toString().toUpperCase();
            if(!(type.equals("SECUNDARIA")
                    ||type.equals("PRIMARIA")||type.equals("PRINCIPAL")))
            {
                e.AddError("El tipo \""+type+"\" no es valido para la etiqueta ventana ", linea, columna, archivo, "SEMANTICO");
            }
        }
        if(!missing.equals(""))
        {
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta ventana", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta ventana ", linea, columna, archivo, "SEMANTICO");
        }
        
        for(etiqueta eti:contenedores)
        {
            eti.Comprobar(e);
        }
    }
}
