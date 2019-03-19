/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;


import codigo_gdato.item;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import errors.mng_error;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JPanel;
import proyecto1.Reconize;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Pamela Palacios
 */
public class ui_imagen extends JPanel implements ui{
    public Hashtable tabla;
    @Override
    public void getDatos(LinkedList<item> it) {
        
    }
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("MULTIMEDIA"))
        {
            valores.add(new Simbolo(var.tipo_imagen,this));
        }
    }
    @Override
     public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE")))
        {
            valores.add(new Simbolo(var.tipo_imagen,this));
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
        String t="var "+nombre+ " = "+panel+ ".CrearImagen(\""+
                ((Simbolo)tabla.get("RUTA")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                //((((Simbolo)tabla.get("AUTO_REPRODUCCION")).valor.toString()).equals("true")?"verdadero":"falso")+","+
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
            /*media.cargar(this,videos,Integer.valueOf(getValor("ANCHO")),Integer.valueOf(getValor("ALTO")),
                Integer.valueOf(getValor("X")),Integer.valueOf(getValor("Y")),
                Reconize.getDireccion(getValor("RUTA")),Boolean.valueOf(getValor("AUTO_REPRODUCCION")));*/
            Integer ancho=Integer.valueOf(getValor("ANCHO"));
            Integer alto=Integer.valueOf(getValor("ALTO"));
            Integer x=Integer.valueOf(getValor("X"));
            Integer y=Integer.valueOf(getValor("Y"));
            String file=Reconize.getDireccion(getValor("RUTA"));
            Canvas c= new Canvas();
            c.setBackground(Color.BLACK);
            c.setSize(ancho, alto);
            c.setPreferredSize(new Dimension(ancho,alto));
            //JPanel video=new JPanel();
            this.setLayout(null);
            this.setBounds(x,y,ancho, alto);
            this.setPreferredSize(new Dimension(ancho, alto));
            this.add(c);
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\Program Files\\VideoLAN\\VLC");
            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
            MediaPlayerFactory mpf= new MediaPlayerFactory();
            EmbeddedMediaPlayer emp=mpf.newEmbeddedMediaPlayer();
            emp.setVideoSurface(mpf.newVideoSurface(c));  
        //String file=Reconize.getDireccion("C:\\Users\\Pamela Palacios\\Desktop\\pilita.mp4");
            emp.prepareMedia(file);
            videos.add(emp);
            this.setVisible(true);
        }catch(Exception exc)
        {
            e.AddError("No se pudo cargar imagen "+getValor("NOMBRE"), 0, 0, "", "SEMANTICO");
        }
    }
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    public ui_imagen(String ruta,int x,int y,Boolean autoplay,int alto,int ancho,String nombre)
    {
        this.tabla=new Hashtable();
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,autoplay,false));
        this.setVisible(false);
    }
       public ui_imagen(String ruta,int x,int y,/*Boolean autoplay,*/int alto,int ancho)
    {
        this.tabla=new Hashtable();
        this.tabla.put("RUTA", new Simbolo(var.tipo_cadena,ruta,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("AUTO_REPRODUCCION", new Simbolo(var.tipo_booleano,true,false));
        this.setVisible(false);
    }
}
