
import AppPackage.AnimationClass;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frmMDI extends javax.swing.JFrame {

    Connection con;
    Statement stat;
    String sql, kelas;
    ResultSet rs;
    java.sql.Connection conn;
    PreparedStatement pst;
    String level = "";
    session loginSession = new session();
    String levelLog = loginSession.getLvl();
    String nama = session.getName();
    AnimationClass moveTo = new AnimationClass();

    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();

    public frmMDI() throws Exception {
        super("Aplikasi Toko");
        setSize((int) (0.8 * dimensi.width), (int) (1 * dimensi.height));
        setLocation(dimensi.width / 2 - getWidth() / 2, dimensi.height / 2
                - getHeight() / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost/db_tokoenterprise", "root", "");
        initComponents();
        loginAkses();
        lblAkun.setText("Akun : " + session.getName());
        lblLevel.setText("AKSES : " + session.getLvl());
        lblGreet.setText("Selamat Datang : " + session.getName());
        updateTabelHistory();
        panelTabellHistory.setVisible(false);
        defaultPopVisibility();
    }

    private void loginAkses() {
        if (levelLog.equals("admin")) {
            aksesAdmin();

        } else if (levelLog.equals("user")) {
            aksesUser();
        }
    }

    private void searchMenuHistory(String history) {
        try {
            String sql = "SELECT * from tb_transaksi WHERE nama_user LIKE '%"
                    + nama + "%' OR nama_barang LIKE '%"
                    + history + "%' OR tanggal_transaksi LIKE '%"
                    + history + "%' OR jumlah_barang LIKE '%"
                    + history + "%' OR harga LIKE '%"
                    + history + "%' OR total LIKE '%"
                    + history + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tblHistory.getModel();
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

    public void updateTabelHistory() {

        try {
            String sql = "SELECT * FROM tb_transaksi WHERE nama_user LIKE '%" + nama + "%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel dtm = (DefaultTableModel) tblHistory.getModel();
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

    private void defaultPopVisibility() {
        lblPopBarang.setVisible(false);
        lblPopSupplier.setVisible(false);
        lblPopTransaksi.setVisible(false);

    }

    private void defaultAnimationPos() {
        moveTo.jLabelXLeft(80, 0, 5, 2, txtLblExit);
        moveTo.jLabelXRight(60, 130, 5, 2, txtLblHistory);
        moveTo.jLabelXLeft(80, 0, 5, 2, txtLblLogout);

    }

    private void aksesAdmin() {
        BtnBarang.setVisible(true);
        BtnTransaksi.setVisible(true);
        BtnSupplier.setVisible(true);
    }

    private void aksesUser() {
        BtnBarang.setVisible(false);
        BtnTransaksi.setVisible(true);
        BtnSupplier.setVisible(false);

    }

    private void BtnBarang() {
        panelTabellHistory.setVisible(false);
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

    private void BtnTransaksi() {
        panelTabellHistory.setVisible(false);
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

    private void BtnSupplier() {
        panelTabellHistory.setVisible(false);
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

    private void BtnLogout() {
        try {
            new frmLogin().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(frmMDI.class.getName()).log(Level.SEVERE, null, ex);
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
        panelMDI = new javax.swing.JPanel();
        panelTabellHistory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnHistory = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        upperPanel = new javax.swing.JPanel();
        lblGreet = new javax.swing.JLabel();
        bgUpperPanel = new javax.swing.JLabel();
        panelAksi2 = new javax.swing.JPanel();
        panelHistory = new javax.swing.JPanel();
        txtLblHistory = new javax.swing.JLabel();
        lblBgHistory = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        txtLblLogout = new javax.swing.JLabel();
        lblBgLogout = new javax.swing.JLabel();
        panelExit = new javax.swing.JPanel();
        txtLblExit = new javax.swing.JLabel();
        lblBgExit = new javax.swing.JLabel();
        bgPanelAksi2 = new javax.swing.JLabel();
        PnlAksi = new javax.swing.JPanel();
        lblBarang = new javax.swing.JLabel();
        lblPopBarang = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        lblPopTransaksi = new javax.swing.JLabel();
        BtnTransaksi = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        lblPopSupplier = new javax.swing.JLabel();
        BtnSupplier = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtnBarang = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblAkun = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblBgUser = new javax.swing.JLabel();
        LblAksiPanel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        Aplikasi = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 768));
        setMinimumSize(new java.awt.Dimension(1300, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1300, 768));

        frmMDI.setBackground(new java.awt.Color(255, 255, 255));
        frmMDI.setForeground(new java.awt.Color(204, 204, 204));

        panelMDI.setBackground(new java.awt.Color(102, 153, 255));
        panelMDI.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTabellHistory.setBackground(new java.awt.Color(102, 153, 255));
        panelTabellHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHistory.setMaximumSize(new java.awt.Dimension(525, 112));
        tblHistory.setMinimumSize(new java.awt.Dimension(525, 112));
        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        panelTabellHistory.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 430));

        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        btnHistory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHistoryKeyPressed(evt);
            }
        });
        panelTabellHistory.add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 240, -1));

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/magnifying-glass.png"))); // NOI18N
        panelTabellHistory.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        panelMDI.add(panelTabellHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 490));

        frmMDI.add(panelMDI);
        panelMDI.setBounds(320, 80, 900, 660);

        upperPanel.setBackground(new java.awt.Color(255, 255, 255));
        upperPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGreet.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblGreet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGreet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/arm-up.png"))); // NOI18N
        lblGreet.setText("SELAMAT DATANG null");
        upperPanel.add(lblGreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 970, -1));

        bgUpperPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/Path 3.png"))); // NOI18N
        upperPanel.add(bgUpperPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        frmMDI.add(upperPanel);
        upperPanel.setBounds(0, 0, 1220, 80);

        panelAksi2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelHistoryMouseExited(evt);
            }
        });
        panelHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLblHistory.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtLblHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/history.png"))); // NOI18N
        txtLblHistory.setText("HISTORY");
        panelHistory.add(txtLblHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        lblBgHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPanel.png"))); // NOI18N
        lblBgHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBgHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBgHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBgHistoryMouseExited(evt);
            }
        });
        panelHistory.add(lblBgHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, -1));

        panelAksi2.add(panelHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 320, 100));

        panelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelLogoutMouseExited(evt);
            }
        });
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLblLogout.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtLblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/logout.png"))); // NOI18N
        txtLblLogout.setText("LOGOUT");
        panelLogout.add(txtLblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        lblBgLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPanel-2.png"))); // NOI18N
        panelLogout.add(lblBgLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 340, 140));

        panelAksi2.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 100));

        panelExit.setPreferredSize(new java.awt.Dimension(420, 100));
        panelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelExitMouseExited(evt);
            }
        });
        panelExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLblExit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtLblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/exit-door-sign.png"))); // NOI18N
        txtLblExit.setText("EXIT");
        panelExit.add(txtLblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        lblBgExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPanel-2.png"))); // NOI18N
        lblBgExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBgExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBgExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBgExitMouseExited(evt);
            }
        });
        panelExit.add(lblBgExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, -1));

        panelAksi2.add(panelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 320, -1));

        bgPanelAksi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/Path 1.png"))); // NOI18N
        panelAksi2.add(bgPanelAksi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        frmMDI.add(panelAksi2);
        panelAksi2.setBounds(0, 80, 320, 890);

        PnlAksi.setBackground(new java.awt.Color(84, 127, 206));
        PnlAksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBarang.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblBarang.setForeground(new java.awt.Color(255, 255, 255));
        lblBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/package.png"))); // NOI18N
        lblBarang.setText("BARANG");
        PnlAksi.add(lblBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        lblPopBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPop.png"))); // NOI18N
        PnlAksi.add(lblPopBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 250, 320, -1));

        lblTransaksi.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        lblTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/transaction.png"))); // NOI18N
        lblTransaksi.setText("TRANSAKSI");
        PnlAksi.add(lblTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        lblPopTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPop.png"))); // NOI18N
        PnlAksi.add(lblPopTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 480, 330, -1));

        BtnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/button 1.png"))); // NOI18N
        BtnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTransaksiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnTransaksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnTransaksiMouseExited(evt);
            }
        });
        PnlAksi.add(BtnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 500, 340, -1));

        lblSupplier.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lblSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icons/logistics-package-and-a-man-outlines.png"))); // NOI18N
        lblSupplier.setText("SUPPLIER");
        PnlAksi.add(lblSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        lblPopSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgPop.png"))); // NOI18N
        PnlAksi.add(lblPopSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 340, 320, -1));

        BtnSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/button 1.png"))); // NOI18N
        BtnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSupplierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnSupplierMouseExited(evt);
            }
        });
        PnlAksi.add(BtnSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 360, 340, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MASTER DATA");
        PnlAksi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 169, -1));

        BtnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/button 1.png"))); // NOI18N
        BtnBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBarangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnBarangMouseExited(evt);
            }
        });
        PnlAksi.add(BtnBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 270, 340, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TRANSAKSI");
        PnlAksi.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        panelUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("_______________________");
        panelUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 250, -1));

        lblAkun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAkun.setForeground(new java.awt.Color(255, 255, 255));
        lblAkun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAkun.setText("nama null");
        panelUser.add(lblAkun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, -1));

        lblLevel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel.setText("akses null");
        panelUser.add(lblLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, -1));

        lblBgUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/bgUser.png"))); // NOI18N
        panelUser.add(lblBgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 270, 210));

        PnlAksi.add(panelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 250, 150));

        LblAksiPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UI/Custom Size – 1.png"))); // NOI18N
        LblAksiPanel.setPreferredSize(new java.awt.Dimension(450, 950));
        PnlAksi.add(LblAksiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 730));

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
                .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(frmMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addComponent(PnlAksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBarangMouseClicked
        // Modify Button Barang
        try {

            BtnBarang();
        } catch (Exception e) {
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

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        // Menutup program
        System.exit(0);
    }//GEN-LAST:event_MenuExitActionPerformed

    private void lblBgExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblBgExitMouseClicked

    private void tblHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblHistoryMouseClicked

    private void btnHistoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHistoryKeyPressed
        // TODO add your handling code here:
        String transaksi = btnHistory.getText();
        if (transaksi != "") {
            searchMenuHistory(transaksi);
        } else {
            updateTabelHistory();
        }
    }//GEN-LAST:event_btnHistoryKeyPressed

    private void lblBgHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgHistoryMouseClicked
        // TODO add your handling code here:
        updateTabelHistory();
        panelTabellHistory.setVisible(true);
    }//GEN-LAST:event_lblBgHistoryMouseClicked

    private void panelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseClicked
        // TODO add your handling code here:
        try {
            new frmLogin().setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(frmMDI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_panelLogoutMouseClicked

    private void panelLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseEntered
        // TODO add your handling code here:

        moveTo.jLabelXRight(0, 80, 5, 2, txtLblLogout);
    }//GEN-LAST:event_panelLogoutMouseEntered

    private void panelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseExited
        // TODO add your handling code here:
        defaultAnimationPos();
    }//GEN-LAST:event_panelLogoutMouseExited

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void panelHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHistoryMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_panelHistoryMouseEntered

    private void panelHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHistoryMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_panelHistoryMouseExited

    private void panelHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHistoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelHistoryMouseClicked

    private void lblBgHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgHistoryMouseEntered
        // TODO add your handling code here:
        moveTo.jLabelXLeft(130, 60, 5, 2, txtLblHistory);
    }//GEN-LAST:event_lblBgHistoryMouseEntered

    private void lblBgHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgHistoryMouseExited
        // TODO add your handling code here:
        defaultAnimationPos();
    }//GEN-LAST:event_lblBgHistoryMouseExited

    private void panelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_panelExitMouseEntered

    private void panelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_panelExitMouseExited

    private void lblBgExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgExitMouseEntered
        // TODO add your handling code here:
        moveTo.jLabelXRight(0, 80, 5, 2, txtLblExit);
    }//GEN-LAST:event_lblBgExitMouseEntered

    private void lblBgExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBgExitMouseExited
        // TODO add your handling code here:
        defaultAnimationPos();
    }//GEN-LAST:event_lblBgExitMouseExited

    private void BtnBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBarangMouseEntered
        // TODO add your handling code here:
        lblPopBarang.setVisible(true);
    }//GEN-LAST:event_BtnBarangMouseEntered

    private void BtnBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBarangMouseExited
        // TODO add your handling code here:
        defaultPopVisibility();
    }//GEN-LAST:event_BtnBarangMouseExited

    private void BtnSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupplierMouseEntered
        // TODO add your handling code here:
        lblPopSupplier.setVisible(true);
    }//GEN-LAST:event_BtnSupplierMouseEntered

    private void BtnSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupplierMouseExited
        // TODO add your handling code here:
        defaultPopVisibility();
    }//GEN-LAST:event_BtnSupplierMouseExited

    private void BtnTransaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTransaksiMouseEntered
        // TODO add your handling code here:
        lblPopTransaksi.setVisible(true);

    }//GEN-LAST:event_BtnTransaksiMouseEntered

    private void BtnTransaksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTransaksiMouseExited
        // TODO add your handling code here:
        defaultPopVisibility();
    }//GEN-LAST:event_BtnTransaksiMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Aplikasi;
    private javax.swing.JLabel BtnBarang;
    private javax.swing.JLabel BtnSupplier;
    private javax.swing.JLabel BtnTransaksi;
    private javax.swing.JLabel LblAksiPanel;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JLabel bgPanelAksi2;
    private javax.swing.JLabel bgUpperPanel;
    private javax.swing.JTextField btnHistory;
    private javax.swing.JDesktopPane frmMDI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAkun;
    private javax.swing.JLabel lblBarang;
    private javax.swing.JLabel lblBgExit;
    private javax.swing.JLabel lblBgHistory;
    private javax.swing.JLabel lblBgLogout;
    private javax.swing.JLabel lblBgUser;
    private javax.swing.JLabel lblGreet;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblPopBarang;
    private javax.swing.JLabel lblPopSupplier;
    private javax.swing.JLabel lblPopTransaksi;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panelAksi2;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelHistory;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelMDI;
    private javax.swing.JPanel panelTabellHistory;
    private javax.swing.JPanel panelUser;
    private javax.swing.JTable tblHistory;
    private javax.swing.JLabel txtLblExit;
    private javax.swing.JLabel txtLblHistory;
    private javax.swing.JLabel txtLblLogout;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

}
