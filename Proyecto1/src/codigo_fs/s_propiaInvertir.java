/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_propiaInvertir implements sent {
    int linea;
     int columna;
     String archivo;
     
     public s_propiaInvertir(int linea,int columna,String archivo)
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
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        if(ts.actual!=null)
        {
            if(ts.actual.tipo.indice!=var.arreglo)
            {
                e.AddError("Solo se pueden invertir arreglos", linea, columna, archivo, "SEMANTICO");
            }else
            {
                 Array a=(Array)ts.actual.valor;
                 LinkedList<Simbolo>valores=new LinkedList();
                 int tam=a.valores.size();
                 for(int i=0;i<tam;i++)
                 {
                     valores.add(a.valores.get(tam-i));
                 }
                 respuesta=new Simbolo(var.tipo_arreglo,new Array(valores));
            }
        }
        return respuesta;
    }
}
