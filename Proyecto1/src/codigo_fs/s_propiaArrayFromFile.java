/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gdato.item;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ventana;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_propiaArrayFromFile implements sent {
    LinkedList<sent> params;
    int linea;
     int columna;
     String archivo;
     
     public s_propiaArrayFromFile(LinkedList<sent> params,int linea,int columna,String archivo)
     {
         this.params=params;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
     }
    @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        Simbolo rr=new Simbolo(var.tipo_error,null);
        if(ts.actual!=null&&params.isEmpty())
        {
            if(ts.actual.tipo.indice==var.ventana)
            {
                ui_ventana ven=(ui_ventana)ts.actual.valor;
                LinkedList<item> valores=ven.getValores();
                String cadena="    <principal>\n";
                for(item i:valores)
                {
                    cadena=cadena+"        <"+i.clave+">"+i.valor.toString()+"</"+i.clave+">\n";
                }
                cadena=cadena+"    </principal>\n";
                System.out.println(cadena);
                ej.GuardarDatos(((Simbolo)ven.tabla.get("ID")).valor.toString(),cadena);
                return new Simbolo(var.tipo_vacio,null);            
            }else
            {
                e.AddError("No se pueden guardar valores de un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }
        }
        else if(ts.actual==null&&params.isEmpty())
        {
            e.AddError("no hay ventana de la cual obtener valores", linea, columna, archivo, "SEMANTICO");
        }
        else if(ts.actual==null)
        {
            if(params.size()!=1)
            {
                e.AddError("el metodo solo tiene un parametro", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo actual=ts.actual;
                ts.actual=null;                    
                Simbolo a=(Simbolo) params.get(0).ejecutar(ts, e, ej);
                if(a.tipo.indice!=var.error)
                {
                    if(a.tipo.indice!=var.cadena)
                    {
                        e.AddError("el parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        //ejecuta la accion

                    }

                }
                ts.actual=actual;
            }
        }else
        {
             e.AddError("el metodo no puede ser aplicado a ningun elemento", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
