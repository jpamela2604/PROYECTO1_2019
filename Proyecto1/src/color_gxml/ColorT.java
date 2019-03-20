/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package color_gxml;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Pamela Palacios
 */
public class ColorT {
    public JTextPane caja2=new JTextPane(); 
    public StyleContext sc = new StyleContext();
    public DefaultStyledDocument doc = new DefaultStyledDocument(sc);

    public void insertar(String texto){
   
        caja2.setDocument(doc);
        try {
            doc.insertString(0,texto,null);

        }catch (Exception ex) {
            //System.out.println("ERROr: no se pudo establecer estilo de documento");
        }
   
   }
   
   public void simbolo(int posini,int posfin){
   Style negro = sc.addStyle("ConstantWidth", null);
   StyleConstants.setForeground(negro, Color.BLACK);
   doc.setCharacterAttributes(posini,posfin, negro, false);
   //System.out.println("simbolo: "+posini+","+posfin);
   }
   
     public void reservada(int posini,int posfin){
            Style azul= sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(azul, Color.decode("#08088A"));
            doc.setCharacterAttributes(posini,posfin, azul, false);
            //System.out.println("reservada: "+posini+","+posfin);
     }
   
       public void numero(int posini,int posfin){
            Style morado = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(morado, Color.decode("#A901DB"));
            doc.setCharacterAttributes(posini,posfin, morado, false);
       
       } 
   
        public void cadena(int posini,int posfin){
            Style orange = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(orange, Color.decode("#FF8000"));
            doc.setCharacterAttributes(posini,posfin, orange, false);
       
       } 
        
         public void llamada(int posini,int posfin){
            Style verde = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(verde, Color.decode("#0B610B"));
            doc.setCharacterAttributes(posini,posfin, verde, false);
         }
         
         public void comentario(int posini,int posfin){
            Style gris = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(gris, Color.decode("#A4A4A4"));
            doc.setCharacterAttributes(posini,posfin,gris, false);
         }
         
         public void otro(int posini,int posfin){
            Style negro = sc.addStyle("ConstantWidth", null);
            StyleConstants.setForeground(negro, Color.BLACK);
            doc.setCharacterAttributes(posini,posfin,negro, false);
            //System.out.println("otro: "+posini+","+posfin);
         }
         
}
