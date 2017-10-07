
package Factory;

import Implement.ImplementHawker;
import Implement.ImplementPegawai;
import Implement.ImplementPembelian;
import Implement.ImplementProduk;
import Implement.ImplementTransaksi;
import Implement.ImplementasiPenjualan;
import Interface.InterfaceHawker;
import Interface.InterfacePegawai;
import Interface.InterfacePembelian;
import Interface.InterfacePenjualan;
import Interface.InterfaceProduk;
import Interface.InterfaceTransaksi;


public class Factory {
    private static InterfacePegawai pegawaiDAO;
    private static InterfaceHawker hawkerDAO;
    private static InterfaceProduk produkDAO;
    private static InterfacePembelian pembelianDAO;
    private static InterfacePenjualan penjualanDAO;
    private static InterfaceTransaksi transaksiDAO;
    
    public static InterfacePegawai getPegawaiDAO(){
        pegawaiDAO = new ImplementPegawai();
        return pegawaiDAO;
    }
    
    public static InterfaceHawker getHawkerDAO(){
        hawkerDAO = new ImplementHawker();
        return hawkerDAO;
    }
    
    public static InterfaceProduk getProdukDAO(){
        produkDAO = new ImplementProduk();
        return produkDAO;
    }
    
    public static InterfacePembelian getPembelianDAO(){
        pembelianDAO = new ImplementPembelian();
        return pembelianDAO;
    }
    
    public static InterfacePenjualan getPenjualanDAO(){
        penjualanDAO = new ImplementasiPenjualan();
        return penjualanDAO;
    }
    
    public static InterfaceTransaksi getTransaksiDAO(){
        transaksiDAO = new ImplementTransaksi();
        return transaksiDAO;
    }
    
}
