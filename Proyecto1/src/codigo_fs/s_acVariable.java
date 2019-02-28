/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gdato.item;
import errors.mng_error;
import execute.Ejecucion;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_acVariable implements sent{
     String id;
     int linea;
     int columna;
     String archivo;
     
     public s_acVariable(String id,int linea,int columna,String archivo)
     {
         this.id=id;
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
        if(ts.actual==null)
        {
            Simbolo r=ts.buscarSimbolo(new Simbolo(id,null,Simbolo.variable,null), linea, columna, archivo);
            if(r!=null)
            {
                respuesta=r;
            }
        }else if(ts.actual.tipo.indice==var.objeto)
        {
            Objeto myObj=(Objeto)ts.actual.valor;
            if(myObj.items.containsKey(id))
            {
                return ((item)myObj.items.get(id)).valor;
            }else
            {
                e.AddError("No existe atributo llamado "+this.id, linea, columna, archivo, "SEMANTICO");
            }
            
        }
        return respuesta;
    }
}
