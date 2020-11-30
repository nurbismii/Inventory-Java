import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class frmMDI extends javax.swing.JFrame {

    /**
     * Creates new form frmMDI
     */
    final static String StringDriver = "com.mysql.jdbc.Driver";
    final static String StringConnection = "jdbc:mysql://localhost:3306/db_tokoenterprise?user=root&password=";
    
    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();

    public frmMDI() {
        super("Aplikasi Toko");
        initComponents();
        //setBounds();
    }
    
    public void setBounds(){
            this.setBounds(0, 0, 1400, 950);
            this.setLocation(dimensi.width / 2
                - this.getWidth() / 2, dimensi.height / 2
                - this.getHeight() / 2);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setAlwaysOnTop(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("bg-apk4.jpg"));
        Image img = icon.getImage();
        frmMDI = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),
                    getHeight(),this);
            }
        };
        PnlAksi = new javax.swing.JPanel();
        BtnBArang = new javax.swing.JLabel();
        BtnTransaksi = new javax.swing.JLabel();
        BtnSupplier = new javax.swing.JLabel();
        BtnLogin = new javax.swing.JLabel();
        BtnLogout = new javax.swing.JLabel();
        LblAksiPanel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MasterData = new javax.swing.JMenu();
        MenuBarang = new javax.swing.JMenuItem();
        MenuTransaksi = new javax.swing.JMenuItem();
        MenuSupplier = new javax.swing.JMenuItem();
        MenuCustomer = new javax.swing.JMenuItem();
        Aplikasi = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frmMDI.setBackground(new java.awt.Color(255, 255, 255));
        frmMDI.setForeground(new java.awt.Color(204, 204, 204));

        PnlAksi.setBackground(new java.awt.Color(162, 252, 255));

        BtnBArang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BtnBarang.png"))); // NOI18N
        BtnBArang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBArangMouseClicked(evt);
            }
        });

        BtnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BtnTransaksi.png"))); // NOI18N
        BtnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTransaksiMouseClicked(evt);
            }
        });

        BtnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BtnSupplier.png"))); // NOI18N
        BtnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSupplierMouseClicked(evt);
            }
        });

        BtnLogin.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BtnLogin.png"))); // NOI18N

        BtnLogout.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        BtnLogout.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BtnLogout.png"))); // NOI18N

        LblAksiPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg-panelAksi.jpg"))); // NOI18N
        LblAksiPanel.setPreferredSize(new java.awt.Dimension(450, 950));

        javax.swing.GroupLayout PnlAksiLayout = new javax.swing.GroupLayout(PnlAksi);
        PnlAksi.setLayout(PnlAksiLayout);
        PnlAksiLayout.setHorizontalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BtnLogin)
                .addGap(1, 1, 1)
                .addComponent(BtnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBArang, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnTransaksi)
                        .addComponent(BtnSupplier)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlAksiLayout.createSequentialGroup()
                    .addComponent(LblAksiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        PnlAksiLayout.setVerticalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLogin)
                    .addComponent(BtnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(BtnBArang)
                .addGap(133, 133, 133)
                .addComponent(BtnTransaksi)
                .addGap(119, 119, 119)
                .addComponent(BtnSupplier)
                .addGap(106, 106, 106))
            .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlAksiLayout.createSequentialGroup()
                    .addComponent(LblAksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        MasterData.setText("Master Data");

        MenuBarang.setText("Barang");
        MenuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBarangActionPerformed(evt);
            }
        });
        MasterData.add(MenuBarang);

        MenuTransaksi.setText("Transaksi");
        MenuTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTransaksiActionPerformed(evt);
            }
        });
        MasterData.add(MenuTransaksi);

        MenuSupplier.setText("Supplier");
        MenuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSupplierActionPerformed(evt);
            }
        });
        MasterData.add(MenuSupplier);

        MenuCustomer.setText("Customer");
        MenuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCustomerActionPerformed(evt);
            }
        });
        MasterData.add(MenuCustomer);

        menuBar.add(MasterData);

        Aplikasi.setText("Aplikasi");

        jMenu2.setText("Export");

        jMenuItem2.setText("Transaksi");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Barang");
        jMenu2.add(jMenuItem3);

        Aplikasi.add(jMenu2);

        MenuExit.setText("Exit");
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        Aplikasi.add(MenuExit);

        menuBar.add(Aplikasi);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmMDI)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void MenuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarangActionPerformed
        // TODO add your handling code here:
       try {
            frmBarang frmBarang = new frmBarang();
            frmMDI.add(frmBarang);
            frmBarang.setBounds((frmMDI.getWidth() / 2) 
                            - (frmBarang.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmBarang.getHeight() / 2), frmBarang.getWidth(), frmBarang.getHeight());
            frmBarang.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        }      
    }//GEN-LAST:event_MenuBarangActionPerformed

    private void MenuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSupplierActionPerformed
        // TODO add your handling code here:
        try {
            frmSupplier frmSupplier = new frmSupplier();
            frmMDI.add(frmSupplier);
            frmSupplier.setBounds((frmMDI.getWidth() / 2) 
                            - (frmSupplier.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmSupplier.getHeight() / 2), frmSupplier.getWidth(), frmSupplier.getHeight());
            frmSupplier.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        } 
    }//GEN-LAST:event_MenuSupplierActionPerformed

    private void MenuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCustomerActionPerformed
        // TODO add your handling code here:
         try {
            frmCustomer frmCustomer = new frmCustomer();
            frmMDI.add(frmCustomer);
            frmCustomer.setBounds((frmMDI.getWidth() / 2) 
                            - (frmCustomer.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmCustomer.getHeight() / 2), frmCustomer.getWidth(), frmCustomer.getHeight());
            frmCustomer.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        } 
    }//GEN-LAST:event_MenuCustomerActionPerformed

    private void MenuTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTransaksiActionPerformed
        // TODO add your handling code here:
        try {
            frmTransaksi frmTransaksi = new frmTransaksi();
            frmMDI.add(frmTransaksi);
            frmTransaksi.setBounds((frmMDI.getWidth() / 2) 
                            - (frmTransaksi.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmTransaksi.getHeight() / 2), frmTransaksi.getWidth(), frmTransaksi.getHeight());
            frmTransaksi.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        }     
    }//GEN-LAST:event_MenuTransaksiActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

    private void BtnBArangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBArangMouseClicked
        // Modify Button Barang
         try {
            frmBarang frmBarang = new frmBarang();
            frmMDI.add(frmBarang);
            frmBarang.setBounds((frmMDI.getWidth() / 2) 
                            - (frmBarang.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmBarang.getHeight() / 2), frmBarang.getWidth(), frmBarang.getHeight());
            frmBarang.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        }    
    }//GEN-LAST:event_BtnBArangMouseClicked

    private void BtnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTransaksiMouseClicked
        // Modify Button Transaksi
        try {
            frmTransaksi frmTransaksi = new frmTransaksi();
            frmMDI.add(frmTransaksi);
            frmTransaksi.setBounds((frmMDI.getWidth() / 2) 
                            - (frmTransaksi.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmTransaksi.getHeight() / 2), frmTransaksi.getWidth(), frmTransaksi.getHeight());
            frmTransaksi.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        } 
    }//GEN-LAST:event_BtnTransaksiMouseClicked

    private void BtnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupplierMouseClicked
        // Modify Button Supplier
        try {
            frmSupplier frmSupplier = new frmSupplier();
            frmMDI.add(frmSupplier);
            frmSupplier.setBounds((frmMDI.getWidth() / 2) 
                            - (frmSupplier.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmSupplier.getHeight() / 2), frmSupplier.getWidth(), frmSupplier.getHeight());
            frmSupplier.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        } 
    }//GEN-LAST:event_BtnSupplierMouseClicked

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
            java.util.logging.Logger.getLogger(frmMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aplikasi;
    private javax.swing.JLabel BtnBArang;
    private javax.swing.JLabel BtnLogin;
    private javax.swing.JLabel BtnLogout;
    private javax.swing.JLabel BtnSupplier;
    private javax.swing.JLabel BtnTransaksi;
    private javax.swing.JLabel LblAksiPanel;
    private javax.swing.JMenu MasterData;
    private javax.swing.JMenuItem MenuBarang;
    private javax.swing.JMenuItem MenuCustomer;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuSupplier;
    private javax.swing.JMenuItem MenuTransaksi;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JDesktopPane frmMDI;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
