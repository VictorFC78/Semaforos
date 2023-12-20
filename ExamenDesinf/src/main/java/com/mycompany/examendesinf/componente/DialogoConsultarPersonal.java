/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.examendesinf.componente;

import com.mycompany.examandesinf.logica.LogicaNegocio;
import gui.ConsultarDatos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author 34675
 */
public class DialogoConsultarPersonal extends javax.swing.JDialog {

    /**
     * Creates new form DialogoConsultarPersonal
     */
    private JFXPanel jfxPanel;
    private JFrame jFrame;
    public DialogoConsultarPersonal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setHelp();
    }
    private void setHelp(){
        jFrame=new JFrame("AYUDA");
        jfxPanel=new JFXPanel();
        jFrame.setSize(new Dimension(500,500));
        jFrame.add(jfxPanel);
        KeyStroke f1KeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_F1,0);
        InputMap inputmap=txtCodigo.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap=txtCodigo.getActionMap();
        inputmap.put(f1KeyStroke, "realizarAccion");
        actionMap.put("realizarAccion",new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebView("https://www.google.es");
            }
        });
    }
    private void openWebView(String url) {
        Platform.runLater(() -> {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load(url);
        jfxPanel.setScene(new Scene(webView));
        jFrame.setVisible(true);
      });
}

    public String codigoIntroducido(){
       return txtCodigo.getText();
    }
    private void comprobarCodigo(){
        if(txtCodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "El codigo esta vacio", "ERROR CODIGO", JOptionPane.ERROR_MESSAGE);
        }else if(!LogicaNegocio.existeDepartamento(txtCodigo.getText().toUpperCase())){
            JOptionPane.showMessageDialog(this, "El departamento no existe", "ERROR DEPARTAMENTO",JOptionPane.ERROR_MESSAGE);
        }else{
            ConsultarDatos dialogoDatos=new ConsultarDatos(this, true);
            dialogoDatos.setVisible(true);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CODIGO DEPARTAMENTO");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnConsultar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        comprobarCodigo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
