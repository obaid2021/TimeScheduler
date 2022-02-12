-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: timeschedule
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `register_user`
--

DROP TABLE IF EXISTS `register_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register_user` (
  `username` varchar(50) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register_user`
--

LOCK TABLES `register_user` WRITE;
/*!40000 ALTER TABLE `register_user` DISABLE KEYS */;
INSERT INTO `register_user` VALUES ('','','','¸»Æ´ÁÆÇÈ·¹Å´È´Æ·¸','´Æ'),('A','','','¾«ª²­w¬±ª¾­±»Âzz°¶ª²µw¬¸¶','ª'),('Adilehsan17','ÂÇÊ','£ÆÑ¿Ì','¿ÂÇÊÃÆÑ¿ÌÅË¿ÇÊÁÍË','ÂÇÊÃÆÑ¿Ì'),('ArifTiktoker','ÏÆÃ',' Å¾ËÁÆÌ','ÂÅÐ¾ËÐÑÒÁÃÏ¾Ò¾ÐÁÂ','ÏÆÃ±ÆÈÑÌÈÂÏ'),('BholaRecord','¿«ª','ª¯²','«®¹§´¹º»ªt¬¸§s»§¹tª«','®µ²§«©µ¸ª'),('muhammadobaid','eyy|','gzy|8my','}y','b}IJK'),('Nasir69','_rz','\\yr[rr','vyrQu?wr>r?uv','_rzGJ'),('o','M','o','n','o'),('Q','k','v','QTTcQ',''),('RR','Z','Z','Z',''),('Saifu','drzw','f}}ry','rzw}}ry?wrzrQx~rz}?t~','rzwvv'),('x','¶','¶','¶','¶');
/*!40000 ALTER TABLE `register_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-12 21:12:16
