/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class frmSupplier extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmSupplier
     */
    public frmSupplier() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        LblKodeSupplier = new javax.swing.JLabel();
        PnlFormSupplier = new javax.swing.JPanel();
        LblFormSupplier = new javax.swing.JLabel();
        LblNamaSupplier = new javax.swing.JLabel();
        LblAlamat = new javax.swing.JLabel();
        LblNoTelp = new javax.swing.JLabel();
        LblEmail = new javax.swing.JLabel();
        TxtKodeSupplier = new javax.swing.JTextField();
        TxtNamaSupplier = new javax.swing.JTextField();
        TxtAlamat = new javax.swing.JTextField();
        TxtNoTelp = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDaftarSupplier = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BtnTambah = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnClear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BtnCari = new javax.swing.JButton();

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

        LblKodeSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblKodeSupplier.setText("Kode Supplier");

        PnlFormSupplier.setBackground(new java.awt.Color(204, 204, 204));

        LblFormSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        LblFormSupplier.setText("FORM SUPPLIER");

        javax.swing.GroupLayout PnlFormSupplierLayout = new javax.swing.GroupLayout(PnlFormSupplier);
        PnlFormSupplier.setLayout(PnlFormSupplierLayout);
        PnlFormSupplierLayout.setHorizontalGroup(
            PnlFormSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlFormSupplierLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblFormSupplier)
                .addGap(294, 294, 294))
        );
        PnlFormSupplierLayout.setVerticalGroup(
            PnlFormSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFormSupplierLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LblFormSupplier)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        LblNamaSupplier.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNamaSupplier.setText("Nama Supplier");

        LblAlamat.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblAlamat.setText("Alamat");

        LblNoTelp.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblNoTelp.setText("No. Telp");

        LblEmail.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        LblEmail.setText("Email");

        TableDaftarSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Supplier", "Nama Supplier", "Alamat", "No Telepon", "Email"
            }
        ));
        jScrollPane2.setViewportView(TableDaftarSupplier);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trajan Pro", 0, 18))); // NOI18N

        BtnTambah.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnTambah.setText("Tambah");

        BtnEdit.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnEdit.setText("Edit");

        BtnHapus.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnHapus.setText("Hapus");

        BtnClear.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnClear.setText("Clear");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnHapus)
                    .addComponent(BtnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Trajan Pro", 0, 18)); // NOI18N
        jLabel9.setText("Daftar Supplier");

        jButton1.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        jButton1.setText("Tutup");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnCari.setFont(new java.awt.Font("Trajan Pro", 0, 16)); // NOI18N
        BtnCari.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlFormSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblKodeSupplier)
                    .addComponent(LblNamaSupplier)
                    .addComponent(LblAlamat)
                    .addComponent(LblNoTelp)
                    .addComponent(LblEmail))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCari)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtNamaSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(TxtAlamat)
                            .addComponent(TxtNoTelp)
                            .addComponent(TxtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlFormSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblKodeSupplier)
                            .addComponent(TxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCari))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblNamaSupplier)
                            .addComponent(TxtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblAlamat)
                            .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblNoTelp)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblEmail)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(37, 37, 37)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCari;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JLabel LblAlamat;
    private javax.swing.JLabel LblEmail;
    private javax.swing.JLabel LblFormSupplier;
    private javax.swing.JLabel LblKodeSupplier;
    private javax.swing.JLabel LblNamaSupplier;
    private javax.swing.JLabel LblNoTelp;
    private javax.swing.JPanel PnlFormSupplier;
    private javax.swing.JTable TableDaftarSupplier;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtKodeSupplier;
    private javax.swing.JTextField TxtNamaSupplier;
    private javax.swing.JTextField TxtNoTelp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
