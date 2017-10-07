
package Implement;

import Entity.EntityPegawai;
import Interface.InterfacePegawai;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ImplementPegawai implements InterfacePegawai{
    private KoneksiDB koneksi;
    private boolean status;
    private String query;
    private ResultSet resultPegawai, resultKode, rsLogin;
    private List listPegawai;
    private EntityPegawai pegawai;
    
    public ImplementPegawai(){
        koneksi = new KoneksiDB();
        koneksi.getKoneksi();
    }
    
    
    @Override
    public boolean insertPegawai(EntityPegawai p) {
        status = false;
        query = "INSERT INTO pegawai (`kode_pegawai`, `password`, `nama`, `jabatan`, `telp`, `alamat`) VALUES ('"+p.getKode_pegawai()+"', '"+p.getPassword()+"', '"+p.getNama()+"', '"+p.getJabatan()+"', '"+p.getTelp()+"', '"+p.getAlamat()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean updatePegawai(EntityPegawai p) {
        status = false;
        query = "UPDATE pegawai SET password='"+p.getPassword()+"', nama='"+p.getNama()+"', jabatan='"+p.getJabatan()+"', telp='"+p.getTelp()+"', alamat='"+p.getAlamat()+"' WHERE kode_pegawai='"+p.getKode_pegawai()+"'  ";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean deletePegawai(String kode) {
        status = false;
        query = "DELETE FROM pegawai WHERE kode_pegawai='"+kode+"'";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selectPegawai(String kode, String nama) {
        query = "SELECT * FROM pegawai WHERE kode_pegawai like '%"+kode+"%' or nama like '%"+nama+"%' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            resultPegawai = koneksi.getRs();
            listPegawai = new ArrayList<EntityPegawai>();
            try {
                while(resultPegawai.next()){
                    EntityPegawai p = new EntityPegawai();
                    p.setKode_pegawai(resultPegawai.getString(1));
                    p.setPassword(resultPegawai.getString(2));
                    p.setNama(resultPegawai.getString(3));
                    p.setJabatan(resultPegawai.getString(4));
                    p.setTelp(resultPegawai.getString(5));
                    p.setAlamat(resultPegawai.getString(6));
                    listPegawai.add(p);
                }
                resultPegawai.close();
                return listPegawai;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public String kodeBaru() {
        String kode = "";
        int angka = 0;
        query = "SELECT MAX(RIGHT(kode_pegawai,3)) as kode FROM pegawai";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            resultKode = koneksi.getRs();
            try {
                resultKode.next();
                angka = resultKode.getInt(1);
                if(angka<10){
                    kode = "WALLS-00" + (angka+1);
                }else if(angka<100){
                    kode = "WALLS-0"+(angka+1);
                }else{
                    kode = "WALLS-"+(angka+1);
                }
            } catch (Exception e) {
                return null;
            }
        }
        return kode;
    }

    @Override
    public boolean loginPegawai(String kode, String pass) {
        String password = null;
        query = "SELECT * FROM pegawai WHERE kode_pegawai ='"+kode+"' and password='"+pass+"' ";
        status = koneksi.eksekusiQuery(query, true);
        if(status){
            rsLogin = koneksi.getRs();
            try {
                rsLogin.next();
                pegawai = new EntityPegawai();
                this.pegawai.setKode_pegawai(rsLogin.getString(1));
                this.pegawai.setPassword(rsLogin.getString(2));
                this.pegawai.setNama(rsLogin.getString(3));
                this.pegawai.setJabatan(rsLogin.getString(4));
                this.pegawai.setTelp(rsLogin.getString(5));
                this.pegawai.setAlamat(rsLogin.getString(6));
                
                password = rsLogin.getString(2);
                rsLogin.close();
                if(password.equals("")){
                    status =false;
                }else{
                    status = true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return status;
    }

    @Override
    public EntityPegawai getPegawai() {
        return this.pegawai;
    }
    

    
}
