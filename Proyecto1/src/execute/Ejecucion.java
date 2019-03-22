/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.Array;
import codigo_fs.sent;
import javax.swing.JTextArea;
import proyecto1.ExtremeEditor;
import proyecto1.Manager_Archivo;

/**
 *
 * @author Pamela Palacios
 */
public class Ejecucion {
    public JTextArea a;
    public ui_gxml deTodo;
    public Ejecucion(JTextArea a,ui_gxml deTodo)
    {
        this.a=a;
        this.deTodo=deTodo;
    }
    public void Imprimir(String valor)
    {
        this.a.setText(a.getText()+">> "+valor+"\n");
    }
    public void GuardarDatos(String ventana,String contenido)
    {
        
        String ruta=ExtremeEditor.ru+"\\"+ventana+".gdato";
        contenido=trueContent(ruta,contenido);       
        Manager_Archivo.escribir(ruta,contenido);
            
    }
    public String trueContent(String ruta,String contenido)
    {
        String valor="<lista>\n"+contenido+"\n</lista>";
        String leido=Manager_Archivo.getContenido(ruta,false);
        if(!leido.equals(""))
        {
            valor=leido.replace("</lista>","\n"+ contenido+"\n</lista>");
        }
        
        return valor;
    }    
    
     public ui_ventana CrearVentana(String color,Integer alto,Integer ancho,String id)
    {
        ui_ventana ventana= new ui_ventana(color,alto,ancho,id);
        return ventana;
    }
    
    public ui_contenedor CrearContenedor(int alto,int ancho,String color,Boolean borde,int x,int y)
    {
        ui_contenedor contenedor= new ui_contenedor( alto,ancho,color,borde, x, y);
        return contenedor;
    }
    
   
    public ui_texto CrearTexto(String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)
    {
        ui_texto texto= new ui_texto( fuente,tam,color,x,y,negrilla,cursiva,valor);
        return texto;
    }
    public ui_boton CrearBoton(String fuente,int tam,String color,int x,int y,sent ref,String val,int alto,int ancho)
    {
        ui_boton boton =new ui_boton(fuente,tam,color,x,y,ref,val,alto,ancho);
        return boton;
    }
   
    public ui_areaTexto CrearAreaTexto(int alto,int ancho,String fuente,int tam,String color,
            int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre)
    {
        ui_areaTexto areaTexto=new ui_areaTexto(alto,ancho,fuente,tam,color,x,y,negrilla,cursiva,defecto,nombre);
        return  areaTexto;
    }
    
    
    public ui_cajaTexto CrearCajaTexto(int alto,int ancho,String fuente,int tam,String color,
            int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre)
    {
        ui_cajaTexto cajaTexto=new ui_cajaTexto(alto,ancho,fuente,tam,color,x,y,negrilla,cursiva,defecto,nombre);
        return  cajaTexto;
    }
    
     public ui_ControlNumerico CrearControlNumerico(int alto,int ancho,int max,int min,int x,int y,int def,String nombre)
    {
        ui_ControlNumerico numerico=new ui_ControlNumerico(alto,ancho,max,min,x,y,def,nombre);
        return  numerico;
    }
    
    
    public ui_desplegable CrearDesplegable(int alto,int ancho,Array lista,int x,int y,String defecto,String nombre)
    {
        ui_desplegable desplegable=new ui_desplegable(alto,ancho,lista,x,y,defecto,nombre);  
        
        return  desplegable;
    }
    
    
    public ui_reproductor CrearReproductor(String ruta,int x,int y,Boolean auto,int alto,int ancho)
    {
        ui_reproductor musica=new ui_reproductor(ruta,x,y,auto,alto,ancho);
        return musica;
    }
    
    public ui_video CrearVideo(String ruta,int x,int y,Boolean auto,int alto,int ancho)
    {
        ui_video video=new ui_video(ruta,x,y,auto,alto,ancho);
        return video;
    }
    
     public ui_imagen CrearImagen(String ruta,int x,int y,int alto,int ancho)
    {
        ui_imagen imagen=new ui_imagen(ruta,x,y,alto,ancho);
        return imagen;
    }
}
