/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Pamela Palacios
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ExtremeEditor().show();
        //new gdato().show();
       // System.out.println(" aa"+invertirNumero(11));
        
    }
    /*
    public static Integer invertirNumero (Integer n){
    return n < 10 ? n : modulo(n, 10) + invertirNumero (n / 10) * 10;
    }
    
    public static Integer modulo(Integer n, Integer p){
    return n < p ? n : modulo( n - p, p);
    }*/
}
