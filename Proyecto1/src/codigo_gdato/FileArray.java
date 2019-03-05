/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gdato;

import java.util.LinkedList;

/**
 *
 * @author Pamela Palacios
 */
public class FileArray {
    String id;
    public LinkedList<tupla> tuplas;
    int fila;
    int columna;
    String archivo;
    public FileArray(String id,LinkedList<tupla> tuplas,int fila,int columna,String archivo)
    {
        
        this.fila=fila;
        this.columna=columna;
        this.archivo=archivo;
        this.tuplas=tuplas;
    }
}
