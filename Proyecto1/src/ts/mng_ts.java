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
    public Simbolo actual;
    public Stack displayReturns;
    public Stack displayBreaks;
    public mng_ts(mng_error er)
    {
         
        this.displayReturns=new Stack();
        this.displayBreaks=new Stack();
        tabla = new Stack();
        ambitoActual = new Hashtable();
        globales = new Hashtable();
        e = er;
        auxiliar = new Stack();
        tabla.push(globales);
        agregarOriginales();
    }
    
    public void agregarOriginales()
    {
        AgregarSimbolo(new Simbolo("ALCERRAR#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("ALCLIC#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARVIDEO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARREPRODUCTOR#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARIMAGEN#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARBOTON#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARDESPLEGABLE#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARCONTROLNUMERICO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARAREATEXTO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARCAJATEXTO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARVENTANA#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARTEXTO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARCONTENEDOR#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("OBTENERPORETIQUETA#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("OBTENERPORID#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("OBTENERPORNOMBRE#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("LEERGXML#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("FILTER#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("MAP#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("BUSCAR#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("REDUCE#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("TODOS#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("ALGUNO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("MAXIMO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("MINIMO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("INVERTIR#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("CREARARRAYDESDEARCHIVO#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("ASCENDENTE#",new LinkedList(),new LinkedList()),true,0,0,"");
        AgregarSimbolo(new Simbolo("DESCENDENTE#",new LinkedList(),new LinkedList()),true,0,0,"");
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
            e.AddError("Ya existe "+sim.getRol()+" con el nombre \""+sim.getNombre()+"\"",linea,columna,arch,"SEMANTICO");
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
