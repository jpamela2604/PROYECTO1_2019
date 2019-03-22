/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;


import errors.mng_error;
import execute.Ejecucion;
import execute.ui_gxml;
import java.util.LinkedList;
import proyecto1.Reconize;
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
        try{
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
                        ui_gxml miarc= nat(Reconize.getDireccion(a.valor.toString()),ts,e,ej);
                        var.archivo=anterior;
                        if(miarc!=null)
                        {
                            rr=new Simbolo(var.tipo_gxml,miarc);
                        }                        
                    }
                }
            }
        }catch(Exception exce)
        {
            e.AddError("ERROR: leergxml", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
    
    public ui_gxml nat(String ruta,mng_ts ts, mng_error e, Ejecucion ej)
    {
        //primero lo traduzo gxml a un fs
        String sss=Reconize.gramaticaGxml(e, ruta, "auxiliar.fs");
        if(!sss.equals(""))
        {
            ui_gxml deTodo=new ui_gxml();
            Ejecucion ejecuta=new Ejecucion(ej.a,deTodo);
            if(Reconize.gramaticaFS("auxiliar.fs", ts, e, ejecuta))
            {
                return deTodo;
            }
        }
        // el fs lo ejecuto
        
        return null;
    }
   
}

