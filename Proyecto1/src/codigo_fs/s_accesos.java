/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import java.util.LinkedList;
import proyecto1.var;
import ts.Simbolo;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public class s_accesos implements sent{
    public LinkedList <sent> accesos;
     public boolean IsSent;/*si es sent no deberia devolver nada*/
     public boolean IsGlobal;
     public s_accesos(LinkedList<sent> accesos)
     {
         this.accesos=accesos;
         IsSent=false;
         IsGlobal=false;
     }
     @Override
    public Object cargar(mng_ts ts, mng_error e, Ejecucion ej) {
        return null;
    }

    @Override
    public Object ejecutar(mng_ts ts, mng_error e, Ejecucion ej) {
        Simbolo r=new Simbolo(var.tipo_error,null);
        try{
        for(sent s:accesos)
        {
            if(s instanceof s_nEventoCargar)
            {
                s_nEventoCargar load=(s_nEventoCargar)s;
                load.IsGlobal=this.IsGlobal;
            }
            r=(Simbolo) s.ejecutar(ts, e, ej);
            if(r.tipo.indice==var.error)
            {
                ts.actual=null;
                return r;
            }
            ts.actual=r;
        }
        ts.actual=null;
        if(IsSent)
        {
            return null;
        }
        }catch(Exception exce)
        {
            e.AddError("ERROR:  accesos", 0, 0, "", "SEMANTICO");
        }
        return r;
    }
}
