/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import proyecto1.var;
import ts.NodoTipo;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_valorPuntual implements sent{
     NodoTipo tipo;
     Object valor;
     int linea;
     int columna;
     String archivo;
     
     public o_valorPuntual(NodoTipo tipo,Object valor,int linea,int columna,String archivo)
     {
         this.tipo=tipo;
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
        try{
        if(tipo!=null)
        {
            return new Simbolo(tipo,valor);
        }else
        {
            s_accesos a=(s_accesos) this.valor;
            Simbolo r=(Simbolo)a.ejecutar(ts, e, ej);
            if(r!=null)
            {                
                r=new Simbolo(r.tipo,r.valor);
                if(r.tipo.indice==var.objeto)
                {
                    Objeto o=(Objeto) r.valor;
                    r.valor=o.clone();
                }else if(r.tipo.indice==var.arreglo)
                {
                    Array arrr=(Array)r.valor;
                    r.valor=arrr.clone();
                }
            }
            return r;
        }
        }catch(Exception exce)
        {
            e.AddError("ERROR: VALOR", linea, columna, archivo, "SEMANTICO");
        }
        return new Simbolo(var.tipo_error,null);
    }
}
