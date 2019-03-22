/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ventana;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nEventoCargar  implements sent {
    sent llamada;
     int linea;
     int columna;
     String archivo;
     public Boolean IsGlobal;    
     
     public s_nEventoCargar(sent llamada,int linea,int columna,String archivo)
     {
         this.llamada=llamada;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
         IsGlobal=true;
     }
    @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        Simbolo rr=new Simbolo(var.tipo_error,null);
        try{
        if(llamada==null)
        {
            //va a empezar desde aqui
            if(ts.actual==null)
            {
                e.AddError("No hay objeto al cual agregar evento cargar", linea, columna, archivo, "SEMANTICO");
            }else if(ts.actual.tipo.indice!=var.ventana)
            {
                 e.AddError("No se le puede agregar un evento al cargar a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }else
            {
                
                ui_ventana v=(ui_ventana) ts.actual.valor;
                if(IsGlobal)
                {
                    ej.deTodo.principal=v;
                }else
                {
                    ej.deTodo.iniciar(v, ts, e, ej);
                }
                /*
                v.cargar();
                v.show();
                if(v.AccionInicial!=null)
                {
                    Simbolo actual=ts.actual;
                    ts.actual=null;
                    v.AccionInicial.ejecutar(ts, e, ej);
                    ts.actual=actual;
                }
                */
                return new Simbolo(var.tipo_vacio,null);
            }
        }
        else 
        {
            if(ts.actual==null)
            {
                e.AddError("No hay objeto al cual agregar evento", linea, columna, archivo, "SEMANTICO");
            }else if(ts.actual.tipo.indice!=var.ventana)
            {
                 e.AddError("No se le puede agregar un evento al cargar a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }else
            {
                ui_ventana v=(ui_ventana) ts.actual.valor;
                v.AccionInicial=this.llamada;
                return new Simbolo(var.tipo_vacio,null);
            }
        }
       //Simbolo t=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);       
        }catch(Exception exce)
        {
            e.AddError("ERROR: evento AlCargar ", linea, columna, archivo, "SEMANTICO");
        }
        return rr;
    }
}
