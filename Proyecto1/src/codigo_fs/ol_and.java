/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class ol_and implements sent{
    sent op1;
     sent op2;
     int linea;
     int columna;
     String archivo;
     
     public ol_and(sent op1,sent op2,int linea,int columna,String archivo)
     {
         this.op1=op1;
         this.op2=op2;
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
        Simbolo o1=(Simbolo)op1.ejecutar(ts,e,ej);
        Simbolo o2=(Simbolo)op2.ejecutar(ts,e,ej);  
        if(o1.tipo.indice==var.error||o2.tipo.indice==var.error)
        {
            return respuesta;
        }
        if(o1.tipo.indice==var.booleano &&o2.tipo.indice==var.booleano)
        {
            Boolean v1=Boolean.valueOf(o1.valor.toString());
            Boolean v2=Boolean.valueOf(o2.valor.toString());
                    
            Boolean val=v1&&v2;
            respuesta=new Simbolo(var.tipo_booleano,val);
        }else
        {
            e.AddError("Tipos incompatibles: "+o1.tipo.nombre+" && "+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
        }
        return respuesta;
    }
}
