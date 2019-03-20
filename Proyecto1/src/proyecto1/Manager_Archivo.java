/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pamela Palacios
 */
public class Manager_Archivo {
    public static String getContenido(String ruta,Boolean bandera)
    {
        String Text;
        String contenido="";
        File Abrir= new File(ruta);
        try{
            FileReader Fichero= new FileReader(Abrir);
                BufferedReader leer= new BufferedReader(Fichero);
                while((Text=leer.readLine())!=null)
                {
                    contenido=contenido+Text+ "\n";
                }
                leer.close();
                Fichero.close();
        }
        catch(Exception ioe)
        {
            if(bandera)
            {JOptionPane.showMessageDialog(null, "Error al abrir el archivo");}
        }
        return contenido;
    }
    
    public static Boolean escribir(String ruta,String contenido)
    {
        contenido=contenido.replace("\r", "");
        FileWriter fw;
        try
        {   
            fw= new FileWriter(ruta);
            fw.write(contenido);
            fw.close();        
                //JOptionPane.showMessageDialog(null, "Guardado Exitosamente ");
            return true;
         }
        catch(IOException io)
        {
                  //l3.setText("Error al abrir el fichero");
                 //JOptionPane.showMessageDialog(null, "Error al guardar ");
        }  
        return false;
    }
    public static Boolean ExisteFile(String ruta)
    {
        File f=new File(ruta);
        return f.exists();
    }
    public static String getFileExtension(String ruta) {
        
        File file=new File(ruta);
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
