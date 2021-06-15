-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 15, 2021 at 07:47 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE TABLE `house` (
  `ID` int(11) NOT NULL,
  `SIZE` float NOT NULL,
  `PRICE` int(11) NOT NULL,
  `ROOMS` int(11) NOT NULL,
  `BATHS` int(11) NOT NULL,
  `FLOORS` int(11) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `IMAGE` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `house`
--

INSERT INTO `house` (`ID`, `SIZE`, `PRICE`, `ROOMS`, `BATHS`, `FLOORS`, `ADDRESS`, `IMAGE`) VALUES
(2, 6.5, 15000, 2, 2, 1, 'Rawalpindi', 0x473a7a61686565722e706e67),
(3, 15, 12000, 4, 3, 1, 'Rawalpindi', 0x473a33442e706e67),
(4, 7, 19000, 4, 3, 2, 'Rawalpindi', 0x473a0961736d697961682e504e47),
(5, 8, 10000, 4, 3, 1, 'Sialkot', 0x473a44657369676e696e674d592047726170686963734a532e706e67);

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `CONTACT` bigint(80) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `CNIC` bigint(80) NOT NULL,
  `IMAGE` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`ID`, `NAME`, `CONTACT`, `ADDRESS`, `CNIC`, `IMAGE`) VALUES
(1, 'Zaheer', 321, 'Rawalpindi.', 37405, 0x473a7a61686565722e706e67),
(2, 'XPERROW', 3235437890, 'Sialkot,mall road, sadar', 3235437890999, 0x473a44657369676e696e674d5920477261706869637378706572726f772076352e332e706e67);

-- --------------------------------------------------------

--
-- Table structure for table `tenant`
--

CREATE TABLE `tenant` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `CONTACT` int(11) NOT NULL,
  `CNIC` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tenant`
--
ALTER TABLE `tenant`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `house`
--
ALTER TABLE `house`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tenant`
--
ALTER TABLE `tenant`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
