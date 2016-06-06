-- MySQL dump 10.13  Distrib 5.7.12, for Linux (x86_64)
--
-- Host: localhost    Database: sqltinhchau
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1

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
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmuc` (
  `id_dm` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `detail` text COLLATE utf8_unicode_ci,
  `super_id` int(5) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `delete_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_dm`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Cửa Nhôm XingFa','<p>Cửa Nh&ocirc;m XingFa</p>\r\n',0,NULL,NULL,'2016-06-06 16:21:23'),(2,'Cửa nhựa lõi thép','<p>Cửa nhựa l&otilde;i th&eacute;p</p>\r\n',0,NULL,NULL,'2016-06-06 16:27:20'),(3,'Mặt dựng nhôm kính',NULL,0,NULL,NULL,NULL),(4,'Cầu thang-lan can kính',NULL,0,NULL,NULL,NULL),(5,'Cửa Kính bản lề sàn',NULL,0,NULL,NULL,NULL),(6,'Cửa, vách kính phòng tắm',NULL,0,NULL,NULL,NULL),(7,'Cửa đi mở quay',NULL,1,NULL,NULL,NULL),(8,'Cửa đi mở trượt',NULL,1,NULL,NULL,NULL),(9,'Cửa đi 1 cách mở quay',NULL,7,NULL,NULL,NULL),(10,'Cửa đi 2 cánh mở quay',NULL,7,NULL,NULL,NULL),(11,'Cửa đi 4 cánh mở quay',NULL,7,NULL,NULL,NULL),(12,'Cửa abc',NULL,0,'2016-06-03 12:18:55','2016-06-03 14:21:37',NULL),(13,'Cửa xyz',NULL,0,'2016-06-03 12:21:59','2016-06-03 14:23:33',NULL),(14,'Cửa 1 cánh',NULL,2,'2016-06-03 12:22:40',NULL,NULL),(15,'Cửa 1 cánh mở xoay',NULL,14,'2016-06-03 12:23:51',NULL,'2016-06-03 12:31:12'),(16,'Cửa 4 cánh abc',NULL,7,'2016-06-03 14:24:10','2016-06-03 14:24:15',NULL);
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dichvu` (
  `id_dv` int(2) NOT NULL AUTO_INCREMENT,
  `name_dv` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `detail` text CHARACTER SET utf8,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_dv`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'Dịch vụ 1','img39.png','<p>dịch vụ 1</p>\r\n','2016-06-01 15:32:25','2016-06-01 15:59:06',NULL),(2,'Dịch Vụ 2','img781.png','<p>Dịch vụ 2</p>\r\n','2016-06-01 15:34:51',NULL,NULL),(3,'Dịch vụ 3','img353.png','','2016-06-01 16:41:00',NULL,NULL);
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sanpham` (
  `id_sp` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `prominent` int(1) DEFAULT '0',
  `super_ID` int(5) DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_sp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Sản phẩm 1','img529.png',1,1,'2016-06-04 14:07:40','2016-06-04 14:36:48',NULL),(2,'Sản phẩm 2','img785.jpeg',0,1,'2016-06-06 16:39:44','2016-06-06 16:41:22',NULL);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slider`
--

DROP TABLE IF EXISTS `slider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slider` (
  `id_sd` int(2) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_sd`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
INSERT INTO `slider` VALUES (1,'slider1','slider1.jpg',NULL,NULL,NULL),(2,'slider2','slider2.jpg',NULL,NULL,NULL),(3,'slider3','slider3.jpg',NULL,NULL,NULL),(5,'img149316323900193862.png','img149316323900193862.png','2016-05-31 16:16:35',NULL,'2016-05-31 16:24:10'),(6,'img3325405040326992744.jpeg','img3325405040326992744.jpeg','2016-05-31 00:00:00',NULL,'2016-05-31 16:27:25'),(7,'img1294489879553130521.jpeg','img1294489879553130521.jpeg','2016-05-31 00:00:00',NULL,'2016-05-31 16:21:55'),(8,'img884.jpeg','img884.jpeg','2016-05-31 00:00:00',NULL,'2016-05-31 16:27:20'),(9,'img730.png','img730.png','2016-05-31 00:00:00',NULL,'2016-05-31 16:27:14'),(10,'img24.png','img24.png','2016-05-31 00:00:00',NULL,'2016-05-31 16:27:09'),(11,'img8429.png','img8429.png','2016-05-31 16:17:26',NULL,'2016-05-31 16:45:25'),(12,'img887.png','img887.png','2016-06-01 10:33:54','2016-06-01 10:53:49','2016-06-01 10:54:04');
/*!40000 ALTER TABLE `slider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtin`
--

DROP TABLE IF EXISTS `thongtin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongtin` (
  `id_tt` int(2) NOT NULL AUTO_INCREMENT,
  `type_company` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `name_company` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `add_company` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fax` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hotline` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slogan` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `word_run` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `logo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `aboutus` text COLLATE utf8_unicode_ci,
  `recruit` text COLLATE utf8_unicode_ci,
  `contact` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id_tt`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtin`
--

LOCK TABLES `thongtin` WRITE;
/*!40000 ALTER TABLE `thongtin` DISABLE KEYS */;
INSERT INTO `thongtin` VALUES (1,'CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI','TÍN CHÂU','Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng','05113.663.117','05113.663.117','tin.tinchauwindow@gmail.com','0935.443.117','Bền vững cánh cửa ngôi nhà','Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!','img641.png','<p>Giới thiệu</p>\r\n',NULL,NULL);
/*!40000 ALTER TABLE `thongtin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$npLW29E7OBMp0Qqg.4GMMedjd96yS/pvCqWRA8OUNyWPxZZvEc5fO','admin');
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

-- Dump completed on 2016-06-06 17:31:00
