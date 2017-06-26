-- MySQL dump 10.13  Distrib 5.5.50, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: spring_employees
-- ------------------------------------------------------
-- Server version	5.5.50-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `spring_employees`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `spring_employees` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `spring_employees`;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `dept_no` char(4) COLLATE utf8_unicode_ci NOT NULL,
  `dept_name` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dept_emp`
--

DROP TABLE IF EXISTS `dept_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept_emp` (
  `from_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `emp_no` int(11) NOT NULL,
  `dept_no` char(4) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`emp_no`,`dept_no`),
  KEY `FK_dept_no` (`dept_no`),
  CONSTRAINT `FK_dept_no` FOREIGN KEY (`dept_no`) REFERENCES `departments` (`dept_no`),
  CONSTRAINT `FK_emp_no` FOREIGN KEY (`emp_no`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dept_manager`
--

DROP TABLE IF EXISTS `dept_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept_manager` (
  `from_date` datetime DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `emp_no` int(11) NOT NULL,
  `dept_no` char(4) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`emp_no`,`dept_no`),
  KEY `dept_no` (`dept_no`),
  CONSTRAINT `FK4lvfrwfkmx5fefuo7si6921on` FOREIGN KEY (`dept_no`) REFERENCES `departments` (`dept_no`),
  CONSTRAINT `FKknmwmf34itsi98bbmkbuauak2` FOREIGN KEY (`emp_no`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `emp_no` int(11) NOT NULL,
  `birth_date` datetime DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` enum('M','F','UNKNOWN') COLLATE utf8_unicode_ci DEFAULT 'UNKNOWN',
  `hire_date` datetime DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salaries`
--

DROP TABLE IF EXISTS `salaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaries` (
  `from_date` datetime NOT NULL,
  `salary` int(11) DEFAULT NULL,
  `to_date` datetime DEFAULT NULL,
  `emp_no` int(11) NOT NULL,
  PRIMARY KEY (`from_date`,`emp_no`),
  KEY `FKjojacp79fphmajxrdll8fvf5o` (`emp_no`),
  CONSTRAINT `FKjojacp79fphmajxrdll8fvf5o` FOREIGN KEY (`emp_no`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `titles`
--

DROP TABLE IF EXISTS `titles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `titles` (
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `from_date` datetime NOT NULL,
  `to_date` datetime DEFAULT NULL,
  `emp_no` int(11) NOT NULL,
  PRIMARY KEY (`title`,`from_date`,`emp_no`),
  KEY `FK9nelqqayecqtilincs67u639a` (`emp_no`),
  CONSTRAINT `FK9nelqqayecqtilincs67u639a` FOREIGN KEY (`emp_no`) REFERENCES `employees` (`emp_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-26 13:11:50
