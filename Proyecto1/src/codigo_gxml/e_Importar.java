/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import java.util.LinkedList;

/**
 *
 * @author Pamela Palacios
 */
public class e_Importar implements etiqueta{
    
    public LinkedList<ruta> rutas;
    public e_Importar(ruta r)
    {
        this.rutas=new LinkedList();
        this.rutas.add(r);
    }
    public e_Importar()
    {
        this.rutas=new LinkedList();
    }
    @Override
    public void Comprobar(mng_error e) {
        
    }

    @Override
    public Object GetGxmlObject() {
        return null;
    }
}
