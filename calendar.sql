/*
Navicat MySQL Data Transfer

Source Server         : dell
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : calendar

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-01-09 15:21:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `academy`
-- ----------------------------
DROP TABLE IF EXISTS `academy`;
CREATE TABLE `academy` (
  `academy_id` varchar(255) NOT NULL DEFAULT '',
  `academy_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`academy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of academy
-- ----------------------------
INSERT INTO `academy` VALUES ('dyxy', '东语学院');
INSERT INTO `academy` VALUES ('glxy', '管理学院');
INSERT INTO `academy` VALUES ('hjxy', '环境学院');
INSERT INTO `academy` VALUES ('rwxy', '人文学院');
INSERT INTO `academy` VALUES ('spxy', '食品学院');
INSERT INTO `academy` VALUES ('ttxy', '统计学院');
INSERT INTO `academy` VALUES ('wyxy', '外语学院');
INSERT INTO `academy` VALUES ('xdxy', '信电学院');
INSERT INTO `academy` VALUES ('xxxy', '信息学院');
INSERT INTO `academy` VALUES ('ysxy', '艺术学院');

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_username` varchar(255) NOT NULL DEFAULT '',
  `admin_password` varchar(255) DEFAULT NULL,
  `admin_phonenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin', '18257846942');

-- ----------------------------
-- Table structure for `affairs`
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
-- Records of affairs
-- ----------------------------
INSERT INTO `affairs` VALUES ('1', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '3', '3');
INSERT INTO `affairs` VALUES ('2', '聚餐', '8', '9', '948301', '流水', '班级聚餐', '5', '5', '5');
INSERT INTO `affairs` VALUES ('4', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('5', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('6', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('7', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('8', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('9', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('10', 'inr', '6', '7', 'admin', 'loc', 'inr', '3', '3', '3');
INSERT INTO `affairs` VALUES ('11', '开会', '6', '7', '948275', 'A楼', '班级会议', '3', '4', '4');
INSERT INTO `affairs` VALUES ('12', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('13', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('14', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('15', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('16', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('17', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('18', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('19', '吃鸡', '6', '7', 'admin', '40#205', '吃鸡', '3', '3', '3');
INSERT INTO `affairs` VALUES ('20', '11', '1', '1', 'admin', 'ca', '11', '1', '1', '1');

-- ----------------------------
-- Table structure for `cclasses`
-- ----------------------------
DROP TABLE IF EXISTS `cclasses`;
CREATE TABLE `cclasses` (
  `course_id` varchar(255) NOT NULL DEFAULT '',
  `classes_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`course_id`,`classes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cclasses
-- ----------------------------
INSERT INTO `cclasses` VALUES ('000001', 'rj1501');
INSERT INTO `cclasses` VALUES ('000002', 'rj1501');
INSERT INTO `cclasses` VALUES ('000003', 'rj1502');
INSERT INTO `cclasses` VALUES ('000004', 'jk1501');
INSERT INTO `cclasses` VALUES ('000005', 'jk1501');
INSERT INTO `cclasses` VALUES ('000006', 'jk1502');
INSERT INTO `cclasses` VALUES ('000007', 'jk1502');
INSERT INTO `cclasses` VALUES ('000008', 'aq1501');
INSERT INTO `cclasses` VALUES ('000009', 'aq1501');
INSERT INTO `cclasses` VALUES ('000010', 'rj1502');

-- ----------------------------
-- Table structure for `classes`
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
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('aq1501', '安全1501', 'aq');
INSERT INTO `classes` VALUES ('cm1401', '传媒1401', 'cm');
INSERT INTO `classes` VALUES ('fy1501', '法语1501', 'fy');
INSERT INTO `classes` VALUES ('jk1501', '计科1501', 'jk');
INSERT INTO `classes` VALUES ('jk1502', '计科1502', 'jk');
INSERT INTO `classes` VALUES ('rj1501', '软件1501', 'rj');
INSERT INTO `classes` VALUES ('rj1502', '软件1502', 'rj');
INSERT INTO `classes` VALUES ('tx1501', '通信工程1501', 'tx');
INSERT INTO `classes` VALUES ('wl1601', '网络工程1601', 'wl');
INSERT INTO `classes` VALUES ('xw1701', '新闻1701', 'xw');
INSERT INTO `classes` VALUES ('yy1501', '英语1501', 'yy');
INSERT INTO `classes` VALUES ('yy1503', '英语1503', 'yy');

-- ----------------------------
-- Table structure for `course`
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
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('000001', '软件工程实践', '1', '3', 'xxxy', '信息楼', '4', '1', '15');
INSERT INTO `course` VALUES ('000002', '数据库管理', '3', '4', 'xxxy', 'A楼', '1', '1', '15');
INSERT INTO `course` VALUES ('000003', '软件需求基础', '3', '5', 'xxxy', 'C楼', '3', '1', '15');
INSERT INTO `course` VALUES ('000004', '软件项目管理', '3', '5', 'xxxy', 'A楼', '1', '1', '15');
INSERT INTO `course` VALUES ('000005', '高等数学', '6', '8', 'tjxy', 'D楼', '1', '1', '15');
INSERT INTO `course` VALUES ('000006', '离散数学', '6', '8', 'tjxy', 'E楼', '4', '1', '15');
INSERT INTO `course` VALUES ('000007', '大学物理', '2', '5', 'xdxy', 'C楼', '1', '1', '15');
INSERT INTO `course` VALUES ('000008', 'C语言基础', '1', '3', 'xxxy', 'A楼', '2', '1', '15');
INSERT INTO `course` VALUES ('000009', 'java入门', '3', '5', 'xxxy', 'B楼', '3', '1', '15');
INSERT INTO `course` VALUES ('000010', '数据结构', '1', '2', 'xxxy', 'A楼', '3', '1', '15');

-- ----------------------------
-- Table structure for `coursedata`
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
-- Records of coursedata
-- ----------------------------
INSERT INTO `coursedata` VALUES ('000001', '第三周', '周三', null, null, null);
INSERT INTO `coursedata` VALUES ('000002', '第五周', '周四', null, null, null);
INSERT INTO `coursedata` VALUES ('000003', '第三周', '周四', null, null, null);
INSERT INTO `coursedata` VALUES ('000004', '第四周', '周五', null, null, null);
INSERT INTO `coursedata` VALUES ('000005', '第一周', '周一', null, null, null);
INSERT INTO `coursedata` VALUES ('000006', '第二周', '周二', null, null, null);
INSERT INTO `coursedata` VALUES ('000007', '第二周', '周三', null, null, null);
INSERT INTO `coursedata` VALUES ('000008', '第七周', '周三', null, null, null);
INSERT INTO `coursedata` VALUES ('000009', '第八周', '周四', null, null, null);
INSERT INTO `coursedata` VALUES ('000010', '第九周', '周二', null, null, null);

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `major_id` varchar(255) NOT NULL,
  `major_name` varchar(255) DEFAULT NULL,
  `academy_id` varchar(255) DEFAULT '',
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('aq', '安全', 'xxxy');
INSERT INTO `major` VALUES ('cm', '传媒', 'rwxy');
INSERT INTO `major` VALUES ('fy', '法语', 'wyxy');
INSERT INTO `major` VALUES ('jk', '计科', 'xxxy');
INSERT INTO `major` VALUES ('rj', '软件', 'xxxy');
INSERT INTO `major` VALUES ('tx', '通信工程', 'xdxy');
INSERT INTO `major` VALUES ('wl', '网络工程', 'xdxy');
INSERT INTO `major` VALUES ('xw', '新闻', 'rwxy');
INSERT INTO `major` VALUES ('yy', '英语', 'wyxy');

-- ----------------------------
-- Table structure for `scalendar`
-- ----------------------------
DROP TABLE IF EXISTS `scalendar`;
CREATE TABLE `scalendar` (
  `scalendar_termstart` varchar(255) NOT NULL DEFAULT '',
  `scalendar_termend` varchar(255) NOT NULL DEFAULT '',
  `scalendar_holiday` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`scalendar_termstart`,`scalendar_termend`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scalendar
-- ----------------------------
INSERT INTO `scalendar` VALUES ('2017.9.15', '2018.1.29', '9.20,9.21');

-- ----------------------------
-- Table structure for `scourse`
-- ----------------------------
DROP TABLE IF EXISTS `scourse`;
CREATE TABLE `scourse` (
  `stu_userid` varchar(255) NOT NULL DEFAULT '',
  `course_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`stu_userid`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scourse
-- ----------------------------
INSERT INTO `scourse` VALUES ('1512190201', '000001');
INSERT INTO `scourse` VALUES ('1512190201', '000002');
INSERT INTO `scourse` VALUES ('1512190201', '000007');
INSERT INTO `scourse` VALUES ('1512190202', '000008');
INSERT INTO `scourse` VALUES ('1512190203', '000009');
INSERT INTO `scourse` VALUES ('1512190204', '000010');
INSERT INTO `scourse` VALUES ('1512190212', '000002');
INSERT INTO `scourse` VALUES ('1512190213', '000003');
INSERT INTO `scourse` VALUES ('1512190216', '000004');
INSERT INTO `scourse` VALUES ('1512190226', '000006');

-- ----------------------------
-- Table structure for `staffairs`
-- ----------------------------
DROP TABLE IF EXISTS `staffairs`;
CREATE TABLE `staffairs` (
  `stu_userid` varchar(255) NOT NULL DEFAULT '',
  `affairs_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_userid`,`affairs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffairs
-- ----------------------------
INSERT INTO `staffairs` VALUES ('11011', '18');
INSERT INTO `staffairs` VALUES ('11111', '17');
INSERT INTO `staffairs` VALUES ('11112', '18');
INSERT INTO `staffairs` VALUES ('1512190201', '1');
INSERT INTO `staffairs` VALUES ('1512190201', '4');
INSERT INTO `staffairs` VALUES ('1512190201', '10');
INSERT INTO `staffairs` VALUES ('1512190201', '20');
INSERT INTO `staffairs` VALUES ('1512190202', '10');
INSERT INTO `staffairs` VALUES ('1512190212', '2');
INSERT INTO `staffairs` VALUES ('1512190212', '18');
INSERT INTO `staffairs` VALUES ('1512190212', '20');

-- ----------------------------
-- Table structure for `student`
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
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('11011', '123456', 'cookien', '1', 'jk1502', 'xxxy', '10010');
INSERT INTO `student` VALUES ('11111', '123456', 'cook', '1', 'jk1501', 'xxxy', '10010');
INSERT INTO `student` VALUES ('11112', '123456', 'cook', '1', 'jk1502', 'xxxy', '10010');
INSERT INTO `student` VALUES ('1512090230', '239974', '66', '0', 'rj1502', 'xxxy', '13894567583');
INSERT INTO `student` VALUES ('1512190201', '235494', '李四', '1', 'rj1501', 'xxxy', '18758425461');
INSERT INTO `student` VALUES ('1512190212', '230316', '张三', '0', 'rj1501', 'xxxy', '18758424692');
INSERT INTO `student` VALUES ('1512190302', '234564', '钱枫', '0', 'aq1501', 'xxxy', '15875848548');
INSERT INTO `student` VALUES ('1512190402', '235156', '王五', '0', 'rj1502', 'xxxy', '18758458648');
INSERT INTO `student` VALUES ('1512190412', '235845', '赵四', '1', 'jk1501', 'xxxy', '15784648456');
INSERT INTO `student` VALUES ('1512190423', '239746', '汪涵', '1', 'rj1501', 'xxxy', '15784584625');

-- ----------------------------
-- Table structure for `tcourse`
-- ----------------------------
DROP TABLE IF EXISTS `tcourse`;
CREATE TABLE `tcourse` (
  `teacher_userid` varchar(255) NOT NULL DEFAULT '',
  `course_id` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`teacher_userid`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcourse
-- ----------------------------
INSERT INTO `tcourse` VALUES ('848270', '000003');
INSERT INTO `tcourse` VALUES ('911113', '000004');
INSERT INTO `tcourse` VALUES ('948170', '000010');
INSERT INTO `tcourse` VALUES ('948275', '000001');
INSERT INTO `tcourse` VALUES ('948275', '000005');
INSERT INTO `tcourse` VALUES ('948275', '000009');
INSERT INTO `tcourse` VALUES ('948301', '000002');
INSERT INTO `tcourse` VALUES ('948301', '000006');
INSERT INTO `tcourse` VALUES ('948301', '000008');
INSERT INTO `tcourse` VALUES ('984545', '000007');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_userid` varchar(255) NOT NULL DEFAULT '',
  `teacher_password` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_permission` int(11) DEFAULT NULL,
  `teacher_academy` varchar(255) DEFAULT NULL,
  `teacher_phonenum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('845784', '585468', '杨文武', '1', '信息学院', '18758458458');
INSERT INTO `teacher` VALUES ('848270', '251453', '谢10', '1', 'xxxy', '18758422469');
INSERT INTO `teacher` VALUES ('854587', '248664', '王家乐', '0', '信息学院', '13894456786');
INSERT INTO `teacher` VALUES ('878854', '586948', '潘云', '1', '信息学院', '18758458431');
INSERT INTO `teacher` VALUES ('896484', '875845', '陈碧', '0', '信息学院', '17774863162');
INSERT INTO `teacher` VALUES ('911113', '123456', 'cook', '1', 'wgyxy', '10010');
INSERT INTO `teacher` VALUES ('948170', '251453', '谢2', '1', '信息学院', '18758422469');
INSERT INTO `teacher` VALUES ('948275', '251453', '谢波', '1', '信息学院', '18758422469');
INSERT INTO `teacher` VALUES ('948301', '245815', '潘伟峰', '0', '信息学院', '18754826846');
INSERT INTO `teacher` VALUES ('984545', '125786', '王慧燕', '0', '信息学院', '18758459698');
