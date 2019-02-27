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
public class oa_potencia implements sent{
    sent op1;
     sent op2;
     int linea;
     int columna;
     String archivo;
     
     public oa_potencia(sent op1,sent op2,int linea,int columna,String archivo)
     {
         this.op1=op1;
         this.op2=op2;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
     }
     @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        Simbolo o1=(Simbolo)op1.ejecutar(ts,e,ej);
        Simbolo o2=(Simbolo)op2.ejecutar(ts,e,ej);    
        if(o1.tipo.indice==var.error||o2.tipo.indice==var.error)
        {
            return respuesta;
        }else if(o1.tipo.indice>3||o2.tipo.indice >3)
        {
            e.AddError("Tipos incompatibles: "+o1.tipo.nombre+" ^ "+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            return respuesta;
        }
        O opera=matriz[o1.tipo.indice][o2.tipo.indice];
        switch(opera)
        {
            case POTEN:
            {
                Double r1=1.0;
                if(o1.tipo.indice==var.booleano)
                {
                    if(Boolean.valueOf(o1.valor.toString())==false)
                    {
                        r1=0.0;
                    }
                }else
                {
                    r1=Double.valueOf(o1.valor.toString());
                }
                Double r2=1.0;
                if(o2.tipo.indice==var.booleano)
                {
                    if(Boolean.valueOf(o2.valor.toString())==false)
                    {
                        r2=0.0;
                    }
                }else
                {
                    r2=Double.valueOf(o2.valor.toString());
                }
                Double val =Math.pow(r1, r2) ;
                if(val-val.intValue()==0)
                {
                    respuesta=new Simbolo(var.tipo_entero,val.intValue());
                }else
                {
                    respuesta=new Simbolo(var.tipo_decimal,val);
                } 
            }break;default:
            {
                e.AddError("Tipos incompatibles: "+o1.tipo.nombre+" ^ "+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            }break;
        }
        return respuesta;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }
    static  O [][]  matriz={
         /*     0|      1|      2|      3*/
    /*0*/{O.ERROR,O.POTEN,O.POTEN,O.ERROR },
    /*1*/{O.POTEN,O.POTEN,O.POTEN,O.ERROR }, 
    /*2*/{O.POTEN,O.POTEN,O.POTEN,O.ERROR },
    /*3*/{O.ERROR,O.ERROR,O.ERROR,O.ERROR }
            };
    private static enum O
    {
        POTEN,
        ERROR
    }
}
