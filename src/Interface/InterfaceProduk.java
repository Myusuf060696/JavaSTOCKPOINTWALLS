
package Interface;

import Entity.EntityProduk;
import java.sql.ResultSet;
import java.util.List;


public interface InterfaceProduk {
    boolean insertProduk(EntityProduk p);
    boolean updateProduk(EntityProduk p);
    boolean deleteProduk(String kode);
    List selectProduk(String kode, String nama);
    String kodeBaru();
    List cekStockProduk();
    ResultSet cekStock();
}
