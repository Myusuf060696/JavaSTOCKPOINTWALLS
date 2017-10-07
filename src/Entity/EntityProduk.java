
package Entity;


public class EntityProduk {
    private String kode_produk;
    private String nama_produk;
    private int harga_beli_satuan;
    private int harga_jual_sp;
    private int harga_jual_hawker;
    private int stock;

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int getHarga_beli_satuan() {
        return harga_beli_satuan;
    }

    public void setHarga_beli_satuan(int harga_beli_satuan) {
        this.harga_beli_satuan = harga_beli_satuan;
    }

   

    public int getHarga_jual_sp() {
        return harga_jual_sp;
    }

    public void setHarga_jual_sp(int harga_jual_sp) {
        this.harga_jual_sp = harga_jual_sp;
    }

    public int getHarga_jual_hawker() {
        return harga_jual_hawker;
    }

    public void setHarga_jual_hawker(int harga_jual_hawker) {
        this.harga_jual_hawker = harga_jual_hawker;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
