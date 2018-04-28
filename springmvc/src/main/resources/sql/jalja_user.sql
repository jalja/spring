/*
Navicat MySQL Data Transfer

Source Server         : 56
Source Server Version : 50636
Source Host           : 192.168.0.56:3306
Source Database       : jalja_deal

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-02-07 23:07:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jalja_user
-- ----------------------------
DROP TABLE IF EXISTS `jalja_user`;
CREATE TABLE `jalja_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL COMMENT '登录名',
  `pass_word` varchar(32) NOT NULL COMMENT '密码',
  `user_email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `user_sex` int(1) DEFAULT '0' COMMENT '0:保密 1：男2：女',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `user_phone` varchar(11) NOT NULL COMMENT '手机号码',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jalja_user
-- ----------------------------
INSERT INTO `jalja_user` VALUES ('1', 'jalja', '111111', '11111@qq.com', '0', '111111', '11111111111', '2017-12-06 22:07:34');
INSERT INTO `jalja_user` VALUES ('2', '张三', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('3', '张AA', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('4', '张三A', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('5', '张三DD', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('6', '张三FF', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('7', '张三GG', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
INSERT INTO `jalja_user` VALUES ('8', '张三DFG', '111111', '11111@qq.com', '0', '222222', '22222222222', '2018-02-07 22:15:36');
