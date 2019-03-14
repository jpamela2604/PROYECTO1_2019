/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gdato.FileArray;
import codigo_gdato.item;
import codigo_gdato.tupla;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ventana;
import g_datos.lexico_d;
import g_datos.sintactico_d;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.ExtremeEditor;
import proyecto1.Reconize;
import static proyecto1.Reconize.getContenido;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_propiaArrayFromFile implements sent {
    LinkedList<sent> params;
    int linea;
     int columna;
     String archivo;
     
     public s_propiaArrayFromFile(LinkedList<sent> params,int linea,int columna,String archivo)
     {
         this.params=params;
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
        if(ts.actual!=null&&params.isEmpty())
        {
            if(ts.actual.tipo.indice==var.ventana)
            {
                ui_ventana ven=(ui_ventana)ts.actual.valor;
                LinkedList<item> valores=ven.getValores();
                String cadena="    <principal>\n";
                for(item i:valores)
                {
                    cadena=cadena+"        <"+i.clave+">"+i.valor.toString()+"</"+i.clave+">\n";
                }
                cadena=cadena+"    </principal>\n";
                System.out.println(cadena);
                ej.GuardarDatos(((Simbolo)ven.tabla.get("ID")).valor.toString(),cadena);
                return new Simbolo(var.tipo_vacio,null);            
            }else
            {
                e.AddError("No se pueden guardar valores de un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }
        }
        else if(ts.actual==null&&params.isEmpty())
        {
            e.AddError("no hay ventana de la cual obtener valores", linea, columna, archivo, "SEMANTICO");
        }
        else if(ts.actual==null)
        {
            if(params.size()!=1)
            {
                e.AddError("el metodo solo tiene un parametro", linea, columna, archivo, "SEMANTICO");
            }else
            {
                Simbolo actual=ts.actual;
                ts.actual=null;                    
                Simbolo a=(Simbolo) params.get(0).ejecutar(ts, e, ej);
                //ts.actual=actual;
                if(a.tipo.indice!=var.error)
                {
                    if(a.tipo.indice!=var.cadena)
                    {
                        e.AddError("el parametro deberia ser de tipo cadena", linea, columna, archivo, "SEMANTICO");
                    }else
                    {
                        //ejecuta la accion
                        String anterior=var.archivo;
                        var.archivo=a.valor.toString();
                        FileArray raiz= gramaticaGDATO(Reconize.getDireccion(a.valor.toString()),e);
                        var.archivo=anterior;
                        if(raiz!=null)
                        {
                            Array ar=getArrayFromFile(raiz,ts,e,ej);
                            if(ar==null)
                            {
                                
                            }else
                            {
                                rr=new Simbolo(var.tipo_arreglo,ar);
                            }
                        }
                    }

                }
                ts.actual=actual;
            }
        }else
        {
             e.AddError("el metodo no puede ser aplicado a ningun elemento", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
    public Array getArrayFromFile(FileArray raiz,mng_ts ts, mng_error err, Ejecucion ej)
    {
        LinkedList<Simbolo>valores=new LinkedList();
        
        LinkedList<tupla> tuplas=raiz.tuplas;
        for(tupla s:tuplas)
        {
            Hashtable vv=new Hashtable();
            Enumeration e = s.items.keys();
            Object clave;
            item valor;
            while( e.hasMoreElements() ){
                clave = e.nextElement();
                valor = (item)s.items.get( clave );                
                if(vv.containsKey(clave))
                {
                    err.AddError("el objeto tiene una clave repetida", linea, columna, archivo, "SEMANTICO");
                    return null;
                }else
                {
                    
                    vv.put(clave,new item(valor.clave,getS(valor.valor.toString()),linea,columna,archivo));
                } 
            }
            valores.add(new Simbolo(var.tipo_objeto,new Objeto(vv)));
                       
        }
        return new Array(valores);
    }
    public Simbolo getS(String c)
    {
        Simbolo r=null;
        if(c.contains("\""))
        {
            r=new Simbolo(var.tipo_cadena,c.substring(1, c.length()-1));
        }                
        else if(c.contains("."))
        {
             r=new Simbolo(var.tipo_decimal,Double.valueOf(c));
        }else
        {
            r=new Simbolo(var.tipo_entero,Integer.valueOf(c));
        }
        return r;
                
    }
    public FileArray gramaticaGDATO(String ruta, mng_error e)
    {
        FileArray raiz = null;        
        try
        {
            lexico_d le = new lexico_d(new BufferedReader( new StringReader(getContenido(ruta,false))));            
            sintactico_d sintactico=new sintactico_d(le);
            sintactico.parse();            
            raiz =sintactico.raiz;
            e.Adding(le.e);
            e.Adding(sintactico.e);
            
        }catch(Exception ex){

                //System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
        return raiz;
    }
}
