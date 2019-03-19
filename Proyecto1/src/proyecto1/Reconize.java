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
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JTextArea;
import static proyecto1.Manager_Archivo.getContenido;
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
    
    public ui_gxml gramaticaGxml(String ruta)
    {
        etiqueta raiz = null;        
        try
        {            
            String con=getContenido(ruta,false);
            if(con!=null&&!con.equals(""))
            {
                lexico_g le = new lexico_g( new StringReader(con));            
                sintactico_g sintactico=new sintactico_g(le);
                sintactico.parse();            
                raiz =sintactico.raiz;
                e.Adding(le.e);
                e.Adding(sintactico.e);
            }
            if(raiz!=null)
            {
                 raiz.Comprobar(e);
                 if(this.e.errores.isEmpty())
                 {
                    ui_gxml archivo=(ui_gxml) raiz.GetGxmlObject();
                    String ruta2=ruta.replace(".gxml", "");
                    ruta2=ruta2+".fs";
                    GuardarDatos(ruta2,archivo.getTraduccion("","",0));
                    a.setText("Archivo traducido en la ruta "+ruta2);
                    // System.out.println(archivo.getTraduccion());
                 }
            }else
            {
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
        return null;
    }
    
    public static void GuardarDatos(String ruta,String contenido)
    {
              
        FileWriter fw;
        try
        {   
            fw= new FileWriter(ruta);
            fw.write(contenido);
            fw.close();        
                //JOptionPane.showMessageDialog(null, "Guardado Exitosamente ");
         }
        catch(IOException io)
        {
                  //l3.setText("Error al abrir el fichero");
                 //JOptionPane.showMessageDialog(null, "Error al guardar ");
        }        
    }
    
    public void gramaticaFS(String ruta)
    {
        LinkedList<sent> raiz = null;        
        try
        {
            String con=getContenido(ruta,false);
            mng_ts ts=new mng_ts(e);
            ui_gxml deTodo=new ui_gxml();
            Ejecucion ej=new Ejecucion(this.a,deTodo);
            if(con!=null&&!con.equals(""))
            {
                lexico_fs le = new lexico_fs(new StringReader(con));            
                sintactico_fs sintactico=new sintactico_fs(le);
                sintactico.parse();            
                raiz =sintactico.raiz;
                e.Adding(le.e);
                e.Adding(sintactico.e);
            }
            if(raiz!=null)
            {
                ts.imports.push(ruta);
                for(sent s:raiz)
                {
                    s.cargar(ts, e, ej);
                }
                for(sent s:raiz)
                {
                    s.ejecutar(ts, e, ej);
                }
                deTodo.iniciar(deTodo.principal,ts, e, ej);
                ts.imports.pop();
            }else
            {
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
            }
        }catch(Exception ex){

                System.out.println("ex: "+ex.getMessage());
                e.AddError("entrada incorrecta", 0, 0, var.archivo, "EJECUCION");
        }
        
        
    }/*
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
    */
    public static String getDireccion(String relativa)
    {
        if(relativa.contains("C:\\"))
        {
            return relativa;
        }
        //String r=ExtremeEditor.ru+"\\"+relativa;
        
        return (ExtremeEditor.ru+"\\"+(relativa.contains("/")?relativa.replace("/","\\"):relativa)).replace("\\\\", "\\");
    }
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
