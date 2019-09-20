CREATE DATABASE  IF NOT EXISTS `irs` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `irs`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: irs
-- ------------------------------------------------------
-- Server version	5.7.27

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
-- Table structure for table `tb_admin`
--

DROP TABLE IF EXISTS `tb_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `salt` varchar(5) DEFAULT '',
  `fullname` varchar(50) NOT NULL COMMENT '全名',
  `e_mail` varchar(100) DEFAULT NULL,
  `sex` varchar(1) NOT NULL COMMENT '性别：0女，1男,2保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL COMMENT '地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_admin_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_admin`
--

LOCK TABLES `tb_admin` WRITE;
/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e',NULL,'arthur','duxiaod@qq.com','1','1994-11-08','陕西省西安市雁塔区','17693109997',1),(18,'test','e10adc3949ba59abbe56e057f20f883e',NULL,'test','test@test.com','1','2018-02-25','甘肃省兰州市榆中县和平镇','17601038192',61);
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_carousel`
--

DROP TABLE IF EXISTS `tb_carousel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_carousel` (
  `id` tinyint(8) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(100) NOT NULL,
  `imgLink` varchar(100) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `sorting` int(10) NOT NULL,
  `status` int(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_carousel`
--

LOCK TABLES `tb_carousel` WRITE;
/*!40000 ALTER TABLE `tb_carousel` DISABLE KEYS */;
INSERT INTO `tb_carousel` VALUES (8,'bf0df63ebce34f85bc60baf3fa264f30568.jpg','http://localhost:8080/irs/index.jsp','百姓关心的环境问题 习近平给出最新答案',200,0,'2018-05-20 23:36:49','2019-06-27 19:46:34'),(14,'bdf66d47298045588b88649020dcc9cb9895.png','http://123.com','1233333',32,1,'2018-12-11 20:17:20','2019-06-27 19:48:35'),(16,'dae184f5ce2c4c6e8db82c1f88b91edf8404.png','http://www.baidu.com','测试上传',1,1,'2019-06-26 15:02:03',NULL);
/*!40000 ALTER TABLE `tb_carousel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_company`
--

DROP TABLE IF EXISTS `tb_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `callNO` varchar(50) DEFAULT NULL,
  `adress` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `service_time` varchar(50) DEFAULT NULL COMMENT '服务时间',
  `logo` varchar(100) DEFAULT NULL,
  `website` char(20) DEFAULT NULL COMMENT '官网地址',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='公司信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_company`
--

LOCK TABLES `tb_company` WRITE;
/*!40000 ALTER TABLE `tb_company` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_feedback`
--

DROP TABLE IF EXISTS `tb_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `back_msg` varchar(500) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `del_flag` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='反馈表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_feedback`
--

LOCK TABLES `tb_feedback` WRITE;
/*!40000 ALTER TABLE `tb_feedback` DISABLE KEYS */;
INSERT INTO `tb_feedback` VALUES (1,'fsdfsdf','85227727@qq.com','1','2019-09-17 16:09:21',NULL);
/*!40000 ALTER TABLE `tb_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods`
--

DROP TABLE IF EXISTS `tb_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typs_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `discount` double DEFAULT NULL COMMENT '折扣',
  `img_ids` varchar(1000) DEFAULT NULL COMMENT '图片IDs',
  `sales` int(11) DEFAULT NULL COMMENT '已销售量',
  `store` int(11) DEFAULT NULL COMMENT '库存',
  `descs` varchar(500) DEFAULT NULL COMMENT '商品描述',
  `rifater` varchar(500) DEFAULT NULL COMMENT '特征',
  `status` char(20) DEFAULT NULL COMMENT '在售状态',
  `isrecommend` char(20) DEFAULT NULL COMMENT '是否推荐',
  `creat_time` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  `online_time` varchar(100) DEFAULT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `del_flag` char(20) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='产品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods`
--

LOCK TABLES `tb_goods` WRITE;
/*!40000 ALTER TABLE `tb_goods` DISABLE KEYS */;
INSERT INTO `tb_goods` VALUES (1,1,'轻奢纯棉刺绣水洗四件套',100,99,'<p><img src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" _src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" style=\"\"/></p>',899,168,'限时购','特征fsdf','0','1','','','','1','件','0');
/*!40000 ALTER TABLE `tb_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods_gallery`
--

DROP TABLE IF EXISTS `tb_goods_gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods_gallery` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) unsigned NOT NULL DEFAULT '0',
  `img_url` varchar(255) NOT NULL DEFAULT '',
  `img_desc` varchar(255) NOT NULL DEFAULT '',
  `sort_order` int(11) unsigned NOT NULL DEFAULT '5',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`)
) ENGINE=MyISAM AUTO_INCREMENT=681 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods_gallery`
--

LOCK TABLES `tb_goods_gallery` WRITE;
/*!40000 ALTER TABLE `tb_goods_gallery` DISABLE KEYS */;
INSERT INTO `tb_goods_gallery` VALUES (1,1006002,'http://yanxuan.nosdn.127.net/4eb09e08ac9de543d2291d27a6be0b54.jpg','',5),(2,1006002,'http://yanxuan.nosdn.127.net/0c9eb81c7594dbe42802ff1ebbece51a.jpg','',5),(3,1006002,'http://yanxuan.nosdn.127.net/8cfc7b6bfd28687ab3399da08e5ba61b.jpg','',5),(4,1006002,'http://yanxuan.nosdn.127.net/b98cfd7f197b62abd1679321eae253a6.jpg','',5),(5,1006007,'http://yanxuan.nosdn.127.net/b7e3438c473a296a7e9feecbd4139af5.jpg','',5),(6,1006007,'http://yanxuan.nosdn.127.net/70422011e5a9855a0723c9c08d0cbbb0.jpg','',5),(7,1006007,'http://yanxuan.nosdn.127.net/f65dbb00aff8b43be02f2c8104208877.jpg','',5),(8,1006007,'http://yanxuan.nosdn.127.net/85e8575c8e473a2f71054e9e36b1211c.jpg','',5),(9,1006010,'http://yanxuan.nosdn.127.net/9b40ba300851af1b84ca0749bae70718.jpg','',5),(10,1006010,'http://yanxuan.nosdn.127.net/fd7465ba32e23fd107161306d6b580cc.jpg','',5),(11,1006010,'http://yanxuan.nosdn.127.net/288dc3fe3238962519f3abd5201e411e.jpg','',5),(12,1006010,'http://yanxuan.nosdn.127.net/06cb7ac0991cb4ea236c826e8e6f0a9c.jpg','',5),(13,1006013,'http://yanxuan.nosdn.127.net/d83cbd9ec177276ba2582ee393eff3db.jpg','',5),(14,1006013,'http://yanxuan.nosdn.127.net/b73852cf22939c4995a5bc8996a4afdd.jpg','',5),(15,1006013,'http://yanxuan.nosdn.127.net/d2fe16d259e0187d6b53eef028e843d1.jpg','',5),(16,1006013,'http://yanxuan.nosdn.127.net/4e8f5c09ae9dd03b5ae5b1287b598cc5.jpg','',5),(17,1006014,'http://yanxuan.nosdn.127.net/22535d179b6796fbd45a83d6ecea3b50.jpg','',5);
/*!40000 ALTER TABLE `tb_goods_gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods_issue`
--

DROP TABLE IF EXISTS `tb_goods_issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods_issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type_id` varchar(255) DEFAULT NULL,
  `goods_id` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods_issue`
--

LOCK TABLES `tb_goods_issue` WRITE;
/*!40000 ALTER TABLE `tb_goods_issue` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_goods_issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods_type`
--

DROP TABLE IF EXISTS `tb_goods_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `decs` varchar(100) DEFAULT NULL COMMENT '描述',
  `order_no` char(20) DEFAULT NULL COMMENT '排序号',
  `status` char(20) DEFAULT NULL COMMENT '上线状态',
  `del_flag` char(20) DEFAULT '0' COMMENT '删除标记',
  `creat_time` varchar(100) DEFAULT NULL,
  `update_time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='产品类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods_type`
--

LOCK TABLES `tb_goods_type` WRITE;
/*!40000 ALTER TABLE `tb_goods_type` DISABLE KEYS */;
INSERT INTO `tb_goods_type` VALUES (1,'整点报时咕咕钟版','无可厚非无可奈何花落去','1','1','0','2019-06-27 17:30:25','2019-06-27 17:30:25');
/*!40000 ALTER TABLE `tb_goods_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_log`
--

DROP TABLE IF EXISTS `tb_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `operation` varchar(50) NOT NULL COMMENT '操作',
  `method` varchar(100) DEFAULT NULL COMMENT '执行方法',
  `params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=893 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_log`
--

LOCK TABLES `tb_log` WRITE;
/*!40000 ALTER TABLE `tb_log` DISABLE KEYS */;
INSERT INTO `tb_log` VALUES (701,'admin','更新轮播图状态','/ssm/carousel/update/11/0','11;0;','0:0:0:0:0:0:0:1','2018-09-19 16:53:04'),(702,'admin','更新轮播图状态','/ssm/carousel/update/11/1','11;1;','0:0:0:0:0:0:0:1','2018-09-19 16:53:07'),(703,'admin','更新轮播图状态','/ssm/carousel/update/11/0','11;0;','0:0:0:0:0:0:0:1','2018-09-19 16:53:11'),(704,'admin','更新轮播图状态','/ssm/carousel/update/11/1','11;1;','0:0:0:0:0:0:0:1','2018-09-19 16:53:16'),(705,'admin','删除指定的轮播图','/ssm/carousel/delete','10;','0:0:0:0:0:0:0:1','2018-09-19 16:53:47'),(706,'admin','添加轮播信息','/ssm/carousel/save','com.irs.pojo.TbCarousel@7abd9b;','0:0:0:0:0:0:0:1','2018-09-19 16:54:16'),(707,'系统自动任务','定时删除日志：329条','','','','2018-09-07 00:00:00'),(708,'admin','更新管理员信息','/ssm/sys/updAdmin','{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":62,\"roleName\":null};','0:0:0:0:0:0:0:1','2018-10-07 19:55:39'),(709,'admin','添加用户','/ssm/user/insUser','{\"uid\":null,\"eMail\":\"duxiaod@qq.com\",\"nickname\":\"tttt\",\"password\":\"tttttt\",\"sex\":\"1\",\"birthday\":\"2018-10-04\",\"address\":\"t\",\"phone\":\"17111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};','0:0:0:0:0:0:0:1','2018-10-09 11:31:16'),(710,'admin','更新轮播图','/ssm/carousel/update','{\"id\":12,\"imgurl\":\"1c7a37a6e71a4a1d8f38537377ed7ff46987.jpg\",\"imglink\":\"http://localhost:8080/irs_maven/index.jsp\",\"remark\":\"2222\",\"sorting\":34,\"status\":1,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-10-14 13:39:27'),(711,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,57,58,59\";','0:0:0:0:0:0:0:1','2018-10-16 11:21:42'),(712,'admin','更新轮播图状态','/ssm/carousel/update/8/0','8;0;','0:0:0:0:0:0:0:1','2018-10-16 11:35:17'),(713,'admin','更新轮播图','/ssm/carousel/update','{\"id\":8,\"imgurl\":\"01edd799479b404b91c39d24689a09981204.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"百姓关心的环境问题 习近平给出最新答案\",\"sorting\":200,\"status\":0,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-10-16 11:35:35'),(714,'admin','根据ID删除用户','/ssm/user/delUserByUid/31','\"31\";','0:0:0:0:0:0:0:1','2018-10-16 11:37:22'),(715,'admin','添加用户','/ssm/user/insUser','{\"uid\":null,\"eMail\":\"593151321@qq.com\",\"nickname\":\"2323\",\"password\":\"6hcjQTquG5sE\",\"sex\":\"1\",\"birthday\":\"2018-10-16\",\"address\":\"23232222222\",\"phone\":\"11111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};','0:0:0:0:0:0:0:1','2018-10-16 11:37:55'),(716,'admin','删除指定角色信息','/ssm/sys/delRole/62','62;','0:0:0:0:0:0:0:1','2018-10-16 11:43:32'),(717,'admin','删除指定角色信息','/ssm/sys/delRole/63','63;','0:0:0:0:0:0:0:1','2018-10-16 11:43:34'),(718,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";','0:0:0:0:0:0:0:1','2018-10-16 11:44:12'),(719,'admin','更新管理员信息','/ssm/sys/updAdmin','{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":61,\"roleName\":null};','0:0:0:0:0:0:0:1','2018-10-16 11:44:22'),(720,'admin','更新管理员信息','/ssm/sys/updAdmin','{\"id\":1,\"username\":\"admin\",\"password\":null,\"salt\":null,\"fullname\":\"arthur\",\"eMail\":\"duxiaod@qq.com\",\"sex\":\"1\",\"birthday\":\"1994-11-08\",\"address\":\"陕西省西安市雁塔区\",\"phone\":\"17693109997\",\"roleId\":1,\"roleName\":null};','0:0:0:0:0:0:0:1','2018-10-16 11:44:30'),(721,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";','0:0:0:0:0:0:0:1','2018-10-16 11:47:37'),(722,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":61,\"roleName\":\"test1\",\"roleRemark\":\"test1\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";','0:0:0:0:0:0:0:1','2018-10-17 09:15:50'),(723,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":61,\"roleName\":\"你好\",\"roleRemark\":\"你好\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";','0:0:0:0:0:0:0:1','2018-10-17 09:29:00'),(724,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":61,\"roleName\":\"test\",\"roleRemark\":\"test\"};\"1,2,3,16,4,20,46,47,9,11,34,14,15,42,43,44,45,51,52,53\";','0:0:0:0:0:0:0:1','2018-10-17 09:29:22'),(725,'admin','删除菜单信息','/ssm/sys/delMenuById/57','57;','0:0:0:0:0:0:0:1','2018-10-17 09:33:34'),(726,'admin','删除菜单信息','/ssm/sys/delMenuById/58','58;','0:0:0:0:0:0:0:1','2018-10-17 09:33:42'),(727,'admin','删除菜单信息','/ssm/sys/delMenuById/59','59;','0:0:0:0:0:0:0:1','2018-10-17 09:33:48'),(728,'admin','删除菜单信息','/ssm/sys/delMenuById/57','57;','0:0:0:0:0:0:0:1','2018-10-17 09:33:52'),(729,'admin','更新轮播图状态','/ssm/carousel/update/8/1','8;1;','0:0:0:0:0:0:0:1','2018-10-17 09:37:07'),(730,'admin','更新轮播图状态','/ssm/carousel/update/8/0','8;0;','0:0:0:0:0:0:0:1','2018-10-17 09:37:09'),(731,'admin','更新轮播图','/ssm/carousel/update','{\"id\":8,\"imgurl\":\"01edd799479b404b91c39d24689a09981204.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"百姓关心的环境问题 习近平给出最新答案\",\"sorting\":200,\"status\":0,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-10-17 09:37:16'),(732,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"232\",\"icon\":\"\",\"href\":\"\",\"perms\":\"2323\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-10-17 16:39:30'),(733,'admin','删除菜单信息','/ssm/sys/delMenuById/60','60;','0:0:0:0:0:0:0:1','2018-10-17 16:45:36'),(734,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:48:05'),(735,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:48:21'),(736,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:48:34'),(737,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-10-17 16:48:54'),(738,'admin','删除菜单信息','/ssm/sys/delMenuById/61','61;','0:0:0:0:0:0:0:1','2018-10-17 16:49:03'),(739,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理2\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:49:23'),(740,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":3,\"title\":\"角色管理1\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:53:16'),(741,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":3,\"title\":\"角色管理1\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:53:26'),(742,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-10-17 16:53:40'),(743,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":14,\"title\":\"test\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-10-17 16:53:47'),(744,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"test\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:53:59'),(745,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 16:54:08'),(746,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理1\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 17:03:17'),(747,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"test\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 17:03:27'),(748,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":15,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"log/logList\",\"perms\":\"\",\"spread\":null,\"parentId\":14,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-17 17:03:38'),(749,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":14,\"title\":\"日志管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-10-17 17:03:46'),(750,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":3,\"title\":\"角色管理\",\"icon\":\"\",\"href\":\"sys/roleList\",\"perms\":\"\",\"spread\":null,\"parentId\":2,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-10-18 11:50:54'),(751,'admin','批量删除用户','/ssm/user/delUsers/32','\"32\";','0:0:0:0:0:0:0:1','2018-10-18 11:52:34'),(752,'admin','添加用户','/ssm/user/insUser','{\"uid\":null,\"eMail\":\"593151321@qq.com\",\"nickname\":\"fsdf\",\"password\":\"fQAgwm3DEX2E\",\"sex\":\"1\",\"birthday\":\"2018-10-18\",\"address\":\"2331\",\"phone\":\"11111111111\",\"eCode\":null,\"status\":null,\"createTime\":null};','0:0:0:0:0:0:0:1','2018-10-18 11:52:52'),(753,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"123\",\"icon\":\"layui-icon-username\",\"href\":\"213\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":12,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:19:03'),(754,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"2323\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":23,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:22:04'),(755,'admin','删除菜单信息','/ssm/sys/delMenuById/63','63;','0:0:0:0:0:0:0:1','2018-11-13 16:22:16'),(756,'admin','删除菜单信息','/ssm/sys/delMenuById/64','64;','0:0:0:0:0:0:0:1','2018-11-13 16:22:34'),(757,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"23123\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":123,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:22:39'),(758,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":65,\"title\":\"23123\",\"icon\":\"\",\"href\":\"23\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":123,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-11-13 16:22:54'),(759,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":65,\"title\":\"123214\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:27:06'),(760,'admin','删除菜单信息','/ssm/sys/delMenuById/66','66;','0:0:0:0:0:0:0:1','2018-11-13 16:27:17'),(761,'admin','删除菜单信息','/ssm/sys/delMenuById/65','65;','0:0:0:0:0:0:0:1','2018-11-13 16:27:22'),(762,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"2313\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:27:33'),(763,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"2\",\"icon\":\"layui-icon-refresh-3\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:41:01'),(764,'admin','删除菜单信息','/ssm/sys/delMenuById/68','68;','0:0:0:0:0:0:0:1','2018-11-13 16:44:09'),(765,'admin','删除菜单信息','/ssm/sys/delMenuById/67','67;','0:0:0:0:0:0:0:1','2018-11-13 16:44:13'),(766,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":0,\"title\":\"123\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-11-13 16:44:21'),(767,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69\";','0:0:0:0:0:0:0:1','2018-11-13 16:45:30'),(768,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":52,\"title\":\"轮播管理\",\"icon\":\"\",\"href\":\"carousel/carouselList\",\"perms\":\"\",\"spread\":null,\"parentId\":51,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-11-13 16:48:15'),(769,'admin','鏇存柊杞挱鍥剧姸鎬�','/ssm/carousel/update/8/1','8;1;','0:0:0:0:0:0:0:1','2018-11-21 17:00:06'),(770,'admin','鏇存柊杞挱鍥剧姸鎬�','/ssm/carousel/update/8/0','8;0;','0:0:0:0:0:0:0:1','2018-11-21 17:00:07'),(771,'admin','添加轮播信息','/ssm/carousel/save','{\"id\":null,\"imgurl\":\"d21a9593a3434cd781d2cd13d09f52091808.png\",\"imglink\":\"http://localhost:8080/irs/index.jsp\",\"remark\":\"2323\",\"sorting\":23,\"status\":1,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-12-11 20:15:06'),(772,'admin','添加轮播信息','/ssm/carousel/save','{\"id\":null,\"imgurl\":\"020b601fc41c4d8d9102b3e5e9e6bfda6285.png\",\"imglink\":\"http://123.com\",\"remark\":\"1233333\",\"sorting\":32,\"status\":1,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-12-11 20:17:19'),(773,'admin','添加轮播信息','/ssm/carousel/save','{\"id\":null,\"imgurl\":\"bfa6a44518b442e4907c2fd9d1a6b43c6704.jpg\",\"imglink\":\"http://localhost:8080/ssm/index.jsp\",\"remark\":\"123123\",\"sorting\":2,\"status\":1,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-12-11 20:38:23'),(774,'admin','添加轮播信息','/ssm/carousel/save','{\"id\":null,\"imgurl\":\"c6cff9ee8e144af3b423e33c78d8c0863365.png\",\"imglink\":\"http://localhost:8080/ssm/index.jsp\",\"remark\":\"12312\",\"sorting\":213,\"status\":1,\"createTime\":null,\"updateTime\":null};','0:0:0:0:0:0:0:1','2018-12-11 20:42:10'),(775,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":69,\"title\":\"多数据源\",\"icon\":\"\",\"href\":\"dynamic/db\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-12-12 12:45:51'),(776,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":69,\"title\":\"多数据源\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-12-12 12:46:20'),(777,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":69,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/db\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2018-12-12 12:46:40'),(778,'admin','更新角色信息','/ssm/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69,70\";','0:0:0:0:0:0:0:1','2018-12-12 12:46:55'),(779,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page/1\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-12-12 12:48:16'),(780,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-12-12 12:56:45'),(781,'admin','维护菜单信息','/ssm/sys/menuForm','{\"menuId\":70,\"title\":\"oracle库\",\"icon\":\"\",\"href\":\"dynamic/page/1\",\"perms\":\"dynamic:dynamic:view\",\"spread\":null,\"parentId\":69,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2018-12-12 12:59:54'),(782,'admin','鏇存柊绠＄悊鍛樹俊鎭�','/ssm/sys/updAdmin','{\"id\":1,\"username\":\"admin\",\"password\":null,\"salt\":null,\"fullname\":\"arthur\",\"eMail\":\"duxiaod@qq.com\",\"sex\":\"1\",\"birthday\":\"1994-11-08\",\"address\":\"陕西省西安市雁塔区\",\"phone\":\"17693109997\",\"roleId\":1,\"roleName\":null};','0:0:0:0:0:0:0:1','2018-12-29 16:50:16'),(783,'admin','更新管理员信息','/irs-maven/sys/updAdmin','{\"id\":18,\"username\":\"test\",\"password\":null,\"salt\":null,\"fullname\":\"test\",\"eMail\":\"test@test.com\",\"sex\":\"1\",\"birthday\":\"2018-02-25\",\"address\":\"甘肃省兰州市榆中县和平镇\",\"phone\":\"17601038192\",\"roleId\":61,\"roleName\":null};','0:0:0:0:0:0:0:1','2019-03-19 17:53:06'),(784,'admin','维护菜单信息','/sys/menuForm','{\"menuId\":0,\"title\":\"接口工具\",\"icon\":\"\",\"href\":\"swagger-ui.html\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":500,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-04-11 17:56:21'),(785,'admin','更新角色信息','/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,43,44,45,51,52,53,54,55,56,69,70,71\";','0:0:0:0:0:0:0:1','2019-04-11 17:56:34'),(786,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71\";','0:0:0:0:0:0:0:1','2019-09-16 09:43:46'),(787,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:48:48'),(788,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:49:28'),(789,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"查看\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"goods:goods:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:50:22'),(790,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73\";','0:0:0:0:0:0:0:1','2019-09-16 09:51:12'),(791,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73\";','0:0:0:0:0:0:0:1','2019-09-16 09:51:34'),(792,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"类型管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":72,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:53:19'),(793,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:53:33'),(794,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"goods:goods:list\",\"spread\":null,\"parentId\":72,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:54:09'),(795,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"\",\"spread\":null,\"parentId\":72,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:54:27'),(796,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"查看\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"goods:goods:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:55:05'),(797,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:55:31'),(798,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:55:40'),(799,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 09:55:50'),(800,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,74,75,76,77,78\";','0:0:0:0:0:0:0:1','2019-09-16 09:56:44'),(801,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":74,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"goods/goodsList\",\"perms\":\"\",\"spread\":null,\"parentId\":72,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:58:22'),(802,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":75,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:list\",\"spread\":null,\"parentId\":74,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 09:58:51'),(803,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"查看\",\"icon\":\"\",\"href\":\"goodsType/goodsTypeList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 10:30:32'),(804,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"类型管理\",\"icon\":\"\",\"href\":\"goodsType/goodsTypeList\",\"perms\":\"\",\"spread\":null,\"parentId\":72,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:30:57'),(805,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":79,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsType:goodsType:list\",\"spread\":null,\"parentId\":73,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:31:20'),(806,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,74,75,76,77,78\";','0:0:0:0:0:0:0:1','2019-09-16 10:32:19'),(807,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":1,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:33:09'),(808,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9999,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:33:25'),(809,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":72,\"title\":\"商品管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9998,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:34:00'),(810,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":78,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:save\",\"spread\":null,\"parentId\":74,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:46:34'),(811,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":77,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:update\",\"spread\":null,\"parentId\":74,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:47:02'),(812,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":76,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goods:goods:delete\",\"spread\":null,\"parentId\":74,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:47:22'),(813,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsType:goodsType:save\\\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 10:47:50'),(814,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":80,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsType:goodsType:save\",\"spread\":null,\"parentId\":73,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 10:48:02'),(815,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsType:goodsType:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 10:48:29'),(816,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":73,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsType:goodsType:delete\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 10:48:51'),(817,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78\";','0:0:0:0:0:0:0:1','2019-09-16 11:12:11'),(818,'admin','获取产品类型下拉','/irs_maven_war_exploded/goodsType/getGoodsTypeItem','','0:0:0:0:0:0:0:1','2019-09-16 11:12:57'),(819,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:14:46'),(820,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:15:21'),(821,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:15:56'),(822,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:16:27'),(823,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:16:47'),(824,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,83,84,85,86\";','0:0:0:0:0:0:0:1','2019-09-16 11:18:43'),(825,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/84','84;','0:0:0:0:0:0:0:1','2019-09-16 11:23:26'),(826,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/85','85;','0:0:0:0:0:0:0:1','2019-09-16 11:23:31'),(827,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/86','86;','0:0:0:0:0:0:0:1','2019-09-16 11:23:36'),(828,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:24:14'),(829,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/87','87;','0:0:0:0:0:0:0:1','2019-09-16 11:25:56'),(830,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 11:26:26'),(831,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"company:company:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:26:52'),(832,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":88,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":83,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 11:27:24'),(833,'admin','列表上修改状态','/irs_maven_war_exploded/goodsType/update/1/0','1;\"0\";','0:0:0:0:0:0:0:1','2019-09-16 11:32:40'),(834,'admin','列表上修改状态','/irs_maven_war_exploded/goodsType/update/1/1','1;\"1\";','0:0:0:0:0:0:0:1','2019-09-16 11:32:41'),(835,'admin','获取产品类型下拉','/irs_maven_war_exploded/goodsType/getGoodsTypeItem','','0:0:0:0:0:0:0:1','2019-09-16 13:54:19'),(836,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-16 14:38:38'),(837,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":88,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":83,\"sorting\":9997,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:46:25'),(838,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":83,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9997,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:46:43'),(839,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":88,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":83,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:47:13'),(840,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":88,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":83,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:48:17'),(841,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/83','83;','0:0:0:0:0:0:0:1','2019-09-17 15:49:45'),(842,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/88','88;','0:0:0:0:0:0:0:1','2019-09-17 15:49:52'),(843,'admin','删除菜单信息','/irs_maven_war_exploded/sys/delMenuById/83','83;','0:0:0:0:0:0:0:1','2019-09-17 15:49:56'),(844,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":9997,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:50:54'),(845,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":89,\"title\":\"公司管理\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":99,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:51:42'),(846,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":90,\"title\":\"查看\",\"icon\":\"\",\"href\":\"company/companyList\",\"perms\":\"company:company:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:52:14'),(847,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":90,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:52:50'),(848,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":92,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:update\",\"spread\":null,\"parentId\":90,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:53:21'),(849,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92\";','0:0:0:0:0:0:0:1','2019-09-17 15:53:43'),(850,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"文章管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:55:24'),(851,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":93,\"title\":\"文章管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9996,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:55:37'),(852,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":93,\"title\":\"文章管理\",\"icon\":\"\",\"href\":\"goodsArticle/goodsArticleList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":999,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:56:23'),(853,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsArticle:goodsArticle:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:56:45'),(854,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92,93,94,95\";','0:0:0:0:0:0:0:1','2019-09-17 15:57:40'),(855,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"反馈管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:59:07'),(856,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":96,\"title\":\"反馈管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9995,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 15:59:18'),(857,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":96,\"title\":\"反馈管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"feedback:feedback:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 15:59:49'),(858,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":97,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"feedback:feedback:list\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:00:11'),(859,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":97,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"feedback:feedback:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:00:37'),(860,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":97,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"feedback:feedback:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:00:59'),(861,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":97,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"feedback:feedback:delete\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:01:16'),(862,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92,93,94,95,96,97,98,99,100,101\";','0:0:0:0:0:0:0:1','2019-09-17 16:01:30'),(863,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":90,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:03:08'),(864,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":97,\"title\":\"反馈管理\",\"icon\":\"\",\"href\":\"feedback/feedbackList\",\"perms\":\"\",\"spread\":null,\"parentId\":96,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:08:33'),(865,'admin','添加产品类别信息','/irs_maven_war_exploded/feedback/save','{\"id\":null,\"name\":\"fsdfsdf\",\"email\":\"85227727@qq.com\",\"backMsg\":\"1\",\"createTime\":null,\"delFlag\":null};','0:0:0:0:0:0:0:1','2019-09-17 16:09:21'),(866,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"文章管理\",\"icon\":\"\",\"href\":\"goodsArticle/goodsArticleList\",\"perms\":\"\",\"spread\":null,\"parentId\":93,\"sorting\":999,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:10:07'),(867,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"使用说明管理\",\"icon\":\"\",\"href\":\"goodsIssue/goodsIssueList\",\"perms\":\"\",\"spread\":null,\"parentId\":93,\"sorting\":999,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:11:23'),(868,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":93,\"title\":\"使用说明管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9996,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:11:41'),(869,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":95,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsIssue:goodsIssue:list\",\"spread\":null,\"parentId\":94,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:12:00'),(870,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsIssue:goodsIssue:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:12:48'),(871,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsIssue:goodsIssue:delete\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:13:04'),(872,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsIssue:goodsIssue:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 16:13:21'),(873,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":103,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"goodsIssue:goodsIssue:save\",\"spread\":null,\"parentId\":94,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:15:30'),(874,'admin','获取产品类型下拉','/irs_maven_war_exploded/goodsType/getGoodsTypeItem','','0:0:0:0:0:0:0:1','2019-09-17 16:19:06'),(875,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":102,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"company:company:save\",\"spread\":null,\"parentId\":90,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 16:20:37'),(876,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92,102,93,94,95,103,104,105,96,97,98,99,100,101\";','0:0:0:0:0:0:0:1','2019-09-17 16:20:59'),(877,'admin','获取产品类型下拉','/irs_maven_war_exploded/goods/selGoodsListById/1','1;','0:0:0:0:0:0:0:1','2019-09-17 17:30:11'),(878,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":94,\"title\":\"问题说明管理\",\"icon\":\"\",\"href\":\"goodsIssue/goodsIssueList\",\"perms\":\"\",\"spread\":null,\"parentId\":93,\"sorting\":999,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:31:07'),(879,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":93,\"title\":\"问题说明管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9996,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:31:48'),(880,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":0,\"title\":\"使用说明书管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:32:30'),(881,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":106,\"title\":\"使用说明书管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9994,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:32:41'),(882,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92,102,93,94,95,103,104,105,96,97,98,99,100,101,106\";','0:0:0:0:0:0:0:1','2019-09-17 17:32:59'),(883,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":106,\"title\":\"富文本管理\",\"icon\":\"\",\"href\":\"\",\"perms\":\"\",\"spread\":null,\"parentId\":0,\"sorting\":9994,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:33:37'),(884,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":106,\"title\":\"富文本管理\",\"icon\":\"\",\"href\":\"goodsArticle/goodsArticleList\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:34:38'),(885,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":107,\"title\":\"查看\",\"icon\":\"\",\"href\":\"goodsArticle:goodsArticle:list\",\"perms\":\"\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:34:55'),(886,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":107,\"title\":\"富文本管理\",\"icon\":\"\",\"href\":\"articleType/articleTypeList\",\"perms\":\"\",\"spread\":null,\"parentId\":106,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:36:07'),(887,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":108,\"title\":\"查看\",\"icon\":\"\",\"href\":\"articleType:articleType:list\",\"perms\":\"\",\"spread\":null,\"parentId\":107,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:36:25'),(888,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":108,\"title\":\"查看\",\"icon\":\"\",\"href\":\"\",\"perms\":\"articleType:articleType:list\",\"spread\":null,\"parentId\":107,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"\";','0:0:0:0:0:0:0:1','2019-09-17 17:36:39'),(889,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":107,\"title\":\"修改\",\"icon\":\"\",\"href\":\"\",\"perms\":\"articleType:articleType:update\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:37:02'),(890,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":107,\"title\":\"新增\",\"icon\":\"\",\"href\":\"\",\"perms\":\"articleType:articleType:save\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:37:37'),(891,'admin','维护菜单信息','/irs_maven_war_exploded/sys/menuForm','{\"menuId\":107,\"title\":\"删除\",\"icon\":\"\",\"href\":\"\",\"perms\":\"articleType:articleType:delete\",\"spread\":null,\"parentId\":null,\"sorting\":null,\"checked\":null,\"isOpen\":false};\"1\";','0:0:0:0:0:0:0:1','2019-09-17 17:37:52'),(892,'admin','更新角色信息','/irs_maven_war_exploded/sys/updRole','{\"roleId\":1,\"roleName\":\"超级管理员\",\"roleRemark\":\"超级管理员\"};\"1,2,3,16,17,18,19,4,20,21,22,23,46,47,48,49,50,9,10,33,11,34,35,36,37,14,15,42,62,43,44,45,51,52,53,54,55,56,69,70,71,72,73,79,80,81,82,74,75,76,77,78,89,90,91,92,102,93,94,95,103,104,105,96,97,98,99,100,101,106,107,108,109,110,111\";','0:0:0:0:0:0:0:1','2019-09-17 17:38:08');
/*!40000 ALTER TABLE `tb_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menus`
--

DROP TABLE IF EXISTS `tb_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menus` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '菜单名',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `href` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `spread` varchar(10) NOT NULL COMMENT 'true：展开，false：不展开',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  `sorting` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menus`
--

LOCK TABLES `tb_menus` WRITE;
/*!40000 ALTER TABLE `tb_menus` DISABLE KEYS */;
INSERT INTO `tb_menus` VALUES (1,'后台首页','','page/main.html','','false',0,9999),(2,'管理员管理','','','','false',0,999),(3,'角色管理','','sys/roleList','','false',2,99),(4,'管理员列表','&#xe613;','sys/adminList',NULL,'false',2,98),(9,'用户管理','&#xe61d;',NULL,NULL,'false',0,998),(10,'添加用户','&#xe608;','user/addUser',NULL,'false',9,NULL),(11,'管理用户','&#xe60e;','user/userList',NULL,'false',9,NULL),(14,'系统日志','&#xe61d;',NULL,NULL,'false',0,995),(15,'日志管理','','log/logList','','false',14,NULL),(16,'查看','','','sys:role:list','false',3,NULL),(17,'新增',NULL,NULL,'sys:role:save','false',3,NULL),(18,'修改',NULL,NULL,'sys:role:update','false',3,NULL),(19,'删除',NULL,NULL,'sys:role:delete','false',3,NULL),(20,'查看',NULL,NULL,'sys:admin:list','false',4,NULL),(21,'新增',NULL,NULL,'sys:admin:save','false',4,NULL),(22,'修改',NULL,NULL,'sys:admin:update','false',4,NULL),(23,'删除',NULL,NULL,'sys:admin:delete','false',4,NULL),(33,'新增',NULL,NULL,'user:user:save','false',10,NULL),(34,'查看',NULL,NULL,'user:user:list','false',11,NULL),(35,'新增',NULL,NULL,'user:user:save','false',11,NULL),(36,'修改',NULL,NULL,'user:user:update','false',11,NULL),(37,'删除',NULL,NULL,'user:user:delete','false',11,NULL),(42,'查看','','','log:log:list','false',15,NULL),(43,'SQL监控','&#xe642;',NULL,NULL,'false',0,996),(44,'SQL监控','&#xe642;','sys/druid',NULL,'false',43,NULL),(45,'查看',NULL,NULL,'sys:druid:list','false',44,NULL),(46,'菜单管理','&#xe642;','sys/menuList',NULL,'false',2,97),(47,'查看',NULL,NULL,'sys:menu:list','false',46,NULL),(48,'新增',NULL,NULL,'sys:menu:save','false',46,NULL),(49,'修改',NULL,NULL,'sys:menu:update','false',46,NULL),(50,'删除',NULL,NULL,'sys:menu:delete','false',46,NULL),(51,'轮播管理','','','','false',0,997),(52,'轮播管理','','carousel/carouselList','','false',51,NULL),(53,'查看','','','carousel:carousel:list','false',52,NULL),(54,'删除','','','carousel:carousel:delete','false',52,NULL),(55,'修改','','','carousel:carousel:update','false',52,NULL),(56,'新增','','','carousel:carousel:save','false',52,NULL),(62,'test','','','','false',14,NULL),(69,'多数据源','','','','false',0,1),(70,'oracle库','','dynamic/page/1','dynamic:dynamic:view','false',69,NULL),(71,'接口工具','','swagger-ui.html','','false',0,0),(72,'商品管理','','','','false',0,9998),(73,'类型管理','','goodsType/goodsTypeList','','false',72,NULL),(74,'商品管理','','goods/goodsList','','false',72,NULL),(75,'查看','','','goods:goods:list','false',74,NULL),(76,'删除','','','goods:goods:delete','false',74,NULL),(77,'修改','','','goods:goods:update','false',74,NULL),(78,'新增','','','goods:goods:save','false',74,NULL),(79,'查看','','','goodsType:goodsType:list','false',73,NULL),(80,'新增','','','goodsType:goodsType:save','false',73,NULL),(81,'修改','','','goodsType:goodsType:update','false',73,NULL),(82,'删除','','','goodsType:goodsType:delete','false',73,NULL),(89,'公司管理','','','','false',0,9997),(90,'公司管理','','company/companyList','','false',89,99),(91,'查看','','company/companyList','company:company:list','false',90,NULL),(92,'修改','','','company:company:update','false',90,NULL),(93,'问题说明管理','','','','false',0,9996),(94,'问题说明管理','','goodsIssue/goodsIssueList','','false',93,999),(95,'查看','','','goodsIssue:goodsIssue:list','false',94,NULL),(96,'反馈管理','','','','false',0,9995),(97,'反馈管理','','feedback/feedbackList','','false',96,NULL),(98,'查看','','','feedback:feedback:list','false',97,NULL),(99,'修改','','','feedback:feedback:update','false',97,NULL),(100,'新增','','','feedback:feedback:save','false',97,NULL),(101,'删除','','','feedback:feedback:delete','false',97,NULL),(102,'新增','','','company:company:save','false',90,NULL),(103,'新增','','','goodsIssue:goodsIssue:save','false',94,NULL),(104,'删除','','','goodsIssue:goodsIssue:delete','false',94,NULL),(105,'修改','','','goodsIssue:goodsIssue:update','false',94,NULL),(106,'富文本管理','','','','false',0,9994),(107,'富文本管理','','articleType/articleTypeList','','false',106,NULL),(108,'查看','','','articleType:articleType:list','false',107,NULL),(109,'修改','','','articleType:articleType:update','false',107,NULL),(110,'新增','','','articleType:articleType:save','false',107,NULL),(111,'删除','','','articleType:articleType:delete','false',107,NULL);
/*!40000 ALTER TABLE `tb_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES (1,'超级管理员','超级管理员'),(61,'test','test');
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles_menus`
--

DROP TABLE IF EXISTS `tb_roles_menus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_roles_menus` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_roles_menus_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menus` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_roles_menus_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles_menus`
--

LOCK TABLES `tb_roles_menus` WRITE;
/*!40000 ALTER TABLE `tb_roles_menus` DISABLE KEYS */;
INSERT INTO `tb_roles_menus` VALUES (1,1),(2,1),(3,1),(4,1),(9,1),(10,1),(11,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(33,1),(34,1),(35,1),(36,1),(37,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(62,1),(69,1),(70,1),(71,1),(72,1),(73,1),(74,1),(75,1),(76,1),(77,1),(78,1),(79,1),(80,1),(81,1),(82,1),(89,1),(90,1),(91,1),(92,1),(93,1),(94,1),(95,1),(96,1),(97,1),(98,1),(99,1),(100,1),(101,1),(102,1),(103,1),(104,1),(105,1),(106,1),(107,1),(108,1),(109,1),(110,1),(111,1),(1,61),(2,61),(3,61),(4,61),(9,61),(11,61),(14,61),(15,61),(16,61),(20,61),(34,61),(42,61),(43,61),(44,61),(45,61),(46,61),(47,61),(51,61),(52,61),(53,61);
/*!40000 ALTER TABLE `tb_roles_menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_test`
--

DROP TABLE IF EXISTS `tb_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_test`
--

LOCK TABLES `tb_test` WRITE;
/*!40000 ALTER TABLE `tb_test` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_users`
--

DROP TABLE IF EXISTS `tb_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_users` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL COMMENT '昵称：唯一',
  `password` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL COMMENT '0:女，1:男，2：保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `e_code` varchar(50) NOT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0:未激活，1，正常，2，禁用',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_users`
--

LOCK TABLES `tb_users` WRITE;
/*!40000 ALTER TABLE `tb_users` DISABLE KEYS */;
INSERT INTO `tb_users` VALUES (27,'isduxd@qq.com','test','96e79218965eb72c92a549dd5a330112','0','2018-03-25','北京通州科创十四街区','17693109923','b3f28566dac54f86bd4f4c2ce36e23d8019','1','2018-03-25 14:48:48'),(28,'123@qq.com','2113','96e79218965eb72c92a549dd5a330112','1','2018-07-26','123123','17693109997','c6411671821c43ca926c032e51ded16a897','1','2018-07-27 09:59:16'),(29,'sdf@163.com','123123','96e79218965eb72c92a549dd5a330112','2','2018-07-27','123123','17111111111','92197e8f8a5647ae8be96fe2db555575147','1','2018-07-27 14:23:55'),(30,'test@126.com','dxd','e10adc3949ba59abbe56e057f20f883e','1','2018-07-31','西安市高新区',NULL,'f5140a3af98c4d7cba05436ac090ae80508','1','2018-10-06 13:29:47'),(33,'593151321@qq.com','fsdf','c2909c4ab63391a7aa438ef83c3d66a8','1','2018-10-18','2331','11111111111','b8c5626e77f04e5daac756aca08330d1750','1','2018-10-18 11:52:52'),(34,'test@126.com','dxd','e10adc3949ba59abbe56e057f20f883e','1','2018-07-31','西安市高新区',NULL,'1cb4c8f364204c1b8515f0c5555d1ba1615','1','2019-04-11 14:46:43');
/*!40000 ALTER TABLE `tb_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'irs'
--

--
-- Dumping routines for database 'irs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-20 16:59:47
