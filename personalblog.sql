/*
Navicat MySQL Data Transfer

Source Server         : LYX
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : personalblog

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-06-06 14:08:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `content` longtext,
  `cover_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `views` int DEFAULT NULL,
  `appreciation_enable` bit(1) NOT NULL,
  `shareStatement_enable` bit(1) NOT NULL,
  `comment_enable` bit(1) NOT NULL,
  `published` bit(1) NOT NULL,
  `recommend_enable` bit(1) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('16', '测试', 'cscs', 'www', 'https://th.wallhaven.cc/lg/57/57o9j5.jpg', '原创', '35', '', '', '', '', '', '2022-05-19 19:27:09', '2022-05-22 16:46:29', '24', '1');
INSERT INTO `t_blog` VALUES ('17', '测试11', 'cscscs', '# 测试', 'https://th.wallhaven.cc/lg/57/57o9j5.jpg', '原创', '1', '', '', '', '', '', '2022-05-23 13:54:54', '2022-05-22 16:46:35', '25', '1');
INSERT INTO `t_blog` VALUES ('18', '测试22', '测试222', '# 测试22', 'https://th.wallhaven.cc/lg/57/57o9j5.jpg', '原创', '2', '', '', '', '', '', '2020-12-01 14:18:28', '2022-05-22 16:46:40', '25', '1');
INSERT INTO `t_blog` VALUES ('21', '测试cs', '测试测试深层次生存手册升传说', '# 测试', 'https://th.wallhaven.cc/lg/57/57o9j5.jpg', '原创', '0', '\0', '\0', '\0', '', '', '2022-05-23 21:44:24', '2022-05-23 21:44:24', '26', '1');
INSERT INTO `t_blog` VALUES ('22', '啛啛喳喳', '冲冲冲', '存储\r\n[![e](https://th.wallhaven.cc/lg/57/57o9j5.jpg \"e\")](https://th.wallhaven.cc/lg/57/57o9j5.jpg \"e\")', 'https://th.wallhaven.cc/lg/57/57o9j5.jpg', '原创', '4', '', '', '', '', '', '2022-05-25 08:48:16', '2022-05-25 08:54:00', '24', '1');
INSERT INTO `t_blog` VALUES ('23', null, null, null, null, null, '0', '\0', '\0', '\0', '\0', '\0', '2022-06-02 08:37:10', '2022-06-02 08:37:10', null, null);

-- ----------------------------
-- Table structure for t_blogroll
-- ----------------------------
DROP TABLE IF EXISTS `t_blogroll`;
CREATE TABLE `t_blogroll` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blog_title` varchar(255) DEFAULT NULL,
  `blog_url` varchar(255) DEFAULT NULL,
  `blog_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_blogroll
-- ----------------------------
INSERT INTO `t_blogroll` VALUES ('1', 'L-toYthe-X', 'http://175.178.151.225:8080/', 'https://s1.ax1x.com/2022/05/26/XEHK0A.jpg');
INSERT INTO `t_blogroll` VALUES ('4', '白玉楼のYoumuこんぱく', 'https://ayou10031.cn/', 'https://s1.ax1x.com/2022/05/26/XVovi6.jpg');

-- ----------------------------
-- Table structure for t_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tag`;
CREATE TABLE `t_blog_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `blog_id` int DEFAULT NULL,
  `tag_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_blog_tag
-- ----------------------------
INSERT INTO `t_blog_tag` VALUES ('62', '16', '7');
INSERT INTO `t_blog_tag` VALUES ('63', '16', '11');
INSERT INTO `t_blog_tag` VALUES ('64', '17', '8');
INSERT INTO `t_blog_tag` VALUES ('65', '17', '13');
INSERT INTO `t_blog_tag` VALUES ('66', '18', '7');
INSERT INTO `t_blog_tag` VALUES ('67', '18', '13');
INSERT INTO `t_blog_tag` VALUES ('68', '21', '10');
INSERT INTO `t_blog_tag` VALUES ('69', '21', '11');
INSERT INTO `t_blog_tag` VALUES ('71', '22', '12');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `blog_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('23', '123', '123', '测试', '/img/Morty.jpg', '2022-05-22 16:50:56', '17');
INSERT INTO `t_comment` VALUES ('25', '姜泥誓杀徐凤年', '123123@qq.com', '测试', '/img/Morty.jpg', '2022-05-23 10:28:09', '16');
INSERT INTO `t_comment` VALUES ('26', '1111', '1111@qq.com', '芜湖', '/img/Morty.jpg', '2022-05-23 10:28:37', '18');
INSERT INTO `t_comment` VALUES ('28', '测试', '测试', '测试', '/img/Morty.jpg', '2022-05-24 18:21:15', '16');
INSERT INTO `t_comment` VALUES ('29', '测试', '测试', '测试', '/img/Morty.jpg', '2022-05-24 20:48:56', '-1');
INSERT INTO `t_comment` VALUES ('30', '123', '123', '测试', '/img/Morty.jpg', '2022-05-24 20:58:58', '16');
INSERT INTO `t_comment` VALUES ('31', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:21:45', '-1');
INSERT INTO `t_comment` VALUES ('32', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:00', '-1');
INSERT INTO `t_comment` VALUES ('33', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:04', '-1');
INSERT INTO `t_comment` VALUES ('34', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:06', '-1');
INSERT INTO `t_comment` VALUES ('35', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:09', '-1');
INSERT INTO `t_comment` VALUES ('36', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:13', '-1');
INSERT INTO `t_comment` VALUES ('37', '1', '1', '1', '/img/Morty.jpg', '2022-05-24 22:31:17', '-1');
INSERT INTO `t_comment` VALUES ('38', '2', '3', '1', '/img/Morty.jpg', '2022-05-25 15:45:23', '-1');
INSERT INTO `t_comment` VALUES ('39', '2323', '2323', '232323', '/img/Morty.jpg', '2022-05-25 15:45:31', '-1');
INSERT INTO `t_comment` VALUES ('40', '2', '2', '123\r\n123\r\n123', '/img/Morty.jpg', '2022-05-26 14:10:14', '-1');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('7', 'Java');
INSERT INTO `t_tag` VALUES ('8', 'MySql');
INSERT INTO `t_tag` VALUES ('9', 'Python');
INSERT INTO `t_tag` VALUES ('10', 'Linux');
INSERT INTO `t_tag` VALUES ('11', 'C');
INSERT INTO `t_tag` VALUES ('12', 'Redis');
INSERT INTO `t_tag` VALUES ('13', 'MongoDB');
INSERT INTO `t_tag` VALUES ('15', '生活点滴');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('22', '编程语言');
INSERT INTO `t_type` VALUES ('23', '操作系统');
INSERT INTO `t_type` VALUES ('24', '框架');
INSERT INTO `t_type` VALUES ('25', '数据库');
INSERT INTO `t_type` VALUES ('26', '插件分享');
INSERT INTO `t_type` VALUES ('27', '记录');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `emial` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'L-toYthe-X', 'lyx', '121f9f342d1505d5bebe7686ebbd332a', '1509982360@qq.com', '/img/pdx.jpg', '1', '2022-05-13 18:08:55', '2022-05-13 18:08:58');
