/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Pamela Palacios
 */
public class Pestania {
    public String ruta;
    public JTextPane texto;
    //public RSyntaxTextArea texto;
    public JScrollPane scroll;
    public Tipo tipo;
    public Pestania(Tipo tipo,String ruta/*,RSyntaxTextArea texto,*/,JScrollPane scroll,JTextPane texto)
    {
        this.ruta=ruta;
        this.texto=texto;
        this.scroll=scroll;
        this.tipo=tipo;
    }
    
    public static enum Tipo
    {
        GXML,
        FS,
        GDATO
    }
}
