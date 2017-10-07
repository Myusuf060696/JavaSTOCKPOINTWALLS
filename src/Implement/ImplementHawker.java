
package Implement;

import Entity.EntityHawker;
import Interface.InterfaceHawker;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplementHawker implements InterfaceHawker {
    private KoneksiDB koneksi;
    private boolean status;
    private String query;
    private ResultSet rsHawker,rsKode;
    private List<EntityHawker> listHawker;
    
    
    public ImplementHawker(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    
    @Override
    public boolean insertHawker(EntityHawker h) {
        status = false;
        query = "INSERT INTO hawker VALUES('"+h.getKode_hawker()+"','"+h.getNama()+"','"+h.getTelp()+"','"+h.getAlamat()+"','"+h.getTanggal_lahir()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updateHawker(EntityHawker h) {
        status = false;
        query = "UPDATE hawker SET nama='"+h.getNama()+"', telp='"+h.getTelp()+"', alamat='"+h.getAlamat()+"', tanggal_lahir='"+h.getTanggal_lahir()+"' WHERE kode_hawker='"+h.getKode_hawker()+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean deleteHawker(String kode) {
        status = false;
        query = "DELETE FROM hawker WHERE kode_hawker='"+kode+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selectHawker(String kode, String nama) {
        query = "SELECT * FROM hawker WHERE kode_hawker like '%"+kode+"%' or nama like '%"+nama+"%' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsHawker = koneksi.getRs();
            listHawker = new ArrayList<EntityHawker>();
            try {
                while(rsHawker.next()){
                    EntityHawker h = new EntityHawker();
                    h.setKode_hawker(rsHawker.getString(1));
                    h.setNama(rsHawker.getString(2));
                    h.setTelp(rsHawker.getString(3));
                    h.setAlamat(rsHawker.getString(4));
                    h.setTanggal_lahir(rsHawker.getString(5));
                    listHawker.add(h);
                }
                rsHawker.close();
                return listHawker;
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
       query = "SELECT MAX(RIGHT(kode_hawker,3)) as kode FROM hawker";
       status = koneksi.eksekusiQuery(query, true);
       if(status){
           rsKode = koneksi.getRs();
           try {
               rsKode.next();
               angka = rsKode.getInt(1);
               if(angka<10){
                   kode = "HW-00" + (angka+1);
               }else if(angka<100){
                   kode = "HW-0"+(angka+1);
               }else{
                   kode = "HW-" + (angka+1);
               }
           } catch (Exception e) {
               return null;
           }
           
       }
       return kode;
    }
    
}
