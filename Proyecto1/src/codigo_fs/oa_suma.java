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
public class oa_suma implements sent{
    sent op1;
     sent op2;
     int linea;
     int columna;
     String archivo;
     
     public oa_suma(sent op1,sent op2,int linea,int columna,String archivo)
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
        }else if(o1.tipo.indice>3||o2.tipo.indice >3)
        {
            e.AddError("Tipos incompatibles: "+o1.tipo.nombre+" + "+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            return respuesta;
        }
        O opera=matriz[o1.tipo.indice][o2.tipo.indice];
        switch(opera)
        {
            case SUMAR:
            {
                Double r1=Double.valueOf(o1.valor.toString());
                Double r2=Double.valueOf(o2.valor.toString());
                Double val = r1+r2;
                if(val-val.intValue()==0)
                {
                    respuesta=new Simbolo(var.tipo_entero,val.intValue());
                }else
                {
                    respuesta=new Simbolo(var.tipo_decimal,val);
                } 
            }break;
            case CONCA:
            {
                String r1;
                String r2;
                if(o1.tipo.indice==var.booleano )
                {
                    r1=var.valor_true;
                    if( Boolean.valueOf(o1.valor.toString())==false)
                    {
                        r1=var.valor_false;
                    }
                }else
                {
                    r1=o1.valor.toString();
                }
                if(o2.tipo.indice==var.booleano )
                {
                    r2=var.valor_true;
                    if( Boolean.valueOf(o2.valor.toString())==false)
                    {
                        r2=var.valor_false;
                    }
                }else
                {
                    r2=o2.valor.toString();
                }
                String val=r1+r2;
                respuesta=new Simbolo(var.tipo_cadena,val);
            }break;
            default:
            {
                e.AddError("Tipos incompatibles: "+o1.tipo.nombre+" + "+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            }break;
        }
        return respuesta;
    }
    static  O [][]  matriz={
         /*     0|      1|      2|      3*/
    /*0*/{O.ERROR,O.ERROR,O.ERROR,O.CONCA },
    /*1*/{O.ERROR,O.SUMAR,O.SUMAR,O.CONCA }, 
    /*2*/{O.ERROR,O.SUMAR,O.SUMAR,O.CONCA },
    /*3*/{O.CONCA,O.CONCA,O.CONCA,O.CONCA }
            };
    private static enum O
    {
        CONCA,
        SUMAR,
        ERROR
    }
    
}
