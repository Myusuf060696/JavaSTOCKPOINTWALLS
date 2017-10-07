
package Interface;

import Entity.EntityPembelian;
import java.util.List;


public interface InterfacePembelian {
    boolean insertPembelian(EntityPembelian p);
    boolean insertDetailPembelian (EntityPembelian p);
    String kodeBaru(String tgl, String kodeDepan);
    List selectPembelianFilter(String tanggalAwal, String tanggalAkhir);
    List selectDetailPembelian(String kode);
}
