/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import errors.mng_error;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_ControlNumerico extends JSpinner implements ui{
   
    public Hashtable tabla;
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("CONTROL"))
        {
            valores.add(new Simbolo(var.tipo_controlnum,this));
        }else if(tag.equals("DEFECTO"))
        {
            valores.add(new Simbolo(var.tipo_entero,
                    Integer.valueOf(((Simbolo)tabla.get("DEFECTO")).valor.toString())));
        }
    }
    @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE")))
        {
            valores.add(new Simbolo(var.tipo_controlnum,this));
        }
    }
    //Contenedor.CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
    @Override
    public String getTraduccion(String ventana,String panel,int num)
    {
         String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre=name+num+"_"+panel;
       
         String t="var "+nombre+ " = "+panel+ ".CrearControlNumerico("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+","+
                 ((Simbolo)tabla.get("MAXIMO")).valor.toString()+","+
                 ((Simbolo)tabla.get("MINIMO")).valor.toString()+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                 ((Simbolo)tabla.get("DEFECTO")).valor.toString()+",\""+
                ((Simbolo)tabla.get("NOMBRE")).valor.toString()+
        "\");\n";        
        //fuente
         t=t+nombre+".fuente=\""+((Simbolo)tabla.get("FUENTE")).valor.toString()+"\";\n";
        //tam
         t=t+nombre+".tam="+((Simbolo)tabla.get("TAM")).valor.toString()+";\n";
         //color
         t=t+nombre+".color=\""+((Simbolo)tabla.get("COLOR")).valor.toString()+"\";\n";
         //NEGRITA
         t=t+nombre+".negrita="+((((Simbolo)tabla.get("NEGRITA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
         //CURSIVA
         t=t+nombre+".cursiva="+((((Simbolo)tabla.get("CURSIVA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
        return t;
    }
     //sent accion;
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


            int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
            int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
            
            //default value,lower bound,upper bound,increment by 
            int minimo=Integer.valueOf(((Simbolo)tabla.get("MINIMO")).valor.toString());

            int maximo=Integer.valueOf(((Simbolo)tabla.get("MAXIMO")).valor.toString());
            int def=Integer.valueOf(((Simbolo)tabla.get("DEFECTO")).valor.toString());
            this.setModel(new SpinnerNumberModel(def, minimo, maximo, var.incr_spinner));
            //this.setForeground(Color.decode(color));
            JComponent editor =(JSpinner.NumberEditor) this.getEditor();
            int n = editor.getComponentCount();
            for (int i=0; i<n; i++)
            {
                Component c = editor.getComponent(i);
                if (c instanceof JTextField)
                {
                    c.setForeground(Color.decode(color));
                }
            }
            this.setLocation(Integer.valueOf(getValor("X")),Integer.valueOf(getValor("Y")));
            //setsize(width,height)
            this.setSize(ancho,alto);
            //this.setBounds(Integer.valueOf(getValor("X")), n, n, n);
            this.repaint();
            this.setVisible(true);
        }catch(Exception exc)
        {
            e.AddError("No se pudo cargar el control numerico "+getValor("NOMBRE"), 0, 0, "", "SEMANTICO");
        }
        
    }

    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
   public ui_ControlNumerico (int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,int defecto,String nombre,
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
    
    //Contenedor.CrearControlNumerico(Alto, Ancho, Maximo, Minimo, X, Y, defecto, nombre)
    
    public ui_ControlNumerico(int alto,int ancho,int maximo,int minimo,
            int x,int y,int defecto,String nombre)
    {
        this.tabla=new Hashtable();
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,maximo,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,minimo,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_entero,defecto,false));
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,var.tamletra,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        this.setVisible(false);        
    }
    
   
    
    
}
