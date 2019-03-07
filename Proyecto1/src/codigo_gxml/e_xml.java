/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import execute.ui_gxml;
import execute.ui_ventana;
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
    public Object GetGxmlObject() {
        ui_gxml archivo= new ui_gxml();
        e_Importar im=(e_Importar)imports;
        archivo.rutas=im.rutas;
        for(etiqueta et:ventanas)
        {
            ui_ventana ven=(ui_ventana)et.GetGxmlObject();
            archivo.ventanas.add(ven);
        }
        return archivo;
    }
    @Override
    public void Comprobar(mng_error e) {
        for(etiqueta et:ventanas)
        {
            et.Comprobar(e);
        }
    }
    
}
