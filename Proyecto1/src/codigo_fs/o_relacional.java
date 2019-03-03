/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.Objects;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class o_relacional implements sent{
     sent op1;
     sent op2;
     int linea;
     int columna;
     String archivo;
     String oprel;
     
     public o_relacional(sent op1,sent op2,String oprel,int linea,int columna,String archivo)
     {
         this.op1=op1;
         this.op2=op2;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
         this.oprel=oprel;
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
        else if((/*o1.tipo.indice>3&&o1.tipo.indice!=8&&*/o2.tipo.indice==var.nulo)
                 ||(/*o2.tipo.indice>3&&o2.tipo.indice!=8&&o*/o1.tipo.indice==var.nulo))
        {
            Boolean val=false;
            if("==".equals(oprel))
            {
                if(o1.valor==o2.valor)
                {
                    val=true;
                }
            }else if("!=".equals(oprel))
            {
                if(o1.valor!=o2.valor)
                {
                    val=true;
                }
            }else
            {
                e.AddError("Tipos incompatibles: "+o1.tipo.nombre+oprel+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
                return respuesta;
            }
            respuesta=new Simbolo(var.tipo_booleano,val);
            return respuesta;
            
        }
        else if(o1.tipo.indice>3||o2.tipo.indice >3)
        {
            e.AddError("Tipos incompatibles: "+o1.tipo.nombre+oprel+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            return respuesta;
        }else
        {
        O opera=matriz[o1.tipo.indice][o2.tipo.indice];
        switch(opera)
        {
            case CMPNO:
            {
                Double r1=getv(o1);
                Double r2=getv(o2);
                Boolean val=false;
                switch(oprel)
                {
                    case ">":
                    {
                        if(r1>r2)
                        {
                            val=true;
                        }
                    }break;
                    case "<":
                    {
                        if(r1<r2)
                        {
                            val=true;
                        }
                    }break;
                    case "<=":
                    {
                        if(r1<=r2)
                        {
                            val=true;
                        }
                    }break;
                    case ">=":
                    {
                        if(r1>=r2)
                        {
                            val=true;
                        }
                    }break;
                    case "==":
                    {
                        if(Objects.equals(r1, r2))
                        {
                            val=true;
                        }
                    }break;
                    default:
                    {
                        if(!Objects.equals(r1, r2))
                        {
                            val=true;
                        }
                    }break;
                }
                respuesta=new Simbolo(var.tipo_booleano,val); 
                
            }break;
            default:
            {
                e.AddError("Tipos incompatibles: "+o1.tipo.nombre+this.oprel+o2.tipo.nombre, linea, columna, archivo, "SEMANTICO");            
            }break;
        }
        }
        return respuesta;
    }
    
    public Double getv(Simbolo s)
    {
        Double r=0.0;
        if(s.tipo.indice==var.cadena)
        {
            String g=s.valor.toString();
            for (int x=0;x<g.length();x++)
            {
                r=r+g.codePointAt(x);
            }
        }else
        {
            r=Double.valueOf(s.valor.toString());
        }
        
        return r;
    }
     static  O [][]  matriz={
         /*     0|      1|      2|      3*/
    /*0*/{O.ERROR,O.ERROR,O.ERROR,O.ERROR },
    /*1*/{O.ERROR,O.CMPNO,O.CMPNO,O.CMPNO }, 
    /*2*/{O.ERROR,O.CMPNO,O.CMPNO,O.CMPNO },
    /*3*/{O.ERROR,O.CMPNO,O.CMPNO,O.CMPNO }
            };
    private static enum O
    {
        CMPNO,
        ERROR
    }
}
