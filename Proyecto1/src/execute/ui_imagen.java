/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_imagen extends JButton implements ui{
    public Hashtable tabla;
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.toUpperCase().trim().equals(getValor("MULTIMEDIA")))
        {
            valores.add(new Simbolo(var.tipo_imagen,this));
        }
    }
    @Override
     public void getByNombre(String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.toUpperCase().trim().equals(getValor("NOMBRE")))
        {
            valores.add(new Simbolo(var.tipo_imagen,this));
        }
    }
     @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
     @Override
     public String getTraduccion(String ventana,String panel)
    {
        //Contenedor.CrearImagen(Ruta, X, Y, Auto-reproductor, Alto, Ancho)
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre="Imagen_"+name;
        String t="var "+nombre+ " = "+panel+ ".CrearImagen(\""+
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
    public void cargar()
    {
        this.setText("");
        this.setIcon(new ImageIcon(((Simbolo)tabla.get("RUTA")).valor.toString()));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //setsize(width,height)
        this.setSize(ancho,alto);
        this.setLocation(Integer.valueOf(getValor("X")),Integer.valueOf(getValor("Y")));
        this.setVisible(true);
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
       public ui_imagen(String ruta,int x,int y,Boolean autoplay,int alto,int ancho)
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
