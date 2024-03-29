
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
    
    
    /* Mendefenisikan Variabel admin*/
    private String Username = "admin";
    private String Password = "admin";
    
    
    
    
    public frmMDI() {
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

        ImageIcon icon = new ImageIcon(getClass().getResource("bg-apk.jpg"));
        Image img = icon.getImage();
        frmMDI = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),
                    getHeight(),this);
            }
        };
        frmLogin = new javax.swing.JInternalFrame();
        PnlLogin = new javax.swing.JPanel();
        LblUsername = new javax.swing.JLabel();
        LblPassword = new javax.swing.JLabel();
        TxtUsername = new javax.swing.JTextField();
        BtnLogin = new javax.swing.JButton();
        TxtPassword = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        MasterData = new javax.swing.JMenu();
        MenuBarang = new javax.swing.JMenuItem();
        MenuTransaksi = new javax.swing.JMenuItem();
        MenuSupplier = new javax.swing.JMenuItem();
        MenuCustomer = new javax.swing.JMenuItem();
        Aplikasi = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        MenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frmMDI.setBackground(java.awt.SystemColor.activeCaption);
        frmMDI.setForeground(new java.awt.Color(204, 204, 204));

        frmLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frmLogin.setNormalBounds(new java.awt.Rectangle(0, 0, 1020, 740));
        frmLogin.setVisible(true);

        PnlLogin.setBackground(new java.awt.Color(204, 204, 204));
        PnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 18))); // NOI18N

        LblUsername.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblUsername.setText("Username");

        LblPassword.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblPassword.setText("Password");

        BtnLogin.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnLogin.setText("Login");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlLoginLayout = new javax.swing.GroupLayout(PnlLogin);
        PnlLogin.setLayout(PnlLoginLayout);
        PnlLoginLayout.setHorizontalGroup(
            PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLoginLayout.createSequentialGroup()
                .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblUsername)
                            .addComponent(LblPassword))
                        .addGap(53, 53, 53)
                        .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(TxtPassword)))
                    .addGroup(PnlLoginLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(BtnLogin)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        PnlLoginLayout.setVerticalGroup(
            PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLoginLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblUsername))
                .addGap(31, 31, 31)
                .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblPassword)
                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(BtnLogin)
                .addContainerGap())
        );

        javax.swing.GroupLayout frmLoginLayout = new javax.swing.GroupLayout(frmLogin.getContentPane());
        frmLogin.getContentPane().setLayout(frmLoginLayout);
        frmLoginLayout.setHorizontalGroup(
            frmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmLoginLayout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(PnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
        );
        frmLoginLayout.setVerticalGroup(
            frmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmLoginLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(PnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        frmMDI.add(frmLogin);
        frmLogin.setBounds(0, 0, 1020, 710);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        frmMDI.add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 452, 110);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        frmMDI.add(jScrollPane2);
        jScrollPane2.setBounds(530, 130, 452, 110);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Barang");
        frmMDI.add(jLabel1);
        jLabel1.setBounds(220, 100, 100, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Daftar Transaksi");
        frmMDI.add(jLabel2);
        jLabel2.setBounds(700, 100, 120, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        frmMDI.add(jPanel1);
        jPanel1.setBounds(10, 610, 1000, 90);

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

        jMenuItem1.setText("Inventori Barang");
        Aplikasi.add(jMenuItem1);

        jMenu2.setText("Export");

        jMenuItem2.setText("Transaksi Penjualan");
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Barang");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Supplier");
        jMenu2.add(jMenuItem4);

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
            .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void MenuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBarangActionPerformed
        // TODO add your handling code here:
        frmBarang frmBarang = new frmBarang();
        frmMDI.add(frmBarang);
        if(Username.equals(TxtUsername.getText()) && Password.equals(TxtPassword.getText())){
            MenuBarang.setEnabled(true);
            frmBarang.setVisible(true);    
        }
    }//GEN-LAST:event_MenuBarangActionPerformed

    private void MenuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSupplierActionPerformed
        // TODO add your handling code here:
        frmSupplier frmSupplier = new frmSupplier();
        frmMDI.add(frmSupplier);
        if(Username.equals(TxtUsername.getText()) && Password.equals(TxtPassword.getText())){
            MenuSupplier.setEnabled(true);
            frmSupplier.setVisible(true);    
        }
    }//GEN-LAST:event_MenuSupplierActionPerformed

    private void MenuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCustomerActionPerformed
        // TODO add your handling code here:
        frmCustomer frmCustomer = new frmCustomer();
        frmMDI.add(frmCustomer);
        if(Username.equals(TxtUsername.getText()) && Password.equals(TxtPassword.getText())){
            MenuCustomer.setEnabled(true);
            frmCustomer.setVisible(true);    
        }
    }//GEN-LAST:event_MenuCustomerActionPerformed

    private void MenuTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTransaksiActionPerformed
        // TODO add your handling code here:
        frmTransaksi frmTransaksi = new frmTransaksi();
        frmMDI.add(frmTransaksi);
        if(Username.equals(TxtUsername.getText()) && Password.equals(TxtPassword.getText())){
            MenuTransaksi.setEnabled(true);
            frmTransaksi.setVisible(true);    
        }
    }//GEN-LAST:event_MenuTransaksiActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        // TODO add your handling code here:
        TxtUsername.requestFocus();

        if(!Username.equals(TxtUsername.getText()) && !Password.equals(TxtPassword.getText())){

            JOptionPane.showMessageDialog(null, "Username atau Password salah !!!");
            TxtUsername.setText("");
            TxtPassword.setText("");

        }
        else if(Username.equals(TxtUsername.getText()) && Password.equals(TxtPassword.getText())){

            PnlLogin.setVisible(false);
            frmLogin.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Username atau Password salah !!!");
            TxtUsername.setText("");
            TxtPassword.setText("");
        }
    }//GEN-LAST:event_BtnLoginActionPerformed

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
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel LblPassword;
    private javax.swing.JLabel LblUsername;
    private javax.swing.JMenu MasterData;
    private javax.swing.JMenuItem MenuBarang;
    private javax.swing.JMenuItem MenuCustomer;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuSupplier;
    private javax.swing.JMenuItem MenuTransaksi;
    private javax.swing.JPanel PnlLogin;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JInternalFrame frmLogin;
    private javax.swing.JDesktopPane frmMDI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
