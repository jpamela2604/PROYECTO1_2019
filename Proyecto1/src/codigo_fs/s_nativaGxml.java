/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gxml.etiqueta;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_gxml;
import g_gxml.lexico_g;
import g_gxml.sintactico_g;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import proyecto1.Reconize;
import static proyecto1.Manager_Archivo.getContenido;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nativaGxml implements sent {
    LinkedList<sent> ruta;
    int linea;
     int columna;
     String archivo;
     
     public s_nativaGxml(LinkedList<sent> ruta,int linea,int columna,String archivo)
     {
         this.ruta=ruta;
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
        if(ruta.size()!=1)
            {
                e.AddError("el metodo solo tiene un parametro", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo actual=ts.actual;
                ts.actual=null;                    
                Simbolo a=(Simbolo) ruta.get(0).ejecutar(ts, e, ej);
                //ts.actual=actual;
                if(a.tipo.indice!=var.error)
                {
                    if(a.tipo.indice!=var.cadena)
                    {
                        e.AddError("el parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        rr=new Simbolo(var.tipo_nulo,null);
                        //ejecuta la accion
                        String anterior=var.archivo;
                        var.archivo=a.valor.toString();
                        ui_gxml miarc= gramaticaGxml(Reconize.getDireccion(a.valor.toString()),e);
                        var.archivo=anterior;
                        if(miarc!=null)
                        {
                            rr=new Simbolo(var.tipo_gxml,miarc);
                        }                        
                    }
                }
            }
        return rr;
    }
    
    
    public ui_gxml gramaticaGxml(String ruta, mng_error e)
    {
        etiqueta raiz = null;        
        try
        {
            String con=getContenido(ruta,false);
            if(con!=null&&!con.equals(""))
            {
                lexico_g le = new lexico_g(new BufferedReader( new StringReader(con)));            
                sintactico_g sintactico=new sintactico_g(le);
                sintactico.parse();            
                raiz =sintactico.raiz;
                e.Adding(le.e);
                e.Adding(sintactico.e);
                if(raiz!=null)
                {
                     raiz.Comprobar(e);
                     if(e.errores.isEmpty())
                     {
                        ui_gxml migxml=(ui_gxml) raiz.GetGxmlObject();
                        return migxml;

                     }
                }
            }
                
            
        }catch(Exception ex){

                //System.out.println("ex: "+ex.getMessage());
                //e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
        return null;
    }
}

