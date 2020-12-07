import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class frmMDI extends javax.swing.JFrame{
    
    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;
    String level = "";

    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();

    public frmMDI()throws Exception{
        super("Aplikasi Toko");
        setSize((int) (0.8* dimensi.width), (int) (1 * dimensi.height));
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2
                - getHeight() / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
    }
    
    private void aksesAdmin(){
        BtnBarang.setVisible(true);
        BtnTransaksi.setVisible(true);
        BtnSupplier.setVisible(true); 
    }
    
    private void aksesUser(){
        BtnBarang.setVisible(false);
        BtnTransaksi.setVisible(true);
        BtnSupplier.setVisible(false); 
        
    }
    
    private void BtnBarang(){
        try {
            frmBarang frmBarang = new frmBarang();
            frmMDI.add(frmBarang);
            frmBarang.setBounds((frmMDI.getWidth() / 2) 
                            - (frmBarang.getWidth() / 2), (frmMDI.getHeight() / 2) 
                                    - (frmBarang.getHeight() / 2), frmBarang.getWidth(), frmBarang.getHeight());
            frmBarang.setVisible(true);
            frmTransaksi frmTransaksi = new frmTransaksi();
            frmMDI.add(frmTransaksi);
            frmTransaksi.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sistem! " + e.getMessage());
        }    
    }
    
    private void BtnTransaksi(){
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
    }
    
    private void BtnSupplier(){
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
    }
    
    private void BtnCustomer(){
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("img//bg-apk4.jpg"));
        Image img = icon.getImage();
        frmMDI = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),
                    getHeight(),this);
            }
        };
        PnlAksi = new javax.swing.JPanel();
        BtnTransaksi = new javax.swing.JLabel();
        BtnSupplier = new javax.swing.JLabel();
        BtnCustomer = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtnBarang = new javax.swing.JLabel();
        BtnUserAccount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LblAksiPanel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        Aplikasi = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frmMDI.setBackground(new java.awt.Color(255, 255, 255));
        frmMDI.setForeground(new java.awt.Color(204, 204, 204));

        PnlAksi.setBackground(new java.awt.Color(162, 252, 255));
        PnlAksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BtnTransaksi.png"))); // NOI18N
        BtnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTransaksiMouseClicked(evt);
            }
        });
        PnlAksi.add(BtnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 576, -1, -1));

        BtnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BtnSupplier.png"))); // NOI18N
        BtnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSupplierMouseClicked(evt);
            }
        });
        PnlAksi.add(BtnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 355, -1, -1));

        BtnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BtnCustomer.png"))); // NOI18N
        BtnCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCustomerMouseClicked(evt);
            }
        });
        PnlAksi.add(BtnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 442, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MASTER DATA");
        PnlAksi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 221, 169, -1));

        BtnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BtnBarang.png"))); // NOI18N
        BtnBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBarangMouseClicked(evt);
            }
        });
        PnlAksi.add(BtnBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 268, -1, -1));

        BtnUserAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BtnUserAccount.png"))); // NOI18N
        PnlAksi.add(BtnUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 710, 300, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TRANSAKSI");
        PnlAksi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 529, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("USER");
        PnlAksi.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 663, 129, -1));

        LblAksiPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg-panelAksi.jpg"))); // NOI18N
        LblAksiPanel.setPreferredSize(new java.awt.Dimension(450, 950));
        PnlAksi.add(LblAksiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 970));

        Aplikasi.setText("Program");

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
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmMDI)
            .addComponent(PnlAksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBarangMouseClicked
        // Modify Button Barang
        try{
            
            BtnBarang();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal menutup form" + e.getMessage());
        } 
    }//GEN-LAST:event_BtnBarangMouseClicked

    private void BtnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTransaksiMouseClicked
        // Modify Button Transaksi
        BtnTransaksi();
    }//GEN-LAST:event_BtnTransaksiMouseClicked

    private void BtnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupplierMouseClicked
        // Modify Button Supplier
        BtnSupplier();
    }//GEN-LAST:event_BtnSupplierMouseClicked

    private void BtnCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCustomerMouseClicked
        // Modify button customer
        BtnCustomer();
    }//GEN-LAST:event_BtnCustomerMouseClicked

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        // Menutup program
        System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

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
                try {
                    
                    new frmMDI().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmMDI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aplikasi;
    private javax.swing.JLabel BtnBarang;
    private javax.swing.JLabel BtnCustomer;
    private javax.swing.JLabel BtnSupplier;
    private javax.swing.JLabel BtnTransaksi;
    private javax.swing.JLabel BtnUserAccount;
    private javax.swing.JLabel LblAksiPanel;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JDesktopPane frmMDI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
