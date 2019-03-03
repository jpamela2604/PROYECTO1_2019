/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.Array;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;
import proyecto1.ExtremeEditor;
import static proyecto1.ExtremeEditor.arrayPanel;
import proyecto1.Reconize;

/**
 *
 * @author Pamela Palacios
 */
public class Ejecucion {
    public JTextArea a;
    public Ejecucion(JTextArea a)
    {
        this.a=a;
    }
    public void Imprimir(String valor)
    {
        this.a.setText(a.getText()+valor+"\n");
    }
    public void GuardarDatos(String ventana,String contenido)
    {
        
        String ruta=ExtremeEditor.ru+"\\"+ventana+".gxml";
        contenido=trueContent(ruta,contenido);        
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
    public String trueContent(String ruta,String contenido)
    {
        String valor="<lista tipo=\"principal\">\n"+contenido+"\n</lista>";
        String leido=Reconize.getContenido(ruta);
        if(!leido.equals(""))
        {
            valor=leido.replace("</lista>","\n"+ contenido+"\n</lista>");
        }
        
        return valor;
    }
    String leer(String ruta)
    {
        String w="";
        try {
            Scanner input = new Scanner(new File("/ruta/filename.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                //System.out.println(line);
                w=w+"\n";
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return w;
    }
    
    
    public ui_ventana CrearVentana(String id,String tipo)
    {
        ui_ventana ventana= new ui_ventana(id,tipo);
        return ventana;
    }
     public ui_ventana CrearVentana(String color,Integer alto,Integer ancho)
    {
        ui_ventana ventana= new ui_ventana(color,alto,ancho);
        return ventana;
    }
    public ui_contenedor CrearContenedor(String id,int x,int y)
    {
        ui_contenedor contenedor= new ui_contenedor( id, x, y);
        return contenedor;
    }
    public ui_contenedor CrearContenedor(int alto,int ancho,String color,Boolean borde,int x,int y)
    {
        ui_contenedor contenedor= new ui_contenedor( alto,ancho,color,borde, x, y);
        return contenedor;
    }
    
    public ui_texto CrearTexto(String id,int x,int y)
    {
        ui_texto texto= new ui_texto( id, x, y);
        return texto;
    }
    public ui_texto CrearTexto(String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)
    {
        ui_texto texto= new ui_texto( fuente,tam,color,x,y,negrilla,cursiva,valor);
        return texto;
    }
    public ui_boton CrearBoton(String nombre,int x,int y)
    {
        ui_boton boton =new ui_boton(nombre,x,y);
        return boton;
    }
    public ui_boton CrearBoton(String fuente,int tam,String color,int x,int y,String ref,String val,int alto,int ancho)
    {
        ui_boton boton =new ui_boton(fuente,tam,color,x,y,ref,val,alto,ancho);
        return boton;
    }
    public ui_areaTexto CrearAreaTexto(String nombre,int x,int y)
    {
        ui_areaTexto areaTexto =new ui_areaTexto(nombre,x,y);
        return areaTexto;
    }
    public ui_areaTexto CrearAreaTexto(int alto,int ancho,String fuente,int tam,String color,
            int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre)
    {
        ui_areaTexto areaTexto=new ui_areaTexto(alto,ancho,fuente,tam,color,x,y,negrilla,cursiva,defecto,nombre);
        return  areaTexto;
    }
    public ui_cajaTexto CrearCajaTexto(String nombre,int x,int y)
    {
        ui_cajaTexto cajaTexto=new ui_cajaTexto(nombre,x,y);
        return  cajaTexto;
    }
    
    public ui_cajaTexto CrearCajaTexto(int alto,int ancho,String fuente,int tam,String color,
            int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre)
    {
        ui_cajaTexto cajaTexto=new ui_cajaTexto(alto,ancho,fuente,tam,color,x,y,negrilla,cursiva,defecto,nombre);
        return  cajaTexto;
    }
    public ui_ControlNumerico CrearControlNumerico(String nombre,int x,int y)
    {
        ui_ControlNumerico numerico=new ui_ControlNumerico(nombre,x,y);
        return  numerico;
    }
     public ui_ControlNumerico CrearControlNumerico(int alto,int ancho,int max,int min,int x,int y,int def,String nombre)
    {
        ui_ControlNumerico numerico=new ui_ControlNumerico(alto,ancho,max,min,x,y,def,nombre);
        return  numerico;
    }
    public ui_desplegable CrearDesplegable(String nombre,int x,int y)
    {
        ui_desplegable desplegable=new ui_desplegable(nombre,x,y);  
        
        return  desplegable;
    }
    
    public ui_desplegable CrearDesplegable(int alto,int ancho,Array lista,int x,int y,String defecto,String nombre)
    {
        ui_desplegable desplegable=new ui_desplegable(alto,ancho,lista,x,y,defecto,nombre);  
        
        return  desplegable;
    }
    
    public ui_reproductor CrearReproductor(String ruta,String nombre,int x,int y)
    {
        ui_reproductor musica=new ui_reproductor(ruta,nombre,x,y);
        return musica;
    }
    public ui_reproductor CrearReproductor(String ruta,int x,int y,Boolean auto,int alto,int ancho)
    {
        ui_reproductor musica=new ui_reproductor(ruta,x,y,auto,alto,ancho);
        return musica;
    }
    public ui_video CrearVideo(String ruta,String nombre,int x,int y)
    {
        ui_video video=new ui_video(ruta,nombre,x,y);
        return video;
    }
    public ui_video CrearVideo(String ruta,int x,int y,Boolean auto,int alto,int ancho)
    {
        ui_video video=new ui_video(ruta,x,y,auto,alto,ancho);
        return video;
    }
     public ui_imagen CrearImagen(String ruta,String nombre,int x,int y)
    {
        ui_imagen imagen=new ui_imagen(ruta,nombre,x,y);
        return imagen;
    }
     public ui_imagen CrearImagen(String ruta,int x,int y,Boolean auto,int alto,int ancho)
    {
        ui_imagen imagen=new ui_imagen(ruta,x,y,auto,alto,ancho);
        return imagen;
    }
}
