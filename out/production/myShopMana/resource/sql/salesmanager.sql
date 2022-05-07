-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2022 at 06:49 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salesmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `billdetails`
--

CREATE TABLE `billdetails` (
  `billID` int(11) NOT NULL,
  `productID` char(45) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `billID` int(11) NOT NULL,
  `customerID` char(45) NOT NULL,
  `employeeID` char(45) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `productID` char(45) NOT NULL,
  `productName` tinytext NOT NULL,
  `productUnit` tinytext NOT NULL,
  `productPrice` int(11) NOT NULL,
  `productQuantity` int(11) NOT NULL,
  `productCategory` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `productName`, `productUnit`, `productPrice`, `productQuantity`, `productCategory`) VALUES
('M001', 'TH True Milk', 'hộp', 42000, 53, 'Beverages'),
('ME001', 'Thịt lợn', 'miếng', 109000, 30, 'Meat'),
('R001', 'Gạo AAN 5kg', 'bao', 90000, 40, 'Rice'),
('S001', 'Dầu ăn Tường An', 'chai', 40000, 25, 'Sauce & Oils'),
('V001', 'Rau Cai', 'bó', 12000, 20, 'Vegetables'),
('W001', 'Lavie', 'chai', 6000, 50, 'Beverages');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` char(45) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `usertype` varchar(50) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `phoneNum` varchar(10) NOT NULL,
  `email` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `username`, `password`, `usertype`, `dateOfBirth`, `firstName`, `lastName`, `phoneNum`, `email`) VALUES
('CA02', 'chubeloatchoat', 'huemongmo', 'Cashier', '2003-09-25', 'Blondy ', 'Mobe', '0967514523', 'karraoke02@vnu.edu.vn'),
('MA01', 'chelseaa', 'lukaka123', 'Manager', '2002-05-03', 'Grnad', 'Mount', '0359247221', 'lukaka@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billdetails`
--
ALTER TABLE `billdetails`
  ADD PRIMARY KEY (`billID`);

--
-- Indexes for table `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`billID`),
  ADD UNIQUE KEY `billID_UNIQUE` (`billID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`),
  ADD UNIQUE KEY `productID_UNIQUE` (`productID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userId_UNIQUE` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
