/*
MySQL Data Transfer
Source Host: localhost
Source Database: mlzone
Target Host: localhost
Target Database: mlzone
Date: 2017-12-30 1:01:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_article_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_category`;
CREATE TABLE `tb_article_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) DEFAULT NULL,
  `parent_id` int(11) unsigned zerofill DEFAULT '00000000000',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_article_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_info`;
CREATE TABLE `tb_article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL,
  `image_path` varchar(128) DEFAULT NULL,
  `file_path` varchar(128) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `post_type` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `public_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `parent_comment_id` int(11) DEFAULT NULL,
  `send_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_recommendation
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommendation`;
CREATE TABLE `tb_recommendation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `link` varchar(32) DEFAULT NULL,
  `source` varchar(32) DEFAULT NULL,
  `author` varchar(16) DEFAULT NULL,
  `recommendation_type` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `recommend_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_star
-- ----------------------------
DROP TABLE IF EXISTS `tb_star`;
CREATE TABLE `tb_star` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL,
  `star_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `birthday` varchar(16) DEFAULT NULL,
  `phone_number` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `image` varchar(32) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `account_source` int(11) DEFAULT NULL,
  `reg_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_article_category` VALUES ('1', '机器学习', '00000000000', 'ML 机器学习相关文章');
INSERT INTO `tb_article_category` VALUES ('2', '数据库', '00000000000', 'database');
INSERT INTO `tb_article_category` VALUES ('3', '大数据', '00000000000', '大数据');
INSERT INTO `tb_article_info` VALUES ('1', 'SVM算法详解', '/data01/5.jpg', 'F:\\CSU\\Github\\BLOG\\csuldw.github.io\\source\\_posts\\2016-12-31-annual-review.md', null, '1', '决策树', '决策树12', '0', '1', '1', '2017-12-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('4', 'adaboost', null, 'E:\\article\\2014-12-21-InsertSort.md', null, '1', null, null, '0', '1', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('5', '数据库', null, 'E:\\article\\2014-12-21-InsertSort.md', null, '123424', '烦烦烦', null, '0', '2', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('6', 'stbc', '/data01/06.jpg', 'E:\\article\\2014-12-21-InsertSort.md', null, '1', null, null, '0', '1', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('9', 'test', '/data01/02 (2).jpg', 'E:\\article\\2014-12-21-InsertSort.md', '', '1', '', '', '0', '2', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('10', 'test', null, 'E:\\article\\2014-12-21-InsertSort.md', null, '1', null, null, '0', '2', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('11', '张三丰是如何炼成太极的', null, null, '123', '123', null, null, '0', '1', '1', '');
INSERT INTO `tb_comment` VALUES ('91', '123123', '1', '1', '1', '0', '2017-12-28 00:25:07');
INSERT INTO `tb_comment` VALUES ('92', '这篇文章好好！', '1', '1', '4', '0', '2017-12-28 00:33:35');
INSERT INTO `tb_comment` VALUES ('93', '这篇文章好好！', '1', '1', '6', '0', '2017-12-28 00:33:50');
INSERT INTO `tb_comment` VALUES ('94', '阿范德萨发', '1', '1', '0', '93', '2017-12-28 00:33:54');
INSERT INTO `tb_comment` VALUES ('95', 'subCommentForm', '1', '1', '1', '91', '2017-12-28 00:34:54');
INSERT INTO `tb_comment` VALUES ('96', '123123', '1', '1', '1', '95', '2017-12-28 00:35:26');
INSERT INTO `tb_comment` VALUES ('97', '123', '1', '1', '7', '0', '2017-12-28 00:35:54');
INSERT INTO `tb_comment` VALUES ('98', '1233444', '1', '1', '7', '97', '2017-12-28 00:35:57');
INSERT INTO `tb_comment` VALUES ('99', 'admin123', '1', '1', '7', '97', '2017-12-28 00:38:38');
INSERT INTO `tb_comment` VALUES ('100', '你好天下', '1', '1', '7', '0', '2017-12-28 00:38:48');
INSERT INTO `tb_comment` VALUES ('101', '小兄弟 你好', '1', '1', '5', '0', '2017-12-28 00:39:21');
INSERT INTO `tb_comment` VALUES ('102', 'OK', '1', '1', '5', '0', '2017-12-28 00:39:33');
INSERT INTO `tb_comment` VALUES ('103', '再见了', '1', '1', '5', '102', '2017-12-28 00:39:38');
INSERT INTO `tb_comment` VALUES ('104', 'dsaf', '1', '1', '4', '92', '2017-12-28 01:00:39');
INSERT INTO `tb_comment` VALUES ('105', 'adadadadad', '1', '1', '1', '0', '2017-12-29 01:11:37');
INSERT INTO `tb_recommendation` VALUES ('1', 'Python机器学习', null, 'www', 'csuldw', null, '1', null);
INSERT INTO `tb_user` VALUES ('1', 'admin', '范德萨', '0192023A7BBD73250516F069DF18B500', '0', null, '', null, '', null, null, null, '1', null, null);
INSERT INTO `tb_user` VALUES ('6', 'root', 'zola', 'admin', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '1', '1', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('13', 'zhangsan', 'zola', 'adminadmin', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '1', '0', '2017-12-12 23:21:42');
