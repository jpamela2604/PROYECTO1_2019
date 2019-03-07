/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_dato implements etiqueta{
    LinkedList<elemento> elementos;
    public Object valor;
    int linea;
    int columna;
    String archivo;
    public e_dato( LinkedList<elemento> elementos,Object valor,int linea, int columna,String archivo)
    {
        this.elementos=elementos;
        this.valor=valor;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
    @Override
    public Object GetGxmlObject() {
        return null;
    }
    @Override
    public void Comprobar(mng_error e) {
        String invalidos= "";
        String aux="";
        for(elemento el:this.elementos)
        {
            invalidos=invalidos+aux+var.elementos[el.tipo-100];
                aux=",";
        }
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta ListaDatos", linea, columna, archivo, "SEMANTICO");
        }
    }
}
