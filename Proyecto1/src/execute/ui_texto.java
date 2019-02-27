/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Pamela Palacios
 */
public class ui_texto extends JLabel{
    //obligatorios
    String nombre;
    String texto;
    int x;
    int y;
    public ui_texto(String nombre,int x,int y)
    {
        this.nombre=nombre;
        this.x=x;
        this.y=y;
        this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";
        this.negrita=false;
        this.cursiva=false;
        this.alto=this.getSize().height;
        this.ancho=this.getSize().width;
    }
    //opcionales
    String fuente;
    int tam;
    String color;
    Boolean negrita;
    Boolean cursiva;
    /*no estoy segura*/
    int alto;
    int ancho;
    int maximo;
    int minimo;
    //sent accion;
    public void cargar()
    {
        int font=0;
        if(negrita)
        {
            font=font+Font.BOLD;
        }
        if(cursiva)
        {
            font=font+Font.ITALIC;
        }
        this.setFont(new java.awt.Font(fuente, font, tam));
        this.setForeground(Color.decode(color));
        this.setText(texto);
        this.setSize(alto,ancho);
    }
    
}
