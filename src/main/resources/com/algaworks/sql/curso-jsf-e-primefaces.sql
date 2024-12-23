CREATE DATABASE  IF NOT EXISTS `cursojsfprimefaces` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cursojsfprimefaces`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: cursojsfprimefaces
-- ------------------------------------------------------
-- Server version	5.7.44-log

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
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_fantasia` varchar(80) NOT NULL,
  `razao_social` varchar(120) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `data_fundacao` date DEFAULT NULL,
  `ramo_atividade_id` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `faturamento` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnpj_UNIQUE` (`cnpj`),
  KEY `fk_ramo_atividade_empresa_1_idx` (`ramo_atividade_id`),
  CONSTRAINT `fk_ramo_atividade_empresa_1` FOREIGN KEY (`ramo_atividade_id`) REFERENCES `ramo_atividade` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Mercado do João','João Mercado e Distribuidor de Alimentos Ltda','70.311.193/0001-87','2009-03-02',1,'LTDA',NULL),(2,'Fale Mais','Fale Mais Telecom S.A.','52.822.994/0001-25','1997-12-10',2,'SA',NULL),(3,'Maria de Souza da Silva','Maria de Souza da Silva','41.952.519/0001-57','2014-10-15',3,'MEI',NULL),(4,'Gomes Inovação','José Fernando Gomes EIRELI ME','16.134.777/0001-89','2009-03-02',4,'EIRELI',NULL);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ramo_atividade`
--

DROP TABLE IF EXISTS `ramo_atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ramo_atividade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ramo_atividade`
--

LOCK TABLES `ramo_atividade` WRITE;
/*!40000 ALTER TABLE `ramo_atividade` DISABLE KEYS */;
INSERT INTO `ramo_atividade` VALUES (1,'Distribuição de alimentos'),(2,'Telecomunicações'),(3,'Vestuário'),(4,'Lavanderia'),(5,'Gráfica'),(6,'Mecânica'),(7,'Turismo'),(8,'Saúde'),(9,'Educação'),(10,'Lazer');
/*!40000 ALTER TABLE `ramo_atividade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 14:10:39
