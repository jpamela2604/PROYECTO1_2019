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
public class e_contenedor implements etiqueta{
    LinkedList<etiqueta> etiquetas;
    LinkedList<elemento> elementos;
    int linea;
    int columna;
    String archivo;
    public e_contenedor(LinkedList<elemento> elementos,LinkedList<etiqueta> etiquetas,int linea, int columna,String archivo)
    {
        this.etiquetas=etiquetas;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
