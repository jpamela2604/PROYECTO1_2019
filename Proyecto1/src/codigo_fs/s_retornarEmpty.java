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
public class s_retornarEmpty implements sent {
     int linea;
     int columna;
     String archivo;
     
     public s_retornarEmpty(int linea,int columna,String archivo)
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
        try{
        if(ts.displayReturns.isEmpty())
        {
            e.AddError("Retorno fuera de metodo", linea, columna, archivo, "SEMANTICO");
        }else
        {
            return new Simbolo(var.tipo_vacio,null);
        }}catch(Exception exce)
        {
            e.AddError("ERROR:  retornar", linea, columna, archivo, "SEMANTICO");
        }
        return null;
    }
}
