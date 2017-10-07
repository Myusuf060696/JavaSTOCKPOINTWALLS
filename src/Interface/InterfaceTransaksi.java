
package Interface;

import Entity.EntityTransaksi;


public interface InterfaceTransaksi {
    boolean insertTransaksi(EntityTransaksi t);
    boolean insertDetailTransaksi(EntityTransaksi t);
    String kodeBaru(String tgl, String kodeDepan);
    boolean updateDetailTransaksi(EntityTransaksi t);
}
