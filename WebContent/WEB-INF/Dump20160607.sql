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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Cửa nhôm XingFa','<p style=\"text-align: justify;\">Cửa nh&ocirc;m xingfa l&agrave; thương hiệu h&agrave;ng đầu về c&aacute;c cấu kiện nh&ocirc;m lắp gh&eacute;p trong c&aacute;c lĩnh vực x&acirc;y dựng. C&aacute;c sản phẩm được giới thiệu đến to&agrave;n thể qu&yacute; kh&aacute;ch h&agrave;ng. Cửa đi nh&ocirc;m Xingfa, cửa sổ nh&ocirc;m xingfa, cửa l&ugrave;a nh&ocirc;m Xingfa...</p>\r\n',0,'2016-06-07 10:01:13',NULL,NULL),(2,'Cửa nhựa lõi thép','',0,'2016-06-07 10:01:58',NULL,NULL),(3,'Mặt dựng nhôm kính','',0,'2016-06-07 10:02:43',NULL,NULL),(4,'Cầu thang, lan can kính','<p style=\"text-align: justify;\"><strong>Cầu thang</strong> bằng k&iacute;nh cường lực, trụ l&agrave; inox, tay vịn gỗ được d&ugrave;ng nhiều trong c&aacute;c t&ograve;a nh&agrave; sang trọng.</p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Ưu điểm của cầu thang k&iacute;nh:</strong></p>\r\n\r\n<p style=\"text-align: justify;\">- Trước ti&ecirc;n k&iacute;nh l&agrave; vật liệu dễ lau ch&ugrave;i, khi sử dụng ch&uacute;ng ta c&oacute; thể lau ch&ugrave;i ch&uacute;ng một c&aacute;ch dễ d&agrave;ng, ch&uacute;ng ta c&oacute; thể d&ugrave;ng b&aacute;o, giẻ lau v&agrave; nước ch&ugrave;i k&iacute;nh để lau ch&ugrave;i, k&iacute;nh sẽ s&aacute;ng b&oacute;ng v&agrave; tăng th&ecirc;m vẻ s&aacute;ng sủa cho ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">- Sử dụng cầu thang k&iacute;nh bền đẹp v&agrave; tốt sẽ gi&uacute;p ch&uacute;ng ta hạn chế về c&aacute;c chi ph&iacute; sửa chữa. - Kh&iacute; hậu n&oacute;ng nực cũng kh&ocirc;ng ảnh hưởng đến cầu thang k&iacute;nh, k&iacute;nh sẽ tạo cho ch&uacute;ng ta cảm gi&aacute;c m&aacute;t mẻ v&agrave; dễ chịu khi đi l&ecirc;n n&oacute;.</p>\r\n\r\n<p style=\"text-align: justify;\">- Cấu tr&uacute;c cầu thang k&iacute;nh được thiết kế đa dạng c&oacute; t&aacute;c dụng phản chiếu &aacute;nh s&aacute;ng gi&uacute;p khu vực buồng thang trở n&ecirc;n s&aacute;ng sủa, tho&aacute;ng đ&atilde;ng hơn rất nhiều. -</p>\r\n\r\n<p style=\"text-align: justify;\">Mang lại vẻ đẹp hiện đại, tho&aacute;ng đ&atilde;ng v&agrave; điểm nhấn tinh tế cho nội v&agrave; ngoại thất c&ocirc;ng tr&igrave;nh.</p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Lan can k&iacute;nh</strong></p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Ưu điểm của lan can k&iacute;nh</strong></p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Lan can bằng k&iacute;nh</strong> gi&uacute;p nới rộng kh&ocirc;ng gian trong nh&agrave;. Thay cho những thanh chắn, tay vịn lan bằng gỗ hoặc sắt b&ecirc; t&ocirc;ng đơn thuần, gi&uacute;p căn nh&agrave; giảm bớt nặng nề th&ocirc; kệt</p>\r\n\r\n<p style=\"text-align: justify;\">T&aacute;c dụng phản chiếu &aacute;nh s&aacute;ng gi&uacute;p khu vực buồng thang trở n&ecirc;n s&aacute;ng sủa, tho&aacute;ng đ&atilde;ng hơn rất nhiều.</p>\r\n\r\n<p style=\"text-align: justify;\">An to&agrave;n, dễ d&agrave;ng vệ sinh., đẹp v&agrave; sang trọng gi&uacute;p t&ocirc; điểm th&ecirc;m cho kh&ocirc;ng gian ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">Chất lượng cao, chịu lực tốt.</p>\r\n',0,'2016-06-07 10:07:50',NULL,NULL),(5,'Cửa kính bản lề sàn','<p style=\"text-align: justify;\">Đ&aacute;p ứng nhu cầu ng&agrave;y c&agrave;ng đa dạng về x&acirc;y dựng nh&agrave; ở,cửa h&agrave;ng,shop, nh&agrave; xưởng c&ocirc;ng nghiệp, c&aacute;c c&ocirc;ng tr&igrave;nh&hellip;theo xu hướng c&ocirc;ng nghiệp h&oacute;a, C&ocirc;ng ty nh&ocirc;m k&iacute;nh ch&uacute;ng t&ocirc;i kh&ocirc;ng ngừng nỗ lực cung cấp những sản phẩm chất lượng cao, nhiều mẫu m&atilde; cho kh&aacute;ch h&agrave;ng.</p>\r\n',0,'2016-06-07 10:08:44',NULL,NULL),(6,'Cửa, vách kính phòng tắm','<p style=\"text-align: justify;\"><strong>V&aacute;ch k&iacute;nh ph&ograve;ng tắm</strong> l&agrave; một mẫu thiết kế cho một ph&ograve;ng tắm hiện đại bằng chất liệu k&iacute;nh v&agrave; giải quyết những hạn chế về mặt bằng. Với điều kiện thời tiết khắc nghiệt như ở Việt Nam, đất nước nhiệt đới gi&oacute; m&ugrave;a ch&uacute;ng ta c&oacute; thể thấy m&ugrave;a đ&ocirc;ng th&igrave; n&oacute; mang lại cảm gi&aacute;c ấm &aacute;p nhưng m&ugrave;a h&egrave; th&igrave; lại gi&uacute;p cho người sử dụng thư gi&atilde;n m&aacute;t lạnh. V&aacute;ch ngăn k&iacute;nh ph&ograve;ng tắm l&agrave; sự lựa chọn tốt nhất cho gia đ&igrave;nh bạn</p>\r\n',0,'2016-06-07 10:10:58',NULL,NULL),(7,'Cửa đi mở quay','<p style=\"text-align: justify;\">Cửa nh&ocirc;m xingfa mở quay 4 c&aacute;nh đ&aacute;p ứng tối đa y&ecirc;u cầu khi mở cửa cần khoảng kh&ocirc;ng gian rộng lớn nhất, ph&ugrave; hợp sử dụng l&agrave;m cửa mặt tiền. Do được tạo th&agrave;nh từ thanh nh&ocirc;m hệ xingfa cao cấp được cấu tạo khoang rỗng c&oacute; c&aacute;c đường g&acirc;n trợ lực n&ecirc;n tạo th&agrave;nh h&igrave;nh khối cửa vững chắc, an to&agrave;n.</p>\r\n\r\n<p style=\"text-align: justify;\">- Ph&acirc;n loại: Cửa 2 c&aacute;nh hoặc 4 c&aacute;nh</p>\r\n\r\n<p style=\"text-align: justify;\"><em><strong>-&nbsp; Đặc điểm nổi bật:</strong></em></p>\r\n\r\n<p style=\"text-align: justify;\">+ Định vị được vị tr&iacute; g&oacute;c mở (g&oacute;c mở tối đa 90 độ).</p>\r\n\r\n<p style=\"text-align: justify;\">+ Lấy tối đa độ th&ocirc;ng tho&aacute;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Kh&ocirc;ng ảnh hưởng đến diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ An to&agrave;n, bền đẹp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Được tạo th&agrave;nh bởi hệ profile nh&ocirc;m định h&igrave;nh thiết kế c&aacute;c g&acirc;n gia cường nhằm tăng khả năng chịu lực.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bề mặt được bao phủ bởi lớp sơn tĩnh điện cao cấp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bộ phụ kiện kim kh&iacute; đồng bộ tương th&iacute;ch với hệ Profile đảm bảo cho cửa hoạt động nhẹ nh&agrave;ng, li&ecirc;n tục.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: lựa chọn k&iacute;nh đơn, k&iacute;nh an to&agrave;n, k&iacute;nh cường lực, k&iacute;nh hộp &hellip;</p>\r\n',1,'2016-06-07 10:13:09',NULL,NULL),(8,'Cửa đi mở trượt','<p style=\"text-align: justify;\">+ Đảm bảo c&aacute;ch &acirc;m, c&aacute;ch nhiệt c&ugrave;ng độ k&iacute;n, kh&iacute;t cao.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Tiết kiệm kh&ocirc;ng gian đ&oacute;ng/mở cửa, gi&uacute;p tận dụng tối đa diện t&iacute;ch cho ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Độ an to&agrave;n cao, tr&aacute;nh được nguy cơ gi&oacute; dập.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Cho ph&eacute;p l&agrave;m c&aacute;nh cửa c&oacute; k&iacute;ch thước lớn.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Gi&uacute;p mở rộng kh&ocirc;ng gian, tạo được tầm nh&igrave;n bao qu&aacute;t cho c&ocirc;ng tr&igrave;nh.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Dễ d&agrave;ng vệ sinh &amp;amp; bảo dưỡng cửa.</p>\r\n\r\n<p style=\"text-align: justify;\">+ C&oacute; khả năng chống ăn m&ograve;n v&agrave; chịu đựng được mọi thời tiết nhờ lớp xi mạ v&agrave; sơn tĩnh diện.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Mang lại t&iacute;nh kinh tế trong sử dụng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: Ph&ocirc;i c&oacute; độ d&agrave;y từ 5mm đến 21mm</p>\r\n\r\n<p style=\"text-align: justify;\">+ Phụ kiện đồng bộ: tay nắm, thanh chốt, b&aacute;nh xe&hellip;</p>\r\n',1,'2016-06-07 10:15:02',NULL,NULL),(9,'Cửa nhựa lõi thép xếp trượt','',1,'2016-06-07 10:16:04',NULL,NULL),(10,'Cửa lùa 2 cánh, 4 cánh','<p style=\"text-align: justify;\"><strong>Đặc điểm nổi bật</strong></p>\r\n\r\n<p style=\"text-align: justify;\">+ Định vị được vị tr&iacute; g&oacute;c mở (g&oacute;c mở tối đa 90 độ).</p>\r\n\r\n<p style=\"text-align: justify;\">+ Lấy tối đa độ th&ocirc;ng tho&aacute;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Kh&ocirc;ng ảnh hưởng đến diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ An to&agrave;n, bền đẹp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Được tạo th&agrave;nh bởi hệ profile nh&ocirc;m định h&igrave;nh thiết kế c&aacute;c g&acirc;n gia cường nhằm tăng khả năng chịu lực.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bề mặt được bao phủ bởi lớp sơn tĩnh điện cao cấp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bộ phụ kiện kim kh&iacute; đồng bộ tương th&iacute;ch với hệ Profile đảm bảo cho cửa hoạt động nhẹ nh&agrave;ng, li&ecirc;n tục.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: Lựa chọn k&iacute;nh đơn, k&iacute;nh an to&agrave;n, k&iacute;nh cường lực, k&iacute;nh hộp &hellip;</p>\r\n',1,'2016-06-07 10:18:18',NULL,NULL),(11,'Cửa đi mở quay','<p style=\"text-align: justify;\"><strong>Đặc điểm:</strong></p>\r\n\r\n<p style=\"text-align: justify;\">- C&oacute; t&iacute;nh c&aacute;ch &acirc;m, c&aacute;ch nhiệt, độ k&iacute;n kh&iacute;t cao.</p>\r\n\r\n<p style=\"text-align: justify;\">- Được l&agrave;m từ thanh Profile c&oacute; k&iacute;ch thước lớn vững chắc.</p>\r\n\r\n<p style=\"text-align: justify;\">- Sử dụng k&iacute;nh cường lực với độ an to&agrave;n cao m&agrave; vẫn đảm bảo &aacute;nh s&aacute;ng đầy đủ cho căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">- Vận h&agrave;nh nhẹ nh&agrave;ng, an to&agrave;n với hệ thống kh&oacute;a đa điểm.</p>\r\n\r\n<p style=\"text-align: justify;\">- K&iacute;ch thước, mẫu m&atilde; đa dạng, ph&ugrave; hợp với nhiều phong c&aacute;ch kiến tr&uacute;c.</p>\r\n',2,'2016-06-07 10:24:12',NULL,NULL),(12,'Cửa đi mở trượt','<p><strong>Đặc điểm:</strong></p>\r\n\r\n<p>- C&oacute; t&iacute;nh c&aacute;ch &acirc;m, c&aacute;ch nhiệt, c&oacute; độ k&iacute;n kh&iacute;t cao.</p>\r\n\r\n<p>- Khi đ&oacute;ng mở kh&ocirc;ng l&agrave;m ảnh hưởng đến kh&ocirc;ng gian v&agrave; diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p>- Cửa được vận h&agrave;nh tr&ecirc;n hệ thống con lăn l&agrave;m bằng chất liệu Polymer n&ecirc;n c&oacute; thể đ&oacute;ng mở nhẹ nh&agrave;ng, &ecirc;m &aacute;i.</p>\r\n\r\n<p>- Tr&aacute;nh được nguy cơ gi&oacute; dập.</p>\r\n\r\n<p>- Vận dụng l&agrave;m cửa đi cho ban c&ocirc;ng, cửa s&acirc;n vườn, hồ bơi...</p>\r\n',2,'2016-06-07 14:50:49',NULL,NULL),(13,'Cửa nhựa lõi thép xếp trượt','',2,'2016-06-07 14:51:56',NULL,NULL),(14,'Cửa lùa 2 cánh, 4 cánh','',2,'2016-06-07 14:52:47',NULL,NULL),(15,'Mặt dựng nhôm kính Unitized','',3,'2016-06-07 14:53:38',NULL,NULL),(16,'Mặt dựng nhôm kính Stick','',3,'2016-06-07 14:53:58',NULL,NULL),(17,'Mặt dựng hệ AV','',3,'2016-06-07 14:54:12',NULL,NULL),(18,'Mặt dựng đầu số 50x60','',3,'2016-06-07 14:54:27',NULL,NULL),(19,'Mặt dựng cover cup','',3,'2016-06-07 14:54:41',NULL,NULL),(20,'Mặt dựng spider','',3,'2016-06-07 14:55:18',NULL,NULL),(21,'Mặt dựng kính Stick','',3,'2016-06-07 14:55:33',NULL,NULL),(22,'Cửa sổ mở trượt PK 800','',6,'2016-06-07 14:57:31',NULL,NULL),(23,'Cửa sổ mở quay lật ( Công nghệ châu âu) hệ 45','',6,'2016-06-07 14:58:21',NULL,NULL),(24,'Cửa sổ mở hất ngoài ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 14:58:37',NULL,NULL),(25,'Cửa sổ mở quay ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 14:59:19',NULL,NULL),(26,'Cửa đi xếp trượt ( Công nghệ châu âu) hệ 45','',6,'2016-06-07 14:59:35',NULL,NULL),(27,'Cửa đi mở trượt ( Công nghệ châu âu) hệ SC-95','',6,'2016-06-07 14:59:59',NULL,NULL),(28,'Cửa mở trượt ( Công nghệ châu âu) hệ 2001','',6,'2016-06-07 15:00:34',NULL,NULL),(29,'Cửa đi mở quay ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 15:00:49',NULL,NULL),(30,'Cửa đi và cửa sổ hệ châu âu (P3)','',6,'2016-06-07 15:01:08',NULL,'2016-06-07 15:01:27'),(31,'Cửa đi 1 cánh mở quay','',7,'2016-06-07 15:03:08',NULL,NULL),(32,'Cửa đi 2 cánh mở quay','',7,'2016-06-07 15:03:25',NULL,NULL),(33,'Cửa đi 4 cánh mở quay','',7,'2016-06-07 15:03:36',NULL,NULL),(34,'Cửa đi mở trượt 2 cánh','',8,'2016-06-07 15:04:12',NULL,NULL),(35,'Cửa đi mở trượt 4 cánh','',8,'2016-06-07 15:04:30',NULL,NULL),(36,'Cửa đi 1 cánh mở quay','',11,'2016-06-07 15:05:19',NULL,NULL),(37,'Cửa đi 2 cánh mở quay','',11,'2016-06-07 15:05:34',NULL,NULL),(38,'Cửa đi 4 cánh mở quay','',11,'2016-06-07 15:05:50',NULL,NULL),(39,'Cửa đi mở trượt 2 cánh','',12,'2016-06-07 15:06:18',NULL,NULL),(40,'Cửa đi mở trượt 4 cánh','',12,'2016-06-07 15:06:28',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtin`
--

LOCK TABLES `thongtin` WRITE;
/*!40000 ALTER TABLE `thongtin` DISABLE KEYS */;
INSERT INTO `thongtin` VALUES (1,'CÔNG TY CỔ PHẦN SẢN XUẤT VÀ THƯƠNG MẠI','TÍN CHÂU','Địa chỉ: Lô 33C đường Mẹ Thứ, Phường Hòa Xuân, Quận Cẩm Lệ, Thành phố Đà Nẵng','05113.663.117','05113.663.117','tin.tinchauwindow@gmail.com','0935.443.117','Bền vững cánh cửa ngôi nhà','Công ty cổ phần sản xuất và thương mại Tín Châu - Chuyên sản xuất - tư vấn thiết kế - lắp đặt nhôm kính....!','img641.png','<p style=\"text-align: center;\"><span style=\"color:#FF0000\"><strong><span style=\"font-size:16px\">C&Ocirc;NG TY CỔ PHẦN SẢN XUẤT V&Agrave; THƯƠNG MẠI T&Iacute;N CH&Acirc;U</span></strong></span></p>\r\n\r\n<p style=\"text-align: justify;\">Cuộc sống x&atilde; hội ng&agrave;y n&acirc;ng cao v&igrave; vậy m&agrave; nhu cầu sử dụng, su hướng l&agrave;m đẹp cho ng&ocirc;i nh&agrave; c&agrave;ng được ch&uacute; trọng. Cửa nh&ocirc;m k&iacute;nh lu&ocirc;n được kh&aacute;ch h&agrave;ng ch&uacute; &yacute; v&agrave; tin d&ugrave;ng với nhiều t&iacute;nh năng ưu Việt.</p>\r\n\r\n<p style=\"text-align: justify;\"><strong>C&ocirc;ng Ty Cổ phần Sản Xuất V&agrave; Thương Mại T&iacute;n Ch&acirc;u</strong> tự h&agrave;o l&agrave; một đơn vị đi đầu về tr&igrave;nh độ kỹ thuật chuy&ecirc;n m&ocirc;n về sản xuất, thi c&ocirc;ng lắp đặt v&agrave; ph&acirc;n phối c&aacute;c sản phẩm nh&ocirc;m k&iacute;nh h&agrave;ng đầu tại Đ&agrave; Nẵng.</p>\r\n\r\n<p style=\"text-align: justify;\">Chuy&ecirc;n thiết kế, thi c&ocirc;ng, lắp đặt c&aacute;c sản phẩm hợp kim phục vụ trong ngh&agrave;nh x&acirc;y dựng v&agrave; trang tr&iacute; nội thất như: Cửa k&iacute;nh, thi c&ocirc;ng nh&ocirc;m k&iacute;nh, Cửa sổ, Cửa đi, Mặt dựng, V&aacute;ch ngăn, cầu thang, lan can &hellip;.</p>\r\n\r\n<p style=\"text-align: justify;\">Với đội ngũ nh&acirc;n vi&ecirc;n nhiệt t&igrave;nh, tr&aacute;ch nhiệm, được đ&agrave;o tạo chuy&ecirc;n m&ocirc;n cao, Ch&uacute;ng t&ocirc;i lu&ocirc;n đem đến cho kh&aacute;ch h&agrave;ng những sản phẩm tốt nhất, ph&ugrave; hợp với mọi nhu cầu của tất cả qu&yacute; kh&aacute;ch.</p>\r\n\r\n<p style=\"text-align: justify;\">Phương ch&acirc;m kinh doanh: Bền vững c&aacute;nh cửa ng&ocirc;i nh&agrave;. Ch&uacute;ng t&ocirc;i lu&ocirc;n gắn lợi &iacute;ch doanh nghiệp với lợi &iacute;ch của kh&aacute;ch h&agrave;ng v&agrave; cộng đồng x&atilde; hội để c&ugrave;ng ph&aacute;t triển bền vững, mang lại cho ng&ocirc;i nh&agrave; bạn một kh&ocirc;ng gian tinh tế nhất.</p>\r\n',NULL,NULL);
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

-- Dump completed on 2016-06-07 17:27:04
