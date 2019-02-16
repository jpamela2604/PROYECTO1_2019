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
public class e_Importar implements etiqueta{
    /*
    int linea;
    int columna;
    String archivo;
    public (int linea, int columna,String archivo)
    {
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
    */
    public LinkedList<ruta> rutas;
    public e_Importar(ruta r)
    {
        this.rutas=new LinkedList();
        this.rutas.add(r);
    }
}
