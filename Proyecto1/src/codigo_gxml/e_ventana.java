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
public class e_ventana implements etiqueta{
    LinkedList<etiqueta> contenedores;
    LinkedList<elemento> elementos;
    int linea;
    int columna;
    String archivo;
    public e_ventana(LinkedList<elemento> elementos,LinkedList<etiqueta> contenedores,int linea, int columna,String archivo)
    {
        this.contenedores=contenedores;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
