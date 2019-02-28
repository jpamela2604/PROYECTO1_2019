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
public class s_nCrearVentana implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nCrearVentana(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
        if(parametros.size()!=3)
        {
            e.AddError("El metodo CrearVentana debe tener 3 parametros", linea, columna, archivo, "SEMANTICO");
            return rr;
        }
        Simbolo t=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
        Simbolo l=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
        Simbolo n=(Simbolo) parametros.get(2).ejecutar(ts, e, ej);
        Boolean b=true;
        if(t.tipo.indice==var.error||l.tipo.indice==var.error||n.tipo.indice==var.error)
        {
            b=false;
        }
        
        if(b&&t.tipo.indice!=var.cadena)
        {
            e.AddError("El primer parametro deberia ser tipo cadena, no "+t.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            b=false;
        }
        if(b&&l.tipo.indice!=var.entero)
        {
            e.AddError("El segundo parametro deberia ser tipo entero, no "+l.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            b=false;
        }
        if(b&&n.tipo.indice!=var.entero)
        {
            e.AddError("El tercer parametro deberia ser tipo entero, no "+n.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            b=false;
        }
        if(b)
        {
            if(ts.actual==null)
            {
                return new Simbolo(var.tipo_ventana,ej.CrearVentana(t.valor.toString()
                        ,Integer.valueOf(l.valor.toString()),Integer.valueOf(n.valor.toString())));
            }else
            {
                e.AddError("No se puede agregar una ventana a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }
        }
        return rr;
    }
}
