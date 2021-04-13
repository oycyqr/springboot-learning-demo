/*
 Navicat Premium Data Transfer

 Source Server         : 146.56.192.87-oyc
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 146.56.192.87:3306
 Source Schema         : oyc

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 13/04/2021 12:36:05

*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id\r\n',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL COMMENT '主键ID',
  `account` varchar(64) DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL COMMENT '盐',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `admin` tinyint(3) DEFAULT '0' COMMENT '是否admin，0不是，1是',
  `status` varchar(64) DEFAULT NULL COMMENT '用户状态',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `name` varchar(64) DEFAULT NULL COMMENT '登录账号',
  `nick_name` varchar(255) DEFAULT NULL,
  `constellation` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT NULL,
  `version` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'ouyangcheng', '1', '1', NULL, '1', '2021-01-20 15:46:12', '1', NULL, 0, NULL, '2021-01-20 15:46:24', NULL, NULL, '城城', NULL, 24, NULL, 0, NULL);
INSERT INTO `user` VALUES ('10', 'lisi', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '李四', '李四', '思思', 18, 'female', 0, NULL);
INSERT INTO `user` VALUES ('111', 'ouyangcheng1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '李四1', '城城1', '思思1', 24, 'female', 0, 4);
INSERT INTO `user` VALUES ('2', 'aaa', 'a', 'a', 'a', 'a', '2021-02-20 16:48:50', 'a', 'a', 0, NULL, NULL, NULL, 'ss', NULL, NULL, 18, 'male', 0, NULL);
INSERT INTO `user` VALUES ('3', 'zhangqian', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '张骞', '骞', 'aa', 18, 'male', 0, NULL);
INSERT INTO `user` VALUES ('6', 'zhangqian1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '张骞', '骞', 'aa', 18, 'male', 0, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
