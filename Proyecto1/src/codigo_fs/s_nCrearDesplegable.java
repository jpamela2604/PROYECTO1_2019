/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_contenedor;
import execute.ui_desplegable;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nCrearDesplegable implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nCrearDesplegable(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
        if(ts.actual==null||ts.actual.tipo.indice==var.contenedor)
        {
            if(parametros.size()!=7)
            {
                e.AddError("El metodo CrearDesplegable debe tener 7 parametros", linea, columna, archivo, "SEMANTICO");
                return rr;
            } 
            Simbolo actual=ts.actual;
            ts.actual=null;
            Simbolo alto=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
            Simbolo ancho=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
            Simbolo lista=(Simbolo) parametros.get(2).ejecutar(ts, e, ej);
            Simbolo x=(Simbolo) parametros.get(3).ejecutar(ts, e, ej);
            Simbolo y=(Simbolo) parametros.get(4).ejecutar(ts, e, ej);
            Simbolo defecto=(Simbolo) parametros.get(5).ejecutar(ts, e, ej);
            Simbolo nombre=(Simbolo) parametros.get(6).ejecutar(ts, e, ej);
            ts.actual=actual;
            Boolean b=true;
            if(     alto.tipo.indice==var.error||ancho.tipo.indice==var.error||nombre.tipo.indice==var.error||
                    lista.tipo.indice==var.error||x.tipo.indice==var.error||y.tipo.indice==var.error
                    ||defecto.tipo.indice==var.error)
            {
                b=false;
            }
            
            if(b&&alto.tipo.indice!=var.entero)
            {
                e.AddError("El primer parametro deberia ser tipo entero, no "+alto.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&ancho.tipo.indice!=var.entero)
            {
                e.AddError("El segundo parametro deberia ser tipo cadena, no "+ancho.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }

            if(b&&lista.tipo.indice!=var.arreglo)
            {
                e.AddError("El tercer parametro deberia ser tipo arreglo, no "+lista.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&x.tipo.indice!=var.entero)
            {
                e.AddError("El cuarto parametro deberia ser tipo entero, no "+x.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&y.tipo.indice!=var.entero)
            {
                e.AddError("El quinto parametro deberia ser tipo entero, no "+y.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }            
            if(b&&defecto.tipo.indice!=var.cadena)
            {
                e.AddError("El sexto parametro deberia ser tipo cadena, no "+defecto.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&nombre.tipo.indice!=var.cadena)
            {
                e.AddError("El septimo parametro deberia ser tipo cadena, no "+nombre.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b)
            {
                ui_desplegable des=
                            ej.CrearDesplegable(
                                    Integer.valueOf(alto.valor.toString()),
                                    Integer.valueOf(ancho.valor.toString()),
                                    (Array)lista.valor,
                                    Integer.valueOf(x.valor.toString()),
                                    Integer.valueOf(y.valor.toString()),  
                                    defecto.valor.toString(),nombre.valor.toString());
                if(ts.actual!=null)
                {
                    ui_contenedor con=(ui_contenedor) ts.actual.valor;
                    con.componentes.add(des);
                }
                return new Simbolo(var.tipo_desplegable,des);

            }
        }else
        {
                e.AddError("No se puede agregar un desplegable a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR:  crear desplegable", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
