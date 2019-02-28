/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ventana;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_nEventoCargar  implements sent {
     LinkedList<sent> parametros;
     int linea;
     int columna;
     String archivo;
     
     public s_nEventoCargar(LinkedList<sent> parametros,int linea,int columna,String archivo)
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
        if(parametros.isEmpty())
        {
            //va a empezar desde aqui
            if(ts.actual==null)
            {
                e.AddError("No hay objeto al cual agregar evento", linea, columna, archivo, "SEMANTICO");
            }else if(ts.actual.tipo.indice!=var.ventana)
            {
                 e.AddError("No se le puede agregar un evento a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
            }else
            {
                ui_ventana v=(ui_ventana) ts.actual.valor;
                v.cargar();
                v.show();
                return ts.actual;
            }
        }
        else if(parametros.size()!=1)
        {
            e.AddError("El metodo AlCargar solo tiene un parametro", linea, columna, archivo, "SEMANTICO");
            return rr;
        }
        Simbolo t=(Simbolo) parametros.get(0).ejecutar(ts, e, ej);       
        
        return rr;
    }
}
