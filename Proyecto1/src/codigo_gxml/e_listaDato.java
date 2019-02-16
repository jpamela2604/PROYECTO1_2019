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
public class e_listaDato implements etiqueta{
    int linea;
    int columna;
    String archivo;
    LinkedList<e_dato>datos;
    elemento accion;
    public e_listaDato(elemento accion,LinkedList<e_dato>datos,int linea, int columna,String archivo)
    {
        this.accion=accion;
        this.datos=datos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
