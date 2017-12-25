/*
MySQL Data Transfer
Source Host: localhost
Source Database: mlzone
Target Host: localhost
Target Database: mlzone
Date: 2017-12-21 23:33:08
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
  `author` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `post_type` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `public_date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_article_category` VALUES ('1', '机器学习', '00000000000', 'ML 机器学习相关文章');
INSERT INTO `tb_article_category` VALUES ('2', '数据库', '00000000000', 'database');
INSERT INTO `tb_article_category` VALUES ('3', '大数据', '00000000000', '大数据');
INSERT INTO `tb_article_info` VALUES ('1', 'SVM算法详解', '12321', null, '1', '决策树', '决策树12', '0', '1', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('4', 'adaboost', '/data01/index.html', null, '1', null, null, '0', '1', '0', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('5', '数据库', '/data01/index.html', null, '123424', '烦烦烦', null, '0', '2', '0', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('6', 'stbc', '/data01/index.html', null, '1', null, null, '0', '1', '0', '2017-11-22 10:24:22');
INSERT INTO `tb_article_info` VALUES ('7', 'test', null, null, '1', null, null, '0', '2', '1', '2017-11-22 10:24:22');
INSERT INTO `tb_comment` VALUES ('1', 'love111', '1', '1', '0', '0', '2017-12-14 12:12:12');
INSERT INTO `tb_comment` VALUES ('2', '123', '13', '1', '0', '1', '2017-12-14 12:12:12');
INSERT INTO `tb_comment` VALUES ('3', 'teset', '15', '1', '0', '1', '2017-12-15 20:07:36');
INSERT INTO `tb_comment` VALUES ('4', 'fdsaf', '1', '1', '0', '1', '2017-12-15 20:11:15');
INSERT INTO `tb_comment` VALUES ('5', '小小', '19', '1', '0', '0', '2017-12-15 20:13:14');
INSERT INTO `tb_comment` VALUES ('6', '范德萨', '1', '1', '1', '0', '2017-12-15 20:13:24');
INSERT INTO `tb_comment` VALUES ('7', '1', '1', '1', '1', '0', '2017-12-15 20:37:09');
INSERT INTO `tb_comment` VALUES ('8', '1123', '1', '1', '1', '0', '2017-12-15 20:41:03');
INSERT INTO `tb_comment` VALUES ('9', '123', '15', '1', '1', '0', '2017-12-15 20:42:03');
INSERT INTO `tb_comment` VALUES ('10', '123', '15', '1', '1', '0', '2017-12-15 20:48:45');
INSERT INTO `tb_comment` VALUES ('11', 'abc', '15', '1', '0', '0', '2017-12-15 20:49:01');
INSERT INTO `tb_comment` VALUES ('12', 'admin', '15', '1', '0', '0', '2017-12-15 21:11:31');
INSERT INTO `tb_comment` VALUES ('13', 'ABC的', '15', '1', '0', '0', '2017-12-15 21:12:34');
INSERT INTO `tb_comment` VALUES ('14', '23213123', '15', '1', '0', '0', '2017-12-15 21:12:38');
INSERT INTO `tb_comment` VALUES ('15', '张12312312312', '1', '1', '0', '0', '2017-12-15 21:12:41');
INSERT INTO `tb_comment` VALUES ('16', '眼哈哈哈哈', '15', '1', '0', '0', '2017-12-15 21:12:46');
INSERT INTO `tb_comment` VALUES ('17', '12312', '15', '1', '0', '0', '2017-12-15 21:13:51');
INSERT INTO `tb_comment` VALUES ('18', '涵盖了很多细节部分，不错的', '19', '1', '0', '0', '2017-12-15 23:25:08');
INSERT INTO `tb_comment` VALUES ('19', '涵盖了很多细节部分，不错的\n回复', '15', '1', '0', '0', '2017-12-15 23:25:11');
INSERT INTO `tb_comment` VALUES ('20', '请吧你的心思拿过来\n温热无法', '15', '1', '0', '0', '2017-12-15 23:32:57');
INSERT INTO `tb_comment` VALUES ('38', '123123', '1', '19', '0', '0', '2017-12-16 21:37:12');
INSERT INTO `tb_comment` VALUES ('39', '12312', '1', '1', '0', '2', '2017-12-16 21:39:34');
INSERT INTO `tb_comment` VALUES ('40', '123123', '1', '1', '0', '0', '2017-12-16 21:41:06');
INSERT INTO `tb_comment` VALUES ('41', '123123123123', '1', '1', '0', '0', '2017-12-16 21:41:09');
INSERT INTO `tb_comment` VALUES ('42', '123123', '1', '1', '0', '0', '2017-12-16 21:41:31');
INSERT INTO `tb_comment` VALUES ('43', '123123', '1', '1', '0', '42', '2017-12-16 21:41:34');
INSERT INTO `tb_comment` VALUES ('44', '而王琦热热无', '1', '1', '0', '43', '2017-12-16 21:41:48');
INSERT INTO `tb_comment` VALUES ('45', '123123', '1', '1', '0', '44', '2017-12-16 21:44:06');
INSERT INTO `tb_comment` VALUES ('46', '123123', '1', '1', '0', '45', '2017-12-16 21:44:47');
INSERT INTO `tb_comment` VALUES ('47', '按错', '1', '1', '0', '46', '2017-12-16 21:45:36');
INSERT INTO `tb_comment` VALUES ('48', '123123', '1', '1', '0', '0', '2017-12-16 21:46:50');
INSERT INTO `tb_comment` VALUES ('49', '范德萨范德萨', '1', '1', '0', '48', '2017-12-16 21:46:55');
INSERT INTO `tb_comment` VALUES ('50', '123123213', '1', '1', '0', '48', '2017-12-16 21:52:12');
INSERT INTO `tb_comment` VALUES ('51', '12313213', '1', '1', '0', '48', '2017-12-16 21:53:45');
INSERT INTO `tb_comment` VALUES ('52', '1232131', '1', '1', '0', '48', '2017-12-16 21:54:11');
INSERT INTO `tb_comment` VALUES ('53', '123123', '1', '1', '0', '48', '2017-12-16 21:55:41');
INSERT INTO `tb_comment` VALUES ('54', '123123', '1', '1', '0', '48', '2017-12-16 21:55:50');
INSERT INTO `tb_comment` VALUES ('55', '阿布', '1', '1', '0', '48', '2017-12-16 21:55:57');
INSERT INTO `tb_comment` VALUES ('56', '123123', '1', '1', '0', '48', '2017-12-16 21:57:37');
INSERT INTO `tb_comment` VALUES ('57', '发范德萨啊', '1', '1', '0', '48', '2017-12-16 21:58:10');
INSERT INTO `tb_comment` VALUES ('58', '12312312', '1', '1', '0', '48', '2017-12-16 21:58:33');
INSERT INTO `tb_comment` VALUES ('59', '范德萨发', '1', '1', '0', '48', '2017-12-16 21:59:44');
INSERT INTO `tb_comment` VALUES ('60', '范德萨发', '1', '1', '0', '48', '2017-12-16 21:59:55');
INSERT INTO `tb_comment` VALUES ('61', '范德萨发', '1', '1', '0', '48', '2017-12-16 22:00:19');
INSERT INTO `tb_comment` VALUES ('62', '范德萨发', '1', '1', '0', '48', '2017-12-16 22:00:33');
INSERT INTO `tb_comment` VALUES ('63', '123123', '1', '1', '0', '48', '2017-12-16 22:02:29');
INSERT INTO `tb_comment` VALUES ('64', '123123123', '1', '1', '0', '48', '2017-12-16 22:03:42');
INSERT INTO `tb_comment` VALUES ('65', '123123', '1', '1', '0', '48', '2017-12-16 22:05:36');
INSERT INTO `tb_comment` VALUES ('66', '范德萨发', '1', '1', '0', '48', '2017-12-16 22:06:10');
INSERT INTO `tb_comment` VALUES ('67', '张丽是个大傻逼', '1', '1', '0', '42', '2017-12-16 22:06:19');
INSERT INTO `tb_comment` VALUES ('68', '张丽我爱你么么哒', '1', '1', '0', '42', '2017-12-16 22:06:26');
INSERT INTO `tb_comment` VALUES ('69', '小丽丽', '1', '1', '0', '42', '2017-12-16 22:06:35');
INSERT INTO `tb_comment` VALUES ('70', '搜迪斯', '1', '1', '0', '0', '2017-12-16 22:06:58');
INSERT INTO `tb_comment` VALUES ('71', '我该怎么办', '1', '1', '0', '0', '2017-12-16 22:07:06');
INSERT INTO `tb_comment` VALUES ('72', '谁能告诉我呢', '1', '1', '0', '0', '2017-12-16 22:07:12');
INSERT INTO `tb_comment` VALUES ('73', '请问你是谁  你个daBBle', '1', '1', '0', '0', '2017-12-16 22:07:21');
INSERT INTO `tb_comment` VALUES ('74', 'MEMEME', '1', '1', '0', '0', '2017-12-16 22:07:25');
INSERT INTO `tb_comment` VALUES ('75', 'WOZHENSHI', '1', '1', '0', '74', '2017-12-16 22:07:31');
INSERT INTO `tb_comment` VALUES ('76', 'FDS AF FDSA FDS AF DSA', '1', '1', '0', '74', '2017-12-16 22:07:37');
INSERT INTO `tb_comment` VALUES ('77', 'FDSA FDS AFDSA FDSA FDSAF SDA', '1', '1', '0', '74', '2017-12-16 22:07:41');
INSERT INTO `tb_comment` VALUES ('78', 'AFDSA', '1', '1', '0', '19', '2017-12-16 23:01:05');
INSERT INTO `tb_comment` VALUES ('79', 'FDSAFDSA', '1', '1', '0', '17', '2017-12-16 23:01:22');
INSERT INTO `tb_comment` VALUES ('80', '是的范德萨范德萨', '1', '1', '0', '17', '2017-12-16 23:02:00');
INSERT INTO `tb_comment` VALUES ('81', '撒范德萨放到', '1', '1', '0', '16', '2017-12-16 23:05:12');
INSERT INTO `tb_comment` VALUES ('82', '发的撒范德萨', '1', '1', '0', '5', '2017-12-16 23:06:58');
INSERT INTO `tb_comment` VALUES ('83', '范德萨发', '1', '1', '0', '74', '2017-12-16 23:22:29');
INSERT INTO `tb_comment` VALUES ('84', '范德萨范德萨', '1', '1', '0', '38', '2017-12-17 13:37:19');
INSERT INTO `tb_comment` VALUES ('85', '范德萨范德萨', '1', '1', '0', '20', '2017-12-17 13:37:25');
INSERT INTO `tb_comment` VALUES ('86', '大范德萨发', '1', '1', '0', '0', '2017-12-17 13:39:26');
INSERT INTO `tb_comment` VALUES ('87', '范德萨发', '1', '1', '0', '0', '2017-12-17 14:20:21');
INSERT INTO `tb_comment` VALUES ('88', '123123', '1', '1', '0', '0', '2017-12-21 22:41:20');
INSERT INTO `tb_comment` VALUES ('89', '123', '1', '1', '0', '0', '2017-12-21 23:12:42');
INSERT INTO `tb_comment` VALUES ('90', '123123123', '1', '1', '0', '0', '2017-12-21 23:12:45');
INSERT INTO `tb_recommendation` VALUES ('1', 'Python机器学习', null, 'www', 'csuldw', null, '1', null);
INSERT INTO `tb_user` VALUES ('1', 'admin', 'dw', '123456', '0', null, '', null, '', null, null, null, '1', null, null);
INSERT INTO `tb_user` VALUES ('6', 'root', 'zola', 'admin', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '1', '1', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('13', 'zhangsan', 'zola', 'adminadmin', '0', null, '1992-03-04', '13111111111', '湖南省', '123@csu.edu.cn', '1', null, '1', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('15', 'zhangsan4', 'zola', 'admin', '1', null, '1992-03-04', '13111111111', '湖北省', '123@csu.edu.cn', '1', null, '0', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('19', 'zhangsan41', 'zola', 'admin', '0', null, '1992-03-04', '13111111111', '北京', '123@csu.edu.cn', '1', null, '0', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('20', 'zhangsan41222', 'zola', 'admin', '1', null, '1992-03-04', '13111111111', '深圳', '123@csu.edu.cn', '1', null, '0', '1', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('23', 'zhangsan412221', 'zola', 'admin', '1', null, '1992-03-04', '13111111111', '广州', '123@csu.edu.cn', '1', null, '0', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('25', 'zhangsa', 'zola', 'admin', '1', null, '1992-03-04', '13111111111', '上海', '123@csu.edu.cn', '1', null, '0', '0', '2017-12-12 23:21:42');
INSERT INTO `tb_user` VALUES ('26', 'afdsaaaa', 'afdsaaaa', 'fdsafdsa', '0', null, '', null, '', null, null, null, '1', null, null);
INSERT INTO `tb_user` VALUES ('28', 'dfdsfds', '', 'fdsafdsa', '0', null, '', null, '', null, null, null, '1', null, null);
INSERT INTO `tb_user` VALUES ('30', '1111111', '', 'admin1234', '0', null, '', null, '', null, null, null, '1', null, '2017-12-13 23:23:00');
