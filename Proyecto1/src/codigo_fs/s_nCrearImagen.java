/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_contenedor;
import execute.ui_imagen;
import java.io.File;
import java.util.LinkedList;
import proyecto1.Reconize;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nCrearImagen implements sent {
    LinkedList<sent> parametros;
    int linea;
     int columna;
     String archivo;
     
     public s_nCrearImagen(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
            if(parametros.size()!=5)
            {
                e.AddError("El metodo CrearImagen debe tener 5 parametros", linea, columna, archivo, "SEMANTICO");
                return rr;
            }   
            Simbolo actual=ts.actual;
            ts.actual=null;
            Simbolo ruta=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);
            Simbolo x=(Simbolo) parametros.get(1).ejecutar(ts, e, ej);
            Simbolo y=(Simbolo) parametros.get(2).ejecutar(ts, e, ej);
            //Simbolo auto=(Simbolo) parametros.get(3).ejecutar(ts, e, ej);
            Simbolo alto=(Simbolo) parametros.get(3).ejecutar(ts, e, ej);
            Simbolo ancho=(Simbolo) parametros.get(4).ejecutar(ts, e, ej);
            ts.actual=actual;
            Boolean b=true;
            if(alto.tipo.indice==var.error||ancho.tipo.indice==var.error/*||auto.tipo.indice==var.error*/
                    ||ruta.tipo.indice==var.error||x.tipo.indice==var.error||y.tipo.indice==var.error){
                b=false;
            }

            if(b&&ruta.tipo.indice!=var.cadena)
            {
                e.AddError("El primer parametro deberia ser tipo cadena, no "+ruta.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&x.tipo.indice!=var.entero)
            {
                e.AddError("El segundo parametro deberia ser tipo entero, no "+x.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&y.tipo.indice!=var.entero)
            {
                e.AddError("El tercer parametro deberia ser tipo entero, no "+y.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }            
            /*if(b&&auto.tipo.indice!=var.booleano)
            {
                e.AddError("El cuarto parametro deberia ser tipo booleano, no "+auto.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }*/
            if(b&&alto.tipo.indice!=var.entero)
            {
                e.AddError("El quinto parametro deberia ser tipo entero, no "+alto.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b&&ancho.tipo.indice!=var.entero)
            {
                e.AddError("El sexto parametro deberia ser tipo entero, no "+ancho.tipo.nombre, linea, columna, archivo, "SEMANTICO");
                b=false;
            }
            if(b)
            {
                String path=ruta.valor.toString();
                if(rutaValida(e,Reconize.getDireccion(path)))
                {
                    ui_imagen imagen=
                                ej.CrearImagen(path,
                                        Integer.valueOf(x.valor.toString()),
                                        Integer.valueOf(y.valor.toString()),
                                        //Boolean.valueOf(auto.valor.toString()),
                                        Integer.valueOf(alto.valor.toString()),                                    
                                        Integer.valueOf(ancho.valor.toString()));
                    if(ts.actual!=null)
                    {
                        ui_contenedor con=(ui_contenedor) ts.actual.valor;
                        con.componentes.add(imagen);
                    }
                    return new Simbolo(var.tipo_imagen,imagen);
                }
            }
        }else
        {
                e.AddError("No se puede agregar una imagen a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR: crearimagen ", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
    Boolean rutaValida(mng_error e,String ruta)
    {
        File file= new File(ruta);
        if(file.exists())
        {
            String extension=Reconize.getFileExtension(file).toUpperCase();
            if(extension.equals("BMP")
              ||extension.equals("JPG")
              ||extension.equals("TPG")
              ||extension.equals("PNG"))
            {
                return true;
            }else
            {
                 e.AddError("La extension del archivo de imagen debe ser bmp,jpg,tpg o png", linea, columna, archivo, "EJECUCION");
            }
        }else
        {
            e.AddError("No existe archivo en la ruta: "+ruta, linea, columna, archivo, "EJECUCION");
           
        }
       
        return false;
    }
    

}
