/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_bloque implements sent {
    int linea;
     int columna;
     String archivo;
     sent cond;
     LinkedList<sent> sentencias;
     
     public s_bloque(sent cond,LinkedList<sent> sentencias,int linea,int columna,String archivo)
     {
         this.cond=cond;
         this.sentencias=sentencias;
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
        ts.cambiarAmbito(false);
        for(sent s:sentencias)
        {
            Simbolo p=(Simbolo) s.ejecutar(ts, e, ej);
            if(p!=null)
            {
                ts.regresarAmbito(false);
                return p;
            }
        }
        ts.regresarAmbito(false);
        return null;
    }
}