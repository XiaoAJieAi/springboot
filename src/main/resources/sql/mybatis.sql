/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 127.0.0.1:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 18/12/2020 18:02:57
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
INSERT INTO `student` VALUES ('001', '康康', 'M', 'db1');
INSERT INTO `student` VALUES ('002', '麦克', 'M', 'db1');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `OPERATION` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户操作',
  `TIME` int(11) NULL DEFAULT NULL COMMENT '响应时间',
  `METHOD` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `PARAMS` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `IP` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 'mrbird', '执行方法一', 11, 'com.n22.springboot.controller.TestController.methodOne()', 'name: KangKang', '169.254.63.214', '2020-12-16 13:47:43');
INSERT INTO `sys_log` VALUES (2, 'mrbird', '执行方法一', 0, 'com.n22.springboot.controller.TestController.methodOne()', 'name: KangKang', '169.254.63.214', '2020-12-16 13:51:52');
INSERT INTO `sys_log` VALUES (3, 'mrbird', '执行方法一', 19, 'com.n22.springboot.controller.TestController.methodOne()', 'name: KangKang', '169.254.63.214', '2020-12-16 13:54:34');
INSERT INTO `sys_log` VALUES (4, 'mrbird', '执行方法二', 2000, 'com.n22.springboot.controller.TestController.methodTwo()', '', '169.254.63.214', '2020-12-16 13:55:09');
INSERT INTO `sys_log` VALUES (5, 'mrbird', '执行方法三', 0, 'com.n22.springboot.controller.TestController.methodThree()', 'name: XiaoAJie age: 18', '169.254.63.214', '2020-12-16 13:55:53');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '哈哈', '123456');
INSERT INTO `user` VALUES (2, '张三', '123456');
INSERT INTO `user` VALUES (3, '李四', '456789');

SET FOREIGN_KEY_CHECKS = 1;
