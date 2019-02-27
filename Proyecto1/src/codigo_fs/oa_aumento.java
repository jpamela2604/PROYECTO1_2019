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
public class oa_aumento implements sent{
     s_accesos acceso;
     int linea;
     int columna;
     String archivo;
     
     public oa_aumento(s_accesos acceso,int linea,int columna,String archivo)
     {
         this.acceso=acceso;
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
        Simbolo s=(Simbolo) acceso.ejecutar(ts, e, ej);
        if(s.tipo.indice==var.entero)
        {
            s.valor=Integer.valueOf(s.valor.toString())+1;
        }else if(s.tipo.indice==var.decimal)
        {
            s.valor=Double.valueOf(s.valor.toString())+1;
        }else
        {
            e.AddError("Tipos incompatibles: operacion unaria aumento"+s.tipo.nombre, linea, columna, archivo, "SEMANTICO"); 
        }
        return null;
    }
}
