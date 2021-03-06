/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_boton;
import execute.ui_texto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nEventoClic implements sent {
     sent llamada;
     int linea;
     int columna;
     String archivo;
     
     public s_nEventoClic(sent llamada,int linea,int columna,String archivo)
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
        }else if(ts.actual.tipo.indice==var.boton)
        {
             ui_boton v=(ui_boton) ts.actual.valor;
             v.IsEnviar=true;
             ActionListener[] ac=v.getActionListeners();
             if(ac.length>0)
             {
                 v.removeActionListener(ac[0]);
             }
             
             v.addActionListener(new ActionListener() { 
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                    Simbolo actual=ts.actual;
                    ts.actual=null; 
                    llamada.ejecutar(ts, e, ej);
                    ts.actual=actual;
                    if(v.referencia!=null)
                    {
                        actual=ts.actual;
                        ts.actual=null; 
                        v.referencia.ejecutar(ts, e, ej);
                        ts.actual=actual;
                    }
                 }
            } );
        }
        else if(ts.actual.tipo.indice==var.texto)
        {
            ui_texto v= (ui_texto)ts.actual.valor;
            MouseListener[] ac=v.getMouseListeners();
            if(ac.length>0)
            {
                v.removeMouseListener(ac[0]);
            }
            v.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent ev) {
                    Simbolo actual=ts.actual;
                    ts.actual=null; 
                    llamada.ejecutar(ts, e, ej);
                    ts.actual=actual;
                }

            });
        }/*else if(ts.actual.tipo.indice==var.imagen)
        {
            ui_imagen v=(ui_imagen)ts.actual.valor;
            v.addActionListener(new ActionListener() { 
                 @Override
                 public void actionPerformed(ActionEvent ae) {
                    Simbolo actual=ts.actual;
                    ts.actual=null; 
                    llamada.ejecutar(ts, e, ej);
                    ts.actual=actual;
                 }
            } );
        }*/
        else 
        {
            e.AddError("No se le puede agregar un evento cerrar a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }}catch(Exception exce)
        {
            e.AddError("ERROR:  al clic", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
