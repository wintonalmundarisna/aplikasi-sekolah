-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2024 at 09:09 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasi_sekolah`
--

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id` int(11) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `wali_kelas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id`, `kelas`, `wali_kelas`) VALUES
(2, 'R.5.A', 'Walas Satu'),
(4, 'R.6.B', 'Walas Dua'),
(5, 'R.7.C', 'Walas Tiga'),
(6, 'R.8.D', 'Walas Empat'),
(8, 'R.6.A', 'Pak Sarwan');

-- --------------------------------------------------------

--
-- Table structure for table `siswa`
--

CREATE TABLE `siswa` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `wali_kelas` varchar(100) NOT NULL,
  `tahun_ajaran` varchar(50) NOT NULL,
  `tanggal_pembayaran` date DEFAULT current_timestamp(),
  `total_tunggakan` bigint(20) DEFAULT 0,
  `total_pembayaran` bigint(20) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `siswa`
--

INSERT INTO `siswa` (`id`, `nama`, `nis`, `kelas`, `wali_kelas`, `tahun_ajaran`, `tanggal_pembayaran`, `total_tunggakan`, `total_pembayaran`) VALUES
(1, 'Pertama', '202143500065', 'R.6.B', 'Walas Dua', '2011', '0000-00-00', 30000, 50000),
(2, 'Kedua', '202143500055', 'R.5.A', 'Walas Satu', '2010', '2020-05-12', 0, 0),
(4, 'Ketiga', '202143500070', 'R.7.C', 'Walas Tiga', '2011', '2020-05-12', 50000, 10000),
(5, 'Keempat', '202143500022', 'R.6.B', 'Walas Dua', '2010', '2020-05-12', 0, 80000),
(9, 'Winton', '202143500065', 'R.6.A', 'Walas Satu', '2013', '2020-05-12', 10000, 10000),
(12, 'Bagas', '202143500011', 'R.6.B', 'Walas Tiga', '2024', '2020-05-12', 0, 0),
(13, 'Andri', '202143500044', 'R.7.C', 'Walas Dua', '1745', '2024-05-31', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tahun_ajaran`
--

CREATE TABLE `tahun_ajaran` (
  `id` int(11) NOT NULL,
  `tahun_ajaran` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tahun_ajaran`
--

INSERT INTO `tahun_ajaran` (`id`, `tahun_ajaran`) VALUES
(1, '2010'),
(2, '2011'),
(7, '1745'),
(8, '2013'),
(9, '2024');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `tanggal_pembayaran` date NOT NULL,
  `nis` varchar(12) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `tahun_ajaran` varchar(50) NOT NULL,
  `total_tunggakan` bigint(255) NOT NULL,
  `total_pembayaran` bigint(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `tanggal_pembayaran`, `nis`, `nama`, `kelas`, `tahun_ajaran`, `total_tunggakan`, `total_pembayaran`) VALUES
(2, '2024-06-10', '202143500044', 'Andri', 'R.7.C', '2010', 100000, 0),
(5, '2024-06-05', '202143500065', 'Winton', 'R.6.A', '2024', 65, 0),
(7, '2024-06-02', '202143500011', 'Bagas', 'R.6.B', '2013', 1, 5000),
(8, '2024-06-04', '202143500022', 'Alfian', 'R.7.C', '2011', 4, 0),
(29, '2024-06-07', '202143500070', 'Winton', 'R.6.A', '2024', 7, 0),
(30, '2024-06-07', '202143500055', 'Winton', 'R.6.A', '2024', 200, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `full_name`, `email`, `password`) VALUES
(1, 'Winton Almundarisna Aja', 'wintonaja@gmail.com', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tahun_ajaran`
--
ALTER TABLE `tahun_ajaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `siswa`
--
ALTER TABLE `siswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tahun_ajaran`
--
ALTER TABLE `tahun_ajaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
