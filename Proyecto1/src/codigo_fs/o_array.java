/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_array implements sent{
     LinkedList <sent> valores;
     int linea;
     int columna;
     String archivo;
     
     public o_array(LinkedList <sent> valores,int linea,int columna,String archivo)
     {
         this.valores=valores;
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
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        try
        {
        LinkedList<Simbolo> val=new LinkedList();
        for(sent s:valores)
        {
            Simbolo p=(Simbolo) s.ejecutar(ts, e, ej);
            if(p.tipo.indice==var.error)
            {
                return respuesta;
            }else if(p.tipo.indice==var.vacio)
            {
                e.AddError("Uno de los valores invoco a un metodo que no devuelve valor", linea, columna, archivo, "SEMANTICO");
                return respuesta;
            }else
            {
                val.add(p);
            }
                
        }
        Array ar=new Array(val);
        respuesta=new Simbolo(var.tipo_arreglo,ar);
        }catch(Exception exce)
        {
            e.AddError("ERROR: ARREGLO", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}
