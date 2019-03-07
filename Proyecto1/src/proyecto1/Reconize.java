/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import codigo_fs.sent;
import codigo_gxml.etiqueta;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_gxml;
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
import javax.swing.JTextArea;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class Reconize {
    public mng_error e;
    public JTextArea a;
    public Reconize(mng_error e,JTextArea a)
    {
        this.e=e;
        this.a=a;
    }
    
    public void Run(String ruta,Pestania.Tipo t)
    {
        var.archivo=ruta;
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
        etiqueta raiz = null;        
        try
        {
            String con=getContenido(ruta,false);
            lexico_g le = new lexico_g(new BufferedReader( new StringReader(con)));            
            sintactico_g sintactico=new sintactico_g(le);
            sintactico.parse();            
            raiz =sintactico.raiz;
            e.Adding(le.e);
            e.Adding(sintactico.e);
            if(raiz!=null)
            {
                 raiz.Comprobar(e);
                 if(this.e.errores.isEmpty())
                 {
                    ui_gxml archivo=(ui_gxml) raiz.GetGxmlObject();
                     System.out.println(archivo.getTraduccion());
                 }
            }else
            {
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
    }
    
     public void gramaticaFS(String ruta)
    {
        LinkedList<sent> raiz = null;        
        try
        {
            lexico_fs le = new lexico_fs(new BufferedReader( new StringReader(getContenido(ruta,false))));            
            sintactico_fs sintactico=new sintactico_fs(le);
            sintactico.parse();            
            raiz =sintactico.raiz;
            e.Adding(le.e);
            e.Adding(sintactico.e);
            mng_ts ts=new mng_ts(e);
            Ejecucion ej=new Ejecucion(this.a);
            if(raiz!=null)
            {
                for(sent s:raiz)
                {
                    s.ejecutar(ts, e, ej);
                }
            }else
            {
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
    }
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
        }
        catch(IOException ioe)
        {
            if(bandera)
            {JOptionPane.showMessageDialog(null, "Error al abrir el archivo");}
        }
        return contenido;
    }
}
