/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_gxml;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nObtenerEtiqueta implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nObtenerEtiqueta(LinkedList<sent> parametros,int linea,int columna,String archivo)
     {
         this.parametros=parametros;
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
        Simbolo rr=new Simbolo(var.tipo_error,null);
        try{
    if(ts.actual==null)
    {
        e.AddError("No hay elemento sobre el cual aplicar el metodo obtenerPorEtiqueta", linea, columna, archivo, "SEMANTICO");
        return rr;
    }else if(ts.actual.tipo!=var.tipo_gxml)
    {
        e.AddError("El metodo ObtenerPorEtiqueta solo se puee aplicar sobre objetos GXML", linea, columna, archivo, "SEMANTICO");
        return rr;
    }
        if(parametros.size()!=1)
            {
                e.AddError("el metodo solo tiene un parametro", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo actual=ts.actual;
                ts.actual=null;                    
                Simbolo a=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
                ts.actual=actual;
                if(a.tipo.indice!=var.error)
                {
                    if(a.tipo.indice!=var.cadena)
                    {
                        e.AddError("el parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        ui_gxml myfile =(ui_gxml) ts.actual.valor;
                        LinkedList<Simbolo> valores=new LinkedList();
                        myfile.getByTag(a.valor.toString().toUpperCase().trim(),valores);
                        Array nuevo=new Array(valores);
                        rr=new Simbolo(var.tipo_arreglo,nuevo);                                
                        
                    }

                }
            }
        }catch(Exception exce)
        {
            e.AddError("ERROR: obtener por etiqueta ", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
