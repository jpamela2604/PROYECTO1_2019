/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.Array;
import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JComboBox;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_desplegable extends JComboBox{
     public Hashtable tabla;
    //obligatorios
    //String nombre;
    //String defecto;
    /*int x;
    int y;*/
     //opcionales
    /*String fuente;
    int tam;
    String color;*/
    /*Boolean negrita;
    Boolean cursiva;*/
    /*int alto;
    int ancho;*/
    /*int maximo;
    int minimo;*/
    public Array lista;
    public ui_desplegable(int alto,int ancho,Array lista,int x,int y,String defecto,String nombre)
    {
        this.tabla=new Hashtable();
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.lista=lista;
        /*this.x=x;
        this.y=y;*/
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        //this.defecto=defecto;
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuenteDef,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,var.tamletra,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        /*this.negrita=false;
        this.cursiva=false; */
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,false,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,var.max_cb,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,var.min_cb,false));
        this.setVisible(false);
        
    }
    //.CrearDesplegable(Alto, Ancho, lista, X, Y, Defecto, nombre)
    public String getTraduccion(String ventana,String panel)
    {
        
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre="Despl_"+name;
        String namelista="lista_"+nombre;
        String contenido="";
        String aux="";
        LinkedList<Simbolo>valores=this.lista.valores;
        for(Simbolo s:valores)
        {
            contenido=contenido+aux+"\""+s.valor.toString() +"\"";
            aux=",";
        }
        String t="var "+namelista+"=["+contenido+"];\n";
         t=t+"var "+nombre+ " = "+panel+ ".CrearDesplegable("+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+","+
                namelista+","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+",\""+
                ((Simbolo)tabla.get("DEFECTO")).valor.toString()+"\",\""+
                ((Simbolo)tabla.get("NOMBRE")).valor.toString()+
        "\");\n";
        //FUENTE
        t=t+nombre+".fuente=\""+((Simbolo)tabla.get("FUENTE")).valor.toString()+"\";\n";
        //TAM
         t=t+nombre+".tam="+((Simbolo)tabla.get("TAM")).valor.toString()+";\n";
        //COLOR
         t=t+nombre+".color=\""+((Simbolo)tabla.get("COLOR")).valor.toString()+"\";\n";
        //NEGRILLA
         t=t+nombre+".negrita="+((((Simbolo)tabla.get("NEGRITA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
        //CURSIVA
         t=t+nombre+".cursiva="+((((Simbolo)tabla.get("CURSIVA")).valor.toString()).equals("true")?"verdadero":"falso")+";\n";
        //MAXIMO
         t=t+nombre+".maximo="+((Simbolo)tabla.get("MAXIMO")).valor.toString()+";\n";
        //MINIMO
         t=t+nombre+".minimo="+((Simbolo)tabla.get("MINIMO")).valor.toString()+";\n";
        return t;
    }
    public ui_desplegable(int alto,int ancho,String fuente,int tam,String color,
             int x,int y,Boolean negrilla,Boolean cursiva,String defecto,String nombre,
             int maximo,int minimo,Array lista) 
    {
        this.tabla=new Hashtable();
        this.lista=lista;
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*
        this.x=x;
        this.y=y;*/
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        /*this.negrita=false;
        this.cursiva=false;*/
        this.tabla.put("NEGRITA", new Simbolo(var.tipo_booleano,negrilla,false));
        this.tabla.put("CURSIVA", new Simbolo(var.tipo_booleano,cursiva,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.tabla.put("MAXIMO", new Simbolo(var.tipo_entero,maximo,false));
        this.tabla.put("MINIMO", new Simbolo(var.tipo_entero,minimo,false));
        this.tabla.put("DEFECTO", new Simbolo(var.tipo_cadena,defecto,false));
        this.setVisible(false);
    }
    
    public void cargar()
    {
        //falta defecto!!!!!!
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
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //setsize(width,height)
        this.setSize(ancho,alto);
        
        for(Simbolo s:this.lista.valores)
        {
            this.addItem(s.valor.toString());
        }
        
        
        
        this.setVisible(true);
        
    }
}
