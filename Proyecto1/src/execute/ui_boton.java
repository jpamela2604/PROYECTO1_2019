    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_fs.sent;
import codigo_gdato.item;
import errors.mng_error;
import java.awt.Color;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JButton;
import proyecto1.var;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_boton extends JButton implements ui{
    public Hashtable tabla;
    String accion;
    public Boolean IsEnviar;
    public sent referencia;
    String id_texto;
    @Override
    public void getDatos(LinkedList<item> it) {
        
    }
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {
        if(tag.equals("BOTON")/*&&!this.IsEnviar*/)
        {
            valores.add(new Simbolo(var.tipo_boton,this));
        }else if(tag.equals("ENVIAR")&&this.IsEnviar)
        {
            valores.add(new Simbolo(var.tipo_boton,this));
        }else if(tag.equals("TEXTO"))
        {
            valores.add(new Simbolo(var.tipo_cadena,((Simbolo)tabla.get("VALOR")).valor.toString()));
        }
    }
    @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        if(nombre.equals(getValor("NOMBRE").trim().toUpperCase()))
        {
            valores.add(new Simbolo(var.tipo_boton,this));
        }else if(nombre.equals(id_texto))
        {
            valores.add(new Simbolo(var.tipo_cadena,id_texto));
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
    }
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
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
        //x,y,ancho,alto
        this.setBounds(Integer.valueOf(getValor("X")),Integer.valueOf(getValor("Y")),ancho,alto);
        this.setVisible(true);
    }
   
    @Override
    public String getValor(String value) {
        return ((Simbolo)tabla.get(value)).valor.toString();
    }
    @Override
    public String getTraduccion(String ventana,String panel,int num)
    {
        // CrearBoton(Fuente, Tamaño, Color, X, Y,Referencia, valor, Alto, Ancho)
         //AGREGAR ON CLICK,AGREGAR NOMBRE,SI ES ENVIAR
        //this.IsEnviar=false;
        String name=((Simbolo)tabla.get("NOMBRE")).valor.toString();
        String nombre=name+num+"_"+panel;
        String ref=((Simbolo)tabla.get("REFERENCIA")).valor.toString();
        String name_referencia=(ref.equals("")&&accion.equals(""))?"nulo":"referencia_"+nombre+"()";
        
        String t="var "+nombre+ " = "+panel+ ".CrearBoton(\""+((Simbolo)tabla.get("FUENTE")).valor.toString()+"\","
                +((Simbolo)tabla.get("TAM")).valor.toString()+",\""+
                ((Simbolo)tabla.get("COLOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("X")).valor.toString()+","+
                ((Simbolo)tabla.get("Y")).valor.toString()+","+
                //((Simbolo)tabla.get("REFERENCIA")).valor.toString()
                name_referencia+",\""+
                ((Simbolo)tabla.get("VALOR")).valor.toString()+"\","+
                ((Simbolo)tabla.get("ALTO")).valor.toString()+","+
                ((Simbolo)tabla.get("ANCHO")).valor.toString()+
        ");\n";
        t=t+nombre+".nombre=\""+name+"\";\n";
        String funcion="";
        
        if(this.IsEnviar)
        {
            
            funcion="generica_"+nombre+"()";
            t=t+"funcion "+funcion+ "{\n";
            t=t+"   "+ventana+".crearArrayDesdeArchivo();\n";
            //t=t+(!accion.equals("")?"   "+accion+";\n":"");
            t=t+"}\n";
        }
        
        t=t+(funcion.equals("")?"":nombre+".alclic("+funcion+");\n");         
        
        if(!name_referencia.equals("nulo"))
        {
            t=t+"funcion "+name_referencia+ "{\n";
            t=t+(!accion.equals("")?"   "+accion+";\n":"");
            t=t+(ref.equals("")?"":"     "+ref+".alcargar()  ;\n");            
            t=t+"}\n";
        }
        return t;
        
    }
    
    public ui_boton(String nombre,int x,int y,int alto,int ancho,String accion,String ref,
            Boolean IsEnviar,String valor,String id_texto)
    {
        this.id_texto=id_texto;
        this.IsEnviar=  IsEnviar;
        this.accion=accion;
        this.tabla=new Hashtable();
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,nombre.toUpperCase().trim(),false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
       this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,var.fuenteDef,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,var.tamletra,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,var.colorDef,false));
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,ref,false));
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        this.setVisible(false);
    }
    public ui_boton(String fuente,int tam,String color,int x,int y,sent ref,String valor,
            int alto,int ancho)
    {
        this.IsEnviar=false;
        id_texto="";
        accion="";
        referencia=ref;
        this.tabla=new Hashtable();
        this.tabla.put("NOMBRE", new Simbolo(var.tipo_cadena,"",false));
        this.tabla.put("FUENTE", new Simbolo(var.tipo_cadena,fuente,false));
        this.tabla.put("TAM", new Simbolo(var.tipo_entero,tam,false));
        this.tabla.put("COLOR", new Simbolo(var.tipo_cadena,color,false));
        this.tabla.put("X", new Simbolo(var.tipo_entero,x,false));
        this.tabla.put("Y", new Simbolo(var.tipo_entero,y,false));
        this.tabla.put("REFERENCIA", new Simbolo(var.tipo_cadena,"",false));
        this.tabla.put("VALOR", new Simbolo(var.tipo_cadena,valor,false));
        this.tabla.put("ALTO", new Simbolo(var.tipo_entero,alto,false));
        this.tabla.put("ANCHO", new Simbolo(var.tipo_entero,ancho,false));
        this.setVisible(false);
        
        
    }
    
}
