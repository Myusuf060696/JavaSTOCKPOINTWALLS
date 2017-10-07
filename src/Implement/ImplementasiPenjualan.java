
package Implement;

import Entity.EntityPenjualan;
import Entity.EntityTransaksi;
import Interface.InterfacePenjualan;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplementasiPenjualan implements InterfacePenjualan{
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsPenjualan, rsPenjualanFilter, rsDetailPenjualan;
    private ResultSet rsKodeTrans, rsDetailTransHawker, rsNamaProduk, rsHargaSP, rsHargaJual;
    private List<EntityPenjualan> listPenjualan, listDetailPenjualan;
    private List<EntityTransaksi> listDetailTrans;
    
    public ImplementasiPenjualan(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    @Override
    public boolean insertPenjualan(EntityPenjualan p) {
        status = false;
        query = "INSERT INTO `penjualan`  VALUES ('"+p.getKode_penjualan()+"', '"+p.getKode_hawker()+"', '"+p.getSetor_hawker()+"', '"+p.getOmset_hawker()+"','"+p.getBonus_hawker()+"', '"+p.getTotal_jual()+"', '"+p.getTanggal()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean insertDetailPenjualan(EntityPenjualan p) {
        status = false;
        query = "INSERT INTO detail_penjualan VALUES ('"+p.getKode_penjualan()+"', '"+p.getKode_produk()+"', '"+p.getQty()+"','"+p.getTotal_jual()+"') ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public String kodeBaru(String tgl, String kodeDepan) {
        String kode = "";
        int angka  = 0;
        
        query = "SELECT MAX(RIGHT(kode_penjualan,4)) as kode FROM penjualan WHERE tanggal='"+tgl+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsPenjualan = koneksi.getRs();
            try {
                rsPenjualan.next();
                angka = rsPenjualan.getInt(1);
                if(angka<10){
                    kode = "JL"+ kodeDepan + "000" + (angka+1);
                }else if(angka<100){
                    kode = "JL"+kodeDepan + "00" + (angka+1);
                }else if (angka<1000){
                    kode = "JL"+kodeDepan + "0" + (angka+1);
                }else{
                    kode = "JL"+kodeDepan + (angka+1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return kode;
    }
  
//     public static void main(String[] args) {
//        ImplementasiPenjualan pe = new ImplementasiPenjualan();
//        List detail =   pe.selectPenjualanFilter("2017-05-16","2017-05-16");
//        System.out.println(detail);
//    }

    @Override
    public List selectPenjualanFilter(String tanggalAwal, String tanggalAkhir) {
       if(tanggalAwal.equalsIgnoreCase("") || tanggalAkhir.equalsIgnoreCase("")){
           query = "SELECT * FROM `penjualan`";
       }else{
           query = "SELECT * FROM penjualan WHERE tanggal BETWEEN '"+tanggalAwal+"' AND '"+tanggalAkhir+"'  ";
       }
       status = koneksi.eksekusiQuery(query, true);
       if(status){
          rsPenjualanFilter = koneksi.getRs();
          listPenjualan = new ArrayList<EntityPenjualan>();
           try {
               while (rsPenjualanFilter.next()) {                   
                   EntityPenjualan p = new EntityPenjualan();
                   p.setKode_penjualan(rsPenjualanFilter.getString(1));
                   p.setKode_hawker(rsPenjualanFilter.getString(2));
                   p.setSetor_hawker(Integer.parseInt(rsPenjualanFilter.getString(3)));
                   p.setOmset_hawker(Integer.parseInt(rsPenjualanFilter.getString(4)));
                   p.setBonus_hawker(Integer.parseInt(rsPenjualanFilter.getString(5)));
                   p.setTotal_jual(Integer.parseInt(rsPenjualanFilter.getString(6)));
                   p.setTanggal(rsPenjualanFilter.getString(7));
                   listPenjualan.add(p);
               }
               rsPenjualanFilter.close();
               return listPenjualan;
           } catch (Exception e) {
               return null;
           }
       }
       return null;
    }

    @Override
    public List selectDetailPenjualan(String kode) {
        query = "SELECT * FROM detail_penjualan WHERE kode_penjualan = '"+kode+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsDetailPenjualan = koneksi.getRs();
            listDetailPenjualan = new ArrayList<EntityPenjualan>();
            try {
                while(rsDetailPenjualan.next()){
                    EntityPenjualan p = new EntityPenjualan();
                    p.setKode_penjualan(rsDetailPenjualan.getString(1));
                    p.setKode_produk(rsDetailPenjualan.getString(2));
                    p.setQty(Integer.parseInt(rsDetailPenjualan.getString(3)));
                    p.setTotal_jual(Integer.parseInt(rsDetailPenjualan.getString(4)));
                    listDetailPenjualan.add(p);
                }
                rsDetailPenjualan.close();
                return listDetailPenjualan;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean cobaselect(String tanggalAwal, String tanggalAkhir) {
       if(tanggalAwal.equalsIgnoreCase("") || tanggalAkhir.equalsIgnoreCase("")){
           query = "SELECT * FROM `penjualan`";
       }else{
           query = "SELECT * FROM penjualan WHERE tanggal BETWEEN '"+tanggalAwal+"' AND '"+tanggalAkhir+"'  ";
       }
       status = koneksi.eksekusiQuery(query, true);
       return status;
    }

    @Override
    public String kodeTransaksi(String tanggal, String kodehawker) {
        String kode = "";
        
        query = "SELECT * FROM transaksi WHERE kode_hawker='"+kodehawker+"' and tanggal='"+tanggal+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsKodeTrans = koneksi.getRs();
            try {
                rsKodeTrans.next();
                kode = rsKodeTrans.getString(1);
            } catch (Exception e) {
                return null;
            }
        }
        return kode;
    }

    @Override
    public List selectDetailTransaksiHawker(String kodetransaksi) {
        query = "SELECT * FROM detail_transaksi WHERE kode_transaksi = '"+kodetransaksi+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsDetailTransHawker = koneksi.getRs();
            listDetailTrans = new ArrayList<EntityTransaksi>();
            try {
                while(rsDetailTransHawker.next()){
                    EntityTransaksi t = new EntityTransaksi();
                    t.setKode_produk(rsDetailTransHawker.getString(2));
                    t.setBawa(rsDetailTransHawker.getInt(3));
                    t.setSisa(rsDetailTransHawker.getInt(4));
                    t.setLaku(rsDetailTransHawker.getInt(5));
                    listDetailTrans.add(t);
                }
                rsDetailTransHawker.close();
                return listDetailTrans;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String namaProduk(String kode) {
        String nama = "";
        query = "SELECT nama_produk FROM produk WHERE kode_produk = '"+kode+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsNamaProduk = koneksi.getRs();
            try {
                rsNamaProduk.next();
                nama = rsNamaProduk.getString(1);
            } catch (Exception e) {
                return null;
            }
        }
        return nama;
    }

    @Override
    public String harga_sp(String kode) {
        String harga="";
        query = "SELECT harga_jual_sp FROM produk WHERE kode_produk='"+kode+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsHargaSP = koneksi.getRs();
            try {
                rsHargaSP.next();
                harga = rsHargaSP.getString(1);
            } catch (Exception e) {
                return null;
            }
        }
        return harga;
    }

    @Override
    public String harga_jual(String kode) {
       String harga="";
        query = "SELECT harga_jual_hawker FROM produk WHERE kode_produk='"+kode+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsHargaSP = koneksi.getRs();
            try {
                rsHargaSP.next();
                harga = rsHargaSP.getString(1);
            } catch (Exception e) {
                return null;
            }
        }
        return harga;
    }


}
