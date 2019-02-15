/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import errors.mng_error;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Pamela Palacios
 */
public class mng_ts {
    public Stack tabla;
    public Hashtable ambitoActual;
    public Hashtable globales;
    private mng_error e;
    public Stack auxiliar;
    public mng_ts(mng_error er)
    {            
        tabla = new Stack();
        ambitoActual = new Hashtable();
        globales = new Hashtable();
        e = er;
        auxiliar = new Stack();
        tabla.push(globales);
    }
    public Boolean AgregarSimbolo(Simbolo simb,Boolean IsGlobal,int linea,int columna,String arch)
    {
        if (IsGlobal)
        {
            return agregarHash(this.globales, simb,linea,columna,arch);
        }else
        {
            return agregarHash(this.ambitoActual, simb,linea,columna,arch);
        }
    }
    public Boolean agregarHash(Hashtable h,Simbolo sim,int linea,int columna,String arch)
    {
        if (h.containsKey(sim.id))
        {
            e.AddError("Ya existe "+sim.getRol()+" con el nombre"+sim.getNombre(),linea,columna,arch,"SEMANTICO");
            return false;
        }
        else
        {               
            h.put(sim.id, sim);
            return true;
        }
    }
    public Simbolo buscarSimbolo(Simbolo sim,int linea,int columna,String archivo)
    {
        if (ambitoActual.containsKey(sim.id))
       {                
            return (Simbolo)ambitoActual.get(sim.id);
        }
            
        Simbolo respuesta = null;
        Stack a = new Stack();
        while (tabla.size() > 0)
        {
            Hashtable recorre = (Hashtable)tabla.pop();
            a.push(recorre);
            if (recorre.containsKey(sim.id))
            {
                respuesta =(Simbolo)recorre.get(sim.id);
                break;
            }
        }
        while(a.size()>0)
        {
            tabla.push((Hashtable)a.pop());
        }

        if (respuesta == null )
        {
            e.AddError("No se encontro "+sim.getRol()+"  \""+sim.getNombre()+"\"", linea, columna,archivo,"SEMANTICO");  
        }

            return respuesta;
    }
    public Boolean ModificarSimbolo(Simbolo simb, int linea, int columna, String archivo)
    {
        Simbolo t = buscarSimbolo(simb, linea, columna,archivo);
        if (t != null)
        {
            t.tipo=simb.tipo;
            t.valor=simb.valor;
            return true;
        }
        return false;
    }   
    public void cambiarAmbito(Boolean IsLlamada)
    {
        if (IsLlamada)
        {
            //guardo el ambito actual a la tabla
            tabla.push(ambitoActual);
            //apilo la tabla
            auxiliar.push(tabla);
            //creo una nueva tabla
            tabla = new Stack();
            //por default ya tiene que tener la de globales
            tabla.push(globales);
            ambitoActual = new Hashtable();
        }
        else
        {
            tabla.push(ambitoActual);
            ambitoActual = new Hashtable();
        }
    }

    public void regresarAmbito(Boolean IsLlamada)
    {
        if (IsLlamada)
        {
            tabla =(Stack) auxiliar.pop();
            ambitoActual =(Hashtable) tabla.pop();
        }
        else
        {
            ambitoActual = (Hashtable)tabla.pop();
        }
    }
}
