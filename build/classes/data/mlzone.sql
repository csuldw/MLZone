/*
MySQL Data Transfer
Source Host: localhost
Source Database: mlzone
Target Host: localhost
Target Database: mlzone
Date: 2017-10-14 23:47:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_article_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_category`;
CREATE TABLE `tb_article_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `public_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  `catetory_id` int(11) DEFAULT NULL,
  `recommend_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `username` varchar(32) DEFAULT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', null, null, '2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('2', 'zhangsan1', null, 'admin', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('4', 'zhangsan', null, '1234', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('5', '2', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('6', '2', null, '2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('7', '2', null, '2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('8', '2', null, '2', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('9', '2', null, '2', null, null, null, null, null, null, null, null, null, null, null);
