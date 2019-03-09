/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.util.LinkedList;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public interface ui {
    public String getTraduccion(String ventana,String panel);
    public void cargar();
    public String getValor(String value);
    public void getById(String id,LinkedList<Simbolo>valores);
    public void getByNombre(String nombre,LinkedList<Simbolo>valores);
    public void getByTag(String nombre,LinkedList<Simbolo>valores);
}
