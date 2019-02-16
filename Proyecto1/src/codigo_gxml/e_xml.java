/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

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
    
}
