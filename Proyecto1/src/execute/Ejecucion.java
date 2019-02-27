/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

/**
 *
 * @author Pamela Palacios
 */
public class Ejecucion {
    public Ejecucion()
    {
    }
    public void Imprimir(String valor)
    {
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
    public ui_texto CrearTexto(String id,int x,int y)
    {
        ui_texto texto= new ui_texto( id, x, y);
        return texto;
    }
    public ui_boton CrearBoton(String nombre,int x,int y)
    {
        ui_boton boton =new ui_boton(nombre,x,y);
        return boton;
    }
    public ui_areaTexto CrearAreaTexto(String nombre,int x,int y)
    {
        ui_areaTexto areaTexto =new ui_areaTexto(nombre,x,y);
        return areaTexto;
    }
    public ui_cajaTexto CrearCajaTexto(String nombre,int x,int y)
    {
        ui_cajaTexto cajaTexto=new ui_cajaTexto(nombre,x,y);
        return  cajaTexto;
    }
    public ui_ControlNumerico CrearControlNumerico(String nombre,int x,int y)
    {
        ui_ControlNumerico numerico=new ui_ControlNumerico(nombre,x,y);
        return  numerico;
    }
    public ui_desplegable CrearDesplegable(String nombre,int x,int y)
    {
        ui_desplegable desplegable=new ui_desplegable(nombre,x,y);  
        
        return  desplegable;
    }
    
    public ui_reproductor CrearReproductor(String ruta,String nombre,int x,int y)
    {
        ui_reproductor musica=new ui_reproductor(ruta,nombre,x,y);
        return musica;
    }
    public ui_video CrearVideo(String ruta,String nombre,int x,int y)
    {
        ui_video video=new ui_video(ruta,nombre,x,y);
        return video;
    }
     public ui_imagen CrearImagen(String ruta,String nombre,int x,int y)
    {
        ui_imagen imagen=new ui_imagen(ruta,nombre,x,y);
        return imagen;
    }
}
