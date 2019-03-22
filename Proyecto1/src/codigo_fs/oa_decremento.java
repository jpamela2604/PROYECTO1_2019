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
public class oa_decremento implements sent{
     s_accesos acceso;
     int linea;
     int columna;
     String archivo;
     public Boolean noRetorna;
     
     public oa_decremento(s_accesos acceso,int linea,int columna,String archivo)
     {
         this.acceso=acceso;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
         this.noRetorna=false;
     }
     @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        
        Simbolo h=new Simbolo(var.tipo_error,null);
        try
        {
            Simbolo s=(Simbolo) acceso.ejecutar(ts, e, ej);
        if(s.tipo.indice==var.error)
        {
        }else if(s.tipo.indice==var.entero)
        {
            h=new Simbolo(s.tipo,s.valor);
            s.valor=Integer.valueOf(s.valor.toString())-1;
            
        }else if(s.tipo.indice==var.decimal)
        {
            h=new Simbolo(s.tipo,s.valor);
            s.valor=Double.valueOf(s.valor.toString())-1;
        }else
        {
            e.AddError("Tipos incompatibles: operacion unaria decremento con valor tipo " +s.tipo.nombre, linea, columna, archivo, "SEMANTICO"); 
            //s=new Simbolo(var.tipo_error,null);
        }
        if(this.noRetorna)
        {
            return null;
        }
        }catch(Exception exce)
        {
            e.AddError("ERROR: DECREMENTO ", linea, columna, archivo, "SEMANTICO");
        }
        return h;
    }
}
