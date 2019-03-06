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
public class e_xml implements etiqueta{
    public etiqueta imports;
    public LinkedList<etiqueta>ventanas;
    public e_xml(etiqueta imports,LinkedList<etiqueta>ventanas)
    {
        this.imports=imports;
        this.ventanas=ventanas;
    }
    @Override
    public Object Comprobar(mng_error e) {
        for(etiqueta et:ventanas)
        {
            et.Comprobar(e);
        }
        return null;
    }
    
}
