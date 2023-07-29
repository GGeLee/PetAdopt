/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : petadoption

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-06-30 12:57:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminId` varchar(255) NOT NULL,
  `adminAccount` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  `adminName` varchar(255) DEFAULT NULL,
  `adminAge` varchar(255) DEFAULT NULL,
  `adminSex` varchar(255) DEFAULT NULL,
  `adminTelephone` varchar(255) DEFAULT NULL,
  `adminEmail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('137e8fe6-cb1f-4730-8caa-014a06b629ce', 'admin', 'admin', 'admin', '1', '1', '11', '1');

-- ----------------------------
-- Table structure for t_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `applyId` varchar(255) NOT NULL,
  `applyUserName` varchar(255) DEFAULT NULL,
  `applyPetName` varchar(255) DEFAULT NULL,
  `applyUserSex` varchar(255) DEFAULT NULL,
  `applyUserAddress` varchar(255) DEFAULT NULL,
  `applyUserTelephone` varchar(255) DEFAULT NULL,
  `applyUserState` varchar(255) DEFAULT NULL,
  `applyTime` varchar(255) DEFAULT NULL,
  `applyState` varchar(255) DEFAULT NULL,
  `applyUserId` varchar(255) DEFAULT NULL,
  `applyPetId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_apply
-- ----------------------------
INSERT INTO `t_apply` VALUES ('86b2a084-4a26-450c-aa0c-ee4ba8e9d873', '6666', '小狗1111', '男', '6666', '6666', '无领养经历', '2023-06-27 23:20:25', '同意领养', '17243181-0a80-4717-b205-95d186785314', '9b26d1a4-9946-477c-8e5c-aea5d937c4a9');
INSERT INTO `t_apply` VALUES ('a2df6aff-49cd-4800-b6f6-24c9a1031617', '6666', 'q', '男', '6666', '6666666', '无领养经历', '2023-06-28 01:36:46', '审核中', '17243181-0a80-4717-b205-95d186785314', '74473eca-f7ce-4e58-9838-131f95ac43be');
INSERT INTO `t_apply` VALUES ('ad4d6568-1185-448e-b89c-870de099890a', '6666', 'pig', '男', '6666', '6666666', '无领养经历', '2023-06-28 09:56:07', '审核中', '17243181-0a80-4717-b205-95d186785314', '84992470-af70-4d1e-b806-b3a6ad049dde');
INSERT INTO `t_apply` VALUES ('dd2a90ba-bcc6-4ac7-add6-f20e56559f25', '6666', 'ggb', '男', '6666', '6666666', '无领养经历', '2023-06-27 23:21:49', '不同意领养', '17243181-0a80-4717-b205-95d186785314', '18467ad9-5a77-4f43-ac96-e0bd93821ba4');
INSERT INTO `t_apply` VALUES ('f588971a-b161-4ad1-af4f-6b5cbcca3795', '6666', '小狗', '男', '6666', '6666', '无领养经历', '2023-06-27 23:20:27', '不同意领养', '17243181-0a80-4717-b205-95d186785314', '53beac26-7b39-4c6c-a48f-77b6d2d4edbd');

-- ----------------------------
-- Table structure for t_pet
-- ----------------------------
DROP TABLE IF EXISTS `t_pet`;
CREATE TABLE `t_pet` (
  `petId` varchar(255) NOT NULL,
  `petName` varchar(255) DEFAULT NULL,
  `petSex` varchar(255) DEFAULT NULL,
  `petSub` varchar(255) DEFAULT NULL,
  `petType` varchar(255) DEFAULT NULL,
  `petBir` varchar(255) DEFAULT NULL,
  `petDetail` varchar(255) DEFAULT NULL,
  `petPic` varchar(255) DEFAULT NULL,
  `petState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`petId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_pet
-- ----------------------------
INSERT INTO `t_pet` VALUES ('09062a33-85c6-441a-8b78-5da41f86d570', '小狗', '公', '1111', '1111', '2023-06-27', '111111                                                                 ', '1d7ce78c-ea94-4447-a900-351a8f4b7a4b.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('157e21e2-3e63-4902-9636-e0554d3828e8', '222', '公', '2222', '222', '2023-06-27', '                                            111                                        ', 'd380e51f-2512-4c64-882c-cdb568ffc209.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('18467ad9-5a77-4f43-ac96-e0bd93821ba4', 'ggb', '公', '1', '小白猪', '2023-01-01', '1', '793670a1-c4a1-4374-8e90-c51487408855.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('261fd09c-6b60-4598-83a5-dfe4b0b1a003', '小狗', '公', '狗', '狗', '2023-06-27', '狗', 'a5ac7be8-a100-433f-8d5b-7a25efd293cc.png', '未领养');
INSERT INTO `t_pet` VALUES ('53beac26-7b39-4c6c-a48f-77b6d2d4edbd', '小狗', '公', '11', '11', '2023-06-27', '1111', 'd4eb43fb-73c2-45b4-aed8-d0a71a27322f.png', '未领养');
INSERT INTO `t_pet` VALUES ('5d329600-3148-4268-93c5-f6191c0ffee2', 'li', '公', 'li', 'li', '2023-06-15', '                                            lli                                        ', '292aecd9-0731-44a0-9dd1-57f42d161bab.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('73658e58-5c93-4867-9655-a65d73ecb13e', '小狗', '公', '狗', '小', '2023-06-27', '嘿嘿嘿', '2d435442-b29d-4dce-9664-bafeca93094e.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('74473eca-f7ce-4e58-9838-131f95ac43be', 'q', '公', 'q', 'qq', '2023-06-22', 'qq', '15da2573-2007-4861-8d72-e797c21f21b2.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('84992470-af70-4d1e-b806-b3a6ad049dde', 'pig', '公', '香猪', '猪', '2023-06-27', '猪', 'd65ca6f9-2f32-4ffd-a521-8654d6c8c87f.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('9b26d1a4-9946-477c-8e5c-aea5d937c4a9', '小狗1111', '公', '111', '11', '2023-06-27', '111', '506ce3f7-c2e2-4668-bf27-919ef0c9acea.jpg', '已被领养');
INSERT INTO `t_pet` VALUES ('a772108d-b4f5-4b0c-9586-f19604f03a51', '5555', '公', '555', '555', '2023-01-01', '444', '07ee4d42-853b-43f0-8aae-cb24d425a490.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('b919355c-3b36-458d-bdce-cc0b85e240b6', '1111', '公', '111', '1111', '2023-01-01', '111                                                                      111                                                                                ', 'f649e82c-a296-4b5e-9de4-905a3cd1fe3c.jpg', '未领养');
INSERT INTO `t_pet` VALUES ('f89af268-0bed-404a-8ae0-5e3394f4e087', '333', '公', '333', '333', '2023-06-27', '3333', 'b0ace5f8-668c-4185-8ffe-a8377b1bdc17.jpg', '未领养');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` varchar(255) NOT NULL,
  `userAccount` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userAge` varchar(255) DEFAULT NULL,
  `userSex` varchar(255) DEFAULT NULL,
  `userTelephone` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userAddress` varchar(255) DEFAULT NULL,
  `userState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('17243181-0a80-4717-b205-95d186785314', 'admin1', 'admin1', 'admin1', '666', '男', '6666666', '6666666', '6666', '无领养经历');
