/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import codigo_gdato.item;
import errors.mng_error;
import execute.Ejecucion;
import execute.ui_ControlNumerico;
import execute.ui_areaTexto;
import execute.ui_boton;
import execute.ui_cajaTexto;
import execute.ui_contenedor;
import execute.ui_desplegable;
import execute.ui_imagen;
import execute.ui_reproductor;
import execute.ui_texto;
import execute.ui_ventana;
import execute.ui_video;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_acVariable implements sent{
     String id;
     int linea;
     int columna;
     String archivo;
     
     public s_acVariable(String id,int linea,int columna,String archivo)
     {
         this.id=id;
         this.linea=linea;
         this.columna=columna;
         this.archivo=archivo;
     }
     @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        Simbolo respuesta=new Simbolo(var.tipo_error,null);
        try{
        if(ts.actual==null)
        {
            Simbolo r=ts.buscarSimbolo(new Simbolo(id,null,Simbolo.variable,null), linea, columna, archivo);
            if(r!=null)
            {
                respuesta=r;
            }
        }else if(ts.actual.tipo.indice==var.objeto)
        {
            Objeto myObj=(Objeto)ts.actual.valor;
            if(myObj.items.containsKey(id))
            {
                return ((item)myObj.items.get(id)).valor;
            }else
            {
                e.AddError("No existe atributo llamado "+this.id, linea, columna, archivo, "SEMANTICO");
            }            
        }else if(ts.actual.tipo.indice==var.ventana)
        {
            ui_ventana obj=(ui_ventana)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_ventana+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.contenedor)
        {
            ui_contenedor obj=(ui_contenedor)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_contenedor+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.texto)
        {
            ui_texto obj=(ui_texto)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_texto+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.cajatexto)
        {
            ui_cajaTexto obj=(ui_cajaTexto)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_cajatexto+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.areatexto)
        {
            ui_areaTexto obj=(ui_areaTexto)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_areatexto+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.controlnum)
        {
            ui_ControlNumerico obj=(ui_ControlNumerico)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_controlnum+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.desplegable)
        {
            ui_desplegable obj=(ui_desplegable)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_desplegable+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.boton)
        {
            ui_boton obj=(ui_boton)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_boton+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.imagen)
        {
            ui_imagen obj=(ui_imagen)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_imagen+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.reproductor)
        {
            ui_reproductor obj=(ui_reproductor)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_reproductor+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else if(ts.actual.tipo.indice==var.video)
        {
            ui_video obj=(ui_video)ts.actual.valor;
            if(obj.tabla.containsKey(this.id))
            {
                return obj.tabla.get(this.id);
            }else
            {
                e.AddError(var.t_video+" no tiene un atributo llamado "+id, linea, columna, archivo, "SEMANTICO");
            }
        }else
        {
            e.AddError("No se puede acceder a un elemento de tipo "+ts.actual.tipo.nombre, linea, columna, archivo, "SEMANTICO");
        }
        }catch(Exception exce)
        {
            e.AddError("ERROR: VARIABLE ", linea, columna, archivo, "SEMANTICO");
        }
        return respuesta;
    }
}
