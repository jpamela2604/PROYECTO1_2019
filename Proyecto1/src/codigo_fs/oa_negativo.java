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
public class oa_negativo implements sent{
     sent op1;
     int linea;
     int columna;
     String archivo;
     
     public oa_negativo(sent op1,int linea,int columna,String archivo)
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
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        Simbolo o1=(Simbolo) op1.ejecutar(ts, e, ej);
        if(respuesta.tipo.indice==var.error)
        {
            return respuesta;
        }
        if(o1.tipo.indice==var.entero)
        {
            Double a=Double.valueOf(o1.valor.toString())*-1;
            o1.valor=a.intValue();
            return o1;
        }
        else if(o1.tipo.indice==var.decimal)
        {
            Double a=Double.valueOf(o1.valor.toString())*-1;
            return o1;
        }else
        {
            e.AddError("Tipos incompatibles: tratar de volver negativo un valor de tipo "+o1.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}
