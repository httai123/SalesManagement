-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2022 at 06:44 AM
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
  `employeeID` varchar(11) NOT NULL,
  `billArea` text NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `billdetails`
--

INSERT INTO `billdetails` (`billID`, `employeeID`, `billArea`, `amount`) VALUES
('BD01', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD01\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       M001     TH True Milk    42000.0            2            2022-05-24    84000.0\n  2       ME02     Ba chỉ lợn 500g     54000.0            1            2022-05-24    54000.0\n', 138000),
('BD02', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD02\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       SO13     Tương ớt chinsu 200g    12000.0            1            2022-05-24    12000.0\n', 12000),
('BD03', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD03\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       V001     Rau Cai    12000.0            2            2022-05-24    24000.0\n', 24000),
('BD04', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD04\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       ME001     Thịt lợn    109000.0            1            2022-05-25    109000.0\n', 109000),
('BD05', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD05\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       M001     TH True Milk    42000.0            1            2022-05-25    42000.0\n', 42000),
('BD06', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD06\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       V001     Rau Cai    12000.0            1            2022-05-25    12000.0\n  2       W001     Lavie    6000.0            2            2022-05-25    12000.0\n', 24000),
('BD07', 'CA02', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA02\n BILL ID    BD07\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       R001     Gạo AAN 5kg    90000.0            1            2022-05-25    90000.0\n  2       ME02     Ba chỉ lợn 500g     54000.0            1            2022-05-25    54000.0\n', 144000),
('BD08', 'CA02', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA02\n BILL ID    BD08\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       M001     TH True Milk    42000.0            1            2022-05-25    42000.0\n', 42000),
('BD09', 'CA01', '=========================  CIRCLE D  ==========================\n CASHIER ID   CA01\n BILL ID    BD09\n NUM       ID       PRODUCT     PRICE     QUANTITY     DATE            TOTAL\n  1       ME001     Thịt lợn    109000.0            1            2022-05-25    109000.0\n', 109000);

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `billID` varchar(10) NOT NULL,
  `employeeID` char(45) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`billID`, `employeeID`, `date`) VALUES
('BD01', 'CA01', '2022-05-24'),
('BD02', 'CA01', '2022-05-24'),
('BD03', 'CA01', '2022-05-24'),
('BD04', 'CA01', '2022-05-25'),
('BD05', 'CA01', '2022-05-25'),
('BD06', 'CA01', '2022-05-25'),
('BD07', 'CA02', '2022-05-25'),
('BD08', 'CA02', '2022-05-25'),
('BD09', 'CA01', '2022-05-25');

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
('B02', 'Trà đào Cozy', 'hộp', 43000, 29, 'Beverages'),
('M001', 'TH True Milk', 'hộp', 42000, 36, 'Beverages'),
('ME001', 'Thịt lợn', 'miếng', 109000, 165, 'Meat'),
('ME02', 'Ba chỉ lợn 500g ', 'gói', 54000, 26, 'Meat'),
('R001', 'Gạo AAN 5kg', 'bao', 90000, 31, 'Rice'),
('R02', 'Cơm nắm ', 'gói', 12000, 14, 'Rice'),
('R12', 'Sữa ', '1', 2000, 1000, 'Beverages'),
('S001', 'Dầu ăn Tường An', 'chai', 40000, 35, 'Sauce & Oils'),
('SO13', 'Tương ớt chinsu 200g', 'chai', 12000, 29, 'Sauce & Oils'),
('SO14', 'Tương ớt chinsu 500g', 'chai', 24000, 29, 'Sauce & Oils'),
('V001', 'Rau Cai', 'bó', 12000, 7, 'Vegetables'),
('W001', 'Lavie', 'chai', 6000, 45, 'Beverages');

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
('B02', 'Trà đào Cozy', 43000, 1, 43000),
('M001', 'TH True Milk', 42000, 14, 588000),
('ME001', 'Thịt lợn', 109000, 5, 545000),
('ME02', 'Ba chỉ lợn 500g ', 54000, 4, 216000),
('R001', 'Gạo AAN 5kg', 90000, 3, 270000),
('R02', 'Cơm nắm ', 12000, 1, 12000),
('S001', 'Dầu ăn Tường An', 40000, 1, 40000),
('SO13', 'Tương ớt chinsu 200g', 12000, 1, 12000),
('SO14', 'Tương ớt chinsu 500g', 24000, 1, 24000),
('V001', 'Rau Cai', 12000, 5, 60000),
('W001', 'Lavie', 6000, 3, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `ID` varchar(15) NOT NULL,
  `fullName` varchar(20) NOT NULL,
  `basicSalary` double NOT NULL,
  `totalSales` int(11) NOT NULL,
  `additions` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`ID`, `fullName`, `basicSalary`, `totalSales`, `additions`) VALUES
('CA01', 'Emme Duun', 5000000, 7, 22900),
('CA02', 'Blondy Mobe', 5000000, 2, 9300),
('CA04', 'Mary Banm', 5000000, 0, 0);

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
  `email` longtext NOT NULL,
  `basicSalary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `username`, `password`, `usertype`, `dateOfBirth`, `firstName`, `lastName`, `phoneNum`, `email`, `basicSalary`) VALUES
('CA01', 'danbrown123', 'devilangle1', 'Cashier', '2022-05-24', 'Emme', 'Duun', '0967513633', 'spiderumRR@gmail.com', 5000000),
('CA02', 'chubeloatchoat', 'huemongmo', 'Cashier', '2003-09-25', 'Blondy ', 'Mobe', '0967514523', 'karraoke02@vnu.edu.vn', 5000000),
('CA04', 'BananaC', 'bamboo123', 'Cashier', '2021-05-17', 'Mary', 'Banm', '012', 'banmboo123@gmail.com', 5000000),
('MA01', 'wembleyDead', 'nxbgdvnhtlnkqg1', 'Manager', '2002-05-03', 'Mason', 'Mount', '0359247221', 'lukaka@gmail.com', 0);

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
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userId_UNIQUE` (`userId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `FK_salaryUser` FOREIGN KEY (`ID`) REFERENCES `user` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
