/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import proyecto1.var;
import ts.NodoTipo;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_propiaMinimo implements sent {
    int linea;
     int columna;
     String archivo;
     
     public s_propiaMinimo(int linea,int columna,String archivo)
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
        try{
        if(ts.actual!=null)
        {
            if(ts.actual.tipo.indice!=var.arreglo)
            {
                e.AddError("El metodo propio \"Minimo\" solo se pueden utilizar con arreglos", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Array a=(Array)ts.actual.valor;
                NodoTipo tipo=a.getTipo();
                if(tipo.indice==var.heterogenea)
                {
                    e.AddError("El metodo propio \"Minimo\" solo se puede aplicar en arreglos homogeneos", linea, columna, archivo, "SEMANTICO");
                }else if(tipo.indice==var.decimal)
                {
                    Double valor=Double.valueOf(a.valores.get(0).valor.toString());
                    
                    for(int i=1;i<a.valores.size();i++)
                    {
                        Double vv=Double.valueOf(a.valores.get(i).valor.toString());
                        if(vv<valor)
                        {
                            valor=vv;
                        }
                    }
                    return new Simbolo(tipo,valor);
                    
                }else if(tipo.indice==var.entero)
                {
                    Integer valor=Integer.valueOf(a.valores.get(0).valor.toString());
                    
                    for(int i=1;i<a.valores.size();i++)
                    {
                        Integer vv=Integer.valueOf(a.valores.get(i).valor.toString());
                        if(vv<valor)
                        {
                            valor=vv;
                        }
                    }
                    return new Simbolo(tipo,valor);
                }else
                {
                    e.AddError("El metodo propio \"Minimo\" no se puede aplicar en arreglos de tipo "+tipo.nombre, linea, columna, archivo, "SEMANTICO");
                }
            }
        
        }else
        {
            e.AddError("No hay arreglo en el cual aplicar la funcion minimo", linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR: minimo ", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}