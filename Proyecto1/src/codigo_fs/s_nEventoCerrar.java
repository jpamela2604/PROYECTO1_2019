/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ventana;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nEventoCerrar  implements sent {
     sent llamada;
     int linea;
     int columna;
     String archivo;
     
     public s_nEventoCerrar(sent llamada,int linea,int columna,String archivo)
     {
         this.llamada=llamada;
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
        if(ts.actual==null)
        {
            e.AddError("No hay objeto al cual agregar evento", linea, columna, archivo, "SEMANTICO");
        }else if(ts.actual.tipo.indice!=var.ventana)
        {
            e.AddError("No se le puede agregar un evento cerrar a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }else
            {
                ui_ventana v=(ui_ventana) ts.actual.valor;
                v.AccionFinal=llamada;
                v.addWindowListener(new WindowAdapter() {
                    //@Override
                    public void windowClosing(WindowEvent w) {
                        Simbolo actual=ts.actual;
                        ts.actual=null;
                        llamada.ejecutar(ts, e, ej);
                        ts.actual=actual;
                        // System.exit(0);
                    }
                });
                return new Simbolo(var.tipo_vacio,null);
            }
        }catch(Exception exce)
        {
            e.AddError("ERROR:  al cerrar", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
