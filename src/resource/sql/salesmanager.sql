-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2022 at 07:34 PM
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
  `billID` varchar(10) NOT NULL,
  `billArea` text NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `billdetails`
--

INSERT INTO `billdetails` (`billID`, `billArea`, `amount`) VALUES
('CD01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    CD01\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       ME001     Thịt lợn    109000.0            1            2022-05-11    109000.0\n  2       S001     Dầu ăn Tường An    40000.0            1            2022-05-11    40000.0\n  3       R001     Gạo AAN 5kg    90000.0            1            2022-05-11    90000.0\n', 239000);

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `billID` varchar(10) NOT NULL,
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
  `productPrice` double NOT NULL,
  `productQuantity` int(11) NOT NULL,
  `productCategory` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `productName`, `productUnit`, `productPrice`, `productQuantity`, `productCategory`) VALUES
('M001', 'TH True Milk', 'hộp', 42000, 51, 'Beverages'),
('ME001', 'Thịt lợn', 'miếng', 109000, 18, 'Meat'),
('R001', 'Gạo AAN 5kg', 'bao', 90000, 35, 'Rice'),
('S001', 'Dầu ăn Tường An', 'chai', 40000, 39, 'Sauce & Oils'),
('V001', 'Rau Cai', 'bó', 12000, 14, 'Vegetables'),
('W001', 'Lavie', 'chai', 6000, 48, 'Beverages');

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `productID` varchar(50) NOT NULL,
  `productName` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `quantitySold` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`productID`, `productName`, `price`, `quantitySold`, `total`) VALUES
('R001', 'Gạo AAN 5kg', 90000, 1, 90000),
('S001', 'Dầu ăn Tường An', 40000, 1, 40000);

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
('MA01', 'chelseaa', 'lukaka123', 'Manager', '2002-05-03', 'Grnad', 'Mount', '0359247221', 'lukaka@gmail.com'),
('MA02', 'lamascho', '12345678', 'Manager', '2003-06-11', 'Mù', 'Tạt', '0982175668', 'qilistation@thuocke.com');

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
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`productID`);

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
