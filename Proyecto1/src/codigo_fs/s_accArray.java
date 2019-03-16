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
public class s_accArray implements sent{
     String id;
     sent valor;
     int linea;
     int columna;
     String archivo;
     
     public s_accArray(String id,sent valor,int linea,int columna,String archivo)
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
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        Simbolo pos=(Simbolo) valor.ejecutar(ts, e, ej);
        if(pos.tipo.indice==var.error)
        {
            return respuesta;
        }else if(pos.tipo.indice!=var.entero)
        {
            e.AddError("La posicion de un arreglo debe ser de tipo entero, no "+pos.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            return respuesta;
        }
        if(ts.actual==null)
        {
            Simbolo r=ts.buscarSimbolo(new Simbolo(id,null,Simbolo.variable,null), linea, columna, archivo);
            if(r!=null)
            {
                Array ar=(Array) r.valor;
                Integer posi=Integer.valueOf(pos.valor.toString());
                if(posi>=ar.valores.size()||posi<0)
                {
                    e.AddError("Indice fuera de los limites", linea, columna, archivo, "EJECUCION");
                    return respuesta;
                }else
                {
                    return ar.valores.get(posi);
                }
            }
        }else if(ts.actual.tipo.indice==var.objeto)
        {
            Simbolo r=null;
            Objeto myObj=(Objeto)ts.actual.valor;
            if(myObj.items.containsKey(id))
            {
                r= (Simbolo) ((item)myObj.items.get(id)).valor;
                if(r.tipo.indice==var.arreglo)
                {
                    Array ar=(Array) r.valor;
                    Integer posi=Integer.valueOf(pos.valor.toString());
                    if(posi>=ar.valores.size()||posi<0)
                    {
                        e.AddError("Indice fuera de los limites", linea, columna, archivo, "EJECUCION");
                        return respuesta;
                    }else
                    {
                        return ar.valores.get(posi);
                    } 
                }else
                {
                    e.AddError("El atributo "+this.id+" no es de tipo arreglo", linea, columna, archivo, "SEMANTICO");
                }
            }else
            {
                e.AddError("No existe atributo llamado "+this.id, linea, columna, archivo, "SEMANTICO");
            }            
            
        }else
        {
            e.AddError("No hay arreglo que se pueda indexar", linea, columna, archivo, "EJECUCION");
        }
            
        return respuesta;
    }
}
