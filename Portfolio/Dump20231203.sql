CREATE DATABASE  IF NOT EXISTS `portfolio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `portfolio`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: portfolio
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `chatNo` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `firsttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'m01','你好','這是我的第一篇測試文','2023-12-01 08:26:19','2023-12-01 08:27:12'),(2,'m01','你好','這是我的第一篇測試文','2023-12-01 08:26:19','2023-12-01 08:27:12'),(3,'m01','嗨','這\r\n是\r\n第\r\n二\r\n篇\r\n測\r\n試','2023-12-01 08:26:19','2023-12-01 08:27:12'),(6,'m01','嗨','測試修改','2023-12-01 08:26:19','2023-12-01 08:27:12'),(7,'m02','喔喔喔喔','我很好','2023-12-01 08:26:19','2023-12-01 08:27:12'),(8,'m15','菜菜子','今天天氣晴','2023-12-01 08:26:19','2023-12-01 08:27:12'),(14,'m15','今天新增商城功能','新品上市 趕緊去看!!!!!!!!','2023-12-01 08:26:19','2023-12-01 08:27:12'),(38,'m01','作品1','今天更新完我的第一個作品內容，\r\n這是用spring boot做的 網頁排版可能沒有到很華麗 請見諒，\r\n製作是從留言板開始製作，收藏內容的想法來自各大社群，後續開始製作商城部分，\r\n剛開始有些迷茫，不知該從何下手，參考網上其他人的想法，才找到屬於我的方式。\r\n最後的遊戲，是老師在課堂出的作業，我覺得不錯所以就新增進來了。','2023-12-03 04:49:29','2023-12-03 04:49:29');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameanswer`
--

DROP TABLE IF EXISTS `gameanswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameanswer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `answernub` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameanswer`
--

LOCK TABLES `gameanswer` WRITE;
/*!40000 ALTER TABLE `gameanswer` DISABLE KEYS */;
INSERT INTO `gameanswer` VALUES (12,'8432'),(13,'6529'),(14,'8531'),(15,'5917'),(16,'6238'),(17,'8964'),(18,'5386'),(19,'1695'),(20,'3698'),(21,'3627'),(22,'7619'),(23,'9657'),(24,'7538'),(25,'2385'),(26,'9741'),(27,'5613'),(28,'9286'),(29,'9672'),(30,'9742'),(31,'8956'),(32,'2659'),(33,'3297'),(34,'1653'),(35,'6275'),(36,'1634'),(37,'8397'),(38,'9732'),(39,'5641'),(40,'3149'),(41,'3175'),(42,'7694'),(43,'5274'),(44,'2539'),(45,'1795'),(46,'4732'),(47,'7264'),(48,'3748'),(49,'8569'),(50,'8321'),(51,'5698'),(52,'1345'),(53,'1653'),(54,'1342'),(55,'2584'),(56,'9518'),(57,'5128'),(58,'5281'),(59,'4971'),(60,'5716'),(61,'7549'),(62,'1725'),(63,'7352'),(64,'5932'),(65,'1642'),(66,'1368'),(67,'8632');
/*!40000 ALTER TABLE `gameanswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameplayer`
--

DROP TABLE IF EXISTS `gameplayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gameplayer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `playernub` varchar(45) DEFAULT NULL,
  `a` int DEFAULT NULL,
  `b` int DEFAULT NULL,
  `reno` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameplayer`
--

LOCK TABLES `gameplayer` WRITE;
/*!40000 ALTER TABLE `gameplayer` DISABLE KEYS */;
INSERT INTO `gameplayer` VALUES (53,'1234',1,1,1),(54,'3627',1,2,2),(55,'4567',0,1,3),(56,'3627',1,2,4),(57,'3627',1,2,5),(58,'0000',0,0,6),(59,'000',NULL,NULL,NULL),(60,'0000',NULL,NULL,NULL),(61,'1234',NULL,NULL,NULL);
/*!40000 ALTER TABLE `gameplayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `like`
--

DROP TABLE IF EXISTS `like`;
/*!50001 DROP VIEW IF EXISTS `like`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `like` AS SELECT 
 1 AS `id`,
 1 AS `username`,
 1 AS `name`,
 1 AS `subject`,
 1 AS `content`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `likechat`
--

DROP TABLE IF EXISTS `likechat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likechat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `chatNo` varchar(45) DEFAULT NULL,
  `chatId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likechat`
--

LOCK TABLES `likechat` WRITE;
/*!40000 ALTER TABLE `likechat` DISABLE KEYS */;
INSERT INTO `likechat` VALUES (107,'text','m01',36),(110,'text','m01',38);
/*!40000 ALTER TABLE `likechat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `memberNo` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'m01','text','123','測試','0'),(2,'m02','aaa','123','學者','000'),(6,'m3','asd','123','杏光','00'),(7,'m7','kkk','123','和亮中山','000'),(14,'14','adsds','123','nnn','0'),(15,'m15','root','123','璋瑤','0');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `number`
--

DROP TABLE IF EXISTS `number`;
/*!50001 DROP VIEW IF EXISTS `number`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `number` AS SELECT 
 1 AS `id`,
 1 AS `username`,
 1 AS `memberNo`,
 1 AS `name`,
 1 AS `subject`,
 1 AS `content`,
 1 AS `firsttime`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `porder`
--

DROP TABLE IF EXISTS `porder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `porder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(45) DEFAULT NULL,
  `porderNo` varchar(45) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `imgNo` varchar(45) DEFAULT NULL,
  `mode` varchar(45) DEFAULT NULL,
  `items` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `porder`
--

LOCK TABLES `porder` WRITE;
/*!40000 ALTER TABLE `porder` DISABLE KEYS */;
INSERT INTO `porder` VALUES (1,'Iphone','01',3000,'1','15pro 64G','手機'),(2,'Samsung','02',2500,'2','Galaxy A54 5G','手機'),(3,'OPPO','03',2000,'3','Reno8 Z 5G','手機'),(4,'MSI','04',4000,'4','GE78 HX 13V','電腦'),(5,'asus','05',3000,'5','Vivobook 15 (X1502)','電腦'),(6,'acer','06',2000,'6','Aspire Vero','電腦'),(7,'PS5','07',3000,'7','超讚','電動'),(8,'Xbox','08',3500,'8','Serice X','電動'),(9,'switch','09',2500,'9','Nintendo Switch™（OLED款式）主機［HEG-001］','電動'),(10,'滑鼠','10',500,'10','G502 HERO','其他'),(11,'鍵盤','11',250,'11','V65 巨浪 65% RGB 英文機械式鍵盤','其他'),(12,'耳機','12',100,'12','無線藍牙頭戴式耳機 ( BTE-3860)','其他');
/*!40000 ALTER TABLE `porder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopcart`
--

DROP TABLE IF EXISTS `shopcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopcart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `memberNo` varchar(45) DEFAULT NULL,
  `porderNo` varchar(45) DEFAULT NULL,
  `shop_amount` int DEFAULT NULL,
  `shop_num` int DEFAULT NULL,
  `shop_sum` int DEFAULT NULL,
  `firsttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopcart`
--

LOCK TABLES `shopcart` WRITE;
/*!40000 ALTER TABLE `shopcart` DISABLE KEYS */;
INSERT INTO `shopcart` VALUES (10,'m01','07',3000,2,6000,'2023-11-30 11:20:48','2023-12-01 08:13:21'),(13,'m01','10',500,4,2000,'2023-11-30 13:35:21','2023-12-02 17:50:27'),(14,'m01','08',3500,1,3500,'2023-11-30 13:38:33','2023-11-30 13:46:37'),(16,'m01','11',250,2,500,'2023-11-30 13:43:03','2023-12-01 08:13:33'),(17,'m02','01',3000,1,3000,'2023-11-30 13:55:51','2023-11-30 13:55:51'),(18,'m15','01',3000,1,3000,'2023-11-30 14:01:14','2023-11-30 14:01:14'),(19,'m15','10',500,1,500,'2023-11-30 14:01:17','2023-11-30 14:01:17'),(20,'m15','02',2500,1,2500,'2023-11-30 14:02:11','2023-11-30 14:02:11'),(25,'m01','01',3000,1,3000,'2023-12-02 17:49:48','2023-12-02 17:50:17');
/*!40000 ALTER TABLE `shopcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `spcar`
--

DROP TABLE IF EXISTS `spcar`;
/*!50001 DROP VIEW IF EXISTS `spcar`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `spcar` AS SELECT 
 1 AS `id`,
 1 AS `imgNo`,
 1 AS `username`,
 1 AS `name`,
 1 AS `product`,
 1 AS `shop_amount`,
 1 AS `shop_num`,
 1 AS `shop_sum`,
 1 AS `firsttime`,
 1 AS `mode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `text`
--

DROP TABLE IF EXISTS `text`;
/*!50001 DROP VIEW IF EXISTS `text`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `text` AS SELECT 
 1 AS `id`,
 1 AS `username`,
 1 AS `name`,
 1 AS `subject`,
 1 AS `content`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `like`
--

/*!50001 DROP VIEW IF EXISTS `like`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `like` AS select `likechat`.`id` AS `id`,`likechat`.`username` AS `username`,`member`.`name` AS `name`,`chat`.`subject` AS `subject`,`chat`.`content` AS `content` from (`member` join (`chat` join `likechat`)) where ((`member`.`memberNo` = `likechat`.`chatNo`) and (`chat`.`id` = `likechat`.`chatId`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `number`
--

/*!50001 DROP VIEW IF EXISTS `number`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `number` AS select `chat`.`id` AS `id`,`member`.`username` AS `username`,`member`.`memberNo` AS `memberNo`,`member`.`name` AS `name`,`chat`.`subject` AS `subject`,`chat`.`content` AS `content`,`chat`.`firsttime` AS `firsttime` from (`member` join `chat` on((`member`.`memberNo` = `chat`.`chatNo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `spcar`
--

/*!50001 DROP VIEW IF EXISTS `spcar`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `spcar` AS select `shopcart`.`id` AS `id`,`porder`.`imgNo` AS `imgNo`,`member`.`username` AS `username`,`member`.`name` AS `name`,`porder`.`product` AS `product`,`shopcart`.`shop_amount` AS `shop_amount`,`shopcart`.`shop_num` AS `shop_num`,`shopcart`.`shop_sum` AS `shop_sum`,`shopcart`.`firsttime` AS `firsttime`,`porder`.`mode` AS `mode` from ((`shopcart` join `member`) join `porder`) where ((`shopcart`.`memberNo` = `member`.`memberNo`) and (`shopcart`.`porderNo` = `porder`.`porderNo`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `text`
--

/*!50001 DROP VIEW IF EXISTS `text`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `text` AS select `chat`.`id` AS `id`,`member`.`username` AS `username`,`member`.`name` AS `name`,`chat`.`subject` AS `subject`,`chat`.`content` AS `content` from (`chat` left join `member` on((`member`.`memberNo` = `chat`.`chatNo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-03 12:57:28
