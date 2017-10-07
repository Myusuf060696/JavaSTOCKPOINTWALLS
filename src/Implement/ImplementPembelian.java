
package Implement;

import Entity.EntityPembelian;
import Interface.InterfacePembelian;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class ImplementPembelian implements InterfacePembelian {
    private KoneksiDB koneksi;
    private String query;
    private boolean status;
    private ResultSet rsPembelian, rsPembelianFilter, rsDetailPembelian;
    private List<EntityPembelian> listPembelian, listDetailPembelian;
    
    
    public ImplementPembelian(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    
    @Override
    public boolean insertPembelian(EntityPembelian p) {
        status = false;
        query = "INSERT INTO pembelian VALUES ('"+p.getKode_pembelian()+"', '"+p.getKode_pegawai()+"','"+p.getTanggal()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean insertDetailPembelian(EntityPembelian p) {
        status = false;
        query = "INSERT INTO detail_pembelian VALUES ('"+p.getKode_pembelian()+"','"+p.getKode_produk()+"','"+p.getQty()+"','"+p.getHarga_satuan()+"','"+p.getTotal()+"') ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public String kodeBaru(String tgl, String kodeDepan) {
        String kode = "";
        int angka  = 0;
        
        query = "SELECT MAX(RIGHT(kode_pembelian,4)) as kode FROM pembelian WHERE tanggal='"+tgl+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsPembelian = koneksi.getRs();
            try {
                rsPembelian.next();
                angka = rsPembelian.getInt(1);
                if(angka<10){
                    kode = "BL"+ kodeDepan + "000" + (angka+1);
                }else if(angka<100){
                    kode = "BL"+kodeDepan + "00" + (angka+1);
                }else if (angka<1000){
                    kode = "BL"+kodeDepan + "0" + (angka+1);
                }else{
                    kode = "BL"+kodeDepan + (angka+1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return kode;
    }
    
//    private String tanggal(){
//       DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//       Date d = new Date();
//       return df.format(d);    
//   }
//   
//   private String kodeDepan(){
//       DateFormat df = new SimpleDateFormat("ddMM");
//       Date d = new Date();
//       return df.format(d);
//   }
//   
//    public static void main(String[] args) {
//        ImplementPembelian p = new ImplementPembelian();
//        String kode = p.kodeBaru(p.tanggal(), p.kodeDepan());
//        System.out.println(kode);
//    }
    
    public static void main(String[] args) {
        ImplementPembelian pe = new ImplementPembelian();
        List detail =   pe.selectDetailPembelian("BL11050001");
        System.out.println(detail);
    }

    @Override
    public List selectPembelianFilter(String tanggalAwal, String tanggalAkhir) {
        if(tanggalAwal.equalsIgnoreCase("") || tanggalAkhir.equalsIgnoreCase("")){
            query = "SELECT * FROM pembelian";
        }else{
            query = "SELECT * FROM pembelian WHERE tanggal BETWEEN '"+tanggalAwal+"' AND '"+tanggalAkhir+"' ";            
        }
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsPembelianFilter = koneksi.getRs();
            listPembelian = new ArrayList<EntityPembelian>();
            try {
                while(rsPembelianFilter.next()){
                    EntityPembelian p = new EntityPembelian();
                    p.setKode_pembelian(rsPembelianFilter.getString(1));
                    p.setKode_pegawai(rsPembelianFilter.getString(2));
                    p.setTanggal(rsPembelianFilter.getString(3));
                    listPembelian.add(p);
                }
                rsPembelianFilter.close();
                return listPembelian;
            } catch (Exception e) {
                return null;
            }
            
        }
        return null;
    }

    @Override
    public List selectDetailPembelian(String kode) {
        query = "SELECT * FROM `detail_pembelian` WHERE kode_pembelian = '"+kode+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsDetailPembelian = koneksi.getRs();
            listDetailPembelian = new ArrayList<EntityPembelian>();
            try {
                while (rsDetailPembelian.next()) {                    
                    EntityPembelian p = new EntityPembelian();
                    p.setKode_pembelian(rsDetailPembelian.getString(1));
                    p.setKode_produk(rsDetailPembelian.getString(2));
                    p.setQty(Integer.parseInt(rsDetailPembelian.getString(3)));
                    p.setHarga_satuan(Integer.parseInt(rsDetailPembelian.getString(4)));
                    p.setTotal(Integer.parseInt(rsDetailPembelian.getString(5)));
                    listDetailPembelian.add(p);
                }
                rsDetailPembelian.close();
                return listDetailPembelian;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    
}
