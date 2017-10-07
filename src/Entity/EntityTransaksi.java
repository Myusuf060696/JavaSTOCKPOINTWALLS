
package Entity;


public class EntityTransaksi {
    private String kode_transaksi;
    private String kode_hawker;
    private String tanggal;
    private String kode_produk;
    private int bawa;
    private int sisa;
    private int laku;

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
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

    public int getBawa() {
        return bawa;
    }

    public void setBawa(int bawa) {
        this.bawa = bawa;
    }

    public int getSisa() {
        return sisa;
    }

    public void setSisa(int sisa) {
        this.sisa = sisa;
    }

    public int getLaku() {
        return laku;
    }

    public void setLaku(int laku) {
        this.laku = laku;
    }
    
    
}
