/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author Pamela Palacios
 */
public class Pestania {
    public String ruta;
    public RSyntaxTextArea texto;
    public RTextScrollPane scroll;
    public Tipo tipo;
    public Pestania(Tipo tipo,String ruta,RSyntaxTextArea texto,RTextScrollPane scroll)
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
