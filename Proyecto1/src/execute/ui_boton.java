    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import java.awt.Color;
import java.util.Hashtable;
import javax.swing.JButton;
import proyecto1.var;
import ts.Simbolo;

/**
 *
 * @author Pamela Palacios
 */
public class ui_boton extends JButton{
     public Hashtable tabla;
    //obligatorios
    //String nombre;
    /*int x;
    int y;*/
    /*String fuente;
    int tam;
    String color;*/
    //opcionales
    /*int alto;
    int ancho;*/
    //String referencia;
    //String valor;
    //sent llamada;
    String accion;
    Boolean IsEnviar;
    public ui_boton(String nombre,int x,int y,int alto,int ancho,String accion,String ref,
            Boolean IsEnviar,String valor)
    {
       
        this.IsEnviar=IsEnviar;
        this.accion=accion;
        this.tabla=new Hashtable();
        //this.nombre=nombre;
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre,false));
        /*this.x=x;
        this.y=y; */
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.alto=this.getSize().height;
        this.ancho=this.getSize().width;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        /*this.fuente=this.getFont().getFontName();
        this.tam=this.getFont().getSize();
        this.color="#000000";*/
       this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuenteDef,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,var.tamletra,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        //referencia="";
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,ref,false));
        //valor=nombre;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        this.setVisible(false);
    }
    
    public String getTraduccion(String ventana,String panel)
    {
        // CrearBoton(Fuente, Tamaño, Color, X, Y,Referencia, valor, Alto, Ancho)
         //AGREGAR ON CLICK,AGREGAR NOMBRE,SI ES ENVIAR
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre="Boton_"+(IsEnviar?"Enviar_":"")+name;
        
        String t="var "+nombre+ " = "+panel+ ".CrearBoton(\""+((Simbolo)tabla.get("FUENTE")).valor.toString()+"\","
                +((Simbolo)tabla.get("TAM")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+",\""+
                ((Simbolo)tabla.get("REFERENCIA")).valor.toString()+"\",\""+
                ((Simbolo)tabla.get("VALOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+
        ");\n";
        t=t+nombre+".nombre=\""+name+"\";\n";
        String funcion=accion;
        if(this.IsEnviar)
        {
            funcion="generica_"+nombre+"()";
            t=t+"funcion "+funcion+ "{\n";
            t=t+"   "+ventana+".crearArrayDesdeArchivo();";
            t=t+(!accion.equals("")?"   "+accion+";\n":"");
            t=t+"}\n";
        }
        
        t=t+(funcion.equals("")?"":nombre+".alclic("+funcion+");\n"); 
        return t;
        
    }
    public ui_boton(String fuente,int tam,String color,int x,int y,String ref,String valor,
            int alto,int ancho)
    {
        accion="";
        this.tabla=new Hashtable();
        //this.nombre="";
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        /*this.fuente=fuente;
        this.tam=tam;
        this.color=color;*/
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        //this.tam=this.getFont().getSize();
        //this.color="#000000";
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        /*this.x=x;
        this.y=y;*/
        //this.referencia=ref;
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,ref,false));
        //this.valor=valor;
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        /*this.alto=alto;
        this.ancho=ancho;*/
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.setVisible(false);
        
        
    }
    public void cargar()
    {
        int tam=Integer.valueOf(((Simbolo)tabla.get("TAM")).valor.toString());
        String fuente=((Simbolo)tabla.get("FUENTE")).valor.toString();
        String color=((Simbolo)tabla.get("COLOR")).valor.toString();
        String valor=((Simbolo)tabla.get("VALOR")).valor.toString();
        this.setText(valor);
        int alto=Integer.valueOf(((Simbolo)tabla.get("ALTO")).valor.toString());
        int ancho=Integer.valueOf(((Simbolo)tabla.get("ANCHO")).valor.toString());
        //setsize(width,height)
        this.setSize(ancho,alto);
        this.setFont(new java.awt.Font(fuente, 0, tam));
        this.setBackground(Color.decode(color));
        this.setVisible(true);
    }
}
