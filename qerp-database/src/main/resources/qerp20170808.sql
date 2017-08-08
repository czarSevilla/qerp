-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qerp
-- ------------------------------------------------------
-- Server version	5.5.56-log

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
-- Table structure for table `address_mx`
--

DROP TABLE IF EXISTS `address_mx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_mx` (
  `id_address` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `zip_code` int(10) unsigned NOT NULL,
  `state` varchar(60) NOT NULL,
  `city` varchar(60) DEFAULT NULL,
  `suburb` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_mx`
--

LOCK TABLES `address_mx` WRITE;
/*!40000 ALTER TABLE `address_mx` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_mx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id_client` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id_company` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_currency` int(10) unsigned NOT NULL,
  `id_language` int(10) unsigned NOT NULL,
  `name` varchar(200) NOT NULL,
  `prefix` varchar(45) NOT NULL,
  PRIMARY KEY (`id_company`),
  UNIQUE KEY `prefix_UNIQUE` (`prefix`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_brand_currency1_idx` (`id_currency`),
  KEY `fk_company_language1_idx` (`id_language`),
  CONSTRAINT `fk_brand_currency1` FOREIGN KEY (`id_currency`) REFERENCES `currency` (`id_currency`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_language1` FOREIGN KEY (`id_language`) REFERENCES `language` (`id_language`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,1,1,'Quality and Knowledge','QAK'),(17,2,2,'pepsi','pspq'),(19,1,2,'laquesea','lkma'),(20,1,1,'nueva','nueva');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `id_currency` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `currency_iso` varchar(45) NOT NULL,
  `name_es_mx` varchar(45) NOT NULL,
  `name_en_us` varchar(45) NOT NULL,
  PRIMARY KEY (`id_currency`),
  UNIQUE KEY `currency_iso_UNIQUE` (`currency_iso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'MXN','Peso Mexicano','Mexican Peso'),(2,'USD','Dolar Americano','American Dollar'),(4,'asd','qwe','asd');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document_type`
--

DROP TABLE IF EXISTS `document_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document_type` (
  `id_document_type` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(45) NOT NULL,
  `name_en_us` varchar(45) NOT NULL,
  PRIMARY KEY (`id_document_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_type`
--

LOCK TABLES `document_type` WRITE;
/*!40000 ALTER TABLE `document_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `document_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id_employee` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_company` int(10) unsigned NOT NULL,
  `number_employee` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `start_date` date NOT NULL,
  `profile_picture` varchar(45) DEFAULT NULL,
  `id_job_title` int(10) unsigned NOT NULL,
  `active` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `birthday` date DEFAULT NULL,
  `place_birth` varchar(45) DEFAULT NULL,
  `tin` varchar(30) DEFAULT NULL,
  `curp` varchar(25) DEFAULT NULL,
  `ssn` varchar(30) DEFAULT NULL,
  `home_phone` int(10) unsigned DEFAULT NULL,
  `emergy_phone` int(10) unsigned DEFAULT NULL,
  `cellphone` int(10) unsigned DEFAULT NULL,
  `corporate_email` varchar(50) DEFAULT NULL,
  `personal_email` varchar(50) DEFAULT NULL,
  `id_gender` int(10) unsigned NOT NULL,
  `id_nationality` int(10) unsigned NOT NULL,
  `id_marital_status` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee`),
  UNIQUE KEY `number_employee_UNIQUE` (`number_employee`),
  KEY `fk_employee_brand_idx` (`id_company`),
  KEY `fk_job_title_idx` (`id_job_title`),
  KEY `fk_marital_status_idx` (`id_marital_status`),
  KEY `fk_gender_idx` (`id_gender`),
  KEY `fk_nationality_idx` (`id_nationality`),
  CONSTRAINT `fk_employee_company` FOREIGN KEY (`id_company`) REFERENCES `company` (`id_company`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gender` FOREIGN KEY (`id_gender`) REFERENCES `gender` (`id_gender`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_job_title` FOREIGN KEY (`id_job_title`) REFERENCES `job_title` (`id_job_title`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_marital_status` FOREIGN KEY (`id_marital_status`) REFERENCES `marital_status` (`id_marital_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nationality` FOREIGN KEY (`id_nationality`) REFERENCES `nationality` (`id_nationality`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,'QAK-1','Cesar Alejandro','Sevilla Hernandez','2017-01-09','qak_1.png',1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,1),(2,1,'QAK-2','Adriana','Torres Alanis','2017-07-17','qak_2.png',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,1,1),(3,1,'QAK-3','Angel','Pimentel Arrieta','2017-07-11','qak_3.png',3,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,2),(4,1,'QAK-4','Irvin Yovani','Damian Montalban','2017-07-10','qak_4.png',4,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,3),(5,1,'QAK-5','Angeles','Flores Guerra','2017-07-10','qak_5.png',2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,1,1),(6,1,'QAK-6','Jesus Enrique','Neri Lozada','2017-07-10','qak_6.png',5,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,2),(7,1,'QAK-7','Sergio','Sanchez Flores','2017-06-30','qak_7.png',6,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_address`
--

DROP TABLE IF EXISTS `employee_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_address` (
  `id_employee_address` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `state` varchar(60) NOT NULL,
  `zip_code` int(10) unsigned NOT NULL,
  `city` varchar(60) NOT NULL,
  `surbub` varchar(60) NOT NULL,
  `street` varchar(60) NOT NULL,
  `st_number` varchar(10) DEFAULT NULL,
  `apt_number` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_employee_address`),
  KEY `fk_employee_address_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_address_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_address`
--

LOCK TABLES `employee_address` WRITE;
/*!40000 ALTER TABLE `employee_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_assignment`
--

DROP TABLE IF EXISTS `employee_assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_assignment` (
  `id_employee_assignment` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `id_client` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_assignment`),
  KEY `fk_employee_assignment_employee1_idx` (`id_employee`),
  KEY `fk_employee_assignment_client1_idx` (`id_client`),
  CONSTRAINT `fk_employee_assignment_client1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_assignment_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_assignment`
--

LOCK TABLES `employee_assignment` WRITE;
/*!40000 ALTER TABLE `employee_assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_certification`
--

DROP TABLE IF EXISTS `employee_certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_certification` (
  `id_employee_certification` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `certification_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_employee_certification`),
  KEY `Fk_employee_idx` (`id_employee`),
  CONSTRAINT `Fk_employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_certification`
--

LOCK TABLES `employee_certification` WRITE;
/*!40000 ALTER TABLE `employee_certification` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_course`
--

DROP TABLE IF EXISTS `employee_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_course` (
  `id_employee_course` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_employee_course`),
  KEY `fk_employee_curse_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_curse_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_course`
--

LOCK TABLES `employee_course` WRITE;
/*!40000 ALTER TABLE `employee_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_document`
--

DROP TABLE IF EXISTS `employee_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_document` (
  `id_employee_document` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `id_document_type` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_document`),
  KEY `fk_employee_document_employee1_idx` (`id_employee`),
  KEY `fk_employee_document_document_type1_idx` (`id_document_type`),
  CONSTRAINT `fk_employee_document_document_type1` FOREIGN KEY (`id_document_type`) REFERENCES `document_type` (`id_document_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_document_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_document`
--

LOCK TABLES `employee_document` WRITE;
/*!40000 ALTER TABLE `employee_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_education`
--

DROP TABLE IF EXISTS `employee_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_education` (
  `id_employee_education` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `schooling` varchar(30) NOT NULL,
  `academic` varchar(80) NOT NULL,
  `profession` varchar(45) NOT NULL,
  `years_experience` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_education`),
  KEY `fk_employee_education_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_education_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_education`
--

LOCK TABLES `employee_education` WRITE;
/*!40000 ALTER TABLE `employee_education` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_language`
--

DROP TABLE IF EXISTS `employee_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_language` (
  `id_employee_language` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `name` varchar(45) NOT NULL,
  `porc_write` int(10) unsigned NOT NULL,
  `porc_speak` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_language`),
  KEY `fk_employee_language_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_language_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_language`
--

LOCK TABLES `employee_language` WRITE;
/*!40000 ALTER TABLE `employee_language` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_recruiting`
--

DROP TABLE IF EXISTS `employee_recruiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_recruiting` (
  `id_employee_recruiting` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_recruiting`),
  KEY `fk_employee_recruiting_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_recruiting_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_recruiting`
--

LOCK TABLES `employee_recruiting` WRITE;
/*!40000 ALTER TABLE `employee_recruiting` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_recruiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_reference`
--

DROP TABLE IF EXISTS `employee_reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_reference` (
  `id_employee_reference` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `name` varchar(80) NOT NULL,
  `phone` int(11) NOT NULL,
  `type` varchar(20) NOT NULL,
  `relationship` varchar(40) NOT NULL,
  PRIMARY KEY (`id_employee_reference`),
  KEY `fk_employee_reference_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_reference_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_reference`
--

LOCK TABLES `employee_reference` WRITE;
/*!40000 ALTER TABLE `employee_reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_salary`
--

DROP TABLE IF EXISTS `employee_salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_salary` (
  `id_employee_salary` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_salary`),
  KEY `fk_employee_salary_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_salary_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_salary`
--

LOCK TABLES `employee_salary` WRITE;
/*!40000 ALTER TABLE `employee_salary` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_skill`
--

DROP TABLE IF EXISTS `employee_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_skill` (
  `id_employee_skill` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  `id_skill` int(10) unsigned NOT NULL,
  `id_skill_type` int(10) unsigned NOT NULL,
  `years_experience` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_skill`),
  KEY `fk_employee_skill_employee1_idx` (`id_employee`),
  KEY `fk_employee_skill_skill1_idx` (`id_skill`),
  KEY `fk_employee_skill_skill2_idx` (`id_skill_type`),
  CONSTRAINT `fk_employee_skill_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_skill_skill1` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id_skill`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_skill_skill2` FOREIGN KEY (`id_skill_type`) REFERENCES `skill_type` (`id_skill_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skill`
--

LOCK TABLES `employee_skill` WRITE;
/*!40000 ALTER TABLE `employee_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_vacations`
--

DROP TABLE IF EXISTS `employee_vacations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_vacations` (
  `id_employee_vacations` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_employee` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_employee_vacations`),
  KEY `fk_employee_vacations_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_employee_vacations_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_vacations`
--

LOCK TABLES `employee_vacations` WRITE;
/*!40000 ALTER TABLE `employee_vacations` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_vacations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gender` (
  `id_gender` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(30) NOT NULL,
  `name_es_eu` varchar(30) NOT NULL,
  PRIMARY KEY (`id_gender`),
  UNIQUE KEY `name_es_mx_UNIQUE` (`name_es_mx`),
  UNIQUE KEY `name_es_eu_UNIQUE` (`name_es_eu`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Masculino','Male'),(2,'Femenino','Female');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_title`
--

DROP TABLE IF EXISTS `job_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_title` (
  `id_job_title` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title_es_mx` varchar(100) NOT NULL,
  `title_en_us` varchar(100) NOT NULL,
  PRIMARY KEY (`id_job_title`),
  UNIQUE KEY `title_es_mx_UNIQUE` (`title_es_mx`),
  UNIQUE KEY `title_en_us_UNIQUE` (`title_en_us`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_title`
--

LOCK TABLES `job_title` WRITE;
/*!40000 ALTER TABLE `job_title` DISABLE KEYS */;
INSERT INTO `job_title` VALUES (1,'Gerente de Aseguramiento de Calidad de Software','Software Quality Assurance Manager'),(2,'Analista de Requerimientos','Business Analyst'),(3,'Becario de Aseguramiento de Calidad de Software','Software Quality Assurance Beginner'),(4,'Desarrollador BI/ETL','BI/ETL Developer'),(5,'Analista .NET','.NET Analyst'),(6,'Soporte Operativo','Technical Support Specialist');
/*!40000 ALTER TABLE `job_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `id_language` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `country_iso` varchar(45) NOT NULL,
  `lang_iso` varchar(45) NOT NULL,
  `name_es_mx` varchar(45) NOT NULL,
  `name_en_us` varchar(45) NOT NULL,
  PRIMARY KEY (`id_language`),
  UNIQUE KEY `lang_unique` (`country_iso`,`lang_iso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'MX','es','Español','Spanish'),(2,'US','en','Inglés','English'),(4,'ES','ES','Castellano','Spanish'),(5,'BR','BR','Portugués Brasileño ','Brazilian Portuguese');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marital_status`
--

DROP TABLE IF EXISTS `marital_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marital_status` (
  `id_marital_status` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(30) NOT NULL,
  `name_es_eu` varchar(30) NOT NULL,
  PRIMARY KEY (`id_marital_status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marital_status`
--

LOCK TABLES `marital_status` WRITE;
/*!40000 ALTER TABLE `marital_status` DISABLE KEYS */;
INSERT INTO `marital_status` VALUES (1,'soltero','single'),(2,'casado','married'),(3,'divorciado','divorced');
/*!40000 ALTER TABLE `marital_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nationality`
--

DROP TABLE IF EXISTS `nationality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nationality` (
  `id_nationality` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(30) NOT NULL,
  `name_es_eu` varchar(30) NOT NULL,
  PRIMARY KEY (`id_nationality`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nationality`
--

LOCK TABLES `nationality` WRITE;
/*!40000 ALTER TABLE `nationality` DISABLE KEYS */;
INSERT INTO `nationality` VALUES (1,'Mexicana','Mexican');
/*!40000 ALTER TABLE `nationality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_incident`
--

DROP TABLE IF EXISTS `payroll_incident`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll_incident` (
  `id_payroll_incident` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_payroll_incident_type` int(10) unsigned NOT NULL,
  `id_employee` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_payroll_incident`),
  KEY `fk_payroll_incident_payroll_incident_type1_idx` (`id_payroll_incident_type`),
  KEY `fk_payroll_incident_employee1_idx` (`id_employee`),
  CONSTRAINT `fk_payroll_incident_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_payroll_incident_payroll_incident_type1` FOREIGN KEY (`id_payroll_incident_type`) REFERENCES `payroll_incident_type` (`id_payroll_incident_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_incident`
--

LOCK TABLES `payroll_incident` WRITE;
/*!40000 ALTER TABLE `payroll_incident` DISABLE KEYS */;
/*!40000 ALTER TABLE `payroll_incident` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payroll_incident_type`
--

DROP TABLE IF EXISTS `payroll_incident_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payroll_incident_type` (
  `id_payroll_incident_type` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `spanish_name` varchar(50) NOT NULL,
  `english_name` varchar(50) NOT NULL,
  `effect` varchar(50) NOT NULL,
  PRIMARY KEY (`id_payroll_incident_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payroll_incident_type`
--

LOCK TABLES `payroll_incident_type` WRITE;
/*!40000 ALTER TABLE `payroll_incident_type` DISABLE KEYS */;
INSERT INTO `payroll_incident_type` VALUES (1,'Falta','Non-attendance','-'),(2,'retardo','be later','-'),(4,'falta','falta','+');
/*!40000 ALTER TABLE `payroll_incident_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_resource`
--

DROP TABLE IF EXISTS `physical_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_resource` (
  `id_physical_resource` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_company` int(10) unsigned NOT NULL,
  `id_physical_resource_type` int(10) unsigned NOT NULL,
  `register_date` date NOT NULL,
  PRIMARY KEY (`id_physical_resource`),
  KEY `fk_physical_resource_company1_idx` (`id_company`),
  KEY `fk_physical_resource_physical_resource_type1_idx` (`id_physical_resource_type`),
  CONSTRAINT `fk_physical_resource_company1` FOREIGN KEY (`id_company`) REFERENCES `company` (`id_company`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_physical_resource_physical_resource_type1` FOREIGN KEY (`id_physical_resource_type`) REFERENCES `physical_resource_type` (`id_physical_resource_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_resource`
--

LOCK TABLES `physical_resource` WRITE;
/*!40000 ALTER TABLE `physical_resource` DISABLE KEYS */;
INSERT INTO `physical_resource` VALUES (1,1,1,'2017-08-01'),(2,1,1,'2017-08-07'),(3,1,2,'2017-08-01'),(6,1,1,'2017-08-07');
/*!40000 ALTER TABLE `physical_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_resource_assignation`
--

DROP TABLE IF EXISTS `physical_resource_assignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_resource_assignation` (
  `id_physical_resource_assignation` int(11) NOT NULL,
  `id_employee` int(10) unsigned NOT NULL,
  `id_physical_resource` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_physical_resource_assignation`),
  KEY `fk_physical_resource_assignation_employee1_idx` (`id_employee`),
  KEY `fk_physical_resource_assignation_physical_resource1_idx` (`id_physical_resource`),
  CONSTRAINT `fk_physical_resource_assignation_employee1` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_physical_resource_assignation_physical_resource1` FOREIGN KEY (`id_physical_resource`) REFERENCES `physical_resource` (`id_physical_resource`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_resource_assignation`
--

LOCK TABLES `physical_resource_assignation` WRITE;
/*!40000 ALTER TABLE `physical_resource_assignation` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_resource_assignation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_resource_has_feature`
--

DROP TABLE IF EXISTS `physical_resource_has_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_resource_has_feature` (
  `id_physical_resource` int(10) unsigned NOT NULL,
  `id_resource_feature` int(10) unsigned NOT NULL,
  `id_physical_resource_has_feature` int(10) NOT NULL AUTO_INCREMENT,
  `value` varchar(90) NOT NULL,
  PRIMARY KEY (`id_physical_resource_has_feature`),
  KEY `fk_resource_feature_has_physical_resource_physical_resource_idx` (`id_physical_resource`),
  KEY `fk_resource_feature_has_physical_resource_resource_feature1_idx` (`id_resource_feature`),
  CONSTRAINT `fk_resource_feature_has_physical_resource_physical_resource1` FOREIGN KEY (`id_physical_resource`) REFERENCES `physical_resource` (`id_physical_resource`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_feature_has_physical_resource_resource_feature1` FOREIGN KEY (`id_resource_feature`) REFERENCES `resource_feature` (`id_resource_feature`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_resource_has_feature`
--

LOCK TABLES `physical_resource_has_feature` WRITE;
/*!40000 ALTER TABLE `physical_resource_has_feature` DISABLE KEYS */;
INSERT INTO `physical_resource_has_feature` VALUES (1,1,1,'Core i7'),(1,2,2,'2Gb'),(2,1,3,'valor1'),(2,2,4,'valor2'),(2,4,5,'valor3'),(6,1,6,'nuevo'),(6,2,7,'nuevo'),(6,4,8,'nuevo');
/*!40000 ALTER TABLE `physical_resource_has_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_resource_type`
--

DROP TABLE IF EXISTS `physical_resource_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_resource_type` (
  `id_physical_resource_type` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(45) NOT NULL,
  `name_en_us` varchar(45) NOT NULL,
  `picture` varchar(45) NOT NULL,
  PRIMARY KEY (`id_physical_resource_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_resource_type`
--

LOCK TABLES `physical_resource_type` WRITE;
/*!40000 ALTER TABLE `physical_resource_type` DISABLE KEYS */;
INSERT INTO `physical_resource_type` VALUES (1,'Laptop','Laptop','laptop.jpg'),(2,'Impresora','Printer','printer.jpg'),(3,'Monitor','Monitor','monitor.jpg');
/*!40000 ALTER TABLE `physical_resource_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_feature`
--

DROP TABLE IF EXISTS `resource_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_feature` (
  `id_resource_feature` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_physical_resource_type` int(10) unsigned NOT NULL,
  `feature_es_mx` varchar(45) NOT NULL,
  `feature_en_us` varchar(45) NOT NULL,
  PRIMARY KEY (`id_resource_feature`),
  KEY `fk_resource_feature_physical_resource_type1_idx` (`id_physical_resource_type`),
  CONSTRAINT `fk_resource_feature_physical_resource_type1` FOREIGN KEY (`id_physical_resource_type`) REFERENCES `physical_resource_type` (`id_physical_resource_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_feature`
--

LOCK TABLES `resource_feature` WRITE;
/*!40000 ALTER TABLE `resource_feature` DISABLE KEYS */;
INSERT INTO `resource_feature` VALUES (1,1,'Procesador','Processor'),(2,1,'Memoria','Memory'),(3,3,'monitor','monitor'),(4,1,'prueba','prueba');
/*!40000 ALTER TABLE `resource_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schooling`
--

DROP TABLE IF EXISTS `schooling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schooling` (
  `id_schooling` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_es_mx` varchar(30) NOT NULL,
  `name_es_eu` varchar(30) NOT NULL,
  PRIMARY KEY (`id_schooling`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schooling`
--

LOCK TABLES `schooling` WRITE;
/*!40000 ALTER TABLE `schooling` DISABLE KEYS */;
/*!40000 ALTER TABLE `schooling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_authorities`
--

DROP TABLE IF EXISTS `sec_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_authorities` (
  `id_sec_user` int(10) unsigned NOT NULL,
  `authority` varchar(20) NOT NULL,
  PRIMARY KEY (`id_sec_user`,`authority`),
  KEY `sec_permissions_fk2_idx` (`authority`),
  CONSTRAINT `sec_permissions_fk2` FOREIGN KEY (`authority`) REFERENCES `sec_permissions` (`id_sec_permission`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sec_users_fk2` FOREIGN KEY (`id_sec_user`) REFERENCES `sec_users` (`id_sec_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_authorities`
--

LOCK TABLES `sec_authorities` WRITE;
/*!40000 ALTER TABLE `sec_authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_modules`
--

DROP TABLE IF EXISTS `sec_modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_modules` (
  `id_sec_module` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description_es_mx` varchar(45) NOT NULL,
  `description_en_us` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sec_module`),
  UNIQUE KEY `description_es_mx_UNIQUE` (`description_es_mx`),
  UNIQUE KEY `description_en_us_UNIQUE` (`description_en_us`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_modules`
--

LOCK TABLES `sec_modules` WRITE;
/*!40000 ALTER TABLE `sec_modules` DISABLE KEYS */;
INSERT INTO `sec_modules` VALUES (1,'Seguridad','Security'),(2,'Administración de Catálogos','Catalogues Administration');
/*!40000 ALTER TABLE `sec_modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_permissions`
--

DROP TABLE IF EXISTS `sec_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_permissions` (
  `id_sec_permission` varchar(20) NOT NULL,
  `id_sec_module` int(10) unsigned NOT NULL,
  `description_es_mx` varchar(100) NOT NULL,
  `description_en_us` varchar(100) NOT NULL,
  `order_num` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_sec_permission`),
  UNIQUE KEY `description_es_mx_UNIQUE` (`description_es_mx`),
  UNIQUE KEY `description_en_us_UNIQUE` (`description_en_us`),
  KEY `sec_modules_fk1_idx` (`id_sec_module`),
  CONSTRAINT `sec_modules_fk1` FOREIGN KEY (`id_sec_module`) REFERENCES `sec_modules` (`id_sec_module`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_permissions`
--

LOCK TABLES `sec_permissions` WRITE;
/*!40000 ALTER TABLE `sec_permissions` DISABLE KEYS */;
INSERT INTO `sec_permissions` VALUES ('ROLE_C_CURRENCY',2,'Insertar en Catálogo de Monedas','Insert into Currencies Catalogue',6),('ROLE_C_JOB_TTL',2,'Insertar en Catálogo de Puestos','Insert into Job Titles Catalogue',2),('ROLE_D_CURRENCY',2,'Eliminar en Catálogo de Monedas','Delete on Currencies Catalogue',8),('ROLE_D_JOB_TTL',2,'Eliminar en Catálogo de Puestos','Delete on Job Titles Catalogue',4),('ROLE_R_CURRENCY',2,'Consultar Catálogo de Monedas','List Currencies Catalogue',5),('ROLE_R_JOB_TTL',2,'Consultar Catálogo de Puestos','List Job Titles Catalogue',1),('ROLE_U_CURRENCY',2,'Modificar en Catálogo de Monedas','Update on Currencies Catalogue',7),('ROLE_U_JOB_TTL',2,'Modificar en Catálogo de Puestos','Update on Job Titles Catalogue',3);
/*!40000 ALTER TABLE `sec_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_role_has_permissions`
--

DROP TABLE IF EXISTS `sec_role_has_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_role_has_permissions` (
  `id_sec_role` int(10) unsigned NOT NULL,
  `id_sec_permission` varchar(20) NOT NULL,
  PRIMARY KEY (`id_sec_role`,`id_sec_permission`),
  KEY `sec_permissions_fk1_idx` (`id_sec_permission`),
  CONSTRAINT `sec_permissions_fk1` FOREIGN KEY (`id_sec_permission`) REFERENCES `sec_permissions` (`id_sec_permission`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sec_roles_fk1` FOREIGN KEY (`id_sec_role`) REFERENCES `sec_roles` (`id_sec_role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_role_has_permissions`
--

LOCK TABLES `sec_role_has_permissions` WRITE;
/*!40000 ALTER TABLE `sec_role_has_permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_role_has_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_roles`
--

DROP TABLE IF EXISTS `sec_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_roles` (
  `id_sec_role` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description_es_mx` varchar(50) NOT NULL,
  `description_en_us` varchar(50) NOT NULL,
  PRIMARY KEY (`id_sec_role`),
  UNIQUE KEY `description_es_mx_UNIQUE` (`description_es_mx`),
  UNIQUE KEY `description_en_us_UNIQUE` (`description_en_us`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_roles`
--

LOCK TABLES `sec_roles` WRITE;
/*!40000 ALTER TABLE `sec_roles` DISABLE KEYS */;
INSERT INTO `sec_roles` VALUES (1,'Administrador General','Root Administrator'),(2,'Administrador de Empresa','Company Administrator'),(3,'Responsable de Recursos Humanos','Human Resource Manager'),(4,'Usuario de Recursos Humanos','Human Resource User');
/*!40000 ALTER TABLE `sec_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_user_has_roles`
--

DROP TABLE IF EXISTS `sec_user_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_user_has_roles` (
  `id_sec_user` int(10) unsigned NOT NULL,
  `id_sec_role` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_sec_user`,`id_sec_role`),
  KEY `sec_roles_fk2_idx` (`id_sec_role`),
  CONSTRAINT `sec_roles_fk2` FOREIGN KEY (`id_sec_role`) REFERENCES `sec_roles` (`id_sec_role`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sec_users_fk1` FOREIGN KEY (`id_sec_user`) REFERENCES `sec_users` (`id_sec_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_user_has_roles`
--

LOCK TABLES `sec_user_has_roles` WRITE;
/*!40000 ALTER TABLE `sec_user_has_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_user_has_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sec_users`
--

DROP TABLE IF EXISTS `sec_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sec_users` (
  `id_sec_user` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sec_username` varchar(50) NOT NULL,
  `sec_password` varchar(120) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `active` tinyint(1) unsigned NOT NULL DEFAULT '1',
  `block` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id_sec_user`),
  UNIQUE KEY `sec_username_UNIQUE` (`sec_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sec_users`
--

LOCK TABLES `sec_users` WRITE;
/*!40000 ALTER TABLE `sec_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `sec_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id_skill` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_skill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_type`
--

DROP TABLE IF EXISTS `skill_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_type` (
  `id_skill_type` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_skill_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_type`
--

LOCK TABLES `skill_type` WRITE;
/*!40000 ALTER TABLE `skill_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `skill_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-08 15:54:42
