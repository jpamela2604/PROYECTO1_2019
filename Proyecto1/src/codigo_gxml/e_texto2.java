/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_gxml;

import errors.mng_error;
import java.util.Hashtable;
import java.util.LinkedList;
import proyecto1.var;

/**
 *
 * @author Pamela Palacios
 */
public class e_texto2 implements etiqueta{
    LinkedList<elemento> elementos;
    String texto;
    int linea;
    int columna;
    String archivo;
    Hashtable obligatorios;
    public e_texto2(LinkedList<elemento> elementos,String texto,int linea, int columna,String archivo)
    {
        this.texto=texto;
        this.elementos=elementos;
        this.linea=linea;
        this.columna = columna;
        this.archivo=archivo;
        obligatorios=new Hashtable();
    }
    @Override
    public Object GetGxmlObject() {
        LinkedList<String> valores=new LinkedList();
        valores.add(obligatorios.get("NOMBRE").toString());
        valores.add(texto);
        return valores;
    }
     @Override
    public void Comprobar(mng_error e) {
        String invalidos= "";
        String aux="";
        for(elemento el:this.elementos)
        {
            if(el.tipo==var.nombre)
            {
                obligatorios.put("NOMBRE",el.valor);
            }else
            {
                invalidos=invalidos+aux+var.elementos[el.tipo-100];
                aux=",";
                        
            }
        }aux="";
        String missing="";
        //comprobar que existan los obligatorios
        if(!obligatorios.containsKey("NOMBRE"))
        {
            missing="NOMBRE";aux=",";
        }
        if(!missing.equals(""))
        {
            e.AddError("Faltan lo(s) elementos(s) obligatoria(s) "+missing+" de la etiqueta texto", linea, columna, archivo, "SEMANTICO");
        } 
        //comprobar los no validos
        if(!invalidos.equals(""))
        {
            e.AddError("El/los elemento(s) "+invalidos+" no son validos para la etiqueta texto", linea, columna, archivo, "SEMANTICO");
        }
    }
}
