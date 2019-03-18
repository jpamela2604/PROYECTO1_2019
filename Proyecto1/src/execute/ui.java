/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import errors.mng_error;
import java.util.LinkedList;
import ts.Simbolo;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Pamela Palacios
 */
public interface ui {
    public String getTraduccion(String ventana,String panel,int num);
    public void cargar(LinkedList<EmbeddedMediaPlayer> videos,mng_error e);
    public String getValor(String value);
    public void getById(String id,LinkedList<Simbolo>valores);
    public void getByNombre(String ventana,String nombre,LinkedList<Simbolo>valores);
    public void getByTag(String nombre,LinkedList<Simbolo>valores);
}
