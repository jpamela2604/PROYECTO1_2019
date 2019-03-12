/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;
import proyecto1.Reconize;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Pamela Palacios
 */
public class media {
    public static void cargar(JPanel prin,LinkedList<EmbeddedMediaPlayer> videos,
            Integer ancho,Integer alto,Integer x,Integer y,String file,Boolean auto)
    {
        
        /*Integer ancho=Integer.valueOf(getValor("ANCHO"));
        Integer alto=Integer.valueOf(getValor("ALTO"));
        Integer x=Integer.valueOf(getValor("X"));
        Integer y=Integer.valueOf(getValor("Y"));*/
        Integer anchoBoton=ancho/3;
        JButton pausa=new JButton();
        pausa.setText("pausar");
        pausa.setVisible(false);       
        pausa.setBounds(x,alto-25,anchoBoton,25);
        JButton continuar=new JButton();
        continuar.setText("continuar");
        continuar.setVisible(false);
        continuar.setBounds(x+anchoBoton,alto-25,anchoBoton,25);
        JButton detener=new JButton();
        detener.setText("detener");
        detener.setVisible(false);
        detener.setBounds(x+2*anchoBoton,alto-25,anchoBoton,25);
        Canvas c= new Canvas();
        c.setBackground(Color.BLACK);
        c.setSize(ancho, alto-25);
        c.setPreferredSize(new Dimension(ancho,alto-25));
        JPanel video=new JPanel();
        video.setLayout(new GridLayout());
        video.setBounds(x,y,ancho, alto-30);
        video.setPreferredSize(new Dimension(ancho, alto-30));
        video.add(c);
        JPanel controles=new JPanel();
        controles.setLayout(new GridLayout(1,3));
        controles.setBounds(x,y+alto-25,ancho,25);
        controles.setPreferredSize(new Dimension(ancho,25));
        controles.add(pausa);
        controles.add(continuar);
        controles.add(detener);
        //JPanel principal=new JPanel();
        prin.setLayout(null);
        prin.setBounds(x,y,ancho, alto);
        prin.setPreferredSize(new Dimension(ancho, alto));  
        prin.add(video);
        prin.add(controles);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\Program Files\\VideoLAN\\VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
        MediaPlayerFactory mpf= new MediaPlayerFactory();
        EmbeddedMediaPlayer emp=mpf.newEmbeddedMediaPlayer();
        emp.setVideoSurface(mpf.newVideoSurface(c));  
        //String file=Reconize.getDireccion("C:\\Users\\Pamela Palacios\\Desktop\\pilita.mp4");
        
        emp.prepareMedia(file);        
        
        pausa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               emp.pause();
            }

        });
        continuar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               emp.play();
            }

        });
        detener.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               emp.stop();
            }

        });
        pausa.setVisible(true); 
        continuar.setVisible(true);
        detener.setVisible(true);
        prin.setVisible(true);
        if(auto)
        {
            videos.add(emp);
            //emp.play();
        }
    }
}
