/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class frmBarang extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmBarang
     */
    public frmBarang() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        LblKodeBarang = new javax.swing.JLabel();
        LblNamaBarang = new javax.swing.JLabel();
        LblHarga = new javax.swing.JLabel();
        LblStok = new javax.swing.JLabel();
        TxtKodeBarang = new javax.swing.JTextField();
        PnlFormBarang = new javax.swing.JPanel();
        LblFormBarang = new javax.swing.JLabel();
        TxtNamaBarang = new javax.swing.JTextField();
        TxtHarga = new javax.swing.JTextField();
        BtnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblDaftarBarang = new javax.swing.JTable();
        PnlAksi = new javax.swing.JPanel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BtnCari = new javax.swing.JButton();
        SpinnerStok = new javax.swing.JSpinner();

        jMenuItem1.setText("jMenuItem1");

        LblKodeBarang.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblKodeBarang.setText("Kode Barang");

        LblNamaBarang.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaBarang.setText("Nama Barang");

        LblHarga.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblHarga.setText("HArga");

        LblStok.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblStok.setText("Stok");

        PnlFormBarang.setBackground(new java.awt.Color(204, 204, 204));

        LblFormBarang.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        LblFormBarang.setText("FORM BARANG");

        javax.swing.GroupLayout PnlFormBarangLayout = new javax.swing.GroupLayout(PnlFormBarang);
        PnlFormBarang.setLayout(PnlFormBarangLayout);
        PnlFormBarangLayout.setHorizontalGroup(
            PnlFormBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlFormBarangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblFormBarang)
                .addGap(316, 316, 316))
        );
        PnlFormBarangLayout.setVerticalGroup(
            PnlFormBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormBarangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(LblFormBarang)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        BtnExit.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        BtnExit.setText("Tutup");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        TblDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane1.setViewportView(TblDaftarBarang);

        PnlAksi.setBackground(new java.awt.Color(204, 204, 204));
        PnlAksi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 18))); // NOI18N

        BtnTambah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnTambah.setText("Tambah");

        BtnEdit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnEdit.setText("Edit");

        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");

        BtnClear.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnClear.setText("CLear");

        javax.swing.GroupLayout PnlAksiLayout = new javax.swing.GroupLayout(PnlAksi);
        PnlAksi.setLayout(PnlAksiLayout);
        PnlAksiLayout.setHorizontalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PnlAksiLayout.setVerticalGroup(
            PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAksiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnHapus))
                .addGap(22, 22, 22)
                .addGroup(PnlAksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEdit)
                    .addComponent(BtnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Trajan Pro", 0, 18)); // NOI18N
        jLabel8.setText("DAFTAR BARANG");

        BtnCari.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnCari.setText("Cari ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlFormBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblHarga)
                            .addComponent(LblStok)
                            .addComponent(LblNamaBarang)
                            .addComponent(LblKodeBarang))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                .addComponent(TxtHarga))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(BtnCari))
                            .addComponent(SpinnerStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PnlAksi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnExit, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlFormBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblKodeBarang)
                            .addComponent(TxtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCari))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNamaBarang))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblHarga))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblStok, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SpinnerStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PnlAksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnExit)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BtnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnExit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JLabel LblFormBarang;
    private javax.swing.JLabel LblHarga;
    private javax.swing.JLabel LblKodeBarang;
    private javax.swing.JLabel LblNamaBarang;
    private javax.swing.JLabel LblStok;
    private javax.swing.JPanel PnlAksi;
    private javax.swing.JPanel PnlFormBarang;
    private javax.swing.JSpinner SpinnerStok;
    private javax.swing.JTable TblDaftarBarang;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtKodeBarang;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
