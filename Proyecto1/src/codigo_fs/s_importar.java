/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gxml.etiqueta;
import codigo_gxml.ruta;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_gxml;
import g_fs.lexico_fs;
import g_fs.sintactico_fs;
import g_gxml.lexico_g;
import g_gxml.sintactico_g;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Stack;
import proyecto1.Manager_Archivo;
import proyecto1.Reconize;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_importar implements sent{
     sent ruta;
     int linea;
     int columna;
     String archivo;
     String path;
     LinkedList<sent> raiz;
     public s_importar(sent ruta,int linea,int columna,String archivo)
     {
         this.ruta=ruta;         
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
         this.raiz=null;
     }
    @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        try{
        ej.deTodo.rutas.add(new ruta(path,linea,columna,archivo));
        Simbolo  s=(Simbolo) this.ruta.ejecutar(ts, e, ej);
        if(s.tipo.indice==var.error)
        {
            return null;
        }else if(s.tipo.indice!=var.cadena)
        {
            e.AddError("El parametro de la ruta del import debe ser una cadena no un "+s.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            return null;
        }
        path=getRutaReal(Reconize.getDireccion(s.valor.toString()),e);
        if(!path.equals("")&&IsValida((Stack) ts.imports.clone()))
        {           
            ts.imports.push(path);
            
            String anterior=var.archivo;
            var.archivo=path;
            gramaticaFS(path, e);
            var.archivo=anterior;
            if(this.raiz!=null)
            {
                for(sent ss:raiz)
                {
                    ss.cargar(ts, e, ej);
                }
            }
            
            ts.imports.pop();
        }else
        {
            this.raiz=null;
            e.AddError("ya se importo el archivo \""+path+"\"", linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR: IMPORTAR ", linea, columna, archivo, "SEMANTICO");
        }
        return null;
    }
    
    String getRutaReal(String ruta, mng_error er)
    {
        mng_error e = new mng_error();
        File a=new File(ruta);
        if(Reconize.getFileExtension(a).toUpperCase().equals("GXML"))
        {
            try
            {
                
                etiqueta root=null;
                String con=Manager_Archivo.getContenido(ruta,false);
                if(con!=null&&!con.equals(""))
                {
                    lexico_g le = new lexico_g(new BufferedReader( new StringReader(con)));            
                    sintactico_g sintactico=new sintactico_g(le);
                    sintactico.parse();            
                    root =sintactico.raiz;
                    e.Adding(le.e);
                    e.Adding(sintactico.e);
                }
                if(root!=null)
                {
                     root.Comprobar(e);
                     if(e.errores.isEmpty())
                     {
                        ui_gxml archivo=(ui_gxml) root.GetGxmlObject();
                        String ruta2=ruta.replace(".gxml", "");
                        ruta2=ruta2+".fs";
                        Reconize.GuardarDatos(ruta2,archivo.getTraduccion("","",0));
                        return ruta2;
                     }
                }else
                {
                    e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
                }
            }catch(Exception ex){

                    System.out.println("ex: "+ex.getMessage());
                    e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }
        }
        er.Adding(e);
        return ruta;
    }
    
    Boolean IsValida(Stack t)
    {
        while(t.size()>0)
        {
            if(t.pop().toString().equals(this.path))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        if(this.raiz!=null)
        {
            for(sent ss:raiz)
            {
                ss.ejecutar(ts, e, ej);
            }
        }
        return null;
    }
    public void gramaticaFS(String ruta,mng_error e)
    {
        LinkedList<sent> raiz = null;        
        try
        {
            String con=Manager_Archivo.getContenido(ruta,false);
            if(con!=null&&!con.equals(""))
            {
                lexico_fs le = new lexico_fs(new BufferedReader( new StringReader(con)));                     
                sintactico_fs sintactico=new sintactico_fs(le);
                sintactico.parse();            
                raiz =sintactico.raiz;
                e.Adding(le.e);
                e.Adding(sintactico.e);
                this.raiz=raiz;
            }else
            {
                e.AddError("No existe/no tiene contenido el archivo: "+ruta, linea, columna, archivo, "SEMANTICO");
            }
            /*if(raiz!=null)
            {
                ts.imports.push(ruta);
                for(sent s:raiz)
                {
                    s.cargar(ts, e, ej);
                }
                for(sent s:raiz)
                {
                    s.ejecutar(ts, e, ej);
                }
                 ts.imports.pop();
            }else
            {
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }*/
        }catch(Exception ex){

                //System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }       
    }
}
