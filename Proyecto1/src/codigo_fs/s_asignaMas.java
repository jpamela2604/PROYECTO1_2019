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
public class s_asignaMas implements sent{
     s_accesos acceso;
     sent valor;
     int linea;
     int columna;
     String archivo;
     
     public s_asignaMas(s_accesos acceso,sent valor,int linea,int columna,String archivo)
     {
         this.acceso=acceso;
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
        oa_suma d=new oa_suma(new o_valorPuntual(null,acceso,linea,columna, archivo),valor,linea,columna, archivo);
        s_asignacion a=new s_asignacion(acceso,d,linea,columna, archivo);
        a.ejecutar(ts, e, ej);
        return null;
    }
}
