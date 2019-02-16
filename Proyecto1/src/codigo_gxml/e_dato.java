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
public class e_dato implements etiqueta{
    public elemento referencia;
    public Object valor;
    int linea;
    int columna;
    String archivo;
    public e_dato( elemento referencia,Object valor,int linea, int columna,String archivo)
    {
        this.referencia=referencia;
        this.valor=valor;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
