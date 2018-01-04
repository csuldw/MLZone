/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : mlzone

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-01-04 18:58:56
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
-- Records of tb_article_category
-- ----------------------------
INSERT INTO `tb_article_category` VALUES ('1', '机器学习', '00000000000', 'ML 机器学习相关文章');
INSERT INTO `tb_article_category` VALUES ('2', '数据库', '00000000000', 'database');
INSERT INTO `tb_article_category` VALUES ('3', '大数据', '00000000000', '大数据');

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
  `view_count` int(11) DEFAULT '0' COMMENT '阅读数',
  `is_publish` int(11) DEFAULT NULL,
  `public_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article_info
-- ----------------------------
INSERT INTO `tb_article_info` VALUES ('1', 'SVM算法详解', '/data01/5.jpg', '/data01/2016-08-28-adaboost-algorithm-theory.md', '长不', '0', '决策树', '决策树12', '0', '1', '114', '1', '2017-12-21 10:24:22');
INSERT INTO `tb_article_info` VALUES ('4', 'adaboost', null, '/data01/f1514649909375-2014-12-22-choiceSort.md', '不二', '712', null, null, '0', '2', '17', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('5', '数据库', null, '/data01/2014-12-26-MergeSort.md', '不二', '712', '烦烦烦', null, '0', '2', '16', '1', '2017-11-23 10:24:22');
INSERT INTO `tb_article_info` VALUES ('6', 'stbc', '/data01/06.jpg', '/data01/2015-07-05-ML-algorithm-Adaboost.md', '不二', '712', null, null, '0', '1', '17', '1', '2017-11-24 10:24:22');
INSERT INTO `tb_article_info` VALUES ('9', 'test', '/data01/02 (2).jpg', 'E:\\article\\2014-12-21-InsertSort.md', '不二', '712', '', '', '0', '2', '13', '1', '2017-11-25 10:24:22');
INSERT INTO `tb_article_info` VALUES ('10', 'test', null, 'E:\\article\\2014-12-21-InsertSort.md', '不二', '712', null, null, '0', '2', '12', '1', '2017-11-26 10:24:22');
INSERT INTO `tb_article_info` VALUES ('11', '张三丰是如何炼成太极的', null, '/data01/2017-09-22-hello-september.md', '不二', '712', null, null, '0', '1', '15', '1', '2017-12-28 16:08:57');
INSERT INTO `tb_article_info` VALUES ('13', '心气', null, '/data01/2017-09-22-hello-september.md', '不二', '712', null, null, '0', '1', '14', '1', '2017-12-30 16:08:57');
INSERT INTO `tb_article_info` VALUES ('14', '叼叼叼', null, '/data01/2017-09-22-hello-september.md', '不二', '712', null, null, '0', '1', '11', '1', '2017-12-30 16:10:30');
INSERT INTO `tb_article_info` VALUES ('15', '啊大幅度', null, '/data01/f1514625264836-2015-05-28-NB.md', '不二', '712', null, null, '0', '1', '11', '1', '2017-12-30 17:14:26');
INSERT INTO `tb_article_info` VALUES ('16', '是非得失', null, '/data01/2017-09-22-hello-september.md', '11111', '712', null, null, '0', '1', '12', '1', '2017-12-30 17:14:35');

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL COMMENT 'about页面为-1, links为 -2',
  `parent_comment_id` int(11) DEFAULT NULL,
  `send_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('149', '123123', '712', '712', '4', '0', '2018-01-02 22:54:56');
INSERT INTO `tb_comment` VALUES ('150', '123123', '712', '712', '4', '149', '2018-01-02 22:55:01');
INSERT INTO `tb_comment` VALUES ('151', 'root', '6', '712', '4', '149', '2018-01-02 22:55:28');
INSERT INTO `tb_comment` VALUES ('152', 'root123', '6', '712', '4', '0', '2018-01-02 22:57:16');
INSERT INTO `tb_comment` VALUES ('153', 'admin', '712', '712', '4', '0', '2018-01-02 23:35:45');
INSERT INTO `tb_comment` VALUES ('154', '12312312', '712', '712', '0', '0', '2018-01-04 00:52:04');
INSERT INTO `tb_comment` VALUES ('155', '12312', '712', '712', '-2', '0', '2018-01-04 00:54:33');
INSERT INTO `tb_comment` VALUES ('156', '123123123', '712', '712', '-1', '0', '2018-01-04 00:54:37');
INSERT INTO `tb_comment` VALUES ('157', '范德萨发', '712', '712', '-1', '0', '2018-01-04 00:54:39');
INSERT INTO `tb_comment` VALUES ('158', '范德萨发', '712', '712', '-1', '157', '2018-01-04 00:54:45');
INSERT INTO `tb_comment` VALUES ('159', '123123', '712', '712', '-1', '0', '2018-01-04 00:54:49');

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
-- Records of tb_recommendation
-- ----------------------------
INSERT INTO `tb_recommendation` VALUES ('1', 'Python机器学习', null, 'www', 'csuldw', null, '1', null);

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
-- Records of tb_star
-- ----------------------------

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
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `account_source` int(11) DEFAULT NULL,
  `reg_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=713 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('6', 'root', 'zola', '0192023A7BBD73250516F069DF18B500', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '0', '1', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('13', 'zhangsan', 'zola', 'adminadmin', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '1', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('712', 'admin', '不二', '0192023A7BBD73250516F069DF18B500', '0', null, '', null, '', null, null, null, '1', null, null);

-- ----------------------------
-- Table structure for tb_web_source
-- ----------------------------
DROP TABLE IF EXISTS `tb_web_source`;
CREATE TABLE `tb_web_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(128) DEFAULT NULL COMMENT '链接',
  `avator` varchar(128) DEFAULT NULL COMMENT '头像',
  `author` varchar(64) DEFAULT NULL COMMENT '资源作者',
  `source_type` varchar(64) DEFAULT NULL COMMENT '资源类型：openSource; link',
  `desc` text COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_web_source
-- ----------------------------
INSERT INTO `tb_web_source` VALUES ('1', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('2', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', '如果实现单行文本的溢出显示省略号同学们应该都知道用text-overflow:ellipsis属性来，');
INSERT INTO `tb_web_source` VALUES ('3', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'link', 'desc1111');
INSERT INTO `tb_web_source` VALUES ('6', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('7', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('8', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('9', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('10', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('11', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('12', 'redis', 'https://github.com/MicrosoftArchive/redis', null, '111', 'openSource', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('13', 'D.W', 'http://www.csuldw.com', null, '111', 'link', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('14', '拾毅者', 'http://www.csuldw.com', null, '111', 'link', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
INSERT INTO `tb_web_source` VALUES ('15', '博客', 'http://www.csuldw.com', null, '111', 'link', 'Redis is an in-memory database that persists on disk. The data model is key-value, but many different kind of values are supported: Strings, Lists, Sets, Sorted Sets, Hashes http://redis.io');
