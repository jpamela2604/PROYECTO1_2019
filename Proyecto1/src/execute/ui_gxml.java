/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import codigo_gdato.item;
import codigo_gxml.ruta;
import errors.mng_error;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public class ui_gxml implements ui{
    public LinkedList<ui_ventana> ventanas;
    public LinkedList<ruta> rutas;
    public ui_ventana principal;
    public ui_ventana actual;
   //public LinkedList<EmbeddedMediaPlayer> videos;
    public ui_gxml()
    {
        this.ventanas=new LinkedList();
        this.rutas=new LinkedList();
        this.principal=null;
        //this.videos=new LinkedList();
    }
    public void iniciar(ui_ventana pri,mng_ts ts, mng_error e, Ejecucion ej)
    {
        try
        {
            if(pri!=null)
            {
                if(actual!=null)
                {
                    actual.dispose();
                }                
                actual=pri;
                LinkedList<EmbeddedMediaPlayer> videos=new LinkedList();
                pri.setVisible(true);
                pri.cargar(videos,e);
                pri.show();
                for(EmbeddedMediaPlayer mu:videos)
                {
                    mu.play();
                }
                if(pri.AccionInicial!=null)
                {
                    Simbolo actual=ts.actual;
                    ts.actual=null;
                    pri.AccionInicial.ejecutar(ts, e, ej);
                    ts.actual=actual;
                }

            }     
        }catch(Exception exc)
        {
            e.AddError("No se pudo cargar ventana principal "+pri.getValor("ID"), 0, 0, "", "SEMANTICO");
        }
    }
    
    @Override
    public void getByTag(String tag,LinkedList<Simbolo>valores)
    {       
        if(tag.equals("IMPORTAR"))
        {
            this.rutas.forEach((ru) -> {
                valores.add(new Simbolo(var.tipo_cadena,ru.ruta));
            });
        }else
        {
            this.ventanas.forEach((ven) -> {
                ven.getByTag(tag, valores);
            });
        }
    }
    @Override
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores)
    {
        for(ui_ventana ven:this.ventanas)
        {
            ven.getByNombre(ventana,nombre, valores);
        }
    }
    @Override
    public void getById(String id,LinkedList<Simbolo>valores)
    {
        for(ui_ventana ven:this.ventanas)
        {
            ven.getById(id, valores);
        }
    }
   
    @Override
    public String getTraduccion(String ventana,String panel,int num)
    {
        String t="";
        for(ruta rut:rutas)
        {
            t=t+"importar(\""+rut.ruta+"\");\n";
        }
        for(int i=0;i<ventanas.size();i++)
        {
            t=t+ventanas.get(i).getTraduccion("","",i);
            
        }
        
        return t;
    }
    @Override
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos, mng_error e)
    {
    }
    @Override
    public String getValor(String value)
    {
        return "";
    }

    @Override
    public void getDatos(LinkedList<item> it) {
        
    }
   
    
}
