/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.infra.Messages;

/**
 *
 * @author Santiago Acuña
 */
public class GUIFindDishe extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIFindDishe
     */
    public GUIFindDishe() {
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
        jLbIdPlato = new javax.swing.JLabel();
        jTxfId = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jPnSur = new javax.swing.JPanel();
        jBtnCerrar = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();
        jLbNombre = new javax.swing.JLabel();
        jTxfNombre = new javax.swing.JTextField();
        jLbPrecio = new javax.swing.JLabel();
        jTxfPrecio = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar Plato");

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));
        jPnNorte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLbIdPlato.setBackground(new java.awt.Color(255, 255, 255));
        jLbIdPlato.setForeground(new java.awt.Color(255, 255, 255));
        jLbIdPlato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbIdPlato.setText("Id:");
        jPnNorte.add(jLbIdPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 60, 30));

        jTxfId.setBackground(new java.awt.Color(255, 255, 255));
        jTxfId.setForeground(new java.awt.Color(0, 0, 0));
        jPnNorte.add(jTxfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 90, 30));

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });
        jPnNorte.add(jBtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        jBtnCerrar.setText("Cerrar");
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCerrar);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        jPnCentro.setLayout(new java.awt.GridLayout(2, 2));

        jLbNombre.setBackground(new java.awt.Color(255, 255, 255));
        jLbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbNombre.setText("Nombre:");
        jPnCentro.add(jLbNombre);

        jTxfNombre.setEditable(false);
        jTxfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTxfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPnCentro.add(jTxfNombre);

        jLbPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jLbPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbPrecio.setText("Precio:");
        jPnCentro.add(jLbPrecio);

        jTxfPrecio.setEditable(false);
        jTxfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jTxfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jPnCentro.add(jTxfPrecio);

        getContentPane().add(jPnCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed

        this.doDefaultCloseAction();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed

        String id = jTxfId.getText().trim();

        IMainDishAccess service = Factory.getInstance().getMainDishService();
        // Inyecta la dependencia
        MainDishService mainDishService = new MainDishService(service);
        if (id.equals("")) {
            jTxfId.requestFocus();
            Messages.warningMessage("ERROR: El campo Id esta vacio.", "Warning");
            return;
        }

        MainDish dish;
        try {
            dish = mainDishService.findMainDish(id);
        } catch (Exception ex) {
            clearControls();
            successMessage(ex.getMessage(), "Atención");
            return;
        }
        clearControls();
        showData(dish);

    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void showData(MainDish mainDish) {
        jTxfNombre.setText(mainDish.getNameDishe());
        jTxfPrecio.setText(Double.toString(mainDish.getDishPrice()));

    }

    public void clearControls() {

        jTxfId.setText("");
        jTxfNombre.setText("");
        jTxfPrecio.setText("");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JLabel jLbIdPlato;
    private javax.swing.JLabel jLbNombre;
    private javax.swing.JLabel jLbPrecio;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JTextField jTxfId;
    private javax.swing.JTextField jTxfNombre;
    private javax.swing.JTextField jTxfPrecio;
    // End of variables declaration//GEN-END:variables
}
