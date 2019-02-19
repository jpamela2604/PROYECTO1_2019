/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo_fs;

import errors.mng_error;
import execute.Ejecucion;
import ts.mng_ts;

/**
 *
 * @author Pamela Palacios
 */
public interface sent {
    public Object cargar(mng_ts ts,mng_error e,Ejecucion ej);
    public Object ejecutar(mng_ts ts,mng_error e,Ejecucion ej);
}
