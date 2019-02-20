/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import javax.swing.JButton;

/**
 *
 * @author Pamela Palacios
 */
public class ui_boton extends JButton{
    //obligatorios
    String nombre;
    int x;
    int y;
    //opcionales
    int alto;
    int ancho;
    String referencia;
    //sent llamada;
    public ui_boton(String nombre,int x,int y)
    {
        this.nombre=nombre;
        this.x=x;
        this.y=y;        
    }
}
