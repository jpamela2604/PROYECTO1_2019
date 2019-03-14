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
        if(id.equals(getValor("ID")))
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
            e.AddError("No se pudo cargar el contenedor "+getValor("ID"), 0, 0, "", "SEMANTICO");
        }
    }
    @Override
    public String getTraduccion(String ventana,String panel)
    {
        //CrearContenedor(Alto, Ancho, Color, Borde, X, Y)
        String name=((Simbolo)tabla.get("ID")).valor.toString();
        String nombre="Con_"+name;
       
        String c="var "+nombre+"="+ventana+".crearcontenedor("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((((Simbolo)tabla.get("BORDE")).valor.toString()).equals("true")?"verdadero":"falso")+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+
                ");\n";
        c=c+nombre+".id=\""+name+"\";\n";
        for(ui com:this.componentes)
        {
            c=c+com.getTraduccion(ventana, nombre);
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
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,id,false));
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
    
    
    
    public LinkedList<Simbolo> getByNombre(String Nombre)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();
        /*
        for(ui_texto t:textos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_texto,t));
            }
        }
        for(ui_ControlNumerico t:spinners)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_controlnum,t));
            }
        }
        for(ui_areaTexto t:areas)
        {
           if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_areatexto,t));
            }
        }
        for(ui_cajaTexto t:cajas)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_cajatexto,t));
            }
        }
        for(ui_desplegable t:combobox)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_desplegable,t));
            }
        }
        for(ui_imagen t:imagenes)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_imagen,t));
            }
        }
        for(ui_video t:videos)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_video,t));
            }
        }
        for(ui_reproductor t:musica)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
                elemntos.add(new Simbolo(var.tipo_reproductor,t));
            }
        }
        for(ui_boton t:botones)
        {
            if(((Simbolo)t.tabla.get("NOMBRE")).valor.toString().equals(Nombre))
            {
               elemntos.add(new Simbolo(var.tipo_boton,t));
            }
        }*/
        return elemntos;
    }
    public LinkedList<item> getValores()
    {
        LinkedList<item> valores=new LinkedList();
        /*for(ui_ControlNumerico t:spinners)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,t.getValue(),0,0,""));
        }
        for(ui_areaTexto t:areas)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,"\""+t.getText()+"\"",0,0,""));
        }
        for(ui_cajaTexto t:cajas)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            valores.add(new item(nombre,"\""+t.getText()+"\"",0,0,""));
        }
        for(ui_desplegable t:combobox)
        {
            String nombre=((Simbolo)t.tabla.get("NOMBRE")).valor.toString();
            Array lista=(Array) ((Simbolo)t.tabla.get("LISTA")).valor;
            Simbolo v=lista.valores.get(t.getSelectedIndex());
            String valor="";
            if(v!=null)
            {
                if(v.tipo.indice==var.booleano)
                {
                    if(Boolean.valueOf(v.valor.toString()))
                    {
                        valor="verdadero";
                    }else
                    {
                        valor="falso";
                    }
                }else if(v.tipo.indice==var.nulo)
                {
                    valor="nulo";
                }
                else
                {
                    valor=v.valor.toString();
                }
                
                if(!(v.tipo.indice==var.entero||v.tipo.indice==var.decimal))
                {
                    valor="\""+valor+"\"";
                }
            }
            valores.add(new item(nombre,valor,0,0,""));
        }*/
        return valores;
    }
    
    public LinkedList<Simbolo> getByTag(String tag)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();  
        /*
        switch(tag.toUpperCase())
        {
            case "TEXTO":
            {
                for(ui_texto con:this.textos)
                {
                    elemntos.add(new Simbolo(var.tipo_texto,con));
                }
            }break;
            case "CONTROLADOR":
            {
                for(ui_areaTexto con:this.areas)
                {
                    elemntos.add(new Simbolo(var.tipo_areatexto,con));
                }
                for(ui_cajaTexto con:this.cajas)
                {
                    elemntos.add(new Simbolo(var.tipo_cajatexto,con));
                }
                for(ui_desplegable con:this.combobox)
                {
                    elemntos.add(new Simbolo(var.tipo_desplegable,con));
                }
                for(ui_ControlNumerico con:this.spinners)
                {
                    elemntos.add(new Simbolo(var.tipo_controlnum,con));
                }
            }break;
            case "MULTIMEDIA":
            {
                for(ui_reproductor con:this.musica)
                {
                    elemntos.add(new Simbolo(var.tipo_reproductor,con));
                }
                for(ui_video con:this.videos)
                {
                    elemntos.add(new Simbolo(var.tipo_video,con));
                }
                for(ui_imagen con:this.imagenes)
                {
                    elemntos.add(new Simbolo(var.tipo_imagen,con));
                }
            }break;
            case "BOTON":
            {
                for(ui_boton con:this.botones)
                {
                    elemntos.add(new Simbolo(var.tipo_boton,con));
                }
            }break;
            case "ENVIAR":
            {
                for(ui_boton con:this.botones)
                {
                    elemntos.add(new Simbolo(var.tipo_boton,con));
                }
            }break;
            
        }
        */
        return elemntos;
    }
    
}
