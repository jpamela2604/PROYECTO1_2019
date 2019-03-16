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
public class s_nObtenerNombre implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nObtenerNombre(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
    if(ts.actual==null)
    {
        e.AddError("No se elemento sobre el cual aplicar el metodo", linea, columna, archivo, "SEMANTICO");
        return rr;
    }else if(ts.actual.tipo!=var.tipo_gxml)
    {
        e.AddError("El metodo ObtenerPorNombre solo se puee aplicar sobre objetos GXML", linea, columna, archivo, "SEMANTICO");
        return rr;
    }
        if(parametros.size()!=2)
            {
                e.AddError("el metodo tiene dos parametros", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo actual=ts.actual;
                ts.actual=null;                    
                Simbolo id=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
                Simbolo ventana=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
                ts.actual=actual;
                if(id.tipo.indice!=var.error||ventana.tipo.indice!=var.error)
                {
                    if(id.tipo.indice!=var.cadena)
                    {
                        e.AddError("el primer parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else if(ventana.tipo.indice!=var.cadena)
                    {
                        e.AddError("el segundo parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        ui_gxml myfile =(ui_gxml) ts.actual.valor;
                        LinkedList<Simbolo> valores=new LinkedList();
                        myfile.getByNombre(ventana.valor.toString().toUpperCase().trim(),
                                id.valor.toString().toUpperCase().trim(),valores);
                        Array nuevo=new Array(valores);
                        rr=new Simbolo(var.tipo_arreglo,nuevo);                                
                        
                    }

                }
            }
        return rr;
    }
}
