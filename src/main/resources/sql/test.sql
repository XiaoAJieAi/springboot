/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 18/12/2020 18:02:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sname` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ssex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `database` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', 'KangKang', 'M', 'db2');
INSERT INTO `student` VALUES ('002', 'Mike', 'M', 'db2');
INSERT INTO `student` VALUES ('003', 'Jane', 'F', 'db2');
INSERT INTO `student` VALUES ('004', 'Maria', 'F', 'db2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com');

SET FOREIGN_KEY_CHECKS = 1;
