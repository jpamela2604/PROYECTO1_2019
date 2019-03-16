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
public class s_funcionalAlgunos implements sent {
    String id;
    int linea;
     int columna;
     String archivo;
     
     public s_funcionalAlgunos(String id,int linea,int columna,String archivo)
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
        if(ts.actual!=null)
        {
            if(ts.actual.tipo.indice!=var.arreglo)
            {
                e.AddError("Solo se puede usar la funcion \"ALGUNO\" con arreglos", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo m=new Simbolo(id+"#",null,Simbolo.metodo,null);
                m=ts.buscarSimbolo(m, linea, columna, archivo);
                if(m!=null)
                {
                    if(m.parametros.size()!=1)
                    {
                         e.AddError("El metodo que se invoca en la funcion \"ALGUNO\" debe tener un parametro", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        //si va a ejecutar
                        return alguno( ts,  e,  ej, m);
                    }
                }/*else
                {
                    e.AddError("No existe metodo llamado \""+this.id+"\"", linea, columna, archivo, "SEMANTICO");
                }*/
            }
        }else
        {
            e.AddError("No hay arreglo al que se le pueda aplicar la funcion \"ALGUNO\"", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
    public Object alguno(mng_ts ts, mng_error e, Ejecucion ej,Simbolo funcion)
    {
        Simbolo respuesta=new Simbolo(var.tipo_booleano,false);
        Array a=(Array)ts.actual.valor;
        for(Simbolo s:a.valores)
        {
            ts.cambiarAmbito(true);
            ts.displayReturns.push("");
            Simbolo actual=ts.actual;
            ts.actual=null;
            //declarar parametro
            ts.AgregarSimbolo(new Simbolo(funcion.parametros.get(0),s.tipo,Simbolo.variable,s.valor), false, linea, columna, archivo);
            //ejecutar sentencias
            Simbolo retorno=null;
            for(sent sen:funcion.sentencias)
            {
                retorno=(Simbolo) sen.ejecutar(ts, e, ej);
                if(retorno!=null)
                {
                    break;
                }
            }
            ts.regresarAmbito(true);
            ts.displayReturns.pop();
            ts.actual=actual;
            if(retorno==null||retorno.tipo.indice!=var.booleano)
            {
            }else
            {
                if(Boolean.valueOf(retorno.valor.toString()))
                {
                    respuesta=new Simbolo(var.tipo_booleano,true);
                    break;
                }
            }
        }        
        return respuesta;
    }
}
