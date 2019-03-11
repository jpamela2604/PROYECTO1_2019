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
public class s_imprimir implements sent{
     sent valor;
     int linea;
     int columna;
     String archivo;
     
     public s_imprimir(sent valor,int linea,int columna,String archivo)
     {
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
        Simbolo s=(Simbolo) valor.ejecutar(ts, e, ej);
        if(s.tipo.indice!=var.error)
        {
            if(s.tipo.indice==var.vacio)
            {
                e.AddError("Se invoco un metodo vacio", linea, columna, archivo, "SEMANTICO");
            }else if(s.tipo.indice==var.indefinido)
            {
                ej.Imprimir("undefined");
            }
            else if(s.tipo.indice==var.booleano)
            {
                String v=var.valor_false;
                if(Boolean.valueOf(s.valor.toString()))
                {
                    v=var.valor_true;
                }
                ej.Imprimir(v);
            }else if(s.tipo.indice==var.nulo)
            {
                ej.Imprimir("NULO");
            }
            else if(s.tipo.indice==var.arreglo)
            {
                ej.Imprimir("ARREGLO FS");
            }
            else if(s.tipo.indice<4)
            {
                ej.Imprimir(s.valor.toString());
            }else
            {
                ej.Imprimir("OBJETO FS");
            }
        }
        return null;
    }
}
