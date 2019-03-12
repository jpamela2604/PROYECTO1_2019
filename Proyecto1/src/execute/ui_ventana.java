/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.sent;
import codigo_gdato.item;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ventana extends JFrame implements ui{
    //ELEMENTOS
    public LinkedList<ui_contenedor> contenedores;
    public Hashtable tabla;
    public sent AccionInicial;
    public sent AccionFinal;
    public String inicial;
    public String fin;
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.toUpperCase().trim().equals(getValor("VENTANA")))
        {
            valores.add(new Simbolo(var.tipo_ventana,this));
        }else
        {
            for(ui_contenedor ven:this.contenedores)
            {
                ven.getByTag(tag, valores);
            }
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
        if(id.toUpperCase().trim().equals(getValor("ID")))
        {
            valores.add(new Simbolo(var.tipo_ventana,this));
        }
        for(ui_contenedor con:this.contenedores)
        {
            con.getById(id, valores);
        }
    }
    
    @Override
     public void getByNombre(String nombre,LinkedList<Simbolo>valores)
    {
       
        for(ui_contenedor con:this.contenedores)
        {
            con.getByNombre(nombre, valores);
        }
    }
    
    
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos)
    {
        int xp=0;
        int yp=0;
        int anchop=0;
        int altop=0;
        //this.setLayout(null);
        JPanel principal=new JPanel();
        principal.setLayout(null);
        JScrollPane sprin = new JScrollPane();
        for(ui_contenedor c:contenedores)
        {
            c.cargar(videos);
            JScrollPane sp = new JScrollPane();
            sp.getViewport().add(c);
            //c.setLocation(xx, yy);
            //sp.setLayout(null);
            int x=Integer.valueOf(((Simbolo)c.tabla.get("X")).valor.toString());
            int y=Integer.valueOf(((Simbolo)c.tabla.get("Y")).valor.toString());
            int alto=Integer.valueOf(((Simbolo)c.tabla.get("ALTO")).valor.toString());
            int ancho=Integer.valueOf(((Simbolo)c.tabla.get("ANCHO")).valor.toString());
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            //setBounds(int x, int y, int width, int height)
            sp.setBounds(x, y, ancho, alto);
            principal.add(sp);
            this.repaint();
            if(xp<=x)
            {
                xp=x;
                anchop=ancho;
            }
            if(yp<=y)
            {
                yp=y;
                altop=alto;
            }
        }
        sprin.getViewport().add(principal);
        sprin.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sprin.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        principal.setLayout(null);
        principal.setBackground(Color.decode(((Simbolo)tabla.get("COLOR")).valor.toString()));
        //new dimension(height,width)
        principal.setPreferredSize(new Dimension(xp+anchop+50,yp+altop+50));
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //new dimension(height,width)
        this.setPreferredSize(new Dimension(ancho ,alto));
        this.setMaximumSize(new Dimension(ancho,alto));
        this.setMaximumSize(new Dimension(ancho,alto));
        //setBounds(int x, int y, int width, int height)
        sprin.setBounds(0, 0, ancho, alto);
        //principal.add(sprin);
        this.add(sprin);
        this.pack();
        
    }  
    @Override
    public String getTraduccion(String ventana,String panel)
    {
        //CrearVentana(“Color hexadecimal”, Alto, ancho
        String name=((Simbolo)tabla.get("ID")).valor.toString();
        String nombre="ven_"+name;
        String t="var "+nombre+"=crearVentana(\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+
                ");\n";
        t=t+(inicial.equals("")?"":nombre+".alcargar("+inicial+");\n");
        t=t+(fin.equals("")?"":nombre+".alcerrar("+fin+");\n");
        if("PRINCIPAL".equals(((Simbolo)tabla.get("TIPO")).valor.toString().toUpperCase()))
        {
            t=t+nombre+".alcargar();\n";
        }
        for(ui_contenedor con :this.contenedores)
        {
            t=t+con.getTraduccion(nombre,"");
        }
        
        return t;
    }
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    public ui_ventana(String id,String tipo,String color,String inicial,String fin)
    {
        this.inicial=inicial;
        this.fin=fin;
        this.tabla=new Hashtable();
        this.contenedores=new LinkedList();
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,id,false));
        //this.id=id;
        //this.tipo=tipo;
        this.tabla.put("TIPO", new Simbolo(var.tipo_cadena,tipo,false));
        //this.alto=500;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,var.alto_ven,false));
        //this.ancho=500;
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,var.ancho_ven,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        //this.color="";
    }
     public ui_ventana(String color,int alto,int ancho)
    {
        this.inicial="";
        this.fin="";
        this.tabla=new Hashtable();
        this.contenedores=new LinkedList();
        //this.id="";
        this.tabla.put("ID", new Simbolo(var.tipo_cadena,"",false));
        //this.tipo="SECUNDARIA";
        this.tabla.put("TIPO", new Simbolo(var.tipo_cadena,"SECUNDARIA",false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        //this.color=color;
        //this.ancho=ancho;
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        //this.alto=alto;
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        
    }
   public LinkedList<item> getValores()
    {
        LinkedList<item> valores=new LinkedList();
        for(ui_contenedor c:contenedores)
        {
            LinkedList<item> va=c.getValores();
            for(item i:va)
            {
                valores.add(i);
            }
        }
        return valores;
    }
    
    public LinkedList<Simbolo> getByNombre(String Nombre)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();
        for(ui_contenedor c:this.contenedores)
        {
            LinkedList<Simbolo> aux=c.getByNombre(Nombre);
            for(Simbolo p:aux)
            {
                elemntos.add(p);
            }
        }     
        
        return elemntos;
    }
    
    
    public LinkedList<Simbolo> getByTag(String tag)
    {
        LinkedList<Simbolo> elemntos=new LinkedList();  
        switch(tag.toUpperCase())
        {
            case "CONTENEDOR":
            {
                for(ui_contenedor con:this.contenedores)
                {
                    elemntos.add(new Simbolo(var.tipo_contenedor,con));
                }
            }break;
            default:
            {
                for(ui_contenedor v:this.contenedores)
                {
                    LinkedList<Simbolo> el=v.getByTag(tag);
                    for(Simbolo s:el)
                    {
                        elemntos.add(s);
                    }
                }
            }break;
        }
        return elemntos;
    }
    
    
}
