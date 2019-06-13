/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : legend

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-01-09 03:25:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for legendtext
-- ----------------------------
DROP TABLE IF EXISTS `legendtext`;
CREATE TABLE `legendtext` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `neck` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `camp` varchar(255) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL,
  `passive` varchar(255) DEFAULT NULL,
  `skillq` varchar(255) DEFAULT NULL,
  `skillw` varchar(255) DEFAULT NULL,
  `skille` varchar(255) DEFAULT NULL,
  `skillr` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of legendtext
-- ----------------------------
INSERT INTO `legendtext` VALUES ('00000000001', '卡特琳娜', '不详之刃', '刺客', '诺克萨斯', '美女', '贪婪', '弹射之刃', '伺机待发', '瞬步', '死亡莲花', null, null);
INSERT INTO `legendtext` VALUES ('00000000002', '李青', '盲僧', '刺客', '艾欧尼亚', '盲仔', '疾风骤雨', '天音波/回音击', '金钟罩/铁布衫', '天雷劈/摧筋断骨', '猛龙摆尾', null, null);
