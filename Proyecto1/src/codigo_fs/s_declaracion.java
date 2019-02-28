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
public class s_declaracion implements sent{
    String id;
    sent valor;
    int linea;
    int columna;
    String archivo;
     
     public s_declaracion(String id,sent valor,int linea,int columna,String archivo)
     {
         this.id=id;
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
        if(valor!=null)
        {
            Simbolo val=(Simbolo) valor.ejecutar(ts, e, ej);
            if(val.tipo.indice!=var.error)
            {
                if(val.tipo.indice==var.vacio)
                {
                    e.AddError("La llamada no devuelve un valor "+val.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                }else
                {
                    ts.AgregarSimbolo(new Simbolo(id,val.tipo,Simbolo.variable,val.valor), false, linea, columna, archivo);
                }
            }
        }
        return null;
    }
}
