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
public class e_boton implements etiqueta{
    LinkedList<elemento> elementos;
    String texto;
    int linea;
    int columna;
    String archivo;
    public e_boton(LinkedList<elemento> elementos,String texto,int linea, int columna,String archivo)
    {
        this.texto=texto;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
