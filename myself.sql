/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80016
Source Host           : 127.0.0.1:3306
Source Database       : myself

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-08-21 18:19:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for st_stocks_gp
-- ----------------------------
DROP TABLE IF EXISTS `st_stocks_gp`;
CREATE TABLE `st_stocks_gp` (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gp_name` varchar(255) NOT NULL COMMENT '股票名称',
  `gp_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '股票代码',
  `gp_bourse` varchar(255) NOT NULL COMMENT '股票所属交易所',
  `gp_address` varchar(255) DEFAULT '' COMMENT '公司地址',
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  `add_user_name` varchar(255) DEFAULT '' COMMENT '添加人员',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user_name` varchar(255) DEFAULT '' COMMENT '更新人员',
  `gp_manager` varchar(255) DEFAULT '' COMMENT '经理',
  `gp_president` varchar(255) DEFAULT '' COMMENT '董事长',
  PRIMARY KEY (`id`),
  KEY `index_gp_all_gp_name` (`gp_name`),
  KEY `index_gp_all_gp_code` (`gp_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全部股票信息表';

-- ----------------------------
-- Table structure for st_trading_statement
-- ----------------------------
DROP TABLE IF EXISTS `st_trading_statement`;
CREATE TABLE `st_trading_statement` (
  `id` varchar(50) NOT NULL,
  `gp_code` varchar(10) NOT NULL COMMENT '股票编号',
  `operate_price` decimal(10,2) NOT NULL COMMENT '操作价格',
  `operate_total_money` decimal(10,2) NOT NULL COMMENT '操作金额',
  `operate_shares` decimal(10,0) NOT NULL COMMENT '操作股数',
  `operate_hand` decimal(10,0) NOT NULL COMMENT '操作手数（操作股数/100）',
  `operate_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `owner_user_id` varchar(50) NOT NULL COMMENT '股票拥有者ID',
  `operate_type` varchar(2) NOT NULL COMMENT '操作类型（0：买；1：卖）',
  `operate_ip` varchar(10) DEFAULT NULL COMMENT '操作IP',
  PRIMARY KEY (`id`),
  KEY `index_Trading_gp_code` (`gp_code`),
  KEY `index_Trading_operate_time` (`operate_time`),
  KEY `index_Trading_operate_ip` (`operate_ip`),
  KEY `index_Trading_owner_user_id` (`owner_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Trading statement 交易流水表';

-- ----------------------------
-- Table structure for st_user
-- ----------------------------
DROP TABLE IF EXISTS `st_user`;
CREATE TABLE `st_user` (
  `id` varchar(50) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_sex` varchar(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(50) NOT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_user_name` (`user_name`),
  KEY `index_user_phone` (`user_phone`),
  KEY `index_user_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
