
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class KoneksiDB {
    private Connection koneksi;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public Connection getKoneksi(){
        if(koneksi==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    String url = "jdbc:mysql://localhost:3306/siwalls";
                    koneksi = DriverManager.getConnection(url,"root","");
                    System.out.println("Koneksi Sukses");
                } catch (Exception e) {
                    System.out.println("Koneksi Gagal");
                }
            } catch (Exception e) {
                System.out.println("Class Tidak Ditemukan " + e);
                System.exit(0);
            }
        }
        return koneksi;
    }
    
    public ResultSet getRs(){
        return rs;
    }
    
    public boolean eksekusiQuery(String query, boolean status){
        try {
            ps = koneksi.prepareStatement(query);
            if(status){
                rs = ps.executeQuery();
            }else{
                ps.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
//    public static void main(String[] args) {
//        new KoneksiDB().getKoneksi();
//    }
    
}
