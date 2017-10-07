
package Interface;

import Entity.EntityPegawai;
import java.util.List;


public interface InterfacePegawai {
    boolean insertPegawai(EntityPegawai p);
    boolean updatePegawai(EntityPegawai p);
    boolean deletePegawai(String kode);
    boolean loginPegawai(String kode, String pass);
    List selectPegawai(String kode, String nama);
    String kodeBaru();
    EntityPegawai getPegawai();
}
