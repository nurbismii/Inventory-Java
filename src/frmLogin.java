
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class frmLogin extends javax.swing.JFrame {

    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;
    String level = "";
    
    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    
    public frmLogin() throws Exception {
        super("Login");
        setSize((int) (0.7 * dimensi.width), (int) (0.7 * dimensi.height));
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2
                - getHeight() / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
  
    } 
    private void login(){
        try{

            String sql = "SELECT level FROM tb_user WHERE username='"+TxtUsername.getText()+"' AND password='"+TxtPassword.getText()+"'";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            
            while(rs.next()){
                level = rs.getString(1);
            }
            if(level.equals("admin")){
                JOptionPane.showMessageDialog(null, "Berhasil login sebagai admin");
                this.setVisible(false);
                new frmMDI().setVisible(true);
                
            }
            else if(level.equals("user")){
                JOptionPane.showMessageDialog(null, "Berhasil login sebagai user");
                this.setVisible(false); 
                new frmMDI().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Silahkan login terlebih dahulu");
               
            }
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan" + e.getMessage());
        }
    }
    
    public void clear(){
        TxtUsername.setText("");
        TxtPassword.setText("");
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlLogin = new javax.swing.JPanel();
        LblPassword = new javax.swing.JLabel();
        LblbgKiri = new javax.swing.JLabel();
        LblUsername = new javax.swing.JLabel();
        TxtUsername = new javax.swing.JTextField();
        TxtPassword = new javax.swing.JPasswordField();
        BtnLogin = new javax.swing.JButton();
        LblBuatAkun = new javax.swing.JLabel();
        LblSistem = new javax.swing.JLabel();
        BtnClose = new javax.swing.JLabel();
        LblbgKanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblPassword.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        LblPassword.setForeground(new java.awt.Color(255, 255, 255));
        LblPassword.setText("PASSWORD");
        PnlLogin.add(LblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 150, 30));

        LblbgKiri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblbgKiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg-login.jpg"))); // NOI18N
        PnlLogin.add(LblbgKiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 606, 720));

        LblUsername.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        LblUsername.setForeground(new java.awt.Color(255, 255, 255));
        LblUsername.setText("USERNAME");
        PnlLogin.add(LblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 140, 30));

        TxtUsername.setForeground(new java.awt.Color(51, 51, 51));
        PnlLogin.add(TxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, 210, -1));
        PnlLogin.add(TxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, 210, -1));

        BtnLogin.setBackground(new java.awt.Color(51, 255, 51));
        BtnLogin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BtnLogin.setText("LOGIN");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        BtnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnLoginKeyPressed(evt);
            }
        });
        PnlLogin.add(BtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 500, 120, -1));

        LblBuatAkun.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        LblBuatAkun.setForeground(new java.awt.Color(102, 153, 255));
        LblBuatAkun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblBuatAkun.setText("Buat Akun");
        PnlLogin.add(LblBuatAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 500, -1, -1));

        LblSistem.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        LblSistem.setForeground(new java.awt.Color(255, 255, 255));
        LblSistem.setText("SISTEM LOGIN ");
        PnlLogin.add(LblSistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, -1, -1));

        BtnClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        BtnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCloseMouseClicked(evt);
            }
        });
        PnlLogin.add(BtnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, -1, -1));

        LblbgKanan.setForeground(new java.awt.Color(255, 255, 255));
        LblbgKanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblbgKanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg-login-kanan.png"))); // NOI18N
        PnlLogin.add(LblbgKanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 660, 720));

        getContentPane().add(PnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCloseMouseClicked
        // Menutup frame
        this.setVisible(false);
    }//GEN-LAST:event_BtnCloseMouseClicked

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        // Login akun
        login();
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void BtnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnLoginKeyPressed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_BtnLoginKeyPressed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmLogin().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnClose;
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel LblBuatAkun;
    private javax.swing.JLabel LblPassword;
    private javax.swing.JLabel LblSistem;
    private javax.swing.JLabel LblUsername;
    private javax.swing.JLabel LblbgKanan;
    private javax.swing.JLabel LblbgKiri;
    private javax.swing.JPanel PnlLogin;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JTextField TxtUsername;
    // End of variables declaration//GEN-END:variables
}
