/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.presentation;

import co.unicauca.onlinerestaurant.client.access.Factory;
import co.unicauca.onlinerestaurant.client.access.IMainDishAccess;
import co.unicauca.onlinerestaurant.client.access.IMenuAccess;
import co.unicauca.onlinerestaurant.client.domain.services.MainDishService;
import co.unicauca.onlinerestaurant.client.domain.services.MenuService;
import co.unicauca.onlinerestaurant.client.infra.Messages;
import static co.unicauca.onlinerestaurant.client.infra.Messages.successMessage;
import co.unicauca.onlinerestaurant.commons.domain.MainDish;
import co.unicauca.onlinerestaurant.commons.domain.Menu;

/**
 *
 * @author Santiago Acuña
 */
public class GUIShowMenuAdmin extends javax.swing.JInternalFrame {

    String restaurantname;
    Menu menu;

    /**
     * Creates new form GUIUpdateDishe
     */
    public GUIShowMenuAdmin(String RestaurantN) throws Exception {
        initComponents();
        menu = new Menu();
        restaurantname = RestaurantN;
        imprimirMenu();
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
        jtxtnamerestaurant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPnSur = new javax.swing.JPanel();
        BntModificar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jPnCentro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        entry = new javax.swing.JTextField();
        drink = new javax.swing.JTextField();
        maindish = new javax.swing.JTextField();
        salad = new javax.swing.JTextField();
        dessert = new javax.swing.JTextField();
        BtnBuscarEntry = new javax.swing.JButton();
        BtnBuscarDrink = new javax.swing.JButton();
        BtnBuscarMainDish = new javax.swing.JButton();
        BtnBuscarSalad = new javax.swing.JButton();
        BtnBuscarDessert = new javax.swing.JButton();
        jTxIDDrink = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxIDMainDish = new javax.swing.JTextField();
        jTxIDSalad = new javax.swing.JTextField();
        jTxIDEntry = new javax.swing.JTextField();
        jTxIDDessert = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mostrar Menu");
        setPreferredSize(new java.awt.Dimension(495, 329));

        jPnNorte.setBackground(new java.awt.Color(54, 33, 88));
        jPnNorte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnNorte.setPreferredSize(new java.awt.Dimension(450, 50));

        jtxtnamerestaurant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtnamerestaurantActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu de la semana del Restaurante:");

        javax.swing.GroupLayout jPnNorteLayout = new javax.swing.GroupLayout(jPnNorte);
        jPnNorte.setLayout(jPnNorteLayout);
        jPnNorteLayout.setHorizontalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jtxtnamerestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPnNorteLayout.setVerticalGroup(
            jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNorteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jtxtnamerestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPnNorte, java.awt.BorderLayout.PAGE_START);

        jPnSur.setBackground(new java.awt.Color(54, 33, 88));
        jPnSur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPnSur.setPreferredSize(new java.awt.Dimension(450, 50));

        BntModificar.setText("Modificar");
        BntModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntModificarActionPerformed(evt);
            }
        });
        jPnSur.add(BntModificar);

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });
        jPnSur.add(jBtnCancelar);

        getContentPane().add(jPnSur, java.awt.BorderLayout.PAGE_END);

        jLabel2.setText("Entrada:");

        jLabel3.setText("Bebida:");

        jLabel4.setText("Plato principal:");

        jLabel5.setText("Ensalada:");

        jLabel6.setText("Postre:");

        salad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saladActionPerformed(evt);
            }
        });

        BtnBuscarEntry.setText("Buscar");

        BtnBuscarDrink.setText("Buscar");

        BtnBuscarMainDish.setText("Buscar");
        BtnBuscarMainDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarMainDishActionPerformed(evt);
            }
        });

        BtnBuscarSalad.setText("Buscar");

        BtnBuscarDessert.setText("Buscar");

        jLabel7.setText("ID");

        javax.swing.GroupLayout jPnCentroLayout = new javax.swing.GroupLayout(jPnCentro);
        jPnCentro.setLayout(jPnCentroLayout);
        jPnCentroLayout.setHorizontalGroup(
            jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCentroLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCentroLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPnCentroLayout.createSequentialGroup()
                        .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxIDMainDish, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxIDDrink, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxIDSalad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxIDDessert, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxIDEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(entry, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(drink, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(maindish)
                            .addComponent(salad)
                            .addComponent(dessert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnBuscarEntry, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnBuscarDrink, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnBuscarMainDish, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(BtnBuscarSalad)
                            .addComponent(BtnBuscarDessert))))
                .addContainerGap())
        );
        jPnCentroLayout.setVerticalGroup(
            jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTxIDEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(entry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBuscarEntry)))
                .addGap(18, 18, 18)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(drink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarDrink)
                    .addComponent(jTxIDDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maindish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarMainDish)
                    .addComponent(jTxIDMainDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(salad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarSalad)
                    .addComponent(jTxIDSalad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscarDessert)
                    .addComponent(jTxIDDessert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPnCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed

        this.doDefaultCloseAction();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jtxtnamerestaurantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtnamerestaurantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtnamerestaurantActionPerformed

    private void saladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saladActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saladActionPerformed

    private void BntModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntModificarActionPerformed

        boolean men;
        String id_dish = jTxIDMainDish.getText();
        String id_drink = jTxIDDrink.getText();
        String id_entry = jTxIDEntry.getText();
        String id_salad = jTxIDSalad.getText();
        String id_dessert = jTxIDDessert.getText();

        IMenuAccess service = Factory.getInstance().getMenuService();
        // Inyecta la dependencia
        MenuService menuService = new MenuService(service);

        if (id_dish.equals("") || id_drink.equals("") || id_entry.equals("") || id_salad.equals("") || id_dessert.equals("")) {
            Messages.warningMessage("Campos vacios: Error al modificar", "Warning");
            return;
        }
        men = false;
        try {
            men = menuService.updateMenu(menu.getId_menu(), id_dish, id_drink, id_entry, id_salad, id_dessert);
        } catch (Exception ex) {

            successMessage(ex.getMessage(), "Atención");
            return;
        }
        if (men) {
            successMessage("Se modifico el plato con exito.", "EXITO");
        } else {
            Messages.warningMessage("Error al modificar", "Warning");
        }
        imprimirMenu();
    }//GEN-LAST:event_BntModificarActionPerformed

    private void BtnBuscarMainDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarMainDishActionPerformed

    }//GEN-LAST:event_BtnBuscarMainDishActionPerformed

    private void imprimirMenu() {
        IMenuAccess service = Factory.getInstance().getMenuService();
        // Inyecta la dependencia
        MenuService restaurant = new MenuService(service);

        try {
            menu = restaurant.findbyMenubyRN(restaurantname);
        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
        }

        maindish.setText(menu.getMaindish().getNameDishe());
        dessert.setText(menu.getDessert().getName_Dish_Dessert());
        entry.setText(menu.getEntry().getNameDishEntry());
        salad.setText(menu.getSalad().getNameSalad());
        drink.setText(menu.getDrink().getNameDrink());

        jTxIDEntry.setText(menu.getEntry().getIdDishEntry());
        jTxIDDessert.setText(menu.getDessert().getId_Dish_Dessert());
        jTxIDDrink.setText(menu.getDrink().getId_Drink());
        jTxIDSalad.setText(menu.getSalad().getIdSalad());
        jTxIDMainDish.setText(menu.getMaindish().getId_mainDishe());

        jtxtnamerestaurant.setText(restaurantname);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntModificar;
    private javax.swing.JButton BtnBuscarDessert;
    private javax.swing.JButton BtnBuscarDrink;
    private javax.swing.JButton BtnBuscarEntry;
    private javax.swing.JButton BtnBuscarMainDish;
    private javax.swing.JButton BtnBuscarSalad;
    private javax.swing.JTextField dessert;
    private javax.swing.JTextField drink;
    private javax.swing.JTextField entry;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPnCentro;
    private javax.swing.JPanel jPnNorte;
    private javax.swing.JPanel jPnSur;
    private javax.swing.JTextField jTxIDDessert;
    private javax.swing.JTextField jTxIDDrink;
    private javax.swing.JTextField jTxIDEntry;
    private javax.swing.JTextField jTxIDMainDish;
    private javax.swing.JTextField jTxIDSalad;
    private javax.swing.JTextField jtxtnamerestaurant;
    private javax.swing.JTextField maindish;
    private javax.swing.JTextField salad;
    // End of variables declaration//GEN-END:variables
}