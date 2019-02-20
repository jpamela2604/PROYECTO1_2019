/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import javax.swing.JComboBox;

/**
 *
 * @author Pamela Palacios
 */
public class ui_desplegable extends JComboBox{
    //obligatorios
    String nombre;
    int x;
    int y;
    public ui_desplegable(String nombre,int x,int y)
    {
        this.nombre=nombre;
        this.x=x;
        this.y=y;
    }
    //opcionales
    String fuente;
    int tam;
    String color;
    Boolean negrita;
    Boolean cursiva;
    int alto;
    int ancho;
    int maximo;
    int minimo;
    //sent accion;
}
