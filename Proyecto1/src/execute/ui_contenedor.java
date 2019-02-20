/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import javax.swing.JPanel;

/**
 *
 * @author Pamela Palacios
 */
public class ui_contenedor extends JPanel{
    //obligatorio
    String id;
    int x;
    int y;
    public ui_contenedor(String id,int x,int y)
    {
        this.id=id;
        this.x=x;
        this.y=y;
    }
    //opcionales
    int alto;
    int ancho;
    String color;
    Boolean borde;
    
}
