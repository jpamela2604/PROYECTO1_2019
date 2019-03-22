/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_detener implements sent {
    int linea;
     int columna;
     String archivo;
     
     public s_detener(int linea,int columna,String archivo)
     {
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
        try
        {
        if(ts.displayBreaks.isEmpty())
        {
            e.AddError("Break fuera de switch", linea, columna, archivo, "SEMANTICO");
        }else
        {
            return new Simbolo(var.tipo_detener,null);
        }
        }catch(Exception exce)
        {
            e.AddError("ERROR:  DETENER", linea, columna, archivo, "SEMANTICO");
        }
        return null;
    }
}
