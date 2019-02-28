/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_cajaTexto;
import execute.ui_contenedor;
import execute.ui_texto;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nCrearCajaTexto implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nCrearCajaTexto(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
            if(parametros.size()!=11)
            {
                e.AddError("El metodo CrearCajaTexto debe tener 11 parametros", linea, columna, archivo, "SEMANTICO");
                return rr;
            } 
            Simbolo alto=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
            Simbolo ancho=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
            Simbolo fuente=(Simbolo) parametros.get(2).ejecutar(ts, e, ej);
            Simbolo tam=(Simbolo) parametros.get(3).ejecutar(ts, e, ej);
            Simbolo color=(Simbolo) parametros.get(4).ejecutar(ts, e, ej);
            Simbolo x=(Simbolo) parametros.get(5).ejecutar(ts, e, ej);
            Simbolo y=(Simbolo) parametros.get(6).ejecutar(ts, e, ej);
            Simbolo negrilla=(Simbolo) parametros.get(7).ejecutar(ts, e, ej);
            Simbolo cursiva=(Simbolo) parametros.get(8).ejecutar(ts, e, ej);
            Simbolo defecto=(Simbolo) parametros.get(9).ejecutar(ts, e, ej);
            Simbolo nombre=(Simbolo) parametros.get(10).ejecutar(ts, e, ej);
            Boolean b=true;
            if(     alto.tipo.indice==var.error||ancho.tipo.indice==var.error||nombre.tipo.indice==var.error||
                    fuente.tipo.indice==var.error||tam.tipo.indice==var.error||color.tipo.indice==var.error
                    ||negrilla.tipo.indice==var.error||x.tipo.indice==var.error||y.tipo.indice==var.error
                    ||cursiva.tipo.indice==var.error||defecto.tipo.indice==var.error)
            {
                b=false;
            }
            
            if(b&&alto.tipo.indice!=var.entero)
            {
                e.AddError("El primer parametro deberia ser tipo entero, no "+fuente.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&ancho.tipo.indice!=var.entero)
            {
                e.AddError("El segundo parametro deberia ser tipo entero, no "+fuente.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }

            if(b&&fuente.tipo.indice!=var.cadena)
            {
                e.AddError("El tercer parametro deberia ser tipo cadena, no "+fuente.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&tam.tipo.indice!=var.entero)
            {
                e.AddError("El cuarto parametro deberia ser tipo entero, no "+tam.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&color.tipo.indice!=var.cadena)
            {
                e.AddError("El quinto parametro deberia ser tipo cadena, no "+color.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }            
            if(b&&x.tipo.indice!=var.entero)
            {
                e.AddError("El sexto parametro deberia ser tipo entero, no "+x.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&y.tipo.indice!=var.entero)
            {
                e.AddError("El septimo parametro deberia ser tipo entero, no "+y.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&negrilla.tipo.indice!=var.booleano)
            {
                e.AddError("El octavo parametro deberia ser tipo booleano, no "+negrilla.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&cursiva.tipo.indice!=var.booleano)
            {
                e.AddError("El noveno parametro deberia ser tipo booleano, no "+cursiva.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&defecto.tipo.indice!=var.cadena)
            {
                e.AddError("El decimo parametro deberia ser tipo cadena, no "+defecto.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&nombre.tipo.indice!=var.cadena)
            {
                e.AddError("El onceavo parametro deberia ser tipo cadena, no "+nombre.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b)
            {
                ui_cajaTexto caja=
                            ej.CrearCajaTexto(
                                    Integer.valueOf(alto.valor.toString()),
                                    Integer.valueOf(ancho.valor.toString()),
                                    fuente.valor.toString(),
                                    Integer.valueOf(tam.valor.toString()),
                                    color.valor.toString(),
                                    Integer.valueOf(x.valor.toString()),
                                    Integer.valueOf(y.valor.toString()),                                    
                                    Boolean.valueOf(negrilla.valor.toString()),
                                    Boolean.valueOf(cursiva.valor.toString()),
                                    defecto.valor.toString(),nombre.valor.toString());
                if(ts.actual!=null)
                {
                    ui_contenedor con=(ui_contenedor) ts.actual.valor;
                    con.cajas.add(caja);
                }
                return new Simbolo(var.tipo_cajatexto,caja);

            }
        }else
        {
                e.AddError("No se puede agregar una caja de texto a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
