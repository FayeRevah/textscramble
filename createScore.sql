-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cst438
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `finalTime` longblob,
  `initials` longtext,
  `score` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `word` (
  `id` int(11) DEFAULT NULL,
  `word` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word`
--

LOCK TABLES `word` WRITE;
/*!40000 ALTER TABLE `word` DISABLE KEYS */;
INSERT INTO `word` VALUES (1,'wacky'),(2,'roll'),(3,'stomach'),(4,'cause'),(5,'statuesque'),(6,'trees'),(7,'unsuitable'),(8,'animated'),(9,'peaceful'),(10,'trick'),(11,'dear'),(12,'drawer'),(13,'far'),(14,'describe'),(15,'attract'),(16,'bead'),(17,'stir'),(18,'possess'),(19,'flap'),(20,'point'),(21,'spotted'),(22,'equable'),(23,'pretty'),(24,'unequaled'),(25,'abstracted'),(26,'enormous'),(27,'ground'),(28,'check'),(29,'popcorn'),(30,'hose'),(31,'nostalgic'),(32,'sulky'),(33,'squeeze'),(34,'crowded'),(35,'chubby'),(36,'lazy'),(37,'dusty'),(38,'bumpy'),(39,'ambitious'),(40,'rate'),(41,'iron'),(42,'tin'),(43,'heat'),(44,'jolly'),(45,'dust'),(46,'bell'),(47,'distinct'),(48,'level'),(49,'horn'),(50,'hall'),(51,'action'),(52,'identify'),(53,'bat'),(54,'key'),(55,'accessible'),(56,'reproduce'),(57,'snatch'),(58,'superb'),(59,'veil'),(60,'egg'),(61,'top'),(62,'goofy'),(63,'neck'),(64,'crayon'),(65,'wrist'),(66,'phone'),(67,'wine'),(68,'fresh'),(69,'burst'),(70,'political'),(71,'judge'),(72,'gruesome'),(73,'caption'),(74,'numerous'),(75,'tart'),(76,'shallow'),(77,'sheep'),(78,'driving'),(79,'craven'),(80,'black'),(81,'ready'),(82,'detail'),(83,'babies'),(84,'useless'),(85,'rock'),(86,'direful'),(87,'glorious'),(88,'value'),(89,'gabby'),(90,'cactus'),(91,'curtain'),(92,'synonymous'),(93,'tick'),(94,'license'),(95,'flashy'),(96,'fruit'),(97,'supply'),(98,'scribble'),(99,'consist'),(100,'science');
/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-26  9:08:38
