-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2021 at 10:05 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thucungpetpro`
--

-- --------------------------------------------------------

--
-- Table structure for table `loaiisanpham`
--

CREATE TABLE `loaiisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaiisanpham`
--

INSERT INTO `loaiisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Thời  Trang      ', 'https://bizweb.dktcdn.net/thumb/grande/100/067/820/articles/thoi-trang-thu-cung.jpg?v=1499849840703'),
(2, 'Dụng Cụ Hàng Ngày  ', 'https://www.petcity.vn/media/news/0203_t3.png'),
(3, 'Thức Ăn', 'https://meocun.com/wp-content/uploads/image1-12.jpg'),
(4, 'Sức Khỏe', 'https://hopquysanpham.com/wp-content/uploads/2019/06/thuoc-thu-y.png');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'YU SƠ MI NHIỀU MÀU 1-2-3-4', 65000, '1TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(2, 'ÁO LÍNH CÓ NÓN', 35000, '2TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(3, 'ÁO BA LỖ FBI', 35000, '3TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(4, 'ÁO CÓ TAY ANGEL', 30000, '4TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(5, 'BỘ SƯU TẦM HÈ THU', 40000, '5TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(6, 'ÁO BA LỖ PUG', 30000, '6TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(7, 'ÁO THUN RÁP TAY', 30000, '7TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(8, 'ÁO 3 LỖ THE DOG FACE', 25000, '8TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(9, 'DÂY DẮT YẾM ÁO VEST', 120000, '9TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(10, 'JUMP ÁO TẾT', 170000, '10TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(11, 'VÁY XÒE REN', 120000, '11TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1),
(12, ' ÁO SƠ MI CARO QUẦN JEAN', 150000, '12TT.JPG', 'Áo phù hợp đủ size cho các giống thú cưng từ 0.5-5kg\r\n\r\nĐược làm từ chất liệu vải cao cấp, nó là lạnh và thoáng khí, bền và chống mài mòn, dễ dàng duy trì.​', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `loaiisanpham`
--
ALTER TABLE `loaiisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `loaiisanpham`
--
ALTER TABLE `loaiisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
