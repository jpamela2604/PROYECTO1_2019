/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_contenedor;
import execute.ui_texto;
import execute.ui_ventana;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nCrearTexto implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nCrearTexto(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
        if(ts.actual==null||ts.actual.tipo.indice==var.contenedor)
        {
            if(parametros.size()!=8)
            {
                e.AddError("El metodo CrearTexto debe tener 8 parametros", linea, columna, archivo, "SEMANTICO");
                return rr;
            }   
            Simbolo actual=ts.actual;
            ts.actual=null;
            Simbolo fuente=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
            Simbolo tam=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
            Simbolo color=(Simbolo) parametros.get(2).ejecutar(ts, e, ej);
            Simbolo x=(Simbolo) parametros.get(3).ejecutar(ts, e, ej);
            Simbolo y=(Simbolo) parametros.get(4).ejecutar(ts, e, ej);
            Simbolo negrilla=(Simbolo) parametros.get(5).ejecutar(ts, e, ej);
            Simbolo cursiva=(Simbolo) parametros.get(6).ejecutar(ts, e, ej);
            Simbolo valor=(Simbolo) parametros.get(7).ejecutar(ts, e, ej);
            Boolean b=true;
            ts.actual=actual;
            if(fuente.tipo.indice==var.error||tam.tipo.indice==var.error||color.tipo.indice==var.error
                    ||negrilla.tipo.indice==var.error||x.tipo.indice==var.error||y.tipo.indice==var.error
                    ||cursiva.tipo.indice==var.error||valor.tipo.indice==var.error)
            {
                b=false;
            }

            if(b&&fuente.tipo.indice!=var.cadena)
            {
                e.AddError("El primer parametro deberia ser tipo cadena, no "+fuente.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&tam.tipo.indice!=var.entero)
            {
                e.AddError("El segundo parametro deberia ser tipo entero, no "+tam.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&color.tipo.indice!=var.cadena)
            {
                e.AddError("El tercer parametro deberia ser tipo cadena, no "+color.tipo.nombre, linea, columna, archivo, "SEMANTICO");
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
            if(b&&negrilla.tipo.indice!=var.booleano)
            {
                e.AddError("El sexto parametro deberia ser tipo booleano, no "+negrilla.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&cursiva.tipo.indice!=var.booleano)
            {
                e.AddError("El septimo parametro deberia ser tipo booleano, no "+cursiva.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&valor.tipo.indice!=var.cadena)
            {
                e.AddError("El octavo parametro deberia ser tipo cadena, no "+valor.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b)
            {
                ui_texto texto=
                            ej.CrearTexto(fuente.valor.toString(),
                                    Integer.valueOf(tam.valor.toString()),
                                    color.valor.toString(),
                                    Integer.valueOf(x.valor.toString()),
                                    Integer.valueOf(y.valor.toString()),                                    
                                    Boolean.valueOf(negrilla.valor.toString()),
                                    Boolean.valueOf(cursiva.valor.toString()),
                                    valor.valor.toString());
                if(ts.actual!=null)
                {
                    ui_contenedor con=(ui_contenedor) ts.actual.valor;
                    con.componentes.add(texto);
                }
                return new Simbolo(var.tipo_texto,texto);

            }
        }else
        {
                e.AddError("No se puede agregar una texto a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
