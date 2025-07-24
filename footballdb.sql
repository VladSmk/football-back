-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (arm64)
--
-- Host: localhost    Database: football
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `birth_date` datetime(6) NOT NULL,
  `experience_months` int NOT NULL DEFAULT '0',
  `team_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `players_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (55,'Ivan Petrov','1995-03-12 00:00:00.000000',120,1),(56,'Oleg Sidorov','1992-07-08 00:00:00.000000',150,3),(57,'Andriy Kovalenko','1998-11-20 00:00:00.000000',80,3),(58,'Serhiy Bondar','1994-05-15 00:00:00.000000',130,1),(59,'Volodymyr Kryk','1996-01-30 00:00:00.000000',100,1),(60,'Dmytro Yasyn','1997-09-10 00:00:00.000000',90,1),(61,'Yuriy Melnyk','1993-12-05 00:00:00.000000',140,1),(62,'Mykola Chorny','1999-04-22 00:00:00.000000',60,1),(63,'Pavlo Hryhor','2000-02-18 00:00:00.000000',50,1),(64,'Stepan Fedor','1991-10-07 00:00:00.000000',160,1),(65,'Ruslan Tkachenko','1996-06-14 00:00:00.000000',110,1),(66,'Bohdan Lisov','1998-08-28 00:00:00.000000',75,1),(67,'Maxym Lysenko','1994-03-03 00:00:00.000000',135,1),(68,'Anton Moroz','1993-02-25 00:00:00.000000',145,2),(69,'Yaroslav Savin','1997-11-11 00:00:00.000000',85,2),(70,'Denys Tkach','1995-07-19 00:00:00.000000',115,1),(71,'Vladyslav Orlov','1994-09-01 00:00:00.000000',130,2),(72,'Kseniya Bondik','2000-05-27 00:00:00.000000',55,2),(73,'Tetiana Zayets','1996-12-12 00:00:00.000000',105,2),(74,'Olena Rudy','1998-03-03 00:00:00.000000',70,3),(75,'Kateryna Boyko','1999-08-16 00:00:00.000000',65,3),(76,'Viktor Dudka','1992-10-30 00:00:00.000000',155,2),(77,'Mykhailo Levchenko','1995-06-09 00:00:00.000000',120,2),(78,'Nazar Hlushchenko','1997-01-21 00:00:00.000000',95,2),(79,'Petro Melnyk','1994-04-18 00:00:00.000000',132,3),(80,'Oksana Hryshko','1999-07-04 00:00:00.000000',68,3),(81,'Sergiy Koval','1996-02-14 00:00:00.000000',108,3),(82,'Liliya Nazar','1998-09-25 00:00:00.000000',72,3),(83,'Roman Khomenko','1993-11-02 00:00:00.000000',148,3),(84,'Iryna Polishchuk','2000-12-29 00:00:00.000000',52,3),(85,'Vadym Yurchenko','1997-05-13 00:00:00.000000',88,3),(86,'Marina Soloviova','1995-01-07 00:00:00.000000',125,3),(87,'Oleksandr Kramar','1992-08-21 00:00:00.000000',160,3),(88,'Nataliya Frolova','1996-03-30 00:00:00.000000',102,3),(89,'Ruslan Pavliuk','1998-10-11 00:00:00.000000',78,3),(90,'Anastasiya Dudko','1999-06-05 00:00:00.000000',60,1),(91,'Bob','2334-09-01 03:00:00.000000',30,1);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `commission_rate` double NOT NULL DEFAULT '0',
  `balance` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `teams_chk_1` CHECK ((`commission_rate` between 0.00 and 10.00))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Red Lions',0.05,319015),(2,'Blue Sharks',0.03,1383333),(3,'Green Eagles',0.04,1230769);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transfers`
--

DROP TABLE IF EXISTS `transfers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transfers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `player_id` int NOT NULL,
  `from_team_id` int NOT NULL,
  `to_team_id` int NOT NULL,
  `transfer_fee` double NOT NULL,
  `total_amount` int NOT NULL,
  `transfer_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_id` (`player_id`),
  KEY `from_team_id` (`from_team_id`),
  KEY `to_team_id` (`to_team_id`),
  CONSTRAINT `transfers_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `players` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transfers_ibfk_2` FOREIGN KEY (`from_team_id`) REFERENCES `teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `transfers_ibfk_3` FOREIGN KEY (`to_team_id`) REFERENCES `teams` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transfers`
--

LOCK TABLES `transfers` WRITE;
/*!40000 ALTER TABLE `transfers` DISABLE KEYS */;
INSERT INTO `transfers` VALUES (2,55,3,1,0.0425,2100000,'2025-07-24 19:47:33.385000'),(3,56,1,3,0.05,2727272,'2025-07-24 19:58:32.263000'),(4,57,1,3,0.05,1846153,'2025-07-24 20:02:17.299000'),(5,74,2,3,0.03,267037,'2025-07-24 20:31:56.350000'),(6,75,2,3,0.03,267800,'2025-07-24 20:36:11.581000'),(7,75,3,3,0.04,270400,'2025-07-24 20:36:36.901000'),(8,75,3,3,0.04,270400,'2025-07-24 20:36:46.579000'),(9,75,3,3,0.04,270400,'2025-07-24 20:36:53.150000'),(10,76,2,2,0.03,498906,'2025-07-24 21:08:55.083000'),(11,90,3,1,0.04,240000,'2025-07-24 21:18:40.523000'),(12,90,1,1,0.05,242307,'2025-07-24 21:31:56.267000'),(13,90,1,1,0.05,242307,'2025-07-24 21:32:10.921000'),(14,90,1,1,0.05,242307,'2025-07-24 21:32:32.613000'),(15,90,1,1,0.05,242307,'2025-07-24 21:33:53.524000'),(16,70,2,1,0.03,394833,'2025-07-24 21:57:56.534000');
/*!40000 ALTER TABLE `transfers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-24 22:01:33
