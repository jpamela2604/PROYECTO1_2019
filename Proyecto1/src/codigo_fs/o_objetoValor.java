/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_objetoValor implements sent{
     String clave;
     sent valor;
     int linea;
     int columna;
     String archivo;
     
     public o_objetoValor(String clave,sent valor,int linea,int columna,String archivo)
     {
         this.clave=clave;
         this.valor=valor;
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
        
        return (Simbolo)this.valor.ejecutar(ts, e, ej);
    }
}
