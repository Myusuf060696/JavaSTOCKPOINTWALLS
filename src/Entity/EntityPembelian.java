
package Entity;


public class EntityPembelian {
    private String kode_pembelian;
    private String kode_pegawai;
    private String tanggal;
    private String kode_produk;
    private int qty;
    private int harga_satuan;
    private int total;

    public String getKode_pembelian() {
        return kode_pembelian;
    }

    public void setKode_pembelian(String kode_pembelian) {
        this.kode_pembelian = kode_pembelian;
    }

    public String getKode_pegawai() {
        return kode_pegawai;
    }

    public void setKode_pegawai(String kode_pegawai) {
        this.kode_pegawai = kode_pegawai;
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

    public int getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(int harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
