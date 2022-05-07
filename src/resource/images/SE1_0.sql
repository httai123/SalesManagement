-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: app_data
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billdetails`
--

DROP TABLE IF EXISTS `billdetails`;

CREATE TABLE `billdetails` (
  `billID` int NOT NULL,
  `productID` char(45) NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!440101 SET character_set_client = 'utf8'*/;


DROP TABLE IF EXISTS `bills`;

CREATE TABLE `bills` (
  `billID` int NOT NULL,
  `customerID` char(45) NOT NULL,
  `employeeID` char(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`billID`),
  UNIQUE KEY `billID_UNIQUE` (`billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = 'utf8'*/;

--
-- Dumping data for table `bills`
--
--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `ID` char(45) NOT NULL,
  `Name` tinytext NOT NULL,
  `Gender` tinytext NOT NULL,
  `DOB` date NOT NULL,
  `Adress` longtext NOT NULL,
  `Contact` tinytext NOT NULL,
  `Position` tinytext NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = 'utf8'*/;

--
-- Dumping data for table `employee`
--


--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `productID` char(45) NOT NULL,
  `productName` tinytext NOT NULL,
  `productUnit` tinytext NOT NULL,
  `productPrice` int NOT NULL,
  `productQuantity` int NOT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productID_UNIQUE` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = 'utf8'*/;

--
-- Dumping data for table `products`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05 12:09:51
