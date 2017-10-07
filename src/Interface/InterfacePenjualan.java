
package Interface;

import Entity.EntityPenjualan;
import java.util.List;


public interface InterfacePenjualan {
    boolean insertPenjualan (EntityPenjualan p);
    boolean insertDetailPenjualan (EntityPenjualan p);
    boolean cobaselect(String tanggalAwal, String tanggalAkhir);
    String kodeBaru(String tgl, String kodeDepan);
    List selectPenjualanFilter (String tanggalAwal, String tanggalAkhir);
    List selectDetailPenjualan (String kode);
    String kodeTransaksi(String tanggal, String kodehawker);
    List selectDetailTransaksiHawker(String kodetransaksi);
    String namaProduk(String kode);
    String harga_sp(String kode);
    String harga_jual(String kode);
}
