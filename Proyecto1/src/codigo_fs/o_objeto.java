/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gdato.item;
import errors.mng_error;
import execute.Ejecucion;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_objeto implements sent{
     LinkedList<o_objetoValor>valores;
     int linea;
     int columna;
     String archivo;
     
     public o_objeto(LinkedList<o_objetoValor>valores,int linea,int columna,String archivo)
     {
         this.valores=valores;
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
        try
        {
        Hashtable vv=new Hashtable();
        for(o_objetoValor s:this.valores)
        {
            Simbolo pp=(Simbolo)s.ejecutar(ts, e, ej);
            if(pp.tipo.indice!=var.error)
            {
                if(pp.tipo.indice==var.vacio)
                {
                    e.AddError("Se llamo a un metodo vacio", linea, columna, archivo, "SEMANTICO");
                    return respuesta;
                }else if(pp.tipo.indice==var.objeto)
                {
                    e.AddError("el valor de un miembro del objeto, no puede ser de tipo objeto", linea, columna, archivo, "SEMANTICO");
                    return respuesta;
                }else
                {
                    if(vv.containsKey(s.clave))
                    {
                        e.AddError("el objeto tiene una clave repetida", linea, columna, archivo, "SEMANTICO");
                        return respuesta;
                    }
                    vv.put(s.clave,new item(s.clave,pp,linea,columna,archivo));
                }
            }else
            {
                return respuesta;
            }
        }
        respuesta=new Simbolo(var.tipo_objeto,new Objeto(vv));
        }catch(Exception exce)
        {
            e.AddError("ERROR: OBJETO", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}