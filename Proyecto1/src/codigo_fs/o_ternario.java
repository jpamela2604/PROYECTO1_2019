/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_ternario implements sent{
     sent cond;
     sent val1;
     sent val2;
     int linea;
     int columna;
     String archivo;
     
     public o_ternario(sent cond,sent val1,sent val2,int linea,int columna,String archivo)
     {
         this.cond=cond;
         this.val1=val1;
         this.val2=val2;
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
        return null;
    }
}