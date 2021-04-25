-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2021 at 07:49 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `adminID` int(11) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `name` varchar(120) NOT NULL,
  `dob` varchar(120) NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`adminID`, `email`, `password`, `name`, `dob`, `phone`, `address`) VALUES
(1, 'kpjepa@gmail.com', '123', 'Ishan Gamage', '1996/06/23', 773456765, '178/B. Colombo 5'),
(2, 'lahiru@gmail.com', '123', 'Kamal Dassanayake', '1993/04/04', 774579413, '184/C, Rahula, Matara'),
(3, 'abc@gmail.com', '123', 'Amal deSilva', '1992/01/04', 774899410, '166/A, Kakanadura, Matara');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `name` varchar(120) NOT NULL,
  `dob` varchar(120) NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `email`, `password`, `name`, `dob`, `phone`, `address`) VALUES
(1, 'jeerange@gmail.com', '123', 'Dasun Madusanka', '1993/04/13', 719987809, '184/C, Anagarika Mawatha, Colombo 3 '),
(2, 'nimal@ecafe.com', '123', 'Nimal Perara', '1990/02/05', 772378510, '356/H, Athawatunu Wava, Hambantota');

-- --------------------------------------------------------

--
-- Table structure for table `seller`
--

CREATE TABLE `seller` (
  `sellerID` int(11) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `name` varchar(120) NOT NULL,
  `dob` varchar(11) NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seller`
--

INSERT INTO `seller` (`sellerID`, `email`, `password`, `name`, `dob`, `phone`, `address`) VALUES
(5, '123sft@gmail.com', '123', 'Nihal Gunasinghe', '1999/12/04', 707890654, '178/A, Danketiya, Tangalle'),
(6, 'kusal@gmail.com', '123', 'Kamal samaraweera', '1993/11/11', 776543567, '334/L Kumarasiri Mawatha, Wallgama');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`sellerID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `seller`
--
ALTER TABLE `seller`
  MODIFY `sellerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
