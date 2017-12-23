/*
 Navicat Premium Data Transfer

 Source Server         : calendar
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : calendar

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 12/23/2017 12:10:56 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `academy`
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `academy_id` varchar(255) NOT NULL DEFAULT '',
  `academy_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`academy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `academy`
-- ----------------------------
BEGIN;
INSERT INTO `academy` VALUES ('rwxy', '人文学院'), ('wyxy', '外语学院'), ('xdxy', '信电学院'), ('xxxy', '信息学院');
COMMIT;

-- ----------------------------
--  Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_username` varchar(255) NOT NULL DEFAULT '',
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_phonenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `admin`
-- ----------------------------
BEGIN;
INSERT INTO `admin` VALUES ('admin', 'admin', '18257846942');
COMMIT;

-- ----------------------------
--  Table structure for `affairs`
-- ----------------------------
DROP TABLE IF EXISTS `affairs`;
CREATE TABLE `affairs` (
  `affairs_id` int(11) NOT NULL AUTO_INCREMENT,
  `affairs_name` varchar(255) DEFAULT '',
  `affairs_timestart` int(255) DEFAULT NULL,
  `affairs_timeend` int(255) DEFAULT NULL,
  `affairs_createrid` varchar(255) DEFAULT NULL,
  `affairs_address` varchar(255) DEFAULT NULL,
  `affairs_introduction` varchar(255) DEFAULT NULL,
  `affairs_week` int(255) DEFAULT NULL,
  `affairs_weekstart` int(255) DEFAULT NULL,
  `affairs_weekend` int(255) DEFAULT NULL,
  PRIMARY KEY (`affairs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `affairs`
-- ----------------------------
BEGIN;
INSERT INTO `affairs` VALUES ('1', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '3', '3'), ('2', '聚餐', '8', '9', '948301', '流水', '班级聚餐', '5', '5', '5'), ('4', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('5', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('6', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('7', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('8', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('9', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('10', 'inr', '6', '7', 'admin', 'loc', 'inr', '3', '3', '3'), ('11', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4'), ('12', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('13', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('14', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('15', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('16', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('17', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('18', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('19', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3'), ('20', '11', '1', '1', 'admin', 'ca', '11', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `cclasses`
-- ----------------------------
DROP TABLE IF EXISTS `cclasses`;
CREATE TABLE `cclasses` (
  `course_id` varchar(255) NOT NULL DEFAULT '',
  `classes_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`course_id`,`classes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cclasses`
-- ----------------------------
BEGIN;
INSERT INTO `cclasses` VALUES ('000001', 'rj1501'), ('000002', 'rj1501');
COMMIT;

-- ----------------------------
--  Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classes_id` varchar(255) NOT NULL DEFAULT '',
  `classes_name` varchar(255) NOT NULL DEFAULT '',
  `major_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classes_id`),
  KEY `major_id` (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `classes`
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES ('aq1501', '安全1501', 'aq'), ('cm1401', '传媒1401', 'cm'), ('fy1501', '法语1501', 'fy'), ('jk1501', '计科1501', 'jk'), ('jk1502', '计科1502', 'jk'), ('rj1501', '软件1501', 'rj'), ('rj1502', '软件1502', 'rj'), ('tx1501', '通信工程1501', 'tx'), ('wl1601', '网络工程1601', 'wl'), ('xw1701', '新闻1701', 'xw'), ('yy1501', '英语1501', 'yy'), ('yy1503', '英语1503', 'yy');
COMMIT;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(255) NOT NULL DEFAULT '',
  `course_name` varchar(255) DEFAULT NULL,
  `course_timestart` int(255) DEFAULT NULL,
  `course_timeend` int(255) DEFAULT NULL,
  `course_academy` varchar(255) DEFAULT NULL,
  `course_address` varchar(255) DEFAULT NULL,
  `course_week` int(255) DEFAULT NULL,
  `course_weekstart` int(255) DEFAULT NULL,
  `course_weekend` int(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('000001', '软件工程实践', '1', '3', 'xxxy', '信息楼', '4', '1', '15'), ('000002', '数据库管理', '3', '4', 'xxxy', 'A楼', '1', '1', '15');
COMMIT;

-- ----------------------------
--  Table structure for `coursedata`
-- ----------------------------
DROP TABLE IF EXISTS `coursedata`;
CREATE TABLE `coursedata` (
  `course_id` varchar(255) NOT NULL DEFAULT '',
  `course_weektime` varchar(255) DEFAULT NULL,
  `course_week` varchar(255) DEFAULT NULL,
  `course_homework` varchar(255) DEFAULT NULL,
  `course_outline` varchar(255) DEFAULT NULL,
  `course_data` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `coursedata`
-- ----------------------------
BEGIN;
INSERT INTO `coursedata` VALUES ('84527', '第三周', '周三', null, null, null), ('84751', '第五周', '周四', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` varchar(255) NOT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  `academy_id` varchar(255) DEFAULT '',
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `major`
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES ('aq', '安全', 'xxxy'), ('cm', '传媒', 'rwxy'), ('fy', '法语', 'wyxy'), ('jk', '计科', 'xxxy'), ('rj', '软件', 'xxxy'), ('tx', '通信工程', 'xdxy'), ('wl', '网络工程', 'xdxy'), ('xw', '新闻', 'rwxy'), ('yy', '英语', 'wyxy');
COMMIT;

-- ----------------------------
--  Table structure for `scalendar`
-- ----------------------------
DROP TABLE IF EXISTS `scalendar`;
CREATE TABLE `scalendar` (
  `scalendar_termstart` varchar(255) NOT NULL DEFAULT '',
  `scalendar_termend` varchar(255) NOT NULL DEFAULT '',
  `scalendar_holiday` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`scalendar_termstart`,`scalendar_termend`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `scalendar`
-- ----------------------------
BEGIN;
INSERT INTO `scalendar` VALUES ('2017.9.15', '2018.1.29', '9.20,9.21');
COMMIT;

-- ----------------------------
--  Table structure for `scourse`
-- ----------------------------
DROP TABLE IF EXISTS `scourse`;
CREATE TABLE `scourse` (
  `stu_userid` varchar(255) NOT NULL DEFAULT '',
  `course_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`stu_userid`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `scourse`
-- ----------------------------
BEGIN;
INSERT INTO `scourse` VALUES ('1512190201', '000001'), ('1512190201', '000002'), ('1512190212', '000002');
COMMIT;

-- ----------------------------
--  Table structure for `staffairs`
-- ----------------------------
DROP TABLE IF EXISTS `staffairs`;
CREATE TABLE `staffairs` (
  `stu_userid` varchar(255) NOT NULL DEFAULT '',
  `affairs_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_userid`,`affairs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `staffairs`
-- ----------------------------
BEGIN;
INSERT INTO `staffairs` VALUES ('11011', '18'), ('11111', '17'), ('11112', '18'), ('1512190201', '1'), ('1512190201', '4'), ('1512190201', '10'), ('1512190201', '20'), ('1512190202', '10'), ('1512190212', '2'), ('1512190212', '18'), ('1512190212', '20');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stu_userid` varchar(255) NOT NULL DEFAULT '',
  `stu_password` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_permission` int(2) DEFAULT NULL,
  `stu_class` varchar(255) DEFAULT NULL,
  `stu_academy` varchar(255) DEFAULT NULL,
  `stu_phonenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stu_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('11011', '123456', 'cookien', '1', 'jk1502', 'xxxy', '10010'), ('11111', '123456', 'cook', '1', 'jk1501', 'xxxy', '10010'), ('11112', '123456', 'cook', '1', 'jk1502', 'xxxy', '10010'), ('1512190201', '235494', '李四', '1', 'rj1501', 'xxxy', '18758425461'), ('1512190212', '230316', '张三', '0', 'rj1501', 'xxxy', '18758424692');
COMMIT;

-- ----------------------------
--  Table structure for `tcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tcourse`;
CREATE TABLE `tcourse` (
  `teacher_userid` varchar(255) NOT NULL DEFAULT '',
  `course_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`teacher_userid`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tcourse`
-- ----------------------------
BEGIN;
INSERT INTO `tcourse` VALUES ('948275', '84527'), ('948301', '84751');
COMMIT;

-- ----------------------------
--  Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_userid` varchar(255) NOT NULL DEFAULT '',
  `teacher_password` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_title` varchar(255) DEFAULT NULL,
  `teacher_permission` int(11) DEFAULT NULL,
  `teacher_major` varchar(255) DEFAULT NULL,
  `teacher_academy` varchar(255) DEFAULT NULL,
  `teacher_phonenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `teacher`
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('848270', '251453', '谢10', null, '1', null, 'xxxy', '18758422469'), ('911113', '123456', 'cook', null, '1', null, 'wgyxy', '10010'), ('948170', '251453', '谢2', null, '1', null, '信息学院', '18758422469'), ('948275', '251453', '谢波', '教授', '1', '软件1501', '信息学院', '18758422469'), ('948301', '245815', '潘伟峰', '教授', '0', '软件1502', '信息学院', '18754826846');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
