-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2017 at 08:41 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siwalls`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_pembelian`
--

CREATE TABLE `detail_pembelian` (
  `kode_pembelian` varchar(10) NOT NULL,
  `kode_produk` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  `harga_satuan` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_pembelian`
--

INSERT INTO `detail_pembelian` (`kode_pembelian`, `kode_produk`, `qty`, `harga_satuan`, `total`) VALUES
('BL11050001', 'CREAM-0001', 3500, 90, 315000),
('BL14050001', 'CREAM-0004', 2400, 24, 57600),
('BL14050001', 'CREAM-0003', 2400, 89, 213600),
('BL14050002', 'CREAM-0004', 45, 2400, 108000),
('BL14050002', 'CREAM-0003', 20, 2400, 48000),
('BL14050003', 'CREAM-0003', 4, 2400, 9600),
('BL14050003', 'CREAM-0004', 54, 2400, 129600),
('BL14050004', 'CREAM-0004', 50, 2400, 120000),
('BL14050005', 'CREAM-0004', 10, 2400, 24000),
('BL14050005', 'CREAM-0003', 10, 2400, 24000),
('BL18050001', 'CREAM-0002', 54, 2400, 129600),
('BL18050001', 'CREAM-0003', 90, 2400, 216000),
('BL29050001', 'CREAM-0005', 43, 2800, 120400),
('BL29050001', 'CREAM-0003', 45, 2400, 108000),
('BL30050001', 'CREAM-0006', 23, 4000, 92000),
('BL30050001', 'CREAM-0001', 43, 2400, 103200);

--
-- Triggers `detail_pembelian`
--
DELIMITER $$
CREATE TRIGGER `tg_update_stok` AFTER INSERT ON `detail_pembelian` FOR EACH ROW BEGIN
	UPDATE produk set stock=stock + NEW.qty WHERE kode_produk=NEW.kode_produk; 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `kode_penjualan` varchar(10) NOT NULL,
  `kode_produk` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  `total_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`kode_penjualan`, `kode_produk`, `qty`, `total_jual`) VALUES
('JL29050001', 'CREAM-0003', 8, 36000),
('JL29050001', 'CREAM-0005', 0, 0),
('JL29050001', 'CREAM-0003', 21, 94500),
('JL29050002', 'CREAM-0001', 22, 88000),
('JL29050003', 'CREAM-0004', 42, 189000),
('JL29050003', 'CREAM-0001', 2, 8000),
('JL29050003', 'CREAM-0004', 76, 342000),
('JL29050004', 'CREAM-0006', 8, 36000),
('JL29050004', 'CREAM-0005', 7, 31500),
('JL30050001', 'CREAM-0004', 21, 94500),
('JL30050001', 'CREAM-0006', 10, 45000),
('JL04060001', 'CREAM-0001', 6, 24000),
('JL05060001', 'CREAM-0003', 7, 31500),
('JL05060001', 'CREAM-0002', 3, 12000),
('JL05060002', 'CREAM-0003', 7, 31500),
('JL05060002', 'CREAM-0002', 3, 12000);

--
-- Triggers `detail_penjualan`
--
DELIMITER $$
CREATE TRIGGER `tg_update_stok_kurang` AFTER INSERT ON `detail_penjualan` FOR EACH ROW BEGIN
	UPDATE produk set stock=stock - NEW.qty WHERE kode_produk=NEW.kode_produk; 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `kode_transaksi` varchar(8) NOT NULL,
  `kode_produk` varchar(10) NOT NULL,
  `bawa` int(11) NOT NULL,
  `sisa` int(11) NOT NULL,
  `laku` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`kode_transaksi`, `kode_produk`, `bawa`, `sisa`, `laku`) VALUES
('14050001', 'CREAM-0003', 10, 2, 8),
('14050001', 'CREAM-0004', 20, 2, 18),
('14050001', 'CREAM-0001', 5, 1, 4),
('14050002', 'CREAM-0003', 5, 1, 4),
('14050002', 'CREAM-0002', 6, 1, 5),
('16050004', 'CREAM-0004', 1, 19, 58900),
('16050004', 'CREAM-0001', 2, 21, 58800),
('16050005', 'CREAM-0004', 20, 2, 18),
('16050005', 'CREAM-0001', 20, 1, 19),
('16050006', 'CREAM-0003', 12, 0, 12),
('16050006', 'CREAM-0001', 12, 0, 12),
('16050006', 'CREAM-0004', 20, 1, 19),
('17050001', 'CREAM-0003', 24, 2, 22),
('17050002', 'CREAM-0003', 60, 0, 60),
('17050002', 'CREAM-0002', 43, 2, 41),
('18050001', 'CREAM-0002', 24, 2, 22),
('18050001', 'CREAM-0003', 45, 1, 44),
('18050001', 'CREAM-0001', 45, 1, 44),
('20050001', 'CREAM-0003', 54, 2, 52),
('29050001', 'CREAM-0005', 4, 1, 3),
('29050001', 'CREAM-0003', 90, 3, 87),
('29050002', 'CREAM-0003', 10, 2, 8),
('29050002', 'CREAM-0005', 4, 4, 0),
('29050002', 'CREAM-0003', 23, 2, 21),
('29050003', 'CREAM-0001', 24, 2, 22),
('29050004', 'CREAM-0004', 45, 3, 42),
('29050004', 'CREAM-0001', 45, 43, 2),
('29050004', 'CREAM-0004', 78, 2, 76),
('29050005', 'CREAM-0006', 10, 2, 8),
('29050005', 'CREAM-0005', 7, 0, 7),
('30050001', 'CREAM-0004', 23, 2, 21),
('30050001', 'CREAM-0006', 10, 0, 10),
('04060001', 'CREAM-0001', 8, 2, 6),
('04060002', 'CREAM-0003', 9, 0, 0),
('04060002', 'CREAM-0006', 7, 0, 0),
('04060002', 'CREAM-0004', 8, 0, 0),
('05060001', 'CREAM-0003', 9, 2, 7),
('05060001', 'CREAM-0002', 5, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `hawker`
--

CREATE TABLE `hawker` (
  `kode_hawker` varchar(7) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `telp` varchar(20) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `tanggal_lahir` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hawker`
--

INSERT INTO `hawker` (`kode_hawker`, `nama`, `telp`, `alamat`, `tanggal_lahir`) VALUES
('HW-001', 'Junio', '08777238842', 'Gamping', '1995-05-11'),
('HW-003', 'Yusuf', '085838377446', 'Sekayu', '1996-06-06'),
('HW-004', 'Aditya', '085640838702', 'Banjar', '1996-05-07'),
('HW-005', 'Ismail', '0893432', 'Yogya', '2017-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `kode_pegawai` varchar(9) NOT NULL,
  `password` varchar(25) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jabatan` varchar(25) NOT NULL,
  `telp` varchar(20) NOT NULL,
  `alamat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`kode_pegawai`, `password`, `nama`, `jabatan`, `telp`, `alamat`) VALUES
('WALLS-001', 'walls', 'M Yusuf', 'Operator', '085838377448', 'Palembang'),
('WALLS-003', 'walls', 'Aditya', 'Manager', '085640838702', 'Banjarnegara	'),
('WALLS-004', 'walls', 'Junio', 'Operator', '089673295968', 'Yogya Gamping		');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `kode_pembelian` varchar(10) NOT NULL,
  `kode_pegawai` varchar(9) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`kode_pembelian`, `kode_pegawai`, `tanggal`) VALUES
('BL11050001', 'WALLS-003', '2017-05-11'),
('BL14050001', 'WALLS-001', '2017-05-14'),
('BL14050002', 'WALLS-001', '2017-05-14'),
('BL14050003', 'WALLS-003', '2017-05-14'),
('BL14050004', 'WALLS-003', '2017-05-14'),
('BL14050005', 'WALLS-003', '2017-05-14'),
('BL18050001', 'WALLS-003', '2017-05-18'),
('BL29050001', 'WALLS-003', '2017-05-29'),
('BL30050001', 'WALLS-003', '2017-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `kode_penjualan` varchar(10) NOT NULL,
  `kode_hawker` varchar(7) NOT NULL,
  `setor_hawker` int(11) NOT NULL,
  `omset_hawker` int(11) NOT NULL,
  `bonus_hawker` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`kode_penjualan`, `kode_hawker`, `setor_hawker`, `omset_hawker`, `bonus_hawker`, `total`, `tanggal`) VALUES
('JL04060001', 'HW-001', 7200, 16800, 0, 24000, '2017-06-04'),
('JL05060001', 'HW-005', 13400, 30100, 0, 43500, '2017-06-05'),
('JL05060002', 'HW-005', 13400, 30100, 0, 43500, '2017-06-05'),
('JL29050001', 'HW-004', 89900, 40600, 0, 130500, '2017-05-29'),
('JL29050002', 'HW-004', 61600, 26400, 0, 88000, '2017-05-29'),
('JL29050003', 'HW-001', 371400, 167600, 10000, 539000, '2017-05-29'),
('JL29050004', 'HW-003', 56100, 11400, 0, 67500, '2017-05-29'),
('JL30050001', 'HW-005', 108100, 31400, 0, 139500, '2017-05-30');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `kode_produk` varchar(10) NOT NULL,
  `nama_produk` varchar(25) NOT NULL,
  `harga_beli_satuan` int(11) NOT NULL,
  `harga_jual_sp` int(11) NOT NULL,
  `harga_jual_hawker` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`kode_produk`, `nama_produk`, `harga_beli_satuan`, `harga_jual_sp`, `harga_jual_hawker`, `stock`) VALUES
('CREAM-0001', 'PP Choco Magma B1', 2400, 2800, 4000, 799),
('CREAM-0002', 'PP Rainbow Power', 2400, 2800, 4000, 63),
('CREAM-0003', 'PP Fruit Pop', 2400, 3100, 4500, 42),
('CREAM-0004', 'PP Colour Popper', 2400, 3100, 4500, 690),
('CREAM-0005', 'PP Acy Fload', 2800, 3100, 4500, 87),
('CREAM-0006', 'PP Soler', 4000, 4300, 4500, 105);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(8) NOT NULL,
  `kode_hawker` varchar(7) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `kode_hawker`, `tanggal`) VALUES
('04060001', 'HW-001', '2017-06-04'),
('04060002', 'HW-003', '2017-06-04'),
('05060001', 'HW-005', '2017-06-05'),
('14050001', 'HW-003', '2017-05-14'),
('14050002', 'HW-001', '2017-05-14'),
('16050001', 'HW-001', '2017-05-16'),
('16050002', 'HW-003', '2017-05-16'),
('16050003', 'HW-003', '2017-05-16'),
('16050004', 'HW-003', '2017-05-16'),
('16050005', 'HW-001', '2017-05-16'),
('16050006', 'HW-001', '2017-05-16'),
('17050001', 'HW-003', '2017-05-17'),
('17050002', 'HW-001', '2017-05-17'),
('18050001', 'HW-001', '2017-05-18'),
('20050001', 'HW-003', '2017-05-20'),
('29050001', 'HW-004', '2017-05-29'),
('29050002', 'HW-004', '2017-05-29'),
('29050003', 'HW-004', '2017-05-29'),
('29050004', 'HW-001', '2017-05-29'),
('29050005', 'HW-003', '2017-05-29'),
('30050001', 'HW-005', '2017-05-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD KEY `kode_pembelian` (`kode_pembelian`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD KEY `kode_penjualan` (`kode_penjualan`),
  ADD KEY `kode_produk` (`kode_produk`),
  ADD KEY `kode_produk_2` (`kode_produk`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `kode_transaksi` (`kode_transaksi`),
  ADD KEY `kode_produk` (`kode_produk`);

--
-- Indexes for table `hawker`
--
ALTER TABLE `hawker`
  ADD PRIMARY KEY (`kode_hawker`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`kode_pegawai`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`kode_pembelian`),
  ADD KEY `kode_pegawai` (`kode_pegawai`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`kode_penjualan`),
  ADD KEY `kode_hawker` (`kode_hawker`),
  ADD KEY `kode_hawker_2` (`kode_hawker`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`kode_produk`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `kode_hawker` (`kode_hawker`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD CONSTRAINT `detail_pembelian_ibfk_1` FOREIGN KEY (`kode_pembelian`) REFERENCES `pembelian` (`kode_pembelian`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_pembelian_ibfk_2` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`kode_penjualan`) REFERENCES `penjualan` (`kode_penjualan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`kode_produk`) REFERENCES `produk` (`kode_produk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`kode_transaksi`) REFERENCES `transaksi` (`kode_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`kode_pegawai`) REFERENCES `pegawai` (`kode_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD CONSTRAINT `penjualan_ibfk_1` FOREIGN KEY (`kode_hawker`) REFERENCES `hawker` (`kode_hawker`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`kode_hawker`) REFERENCES `hawker` (`kode_hawker`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
