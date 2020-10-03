/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.onlinerestaurant.client.presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Santiago Acuña
 */
public class GUIMenuCustomer extends javax.swing.JFrame {

    private boolean state = false;
    /**
     * Guarda la coordenada en eje x para poder mover el formulario con el raton
     */
    private int x = 0;
    /**
     * Guarda la coordenada en eje y para poder mover el formulario con el raton
     */
    private int y = 0;

    public GUIMenuCustomer() {
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

        jPnlBg = new javax.swing.JPanel();
        jPnlSide = new javax.swing.JPanel();
        BtnHomePage = new javax.swing.JPanel();
        jLbHomePageIcono = new javax.swing.JLabel();
        jLbHomePage = new javax.swing.JLabel();
        BtnMenus = new javax.swing.JPanel();
        jLbMenusIcon = new javax.swing.JLabel();
        jLbMenus = new javax.swing.JLabel();
        BtnRestaurant = new javax.swing.JPanel();
        jLbRestaurantIcon = new javax.swing.JLabel();
        jLbRestaurant = new javax.swing.JLabel();
        jLbLogOut = new javax.swing.JLabel();
        jLbUserName = new javax.swing.JLabel();
        jLbUserPhoto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPnlCMH = new javax.swing.JPanel();
        jLbMaxMin = new javax.swing.JLabel();
        jLbHide = new javax.swing.JLabel();
        jLbClose1 = new javax.swing.JLabel();
        dskEscritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1080, 646));

        jPnlBg.setBackground(new java.awt.Color(255, 255, 255));
        jPnlBg.setLayout(new java.awt.BorderLayout());

        jPnlSide.setBackground(new java.awt.Color(54, 33, 88));
        jPnlSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnHomePage.setBackground(new java.awt.Color(85, 65, 118));
        BtnHomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnHomePageMousePressed(evt);
            }
        });

        jLbHomePageIcono.setPreferredSize(new java.awt.Dimension(34, 35));

        jLbHomePage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLbHomePage.setForeground(new java.awt.Color(204, 204, 204));
        jLbHomePage.setText("Home page");

        javax.swing.GroupLayout BtnHomePageLayout = new javax.swing.GroupLayout(BtnHomePage);
        BtnHomePage.setLayout(BtnHomePageLayout);
        BtnHomePageLayout.setHorizontalGroup(
            BtnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnHomePageLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLbHomePageIcono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        BtnHomePageLayout.setVerticalGroup(
            BtnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnHomePageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BtnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbHomePage)
                    .addComponent(jLbHomePageIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPnlSide.add(BtnHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 280, 40));

        BtnMenus.setBackground(new java.awt.Color(64, 43, 100));
        BtnMenus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnMenusMousePressed(evt);
            }
        });

        jLbMenusIcon.setPreferredSize(new java.awt.Dimension(34, 35));

        jLbMenus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLbMenus.setForeground(new java.awt.Color(204, 204, 204));
        jLbMenus.setText("Menus");

        javax.swing.GroupLayout BtnMenusLayout = new javax.swing.GroupLayout(BtnMenus);
        BtnMenus.setLayout(BtnMenusLayout);
        BtnMenusLayout.setHorizontalGroup(
            BtnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnMenusLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLbMenusIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        BtnMenusLayout.setVerticalGroup(
            BtnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnMenusLayout.createSequentialGroup()
                .addGroup(BtnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbMenusIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BtnMenusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLbMenus)))
                .addGap(21, 21, 21))
        );

        jPnlSide.add(BtnMenus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, 40));

        BtnRestaurant.setBackground(new java.awt.Color(64, 43, 100));
        BtnRestaurant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BtnRestaurantMousePressed(evt);
            }
        });

        jLbRestaurantIcon.setPreferredSize(new java.awt.Dimension(34, 35));

        jLbRestaurant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLbRestaurant.setForeground(new java.awt.Color(204, 204, 204));
        jLbRestaurant.setText("Restaurants");

        javax.swing.GroupLayout BtnRestaurantLayout = new javax.swing.GroupLayout(BtnRestaurant);
        BtnRestaurant.setLayout(BtnRestaurantLayout);
        BtnRestaurantLayout.setHorizontalGroup(
            BtnRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnRestaurantLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLbRestaurantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLbRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        BtnRestaurantLayout.setVerticalGroup(
            BtnRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnRestaurantLayout.createSequentialGroup()
                .addGroup(BtnRestaurantLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbRestaurantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BtnRestaurantLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLbRestaurant)))
                .addGap(21, 21, 21))
        );

        jPnlSide.add(BtnRestaurant, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, 40));

        jLbLogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLbLogOut.setForeground(new java.awt.Color(204, 204, 204));
        jLbLogOut.setText("Log out");
        jPnlSide.add(jLbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 50, -1));

        jLbUserName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLbUserName.setForeground(new java.awt.Color(204, 204, 204));
        jLbUserName.setText("User");
        jPnlSide.add(jLbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 130, -1));
        jPnlSide.add(jLbUserPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 100));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jPnlSide.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 10));

        jPnlBg.add(jPnlSide, java.awt.BorderLayout.LINE_START);

        jPnlCMH.setBackground(new java.awt.Color(122, 72, 221));
        jPnlCMH.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPnlCMHMouseDragged(evt);
            }
        });
        jPnlCMH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPnlCMHMousePressed(evt);
            }
        });

        jLbMaxMin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbMaxMin.setForeground(new java.awt.Color(255, 255, 255));
        jLbMaxMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbMaxMin.setText("[]");
        jLbMaxMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbMaxMinMouseClicked(evt);
            }
        });

        jLbHide.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbHide.setForeground(new java.awt.Color(255, 255, 255));
        jLbHide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbHide.setText("-");
        jLbHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbHideMouseClicked(evt);
            }
        });

        jLbClose1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLbClose1.setForeground(new java.awt.Color(255, 255, 255));
        jLbClose1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbClose1.setText("X");
        jLbClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbClose1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPnlCMHLayout = new javax.swing.GroupLayout(jPnlCMH);
        jPnlCMH.setLayout(jPnlCMHLayout);
        jPnlCMHLayout.setHorizontalGroup(
            jPnlCMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlCMHLayout.createSequentialGroup()
                .addContainerGap(1014, Short.MAX_VALUE)
                .addComponent(jLbHide, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLbMaxMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLbClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPnlCMHLayout.setVerticalGroup(
            jPnlCMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlCMHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlCMHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLbMaxMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLbClose1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLbHide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPnlBg.add(jPnlCMH, java.awt.BorderLayout.PAGE_START);

        dskEscritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dskEscritorioLayout = new javax.swing.GroupLayout(dskEscritorio);
        dskEscritorio.setLayout(dskEscritorioLayout);
        dskEscritorioLayout.setHorizontalGroup(
            dskEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        dskEscritorioLayout.setVerticalGroup(
            dskEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jPnlBg.add(dskEscritorio, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPnlBg, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnHomePageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnHomePageMousePressed
        setColor(BtnHomePage);
        resetColor(BtnRestaurant);
        resetColor(BtnMenus);
    }//GEN-LAST:event_BtnHomePageMousePressed

    private void BtnMenusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMenusMousePressed
        resetColor(BtnHomePage);
        resetColor(BtnRestaurant);
        setColor(BtnMenus);
    }//GEN-LAST:event_BtnMenusMousePressed

    private void BtnRestaurantMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRestaurantMousePressed
        resetColor(BtnHomePage);
        setColor(BtnRestaurant);
        resetColor(BtnMenus);
    }//GEN-LAST:event_BtnRestaurantMousePressed

    private void jLbMaxMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbMaxMinMouseClicked

        if (state) {
            this.setExtendedState(NORMAL);
            state = false;
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
            state = true;
        }
    }//GEN-LAST:event_jLbMaxMinMouseClicked

    private void jLbHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbHideMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLbHideMouseClicked

    private void jLbClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbClose1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLbClose1MouseClicked

    private void jPnlCMHMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPnlCMHMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jPnlCMHMouseDragged

    private void jPnlCMHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPnlCMHMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPnlCMHMousePressed

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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMenuCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMenuCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMenuCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMenuCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMenuCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnHomePage;
    private javax.swing.JPanel BtnMenus;
    private javax.swing.JPanel BtnRestaurant;
    private javax.swing.JDesktopPane dskEscritorio;
    private javax.swing.JLabel jLbClose1;
    private javax.swing.JLabel jLbHide;
    private javax.swing.JLabel jLbHomePage;
    private javax.swing.JLabel jLbHomePageIcono;
    private javax.swing.JLabel jLbLogOut;
    private javax.swing.JLabel jLbMaxMin;
    private javax.swing.JLabel jLbMenus;
    private javax.swing.JLabel jLbMenusIcon;
    private javax.swing.JLabel jLbRestaurant;
    private javax.swing.JLabel jLbRestaurantIcon;
    private javax.swing.JLabel jLbUserName;
    private javax.swing.JLabel jLbUserPhoto;
    private javax.swing.JPanel jPnlBg;
    private javax.swing.JPanel jPnlCMH;
    private javax.swing.JPanel jPnlSide;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void setColor(JPanel panel) {
        panel.setBackground(new Color(85, 65, 118));

    }

    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(64, 43, 100));

    }

    private void initIcons() {
        addIcon(jLbHomePageIcono, "src/main/java/resources/home.png");
        addIcon(jLbRestaurantIcon, "src/main/java/resources/restaurant.png");
        addIcon(jLbMenusIcon, "src/main/java/resources/restaurantMenu.png");
        addIcon(jLbUserPhoto, "src/main/java/resources/userPhoto.png");
    }

    private void addIcon(JLabel lb, String pathIcon) {
        ImageIcon img = new ImageIcon(pathIcon);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(
                lb.getWidth(),
                lb.getHeight(),
                Image.SCALE_DEFAULT));
        lb.setIcon(icono);
        this.repaint();
    }

}
