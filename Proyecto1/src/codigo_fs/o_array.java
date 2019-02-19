/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
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
        return null;
    }
}
