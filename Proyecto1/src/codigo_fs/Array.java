/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import java.util.LinkedList;
import proyecto1.var;
import ts.NodoTipo;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class Array {
    public LinkedList<Simbolo>valores;
    
    public Array(LinkedList<Simbolo>valores)
    {
        this.valores=valores;
    }
    public NodoTipo getTipo()
    {
        NodoTipo m=var.tipo_heterogeneo;
        if(!this.valores.isEmpty())
        {
            NodoTipo s=valores.get(0).tipo;
            
            for(int i=1;i<this.valores.size();i++)
            {
                NodoTipo ss=valores.get(i).tipo;
                if((s.indice==var.entero&&ss.indice==var.decimal)||
                    (s.indice==var.decimal&&ss.indice==var.entero)    )
                {
                    s=var.tipo_decimal;
                }
                else if(!(ss.indice==s.indice&&ss.nombre.equals(s.nombre)))
                {
                    return m;
                }
            }
            return s;
        }
        
        return m;
    }
}
