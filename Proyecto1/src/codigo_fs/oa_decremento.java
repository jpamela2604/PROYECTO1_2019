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
public class oa_decremento implements sent{
     s_accesos op1;
     int linea;
     int columna;
     String archivo;
     
     public oa_decremento(s_accesos op1,int linea,int columna,String archivo)
     {
         this.op1=op1;
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
