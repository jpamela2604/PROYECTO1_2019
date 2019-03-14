/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

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
    public LinkedList<EmbeddedMediaPlayer> videos;
    public ui_gxml()
    {
        this.ventanas=new LinkedList();
        this.rutas=new LinkedList();
        this.principal=null;
        this.videos=new LinkedList();
    }
    public void iniciar(mng_ts ts, mng_error e, Ejecucion ej)
    {
        try
        {
        if(principal!=null)
        {
            principal.setVisible(true);
            principal.cargar(videos,e);
            principal.show();
            for(EmbeddedMediaPlayer mu:videos)
            {
                mu.play();
            }
            if(principal.AccionInicial!=null)
            {
                Simbolo actual=ts.actual;
                ts.actual=null;
                principal.AccionInicial.ejecutar(ts, e, ej);
                ts.actual=actual;
            }
            
        }     
        }catch(Exception exc)
        {
            e.AddError("No se pudo cargar ventana principal "+principal.getValor("ID"), 0, 0, "", "SEMANTICO");
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
    public String getTraduccion(String ventana,String panel)
    {
        String t="";
        for(ruta rut:rutas)
        {
            t=t+"importar(\""+rut.ruta+"\");\n";
        }
        for(ui_ventana bo:ventanas)
        {
            t=t+bo.getTraduccion("","");
            
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
   
    
}
