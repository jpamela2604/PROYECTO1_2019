/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;


import codigo_gdato.item;
import errors.mng_error;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyecto1.Reconize;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_imagen extends JLabel implements ui{
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
        if(nombre.equals(getValor("NOMBRE").trim().toUpperCase()))
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
            Integer ancho=Integer.valueOf(getValor("ANCHO"));
            Integer alto=Integer.valueOf(getValor("ALTO"));
            Integer x=Integer.valueOf(getValor("X"));
            Integer y=Integer.valueOf(getValor("Y"));
            String ruta=Reconize.getDireccion(getValor("RUTA"));
            BufferedImage myPicture = ImageIO.read(new File(ruta));
            Image scaledInstance = myPicture.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);           
            this.setIcon(new ImageIcon(scaledInstance));
            this.setBounds(x, y, ancho, alto);
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
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre.toUpperCase().trim(),false));
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
