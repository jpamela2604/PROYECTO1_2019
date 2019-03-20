/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_gdato.item;
import errors.mng_error;
import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JLabel;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_texto extends JLabel implements ui{
     public Hashtable tabla;
     @Override
    public void getDatos(LinkedList<item> it) {
        
    }
     @Override
     public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("TEXTO"))
        {
            valores.add(new Simbolo(var.tipo_texto,this));
        }
    }
     @Override
     public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE").trim().toUpperCase()))
        {
            valores.add(new Simbolo(var.tipo_texto,this));
        }
    }
     @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
     @Override
    //CrearTexto(Fuente, tam, Color, X, Y, Negrilla, Cursiva, valor)
    public String getTraduccion(String ventana,String panel,int num)
    {
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre=name+num+"_"+panel;
        String t="var "+nombre+ " = "+panel+ ".CrearTexto(\""+
                ((Simbolo)tabla.get("FUENTE")).valor.toString()+"\","
                +((Simbolo)tabla.get("TAM")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                ((((Simbolo)tabla.get("NEGRITA")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((((Simbolo)tabla.get("CURSIVA")).valor.toString()).equals("true")?"verdadero":"falso")+",\""+
                ((Simbolo)tabla.get("VALOR")).valor.toString()+
        "\");\n";
        t=t+nombre+".nombre=\""+name+"\";\n";
        
        return t;
    }
    
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
    {
        try
        {
            int tam=Integer.valueOf(((Simbolo)tabla.get("TAM")).valor.toString());
            String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
            String color=((Simbolo)tabla.get("COLOR")).valor.toString();
            Boolean negrita=Boolean.valueOf(((Simbolo)tabla.get("NEGRITA")).valor.toString());
            Boolean cursiva=Boolean.valueOf(((Simbolo)tabla.get("CURSIVA")).valor.toString());
            int font=0;
            if(negrita)
            {
                font=font+Font.BOLD;
            }
            if(cursiva)
            {
                font=font+Font.ITALIC;
            }
            this.setFont(new java.awt.Font(fuente, font, tam));
            this.setForeground(Color.decode(color));
            String valor=((Simbolo)tabla.get("VALOR")).valor.toString();
            this.setText("<html>"+valor+"</html>");
            int xx=Integer.valueOf(((Simbolo)tabla.get("X")).valor.toString());
            int yy=Integer.valueOf(((Simbolo)tabla.get("Y")).valor.toString());
            int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
            int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
            //setsize(width,height)
            //this.setSize(ancho>this.getWidth()?ancho:this.getWidth(),alto);
            //setBounds(int x, int y, int width, int height)
            
            this.setBounds(xx, yy, getmyWidth(),
                    alto>this.getPreferredSize().height?alto:this.getPreferredSize().height);
            this.setVisible(true);
            this.repaint();
        }
        catch(Exception exc)
        {
            e.AddError("No se pudo cargar texto "+getValor("NOMBRE"), 0, 0, "", "SEMANTICO");
        }
    }
    Integer getmyWidth()
    {
        Integer anchoActual=Integer.valueOf(getValor("ANCHO"));
        Integer ancho=this.getPreferredSize().width;
        if(ancho>anchoActual)
        {
            ((Simbolo)tabla.get("ANCHO")).valor=ancho;
            return ancho;
        }
        return anchoActual;        
    }
    
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
     public ui_texto(String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)
    {        
        this.tabla=new Hashtable();   
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false)); 
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,var.alto_t,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,var.ancho_t,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_t,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_t,false));
        this.setVisible(false);
        
    }  
    public ui_texto(String nombre,String fuente,int tam,String color,int x,int y,Boolean negrilla,
            Boolean cursiva,String valor)
    {
        this.tabla=new Hashtable();
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));   
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre.toUpperCase(),false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,var.alto_t,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,var.ancho_t,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_t,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_t,false));
        this.setVisible(false);
    }
    
}
