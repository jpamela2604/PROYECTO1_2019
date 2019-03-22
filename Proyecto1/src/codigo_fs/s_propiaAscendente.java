/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.Collections;
import java.util.LinkedList;
import proyecto1.var;
import ts.NodoTipo;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_propiaAscendente implements sent {
    int linea;
     int columna;
     String archivo;
     
     public s_propiaAscendente(int linea,int columna,String archivo)
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
                e.AddError("Solo se pueden ordenar arreglos", linea, columna, archivo, "SEMANTICO");
            }else
            {
                LinkedList<Simbolo>valores=new  LinkedList();
                Array a=(Array)ts.actual.valor;
                NodoTipo tipo=a.getTipo();
                
                if(tipo.indice==var.heterogenea)
                {
                    e.AddError("Solo se pueden ordenar arreglos heterogeneos", linea, columna, archivo, "SEMANTICO");
                }else if(tipo.indice==var.decimal)
                {
                    LinkedList<Double> nueva=new LinkedList();
                    a.valores.forEach((sim) -> {
                        nueva.add(Double.valueOf(sim.valor.toString()));
                    });
                    Collections.sort(nueva);
                  
                    nueva.forEach((ou) -> {
                        valores.add(new Simbolo(tipo,ou));
                    });
                    a.valores=valores;
                    respuesta=ts.actual;
                    
                }else if(tipo.indice==var.entero)
                {
                    LinkedList<Integer> nueva=new LinkedList();
                    a.valores.forEach((sim) -> {
                        nueva.add(Integer.valueOf(sim.valor.toString()));
                    });
                    Collections.sort(nueva);
                    nueva.forEach((ou) -> {
                        valores.add(new Simbolo(tipo,ou));
                    });
                    a.valores=valores;
                    respuesta=ts.actual;
                }else if(tipo.indice==var.cadena)
                {
                    LinkedList<String> nueva=new LinkedList();
                    a.valores.forEach((sim) -> {
                        nueva.add(sim.valor.toString());
                    });
                    Collections.sort(nueva);
                    nueva.forEach((ou) -> {
                        valores.add(new Simbolo(tipo,ou));
                    });
                    a.valores=valores;
                    respuesta=ts.actual;
                }else
                {
                    e.AddError("No se pueden ordenar arreglos de tipo "+tipo.nombre , linea, columna, archivo, "SEMANTICO");
                }
                //respuesta=new Simbolo(var.tipo_arreglo,new Array(valores));
            }
        }else
        {
            e.AddError("No hay arreglo que ordenar", linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR: ascendente ", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}