/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;


import codigo_gdato.item;
import errors.mng_error;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_contenedor extends JPanel implements ui{
    public Hashtable tabla;
    public LinkedList<ui> componentes;
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("CONTENEDOR"))
        {
            valores.add(new Simbolo(var.tipo_contenedor,this));
        }else
        {
            for(ui ven:this.componentes)
            {
                ven.getByTag(tag, valores);
            }
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
        if(id.equals(getValor("ID").trim().toUpperCase()))
        {
            valores.add(new Simbolo(var.tipo_contenedor,this));
        }
    }
    @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {        
        for(ui con:this.componentes)
        {
            con.getByNombre(ventana,nombre, valores);
        }
    }
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
    {
        try
        {
            this.setLayout(null);
            Boolean borde=Boolean.valueOf(((Simbolo)tabla.get("BORDE")).valor.toString());
            if(borde)
            {
                this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));        
            }
            String color=((Simbolo)tabla.get("COLOR")).valor.toString();
            this.setBackground(Color.decode(color));
            int x=0;
            int y=0;
            int ancho=0;
            int alto=0;

            for(ui t:this.componentes)
            {
                if(t instanceof ui_areaTexto)
                {
                    t.cargar(videos,e);
                    JScrollPane sp = new JScrollPane();
                    sp.getViewport().add((JComponent)t);
                    sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    int altxo=Integer.valueOf(t.getValor("ALTO"));
                    int anchxo=Integer.valueOf(t.getValor("ANCHO"));
                    int xx=Integer.valueOf(t.getValor("X"));
                    int yy=Integer.valueOf(t.getValor("Y"));
                    //setBounds(int x, int y, int width, int height)
                    sp.setBounds(xx, yy, anchxo, altxo);
                    //t.setLocation(xx, yy);
                    if(xx+anchxo>=x+ancho)
                    {
                        x=xx;
                        ancho=anchxo;                
                    }
                    if(yy+altxo>=y+alto)
                    {
                        y=yy;
                        alto=altxo; 
                    }
                    this.add(sp);
                }else
                {
                    t.cargar(videos,e);
                    int xx=Integer.valueOf(t.getValor("X"));
                    int yy=Integer.valueOf(t.getValor("Y"));
                    //t.setLocation(xx, yy);
                    Integer anchxo=Integer.valueOf(t.getValor("ANCHO"));
                    Integer altxo=Integer.valueOf(t.getValor("ALTO"));
                    if(xx+anchxo>=x+ancho)
                    {
                        x=xx;
                        ancho=anchxo;                
                    }
                    if(yy+altxo>=y+alto)
                    {
                        y=yy;
                        alto=altxo; 
                    }
                    this.add((JComponent)t);
                }
            }


            this.validate();
            ////new dimension(height,width)
            this.setPreferredSize(new Dimension(x+ancho+50,y+alto+50));
            this.validate();
            this.setVisible(true);
        }catch(Exception exc)
        {
            System.out.println(""+exc.getMessage());
            e.AddError("No se pudo cargar el contenedor "+getValor("ID"), 0, 0, "", "SEMANTICO");
        }
    }
    @Override
    public String getTraduccion(String ventana,String panel,int num)
    {
        //CrearContenedor(Alto, Ancho, Color, Borde, X, Y)
        String name=((Simbolo)tabla.get("ID")).valor.toString();
        String nombre=name+num+"_"+ventana;
       
        String c="var "+nombre+"="+ventana+".crearcontenedor("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((((Simbolo)tabla.get("BORDE")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+
                ");\n";
        c=c+nombre+".id=\""+name+"\";\n\n";
        for(int i=0;i<this.componentes.size();i++)
        {
            c=c+this.componentes.get(i).getTraduccion(ventana, nombre,i)+"\n";
        }
        return c;
        
    }    
    
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    public ui_contenedor(int alto,int ancho,String color,Boolean borde,int x,int y,String id)
    {
        componentes=new LinkedList();
        this.tabla=new Hashtable();
        this.tabla.put("BORDE", new Simbolo(var.tipo_booleano,borde,false));
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,id.toUpperCase().trim(),false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.setVisible(false);
    }
    public ui_contenedor(int alto,int ancho,String color,Boolean borde,int x,int y)
    {
         componentes=new LinkedList();
        this.tabla=new Hashtable();
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("BORDE", new Simbolo(var.tipo_booleano,borde,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));        
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,"",false));
        this.setVisible(false);
    }
    
    
    
    @Override
    public void getDatos(LinkedList<item> it) {
        for(ui u:this.componentes)
        {
            u.getDatos(it);
        }
    }
   
    
    
    
}
