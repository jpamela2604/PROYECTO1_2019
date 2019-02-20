/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import javax.swing.JFrame;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ventana extends JFrame{
    //obligatorio
    String id;
    String tipo;//Principal,Secundaria
    //opcional
    public ui_ventana(String id,String tipo)
    {
        this.id=id;
        this.tipo=tipo;
    }
    String color;
    //sent AccionInicial;
    //sent AccionFinal;
    
}
