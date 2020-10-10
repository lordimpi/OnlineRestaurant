/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;

/**
 *
 * @author Santiago Acuña
 */
public class GUIDeleteDishe extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIUpdateDishe
     */
    public GUIDeleteDishe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnNorte = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        jPnSur = new javax.swing.JPanel();
        jBtnMidificar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Plato");
        setPreferredSize(new java.awt.Dimension(495, 329));

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        javax.swing.GroupLayout jPnNorteLayout = new javax.swing.GroupLayout(jPnNorte);
        jPnNorte.setLayout(jPnNorteLayout);
        jPnNorteLayout.setHorizontalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNorteLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        jPnNorteLayout.setVerticalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        jBtnMidificar.setText("Borrar");
        jBtnMidificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnMidificarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnMidificar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCancelar);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPnCentroLayout = new javax.swing.GroupLayout(jPnCentro);
        jPnCentro.setLayout(jPnCentroLayout);
        jPnCentroLayout.setHorizontalGroup(
            jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        jPnCentroLayout.setVerticalGroup(
            jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );

        getContentPane().add(jPnCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        this.doDefaultCloseAction();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnMidificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnMidificarActionPerformed
        // TODO add your handling code here:
        String sid = id.getText().trim();

        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDishService = new MainDishService(service);
        if (sid.equals("")) {
            id.requestFocus();
            return;
        }
        try {
            mainDishService.deleteMainDish(sid);
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
            return;
        }
    }//GEN-LAST:event_jBtnMidificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnMidificar;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    // End of variables declaration//GEN-END:variables
}
