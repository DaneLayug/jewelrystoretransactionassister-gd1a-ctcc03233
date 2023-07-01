-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2023 at 04:39 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jewelry_items`
--

-- --------------------------------------------------------

--
-- Table structure for table `jewelries`
--

CREATE TABLE `jewelries` (
  `jewelry_code` int(11) NOT NULL,
  `jewelry_number` varchar(32) NOT NULL,
  `jewelry_karat` varchar(32) NOT NULL,
  `jewelry_type` varchar(32) NOT NULL,
  `jewelry_design` varchar(32) NOT NULL,
  `jewelry_grams` varchar(32) NOT NULL,
  `jewelry_length` varchar(32) DEFAULT NULL,
  `jewelry_Price` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jewelries`
--

INSERT INTO `jewelries` (`jewelry_code`, `jewelry_number`, `jewelry_karat`, `jewelry_type`, `jewelry_design`, `jewelry_grams`, `jewelry_length`, `jewelry_Price`) VALUES
(1, '1', '14K', 'Earrings', 'Crossed Heart', '0.7g', '', '2050'),
(2, '2', '14K', 'Chain', 'Japanese', '1.2g', '18 inches', '3500'),
(3, '3', '14K', 'Pendant', 'Heart', '0.4g', '', '1170'),
(4, '4', '14K', 'Ring', 'Plain', '2.6g', '6 1/2', '7590'),
(5, '5', '14K', 'Bracelet', 'Chain with Danggling Orbs', '2.4g', '7 inches', '7000'),
(6, '6', '18K', 'Earrings', 'Danggling Stars', '1.50g', '', '4950'),
(7, '7', '18K', 'Earrings', 'Loop', '2.00g', '', '6750'),
(8, '8', '18K', 'Earrings', 'Egyptian Design Creolla', '2.09g', '', '6990'),
(9, '9', '18K', 'Chain', 'Box', '4.62g', '18 inches', '15390'),
(10, '10', '18K', 'Chain', 'Knot', '10.59g', '20 inches', '34950'),
(11, '11', '18K', 'Chain', 'Damascus', '19.50g', '24 inches', '64350'),
(12, '12', '18K', 'Pendant', 'Clover Heart', '1.55g', '', '5200'),
(13, '13', '18K', 'Pendant', 'Cross', '1.78g', '', '5950'),
(14, '14', '18K', 'Pendant', 'Knot', '1.89g', '', '6350'),
(15, '15', '18K', 'Ring', 'Proposal', '2.02g', '7 1/4', '6700'),
(16, '16', '18K', 'Ring', 'Twin Hearts', '3.65g', '8', '12050'),
(17, '17', '18K', 'Ring', 'Dollar Sign', '7.90g', '12', '26090'),
(18, '18', '18K', 'Bracelet', 'Paper Clip', '1.50g', '8 inches', '4950'),
(19, '19', '18K', 'Bracelet', 'Knot', '2.2g', '9 inches', '7290'),
(20, '20', '18K', 'Bracelet', 'Damsacus', '15.23g', '9 inches', '50390');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jewelries`
--
ALTER TABLE `jewelries`
  ADD PRIMARY KEY (`jewelry_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
