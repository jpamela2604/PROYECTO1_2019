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
public class s_if implements sent{
    public LinkedList<s_bloque> bloques;
     
     public s_if(s_bloque bloque)
     {
         this.bloques=new LinkedList();
         this.bloques.add(bloque);
     }
    @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        Boolean bandera=false;
        for(s_bloque s:bloques)
        {
            if(s.cond!=null)
            {
                Simbolo p=(Simbolo) s.cond.ejecutar(ts, e, ej);
                if(p.tipo.indice==var.error)
                {
                    break;
                }else if(p.tipo.indice!=var.booleano)
                {
                    e.AddError("Tipos incompatibles: la condicion del if no puede ser tipo"+p.tipo.nombre, s.linea, s.columna, s.archivo, "SEMANTICO");           
                    break;
                }else
                {
                    if(Boolean.valueOf(p.valor.toString()))
                    {
                        Simbolo retorno=(Simbolo) s.ejecutar(ts, e, ej);
                        if(retorno!=null)
                        {
                            return retorno;
                        }
                    }
                }
            }else
            {
                Simbolo retorno=(Simbolo) s.ejecutar(ts, e, ej);
                if(retorno!=null)
                {
                    return retorno;
                }
            }
        }            
        return null;
    }
}
