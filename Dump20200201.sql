CREATE DATABASE  IF NOT EXISTS `thinkquotienttracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `thinkquotienttracker`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: thinkquotienttracker
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drive`
--

DROP TABLE IF EXISTS `drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) NOT NULL,
  `noofresourses` int(11) DEFAULT NULL,
  `exp_required` tinyint(4) NOT NULL,
  `ctc` float NOT NULL,
  `bond` float DEFAULT NULL,
  `wposition` tinyint(4) NOT NULL,
  `follow_up` date DEFAULT NULL,
  `edu_crt` tinyint(4) NOT NULL,
  `curr_status` tinyint(4) DEFAULT NULL,
  `next_act` tinyint(4) DEFAULT NULL,
  `next_date` timestamp NULL DEFAULT NULL,
  `pass_out_year_req` int(11) DEFAULT NULL,
  `gap_req` tinyint(4) DEFAULT NULL,
  `creation_datec` timestamp NULL DEFAULT NULL,
  `tpoid` int(11) DEFAULT NULL,
  `joining_criteria` int(11) NOT NULL,
  `gstnumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive`
--

LOCK TABLES `drive` WRITE;
/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
INSERT INTO `drive` VALUES (55,'TCS',4,6,40000,0,2,'2020-01-28',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'32AKLHG3333B5Z8'),(56,'INFOSYS',4,8,500000,1,1,'2020-01-20',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'72AKLHG3333A5Z9'),(57,'GreenlightTech',4,10,800000,0,3,'2020-01-08',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'80AHGJG3333A4Z6'),(58,'Westry',5,5,600000,0,3,'2020-02-26',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'16AuyHG3333B5Z7');
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud`
--

DROP TABLE IF EXISTS `drive_stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_stud` (
  `dsid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `st_id` int(11) DEFAULT NULL,
  `ceation_date` timestamp NULL DEFAULT NULL,
  `tpoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`dsid`),
  KEY `m` (`tpoid`),
  KEY `s_idx` (`did`),
  CONSTRAINT `m` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s` FOREIGN KEY (`did`) REFERENCES `drive` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud`
--

LOCK TABLES `drive_stud` WRITE;
/*!40000 ALTER TABLE `drive_stud` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud_tr`
--

DROP TABLE IF EXISTS `drive_stud_tr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_stud_tr` (
  `dsrid` int(11) NOT NULL,
  `did` int(11) NOT NULL,
  `st_id` int(11) NOT NULL,
  `tpoid` int(11) NOT NULL,
  `survived_status` tinyint(4) NOT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`dsrid`),
  KEY `h` (`tpoid`),
  KEY `d_idx` (`did`),
  KEY `g_idx` (`did`),
  CONSTRAINT `g` FOREIGN KEY (`did`) REFERENCES `drive` (`did`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `h` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud_tr`
--

LOCK TABLES `drive_stud_tr` WRITE;
/*!40000 ALTER TABLE `drive_stud_tr` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud_tr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_track`
--

DROP TABLE IF EXISTS `drive_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_track` (
  `tr_id` int(11) NOT NULL,
  `did` int(11) DEFAULT NULL,
  `dstatus` tinyint(4) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT NULL,
  `tpoid` int(11) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `no_of_students` int(11) DEFAULT NULL,
  PRIMARY KEY (`tr_id`),
  KEY `c` (`tpoid`),
  KEY `d_idx` (`did`),
  CONSTRAINT `c` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `d` FOREIGN KEY (`did`) REFERENCES `drive` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_track`
--

LOCK TABLES `drive_track` WRITE;
/*!40000 ALTER TABLE `drive_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registration` (
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES ('yogesh','upadhyay','yogesh19','abc@123');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpo`
--

DROP TABLE IF EXISTS `tpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tpo` (
  `tpoid` int(11) NOT NULL,
  `tpo_name` varchar(50) NOT NULL,
  `tpo_email` varchar(50) NOT NULL,
  `tpo_username` varchar(50) NOT NULL,
  `tpo_password` varchar(50) NOT NULL,
  `creation_date` timestamp NOT NULL,
  `tpo_role` tinyint(4) NOT NULL,
  PRIMARY KEY (`tpoid`),
  UNIQUE KEY `tpo_name` (`tpo_name`),
  UNIQUE KEY `tpo_email` (`tpo_email`),
  UNIQUE KEY `tpo_username` (`tpo_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpo`
--

LOCK TABLES `tpo` WRITE;
/*!40000 ALTER TABLE `tpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tpo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'thinkquotienttracker'
--

--
-- Dumping routines for database 'thinkquotienttracker'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-01 14:38:26
