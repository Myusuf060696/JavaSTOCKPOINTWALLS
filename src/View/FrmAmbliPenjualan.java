
package View;

import Entity.EntityHawker;
import Entity.EntityProduk;
import Entity.EntityTransaksi;
import Interface.InterfaceHawker;
import Interface.InterfacePenjualan;
import Interface.InterfaceProduk;
import Interface.InterfaceTransaksi;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
public class FrmAmbliPenjualan extends javax.swing.JInternalFrame {

    private String[] tabelHeader, tabelHeaderHawker, tabelHeaderProduk;
    private DefaultTableModel dtmPenjualan, dtmHawker, dtmProduk;
    private InterfaceTransaksi transaksiDAO;
    private InterfaceHawker hawkerDAO;
    private InterfaceProduk produkDAO;
    private InterfacePenjualan penjualanDAO;
    private List<EntityHawker> listHawker;
    private List<EntityProduk> listProduk;
    
    private String tanggal(){
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       Date d = new Date();
       return df.format(d);    
   }
   
   private String kodeDepan(){
       DateFormat df = new SimpleDateFormat("ddMM");
       Date d = new Date();
       return df.format(d);
   }
   
   private void aturButton(boolean status){
       btnAdd.setEnabled(status);
       btnSave.setEnabled(!status);
       if(status==true){
           btnExit.setText("Exit");
       }else{
           btnExit.setText("Cancel");
       }
   }
   
   private void aturTeks(){
       txtKodeTransaksi.setEditable(false);
       txtKodePenjualan.setEditable(false);
       txtTanggal.setEditable(false);
       txtKodeHawker.setEditable(false);
       txtNamaHawker.setEditable(false);
       txtKodeProduk.setEditable(false);
       txtNamaProduk.setEditable(false);
       txtHargaJual.setEditable(false);
       txtbawa.setEditable(false);
   }
   private void teksKosong(){
       txtKodeTransaksi.setText("");
       txtKodePenjualan.setText("");
       txtTanggal.setText("");
       txtKodeHawker.setText("");
       txtNamaHawker.setText("");
       txtKodeProduk.setText("");
       txtNamaProduk.setText("");
       txtHargaJual.setText("");
       txtbawa.setText("");
       txtHargaSP.setText("");
   }
    
   private void aturTable(){
       tabelHeader = new String[]{"Kode Produk", "Nama Produk", "Bawa"};
       dtmPenjualan = new DefaultTableModel(null, tabelHeader);
       tabelJualAmbil.setModel(dtmPenjualan);
   }
   
    private void refreshIsitabelHawker(){
       listHawker = hawkerDAO.selectHawker(txtCariHawker.getText(), txtCariHawker.getText());
       dtmHawker = (DefaultTableModel) tabelCariHawker.getModel();
       dtmHawker.setRowCount(0);
       for(EntityHawker data : listHawker){
           dtmHawker.addRow(new Object[]{data.getKode_hawker(),data.getNama()});
       }
   }
   
   private void refreshIsitabelProduk(){
       listProduk = produkDAO.selectProduk(txtCariProduk.getText(), txtCariProduk.getText());
       dtmProduk = (DefaultTableModel) tabelCariProduk.getModel();
       dtmProduk.setRowCount(0);
       for(EntityProduk data : listProduk){
           dtmProduk.addRow(new Object[]{data.getKode_produk(),data.getNama_produk(),data.getHarga_jual_sp(),data.getHarga_jual_hawker()});
       }  
   }
    
    public FrmAmbliPenjualan() {
        initComponents();
        transaksiDAO = Factory.Factory.getTransaksiDAO();
     penjualanDAO = Factory.Factory.getPenjualanDAO();
     hawkerDAO = Factory.Factory.getHawkerDAO();
     produkDAO = Factory.Factory.getProdukDAO();
     
     aturTable();
     aturButton(true);
     btnAdd.requestFocus();
     aturTeks();
     
     tabelHeaderHawker = new String[]{"Kode Hawker", "Nama"};
     dtmHawker = new DefaultTableModel(null, tabelHeaderHawker);
     tabelCariHawker.setModel(dtmHawker);
     refreshIsitabelHawker();
     
     tabelHeaderProduk = new String[]{"Kode Produk", "Nama", "Harga Jual SP", "Harga Jual HW"};
     dtmProduk = new DefaultTableModel(null, tabelHeaderProduk);
     tabelCariProduk.setModel(dtmProduk);
     refreshIsitabelProduk();
     
     btnCariHawker.setEnabled(false);
     btnCariProduk.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCariHawker = new javax.swing.JDialog();
        txtCariHawker = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelCariHawker = new javax.swing.JTable();
        dialogCariProduk = new javax.swing.JDialog();
        txtCariProduk = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelCariProduk = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        txtKodePenjualan = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtKodeHawker = new javax.swing.JTextField();
        btnCariHawker = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNamaHawker = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKodeProduk = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        btnCariProduk = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNamaProduk = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtHargaSP = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtbawa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelJualAmbil = new javax.swing.JTable();

        dialogCariHawker.setMinimumSize(new java.awt.Dimension(400, 231));

        tabelCariHawker.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCariHawker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCariHawkerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelCariHawker);

        javax.swing.GroupLayout dialogCariHawkerLayout = new javax.swing.GroupLayout(dialogCariHawker.getContentPane());
        dialogCariHawker.getContentPane().setLayout(dialogCariHawkerLayout);
        dialogCariHawkerLayout.setHorizontalGroup(
            dialogCariHawkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCariHawkerLayout.createSequentialGroup()
                .addGroup(dialogCariHawkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogCariHawkerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtCariHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogCariHawkerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        dialogCariHawkerLayout.setVerticalGroup(
            dialogCariHawkerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCariHawkerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCariHawker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        dialogCariProduk.setMinimumSize(new java.awt.Dimension(400, 249));

        tabelCariProduk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelCariProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelCariProdukMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelCariProduk);

        javax.swing.GroupLayout dialogCariProdukLayout = new javax.swing.GroupLayout(dialogCariProduk.getContentPane());
        dialogCariProduk.getContentPane().setLayout(dialogCariProdukLayout);
        dialogCariProdukLayout.setHorizontalGroup(
            dialogCariProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCariProdukLayout.createSequentialGroup()
                .addGroup(dialogCariProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogCariProdukLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogCariProdukLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        dialogCariProdukLayout.setVerticalGroup(
            dialogCariProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCariProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(242, 48, 67));
        jPanel1.setPreferredSize(new java.awt.Dimension(245, 55));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA AMBIL BARANG");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ico_walls.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 48, 67))); // NOI18N

        jLabel2.setText("Kode Transaksi");

        jLabel3.setText("Kode Penjualan");

        jLabel4.setText("Tanggal");

        jLabel10.setText("Kode Hawker");

        btnCariHawker.setText("jButton1");
        btnCariHawker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariHawkerActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Hawker");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(txtKodePenjualan))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtKodeHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(txtNamaHawker))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtKodeHawker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariHawker))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNamaHawker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Es yang Dijual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 48, 67))); // NOI18N

        jLabel5.setText("Produk");

        jLabel6.setText("Harga Jual");

        btnCariProduk.setText("jButton1");
        btnCariProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariProdukActionPerformed(evt);
            }
        });

        jLabel9.setText("Nama Produk");

        jLabel8.setText("Harga SP");

        btnInsert.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsert.setText("v");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnRemove.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemove.setText("ʌ");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel20.setText("Bawa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCariProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHargaSP)
                                    .addComponent(txtHargaJual))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNamaProduk)))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(txtbawa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCariProduk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsert)
                        .addComponent(btnRemove))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtbawa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save_16x16.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        tabelJualAmbil.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelJualAmbil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariHawkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariHawkerActionPerformed
        dialogCariHawker.setVisible(true);
    }//GEN-LAST:event_btnCariHawkerActionPerformed

    private void btnCariProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariProdukActionPerformed
        dialogCariProduk.setVisible(true);
    }//GEN-LAST:event_btnCariProdukActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        dtmPenjualan.addRow(new Object[]{txtKodeProduk.getText(),txtNamaProduk.getText(),txtbawa.getText()});
        txtKodeProduk.setText("");
        txtNamaProduk.setText("");
        txtHargaJual.setText("");
        txtHargaSP.setText("");
        txtbawa.setText("");

    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if(tabelJualAmbil.getSelectedRow()>=0){
            dtmPenjualan.removeRow(tabelJualAmbil.getSelectedRow());
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtKodeTransaksi.setText(transaksiDAO.kodeBaru(tanggal(), kodeDepan()));
        txtTanggal.setText(tanggal());
        txtKodePenjualan.setText(penjualanDAO.kodeBaru(tanggal(), kodeDepan()));
        aturButton(false);
        btnCariHawker.setEnabled(true);
        btnCariProduk.setEnabled(true);
        txtbawa.setEditable(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        EntityTransaksi t = new EntityTransaksi();
        t.setKode_transaksi(txtKodeTransaksi.getText());
        t.setKode_hawker(txtKodeHawker.getText());
        t.setTanggal(txtTanggal.getText());
        transaksiDAO.insertTransaksi(t);

        int baris = tabelJualAmbil.getRowCount();
        for(int i=0; i<baris;i++){
            t.setKode_produk(dtmPenjualan.getValueAt(i, 0).toString());
            t.setBawa(Integer.parseInt(dtmPenjualan.getValueAt(i, 2).toString()));
            t.setSisa(0);
            t.setLaku(0);
            transaksiDAO.insertDetailTransaksi(t);
        }
        aturButton(true);
        teksKosong();
        aturTable();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tabelCariHawkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCariHawkerMouseClicked
        int baris = tabelCariHawker.getSelectedRow();
        txtKodeHawker.setText(dtmHawker.getValueAt(baris, 0).toString());
        txtNamaHawker.setText(dtmHawker.getValueAt(baris, 1).toString());
        dialogCariHawker.setVisible(false);
    }//GEN-LAST:event_tabelCariHawkerMouseClicked

    private void tabelCariProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCariProdukMouseClicked
        int baris = tabelCariProduk.getSelectedRow();
        txtKodeProduk.setText(dtmProduk.getValueAt(baris, 0).toString());
        txtNamaProduk.setText(dtmProduk.getValueAt(baris, 1).toString());
        txtHargaSP.setText(dtmProduk.getValueAt(baris, 2).toString());
        txtHargaJual.setText(dtmProduk.getValueAt(baris, 3).toString());
        dialogCariProduk.setVisible(false);
    }//GEN-LAST:event_tabelCariProdukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCariHawker;
    private javax.swing.JButton btnCariProduk;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JDialog dialogCariHawker;
    private javax.swing.JDialog dialogCariProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelCariHawker;
    private javax.swing.JTable tabelCariProduk;
    private javax.swing.JTable tabelJualAmbil;
    private javax.swing.JTextField txtCariHawker;
    private javax.swing.JTextField txtCariProduk;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtHargaSP;
    private javax.swing.JTextField txtKodeHawker;
    private javax.swing.JTextField txtKodePenjualan;
    private javax.swing.JTextField txtKodeProduk;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtNamaHawker;
    private javax.swing.JTextField txtNamaProduk;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtbawa;
    // End of variables declaration//GEN-END:variables
}
