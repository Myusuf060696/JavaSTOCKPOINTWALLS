
package Interface;

import Entity.EntityHawker;
import java.util.List;


public interface InterfaceHawker {
    boolean insertHawker(EntityHawker h);
    boolean updateHawker(EntityHawker h);
    boolean deleteHawker(String kode);
    List selectHawker (String kode, String nama);
    String kodeBaru();
}
