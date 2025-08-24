CREATE DATABASE  IF NOT EXISTS `match_analyzer` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `match_analyzer`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: match_analyzer
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `footballers`
--

DROP TABLE IF EXISTS `footballers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `footballers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `team` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `overall_rating` int NOT NULL,
  `physical_form` int NOT NULL,
  `mental_clarity` int NOT NULL,
  `deployable` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `team_idx` (`team`),
  KEY `idx_footballers_name_surname_team` (`name`,`surname`,`team`),
  CONSTRAINT `team` FOREIGN KEY (`team`) REFERENCES `teams` (`name_team`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `footballers`
--

LOCK TABLES `footballers` WRITE;
/*!40000 ALTER TABLE `footballers` DISABLE KEYS */;
INSERT INTO `footballers` VALUES (1,'Yann','Sommer','Inter','1988-12-17',87,100,75,1),(2,'Josep','Martinez','Inter','1998-05-27',75,100,75,1),(3,'Alessandro','Bastoni','Inter','1999-04-13',87,100,75,1),(4,'Benjamin','Pavard','Inter','1996-03-28',84,100,75,1),(5,'Stefan','De Vrij','Inter','1992-02-05',83,100,75,1),(6,'Francesco','Acerbi','Inter','1988-02-10',84,100,75,1),(7,'Federico','Di Marco','Inter','1997-11-10',84,100,75,1),(8,'Carlos','Augusto','Inter','1999-01-07',79,100,75,1),(9,'Denzel','Dumfries','Inter','1996-04-18',82,100,75,1),(10,'Matteo','Darmian','Inter','1989-12-02',77,100,75,1),(11,'Hakan','Calhanoglu','Inter','1994-02-08',86,100,75,1),(12,'Kristjan','Asllani','Inter','2002-03-09',75,100,75,1),(13,'Nicolo','Barella','Inter','1997-02-07',87,100,75,1),(14,'Davide','Frattesi','Inter','1999-09-22',81,100,75,1),(15,'Piotr','Zielinski','Inter','1994-05-20',83,100,75,1),(16,'Henrikh','Mkhitaryan','Inter','1989-01-21',80,100,75,1),(17,'Lautaro','Martinez','Inter','1997-08-22',89,100,75,1),(18,'Marcus','Thuram','Inter','1997-08-06',83,100,75,1),(19,'Mehdi','Taremi','Inter','1992-07-18',78,100,75,1),(20,'Marko','Arnautovic','Inter','1989-04-19',79,100,75,1),(21,'Michele','Di Gregorio','Juventus','1997-07-27',80,100,75,1),(22,'Mattia','Perin','Juventus','1992-11-10',79,100,75,1),(23,'Gleison','Bremer','Juventus','1997-03-18',86,100,75,1),(24,'Pierre','Kalulu','Juventus','2000-06-05',79,100,75,1),(25,'Federico','Gatti','Juventus','1998-06-24',78,100,75,1),(26,'Andrea','Cambiaso','Juventus','2000-02-20',79,100,75,1),(27,'Juan','Cabal','Juventus','2001-01-08',74,100,75,1),(28,'Manuel','Locatelli','Juventus','1998-01-08',83,100,75,1),(29,'Lloyd','Kelly','Juventus','1998-10-06',77,100,75,1),(30,'Douglas','Luiz','Juventus','1998-05-09',82,100,75,1),(31,'Khephren','Thuram','Juventus','2001-03-26',80,100,75,1),(32,'Weston','McKennie','Juventus','1998-10-28',79,100,75,1),(33,'Teun','Koopmeiners','Juventus','1998-02-28',83,100,75,1),(34,'Kenan','Yildiz','Juventus','2005-05-04',80,100,75,1),(35,'Francisco','Conceicao','Juventus','2002-12-14',77,100,75,1),(36,'Nico','Gonzalez','Juventus','1998-04-06',80,100,75,1),(37,'Timothy','Weah','Juventus','2000-02-22',77,100,75,1),(38,'Dusan','Vlahovic','Juventus','2000-01-28',84,100,75,1),(39,'Randal','Kolo Muani','Juventus','1998-12-05',82,100,75,1),(40,'Arkadiusz','Milik','Juventus','1994-02-28',77,100,75,1),(41,'Mike','Maignan','Milan','1995-07-03',87,100,75,1),(42,'Marco','Sportiello','Milan','1992-05-10',75,100,75,1),(43,'Fikayo','Tomori','Milan','1997-12-19',83,100,75,1),(44,'Malick','Thiaw','Milan','2001-10-08',78,100,75,1),(45,'Matteo','Gabbia','Milan','1999-10-21',77,100,75,1),(46,'Emerson','Royale','Milan','1999-01-14',76,100,75,1),(47,'Strahinja','Pavlovic','Milan','2001-05-24',77,100,75,1),(48,'Theo','Hernandez','Milan','1997-10-06',87,100,75,1),(49,'Kyle','Walker','Milan','1990-05-20',84,100,75,1),(50,'Alessandro','Florenzi','Milan','1991-03-11',77,100,75,1),(51,'Youssouf','Fofana','Milan','1999-01-10',81,100,75,1),(52,'Yunus','Musah','Milan','2002-11-29',75,100,75,1),(53,'Tijjani','Reijnders','Milan','1998-07-29',82,100,75,1),(54,'Ruben','Loftus-Cheek','Milan','1996-01-23',81,100,75,1),(55,'Warren','Bondo','Milan','2003-09-15',74,100,75,1),(56,'Rafael','Leao','Milan','1999-06-10',87,100,75,1),(57,'Riccardo','Sottil','Milan','1999-06-03',75,100,75,1),(58,'Christian','Pulisic','Milan','1998-09-18',83,100,75,1),(59,'Samuel','Chukwueze','Milan','1999-05-22',80,100,75,1),(60,'Joao','Felix','Milan','1999-11-10',83,100,75,1),(61,'Santiago','Gimenez','Milan','2001-04-18',81,100,75,1),(62,'Tammy','Abraham','Milan','1997-10-02',79,100,75,1),(63,'Yann','Bisseck','Inter','2000-11-29',78,100,75,1),(73,'Alex','Meret','Napoli','1997-03-22',82,100,75,1),(74,'Simone','Scuffet','Napoli','1996-05-31',75,100,75,1),(75,'Alessandro','Buongiorno','Napoli','1999-06-06',81,100,75,1),(76,'Amir','Rrahmani','Napoli','1994-02-24',80,100,75,1),(77,'Rafa','Marin','Napoli','2002-05-19',74,100,75,1),(78,'Juan','Jesus','Napoli','1991-06-10',75,100,75,1),(79,'Mathias','Oliveira','Napoli','1997-10-31',77,100,75,1),(80,'Leonardo','Spinazzola','Napoli','1993-03-25',78,100,75,1),(81,'Giovanni','Di Lorenzo','Napoli','1993-08-04',83,100,75,1),(82,'Pasquale','Mazzocchi','Napoli','1995-07-27',74,100,75,1),(83,'Stanislav','Lobotka','Napoli','1994-11-25',83,100,75,1),(84,'Billy','Gilmour','Napoli','2001-06-11',77,100,75,1),(85,'Scott','McTominay','Napoli','1996-12-08',81,100,75,1),(86,'Frank','Anguissa','Napoli','1995-11-16',83,100,75,1),(87,'Philip','Billing','Napoli','1996-06-11',77,100,75,1),(88,'Noah','Okafor','Napoli','2000-05-24',79,100,75,1),(89,'David','Neres','Napoli','1997-03-03',81,100,75,1),(90,'Cyril','Ngonge','Napoli','2000-05-26',75,100,75,1),(91,'Matteo','Politano','Napoli','1993-08-03',80,100,75,1),(92,'Giacomo','Raspadori','Napoli','2000-02-18',79,100,75,1),(93,'Romelu','Lukaku','Napoli','1993-05-13',82,100,75,1),(94,'Giovanni','Simeone','Napoli','1995-07-05',77,100,75,1),(95,'Mile','Svilar','Roma','1999-08-27',82,100,75,1),(96,'Pierluigi','Gollini','Roma','1995-03-18',77,100,75,1),(97,'Evan','Ndicka','Roma','1999-08-20',79,100,75,1),(98,'Gianluca','Mancini','Roma','1996-04-17',83,100,75,1),(99,'Mats','Hummels','Roma','1988-12-16',84,100,75,1),(100,'Victor','Nelsson','Roma','1998-10-14',76,100,75,1),(101,'Jose','Angelino','Roma','1997-01-04',80,100,75,1),(102,'Devyne','Rensch','Roma','2003-01-18',77,100,75,1),(103,'Zeki','Celik','Roma','1997-02-17',76,100,75,1),(104,'Saud','Abdulhamid','Roma','1999-07-18',77,100,75,1),(105,'Bryan','Cristante','Roma','1995-03-03',80,100,75,1),(106,'Leandro','Paredes','Roma','1994-06-29',80,100,75,1),(107,'Manu','Kone','Roma','2001-05-17',81,100,75,1),(108,'Niccolo','Pisilli','Roma','2004-09-23',75,100,75,1),(109,'Lorenzo','Pellegrini','Roma','1996-06-19',81,100,75,1),(110,'Tommaso','Baldanzi','Roma','2003-05-23',76,100,75,1),(111,'Stephan','El Shaarawy','Roma','1992-10-27',79,100,75,1),(112,'Matias','Solule','Roma','2003-04-15',78,100,75,1),(113,'Alexis','Saelemaekers','Roma','1999-06-27',78,100,75,1),(114,'Paulo','Dybala','Roma','1993-11-15',86,100,75,1),(115,'Artem','Dovbyk','Roma','1997-06-21',83,100,75,1),(116,'Eldor','Shomurodov','Roma','1995-06-29',75,100,75,1),(117,'David','De Gea','Fiorentina','1990-11-07',85,100,75,1),(118,'Pietro','Terraciano','Fiorentina','1990-03-08',79,100,75,1),(119,'Pietro','Comuzzo','Fiorentina','2005-02-20',77,100,75,1),(120,'Luca','Ranieri','Fiorentina','1999-04-23',75,100,75,1),(121,'Marin','Pongracic','Fiorentina','1997-09-11',75,100,75,1),(122,'Pablo','Mari','Fiorentina','1993-08-31',74,100,75,1),(123,'Matias','Moreno','Fiorentina','2003-09-24',68,100,75,1),(124,'Robin','Gosens','Fiorentina','1994-07-05',79,100,75,1),(125,'Fabiano','Parisi','Fiorentina','2000-11-09',75,100,75,1),(126,'Cordeiro','Dodo','Fiorentina','1998-11-17',77,100,75,1),(127,'Yacine','Adli','Fiorentina','2000-07-29',77,100,75,1),(128,'Rolando','Mandragora','Fiorentina','1997-06-29',77,100,75,1),(129,'Danilo','Cataldi','Fiorentina','1994-08-06',77,100,75,1),(130,'Nicolo','Fagioli','Fiorentina','2001-02-12',76,100,75,1),(131,'Amir','Richardson','Fiorentina','2002-01-24',74,100,75,1),(132,'Micheal','Folorunsho','Fiorentina','1998-02-07',76,100,75,1),(144,'Nicolo','Zaniolo','Fiorentina','1999-07-02',77,100,75,1),(145,'Lucas','Beltran','Fiorentina','2001-03-29',76,100,75,1),(146,'Andrea','Colpani','Fiorentina','1999-05-11',79,100,75,1),(147,'Albert','Gudmundsson','Fiorentina','1997-06-15',80,100,75,1),(148,'Moise','Kean','Fiorentina','2000-02-28',80,100,75,1);
/*!40000 ALTER TABLE `footballers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineup_players`
--

DROP TABLE IF EXISTS `lineup_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineup_players` (
  `lineup_id` int NOT NULL,
  `footballer_id` int NOT NULL,
  `position` int NOT NULL,
  PRIMARY KEY (`lineup_id`,`footballer_id`),
  KEY `fk_id_footballer_idx` (`footballer_id`),
  CONSTRAINT `fk_id_footballer` FOREIGN KEY (`footballer_id`) REFERENCES `footballers` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_id_lineup` FOREIGN KEY (`lineup_id`) REFERENCES `lineups` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineup_players`
--

LOCK TABLES `lineup_players` WRITE;
/*!40000 ALTER TABLE `lineup_players` DISABLE KEYS */;
INSERT INTO `lineup_players` VALUES (1,1,1),(1,3,2),(1,4,3),(1,6,4),(1,7,8),(1,9,9),(1,11,5),(1,13,6),(1,15,7),(1,18,11),(1,19,10),(2,21,1),(2,23,2),(2,25,3),(2,26,4),(2,28,5),(2,31,6),(2,33,7),(2,34,8),(2,36,9),(2,37,10),(2,38,11),(3,41,1),(3,45,3),(3,47,4),(3,48,2),(3,49,5),(3,51,6),(3,52,8),(3,53,7),(3,56,9),(3,58,10),(3,61,11),(4,73,1),(4,75,3),(4,76,4),(4,80,2),(4,81,5),(4,83,6),(4,85,8),(4,86,7),(4,89,9),(4,91,10),(4,93,11),(5,95,1),(5,97,4),(5,98,3),(5,99,2),(5,101,7),(5,106,6),(5,107,5),(5,109,10),(5,113,8),(5,114,9),(5,115,11),(6,117,1),(6,119,2),(6,120,3),(6,121,4),(6,124,7),(6,126,8),(6,129,5),(6,130,6),(6,146,10),(6,147,9),(6,148,11);
/*!40000 ALTER TABLE `lineup_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineups`
--

DROP TABLE IF EXISTS `lineups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineups` (
  `id` int NOT NULL AUTO_INCREMENT,
  `team` varchar(100) NOT NULL,
  `formation` varchar(45) NOT NULL,
  `play_style` varchar(100) NOT NULL,
  `marking_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_team_lineup_idx` (`team`),
  CONSTRAINT `fk_team_lineup` FOREIGN KEY (`team`) REFERENCES `teams` (`name_team`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineups`
--

LOCK TABLES `lineups` WRITE;
/*!40000 ALTER TABLE `lineups` DISABLE KEYS */;
INSERT INTO `lineups` VALUES (1,'Inter','3-5-2','Direct Play','Zonal'),(2,'Juventus','4-5-1','Wing Play','Zonal'),(3,'Milan','4-3-3','Direct Play','Zonal'),(4,'Napoli','4-3-3','Wing Play','Zonal'),(5,'Roma','3-4-2-1','Wing Play','Man-to-Man'),(6,'Fiorentina','3-4-2-1','Direct Play','Zonal');
/*!40000 ALTER TABLE `lineups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matches` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_team` varchar(100) NOT NULL,
  `away_team` varchar(100) NOT NULL,
  `match_date` date NOT NULL,
  `match_time` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `home_team` (`home_team`,`away_team`,`match_date`) /*!80000 INVISIBLE */,
  KEY `away_team` (`away_team`),
  KEY `idx_matches_date_time` (`match_date`,`match_time`),
  CONSTRAINT `matches_ibfk_1` FOREIGN KEY (`home_team`) REFERENCES `teams` (`name_team`),
  CONSTRAINT `matches_ibfk_2` FOREIGN KEY (`away_team`) REFERENCES `teams` (`name_team`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (2,'Juventus','Inter','2025-09-23','18:30:00'),(3,'Inter','Milan','2025-09-30','20:45:00'),(4,'Napoli','Fiorentina','2025-09-22','20:45:00'),(5,'Milan','Roma','2025-09-22','18:30:00'),(6,'Napoli','Juventus','2025-09-29','15:00:00'),(7,'Milan','Fiorentina','2025-10-06','12:30:00'),(8,'Milan','Juventus','2025-10-13','20:45:00'),(9,'Napoli','Milan','2025-10-19','18:30:00');
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_affinities`
--

DROP TABLE IF EXISTS `role_affinities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_affinities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `footballer_id` int NOT NULL,
  `role` enum('GK','LB','CB','RB','CDM','CM','CAM','LM','RM','LW','RW','ST') NOT NULL,
  `affinity` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `footballer_id_idx` (`footballer_id`),
  CONSTRAINT `footballer_id` FOREIGN KEY (`footballer_id`) REFERENCES `footballers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_affinities`
--

LOCK TABLES `role_affinities` WRITE;
/*!40000 ALTER TABLE `role_affinities` DISABLE KEYS */;
INSERT INTO `role_affinities` VALUES (1,1,'GK',1),(2,2,'GK',1),(3,3,'CB',1),(4,3,'LB',0.4),(5,4,'CB',1),(6,4,'RB',0.7),(7,5,'CB',1),(8,6,'CB',1),(9,7,'CB',0.4),(10,7,'LB',0.8),(11,7,'LM',1),(12,8,'CB',0.6),(13,8,'LB',0.8),(14,8,'LM',1),(15,9,'RB',0.8),(16,9,'RM',1),(17,10,'RB',1),(18,10,'RM',0.5),(19,10,'CB',0.7),(20,11,'CM',0.7),(21,11,'CDM',1),(22,12,'CDM',1),(23,12,'CM',0.5),(24,13,'CM',1),(25,13,'CDM',0.7),(26,14,'CM',1),(27,14,'CAM',0.5),(28,15,'CM',1),(29,15,'CAM',0.7),(30,16,'CM',1),(31,16,'CAM',0.5),(32,17,'ST',1),(33,17,'LW',0.4),(34,17,'RW',0.3),(35,18,'ST',1),(36,18,'LW',0.7),(37,18,'RW',0.5),(38,19,'ST',1),(39,20,'ST',1),(40,21,'GK',1),(41,22,'GK',1),(42,23,'CB',1),(43,24,'CB',0.7),(44,24,'RB',1),(45,24,'LB',0.5),(46,25,'CB',1),(47,26,'RB',0.7),(48,26,'RM',0.8),(49,26,'LB',1),(50,26,'LM',0.9),(51,27,'CB',0.7),(52,27,'LB',1),(53,28,'CDM',1),(54,28,'CM',0.7),(55,29,'CB',1),(56,29,'RB',0.7),(57,30,'CDM',1),(58,30,'CM',0.7),(59,31,'CDM',0.7),(60,31,'CM',1),(61,32,'CM',1),(62,32,'CDM',0.7),(63,32,'CAM',0.3),(64,33,'CM',1),(65,33,'CDM',0.5),(66,33,'CAM',0.7),(67,34,'RW',1),(68,34,'RM',0.9),(69,34,'CAM',0.5),(70,34,'LW',0.7),(71,34,'LM',0.4),(72,35,'LW',0.7),(73,35,'LM',0.4),(74,35,'RW',1),(75,35,'RM',0.8),(76,36,'LW',1),(77,36,'LM',0.9),(78,36,'RW',0.7),(79,36,'RM',0.4),(80,36,'ST',0.3),(81,37,'RW',0.5),(82,37,'RM',0.7),(83,37,'RB',1),(84,38,'ST',1),(85,39,'ST',1),(86,39,'LW',0.7),(87,39,'RW',0.5),(88,40,'ST',1),(89,41,'GK',1),(90,42,'GK',1),(91,43,'CB',1),(92,44,'CB',1),(93,44,'RB',0.7),(94,45,'CB',1),(95,46,'LB',1),(96,46,'LM',0.7),(97,47,'CB',1),(98,48,'LM',0.7),(99,48,'LB',1),(100,49,'CB',0.5),(101,49,'RB',1),(102,49,'RM',0.6),(103,50,'RB',1),(104,50,'RM',0.6),(105,50,'LB',0.7),(106,50,'LM',0.5),(107,51,'CM',0.5),(108,51,'CDM',1),(109,53,'CM',1),(110,53,'CDM',0.5),(111,53,'CAM',0.7),(112,54,'CM',1),(113,54,'CDM',0.5),(114,54,'CAM',0.7),(115,55,'CDM',0.7),(116,55,'CM',1),(117,52,'CM',1),(118,52,'RM',0.5),(119,56,'LW',1),(120,56,'LM',0.7),(121,57,'RW',1),(122,57,'LW',0.7),(123,57,'ST',0.3),(124,57,'RM',0.8),(125,57,'LM',0.5),(126,58,'RM',0.7),(127,58,'RW',1),(128,59,'RW',1),(129,59,'LW',0.7),(130,59,'RM',0.5),(131,59,'LM',0.4),(132,60,'ST',0.7),(133,60,'LW',0.5),(134,60,'CAM',1),(135,61,'ST',1),(136,62,'ST',1),(137,73,'GK',1),(138,74,'GK',1),(139,75,'CB',1),(140,76,'CB',1),(141,77,'CB',1),(142,78,'CB',1),(143,78,'LB',0.7),(144,79,'LB',1),(145,79,'LM',0.7),(146,80,'LB',1),(147,80,'LM',0.7),(148,80,'RB',0.8),(149,81,'RB',1),(150,81,'RM',0.7),(151,82,'RB',1),(152,82,'RM',0.7),(153,83,'CDM',1),(154,83,'CM',0.7),(155,84,'CM',0.9),(156,84,'CDM',1),(157,85,'CM',1),(158,85,'CDM',0.7),(159,85,'CAM',0.5),(160,86,'CM',1),(161,86,'CDM',0.7),(162,87,'CDM',0.5),(163,87,'CM',1),(164,87,'CAM',0.7),(165,88,'LW',1),(166,88,'RW',0.7),(167,88,'ST',0.8),(168,89,'LW',1),(169,89,'RW',0.9),(170,89,'CAM',0.4),(171,90,'ST',0.5),(172,90,'CAM',0.7),(173,90,'RW',1),(174,91,'RW',1),(175,91,'RM',0.7),(176,92,'ST',1),(177,92,'CAM',0.5),(178,92,'LW',0.7),(179,93,'ST',1),(180,94,'ST',1),(181,95,'GK',1),(182,96,'GK',1),(183,97,'CB',1),(184,98,'CB',1),(185,99,'CB',1),(186,100,'CB',1),(187,63,'CB',1),(188,101,'LM',1),(189,101,'LB',0.7),(190,101,'CB',0.4),(191,102,'RB',1),(192,102,'LB',0.7),(193,102,'CB',0.4),(194,103,'RB',1),(195,103,'RM',0.7),(196,103,'CB',0.4),(197,104,'CB',0.4),(198,104,'RM',0.7),(199,104,'RB',1),(200,105,'CB',0.4),(201,105,'CDM',1),(202,105,'CM',0.8),(203,106,'CM',1),(204,106,'CDM',0.9),(205,107,'CAM',0.5),(206,107,'CM',1),(207,107,'CDM',0.7),(208,108,'CM',1),(209,108,'CAM',0.7),(210,109,'CAM',1),(211,109,'CM',0.8),(212,109,'CDM',0.5),(213,110,'CAM',1),(214,110,'CM',0.7),(215,110,'RW',0.6),(216,111,'LM',0.9),(217,111,'LW',1),(218,112,'RM',0.9),(219,112,'RW',1),(220,112,'CAM',0.8),(221,113,'RM',1),(222,113,'RW',0.7),(223,114,'ST',0.7),(224,114,'CAM',1),(225,115,'ST',1),(226,116,'ST',1),(227,117,'GK',1),(228,118,'GK',1),(229,119,'CB',1),(230,120,'CB',1),(231,121,'CB',1),(232,120,'LB',0.7),(233,121,'RB',0.7),(234,122,'CB',1),(235,123,'CB',1),(236,124,'LB',0.9),(237,124,'LM',1),(238,125,'LB',1),(239,125,'RB',0.8),(240,125,'LM',0.7),(241,125,'RM',0.5),(242,126,'RB',1),(243,126,'RM',0.8),(244,127,'CAM',0.5),(245,127,'CDM',1),(246,127,'CM',0.7),(247,128,'CDM',1),(248,128,'CM',0.9),(249,129,'CM',0.7),(250,129,'CAM',0.5),(251,129,'CDM',1),(252,130,'CM',1),(253,130,'CDM',0.8),(254,130,'CAM',0.5),(255,131,'CDM',0.7),(256,131,'CM',1),(257,132,'CAM',0.7),(258,132,'CDM',0.5),(259,132,'CM',1),(260,144,'RW',0.7),(261,144,'ST',0.6),(262,144,'CAM',1),(263,145,'ST',0.7),(264,145,'CAM',1),(265,146,'CAM',1),(266,146,'LW',0.6),(267,146,'RW',0.7),(268,147,'LW',0.7),(269,147,'CAM',1),(270,147,'ST',0.8),(271,148,'ST',1);
/*!40000 ALTER TABLE `role_affinities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `name_team` varchar(100) NOT NULL,
  `stadium` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  PRIMARY KEY (`name_team`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES ('Fiorentina','Stadio Artemio Franchi','Firenze'),('Inter','Stadio Giuseppe Meazza','Milano'),('Juventus','Allianz Stadium','Torino'),('Milan','San Siro','Milano'),('Napoli','Stadio Diego Armando Maradona','Napoli'),('Roma','Stadio Olimpico','Roma');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT 'Hash della password',
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `role` enum('COACH','TRAINER','FOOTBALLER') NOT NULL,
  `team` varchar(100) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`email`),
  KEY `fk_users_team` (`team`),
  CONSTRAINT `fk_users_team` FOREIGN KEY (`team`) REFERENCES `teams` (`name_team`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('andrea.ferrari@gmail.com','$2a$10$jDYywdN0q74RVL2vyDTPb.5lh70PxlhEgLifoZcfTXOCczXxG4f/C','Andrea','Ferrari','TRAINER','Juventus','2025-03-16 12:36:55'),('antonio.conte@gmail.com','$2a$10$slD2phoB.JPp.mdS8mO5SuD/td4MId1l331hoWCTPJqcMi8bfKJv6','Antonio','Conte','COACH','Napoli','2025-03-16 12:37:58'),('claudio.ranieri@gmail.com','$2a$10$6xdFVYBgecQuxAs7x1cx4O0AfD11yZ7yunG3v85dwhg1SCdeLwpzq','Claudio','Ranieri','COACH','Roma','2025-03-16 12:39:41'),('luca.bianchi@gmail.com','$2a$10$uBhVXnTi/9VHQCJKjk2.tOcxFKcLumt6xLpTGJM.xrggnMsJVYcZS','Luca','Bianchi','TRAINER','Milan','2025-03-16 12:33:52'),('marco.rossi@gmail.com','$2a$10$7OdM1IFNIhXNtLsvIavgZujCbBHJOk1CsWoapH2atgEOnFvRMX5QG','Marco','Rossi','TRAINER','Inter','2025-03-16 12:31:18'),('maria.gallo@gmail.com','$2a$10$puh6YMrPIxyrpLJ3qH9dWuF09Muwn29XT4jNp0.RIGUkkRBvHnwAm','Maria','Gallo','TRAINER','Fiorentina','2025-03-16 12:42:24'),('mario.lori@gmail.com','$2a$10$jtDQsaMEA5sQa41pmuHAJuWos626VCLaCdTcutQQAXRaX7g6BhQd.','Mario','Lori','FOOTBALLER','Napoli','2025-03-16 12:43:30'),('matteo.esposito@gmail.com','$2a$10$0UlQbhcVKb0sIgf4FEncROGYfByB1g6v1Lr0af3epHTGr.undAV1S','Matteo','Esposito','TRAINER','Napoli','2025-03-16 12:38:50'),('sergio.conceicao@gmail.com','$2a$10$I/bZAB8iiDguP8wX56XAm.8Rsnxl1NnJyYBVU8sPKx75T67mCPB7.','Sergio','Conceicao','COACH','Milan','2025-03-16 12:32:54'),('simone.inzaghi@gmail.com','$2a$10$LWjs4dlPB7Rodk6CicHSOOe3cI6/Zdood/R.MMZC0f1DSHKWbR.CW','Simone','Inzaghi','COACH','Inter','2025-03-16 12:29:51'),('sofia.marino@gmail.com','$2a$10$hWcuXt02iBZV6CoBge7La.Hy1XRP5pRT7/YuSHGefoa08Du/iRxMW','Sofia','Marino','TRAINER','Roma','2025-03-16 12:40:41'),('thiago.motta@gmail.com','$2a$10$uAoYCsL0AMm1ZvVK5MHKEOuSzD92IiqnXVYdOpAX.do4LfhcYyy56','Thiago','Motta','COACH','Juventus','2025-03-16 12:35:58'),('vincenzo.italiano@gmail.com','$2a$10$Nvc8ou57I1y1qQQAaatvce9KzPnSOJd8oAYlXpACO6yHkrzim8pp.','Vincenzo','Italiano','COACH','Fiorentina','2025-03-16 12:41:32');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-07 10:06:34
