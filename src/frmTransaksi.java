
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class frmTransaksi extends javax.swing.JInternalFrame {

    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;
    int totalHarga, jumlah, harga;

    /**
     * Creates new form frmTransaksi
     *
     * @throws java.lang.Exception
     */
    public frmTransaksi() throws Exception {
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
        updateTabelBarang();
        updateTabelTransaksi();
        TxtTotalHarga.setEditable(false);

    }

    public void clear() {
        TxtIdTransaksi.setText("");
        txtIdCustomer.setText("");
        txtKodeBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtTotalHarga.setText("");
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    private void updateTabelBarang() {
        try {
            String sql = "SELECT * FROM tb_barang;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tabBarang.getModel();
            dtm.setRowCount(0);
            String[] data = new String[4];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("kd_barang");
                data[1] = rs.getString("nama_barang");
                data[2] = rs.getString("stok_barang");
                data[3] = rs.getString("harga_barang");
                dtm.addRow(data);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error " + e.getMessage());
        }
    }

    private void updateTabelTransaksi() {
        try {
            String sql = "SELECT * FROM tb_transaksi;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tabTransaksi.getModel();
            dtm.setRowCount(0);
            String[] data = new String[7];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_transaksi");
                data[1] = rs.getString("id_customer");
                data[2] = rs.getString("kode_barang");
                data[3] = rs.getString("tanggal");
                data[4] = rs.getString("jumlah_barang");
                data[5] = rs.getString("harga");
                data[6] = rs.getString("total");
                dtm.addRow(data);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "tabel error " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LblHarga = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        LblJumlah = new javax.swing.JLabel();
        LblTotalHarga = new javax.swing.JLabel();
        TxtTotalHarga = new javax.swing.JTextField();
        PnlAksi = new javax.swing.JPanel();
        BtnBeli = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        LblTransaksi = new javax.swing.JLabel();
        LblCustomer = new javax.swing.JLabel();
        LblKodeBarang = new javax.swing.JLabel();
        LblTanggal = new javax.swing.JLabel();
        TxtIdTransaksi = new javax.swing.JTextField();
        TxtJumlah = new javax.swing.JTextField();
        txtIdCustomer = new javax.swing.JTextField();
        txtKodeBarang = new javax.swing.JTextField();
        JTanggal = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        barangSearchButton = new javax.swing.JButton();
        txtSearchBarang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabBarang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabTransaksi = new javax.swing.JTable();
        transaksiSearchButton = new javax.swing.JButton();
        txtSearchTransaksi = new javax.swing.JTextField();
        BtnExit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        jLabel2.setText("form transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA TRANSAKSI"));

        LblHarga.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblHarga.setText("Harga");

        LblJumlah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblJumlah.setText("Jumlah");

        LblTotalHarga.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTotalHarga.setText("Total Harga");

        PnlAksi.setBackground(new java.awt.Color(204, 204, 204));
        PnlAksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 16))); // NOI18N
        PnlAksi.setPreferredSize(new java.awt.Dimension(224, 155));

        BtnBeli.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnBeli.setText("Beli");
        BtnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBeliActionPerformed(evt);
            }
        });

        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.setMaximumSize(new java.awt.Dimension(103, 25));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

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
                    .addComponent(BtnBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        PnlAksiLayout.setVerticalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAksiLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(BtnBeli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClear))
                .addGap(24, 24, 24))
        );

        LblTransaksi.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTransaksi.setText("ID Transaksi");

        LblCustomer.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblCustomer.setText("Id Customer");

        LblKodeBarang.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblKodeBarang.setText("Kode Barang");

        LblTanggal.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTanggal.setText("Tanggal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblTransaksi)
                            .addComponent(LblCustomer)
                            .addComponent(LblKodeBarang)
                            .addComponent(LblHarga)
                            .addComponent(LblJumlah)
                            .addComponent(LblTotalHarga)
                            .addComponent(LblTanggal))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(TxtTotalHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTransaksi))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCustomer)
                    .addComponent(txtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblKodeBarang)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LblTanggal)
                    .addComponent(JTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblHarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblJumlah)
                    .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTotalHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR BARANG"));

        barangSearchButton.setText("Cari");
        barangSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangSearchButtonActionPerformed(evt);
            }
        });

        tabBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga", "Stok"
            }
        ));
        jScrollPane2.setViewportView(tabBarang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barangSearchButton)
                .addGap(18, 18, 18)
                .addComponent(txtSearchBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barangSearchButton)
                    .addComponent(txtSearchBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR TRANSAKSI"));

        tabTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "ID Customer", "Kode Barang", "Tanggal", "Harga", "Jumlah", "Total Harga"
            }
        ));
        tabTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabTransaksi);

        transaksiSearchButton.setText("Cari");

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
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(transaksiSearchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnExit))
                            .addComponent(jScrollPane1))
                        .addGap(27, 27, 27))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transaksiSearchButton)
                    .addComponent(txtSearchTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBeliActionPerformed
        // TODO add your handling code here:

        harga = Integer.parseInt(TxtHarga.getText());
        jumlah = Integer.parseInt(TxtJumlah.getText());
        totalHarga = harga * jumlah;
        TxtTotalHarga.setText(Integer.toString(totalHarga));

        //deklarasi tanggal
        //SET TANGGAL HARUS SAMA DENGAN TANGGAL KOMPUTER/CURRENT DATE
        String format = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(format);
        String tanggal = String.valueOf(fm.format(JTanggal.getDate()));

        try {
            String sql = "INSERT INTO tb_transaksi VALUES('"
                    + "" + TxtIdTransaksi.getText() + "','"
                    + "" + txtIdCustomer.getText() + "','"
                    + "" + txtKodeBarang.getText() + "','"
                    + "" + tanggal + "','"
                    + "" + harga + "','"
                    + "" + jumlah + "','"
                    + "" + totalHarga + "')";

            stat = conn.createStatement();
            int res = stat.executeUpdate(sql);
            if (res == 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Barang Berhasil Dibeli! !");
                updateTabelTransaksi();
                clear();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tambah  Data GAGAL! " + e.getMessage());
        }
    }//GEN-LAST:event_BtnBeliActionPerformed

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void tabTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransaksiMouseClicked
        // TODO add your handling code here:
        tabTransaksi.setEnabled(false);
        int baris = tabTransaksi.rowAtPoint(evt.getPoint());

        String idTransaksi = tabTransaksi.getValueAt(baris, 0).toString();
        TxtIdTransaksi.setText(idTransaksi);

        String idCustomer = tabTransaksi.getValueAt(baris, 1).toString();
        txtIdCustomer.setText(idCustomer);

        String kodeBarang = tabTransaksi.getValueAt(baris, 2).toString();
        txtKodeBarang.setText(idCustomer);

        String Harga = tabTransaksi.getValueAt(baris, 3).toString();
        TxtHarga.setText(Harga);

        String jumlah = tabTransaksi.getValueAt(baris, 4).toString();
        TxtJumlah.setText(jumlah);

        String TotalHarga = tabTransaksi.getValueAt(baris, 5).toString();
        TxtTotalHarga.setText(TotalHarga);
        tabTransaksi.setEnabled(true);
    }//GEN-LAST:event_tabTransaksiMouseClicked

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        TxtIdTransaksi.setEditable(false);
        try {

            String sql = "DELETE FROM tb_transaksi WHERE id_transaksi = '" + TxtIdTransaksi.getText() + "'";
            stat = conn.createStatement();
            int hapus = stat.executeUpdate(sql);
            if (hapus == 1) {
                JOptionPane.showMessageDialog(null, "Berhasil di hapus ");
                clear();
                updateTabelTransaksi();
                updateTabelBarang();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage());
        }
        TxtIdTransaksi.setEditable(true);
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void barangSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangSearchButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_barangSearchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBeli;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnHapus;
    private com.toedter.calendar.JDateChooser JTanggal;
    private javax.swing.JLabel LblCustomer;
    private javax.swing.JLabel LblHarga;
    private javax.swing.JLabel LblJumlah;
    private javax.swing.JLabel LblKodeBarang;
    private javax.swing.JLabel LblTanggal;
    private javax.swing.JLabel LblTotalHarga;
    private javax.swing.JLabel LblTransaksi;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtIdTransaksi;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtTotalHarga;
    private javax.swing.JButton barangSearchButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabBarang;
    private javax.swing.JTable tabTransaksi;
    private javax.swing.JButton transaksiSearchButton;
    private javax.swing.JTextField txtIdCustomer;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtSearchBarang;
    private javax.swing.JTextField txtSearchTransaksi;
    // End of variables declaration//GEN-END:variables
}
