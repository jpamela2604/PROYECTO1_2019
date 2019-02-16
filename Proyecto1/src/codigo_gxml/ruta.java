/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

/**
 *
 * @author Pamela Palacios
 */
public class ruta {
    public int linea;
    public int columna;
    public String archivo;
    public String ruta;
    public ruta(String ruta,int linea,int columna,String archivo)
    {
        this.ruta=ruta;
        this.linea=linea;
        this.columna=columna;
        this.archivo=archivo;
    }
}
