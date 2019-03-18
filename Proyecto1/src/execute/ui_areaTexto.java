/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import errors.mng_error;
import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JTextArea;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_areaTexto extends JTextArea implements ui{
     public Hashtable tabla;
     @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("CONTROL"))
        {
            valores.add(new Simbolo(var.tipo_areatexto,this));
        }else if(tag.equals("DEFECTO"))
        {
            valores.add(new Simbolo(var.tipo_cadena,
                    ((Simbolo)tabla.get("DEFECTO")).valor.toString()));
        }
    }
     @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE")))
        {
            valores.add(new Simbolo(var.tipo_areatexto,this));
        }
    }
     //.CrearAreaTexto(Alto, ancho, Fuente, Tamaño, Color, X, Y, Negrilla, Cursiva, defecto, nombre
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
    @Override    
    public String getTraduccion(String ventana,String panel,int num)
    {
         String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre=name+num+"_"+panel;
       
         String t="var "+nombre+ " = "+panel+ ".CrearAreaTexto("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+",\""+
                 ((Simbolo)tabla.get("FUENTE")).valor.toString()+"\","+
                 ((Simbolo)tabla.get("TAM")).valor.toString()+",\""+
                 ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                 ((((Simbolo)tabla.get("NEGRITA")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((((Simbolo)tabla.get("CURSIVA")).valor.toString()).equals("true")?"verdadero":"falso")+",\""+                
                ((Simbolo)tabla.get("DEFECTO")).valor.toString()+"\",\""+
                ((Simbolo)tabla.get("NOMBRE")).valor.toString()+
        "\");\n";        
        //MAXIMO
         t=t+nombre+".maximo="+((Simbolo)tabla.get("MAXIMO")).valor.toString()+";\n";
        //MINIMO
         t=t+nombre+".minimo="+((Simbolo)tabla.get("MINIMO")).valor.toString()+";\n";
        return t;
    }
     @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
    {
        try
        {
            int font=0;
            Boolean negrita=Boolean.valueOf(((Simbolo)tabla.get("NEGRITA")).valor.toString());
            Boolean cursiva=Boolean.valueOf(((Simbolo)tabla.get("CURSIVA")).valor.toString());
            if(negrita)
            {
                font=font+Font.BOLD;
            }
            if(cursiva)
            {
                font=font+Font.ITALIC;
            }
            int tam=Integer.valueOf(((Simbolo)tabla.get("TAM")).valor.toString());
            String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
            String color=((Simbolo)tabla.get("COLOR")).valor.toString();
            this.setFont(new java.awt.Font(fuente, font, tam));
            this.setForeground(Color.decode(color));
            /*int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
            int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
            this.setSize(alto,ancho);*/
             String def=((Simbolo)tabla.get("DEFECTO")).valor.toString();
             this.setText(def);
             this.setVisible(true);
        }catch(Exception exc)
        {
            e.AddError("No se pudo cargar el area texto "+getValor("NOMBRE"), 0, 0, "", "SEMANTICO");
        }
    }
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    public ui_areaTexto (int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre,
             int maximo,int minimo)
    {
        this.tabla=new Hashtable();
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,maximo,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,minimo,false));
        this.setVisible(false);
    }
    
     public ui_areaTexto (int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre)
    {
        this.tabla=new Hashtable();
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_area,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_area,false));
        this.setVisible(false);
    }
   
}
