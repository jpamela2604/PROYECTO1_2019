/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

import codigo_fs.sent;
import java.util.LinkedList;

/**
 *
 * @author Pamela Palacios
 */
public class Simbolo {
    public static int variable=10;
    public static int metodo=11;
    
    String id;
    public NodoTipo tipo;
    int rol;
    public Object valor;
    public LinkedList<String> parametros;
    public LinkedList<sent> sentencias;
    public Boolean PuedeCambiarTipo;
    
    public Simbolo(String id,LinkedList<String> parametros,LinkedList<sent> sentencias)
    {
        this.id=id;
        this.parametros=parametros;
        this.sentencias=sentencias; 
        this.rol=metodo;
        PuedeCambiarTipo=true;
    }
    public Simbolo(NodoTipo tipo,Object valor)
    {
        this.tipo=tipo;
        this.valor=valor;
        PuedeCambiarTipo=true;
    }
    
    public Simbolo(NodoTipo tipo,Object valor,Boolean p)
    {
        this.tipo=tipo;
        this.valor=valor;
        PuedeCambiarTipo=p;
    }
    public Simbolo(String nombre,NodoTipo tipo,int rol,Object valor)
    {
        this.id=nombre;
        this.tipo=tipo;
        this.rol=rol;
        this.valor=valor;
        PuedeCambiarTipo=true;
    }
    
    public String getRol()
    {
        if(this.rol==metodo)
        {
            return "metodo";
        }
        return "variable";
    }
    public String getNombre()
    {
        if(this.rol==metodo)
        {
            return id.substring(0,id.length()-1);
        }
        return id;
    }
}
