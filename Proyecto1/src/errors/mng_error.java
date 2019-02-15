/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pamela Palacios
 */
public class mng_error {
    public LinkedList<NodoError> errores;
    public String RUTAREPORTE;
    public mng_error()
    {
        RUTAREPORTE="C:\\Reporte\\ReporteErrorArchivoXLS.html";
        this.errores= new LinkedList<NodoError>();
    }
    public void Adding(mng_error b)
    {
        for(NodoError e:b.errores)
        {
            this.errores.add(e);
        }
    }
    public void AddError(String descripcion,int linea, int columna,String archivo,String tipo)
    {
        this.errores.add(new NodoError(descripcion,linea,columna,archivo,tipo));
    }
    public void Generar_Reporte()
    {
        FileWriter fw;
            try
            {       fw= new FileWriter(RUTAREPORTE);
                    fw.write("<!DOCTYPE html>");
                    fw.write("<html >");
                    fw.write("<head>");
                    fw.write("<meta charset=\"UTF-8\">");
                    fw.write("<title>Reporte Errores</title> ");
                    fw.write("<link rel=\"stylesheet\" href=\"css/style.css\">");
                    fw.write("</head>");
                    fw.write("<body ALIGN =CENTER>");
                    fw.write("  <h1><span class=\"blue\">&lt;</span>COMPILADORES 2<span class=\"blue\">&gt;</span> <span class=\"yellow\">PROYECTO1</pan></h1>");
                    fw.write("<h2>2012-22673 <a  target=\"_blank\">Jenifer Pamela Palacios</a></h2>");
                    fw.write("<p><font size=\"25\">REPORTE DE ERRORES</font></p>");
                    //fw.write(DateTime.Now.ToString("G"));
            /**/
                    fw.write("<table class=\"container\">");
                    fw.write("<thead>");
		    fw.write("<tr>");
                    fw.write("<th><h1>No.</h1></th>");
                    fw.write("<th><h1>Descripcion</h1></th>");
                    fw.write("<th><h1>Linea</h1></th>");
                    fw.write("<th><h1>Columna</h1></th>");
                    fw.write("<th><h1>Tipo</h1></th>");
                    fw.write("<th><h1>Archivo</h1></th>");
		    fw.write("</tr>");
                    fw.write("</thead>");
                    fw.write("<tbody>");
                  Integer aux=0;
                  for(NodoError err:errores)
                  //for(int i=0;i<2;i++)
                  {
                      aux++;
                      fw.write("<td>"+aux+"</td>");
                      fw.write("<td>"+err.Descripcion+"</td>");
                      fw.write("<td>"+err.linea+"</td>");
                      fw.write("<td>"+err.columna+"</td>");
                      fw.write("<td>"+err.tipo+"</td>");
                      fw.write("<td>"+err.archivo+"</td>");
                      fw.write("</tr>");
                      
                  }
                  
                  
                    fw.write("</tbody>");
                    fw.write("</table>");           
                    fw.write("</body>");
                    fw.write("</html>");
                  fw.close();
                  Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" "+RUTAREPORTE);
            
            
            }catch(IOException io)
            {
                  //l3.setText("Error al abrir el fichero");
                 JOptionPane.showMessageDialog(null, "Error al guardar el Archivo");
                  return;
            }
    }
}
