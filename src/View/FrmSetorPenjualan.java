
package View;

import Entity.EntityHawker;
import Entity.EntityPenjualan;
import Entity.EntityTransaksi;
import Interface.InterfaceHawker;
import Interface.InterfacePenjualan;
import Interface.InterfaceTransaksi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrmSetorPenjualan extends javax.swing.JInternalFrame {

    private String[] tabelHeader, tabelHeaderHawker;
    private DefaultTableModel dtmTransaksi, dtmHawker;
    private InterfaceHawker hawkerDAO;
    private InterfacePenjualan penjualanDAO;
    private InterfaceTransaksi transaksiDAO;
    private List<EntityHawker> listHawker;
    private List<EntityTransaksi> listDetailTrans;
    private int total_setor;
    private int total_omset, bonus;
    
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
       txtKodeHawker.setEditable(false);
       txtNamaHawker.setEditable(false);
       txtKodeProduk.setEditable(false);
       txtNamaProduk.setEditable(false);
       txtHargaJual.setEditable(false);
       txtbawa.setEditable(false);
       txtSisa.setEditable(false);
       txtLaku.setEditable(false);
       txtTotal.setEditable(false);
   }
   
    private void teksKosong(){
       txtKodeTransaksi.setText("");
       txtKodePenjualan.setText("");
       txtKodeHawker.setText("");
       txtNamaHawker.setText("");
       txtKodeProduk.setText("");
       txtNamaProduk.setText("");
       txtHargaJual.setText("");
       txtbawa.setText("");
       txtSisa.setText("");
       txtLaku.setText("");
       txtTotal.setText("");
       txtHargaSP.setText("");
   }
    
    private void aturTable(){
       tabelHeader = new String[]{"Kode Produk","Bawa", "Sisa", "Laku","SETOR HAWKER","OMSET HAWKER","Total"};
       dtmTransaksi = new DefaultTableModel(null, tabelHeader);
       tabelTransaksi.setModel(dtmTransaksi);
       tabelTransaksi.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
               int baris;
               baris = tabelTransaksi.getSelectedRow();
               if(baris>=0){
                   txtKodeProduk.setText(dtmTransaksi.getValueAt(baris, 0).toString());
                   txtbawa.setText(dtmTransaksi.getValueAt(baris, 1).toString());
                   txtSisa.setText(dtmTransaksi.getValueAt(baris, 2).toString());
                   txtLaku.setText(dtmTransaksi.getValueAt(baris, 3).toString());
                   txtNamaProduk.setText(penjualanDAO.namaProduk(txtKodeProduk.getText()));
                   txtHargaSP.setText(penjualanDAO.harga_sp(txtKodeProduk.getText()));
                   txtHargaJual.setText(penjualanDAO.harga_jual(txtKodeProduk.getText()));
               }
           }
       });
       
   }
    
     private void refreshIsitabelHawker(){
       listHawker = hawkerDAO.selectHawker(txtCariHawker.getText(), txtCariHawker.getText());
       dtmHawker = (DefaultTableModel) tabelCariHawker.getModel();
       dtmHawker.setRowCount(0);
       for(EntityHawker data : listHawker){
           dtmHawker.addRow(new Object[]{data.getKode_hawker(),data.getNama()});
       }
   }
     
     private void refreshIsitabelTransaksi(){
         listDetailTrans = penjualanDAO.selectDetailTransaksiHawker(txtKodeTransaksi.getText());
         dtmTransaksi = (DefaultTableModel) tabelTransaksi.getModel();
         dtmTransaksi.setRowCount(0);
         for(EntityTransaksi data : listDetailTrans){
             dtmTransaksi.addRow(new Object[]{data.getKode_produk(),data.getBawa(),data.getSisa(),data.getLaku(),0,0,0});
         }
     }

    public FrmSetorPenjualan() {
        initComponents();
        penjualanDAO = Factory.Factory.getPenjualanDAO();
        transaksiDAO = Factory.Factory.getTransaksiDAO();
        aturTable();
        aturButton(true);
        btnAdd.requestFocus();
        aturTeks();
        
        hawkerDAO = Factory.Factory.getHawkerDAO();
        tabelHeaderHawker = new String[]{"Kode Hawker", "Nama"};
        dtmHawker = new DefaultTableModel(null, tabelHeaderHawker);
        tabelCariHawker.setModel(dtmHawker);
        refreshIsitabelHawker();
        btnCariHawker.setEnabled(false);
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
        jLabel10 = new javax.swing.JLabel();
        txtKodeHawker = new javax.swing.JTextField();
        btnCariHawker = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNamaHawker = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtKodePenjualan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelOmset = new javax.swing.JLabel();
        labelBonus = new javax.swing.JLabel();
        labelSetor = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKodeProduk = new javax.swing.JTextField();
        txtHargaJual = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtbawa = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtSisa = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtLaku = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNamaProduk = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtHargaSP = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

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
        jLabel1.setText("DATA SETOR BARANG");

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

        jLabel10.setText("Kode Hawker");

        btnCariHawker.setText("jButton1");
        btnCariHawker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariHawkerActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Hawker");

        jLabel15.setText("Kode Penjualan");

        jLabel16.setText("Kode Transaksi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtKodeHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCariHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNamaHawker, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtKodeHawker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCariHawker))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNamaHawker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelTransaksi);

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

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Total Omset Hawker : Rp.  ");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Total Setor Hawker  : Rp.");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Bonus Hawker           : Rp. ");

        labelOmset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelOmset.setText("0");

        labelBonus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelBonus.setText("0");

        labelSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelSetor.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(labelOmset, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelBonus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(labelOmset)
                    .addComponent(labelSetor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(labelBonus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Es yang Dijual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 48, 67))); // NOI18N

        jLabel5.setText("Produk");

        jLabel6.setText("Harga Jual");

        jLabel20.setText("Bawa");

        jLabel21.setText("Sisa");

        txtSisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSisaKeyTyped(evt);
            }
        });

        jLabel22.setText("Laku");

        jLabel23.setText("Total Rp.");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKodeProduk)
                                    .addComponent(txtHargaSP)
                                    .addComponent(txtHargaJual))
                                .addGap(63, 63, 63))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbawa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLaku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSisa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtbawa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtSisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHargaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtLaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(btnInsert)
                        .addComponent(btnRemove)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariHawkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariHawkerActionPerformed
        dialogCariHawker.setVisible(true);
    }//GEN-LAST:event_btnCariHawkerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtKodePenjualan.setText(penjualanDAO.kodeBaru(tanggal(), kodeDepan()));
        aturButton(false);
        btnCariHawker.setEnabled(true);
        txtbawa.setEditable(true);
        txtSisa.setEditable(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        EntityPenjualan p = new EntityPenjualan();
        EntityTransaksi t = new EntityTransaksi();

        p.setKode_penjualan(txtKodePenjualan.getText());
        p.setKode_hawker(txtKodeHawker.getText());
        p.setTanggal(tanggal());
        p.setSetor_hawker(total_setor);
        p.setOmset_hawker(total_omset);
        p.setTotal_jual(total_setor+total_omset);
        p.setBonus_hawker(bonus);
        penjualanDAO.insertPenjualan(p);

        int baris = tabelTransaksi.getRowCount();
        for(int i=0; i<baris;i++){
            p.setKode_produk(dtmTransaksi.getValueAt(i, 0).toString());
            t.setKode_produk(dtmTransaksi.getValueAt(i, 0).toString());
            p.setQty(Integer.parseInt(dtmTransaksi.getValueAt(i,3).toString()));
            t.setLaku(Integer.parseInt(dtmTransaksi.getValueAt(i,3).toString()));
            p.setTotal_jual(Integer.parseInt(dtmTransaksi.getValueAt(i, 6).toString()));
            t.setBawa(Integer.parseInt(dtmTransaksi.getValueAt(i, 1).toString()));
            t.setSisa(Integer.parseInt(dtmTransaksi.getValueAt(i,2).toString()));
            t.setKode_transaksi(txtKodeTransaksi.getText());
            penjualanDAO.insertDetailPenjualan(p);
            boolean cek = transaksiDAO.updateDetailTransaksi(t);
            System.out.println(cek);
        }
        aturButton(true);
        teksKosong();
        aturTable();
        labelSetor.setText("");
        labelOmset.setText("");
        labelBonus.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        if(btnExit.getText().equals("Exit")){

            this.dispose();
        }else{
            aturButton(true);
            teksKosong();
            txtKodeProduk.setText("");
            txtNamaProduk.setText("");
            txtHargaJual.setText("");
            txtbawa.setText("");
            txtSisa.setText("");
            txtLaku.setText("");
            txtTotal.setText("");
            aturTable();
        }

    }//GEN-LAST:event_btnExitActionPerformed

    private void txtSisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSisaKeyPressed
        if(txtSisa.getText().equalsIgnoreCase("")){
            txtLaku.setText("");
            txtTotal.setText("");
        }else{
            int bawa = Integer.parseInt(txtbawa.getText());
            int sisa = Integer.parseInt(txtSisa.getText());
            int laku = bawa - sisa;
            txtLaku.setText(String.valueOf(laku));
            int harga = Integer.parseInt(txtHargaJual.getText());
            int total = laku * harga;
            txtTotal.setText(String.valueOf(total));
        }

        if(evt.getKeyCode()==evt.VK_ENTER){
            int bawa = Integer.parseInt(txtbawa.getText());
            int sisa = Integer.parseInt(txtSisa.getText());
            int laku = bawa - sisa;
            txtLaku.setText(String.valueOf(laku));
            int harga = Integer.parseInt(txtHargaJual.getText());
            int total = laku * harga;
            txtTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_txtSisaKeyPressed

    private void txtSisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSisaKeyReleased
        if(txtSisa.getText().equalsIgnoreCase("")){
            txtLaku.setText("");
            txtTotal.setText("");
        }else{
            int bawa = Integer.parseInt(txtbawa.getText());
            int sisa = Integer.parseInt(txtSisa.getText());
            int laku = bawa - sisa;
            txtLaku.setText(String.valueOf(laku));
            int harga = Integer.parseInt(txtHargaJual.getText());
            int total = laku * harga;
            txtTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_txtSisaKeyReleased

    private void txtSisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSisaKeyTyped
        if(txtSisa.getText().equalsIgnoreCase("")){
            txtLaku.setText("");
            txtTotal.setText("");
        }else{
            int bawa = Integer.parseInt(txtbawa.getText());
            int sisa = Integer.parseInt(txtSisa.getText());
            int laku = bawa - sisa;
            txtLaku.setText(String.valueOf(laku));
            int harga = Integer.parseInt(txtHargaJual.getText());
            int total = laku * harga;
            txtTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_txtSisaKeyTyped

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(tabelTransaksi.getSelectedRow()>=0){
            dtmTransaksi.removeRow(tabelTransaksi.getSelectedRow());
            int total = Integer.parseInt(txtHargaJual.getText()) * Integer.parseInt(txtLaku.getText());
            int omset_hawker = (Integer.parseInt(txtHargaJual.getText()) - Integer.parseInt(txtHargaSP.getText())) * Integer.parseInt(txtLaku.getText());
            int setor_hawker = Integer.parseInt(txtHargaSP.getText()) * Integer.parseInt(txtLaku.getText());

            dtmTransaksi.addRow(new Object[]{txtKodeProduk.getText(),txtbawa.getText(),txtSisa.getText(),txtLaku.getText(),omset_hawker,setor_hawker,total});

        }
        int baris = tabelTransaksi.getRowCount();
        total_setor = 0;
        total_omset = 0;
        for (int i = 0; i < baris; i++) {
            total_setor = total_setor + Integer.parseInt(dtmTransaksi.getValueAt(i, 4).toString());
            total_omset = total_omset + Integer.parseInt(dtmTransaksi.getValueAt(i, 5).toString());
        }
        if (total_setor >= 150000) {
            bonus = 10000;
        } else {
            bonus = 0;
        }
        labelSetor.setText(String.valueOf(total_setor - bonus));
        labelOmset.setText(String.valueOf(total_omset));
        labelBonus.setText(String.valueOf(bonus));
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tabelCariHawkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCariHawkerMouseClicked
        int baris = tabelCariHawker.getSelectedRow();
        txtKodeHawker.setText(dtmHawker.getValueAt(baris, 0).toString());
        txtNamaHawker.setText(dtmHawker.getValueAt(baris, 1).toString());
        dialogCariHawker.setVisible(false);
        txtKodeTransaksi.setText(penjualanDAO.kodeTransaksi(tanggal(), txtKodeHawker.getText()));
        refreshIsitabelTransaksi();
        txtSisa.setEditable(true);
    }//GEN-LAST:event_tabelCariHawkerMouseClicked

    private void tabelCariProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelCariProdukMouseClicked

    }//GEN-LAST:event_tabelCariProdukMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCariHawker;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JDialog dialogCariHawker;
    private javax.swing.JDialog dialogCariProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelBonus;
    private javax.swing.JLabel labelOmset;
    private javax.swing.JLabel labelSetor;
    private javax.swing.JTable tabelCariHawker;
    private javax.swing.JTable tabelCariProduk;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField txtCariHawker;
    private javax.swing.JTextField txtCariProduk;
    private javax.swing.JTextField txtHargaJual;
    private javax.swing.JTextField txtHargaSP;
    private javax.swing.JTextField txtKodeHawker;
    private javax.swing.JTextField txtKodePenjualan;
    private javax.swing.JTextField txtKodeProduk;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtLaku;
    private javax.swing.JTextField txtNamaHawker;
    private javax.swing.JTextField txtNamaProduk;
    private javax.swing.JTextField txtSisa;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtbawa;
    // End of variables declaration//GEN-END:variables
}
