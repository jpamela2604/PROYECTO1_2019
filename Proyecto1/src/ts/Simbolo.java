/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

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
    
    public Simbolo(String nombre,NodoTipo tipo,int rol,Object valor)
    {
        this.id=nombre;
        this.tipo=tipo;
        this.rol=rol;
        this.valor=valor;
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
