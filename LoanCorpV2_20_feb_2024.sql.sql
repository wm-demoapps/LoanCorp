-- MariaDB dump 10.19  Distrib 10.6.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: loancorpv2
-- ------------------------------------------------------
-- Server version	10.6.12-MariaDB-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `loancorpv2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `loancorpv2` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */;

USE `loancorpv2`;

--
-- Table structure for table `comm_trail`
--

DROP TABLE IF EXISTS `comm_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comm_trail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_application_id` int(11) DEFAULT NULL,
  `comm_type` varchar(255) DEFAULT NULL,
  `comm_desc` longtext DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  `triggered_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comm_trail_TO_loan_apYGnUg` (`loan_application_id`),
  CONSTRAINT `FK_comm_trail_TO_loan_apYGnUg` FOREIGN KEY (`loan_application_id`) REFERENCES `loan_application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `credit_details`
--

DROP TABLE IF EXISTS `credit_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_history_id` int(11) DEFAULT NULL,
  `credit_type` varchar(255) DEFAULT NULL,
  `credit_amt` int(11) DEFAULT NULL,
  `credit_limit` int(11) DEFAULT NULL,
  `ssn_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_credit_details_TO_creeeJu6` (`credit_history_id`),
  CONSTRAINT `FK_credit_details_TO_creeeJu6` FOREIGN KEY (`credit_history_id`) REFERENCES `credit_history` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `credit_history`
--

DROP TABLE IF EXISTS `credit_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_details_id` int(11) DEFAULT NULL,
  `credit_score` int(11) DEFAULT NULL,
  `score_date` date DEFAULT NULL,
  `previous_score` int(11) DEFAULT NULL,
  `repayment_score` int(11) DEFAULT NULL,
  `monthly_income` int(11) DEFAULT NULL,
  `credit_history_duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_credit_history_TO_cusSisZj` (`customer_details_id`),
  CONSTRAINT `FK_credit_history_TO_cusSisZj` FOREIGN KEY (`customer_details_id`) REFERENCES `customer_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer_details`
--

DROP TABLE IF EXISTS `customer_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `ssn_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `doc_extracted_data`
--

DROP TABLE IF EXISTS `doc_extracted_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doc_extracted_data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) DEFAULT NULL,
  `w2_ein_no` varchar(255) DEFAULT NULL,
  `w2_wages` int(11) DEFAULT NULL,
  `w2_state` varchar(255) DEFAULT NULL,
  `w2_zip` varchar(255) DEFAULT NULL,
  `w2_address` varchar(255) DEFAULT NULL,
  `w2_ssn_no` varchar(255) DEFAULT NULL,
  `dl_no` varchar(255) DEFAULT NULL,
  `doc_type` varchar(255) DEFAULT NULL,
  `pa_no` varchar(255) DEFAULT NULL,
  `pa_issue_date` date DEFAULT NULL,
  `pa_expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_doc_extracted_data_TOR7rmU` (`document_id`),
  CONSTRAINT `FK_doc_extracted_data_TOR7rmU` FOREIGN KEY (`document_id`) REFERENCES `document` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `loan_application_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `la_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_documents_TO_loan_appS16zL` (`la_id`),
  CONSTRAINT `FK_documents_TO_loan_appS16zL` FOREIGN KEY (`la_id`) REFERENCES `loan_application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kyc`
--

DROP TABLE IF EXISTS `kyc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kyc` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `loan_application_id` int(11) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `start_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `status` varchar(255) DEFAULT NULL,
  `kyc_image` longblob DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loan_application`
--

DROP TABLE IF EXISTS `loan_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cd_id` int(11) DEFAULT NULL,
  `creation_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ld_id` int(11) DEFAULT NULL,
  `loan_type` varchar(255) DEFAULT NULL,
  `customer_details_id` int(11) DEFAULT NULL,
  `loan_details_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_loan_application_TO_l3laqe` (`loan_details_id`),
  KEY `FK_loan_application_TO_cqVNQl` (`customer_details_id`),
  CONSTRAINT `FK_loan_application_TO_cqVNQl` FOREIGN KEY (`customer_details_id`) REFERENCES `customer_details` (`id`),
  CONSTRAINT `FK_loan_application_TO_l3laqe` FOREIGN KEY (`loan_details_id`) REFERENCES `loan_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loan_details`
--

DROP TABLE IF EXISTS `loan_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `default_probability` int(11) DEFAULT NULL,
  `emi_freq` varchar(255) DEFAULT NULL,
  `interest_amt` int(11) DEFAULT NULL,
  `interest_rate` int(11) DEFAULT NULL,
  `tenure` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loan_offers`
--

DROP TABLE IF EXISTS `loan_offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_offers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `la_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `validity_period` int(11) DEFAULT NULL,
  `loan_application_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_loan_offers_TO_loan_akQOjW` (`la_id`),
  CONSTRAINT `FK_loan_offers_TO_loan_akQOjW` FOREIGN KEY (`la_id`) REFERENCES `loan_application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `loan_officer`
--

DROP TABLE IF EXISTS `loan_officer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_officer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fname` varchar(255) DEFAULT NULL,
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `login_details`
--

DROP TABLE IF EXISTS `login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `last_login` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_login_details_TO_custKpuP5` (`customer_id`),
  CONSTRAINT `FK_login_details_TO_custKpuP5` FOREIGN KEY (`customer_id`) REFERENCES `customer_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'loancorpv2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-20 12:13:16
