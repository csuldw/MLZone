/*
MySQL Data Transfer
Source Host: localhost
Source Database: mlzone
Target Host: localhost
Target Database: mlzone
Date: 2017-10-29 14:33:17
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
  `file_path` varchar(64) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `post_type` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `public_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_article_category` VALUES ('1', '机器学习', '00000000000', 'ML 机器学习相关文章');
INSERT INTO `tb_article_category` VALUES ('2', '数据库', '00000000000', 'database');
INSERT INTO `tb_article_category` VALUES ('3', '大数据', '00000000000', '大数据');
INSERT INTO `tb_recommendation` VALUES ('1', 'Python机器学习', null, 'www', 'csuldw', null, '1', null);
INSERT INTO `tb_user` VALUES ('1', 'zhangsan1', null, 'admin', null, null, null, null, '湖南省', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('6', 'zhangsa12', null, 'admin', null, null, null, null, '湖南省', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('13', 'zhangsan', null, 'admin', null, null, null, null, '湖南省', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('15', 'zhangsan4', null, 'admin', null, null, null, null, '湖北省', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('19', 'zhangsan41', null, 'admin', null, null, null, null, '北京', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('20', 'zhangsan41222', null, 'admin', null, null, null, null, '深圳', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('23', 'zhangsan412221', null, 'admin', null, null, null, null, '广州', null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('25', 'zhangsa', null, 'admin', null, null, null, null, '上海', null, null, null, null, null, null);
