/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_funcion implements sent{
    /*agregar las propias,funcionales y nativas para que no se repita*/
    public String nombre;
    LinkedList<String> parametros;
    LinkedList<sent> sentencias;
    int linea;
     int columna;
     String archivo;
     
     public s_funcion(String nombre,LinkedList<String> parametros,LinkedList<sent> sentencias,int linea,int columna,String archivo)
     {
         this.nombre=nombre;
         this.parametros=parametros;
         this.sentencias=sentencias;
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
        Simbolo fun=new Simbolo(this.nombre+"#",this.parametros,this.sentencias);
        ts.AgregarSimbolo(fun, true, linea, columna, archivo);
        return null;
    }
}
