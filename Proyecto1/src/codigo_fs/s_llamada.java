/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_llamada implements sent{
    public String nombre;
    public LinkedList<sent> parametros;
     int linea;
     int columna;
     String archivo;
     public s_llamada(String nombre,LinkedList<sent> parametros,int linea,int columna,String archivo)
     {
         this.nombre=nombre;
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
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        if("CREARVENTANA".equals(this.nombre))
        {
            return new s_nCrearVentana(parametros,linea,columna,archivo).ejecutar(ts, e, ej);
        }else if("ALCARGAR".equals(this.nombre))
        {
            //return new s_nEventoCargar(parametros,linea,columna,archivo).ejecutar(ts, e, ej);
        }else if("CREARARRAYDESDEARCHIVO".equals(this.nombre))
        {
            return new s_propiaArrayFromFile(parametros,linea,columna,archivo).ejecutar(ts, e, ej);
        }
        else
        {
            /*es una llamada de un metodo cualquiera*/
            
            Simbolo m=new Simbolo(nombre+"#",null,Simbolo.metodo,null);
            m=ts.buscarSimbolo(m, linea, columna, archivo);
            if(m!=null)
            {
                if(m.parametros.size()==this.parametros.size())
                {
                    
                    LinkedList<Simbolo> valores=new LinkedList(); 
                    Boolean Bandera=true;
                    //ejecutar los parametros
                    for(sent s:parametros)
                    {
                        Simbolo p=(Simbolo) s.ejecutar(ts, e, ej);
                        if(p.tipo.indice==var.error)
                        {
                            Bandera = false;
                            break;
                        }else if(p.tipo.indice==var.vacio)
                        {
                            e.AddError("Se invoco a un metodo vacio", linea, columna, archivo, "SEMANTICO");
                            Bandera = false;
                            break;
                        }else
                        {
                            valores.add(p);
                        }   
                    }
                    //si no hubo errores
                    if(Bandera)
                    {
                        respuesta=new Simbolo(var.tipo_vacio,null);
                        ts.displayReturns.push("");
                        ts.cambiarAmbito(true);
                        Simbolo actual=ts.actual;
                        ts.actual=null;
                        //declarar las variable parametro
                        int x=0;
                        for(String name:m.parametros)
                        {
                            ts.AgregarSimbolo(new Simbolo(name,valores.get(x).tipo,Simbolo.variable,valores.get(x).valor), false, linea, columna, archivo);
                            x++;
                        }
                        //ejecutar las sentencias
                        for(sent se: m.sentencias)
                        {
                            Simbolo retorno =(Simbolo) se.ejecutar(ts, e, ej);
                            if(retorno!=null)
                            {
                                respuesta=retorno;
                                break;
                            }
                        }
                        ts.actual=actual;
                        ts.regresarAmbito(true);
                        ts.displayReturns.pop();
                    }
                    
                }else
                {
                    e.AddError("El metodo "+nombre+" esta definido con "+m.parametros.size()+" parametros", linea, columna, archivo, "SEMANTICO");
                }
            }
        }
        return respuesta;
    }
}
