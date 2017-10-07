
package Implement;

import Entity.EntityProduk;
import Interface.InterfaceProduk;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplementProduk implements InterfaceProduk {
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsProduk, rsKode, rsCekStock, rsCek;
    private List<EntityProduk> listProduk, listCekStock, listHasil;
    
    public ImplementProduk(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    
    @Override
    public boolean insertProduk(EntityProduk p) {
        status = false;
        query = "INSERT INTO produk VALUES ('"+p.getKode_produk()+"','"+p.getNama_produk()+"','"+p.getHarga_beli_satuan()+"','"+p.getHarga_jual_sp()+"','"+p.getHarga_jual_hawker()+"','"+p.getStock()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updateProduk(EntityProduk p) {
        status = false;
        query = "UPDATE produk SET nama_produk='"+p.getNama_produk()+"', harga_beli_satuan='"+p.getHarga_beli_satuan()+"', harga_jual_sp='"+p.getHarga_jual_sp()+"', harga_jual_hawker='"+p.getHarga_jual_hawker()+"', stock='"+p.getStock()+"' WHERE kode_produk='"+p.getKode_produk()+"' ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean deleteProduk(String kode) {
        status = false;
        query = "DELETE FROM produk WHERE kode_produk = '"+kode+"' ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selectProduk(String kode, String nama) {
        query = "SELECT * FROM produk WHERE kode_produk like '%"+kode+"%' or nama_produk like '%"+nama+"%' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsProduk = koneksi.getRs();
            listProduk = new ArrayList<EntityProduk>();
            try {
                while(rsProduk.next()){
                    EntityProduk p = new EntityProduk();
                    p.setKode_produk(rsProduk.getString(1));
                    p.setNama_produk(rsProduk.getString(2));
                    p.setHarga_beli_satuan(rsProduk.getInt(3));
                    p.setHarga_jual_sp(rsProduk.getInt(4));
                    p.setHarga_jual_hawker(rsProduk.getInt(5));
                    p.setStock(rsProduk.getInt(6));
                    listProduk.add(p);
                }
                rsProduk.close();
                return listProduk;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String kodeBaru() {
        String kode = "";
        int angka = 0;
        query = "SELECT MAX(RIGHT(kode_produk,4)) as kode FROM produk";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
           rsKode = koneksi.getRs();
            try {
                rsKode.next();
                angka = rsKode.getInt(1);
                if(angka<10){
                    kode = "CREAM-000" + (angka+1);
                }else if(angka<100){
                    kode = "CREAM-00" + (angka+1);
                }else if(angka<1000){
                    kode = "CREAM-0" + (angka+1);
                }else{
                    kode = "CREAM-"+(angka+1);
                }
            } catch (Exception e) {
                return null;
            }
        }
        
        return kode;
    }

    @Override
    public List cekStockProduk() {
        query = "SELECT * FROM produk WHERE stock < 10 ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsCekStock = koneksi.getRs();
            listCekStock = new ArrayList<EntityProduk>();
            try {
                while (rsCekStock.next()) {                    
                    EntityProduk p = new EntityProduk();
                    p.setNama_produk(rsProduk.getString(2));
                    listCekStock.add(p);
                }
                rsCekStock.close();
                return listCekStock;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
    
    
    public static void main(String[] args) {
       ImplementProduk p = new ImplementProduk();
        ResultSet rscek = p.cekStock();
        try {
            while (rscek.next()) {                
                System.out.println(rscek.getString(2));
            }
        } catch (Exception e) {
        }
    }

    @Override
    public ResultSet cekStock() {
        query = "SELECT * FROM produk WHERE stock < 10 ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsCekStock = koneksi.getRs();
        }
        return rsCekStock;
    }
}
