import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class frmCustomer extends javax.swing.JInternalFrame {

    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;
    
    public frmCustomer() throws Exception {
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
        UpdateTabel();
    }
    
    private void searchCustomer(String customer) {
        try {
            String sql = "SELECT * from tb_customer WHERE id_customer LIKE '%"
                    + customer + "%' OR nama_customer LIKE '%"
                    + customer + "%' OR alamat_customer LIKE '%"
                    + customer + "%' OR email_customer LIKE '%"
                    + customer + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TableDaftarCustomer.getModel();
            dtm.setRowCount(0);
            String[] data = new String[5];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_customer");
                data[1] = rs.getString("nama_customer");
                data[2] = rs.getString("alamat_customer");
                data[3] = rs.getString("email_customer");
                dtm.addRow(data);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal mencari " + e.getMessage());
        }
    }
    
    private void UpdateTabel() {
        try {
            String sql = "SELECT * FROM tb_customer;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TableDaftarCustomer.getModel();
            dtm.setRowCount(0);
            String[] data = new String[5];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_customer");
                data[1] = rs.getString("nama_customer");
                data[2] = rs.getString("alamat_customer");
                data[3] = rs.getString("email_customer");
                data[4] = rs.getString("password");
                dtm.addRow(data);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data " + e.getMessage());
        }
    }
      
    public void clear(){
        TxtIdCustomer.setText("");
        TxtNamaLengkap.setText("");
        TxtAlamat.setText("");
        TxtEmail.setText("");
        TxtPassword.setText("");
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jSpinner1 = new javax.swing.JSpinner();
        PnlFormCustomer = new javax.swing.JPanel();
        LblFormCustomer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        TxtAlamat = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        LblIdCustomer = new javax.swing.JLabel();
        LblPassword = new javax.swing.JLabel();
        LblNamaLengkap = new javax.swing.JLabel();
        LblAlamat = new javax.swing.JLabel();
        LblEmail = new javax.swing.JLabel();
        TxtIdCustomer = new javax.swing.JTextField();
        TxtNamaLengkap = new javax.swing.JTextField();
        PnlAksi = new javax.swing.JPanel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        TxtPassword = new javax.swing.JPasswordField();
        LblMatch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDaftarCustomer = new javax.swing.JTable();
        TxtCari = new javax.swing.JTextField();
        BtnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setBackground(new java.awt.Color(255, 255, 255));
        setFrameIcon(null);
        setOpaque(true);

        PnlFormCustomer.setBackground(new java.awt.Color(204, 204, 204));

        LblFormCustomer.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        LblFormCustomer.setText("Form Customer");

        javax.swing.GroupLayout PnlFormCustomerLayout = new javax.swing.GroupLayout(PnlFormCustomer);
        PnlFormCustomer.setLayout(PnlFormCustomerLayout);
        PnlFormCustomerLayout.setHorizontalGroup(
            PnlFormCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormCustomerLayout.createSequentialGroup()
                .addGap(472, 472, 472)
                .addComponent(LblFormCustomer)
                .addContainerGap(496, Short.MAX_VALUE))
        );
        PnlFormCustomerLayout.setVerticalGroup(
            PnlFormCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormCustomerLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LblFormCustomer)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA CUSTOMER"));

        LblIdCustomer.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblIdCustomer.setText("ID");

        LblPassword.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblPassword.setText("Password");

        LblNamaLengkap.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaLengkap.setText("Nama Lengkap");

        LblAlamat.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblAlamat.setText("Alamat");

        LblEmail.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblEmail.setText("Email ");

        PnlAksi.setBackground(new java.awt.Color(255, 255, 255));
        PnlAksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 16))); // NOI18N

        BtnTambah.setBackground(new java.awt.Color(0, 255, 51));
        BtnTambah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnEdit.setBackground(new java.awt.Color(255, 255, 51));
        BtnEdit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnHapus.setBackground(new java.awt.Color(255, 51, 51));
        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnClear.setBackground(new java.awt.Color(255, 153, 102));
        BtnClear.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlAksiLayout = new javax.swing.GroupLayout(PnlAksi);
        PnlAksi.setLayout(PnlAksiLayout);
        PnlAksiLayout.setHorizontalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlAksiLayout.setVerticalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnEdit))
                .addGap(18, 18, 18)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus)
                    .addComponent(BtnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblIdCustomer)
                            .addComponent(LblAlamat)
                            .addComponent(LblEmail)
                            .addComponent(LblNamaLengkap))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtNamaLengkap)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(TxtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 61, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LblMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                    .addComponent(TxtAlamat)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblIdCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNamaLengkap))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblAlamat)
                    .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR CUSTOMER"));

        TableDaftarCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Lengkap", "Alamat", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableDaftarCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDaftarCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDaftarCustomer);

        TxtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCariKeyPressed(evt);
            }
        });

        BtnExit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnExit.setText("Tutup");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        jLabel2.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnExit)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnExit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PnlFormCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlFormCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // Menutup form customer
        this.setVisible(false);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // Menambah data customer
        
        try {

            String sql = "INSERT INTO tb_customer VALUES('" 
                    + "" + TxtIdCustomer.getText() + "','"
                    + "" + TxtNamaLengkap.getText() + "','"
                    + "" + TxtAlamat.getText() + "','"
                    + "" + TxtEmail.getText() + "','"
                    + "" + Arrays.toString(TxtPassword.getPassword()) + "')";
            stat = conn.createStatement();
            int res = stat.executeUpdate(sql);
             if (res==1){
                javax.swing.JOptionPane.showMessageDialog(null,"Data Customer Berhasil ditambah !");
                UpdateTabel();
                clear();
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Tambah  Data GAGAL! " + e.getMessage());
        }
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // Menghapus data customer
        TxtIdCustomer.setEditable(false);
        try{
            String sql = "DELETE FROM tb_customer WHERE id_customer = '"+ TxtIdCustomer.getText()+ "'";
            stat = conn.createStatement();
            int hapus = stat.executeUpdate(sql);
            if(hapus == 1){
                JOptionPane.showMessageDialog(null, "Berhasil di hapus ");
                clear();
                UpdateTabel();
                
            }
            }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage());
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // Mengedit data customer
        TxtIdCustomer.setEditable(false);
        
        String password = "";
        
        password = Arrays.toString(TxtPassword.getPassword());
        
        if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Password wajib di isi");
        }
        
        else if (TxtIdCustomer.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "LENGKAPI SEMUA DATA!");
        } else {
            try {
                String sql = "UPDATE tb_customer SET nama_customer='" 
                        + TxtNamaLengkap.getText() 
                        + "',nama_customer = '" + TxtNamaLengkap.getText() 
                        + "',alamat_customer = '" + TxtAlamat.getText() 
                        + "',email_customer = '" + TxtEmail.getText()
                        + "',password = '" + password
                        + "'WHERE id_customer = '" + TxtIdCustomer.getText() + "'";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data Berhasil di Update!");
                UpdateTabel();
                clear();
                UpdateTabel();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Update Data Gagal!\n" + e.getMessage());
            }
            clear();
            UpdateTabel();
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void TableDaftarCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDaftarCustomerMouseClicked
        // ketika sebuah kolom pada tabel di pilih
        TableDaftarCustomer.setEnabled(false);
        int baris = TableDaftarCustomer.rowAtPoint(evt.getPoint());

        String IdCustomer = TableDaftarCustomer.getValueAt(baris, 0).toString();
        TxtIdCustomer.setText(IdCustomer);

        String namaLengkap = TableDaftarCustomer.getValueAt(baris, 1).toString();
        TxtNamaLengkap.setText(namaLengkap);

        String alamat = TableDaftarCustomer.getValueAt(baris, 2).toString();
        TxtAlamat.setText(alamat);

        String Email = TableDaftarCustomer.getValueAt(baris, 3).toString();
        TxtEmail.setText(Email);
        /*
        String password = TableDaftarCustomer.getValueAt(baris, 5).toString();
        TxtPassword.setText(password);
        */
    }//GEN-LAST:event_TableDaftarCustomerMouseClicked

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void TxtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariKeyPressed
        // TODO add your handling code here:
        String customer = TxtCari.getText();
        
        if (customer != "") {
            searchCustomer(customer);
        } else {
            UpdateTabel();
        }
    }//GEN-LAST:event_TxtCariKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JLabel LblAlamat;
    private javax.swing.JLabel LblEmail;
    private javax.swing.JLabel LblFormCustomer;
    private javax.swing.JLabel LblIdCustomer;
    private javax.swing.JLabel LblMatch;
    private javax.swing.JLabel LblNamaLengkap;
    private javax.swing.JLabel LblPassword;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JPanel PnlFormCustomer;
    private javax.swing.JTable TableDaftarCustomer;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtCari;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtIdCustomer;
    private javax.swing.JTextField TxtNamaLengkap;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables

    private String StringValueOf(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
