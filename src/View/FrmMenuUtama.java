/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Koneksi.KoneksiDB;
import Until.Auth;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Junz
 */
public class FrmMenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuUtama
     */
    public FrmMenuUtama() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        lblNama1.setText(Auth.getNama());
        lbljabatan.setText(Auth.getJabatan());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        lbljabatan = new javax.swing.JLabel();
        lblNama1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHawker = new javax.swing.JLabel();
        lblProduk = new javax.swing.JLabel();
        lblPnjlAmbil = new javax.swing.JLabel();
        lblPenjSetor = new javax.swing.JLabel();
        btnLogut = new javax.swing.JButton();
        DpMenu = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jPegawai = new javax.swing.JMenuItem();
        jHawker = new javax.swing.JMenuItem();
        jProduk = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPembelian = new javax.swing.JMenuItem();
        jPenjualan = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbljabatan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbljabatan.setForeground(new java.awt.Color(255, 255, 255));
        lbljabatan.setText("jabatan");
        getContentPane().add(lbljabatan);
        lbljabatan.setBounds(90, 160, 60, 20);

        lblNama1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblNama1.setForeground(new java.awt.Color(255, 255, 255));
        lblNama1.setText("Nama");
        getContentPane().add(lblNama1);
        lblNama1.setBounds(90, 140, 60, 20);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hi,");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 110, 50, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 110, 80, 71);

        lblHawker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnhawker.png"))); // NOI18N
        lblHawker.setToolTipText("Hawker");
        lblHawker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHawker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHawkerMouseClicked(evt);
            }
        });
        getContentPane().add(lblHawker);
        lblHawker.setBounds(10, 240, 180, 80);

        lblProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnproduk.png"))); // NOI18N
        lblProduk.setToolTipText("Produk");
        lblProduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblProdukMouseClicked(evt);
            }
        });
        getContentPane().add(lblProduk);
        lblProduk.setBounds(10, 310, 180, 70);

        lblPnjlAmbil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btntrans.png"))); // NOI18N
        lblPnjlAmbil.setToolTipText("Ambil Barang");
        lblPnjlAmbil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPnjlAmbil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPnjlAmbilMouseClicked(evt);
            }
        });
        getContentPane().add(lblPnjlAmbil);
        lblPnjlAmbil.setBounds(10, 380, 180, 70);

        lblPenjSetor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnpenjualan.png"))); // NOI18N
        lblPenjSetor.setToolTipText("Setor Barang");
        lblPenjSetor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPenjSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPenjSetorMouseClicked(evt);
            }
        });
        getContentPane().add(lblPenjSetor);
        lblPenjSetor.setBounds(10, 450, 180, 70);

        btnLogut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1300682129_stock_exit.png"))); // NOI18N
        btnLogut.setText("Log Out");
        btnLogut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogut);
        btnLogut.setBounds(10, 620, 170, 40);

        javax.swing.GroupLayout DpMenuLayout = new javax.swing.GroupLayout(DpMenu);
        DpMenu.setLayout(DpMenuLayout);
        DpMenuLayout.setHorizontalGroup(
            DpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1170, Short.MAX_VALUE)
        );
        DpMenuLayout.setVerticalGroup(
            DpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(DpMenu);
        DpMenu.setBounds(190, 80, 1170, 650);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 760);

        jMenu1.setText("File");

        jMenuItem9.setText("Ganti Password");
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator2);

        jMenuItem10.setText("Log out");
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Master Data");

        jPegawai.setText("Pegawai");
        jPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPegawaiActionPerformed(evt);
            }
        });
        jMenu2.add(jPegawai);

        jHawker.setText("Hawker");
        jHawker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHawkerActionPerformed(evt);
            }
        });
        jMenu2.add(jHawker);

        jProduk.setText("Produk");
        jProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProdukActionPerformed(evt);
            }
        });
        jMenu2.add(jProduk);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Transaksi");

        jPembelian.setText("Pembelian");
        jPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPembelianActionPerformed(evt);
            }
        });
        jMenu6.add(jPembelian);

        jPenjualan.setText("Penjualan");
        jPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPenjualanActionPerformed(evt);
            }
        });
        jMenu6.add(jPenjualan);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Laporan");

        jMenuItem13.setText("Laporan Produk");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem11.setText("Laporan Penjualan");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem12.setText("Laporan Pembelian");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("About");

        jMenuItem8.setText("SiWalls");
        jMenu8.add(jMenuItem8);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPegawaiActionPerformed
        FrmPegawai peg = new FrmPegawai();
        DpMenu.add(peg);
        peg.setVisible(true);
    }//GEN-LAST:event_jPegawaiActionPerformed

    private void lblHawkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHawkerMouseClicked
        // TODO add your handling code here:
        FrmHawker hawker = new FrmHawker();
        DpMenu.add(hawker);
        hawker.setVisible(true);
    }//GEN-LAST:event_lblHawkerMouseClicked

    private void lblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblProdukMouseClicked
        // TODO add your handling code here:
        FrmProduk produk = new FrmProduk();
        DpMenu.add(produk);
        produk.setVisible(true);
    }//GEN-LAST:event_lblProdukMouseClicked

    private void lblPnjlAmbilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPnjlAmbilMouseClicked
        // TODO add your handling code here:
        FrmAmbliPenjualan ambil = new FrmAmbliPenjualan();
        DpMenu.add(ambil);
        ambil.setVisible(true);
    }//GEN-LAST:event_lblPnjlAmbilMouseClicked

    private void btnLogutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogutActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnLogutActionPerformed

    private void jPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPembelianActionPerformed
        // TODO add your handling code here:
        FrmTampilPembelian tampilbeli = new FrmTampilPembelian();
        DpMenu.add(tampilbeli);
        tampilbeli.setVisible(true);
    }//GEN-LAST:event_jPembelianActionPerformed

    private void jPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPenjualanActionPerformed
        // TODO add your handling code here:
        FrmTampilPenjualan penju = new FrmTampilPenjualan();
        DpMenu.add(penju);
        penju.setVisible(true);
    }//GEN-LAST:event_jPenjualanActionPerformed

    private void jHawkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHawkerActionPerformed
        // TODO add your handling code here:
        FrmHawker hawker = new FrmHawker();
        DpMenu.add(hawker);
        hawker.setVisible(true);
    }//GEN-LAST:event_jHawkerActionPerformed

    private void jProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProdukActionPerformed
        // TODO add your handling code here:
        FrmProduk produk = new FrmProduk();
        DpMenu.add(produk);
        produk.setVisible(true);
    }//GEN-LAST:event_jProdukActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        try {
            KoneksiDB koneksi = new KoneksiDB();
            koneksi.getKoneksi();
            try {
               Map<String, Object> parameter = new HashMap<String, Object>();
                File rpt = new File("src/Report/laporanProduk.jrxml");
                JasperDesign jasDesign = JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
                JasperPrint jasPrint = JasperFillManager.fillReport(jasReport, parameter, koneksi.getKoneksi());
                JasperViewer.viewReport(jasPrint,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
         try {
            KoneksiDB koneksi = new KoneksiDB();
            koneksi.getKoneksi();
            try {
               Map<String, Object> parameter = new HashMap<String, Object>();
                File rpt = new File("src/Report/LaporanPenjualan.jrxml");
                JasperDesign jasDesign = JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
                JasperPrint jasPrint = JasperFillManager.fillReport(jasReport, parameter, koneksi.getKoneksi());
                JasperViewer.viewReport(jasPrint,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        try {
            KoneksiDB koneksi = new KoneksiDB();
            koneksi.getKoneksi();
            try {
               Map<String, Object> parameter = new HashMap<String, Object>();
                File rpt = new File("src/Report/LaporanPembelian.jrxml");
                JasperDesign jasDesign = JRXmlLoader.load(rpt);
                parameter.clear();
                JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
                JasperPrint jasPrint = JasperFillManager.fillReport(jasReport, parameter, koneksi.getKoneksi());
                JasperViewer.viewReport(jasPrint,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Laporan Tidak Ditemukan " + e);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void lblPenjSetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPenjSetorMouseClicked
        // TODO add your handling code here:
        FrmTampilPenjualan setor = new FrmTampilPenjualan();
        DpMenu.add(setor);
        setor.setVisible(true);
    }//GEN-LAST:event_lblPenjSetorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DpMenu;
    private javax.swing.JButton btnLogut;
    private javax.swing.JMenuItem jHawker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jPegawai;
    private javax.swing.JMenuItem jPembelian;
    private javax.swing.JMenuItem jPenjualan;
    private javax.swing.JMenuItem jProduk;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblHawker;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblPenjSetor;
    private javax.swing.JLabel lblPnjlAmbil;
    private javax.swing.JLabel lblProduk;
    private javax.swing.JLabel lbljabatan;
    // End of variables declaration//GEN-END:variables
}
