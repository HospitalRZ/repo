/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_presentacion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import lib_clases.departamento;
import lib_gestion.gestion;
import lib_reporte.Form_reporte_concentrado;
import lib_reporte.Form_reporte_departamento;

/**
 *
 * @author juliovicente
 */
public class frm_principal extends javax.swing.JFrame {

    /**
     * Creates new form frm_principal
     */
    gestion gestionM;
    int iddepartamento = -1;
    ArrayList<departamento> departamentos;
    public frm_principal() {
        initComponents();
        gestionM = new gestion();
        departamentos = new ArrayList<departamento>();
    }
    public frm_principal(int identidad) throws SQLException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gestionM = new gestion();
        departamentos = gestionM.ListarDepartamentos_Entidad(identidad);
        Combo_departamentos.removeAllItems();
        for (int i = 0; i < jMenu1.getItemCount(); i++) {
            JMenuItem s = jMenu1.getItem(i);
            Boolean estado = false;
            for(departamento objeto: departamentos)
            {
                if (s.getText().equals(objeto.getDescripcion()))
                    estado= true;
            }
            s.setEnabled(estado);
        }
        for(departamento objeto: departamentos)
        {
            Combo_departamentos.addItem(objeto.getDescripcion());
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        Combo_departamentos = new javax.swing.JComboBox();
        aceptar_boton = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ch_Reporte_departamento = new javax.swing.JCheckBox();
        ch_Reporte_concentrado1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemUSUARIO = new javax.swing.JMenuItem();
        jMenuItemPACIENTES = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSALIR = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemEMERGENCIA = new javax.swing.JMenuItem();
        jMenuItemCIRUGIA = new javax.swing.JMenuItem();
        jMenuItemGINECOBSTETRICIA = new javax.swing.JMenuItem();
        jMenuItemTRAUMATOLOGIA = new javax.swing.JMenuItem();
        jMenuItemMEDICINAINTERNA = new javax.swing.JMenuItem();
        jMenuItemPEDIATRIA = new javax.swing.JMenuItem();
        jMenuItemUCI = new javax.swing.JMenuItem();
        jMenuItemINFECTOLOGIA = new javax.swing.JMenuItem();
        jMenuItemUNIDADQUEMADOS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemDEPARTAMENTO = new javax.swing.JMenuItem();
        jMenuItemCONCENTRADO = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemACERCADE = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Combo_departamentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Combo_departamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Combo_departamentosItemStateChanged(evt);
            }
        });

        aceptar_boton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        aceptar_boton.setText("Aceptar");
        aceptar_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptar_botonMouseClicked(evt);
            }
        });
        aceptar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_botonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Registro de dieta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Combo_departamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar_boton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(Combo_departamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aceptar_boton))
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Reportes");

        ch_Reporte_departamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ch_Reporte_departamento.setText("Departamento");
        ch_Reporte_departamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_Reporte_departamentoItemStateChanged(evt);
            }
        });

        ch_Reporte_concentrado1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ch_Reporte_concentrado1.setText("Concentrado");
        ch_Reporte_concentrado1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_Reporte_concentrado1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ch_Reporte_departamento)
                    .addComponent(jLabel4))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(ch_Reporte_concentrado1)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(71, 71, 71)
                .addComponent(ch_Reporte_departamento))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(ch_Reporte_concentrado1)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Hospital Rafeal Rodriguez Zambrano");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Control de Dietas");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel1))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu4.setText("ARCHIVO");
        jMenu4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jMenuItemUSUARIO.setText("USUARIO");
        jMenu4.add(jMenuItemUSUARIO);

        jMenuItemPACIENTES.setText("PACIENTES");
        jMenu4.add(jMenuItemPACIENTES);
        jMenu4.add(jSeparator1);

        jMenuItemSALIR.setText("SALIR");
        jMenu4.add(jMenuItemSALIR);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("DEPARTAMENTOS");
        jMenu1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jMenuItemEMERGENCIA.setText("EMERGENCIA");
        jMenuItemEMERGENCIA.setEnabled(false);
        jMenuItemEMERGENCIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEMERGENCIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEMERGENCIA);

        jMenuItemCIRUGIA.setText("CIRUGIA");
        jMenuItemCIRUGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCIRUGIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCIRUGIA);

        jMenuItemGINECOBSTETRICIA.setText("GINECO-OBSTETRICIA");
        jMenuItemGINECOBSTETRICIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGINECOBSTETRICIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGINECOBSTETRICIA);

        jMenuItemTRAUMATOLOGIA.setText("TRAUMATOLOGIA");
        jMenuItemTRAUMATOLOGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTRAUMATOLOGIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemTRAUMATOLOGIA);

        jMenuItemMEDICINAINTERNA.setText("MEDICINA INTERNA");
        jMenuItemMEDICINAINTERNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMEDICINAINTERNAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemMEDICINAINTERNA);

        jMenuItemPEDIATRIA.setText("PEDIATRIA");
        jMenuItemPEDIATRIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPEDIATRIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPEDIATRIA);

        jMenuItemUCI.setText("UCI");
        jMenuItemUCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUCIActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemUCI);

        jMenuItemINFECTOLOGIA.setText("INFECTOLOGIA");
        jMenuItemINFECTOLOGIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemINFECTOLOGIAActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemINFECTOLOGIA);

        jMenuItemUNIDADQUEMADOS.setText("UNIDAD DE QUEMADOS");
        jMenuItemUNIDADQUEMADOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUNIDADQUEMADOSActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemUNIDADQUEMADOS);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("REPORTES");
        jMenu2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jMenuItemDEPARTAMENTO.setText("DEPARTAMENTO");
        jMenuItemDEPARTAMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDEPARTAMENTOActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemDEPARTAMENTO);

        jMenuItemCONCENTRADO.setText("CONCENTRADO");
        jMenuItemCONCENTRADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCONCENTRADOActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCONCENTRADO);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("INFORMACIÓN");
        jMenu3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        jMenuItemACERCADE.setText("ACERCA DE..");
        jMenu3.add(jMenuItemACERCADE);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private departamento buscarDepartamento(String texto){
        departamento dep = new departamento();
        for(departamento objeto: departamentos)
            {
                if (texto == null ? objeto.getDescripcion() == null : texto.equals(objeto.getDescripcion())) {
                    iddepartamento = objeto.getId();
                    return dep=objeto;
                }
            }
        return dep;
    }
    private void Combo_departamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Combo_departamentosItemStateChanged
        if (evt.getSource() == Combo_departamentos) {
            String seleccionado=(String)Combo_departamentos.getSelectedItem();
            buscarDepartamento(seleccionado);
        }
    }//GEN-LAST:event_Combo_departamentosItemStateChanged

    private void aceptar_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptar_botonMouseClicked
        if (iddepartamento != -1) {
                  frm_proceso proceso = new frm_proceso(iddepartamento);           
            proceso.show();
            }
    }//GEN-LAST:event_aceptar_botonMouseClicked

    private void ch_Reporte_concentrado1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_Reporte_concentrado1ItemStateChanged
        Form_reporte_concentrado frm_concentrado = new Form_reporte_concentrado(); 
        frm_concentrado.show();
    }//GEN-LAST:event_ch_Reporte_concentrado1ItemStateChanged

    private void ch_Reporte_departamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_Reporte_departamentoItemStateChanged
        Form_reporte_departamento frm_departamento = null;
        try {
            frm_departamento = new Form_reporte_departamento();
        } catch (SQLException ex) {
            Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        frm_departamento.show();
    }//GEN-LAST:event_ch_Reporte_departamentoItemStateChanged

    private void aceptar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_botonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptar_botonActionPerformed

    private void jMenuItemEMERGENCIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEMERGENCIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemEMERGENCIAActionPerformed

    private void jMenuItemCIRUGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCIRUGIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemCIRUGIAActionPerformed

    private void jMenuItemGINECOBSTETRICIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGINECOBSTETRICIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemGINECOBSTETRICIAActionPerformed

    private void jMenuItemTRAUMATOLOGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTRAUMATOLOGIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemTRAUMATOLOGIAActionPerformed

    private void jMenuItemMEDICINAINTERNAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMEDICINAINTERNAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemMEDICINAINTERNAActionPerformed

    private void jMenuItemPEDIATRIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPEDIATRIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemPEDIATRIAActionPerformed

    private void jMenuItemUCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUCIActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemUCIActionPerformed

    private void jMenuItemINFECTOLOGIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemINFECTOLOGIAActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemINFECTOLOGIAActionPerformed

    private void jMenuItemUNIDADQUEMADOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUNIDADQUEMADOSActionPerformed
        buscarDepartamento(evt.getActionCommand().toString());
        frm_proceso proceso = new frm_proceso(iddepartamento);           
        jDesktopPane1.add(proceso);
        proceso.setVisible(true); 
    }//GEN-LAST:event_jMenuItemUNIDADQUEMADOSActionPerformed

    private void jMenuItemDEPARTAMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDEPARTAMENTOActionPerformed
        Form_reporte_departamento frm_departamento= null;
        try {
            frm_departamento = new Form_reporte_departamento();
        } catch (SQLException ex) {
            Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDesktopPane1.add(frm_departamento);
        frm_departamento.setVisible(true); 
    }//GEN-LAST:event_jMenuItemDEPARTAMENTOActionPerformed

    private void jMenuItemCONCENTRADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCONCENTRADOActionPerformed
        Form_reporte_concentrado frm_concentrado = new Form_reporte_concentrado(); 
        jDesktopPane1.add(frm_concentrado);
        frm_concentrado.setVisible(true); 
    }//GEN-LAST:event_jMenuItemCONCENTRADOActionPerformed

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
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frm_principal(1).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frm_principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Combo_departamentos;
    private javax.swing.JToggleButton aceptar_boton;
    private javax.swing.JCheckBox ch_Reporte_concentrado1;
    private javax.swing.JCheckBox ch_Reporte_departamento;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemACERCADE;
    private javax.swing.JMenuItem jMenuItemCIRUGIA;
    private javax.swing.JMenuItem jMenuItemCONCENTRADO;
    private javax.swing.JMenuItem jMenuItemDEPARTAMENTO;
    private javax.swing.JMenuItem jMenuItemEMERGENCIA;
    private javax.swing.JMenuItem jMenuItemGINECOBSTETRICIA;
    private javax.swing.JMenuItem jMenuItemINFECTOLOGIA;
    private javax.swing.JMenuItem jMenuItemMEDICINAINTERNA;
    private javax.swing.JMenuItem jMenuItemPACIENTES;
    private javax.swing.JMenuItem jMenuItemPEDIATRIA;
    private javax.swing.JMenuItem jMenuItemSALIR;
    private javax.swing.JMenuItem jMenuItemTRAUMATOLOGIA;
    private javax.swing.JMenuItem jMenuItemUCI;
    private javax.swing.JMenuItem jMenuItemUNIDADQUEMADOS;
    private javax.swing.JMenuItem jMenuItemUSUARIO;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
