
package Entity;


public class EntityPenjualan {
    private String kode_penjualan;
    private String kode_hawker;
    private String tanggal;
    private String kode_produk;
    private int qty;
    private int setor_hawker;
    private int omset_hawker;
    private int total_jual;
    private int bonus_hawker;

    public String getKode_penjualan() {
        return kode_penjualan;
    }

    public void setKode_penjualan(String kode_penjualan) {
        this.kode_penjualan = kode_penjualan;
    }

    public String getKode_hawker() {
        return kode_hawker;
    }

    public void setKode_hawker(String kode_hawker) {
        this.kode_hawker = kode_hawker;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal_jual() {
        return total_jual;
    }

    public void setTotal_jual(int total_jual) {
        this.total_jual = total_jual;
    }

    public int getSetor_hawker() {
        return setor_hawker;
    }

    public void setSetor_hawker(int setor_hawker) {
        this.setor_hawker = setor_hawker;
    }

    public int getOmset_hawker() {
        return omset_hawker;
    }

    public void setOmset_hawker(int omset_hawker) {
        this.omset_hawker = omset_hawker;
    }

    public int getBonus_hawker() {
        return bonus_hawker;
    }

    public void setBonus_hawker(int bonus_hawker) {
        this.bonus_hawker = bonus_hawker;
    }
    
    
}
