/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;

/**
 *
 * @author Pamela Palacios
 */
public class e_defecto implements etiqueta{
    public String valor;
    int linea;
    int columna;
    String archivo;
    public e_defecto( String valor,int linea, int columna,String archivo)
    {
        this.valor=valor;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
    @Override
    public Object GetGxmlObject() {
        return valor;
    }
    @Override
    public void Comprobar(mng_error e) {
        
    }
}
