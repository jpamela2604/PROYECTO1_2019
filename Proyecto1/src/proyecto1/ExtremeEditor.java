/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import errors.mng_error;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

/**
 *
 * @author Pamela Palacios
 */
public class ExtremeEditor extends javax.swing.JFrame {

    public static Pestania[] arrayPanel= new Pestania[25] ;
    public static int cuentaArrayPanel=0;
    String ru="";
    mng_error er;
    Reconize gra;
    /**
     * Creates new form ExtremeEditor
     */
    public ExtremeEditor() {
        initComponents();
        initCom();
        ru="C:\\Users\\Pamela Palacios\\Desktop\\entradas";
        er=new mng_error();
        gra=new Reconize(er);
    }
    public void initCom()
    {
        files.setUI(new CustomTabbedPaneUI());
        lbColumna.setText("Columna: "+var.columnaGlobal);
        lbLinea.setText("Fila: "+var.filaGlobal);
        this.TextoBuscar.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Buscar(true,"No hay coincidencias siguientes");
         }
      });      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        files = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbLinea = new javax.swing.JLabel();
        lbColumna = new javax.swing.JLabel();
        TextoBuscar = new javax.swing.JTextField();
        btnBuscarNext = new javax.swing.JButton();
        btnBuscarPrevious = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        Item_abrir = new javax.swing.JMenuItem();
        item_guardar = new javax.swing.JMenuItem();
        item_guardacomo = new javax.swing.JMenuItem();
        CambiarRuta = new javax.swing.JMenuItem();
        getRuta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        item_error = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Consola:");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnNuevo.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/file.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAbrir.setBackground(new java.awt.Color(204, 204, 204));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/open.png"))); // NOI18N
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardar.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/save.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarComo.setBackground(new java.awt.Color(204, 204, 204));
        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/saveas.png"))); // NOI18N
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });

        btnRun.setBackground(new java.awt.Color(204, 204, 204));
        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/run.png"))); // NOI18N
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Reporte.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarComo)
                .addGap(87, 87, 87)
                .addComponent(btnRun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(btnRun)
                    .addComponent(btnGuardarComo)
                    .addComponent(btnGuardar)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbLinea.setText("jLabel1");

        lbColumna.setText("jLabel1");

        btnBuscarNext.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnBuscarNext.setText("Siguiente");
        btnBuscarNext.setMaximumSize(new java.awt.Dimension(73, 19));
        btnBuscarNext.setMinimumSize(new java.awt.Dimension(73, 19));
        btnBuscarNext.setPreferredSize(new java.awt.Dimension(73, 19));
        btnBuscarNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNextActionPerformed(evt);
            }
        });

        btnBuscarPrevious.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        btnBuscarPrevious.setText("Anterior");
        btnBuscarPrevious.setMaximumSize(new java.awt.Dimension(73, 19));
        btnBuscarPrevious.setMinimumSize(new java.awt.Dimension(73, 19));
        btnBuscarPrevious.setPreferredSize(new java.awt.Dimension(73, 19));
        btnBuscarPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPreviousActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar:");

        jMenu2.setText("Archivo");
        jMenu2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jMenu2AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Item_abrir.setText("Abrir");
        Item_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_abrirActionPerformed(evt);
            }
        });
        jMenu2.add(Item_abrir);

        item_guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        item_guardar.setText("Guardar");
        item_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_guardarActionPerformed(evt);
            }
        });
        jMenu2.add(item_guardar);

        item_guardacomo.setText("Guardar Como");
        item_guardacomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_guardacomoActionPerformed(evt);
            }
        });
        jMenu2.add(item_guardacomo);

        CambiarRuta.setText("Cambiar Ruta Proyecto");
        CambiarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarRutaActionPerformed(evt);
            }
        });
        jMenu2.add(CambiarRuta);

        getRuta.setText("Ruta Proyecto");
        getRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getRutaActionPerformed(evt);
            }
        });
        jMenu2.add(getRuta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tabs");

        jMenuItem1.setText("Nueva");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Error");

        item_error.setText("Generar Reporte");
        item_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_errorActionPerformed(evt);
            }
        });
        jMenu4.add(item_error);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(lbLinea)
                        .addGap(52, 52, 52)
                        .addComponent(lbColumna)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarNext, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(jScrollPane1)
                    .addComponent(files))
                .addContainerGap(79, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(files, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbLinea)
                            .addComponent(lbColumna)
                            .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNextActionPerformed
        // TODO add your handling code here:
        Buscar(true,"No hay coincidencias siguientes");
    }//GEN-LAST:event_btnBuscarNextActionPerformed

    private void btnBuscarPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPreviousActionPerformed
        // TODO add your handling code here:
        Buscar(false,"No hay coincidencias anteriores");
    }//GEN-LAST:event_btnBuscarPreviousActionPerformed

    private void jMenu2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jMenu2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2AncestorMoved

    private void item_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_guardarActionPerformed
        // TODO add your handling code here:
        if(files.getComponentCount()>0)
        {
            guardar();
        }else
        {
            JOptionPane.showMessageDialog(null, "No hay un archivo abierto para guardar");
        }
    }//GEN-LAST:event_item_guardarActionPerformed
    void guardar()
    {   
            FileWriter fw;
            try
            {   
                int indice=files.getSelectedIndex();
                
                fw= new FileWriter(arrayPanel[indice].ruta);
                fw.write(arrayPanel[indice].texto.getText());
                fw.close();        
                //JOptionPane.showMessageDialog(null, "Guardado Exitosamente ");
            }
            catch(IOException io)
            {
                  //l3.setText("Error al abrir el fichero");
                 //JOptionPane.showMessageDialog(null, "Error al guardar ");
                 
            }
            
 
    }
    private void Item_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_abrirActionPerformed
        // TODO add your handling code here:
        open();            
                  
    }//GEN-LAST:event_Item_abrirActionPerformed
    public void open()
    {
        File Abrir;
        JFileChooser Ventana = new JFileChooser(System.getProperty(ru));
        Ventana.setCurrentDirectory(new File(ru));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("ExtremeEditor", "gxml","xml","fs");
        Ventana.setFileFilter(filter);
        Ventana.setDialogTitle("Abrir Archivo");   
	Ventana.showOpenDialog(this);
        Abrir = Ventana.getSelectedFile();
        try
        {
        abrir(Ventana.getSelectedFile().toString(),getnombre(Ventana.getSelectedFile().toString()));
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
        }   
    }
    public  void abrir(String ruta,String nombre)
    { 
        String Text;
        String contenido="";
        File Abrir= new File(ruta);
        if(!Abrir.isDirectory())
        {
            try{
            
                int indice=files.getSelectedIndex();
                FileReader Fichero= new FileReader(Abrir);
                BufferedReader leer= new BufferedReader(Fichero);
                while((Text=leer.readLine())!=null)
                {
                    contenido=contenido+Text+ "\n";
                }
                leer.close();
                AgregarTab(ruta,contenido,nombre,TipoFile(ruta));  
                
            }
            catch(IOException ioe)
            {
		JOptionPane.showMessageDialog(null, "Error al abrir el archivo");
            }
        }
    }
    
    private void item_guardacomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_guardacomoActionPerformed
        // TODO add your handling code here:
       saveAs();
    }//GEN-LAST:event_item_guardacomoActionPerformed
    public void saveAs()
    {
         if(files.getComponentCount()>0)
        {
            File Abrir;
            JFileChooser Ventana = new JFileChooser(System.getProperty(ru));
            Ventana.setCurrentDirectory(new File(ru));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("ExtremeEditor", "gxml","xml","fs");
            Ventana.setFileFilter(filter);
            Ventana.setDialogTitle("Guardar Archivo");   
            Ventana.showSaveDialog(this);
            Abrir = Ventana.getSelectedFile();
            AgregarTab(Ventana.getSelectedFile().toString(),Reconize.getContenido(arrayPanel[files.getSelectedIndex()].ruta),getnombre(Ventana.getSelectedFile().toString()),TipoFile(Ventana.getSelectedFile().toString()));
            //abrir(Ventana.getSelectedFile().toString(),getnombre(Ventana.getSelectedFile().toString()));
            guardar();
        }else
        {
            JOptionPane.showMessageDialog(null, "No hay un archivo abierto para guardar");
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
       
            nueva();    
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void nueva()
    {
     String[] buttons = { "gxml", "fs" };        
            Integer rc = JOptionPane.showOptionDialog(null, "Qué tipo de archivo desea crear?", "TIPO DE ARCHIVO",
            JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
            String extension;
            switch(rc)
            {
                case 0:
                {
                    extension=var.ext_gxml;
                }break;
                case 1:
                {
                    extension=var.ext_fs;
                }break;
                default:
                {
                    return;
                }
            }
            String nombre=JOptionPane.showInputDialog(null, "Nombre del archivo");
            
            if(nombre!=null&&CrearArchivo(ru+"\\"+nombre,extension))
            {
                //String ruta,String texto,String nombre 
                AgregarTab(ru+"\\"+nombre+extension,"",nombre+extension,TipoFile(ru+"\\"+nombre+extension));
               
            }           
    }
    boolean CrearArchivo(String ruta,String extension)
    {
        File fileToSave = new File(ruta+extension);
        if (fileToSave.exists()) {
            JOptionPane.showMessageDialog(null, "Ya existe el archivo");
            return false;
        }else{
               
            FileWriter fw;
            try
            {     
                fw= new FileWriter( fileToSave);                 
                fw.write("");
                fw.close(); 
                return true;
            }
            catch(IOException io)
            {
                  //l3.setText("Error al abrir el fichero");
                 JOptionPane.showMessageDialog(null, "Error al guardar el Archivo");
                  return false;
            }
        }
        
    }
    static String getnombre(String ruta)
    {
        StringTokenizer split= new StringTokenizer(ruta,"\\");
        String[] lista = new String[split.countTokens()];
        int c=0;
        while (split.hasMoreTokens()) 
        {
            lista[c] = split.nextToken();
            c ++ ;
        }
        return lista[lista.length-1];
    }
    
    static boolean extVal(String ruta,String extension)
    {
        StringTokenizer split= new StringTokenizer(ruta,".");
        String[] lista = new String[split.countTokens()];
        int c = 0;
        while (split.hasMoreTokens()) 
        {
            lista[c] = split.nextToken();
            c ++ ;
        }  
        String e=extension.substring(1,extension.length());
        return lista.length>1&&e.equals(lista[lista.length-1]);
    }
    
    static Pestania.Tipo TipoFile(String ruta)
    {
        if(extVal(ruta,var.ext_fs))
        {
            return Pestania.Tipo.FS;
        }
        return Pestania.Tipo.GXML;
    }
    void AgregarTab(String ruta,String texto,String nombre,Pestania.Tipo tipo)
    { 
        RSyntaxTextArea textArea = new RSyntaxTextArea(); 
        
        /*inicio para saber donde se esta situado*/
        textArea.addCaretListener(new CaretListener() {
           @Override
           public void caretUpdate(CaretEvent e) {
                lbColumna.setText("Columna: "+getColumna(e.getDot(), (JTextComponent)e.getSource()));
                lbLinea.setText("Fila: "+getFila(e.getDot(), (JTextComponent)e.getSource()));
          }});    
        /*fin*/      
        
        RTextScrollPane sp = new RTextScrollPane(textArea); // agregar el scroll mi textarea
        //guardar la pestania
        Pestania n = new Pestania(tipo,ruta,textArea,sp); 
        arrayPanel[cuentaArrayPanel]=n;        
        files.addTab(nombre+"    ", sp);
        files.setSelectedIndex(cuentaArrayPanel);
        cuentaArrayPanel++;
        textArea.setText(texto);
        
    }
     public static int getFila(int pos, JTextComponent editor) {
        int rn = (pos==0) ? 1 : 0;
        try {
            int offs=pos;
            while( offs>0) {
                offs=Utilities.getRowStart(editor, offs)-1;
                rn++;
            }
        } catch (BadLocationException e) {
        }
        return rn;
    }
         
    public static int getColumna(int pos, JTextComponent editor) {
        try {
            return pos-Utilities.getRowStart(editor, pos)+1;
        } catch (BadLocationException e) {
        }
        return -1;
    }
    private void item_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_errorActionPerformed
        // TODO add your handling code here:
        if(!er.errores.isEmpty())
        {er.Generar_Reporte();}
        else
        {
            JOptionPane.showMessageDialog(null, "No hay errores que reportar");
        }
    }//GEN-LAST:event_item_errorActionPerformed

    private void CambiarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarRutaActionPerformed
        // TODO add your handling code here:
        JFileChooser  selectorArchivos = new JFileChooser ();
        //selectorArchivos.setCurrentDirectory(new java.io.File("."));
        selectorArchivos.setDialogTitle("Escoja la carpeta del proyecto");
        selectorArchivos.setFileSelectionMode(JFileChooser .DIRECTORIES_ONLY);
        selectorArchivos.setAcceptAllFileFilterUsed(false);
        File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

       if (selectorArchivos.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
           ru=selectorArchivos.getSelectedFile().toString();
       }else {
            
            this.dispose();
       }
    }//GEN-LAST:event_CambiarRutaActionPerformed

    private void getRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getRutaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, ru);
    }//GEN-LAST:event_getRutaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        nueva();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        // TODO add your handling code here:
        open();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if(files.getComponentCount()>0)
        {
            guardar();
        }else
        {
            JOptionPane.showMessageDialog(null, "No hay un archivo abierto para guardar");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        // TODO add your handling code here:
        saveAs();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!er.errores.isEmpty())
        {er.Generar_Reporte();}
        else
        {
            JOptionPane.showMessageDialog(null, "No hay errores que reportar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        // TODO add your handling code here:
        //this.er= new mng_error();
        this.er.errores.clear();
        jButton1.setBackground(new Color(204, 204, 204));
        if(files.getComponentCount()>0)
        {
            Pestania ta=arrayPanel[files.getSelectedIndex()];
            var.archivo=ta.ruta;
            this.gra.Run(ta.ruta, ta.tipo);
        }else
        {
            JOptionPane.showMessageDialog(null, "No hay un archivo abierto para guardar");
        }
        if(!this.er.errores.isEmpty())
        {            
            jButton1.setBackground(new Color(255, 246, 221));
        }
    }//GEN-LAST:event_btnRunActionPerformed
    public void Buscar(Boolean Adelante,String mensaje)
    {
        if(files.getComponentCount()>0)
        {
            SearchContext context = new SearchContext();
            String text = this.TextoBuscar.getText();
            if (text.length() == 0) {
               return;
            }
            context.setSearchFor(text);
            context.setMatchCase(false);
            context.setRegularExpression(false);
            context.setSearchForward(Adelante);
            context.setWholeWord(false);

            boolean found = SearchEngine.find(arrayPanel[files.getSelectedIndex()].texto, context);
            if (!found) {
               JOptionPane.showMessageDialog(this, mensaje);
            }
        }else
        {
            JOptionPane.showMessageDialog(this, "No hay ningun archivo abierto");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExtremeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExtremeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExtremeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExtremeEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExtremeEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CambiarRuta;
    private javax.swing.JMenuItem Item_abrir;
    private javax.swing.JTextField TextoBuscar;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnBuscarNext;
    private javax.swing.JButton btnBuscarPrevious;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRun;
    private javax.swing.JTabbedPane files;
    private javax.swing.JMenuItem getRuta;
    private javax.swing.JMenuItem item_error;
    private javax.swing.JMenuItem item_guardacomo;
    private javax.swing.JMenuItem item_guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JLabel lbColumna;
    private static javax.swing.JLabel lbLinea;
    // End of variables declaration//GEN-END:variables
}
class CustomTabbedPaneUI extends MetalTabbedPaneUI
{
   Rectangle xRect;
  
   protected void installListeners() {
      super.installListeners();
      tabPane.addMouseListener(new MyMouseHandler());
   }
  
   protected void paintTab(Graphics g, int tabPlacement,
                           Rectangle[] rects, int tabIndex,
                           Rectangle iconRect, Rectangle textRect) {
      super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
  
      Font f = g.getFont();
      g.setFont(new Font("Courier", Font.BOLD, 10));
      FontMetrics fm = g.getFontMetrics(g.getFont());
      int charWidth = fm.charWidth('x');
      int maxAscent = fm.getMaxAscent();
      g.drawString("x", textRect.x + textRect.width - 3, textRect.y + textRect.height - 3);
      g.drawRect(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      xRect = new Rectangle(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      g.setFont(f);
    }
  
    public class MyMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            try
            {
                if (xRect.contains(e.getPoint())) {
               JTabbedPane tabPane = (JTabbedPane)e.getSource();
               int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
               for(int i=tabIndex;i<ExtremeEditor.cuentaArrayPanel;i++)
               {                   
                   ExtremeEditor.arrayPanel[i]=ExtremeEditor.arrayPanel[i+1];
               }
               ExtremeEditor.cuentaArrayPanel=ExtremeEditor.cuentaArrayPanel-1;
               tabPane.remove(tabIndex);
               
            }
            }catch(Exception exc)
            {
            }
        }
    }
}