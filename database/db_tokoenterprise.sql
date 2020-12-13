-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2020 at 06:07 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tokoenterprise`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `kd_barang` int(11) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `stok_barang` int(11) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `TotalHarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`kd_barang`, `nama_barang`, `stok_barang`, `harga_barang`, `TotalHarga`) VALUES
(1, 'Rok Mini', 98, 30000, 3000000),
(2, 'Rok Panjang', 7, 50000, 350000),
(3, 'Celana Jeans', 996, 150000, 150000000),
(4, 'Indomie', 196, 1000, 400000),
(5, 'Ikan Bakar', 120, 10000, 1230000),
(6, 'Nasi Padang', 5, 20000, 280000),
(7, 'Soto Ayam', 99, 12000, 1188000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_customer`
--

CREATE TABLE `tb_customer` (
  `id_customer` int(11) NOT NULL,
  `nama_customer` varchar(50) NOT NULL,
  `alamat_customer` varchar(50) DEFAULT NULL,
  `email_customer` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_customer`
--

INSERT INTO `tb_customer` (`id_customer`, `nama_customer`, `alamat_customer`, `email_customer`, `password`) VALUES
(181011402, 'adam', 'tangsel', '@adam', '[1, 2, 3, 4]');

-- --------------------------------------------------------

--
-- Table structure for table `tb_supplier`
--

CREATE TABLE `tb_supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama_supplier` varchar(50) DEFAULT NULL,
  `alamat_supplier` varchar(50) DEFAULT NULL,
  `email_supplier` varchar(50) DEFAULT NULL,
  `telp_supplier` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_supplier`
--

INSERT INTO `tb_supplier` (`id_supplier`, `nama_supplier`, `alamat_supplier`, `email_supplier`, `telp_supplier`) VALUES
(111, 'Widyawati', 'Jl. Mylta', 'widya12@gmail.com', '08764543555'),
(112, 'Graciella', 'JL Besusu', 'grcllshm@gmail.com', '085282810040'),
(113, 'Ismi', 'jl pndok aren', 'reksal@gmail.com', '124545633'),
(114, 'Putri', 'Pondok Kacang', 'Putri@gmail.com', '0824513643');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `jumlah_barang` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal_transaksi` varchar(50) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id_transaksi`, `nama_user`, `nama_barang`, `jumlah_barang`, `harga`, `tanggal_transaksi`, `total`) VALUES
(32, 'nurbismi', 'Celana Jeans', 1, 150000, ' December 13, 2020', 150000),
(33, 'nurbismi', 'Indomie', 100, 1000, ' December 13, 2020', 100000),
(34, 'kusu', 'Indomie', 55, 1000, ' December 13, 2020', 55000),
(35, 'adam Pamungkas', 'Rok Mini', 1, 30000, ' December 13, 2020', 30000),
(36, 'nurbismi', 'Ikan Bakar', 1, 10000, ' December 13, 2020', 10000),
(40, 'nurbismi', 'Ikan Bakar', 1, 10000, ' December 13, 2020', 10000),
(41, 'nurbismi', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000),
(42, 'nurbismi', 'Nasi Padang', 2, 20000, ' December 13, 2020', 40000),
(43, 'nurbismi', 'Indomie', 4, 1000, ' December 13, 2020', 4000),
(44, 'nurbismi', 'Indomie', 44, 1000, ' December 13, 2020', 44000),
(45, 'nurbismi', 'Celana Jeans', 4, 150000, ' December 13, 2020', 600000),
(46, 'nurbismi', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000),
(47, 'nurbismi', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000),
(48, 'nurbismi', 'Rok Mini', 1, 30000, ' December 13, 2020', 30000),
(49, 'nurbismi', 'Rok Mini', 1, 30000, ' December 13, 2020', 30000),
(50, 'nurbismi', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000),
(51, 'kusu', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000),
(52, 'kusu', 'Nasi Padang', 1, 20000, ' December 13, 2020', 20000);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `level` enum('admin','user') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `username`, `password`, `nama_user`, `level`) VALUES
(2, 'admin', 'admin', 'nurbismi', 'admin'),
(3, 'user', 'user', 'kusu', 'user'),
(4, 'akuntes', 'akuntes123', 'akuntesting', 'admin'),
(7, 'andy_kece', '[a, n, d, i, 1, 2, 3]', 'andi', 'user'),
(8, 'cry', '[c, r, y, 1, 2, 3]', 'farhan', 'user'),
(9, 'ali_1', '[1, 2, 3]', 'ali', 'user'),
(11, 'adam', '[1, 2, 3]', 'adam', 'user'),
(14, '12333333333333', '123', '123', 'user'),
(15, 'adam', '123', 'adam Pamungkas', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tb_customer`
--
ALTER TABLE `tb_customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indexes for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_barang`
--
ALTER TABLE `tb_barang`
  MODIFY `kd_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tb_customer`
--
ALTER TABLE `tb_customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=181011406;

--
-- AUTO_INCREMENT for table `tb_supplier`
--
ALTER TABLE `tb_supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
