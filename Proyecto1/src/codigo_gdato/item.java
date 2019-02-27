/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gdato;

/**
 *
 * @author Pamela Palacios
 */
public class item {
    public String clave;
    public Object valor;
    int fila;
    int columna;
    String archivo;
    public item(String clave,Object valor,int fila,int columna,String archivo)
    {
        this.fila=fila;
        this.columna=columna;
        this.archivo=archivo;
        this.clave=clave;
        this.valor=valor;
    }
}
