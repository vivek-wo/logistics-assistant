/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : logistics_assistant

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 18/03/2021 15:38:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city`  (
  `id` bigint NOT NULL COMMENT '地区Id',
  `adcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址编码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '地址',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '市',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '区',
  `formatted` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '格式化地址',
  `lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '纬度',
  `lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '经度',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '省',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '公司Id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '公司名称',
  `lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '经度',
  `lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '纬度',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '地区',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '详细地址',
  `licensePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '营业执照图片路径',
  `doorImagePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公司门头照路径',
  `roadLicensePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '道路运输许可证图片路径',
  `legalUserId` bigint NOT NULL COMMENT '公司法人Id',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_dedicated_line
-- ----------------------------
DROP TABLE IF EXISTS `t_dedicated_line`;
CREATE TABLE `t_dedicated_line`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '专线Id',
  `startSiteId` bigint NOT NULL COMMENT '开始网点Id',
  `endSiteId` bigint NOT NULL COMMENT '结束网点Id',
  `middleSiteIds` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '中间网点Id集合',
  `companyId` bigint NOT NULL COMMENT '公司Id',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_departure
-- ----------------------------
DROP TABLE IF EXISTS `t_departure`;
CREATE TABLE `t_departure`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '发车Id',
  `dedicatedLineId` bigint NOT NULL COMMENT '专线Id',
  `startDepartureTime` timestamp NOT NULL COMMENT '发车时间',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_site
-- ----------------------------
DROP TABLE IF EXISTS `t_site`;
CREATE TABLE `t_site`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '网点Id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '网点名称',
  `lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '网点经度',
  `lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '网点纬度',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '网点地区',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '网点地址',
  `contactUser` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '网点联系人',
  `contactPhone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '网点联系电话',
  `startTime` timestamp NULL DEFAULT NULL COMMENT '网点开始营业时间',
  `endTime` timestamp NULL DEFAULT NULL COMMENT '网点结束营业时间',
  `companyId` bigint NOT NULL COMMENT '公司Id',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户姓名',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户手机号码',
  `photoPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户头像路径',
  `idcardFrontPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户身份证正面路径',
  `idcardBackPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户身份证反面路径',
  `type` int NULL DEFAULT NULL COMMENT '用户类型',
  `createTime` timestamp NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_wxauth_user
-- ----------------------------
DROP TABLE IF EXISTS `t_wxauth_user`;
CREATE TABLE `t_wxauth_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `userId` bigint NOT NULL COMMENT '用户Id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '微信code',
  `openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '微信openId',
  `nick` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '微信昵称',
  `photoPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
