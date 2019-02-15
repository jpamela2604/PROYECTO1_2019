/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors;

/**
 *
 * @author Pamela Palacios
 */
public class NodoError {
    
    public String Descripcion;
    public int columna;
    public int linea;
    public String archivo;
    public String tipo;
    
    public NodoError(String Descripcion,int linea,int columna,String archivo,String tipo)
    {
        this.Descripcion=Descripcion;
        this.linea=linea;
        this.columna=columna;
        this.archivo=archivo;
        this.tipo=tipo;
    }
}

