import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class frmSupplier extends javax.swing.JInternalFrame  {
    
    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;

    /**
     * Creates new form frmSupplier
     * @throws java.lang.Exception
     */
    public frmSupplier() throws Exception{
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
        updateTabel();
    }
    
    public void updateTabel(){
     try {
            String sql = "SELECT * FROM tb_supplier;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarSupplier.getModel();
            dtm.setRowCount(0);
            String[] data = new String[5];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_supplier");
                data[1] = rs.getString("nama_supplier");
                data[2] = rs.getString("alamat_supplier");
                data[3] = rs.getString("email_supplier");
                data[4] = rs.getString("telp_supplier");
                dtm.addRow(data);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data " + e.getMessage());
        }
    }
    
    public void clear() {
        TxtKodeSupplier.setText("");
        TxtNamaSupplier.setText("");
        TxtAlamat.setText("");
        TxtEmail.setText("");
        TxtNoTelp.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PnlFormSupplier = new javax.swing.JPanel();
        LblFormSupplier = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TxtKodeSupplier = new javax.swing.JTextField();
        LblKodeSupplier = new javax.swing.JLabel();
        LblNamaSupplier = new javax.swing.JLabel();
        TxtNamaSupplier = new javax.swing.JTextField();
        LblAlamat = new javax.swing.JLabel();
        TxtAlamat = new javax.swing.JTextField();
        LblNoTelp = new javax.swing.JLabel();
        TxtNoTelp = new javax.swing.JTextField();
        LblEmail = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BtnCari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDaftarSupplier = new javax.swing.JTable();
        TxtCari = new javax.swing.JTextField();
        BtnExit = new javax.swing.JButton();

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

        setBackground(new java.awt.Color(255, 255, 255));

        PnlFormSupplier.setBackground(new java.awt.Color(204, 204, 204));

        LblFormSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        LblFormSupplier.setText("FORM SUPPLIER");

        javax.swing.GroupLayout PnlFormSupplierLayout = new javax.swing.GroupLayout(PnlFormSupplier);
        PnlFormSupplier.setLayout(PnlFormSupplierLayout);
        PnlFormSupplierLayout.setHorizontalGroup(
            PnlFormSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormSupplierLayout.createSequentialGroup()
                .addGap(463, 463, 463)
                .addComponent(LblFormSupplier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlFormSupplierLayout.setVerticalGroup(
            PnlFormSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormSupplierLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LblFormSupplier)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA SUPPLIER"));

        LblKodeSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblKodeSupplier.setText("Kode Supplier");

        LblNamaSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaSupplier.setText("Nama Supplier");

        LblAlamat.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblAlamat.setText("Alamat");

        LblNoTelp.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNoTelp.setText("No. Telp");

        LblEmail.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblEmail.setText("Email");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 18))); // NOI18N

        BtnTambah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.setPreferredSize(new java.awt.Dimension(100, 25));
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnEdit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 25));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnClear.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 25));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblKodeSupplier)
                            .addComponent(LblNamaSupplier))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE))
                            .addComponent(TxtNamaSupplier)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAlamat)
                            .addComponent(LblNoTelp)
                            .addComponent(LblEmail))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNoTelp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblKodeSupplier)
                    .addComponent(TxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNamaSupplier)
                    .addComponent(TxtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblAlamat)
                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNoTelp)
                    .addComponent(TxtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblEmail)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR SUPPLIER"));

        BtnCari.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnCari.setText("Cari");

        TblDaftarSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Supplier", "Nama Supplier", "Alamat", "Email", "No Telepon"
            }
        ));
        TblDaftarSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDaftarSupplierMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblDaftarSupplier);

        BtnExit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnExit.setText("Tutup");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnExit))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(BtnCari)
                                .addGap(18, 18, 18)
                                .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 384, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCari)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(BtnExit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlFormSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlFormSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
         try {
            String sql = "INSERT INTO tb_supplier VALUES('"
                    + "" + TxtKodeSupplier.getText() + "','"
                    + "" + TxtNamaSupplier.getText() + "','"
                    + "" + TxtAlamat.getText() + "','"
                    + "" + TxtEmail.getText() + "','"
                    + "" + TxtNoTelp.getText() + "')";
            
            stat = conn.createStatement();
            int res = stat.executeUpdate(sql);
            if (res == 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Data Barang Berhasil ditambah !");
                updateTabel();
                clear();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tambah  Data GAGAL! " + e.getMessage());
        }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void TblDaftarSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDaftarSupplierMouseClicked
        // TODO add your handling code here:
        TblDaftarSupplier.setEnabled(false);
        int baris = TblDaftarSupplier.rowAtPoint(evt.getPoint());

        String kodeSupplier = TblDaftarSupplier.getValueAt(baris, 0).toString();
        TxtKodeSupplier.setText(kodeSupplier);
        TxtKodeSupplier.setEditable(false);

        String namaSupplier = TblDaftarSupplier.getValueAt(baris, 1).toString();
        TxtNamaSupplier.setText(namaSupplier);
        
        String alamat = TblDaftarSupplier.getValueAt(baris, 2).toString();
        TxtAlamat.setText(alamat);
        
        String noTelp = TblDaftarSupplier.getValueAt(baris, 4).toString();
        TxtNoTelp.setText(noTelp);
        
        String email = TblDaftarSupplier.getValueAt(baris, 3).toString();
        TxtEmail.setText(email);
    }//GEN-LAST:event_TblDaftarSupplierMouseClicked

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        if (TxtKodeSupplier.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LENGKAPI SEMUA DATA!");
        } else {
            try {
                String sql = "UPDATE tb_supplier SET nama_supplier='"
                        + TxtNamaSupplier.getText()
                        + "',nama_supplier = '" + TxtNamaSupplier.getText() 
                        + "',alamat_supplier = '" + TxtAlamat.getText() 
                        + "',telp_supplier = '" + TxtNoTelp.getText() 
                        + "',email_supplier = '" + TxtEmail.getText()
                        + "'WHERE id_supplier = '" + TxtKodeSupplier.getText() + "'";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data Berhasil di Update!");
                updateTabel();
                clear();
                updateTabel();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Update Data Gagal!\n" + e.getMessage());
            }
            clear();
            updateTabel();
        }
        
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM tb_supplier WHERE id_supplier = '" + TxtKodeSupplier.getText() + "'";
            stat = conn.createStatement();
            int hapus = stat.executeUpdate(sql);
            if (hapus == 1) {
                JOptionPane.showMessageDialog(null, "Berhasil di hapus ");
                clear();
                updateTabel();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage());
        }
    }//GEN-LAST:event_BtnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JLabel LblAlamat;
    private javax.swing.JLabel LblEmail;
    private javax.swing.JLabel LblFormSupplier;
    private javax.swing.JLabel LblKodeSupplier;
    private javax.swing.JLabel LblNamaSupplier;
    private javax.swing.JLabel LblNoTelp;
    private javax.swing.JPanel PnlFormSupplier;
    private javax.swing.JTable TblDaftarSupplier;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtKodeSupplier;
    private javax.swing.JTextField TxtNamaSupplier;
    private javax.swing.JTextField TxtNoTelp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
