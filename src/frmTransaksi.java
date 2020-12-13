
import com.mysql.jdbc.Connection;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    String nama_user = "";
    session Session = new session();
    String nama = session.getName();

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
        TxtTotalHarga.setEditable(false);
        getData();
    }

    public void getData() {
        TxtNamaUser.setEditable(false);
        TxtNamaUser.setText(nama);

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

    public void exportToExcel() {
        FileOutputStream excelFOS = null;
        BufferedOutputStream excelBOS = null;
        XSSFWorkbook wb = null;

        JFileChooser excelFileChooser = new JFileChooser();
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "ods");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("Data Sheet");

                for (int i = 0; i < TblDaftarTransaksi.getRowCount(); i++) {
                    XSSFRow excelRow = sheet.createRow(i);
                    for (int j = 0; j < TblDaftarTransaksi.getColumnCount(); j++) {

                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(TblDaftarTransaksi.getValueAt(i, j).toString());

                    }
                }

                excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOS = new BufferedOutputStream(excelFOS);
                wb.write(excelBOS);
                JOptionPane.showMessageDialog(null, "Successfully saved.");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOS != null) {
                        excelBOS.close();
                    }
                    if (excelFOS != null) {
                        excelFOS.close();
                    }
                    if (wb != null) {
                        wb.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } //---- end finally
        }

    }

    public void clear() {
        TxtIdTransaksi.setText("");
        TxtNamaUser.setText("");
        TxtNamaBarang.setText("");
        TxtHarga.setText("");
        TxtJumlah.setText("");
        TxtTotalHarga.setText("");
        LblTanggalTransaksi.setText("");
        getData();
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
            String sql = "SELECT * FROM tb_transaksi WHERE nama_user LIKE '%" + nama + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) TblDaftarTransaksi.getModel();
            dtm.setRowCount(0);
            String[] data = new String[7];
            int i = 1;

            while (rs.next()) {
                data[0] = rs.getString("id_transaksi");
                data[1] = rs.getString("nama_user");
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
                    + transaksi + "%' OR nama_user LIKE '%"
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
                data[1] = rs.getString("nama_user");
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
        TxtNamaUser = new javax.swing.JTextField();
        TxtNamaBarang = new javax.swing.JTextField();
        LblTanggalTransaksi = new javax.swing.JLabel();
        LblIdTransaksi = new javax.swing.JLabel();
        TxtIdTransaksi = new javax.swing.JTextField();
        lblExport = new javax.swing.JLabel();
        BtnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        TxtCariBarang = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblDaftarBarang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDaftarTransaksi = new javax.swing.JTable();
        TxtCariTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        jLabel2.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA TRANSAKSI"));

        LblHarga.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblHarga.setText("Harga");

        LblJumlah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblJumlah.setText("Jumlah");

        LblTotalHarga.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTotalHarga.setText("Total Harga");

        PnlAksi.setBackground(new java.awt.Color(255, 255, 255));
        PnlAksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 16))); // NOI18N
        PnlAksi.setPreferredSize(new java.awt.Dimension(224, 155));

        BtnBeli.setBackground(new java.awt.Color(0, 255, 51));
        BtnBeli.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnBeli.setText("Beli");
        BtnBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBeliActionPerformed(evt);
            }
        });

        BtnHapus.setBackground(new java.awt.Color(255, 102, 102));
        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.setMaximumSize(new java.awt.Dimension(103, 25));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnClear.setBackground(new java.awt.Color(255, 204, 102));
        BtnClear.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnClear.setForeground(new java.awt.Color(51, 51, 51));
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
        LblCustomer.setText("Nama User");

        LblNamaBarang.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaBarang.setText("Nama Barang");

        LblTanggalTransaksi.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblTanggalTransaksi.setText("Tanggal Transaksi :");

        LblIdTransaksi.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblIdTransaksi.setText("ID Transaksi");

        lblExport.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/export.png"))); // NOI18N
        lblExport.setText("EXPORT");
        lblExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExportMouseClicked(evt);
            }
        });

        BtnExit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnExit.setText("Tutup");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LblIdTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtJumlah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(TxtHarga, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TxtNamaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TxtNamaUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                .addGap(48, 48, 48)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(TxtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTotalHarga)
                    .addComponent(TxtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblExport)
                        .addGap(26, 26, 26)
                        .addComponent(BtnExit)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DAFTAR BARANG"));

        TxtCariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCariBarangKeyPressed(evt);
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

        jLabel1.setText("Search");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
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
                "ID Transaksi", "Nama User", "Nama Barang", "Jumlah", "Harga", "Tanggal", "Total Harga"
            }
        ));
        TblDaftarTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblDaftarTransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblDaftarTransaksi);

        TxtCariTransaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCariTransaksiKeyPressed(evt);
            }
        });

        jLabel3.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCariTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(46, 46, 46))
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
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        + "" + TxtNamaUser.getText() + "','"
                        + "" + TxtNamaBarang.getText() + "','"
                        + "" + jumlah + "','"
                        + "" + harga + "','"
                        + "" + tanggal + "','"
                        + "" + totalHarga + "')";

                stat = conn.createStatement();
                int res = stat.executeUpdate(sql);
                if (res == 1) {
                    updateStok();
                    javax.swing.JOptionPane.showMessageDialog(null, "Barang Berhasil Dibeli! !");
                    updateTabelTransaksi();
                    updateTabelBarang();
                    clear();

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

        String NamaUser = TblDaftarTransaksi.getValueAt(baris, 1).toString();
        TxtNamaUser.setText(NamaUser);

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
                JOptionPane.showMessageDialog(null, "Berhasil di hapus");
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

    private void TxtCariBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariBarangKeyPressed
        // TODO add your handling code here:
        String barang = TxtCariBarang.getText();

        if (barang != "") {
            searchBarang(barang);
        } else {
            updateTabelBarang();
        }
    }//GEN-LAST:event_TxtCariBarangKeyPressed

    private void TxtCariTransaksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCariTransaksiKeyPressed
        // TODO add your handling code here:
        String transaksi = TxtCariTransaksi.getText();
        if (transaksi != "") {
            searchTransaksi(transaksi);
        } else {
            updateTabelTransaksi();
        }
    }//GEN-LAST:event_TxtCariTransaksiKeyPressed

    private void lblExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportMouseClicked
        // TODO add your handling code here:
        exportToExcel();
    }//GEN-LAST:event_lblExportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBeli;
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
    private javax.swing.JTextField TxtCariBarang;
    private javax.swing.JTextField TxtCariTransaksi;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtIdTransaksi;
    private javax.swing.JTextField TxtJumlah;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JTextField TxtNamaUser;
    private javax.swing.JTextField TxtTotalHarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblExport;
    // End of variables declaration//GEN-END:variables
}
