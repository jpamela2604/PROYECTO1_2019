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
public class elemento {
    public int tipo;
    public Object valor;
    public int linea;
    public int columna;
    public String archivo;
    public elemento(int tipo,Object valor,int linea, int columna,String archivo)
    {
        this.tipo=tipo;
        this.valor=valor;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
}
