/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import codigo_fs.Array;
import errors.mng_error;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class e_listaDato implements etiqueta{
    int linea;
    int columna;
    String archivo;
    LinkedList<e_dato>datos;
    LinkedList<elemento> elementos;
    public e_listaDato(LinkedList<elemento> elementos,LinkedList<e_dato>datos,int linea, int columna,String archivo)
    {
        this.elementos=elementos;
        this.datos=datos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
    }
    @Override
    public Object GetGxmlObject() {
        LinkedList<Simbolo>valores=new LinkedList();
        for(etiqueta et:datos)
        {
            valores.add((Simbolo)et.GetGxmlObject());
        }
        return new Array(valores);
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
