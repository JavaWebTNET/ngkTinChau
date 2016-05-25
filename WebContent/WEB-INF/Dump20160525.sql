-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sqltinhchau
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
  `link` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `super_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`id_dm`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Cửa Nhôm XingFa','javascrip:void(0)',0),(2,'Cửa nhựa lõi thép','javascrip:void(0)',0),(3,'Mặt dựng nhôm kính','javascrip:void(0)',0),(4,'Cầu thang-lan can kính','javascrip:void(0)',0),(5,'Cửa Kính bản lề sàn','javascrip:void(0)',0),(6,'Cửa, vách kính phòng tắm','javascrip:void(0)',0),(7,'Cửa đi mở quay','javascrip:void(0)',1),(8,'Cửa đi mở trượt','javascrip:void(0)',1),(9,'Cửa đi 1 cách mở quay','javascrip:void(0)',7),(10,'Cửa đi 2 cánh mở quay','javascrip:void(0)',7),(11,'Cửa đi 4 cánh mở quay','javascript:void(0',9);
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
  PRIMARY KEY (`id_dv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
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
  `detail` text CHARACTER SET utf8,
  `super_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`id_sp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
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
  PRIMARY KEY (`id_sd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
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
  PRIMARY KEY (`id_tt`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtin`
--

LOCK TABLES `thongtin` WRITE;
/*!40000 ALTER TABLE `thongtin` DISABLE KEYS */;
INSERT INTO `thongtin` VALUES (1,'CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI','TÍN CHÂU','Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng','05113.663.117','05113.663.117','tin.tinchauwindow@gmail.com','0935 443 117','Bền vững cánh cửa ngôi nhà','Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!'),(4,'CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI','Skyline','Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng','05113.663.117','05113.663.117','tin.tinchauwindow@gmail.com','0935 443 117','Bền vững cánh cửa ngôi nhà','Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!'),(5,'CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI','TÍN CHÂU','Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng','05113.663.117','05113.663.117','tin.tinchauwindow@gmail.com','0935 443 117','Bền vững cánh cửa ngôi nhà','Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!');
/*!40000 ALTER TABLE `thongtin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-25 17:07:30
