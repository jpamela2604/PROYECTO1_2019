/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import java.util.Objects;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_switch implements sent{
    /*no se muy bien como funciona el switch*/
    /*linea 59*/
    public sent valor;
    public LinkedList<s_bloque> casos;
     int linea;
     int columna;
     String archivo;
     public s_switch(sent valor,s_bloque caso,int linea,int columna,String archivo)
     {
         this.valor=valor;
         this.casos=new LinkedList();
         this.casos.add(caso);
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
        Simbolo v=(Simbolo) valor.ejecutar(ts, e, ej);
        if(v.tipo.indice>3)
        {
            e.AddError(archivo, linea, columna, archivo, "SEMANTICO");
        }
        if(v.tipo.indice!=var.error)
        {
            Boolean bandera=false;
            for(s_bloque s:casos)
            {
                if(!bandera)
                {
                    if(s.cond!=null)
                    {
                        Simbolo p=(Simbolo) s.cond.ejecutar(ts, e, ej);
                        if(p.tipo.indice==var.error)
                        {
                            return null;
                        }else if(p.tipo.indice!=v.tipo.indice)
                        {

                        }else
                        {
                            if(EsIgual(v,p))
                            {
                                bandera=true;
                                Simbolo h=(Simbolo) s.ejecutar(ts, e, ej);
                                if(h!=null)
                                {
                                    if(h.tipo.indice==var.detener)
                                    {
                                        return null;
                                    }else
                                    {
                                        return h;
                                    }
                                }
                            }
                        }

                    }else
                    {
                        Simbolo h=(Simbolo) s.ejecutar(ts, e, ej);
                        if(h!=null)
                        {
                            if(h.tipo.indice==var.detener)
                            {
                                return null;
                            }else
                            {
                                return h;
                            }
                        }
                    }
                }else
                {
                    Simbolo h=(Simbolo) s.ejecutar(ts, e, ej);
                    if(h!=null)
                    {
                        if(h.tipo.indice==var.detener)
                        {
                            return null;
                        }else
                        {
                            return h;
                        }
                    }
                }
            }
        }
        return null;
    }
    public Boolean EsIgual(Simbolo a,Simbolo b)
    {
        if(a.tipo.indice==b.tipo.indice)
        {
            if(a.tipo.indice==var.booleano||a.tipo.indice==var.cadena)
            {
                if(a.valor.toString().equals(b.valor.toString()))
                {
                    return true;
                }
                if(Objects.equals(Double.valueOf(a.valor.toString()), Double.valueOf(b.valor.toString())))
                {
                    return true;
                }
                        
            }
        }
        return false;
    }
}


