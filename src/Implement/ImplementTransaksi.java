
package Implement;

import Entity.EntityTransaksi;
import Interface.InterfaceTransaksi;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;


public class ImplementTransaksi implements InterfaceTransaksi{
    private KoneksiDB koneksi;
    private boolean status;
    private String query;
    private ResultSet rsTransaksi;
    
    public ImplementTransaksi(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    
    @Override
    public boolean insertTransaksi(EntityTransaksi t) {
        status = false;
        query = "INSERT INTO transaksi VALUES ('"+t.getKode_transaksi()+"','"+t.getKode_hawker()+"', '"+t.getTanggal()+"') ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean insertDetailTransaksi(EntityTransaksi t) {
        status = false;
        query = "INSERT INTO detail_transaksi VALUES ('"+t.getKode_transaksi()+"', '"+t.getKode_produk()+"', '"+t.getBawa()+"' , '"+t.getSisa()+"' , '"+t.getLaku()+"') ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public String kodeBaru(String tgl, String kodeDepan) {
        String kode = "";
        int angka = 0;
        
        query = "SELECT MAX(RIGHT(kode_transaksi,4)) as kode FROM transaksi WHERE tanggal = '"+tgl+"'";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsTransaksi = koneksi.getRs();
            try {
                rsTransaksi.next();
                angka = rsTransaksi.getInt(1);
                if(angka<10){
                    kode = kodeDepan + "000" + (angka+1);
                }else if(angka<100){
                    kode = kodeDepan + "00" + (angka+1);
                }else if(angka<1000){
                    kode = kodeDepan + "0" + (angka+1);
                }else{
                    kode = kodeDepan + String.valueOf(angka+1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return kode;
    }

    @Override
    public boolean updateDetailTransaksi(EntityTransaksi t) {
        status = false;
        query = "UPDATE detail_transaksi SET sisa='"+t.getSisa()+"', laku='"+t.getLaku()+"' where kode_transaksi='"+t.getKode_transaksi()+"' and kode_produk='"+t.getKode_produk()+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

}
