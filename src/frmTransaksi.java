
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

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
    int totalHarga, jumlah, harga, stok, jmlAwal;
    String tanggal, temp, kodeBarang;

    /**
     * Creates new form frmTransaksi
     */
    public frmTransaksi() throws Exception {
        initComponents();
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        updateTabelBarang();
        updateTabelTransaksi();
        LblIdTransaksi.setVisible(false);
        TxtIdTransaksi.setVisible(false);
    }

    public void updateStok() {
        try {
            String sql = "UPDATE tb_barang SET stok_barang = '"
                    + (Integer.parseInt(temp) - Integer.parseInt(TxtJumlah.getText()))
                    + "' WHERE kd_barang = '" + kodeBarang + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Barang gagal diupdate" + e.getMessage());
        }
    }

    public void clear() {
        TxtIdTransaksi.setText("");
        TxtIdCustomer.setText("");
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtTotalHarga.setText("");
        LblTanggalTransaksi.setText("");
    }

    private void searchBarang(String barang) {
        try {
            String sql = "SELECT * from tb_barang WHERE kd_barang LIKE '%"
                    + barang + "%' OR nama_barang LIKE '%"
                    + barang + "%' OR stok_barang LIKE '%"
                    + barang + "%' OR harga_barang LIKE '%"
                    + barang + "%' OR totalHarga LIKE '%"
                    + barang + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarBarang.getModel();
            dtm.setRowCount(0);
            String[] data = new String[5];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("kd_barang");
                data[1] = rs.getString("nama_barang");
                data[2] = rs.getString("stok_barang");
                data[3] = rs.getString("harga_barang");
                data[4] = rs.getString("totalHarga");
                dtm.addRow(data);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal mencari " + e.getMessage());
        }
    }

    private void searchTransaksi(String transaksi) {
        try {
            String sql = "SELECT * from tb_transaksi WHERE id_transaksi LIKE '%"
                    + transaksi + "%' OR id_customer LIKE '%"
                    + transaksi + "%' OR nama_barang LIKE '%"
                    + transaksi + "%' OR tanggal_transaksi LIKE '%"
                    + transaksi + "%' OR jumlah_barang LIKE '%"
                    + transaksi + "%' OR harga LIKE '%"
                    + transaksi + "%' OR total LIKE '%"
                    + transaksi + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarTransaksi.getModel();
            dtm.setRowCount(0);
            String[] data = new String[7];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_transaksi");
                data[1] = rs.getString("id_customer");
                data[2] = rs.getString("nama_barang");
                data[3] = rs.getString("tanggal_transaksi");
                data[4] = rs.getString("jumlah_barang");
                data[5] = rs.getString("harga");
                data[6] = rs.getString("total");
                dtm.addRow(data);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal mencari" + e.getMessage());
        }
    }

    private void updateTabelBarang() {
        try {
            String sql = "SELECT * FROM tb_barang;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarBarang.getModel();
            dtm.setRowCount(0);
            String[] data = new String[4];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("kd_barang");
                data[1] = rs.getString("nama_barang");
                data[2] = rs.getString("harga_barang");
                data[3] = rs.getString("stok_barang");
                dtm.addRow(data);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data " + e.getMessage());
        }
    }

    private void updateTabelTransaksi() {
        try {
            String sql = "SELECT * FROM tb_transaksi;";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarTransaksi.getModel();
            dtm.setRowCount(0);
            String[] data = new String[7];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_transaksi");
                data[1] = rs.getString("id_customer");
                data[2] = rs.getString("nama_barang");
                data[3] = rs.getString("jumlah_barang");
                data[4] = rs.getString("harga");
                data[5] = rs.getString("tanggal_transaksi");
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
        LblCustomer = new javax.swing.JLabel();
        LblNamaBarang = new javax.swing.JLabel();
        TxtJumlah = new javax.swing.JTextField();
        TxtIdCustomer = new javax.swing.JTextField();
        TxtNamaBarang = new javax.swing.JTextField();
        LblTanggalTransaksi = new javax.swing.JLabel();
        LblIdTransaksi = new javax.swing.JLabel();
        TxtIdTransaksi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        BtnCariBarang = new javax.swing.JButton();
        TxtCariDataBarang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDaftarBarang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDaftarTransaksi = new javax.swing.JTable();
        BtnCariTransaksi = new javax.swing.JButton();
        TxtCariTransaksi = new javax.swing.JTextField();
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
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PnlAksiLayout.createSequentialGroup()
                        .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlAksiLayout.setVerticalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlAksiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBeli)
                .addGap(18, 18, 18)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnClear))
                .addGap(24, 24, 24))
        );

        LblCustomer.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblCustomer.setText("Id Customer");

        LblNamaBarang.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaBarang.setText("Nama Barang");

        LblTanggalTransaksi.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTanggalTransaksi.setText("Tanggal Transaksi :");

        LblIdTransaksi.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblIdTransaksi.setText("ID Transaksi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(LblTanggalTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblCustomer)
                                    .addComponent(LblNamaBarang)
                                    .addComponent(LblHarga)
                                    .addComponent(LblJumlah)
                                    .addComponent(LblTotalHarga))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(TxtHarga, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtIdCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblIdTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblIdTransaksi)
                    .addComponent(TxtIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCustomer)
                    .addComponent(TxtIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNamaBarang)
                    .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblHarga)
                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblJumlah)
                    .addComponent(TxtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTotalHarga)
                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR BARANG"));

        BtnCariBarang.setText("Cari");

        TxtCariDataBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCariDataBarangKeyPressed(evt);
            }
        });

        TblDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        TblDaftarBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDaftarBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblDaftarBarang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BtnCariBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCariDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCariBarang)
                    .addComponent(TxtCariDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR TRANSAKSI"));

        TblDaftarTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Transaksi", "ID Customer", "Nama Barang", "Harga", "Jumlah", "Tanggal", "Total Harga"
            }
        ));
        TblDaftarTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDaftarTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDaftarTransaksi);

        BtnCariTransaksi.setText("Cari");

        TxtCariTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCariTransaksiKeyPressed(evt);
            }
        });

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
                        .addComponent(BtnCariTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BtnExit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE))
                        .addGap(27, 27, 27))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCariTransaksi)
                    .addComponent(TxtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnExit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtnExitActionPerformed

    private void TblDaftarBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDaftarBarangMouseClicked
        // TODO add your handling code here:
        Date date = new Date();
        TblDaftarBarang.setEnabled(false);
        int baris = TblDaftarBarang.rowAtPoint(evt.getPoint());

        kodeBarang = TblDaftarBarang.getValueAt(baris, 0).toString();

        String namaBarang = TblDaftarBarang.getValueAt(baris, 1).toString();
        TxtNamaBarang.setText(namaBarang);

        String hargaBarang = TblDaftarBarang.getValueAt(baris, 2).toString();
        TxtHarga.setText(hargaBarang);

        tanggal = String.format("%s %tB %<te, %<tY", "", date);
        LblTanggalTransaksi.setText("Tanggal  :" + tanggal);

        temp = TblDaftarBarang.getValueAt(baris, 3).toString();
    }//GEN-LAST:event_TblDaftarBarangMouseClicked

    private void BtnBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBeliActionPerformed
        // TODO add your handling code here:
        harga = Integer.parseInt(TxtHarga.getText());
        jumlah = Integer.parseInt(TxtJumlah.getText());
        totalHarga = harga * jumlah;
        TxtTotalHarga.setText(Integer.toString(totalHarga));

        if (Integer.parseInt(TxtJumlah.getText()) <= Integer.parseInt(temp)) {
            try {
                String sql = "INSERT INTO tb_transaksi VALUES(null,'"
                        + "" + TxtIdCustomer.getText() + "','"
                        + "" + TxtNamaBarang.getText() + "','"
                        + "" + harga + "','"
                        + "" + jumlah + "','"
                        + "" + tanggal + "','"
                        + "" + totalHarga + "')";

                stat = conn.createStatement();
                int res = stat.executeUpdate(sql);
                if (res == 1) {
                    updateStok();
                    javax.swing.JOptionPane.showMessageDialog(null, "Barang Berhasil Dibeli! !");
                    clear();
                    updateTabelTransaksi();
                    updateTabelBarang();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tambah  Data GAGAL! " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Stok barang tidak cukup ");
        }
    }//GEN-LAST:event_BtnBeliActionPerformed

    private void TblDaftarTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDaftarTransaksiMouseClicked
        // TODO add your handling code here:
        TblDaftarTransaksi.setEnabled(false);
        int baris = TblDaftarTransaksi.rowAtPoint(evt.getPoint());

        String idTransaksi = TblDaftarTransaksi.getValueAt(baris, 0).toString();
        TxtIdTransaksi.setText(idTransaksi);

        String idCustomer = TblDaftarTransaksi.getValueAt(baris, 1).toString();
        TxtIdCustomer.setText(idCustomer);

        String namaBarang = TblDaftarTransaksi.getValueAt(baris, 2).toString();
        TxtNamaBarang.setText(namaBarang);

        String Harga = TblDaftarTransaksi.getValueAt(baris, 3).toString();
        TxtHarga.setText(Harga);

        String jumlah = TblDaftarTransaksi.getValueAt(baris, 4).toString();
        TxtJumlah.setText(jumlah);

        String TotalHarga = TblDaftarTransaksi.getValueAt(baris, 6).toString();
        TxtTotalHarga.setText(TotalHarga);

        String tanggal = TblDaftarTransaksi.getValueAt(baris, 5).toString();
        LblTanggalTransaksi.setText("Tanggal Transaksi : " + tanggal);
        TblDaftarTransaksi.setEnabled(true);
    }//GEN-LAST:event_TblDaftarTransaksiMouseClicked

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

    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void TxtCariDataBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariDataBarangKeyPressed
        // Fungsi Search tabel barang
        String barang = TxtCariDataBarang.getText();

        if (barang != "") {
            searchBarang(barang);
        } else {
            updateTabelBarang();
        }
    }//GEN-LAST:event_TxtCariDataBarangKeyPressed

    private void TxtCariTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariTransaksiKeyPressed
        // TODO add your handling code here:
        String transaksi = TxtCariTransaksi.getText();

        if (transaksi != "") {
            searchTransaksi(transaksi);
        } else {
            updateTabelTransaksi();
        }
    }//GEN-LAST:event_TxtCariTransaksiKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBeli;
    private javax.swing.JButton BtnCariBarang;
    private javax.swing.JButton BtnCariTransaksi;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JLabel LblCustomer;
    private javax.swing.JLabel LblHarga;
    private javax.swing.JLabel LblIdTransaksi;
    private javax.swing.JLabel LblJumlah;
    private javax.swing.JLabel LblNamaBarang;
    private javax.swing.JLabel LblTanggalTransaksi;
    private javax.swing.JLabel LblTotalHarga;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JTable TblDaftarBarang;
    private javax.swing.JTable TblDaftarTransaksi;
    private javax.swing.JTextField TxtCariDataBarang;
    private javax.swing.JTextField TxtCariTransaksi;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtIdCustomer;
    private javax.swing.JTextField TxtIdTransaksi;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JTextField TxtTotalHarga;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
