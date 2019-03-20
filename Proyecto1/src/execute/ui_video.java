/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;


import codigo_gdato.item;
import errors.mng_error;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JPanel;
import proyecto1.Reconize;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_video extends JPanel implements ui{
    public Hashtable tabla;
    @Override
    public void getDatos(LinkedList<item> it) {
        
    }
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("MULTIMEDIA"))
        {
            valores.add(new Simbolo(var.tipo_video,this));
        }
    }
    @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE").trim().toUpperCase()))
        {
            valores.add(new Simbolo(var.tipo_video,this));
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
    @Override
    public String getTraduccion(String ventana,String panel,int num)
    {
        //Contenedor.CrearImagen(Ruta, X, Y, Auto-reproductor, Alto, Ancho)
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre=name+num+"_"+panel;
        String t="var "+nombre+ " = "+panel+ ".CrearVideo(\""+
                ((Simbolo)tabla.get("RUTA")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                ((((Simbolo)tabla.get("AUTO_REPRODUCCION")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+
        ");\n";
        t=t+nombre+".nombre=\""+name+"\";\n";
        return t;
    }   
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
    {
        try
        {
            media.cargar(this,videos,Integer.valueOf(getValor("ANCHO")),Integer.valueOf(getValor("ALTO")),
                Integer.valueOf(getValor("X")),Integer.valueOf(getValor("Y")),
                Reconize.getDireccion(getValor("RUTA")),Boolean.valueOf(getValor("AUTO_REPRODUCCION")));
        }
        catch(Exception exc)
        {
            e.AddError("No se pudo cargar video "+getValor("NOMBRE"), 0, 0, "", "SEMANTICO");
        }
    }
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    public ui_video(String ruta,int x,int y,Boolean autoplay,int alto,int ancho,String nombre)
    {
        this.tabla=new Hashtable();
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre.toUpperCase(),false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,autoplay,false));
        this.setVisible(false);
    }
    public ui_video(String ruta,int x,int y,Boolean autoplay,int alto,int ancho)
    {
        this.tabla=new Hashtable();
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,autoplay,false));
        this.setVisible(false);
    }
}
