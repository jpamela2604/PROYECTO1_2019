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
public class o_relacional implements sent{
     sent op1;
     sent op2;
     int linea;
     int columna;
     String archivo;
     String oprel;
     
     public o_relacional(sent op1,sent op2,String oprel,int linea,int columna,String archivo)
     {
         this.op1=op1;
         this.op2=op2;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
         this.oprel=oprel;
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
