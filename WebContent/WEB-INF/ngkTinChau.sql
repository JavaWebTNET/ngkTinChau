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
  `update_at` datetime DEFAULT NULL,
  `delete_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id_dm`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Cửa nhôm XingFa','<p style=\"text-align: justify;\">Cửa nh&ocirc;m xingfa l&agrave; thương hiệu h&agrave;ng đầu về c&aacute;c cấu kiện nh&ocirc;m lắp gh&eacute;p trong c&aacute;c lĩnh vực x&acirc;y dựng. C&aacute;c sản phẩm được giới thiệu đến to&agrave;n thể qu&yacute; kh&aacute;ch h&agrave;ng. Cửa đi nh&ocirc;m Xingfa, cửa sổ nh&ocirc;m xingfa, cửa l&ugrave;a nh&ocirc;m Xingfa...</p>\r\n',0,'2016-06-07 10:01:13','2016-06-07 10:01:13',NULL),(2,'Cửa nhựa lõi thép','',0,'2016-06-07 10:01:58','2016-06-07 10:01:58',NULL),(3,'Mặt dựng nhôm kính','',0,'2016-06-07 10:02:43','2016-06-07 10:02:43',NULL),(4,'Cầu thang, lan can kính','<p style=\"text-align: justify;\"><strong>Cầu thang</strong> bằng k&iacute;nh cường lực, trụ l&agrave; inox, tay vịn gỗ được d&ugrave;ng nhiều trong c&aacute;c t&ograve;a nh&agrave; sang trọng.</p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Ưu điểm của cầu thang k&iacute;nh:</strong></p>\r\n\r\n<p style=\"text-align: justify;\">- Trước ti&ecirc;n k&iacute;nh l&agrave; vật liệu dễ lau ch&ugrave;i, khi sử dụng ch&uacute;ng ta c&oacute; thể lau ch&ugrave;i ch&uacute;ng một c&aacute;ch dễ d&agrave;ng, ch&uacute;ng ta c&oacute; thể d&ugrave;ng b&aacute;o, giẻ lau v&agrave; nước ch&ugrave;i k&iacute;nh để lau ch&ugrave;i, k&iacute;nh sẽ s&aacute;ng b&oacute;ng v&agrave; tăng th&ecirc;m vẻ s&aacute;ng sủa cho ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">- Sử dụng cầu thang k&iacute;nh bền đẹp v&agrave; tốt sẽ gi&uacute;p ch&uacute;ng ta hạn chế về c&aacute;c chi ph&iacute; sửa chữa. - Kh&iacute; hậu n&oacute;ng nực cũng kh&ocirc;ng ảnh hưởng đến cầu thang k&iacute;nh, k&iacute;nh sẽ tạo cho ch&uacute;ng ta cảm gi&aacute;c m&aacute;t mẻ v&agrave; dễ chịu khi đi l&ecirc;n n&oacute;.</p>\r\n\r\n<p style=\"text-align: justify;\">- Cấu tr&uacute;c cầu thang k&iacute;nh được thiết kế đa dạng c&oacute; t&aacute;c dụng phản chiếu &aacute;nh s&aacute;ng gi&uacute;p khu vực buồng thang trở n&ecirc;n s&aacute;ng sủa, tho&aacute;ng đ&atilde;ng hơn rất nhiều. -</p>\r\n\r\n<p style=\"text-align: justify;\">Mang lại vẻ đẹp hiện đại, tho&aacute;ng đ&atilde;ng v&agrave; điểm nhấn tinh tế cho nội v&agrave; ngoại thất c&ocirc;ng tr&igrave;nh.</p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Lan can k&iacute;nh</strong></p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Ưu điểm của lan can k&iacute;nh</strong></p>\r\n\r\n<p style=\"text-align: justify;\"><strong>Lan can bằng k&iacute;nh</strong> gi&uacute;p nới rộng kh&ocirc;ng gian trong nh&agrave;. Thay cho những thanh chắn, tay vịn lan bằng gỗ hoặc sắt b&ecirc; t&ocirc;ng đơn thuần, gi&uacute;p căn nh&agrave; giảm bớt nặng nề th&ocirc; kệt</p>\r\n\r\n<p style=\"text-align: justify;\">T&aacute;c dụng phản chiếu &aacute;nh s&aacute;ng gi&uacute;p khu vực buồng thang trở n&ecirc;n s&aacute;ng sủa, tho&aacute;ng đ&atilde;ng hơn rất nhiều.</p>\r\n\r\n<p style=\"text-align: justify;\">An to&agrave;n, dễ d&agrave;ng vệ sinh., đẹp v&agrave; sang trọng gi&uacute;p t&ocirc; điểm th&ecirc;m cho kh&ocirc;ng gian ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">Chất lượng cao, chịu lực tốt.</p>\r\n',0,'2016-06-07 10:07:50','2016-06-07 10:07:50',NULL),(5,'Cửa kính bản lề sàn','<p style=\"text-align: justify;\">Đ&aacute;p ứng nhu cầu ng&agrave;y c&agrave;ng đa dạng về x&acirc;y dựng nh&agrave; ở,cửa h&agrave;ng,shop, nh&agrave; xưởng c&ocirc;ng nghiệp, c&aacute;c c&ocirc;ng tr&igrave;nh&hellip;theo xu hướng c&ocirc;ng nghiệp h&oacute;a, C&ocirc;ng ty nh&ocirc;m k&iacute;nh ch&uacute;ng t&ocirc;i kh&ocirc;ng ngừng nỗ lực cung cấp những sản phẩm chất lượng cao, nhiều mẫu m&atilde; cho kh&aacute;ch h&agrave;ng.</p>\r\n',0,'2016-06-07 10:08:44','2016-06-07 10:08:44',NULL),(6,'Cửa, vách kính phòng tắm','<p style=\"text-align: justify;\"><strong>V&aacute;ch k&iacute;nh ph&ograve;ng tắm</strong> l&agrave; một mẫu thiết kế cho một ph&ograve;ng tắm hiện đại bằng chất liệu k&iacute;nh v&agrave; giải quyết những hạn chế về mặt bằng. Với điều kiện thời tiết khắc nghiệt như ở Việt Nam, đất nước nhiệt đới gi&oacute; m&ugrave;a ch&uacute;ng ta c&oacute; thể thấy m&ugrave;a đ&ocirc;ng th&igrave; n&oacute; mang lại cảm gi&aacute;c ấm &aacute;p nhưng m&ugrave;a h&egrave; th&igrave; lại gi&uacute;p cho người sử dụng thư gi&atilde;n m&aacute;t lạnh. V&aacute;ch ngăn k&iacute;nh ph&ograve;ng tắm l&agrave; sự lựa chọn tốt nhất cho gia đ&igrave;nh bạn</p>\r\n',0,'2016-06-07 10:10:58','2016-06-07 10:10:58',NULL),(7,'Cửa đi mở quay','<p style=\"text-align: justify;\">Cửa nh&ocirc;m xingfa mở quay 4 c&aacute;nh đ&aacute;p ứng tối đa y&ecirc;u cầu khi mở cửa cần khoảng kh&ocirc;ng gian rộng lớn nhất, ph&ugrave; hợp sử dụng l&agrave;m cửa mặt tiền. Do được tạo th&agrave;nh từ thanh nh&ocirc;m hệ xingfa cao cấp được cấu tạo khoang rỗng c&oacute; c&aacute;c đường g&acirc;n trợ lực n&ecirc;n tạo th&agrave;nh h&igrave;nh khối cửa vững chắc, an to&agrave;n.</p>\r\n\r\n<p style=\"text-align: justify;\">- Ph&acirc;n loại: Cửa 2 c&aacute;nh hoặc 4 c&aacute;nh</p>\r\n\r\n<p style=\"text-align: justify;\"><em><strong>-&nbsp; Đặc điểm nổi bật:</strong></em></p>\r\n\r\n<p style=\"text-align: justify;\">+ Định vị được vị tr&iacute; g&oacute;c mở (g&oacute;c mở tối đa 90 độ).</p>\r\n\r\n<p style=\"text-align: justify;\">+ Lấy tối đa độ th&ocirc;ng tho&aacute;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Kh&ocirc;ng ảnh hưởng đến diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ An to&agrave;n, bền đẹp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Được tạo th&agrave;nh bởi hệ profile nh&ocirc;m định h&igrave;nh thiết kế c&aacute;c g&acirc;n gia cường nhằm tăng khả năng chịu lực.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bề mặt được bao phủ bởi lớp sơn tĩnh điện cao cấp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bộ phụ kiện kim kh&iacute; đồng bộ tương th&iacute;ch với hệ Profile đảm bảo cho cửa hoạt động nhẹ nh&agrave;ng, li&ecirc;n tục.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: lựa chọn k&iacute;nh đơn, k&iacute;nh an to&agrave;n, k&iacute;nh cường lực, k&iacute;nh hộp &hellip;</p>\r\n',1,'2016-06-07 10:13:09','2016-06-07 10:13:09',NULL),(8,'Cửa đi mở trượt','<p style=\"text-align: justify;\">+ Đảm bảo c&aacute;ch &acirc;m, c&aacute;ch nhiệt c&ugrave;ng độ k&iacute;n, kh&iacute;t cao.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Tiết kiệm kh&ocirc;ng gian đ&oacute;ng/mở cửa, gi&uacute;p tận dụng tối đa diện t&iacute;ch cho ng&ocirc;i nh&agrave;.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Độ an to&agrave;n cao, tr&aacute;nh được nguy cơ gi&oacute; dập.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Cho ph&eacute;p l&agrave;m c&aacute;nh cửa c&oacute; k&iacute;ch thước lớn.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Gi&uacute;p mở rộng kh&ocirc;ng gian, tạo được tầm nh&igrave;n bao qu&aacute;t cho c&ocirc;ng tr&igrave;nh.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Dễ d&agrave;ng vệ sinh &amp;amp; bảo dưỡng cửa.</p>\r\n\r\n<p style=\"text-align: justify;\">+ C&oacute; khả năng chống ăn m&ograve;n v&agrave; chịu đựng được mọi thời tiết nhờ lớp xi mạ v&agrave; sơn tĩnh diện.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Mang lại t&iacute;nh kinh tế trong sử dụng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: Ph&ocirc;i c&oacute; độ d&agrave;y từ 5mm đến 21mm</p>\r\n\r\n<p style=\"text-align: justify;\">+ Phụ kiện đồng bộ: tay nắm, thanh chốt, b&aacute;nh xe&hellip;</p>\r\n',1,'2016-06-07 10:15:02','2016-06-07 10:15:02',NULL),(9,'Cửa nhựa lõi thép xếp trượt','',1,'2016-06-07 10:16:04','2016-06-07 10:16:04',NULL),(10,'Cửa lùa 2 cánh, 4 cánh','<p style=\"text-align: justify;\"><strong>Đặc điểm nổi bật</strong></p>\r\n\r\n<p style=\"text-align: justify;\">+ Định vị được vị tr&iacute; g&oacute;c mở (g&oacute;c mở tối đa 90 độ).</p>\r\n\r\n<p style=\"text-align: justify;\">+ Lấy tối đa độ th&ocirc;ng tho&aacute;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Kh&ocirc;ng ảnh hưởng đến diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">+ An to&agrave;n, bền đẹp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Được tạo th&agrave;nh bởi hệ profile nh&ocirc;m định h&igrave;nh thiết kế c&aacute;c g&acirc;n gia cường nhằm tăng khả năng chịu lực.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bề mặt được bao phủ bởi lớp sơn tĩnh điện cao cấp.</p>\r\n\r\n<p style=\"text-align: justify;\">+ Bộ phụ kiện kim kh&iacute; đồng bộ tương th&iacute;ch với hệ Profile đảm bảo cho cửa hoạt động nhẹ nh&agrave;ng, li&ecirc;n tục.</p>\r\n\r\n<p style=\"text-align: justify;\">+ K&iacute;nh: Lựa chọn k&iacute;nh đơn, k&iacute;nh an to&agrave;n, k&iacute;nh cường lực, k&iacute;nh hộp &hellip;</p>\r\n',1,'2016-06-07 10:18:18','2016-06-07 10:18:18',NULL),(11,'Cửa đi mở quay','<p style=\"text-align: justify;\"><strong>Đặc điểm:</strong></p>\r\n\r\n<p style=\"text-align: justify;\">- C&oacute; t&iacute;nh c&aacute;ch &acirc;m, c&aacute;ch nhiệt, độ k&iacute;n kh&iacute;t cao.</p>\r\n\r\n<p style=\"text-align: justify;\">- Được l&agrave;m từ thanh Profile c&oacute; k&iacute;ch thước lớn vững chắc.</p>\r\n\r\n<p style=\"text-align: justify;\">- Sử dụng k&iacute;nh cường lực với độ an to&agrave;n cao m&agrave; vẫn đảm bảo &aacute;nh s&aacute;ng đầy đủ cho căn ph&ograve;ng.</p>\r\n\r\n<p style=\"text-align: justify;\">- Vận h&agrave;nh nhẹ nh&agrave;ng, an to&agrave;n với hệ thống kh&oacute;a đa điểm.</p>\r\n\r\n<p style=\"text-align: justify;\">- K&iacute;ch thước, mẫu m&atilde; đa dạng, ph&ugrave; hợp với nhiều phong c&aacute;ch kiến tr&uacute;c.</p>\r\n',2,'2016-06-07 10:24:12','2016-06-07 10:24:12',NULL),(12,'Cửa đi mở trượt','<p><strong>Đặc điểm:</strong></p>\r\n\r\n<p>- C&oacute; t&iacute;nh c&aacute;ch &acirc;m, c&aacute;ch nhiệt, c&oacute; độ k&iacute;n kh&iacute;t cao.</p>\r\n\r\n<p>- Khi đ&oacute;ng mở kh&ocirc;ng l&agrave;m ảnh hưởng đến kh&ocirc;ng gian v&agrave; diện t&iacute;ch sử dụng của căn ph&ograve;ng.</p>\r\n\r\n<p>- Cửa được vận h&agrave;nh tr&ecirc;n hệ thống con lăn l&agrave;m bằng chất liệu Polymer n&ecirc;n c&oacute; thể đ&oacute;ng mở nhẹ nh&agrave;ng, &ecirc;m &aacute;i.</p>\r\n\r\n<p>- Tr&aacute;nh được nguy cơ gi&oacute; dập.</p>\r\n\r\n<p>- Vận dụng l&agrave;m cửa đi cho ban c&ocirc;ng, cửa s&acirc;n vườn, hồ bơi...</p>\r\n',2,'2016-06-07 14:50:49','2016-06-07 14:50:49',NULL),(13,'Cửa nhựa lõi thép xếp trượt','',2,'2016-06-07 14:51:56','2016-06-07 14:51:56',NULL),(14,'Cửa lùa 2 cánh, 4 cánh','',2,'2016-06-07 14:52:47','2016-06-07 14:52:47',NULL),(15,'Mặt dựng nhôm kính Unitized','',3,'2016-06-07 14:53:38','2016-06-07 14:53:38',NULL),(16,'Mặt dựng nhôm kính Stick','',3,'2016-06-07 14:53:58','2016-06-07 14:53:58',NULL),(17,'Mặt dựng hệ AV','',3,'2016-06-07 14:54:12','2016-06-07 14:54:12',NULL),(18,'Mặt dựng đầu số 50x60','',3,'2016-06-07 14:54:27','2016-06-07 14:54:27',NULL),(19,'Mặt dựng cover cup','',3,'2016-06-07 14:54:41','2016-06-07 14:54:41',NULL),(20,'Mặt dựng spider','',3,'2016-06-07 14:55:18','2016-06-07 14:55:18',NULL),(21,'Mặt dựng kính Stick','',3,'2016-06-07 14:55:33','2016-06-07 14:55:33',NULL),(22,'Cửa sổ mở trượt PK 800','',6,'2016-06-07 14:57:31','2016-06-07 14:57:31',NULL),(23,'Cửa sổ mở quay lật ( Công nghệ châu âu) hệ 45','',6,'2016-06-07 14:58:21','2016-06-07 14:58:21',NULL),(24,'Cửa sổ mở hất ngoài ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 14:58:37','2016-06-07 14:58:37',NULL),(25,'Cửa sổ mở quay ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 14:59:19','2016-06-07 14:59:19',NULL),(26,'Cửa đi xếp trượt ( Công nghệ châu âu) hệ 45','',6,'2016-06-07 14:59:35','2016-06-07 14:59:35',NULL),(27,'Cửa đi mở trượt ( Công nghệ châu âu) hệ SC-95','',6,'2016-06-07 14:59:59','2016-06-07 14:59:59',NULL),(28,'Cửa mở trượt ( Công nghệ châu âu) hệ 2001','',6,'2016-06-07 15:00:34','2016-06-07 15:00:34',NULL),(29,'Cửa đi mở quay ( Công nghệ châu âu) hệ 55','',6,'2016-06-07 15:00:49','2016-06-07 15:00:49',NULL),(30,'Cửa đi và cửa sổ hệ châu âu (P3)','',6,'2016-06-07 15:01:08','2016-06-07 15:01:27',NULL),(31,'Cửa đi 1 cánh mở quay','',7,'2016-06-07 15:03:08','2016-06-07 15:03:08',NULL),(32,'Cửa đi 2 cánh mở quay','',7,'2016-06-07 15:03:25','2016-06-07 15:03:25',NULL),(33,'Cửa đi 4 cánh mở quay','',7,'2016-06-07 15:03:36','2016-06-07 15:03:36',NULL),(34,'Cửa đi mở trượt 2 cánh','',8,'2016-06-07 15:04:12','2016-06-07 15:04:12',NULL),(35,'Cửa đi mở trượt 4 cánh','',8,'2016-06-07 15:04:30','2016-06-07 15:04:30',NULL),(36,'Cửa đi 1 cánh mở quay','',11,'2016-06-07 15:05:19','2016-06-07 15:05:19',NULL),(37,'Cửa đi 2 cánh mở quay','',11,'2016-06-07 15:05:34','2016-06-07 15:05:34',NULL),(38,'Cửa đi 4 cánh mở quay','',11,'2016-06-07 15:05:50','2016-06-07 15:05:50',NULL),(39,'Cửa đi mở trượt 2 cánh','',12,'2016-06-07 15:06:18','2016-06-07 15:06:18',NULL),(40,'Cửa đi mở trượt 4 cánh','',12,'2016-06-07 15:06:28','2016-06-07 15:06:28',NULL);
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
INSERT INTO `dichvu` VALUES (1,'Tư vấn và thiết kế','img39.png','<p>Tư vấn v&agrave; thiết kế</p>\r\n','2016-06-01 15:32:25','2016-06-10 16:46:04',NULL),(2,'Sản xuất','img781.png','<p>Sản xuất</p>\r\n','2016-06-01 15:34:51','2016-06-10 16:45:41',NULL),(3,'Thi công lắp đặt nhôm kính','img353.png','<p>Thi c&ocirc;ng lắp đặt nh&ocirc;m k&iacute;nh</p>\r\n','2016-06-01 16:41:00','2016-06-10 16:45:08',NULL);
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meck`
--

DROP TABLE IF EXISTS `meck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meck` (
  `ip` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `visit_date` date NOT NULL,
  `hits` int(10) NOT NULL DEFAULT '1',
  `onl` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ip`,`visit_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meck`
--

LOCK TABLES `meck` WRITE;
/*!40000 ALTER TABLE `meck` DISABLE KEYS */;
INSERT INTO `meck` VALUES ('127.0.0.1','2015-06-11',1,'1'),('127.0.0.1','2016-05-10',1,'1'),('127.0.0.1','2016-06-08',11,''),('127.0.0.1','2016-06-09',728,'1465472150564'),('127.0.0.1','2016-06-10',132,'1465558307116'),('127.0.0.1','2016-06-11',73,'1465642159702');
/*!40000 ALTER TABLE `meck` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Cửa nhôm XingFa 01','img891.png',1,1,'2016-06-08 09:52:27','2016-06-08 09:52:27',NULL),(2,'Cửa đi mở quay 01','img714.png',1,7,'2016-06-08 09:53:28','2016-06-08 09:53:28',NULL),(3,'Cửa đi 1 cánh mở quay 01','img156.png',0,31,'2016-06-08 09:54:02','2016-06-08 09:54:02',NULL),(4,'Cửa đi 2 cánh mở quay 01','img331.png',0,32,'2016-06-08 09:55:57','2016-06-08 09:55:57',NULL),(5,'Cửa đi 4 cánh mở quay 01','img398.png',0,33,'2016-06-08 09:56:42','2016-06-08 09:56:42',NULL),(6,'Cửa đi mở trượt 01','img591.png',1,8,'2016-06-08 10:15:11','2016-06-08 10:15:11',NULL),(7,'Cửa đi mở trượt 2 cánh 01','img551.png',0,34,'2016-06-08 10:15:37','2016-06-08 10:15:37',NULL),(8,'Cửa đi mở trượt 4 cánh 01','img133.png',0,35,'2016-06-08 10:16:19','2016-06-08 10:16:19',NULL),(9,'Cửa nhựa lõi thép xếp trượt 01','img159.png',1,9,'2016-06-08 10:17:32','2016-06-08 10:17:32',NULL),(10,'Cửa lùa 2 cánh, 4 cánh 01','img265.png',1,10,'2016-06-08 10:18:55','2016-06-08 10:18:55',NULL),(11,'Cửa nhựa lõi thép 01','img547.png',1,2,'2016-06-08 10:37:07','2016-06-08 10:37:07',NULL),(12,'Cửa đi mở quay 01','img483.png',1,11,'2016-06-08 10:37:40','2016-06-08 10:37:40',NULL),(13,'Cửa đi 1 cánh mở quay 01','img83.png',0,36,'2016-06-08 10:38:08','2016-06-08 10:38:08',NULL),(14,'Cửa đi 2 cánh mở quay 01','img121.png',0,37,'2016-06-08 10:38:33','2016-06-08 10:38:33',NULL),(15,'Cửa đi 4 cánh mở quay 01','img561.png',0,38,'2016-06-08 10:39:44','2016-06-08 10:39:44',NULL),(16,'Cửa đi mở trượt 01','img1.png',0,12,'2016-06-08 10:42:45','2016-06-08 10:42:45',NULL),(17,'Cửa đi mở trượt 2 cánh 01','img963.png',0,39,'2016-06-08 10:43:17','2016-06-08 10:43:17',NULL),(18,'Cửa đi mở trượt 4 cánh 01','img91.png',0,40,'2016-06-08 10:44:03','2016-06-08 10:44:03',NULL),(19,'Cửa nhựa lõi thép xếp trượt 01','img570.png',0,13,'2016-06-08 10:45:16','2016-06-08 10:45:16',NULL),(20,'Cửa lùa 2 cánh, 4 cánh 01','img92.png',0,14,'2016-06-08 10:45:47','2016-06-08 10:45:47',NULL),(21,'Mặt dựng nhôm kính 01','img672.png',1,3,'2016-06-08 10:46:29','2016-06-08 10:46:29',NULL),(22,'Mặt dựng nhôm kính Unitized 01','img456.png',0,15,'2016-06-08 10:47:43','2016-06-08 10:47:43',NULL),(23,'Mặt dựng nhôm kính Stick 01','img34.png',0,16,'2016-06-08 10:48:22','2016-06-08 10:48:22',NULL),(24,'Mặt dựng hệ AV 01','img144.png',0,17,'2016-06-08 10:50:01','2016-06-08 10:50:01',NULL),(25,'Mặt dựng đầu số 50x60 01','img943.png',0,18,'2016-06-08 10:50:34','2016-06-08 10:50:34',NULL),(26,'Mặt dựng cover cup 01','img228.png',0,19,'2016-06-08 10:51:06','2016-06-08 10:51:06',NULL),(27,'Mặt dựng spider 01','img704.png',0,20,'2016-06-08 10:52:04','2016-06-08 10:52:04',NULL),(28,'Mặt dựng kính Stick 01','img707.png',0,21,'2016-06-08 10:53:05','2016-06-08 10:53:05',NULL),(29,'Cầu thang, lan can kính 01','img957.png',1,4,'2016-06-08 10:55:02','2016-06-08 10:55:02',NULL),(30,'Cửa kính bản lề sàn 01','img165.png',1,5,'2016-06-08 10:55:44','2016-06-08 10:55:44',NULL),(31,'Cửa, vách kính phòng tắm 01','img10.png',1,6,'2016-06-08 10:56:27','2016-06-08 10:56:27',NULL),(32,'Cửa sổ mở trượt PK 800 01','img444.png',0,22,'2016-06-08 10:56:58','2016-06-08 10:56:58',NULL),(33,'Cửa sổ mở quay lật ( Công nghệ châu âu) hệ 45 01','img676.png',0,23,'2016-06-08 10:57:21','2016-06-08 10:57:21',NULL),(34,'Cửa sổ mở hất ngoài ( Công nghệ châu âu) hệ 55 01','img131.png',0,24,'2016-06-08 10:57:53','2016-06-08 10:57:53',NULL),(35,'Cửa sổ mở quay ( Công nghệ châu âu) hệ 55 01','img86.png',0,25,'2016-06-08 10:58:36','2016-06-08 10:58:36',NULL),(36,'Cửa đi xếp trượt ( Công nghệ châu âu) hệ 45 01','img678.png',0,26,'2016-06-08 10:58:58','2016-06-08 10:58:58',NULL),(37,'Cửa đi mở trượt ( Công nghệ châu âu) hệ SC-95 01','img376.png',0,27,'2016-06-08 10:59:39','2016-06-08 10:59:39',NULL),(38,'Cửa mở trượt ( Công nghệ châu âu) hệ 2001 01','img630.png',0,28,'2016-06-08 11:26:43','2016-06-08 11:26:43',NULL),(39,'Cửa đi mở quay ( Công nghệ châu âu) hệ 55 01','img388.png',0,29,'2016-06-08 11:27:26','2016-06-08 11:27:26',NULL),(40,'Cửa đi và cửa sổ hệ châu âu (P3) 01','img748.png',0,30,'2016-06-08 11:27:59','2016-06-08 11:27:59',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slider`
--

LOCK TABLES `slider` WRITE;
/*!40000 ALTER TABLE `slider` DISABLE KEYS */;
INSERT INTO `slider` VALUES (1,'slider1','slider1.jpg','2016-05-31 16:16:35','2016-05-31 16:16:35',NULL),(2,'slider2','slider2.jpg','2016-05-31 16:17:26','2016-05-31 16:17:26',NULL),(3,'slider3','slider3.jpg','2016-05-31 16:33:54','2016-05-31 16:33:54',NULL);
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
-- Table structure for table `tintuc`
--

DROP TABLE IF EXISTS `tintuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tintuc` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `detail` text CHARACTER SET utf8,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tintuc`
--

LOCK TABLES `tintuc` WRITE;
/*!40000 ALTER TABLE `tintuc` DISABLE KEYS */;
INSERT INTO `tintuc` VALUES (4,'Tin tức 123','<p>Tin tức 123</p>\r\n\r\n<p>Tin tức 123</p>\r\n','2016-06-11 17:22:46','2016-06-11 17:23:08',NULL),(5,'Tin tức 567','<p>Tin tức 567</p>\r\n','2016-06-11 17:46:11','2016-06-11 17:46:11',NULL);
/*!40000 ALTER TABLE `tintuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuyendung`
--

DROP TABLE IF EXISTS `tuyendung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuyendung` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `detail` text CHARACTER SET utf8,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL,
  `delete_at` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuyendung`
--

LOCK TABLES `tuyendung` WRITE;
/*!40000 ALTER TABLE `tuyendung` DISABLE KEYS */;
INSERT INTO `tuyendung` VALUES (4,'Tuyển dụng 12','<p>Tuyển dụng 12</p>\r\n\r\n<p>Tuyển dụng 12</p>\r\n','2016-06-11 17:42:17','2016-06-11 17:42:26',NULL);
/*!40000 ALTER TABLE `tuyendung` ENABLE KEYS */;
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

-- Dump completed on 2016-06-11 17:51:02
