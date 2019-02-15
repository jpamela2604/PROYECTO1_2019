/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import errors.mng_error;
import g_fs.lexico_fs;
import g_fs.sintactico_fs;
import g_gxml.lexico_g;
import g_gxml.sintactico_g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pamela Palacios
 */
public class Reconize {
    public mng_error e;
    public Reconize(mng_error e)
    {
        this.e=e;
    }
    
    public void Run(String ruta,Pestania.Tipo t)
    {
        if(Pestania.Tipo.FS==t)
        {
            gramaticaFS(ruta);
        }else
        {
            gramaticaGxml(ruta);
        }
    }
    
    public void gramaticaGxml(String ruta)
    {
        //LinkedList<int> raiz = null;        
        try
        {
            lexico_g le = new lexico_g(new BufferedReader( new StringReader(getContenido(ruta))));            
            sintactico_g sintactico=new sintactico_g(le);
            sintactico.parse();            
           // raiz =sintactico.raiz;
            e.Adding(le.e);
            e.Adding(sintactico.e);
            /*if(raiz!=null)
            {
                for(sent s:raiz)
                {
                    s.Ejecutar(ts, e, txtSalida);
                }
            }else
            {
                this.txtError.setText("entrada incorrecta");
            }*/
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
    }
     public void gramaticaFS(String ruta)
    {
        //LinkedList<int> raiz = null;        
        try
        {
            lexico_fs le = new lexico_fs(new BufferedReader( new StringReader(getContenido(ruta))));            
            sintactico_fs sintactico=new sintactico_fs(le);
            sintactico.parse();            
           // raiz =sintactico.raiz;
            e.Adding(le.e);
            e.Adding(sintactico.e);
            /*if(raiz!=null)
            {
                for(sent s:raiz)
                {
                    s.Ejecutar(ts, e, txtSalida);
                }
            }else
            {
                this.txtError.setText("entrada incorrecta");
            }*/
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
    }
    public static String getContenido(String ruta)
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
        }
        catch(IOException ioe)
        {
		JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        }
        return contenido;
    }
}
