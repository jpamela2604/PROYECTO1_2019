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
public class ui_imagen extends JButton{
    //obligatorios
    String ruta;
    String nombre;
    int x;
    int y;
     public ui_imagen(String ruta,String nombre,int x,int y)
    {
        this.ruta=ruta;
        this.nombre=nombre;
        this.x=x;
        this.y=y;
    }
    //opcionales
    int ancho;
    int alto;
    Boolean auto_reproduccion;
}
