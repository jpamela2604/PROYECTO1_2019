/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

    
import codigo_gdato.item;
import java.util.Hashtable;
import java.util.LinkedList;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class Objeto {
    public Hashtable items;
    public Objeto(Hashtable items)
    {
        this.items=items;
    }
    
    public Objeto clone()
    {
         
         return new Objeto((Hashtable) this.items.clone());
    }
    
}
