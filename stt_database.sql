/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : stt_database

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-04-01 15:21:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for analyzes
-- ----------------------------
DROP TABLE IF EXISTS `analyzes`;
CREATE TABLE `analyzes` (
  `a_id` int(20) NOT NULL,
  `result` double(11,0) NOT NULL,
  `iname` varchar(20) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of analyzes
-- ----------------------------
INSERT INTO `analyzes` VALUES ('38698', '48', '数计学院');
INSERT INTO `analyzes` VALUES ('455383', '52', '音乐学院');
INSERT INTO `analyzes` VALUES ('745420', '48', '数计学院');
INSERT INTO `analyzes` VALUES ('745422', '42', '音乐学院');
INSERT INTO `analyzes` VALUES ('745430', '15', '音乐学院');
INSERT INTO `analyzes` VALUES ('745433', '28', '数计学院');
INSERT INTO `analyzes` VALUES ('745434', '55', '数计学院');
INSERT INTO `analyzes` VALUES ('745440', '34', '数计学院');
INSERT INTO `analyzes` VALUES ('745445', '41', '外国语学院');
INSERT INTO `analyzes` VALUES ('745446', '34', '外国语学院');
INSERT INTO `analyzes` VALUES ('745447', '38', '外国语学院');
INSERT INTO `analyzes` VALUES ('745456', '40', '建工学院');
INSERT INTO `analyzes` VALUES ('745463', '27', '建工学院');
INSERT INTO `analyzes` VALUES ('745467', '31', '管理学院');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `c_id` int(11) NOT NULL auto_increment,
  `cname` varchar(20) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`c_id`,`cname`),
  KEY `c_id` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构');
INSERT INTO `course` VALUES ('2', '软件设计模式与体系结构');
INSERT INTO `course` VALUES ('3', '计算机组成');
INSERT INTO `course` VALUES ('4', '计算机网络');
INSERT INTO `course` VALUES ('5', '软件项目管理');
INSERT INTO `course` VALUES ('6', 'XML实用教程');
INSERT INTO `course` VALUES ('7', '设计师的故事');
INSERT INTO `course` VALUES ('8', 'XML理论教程');
INSERT INTO `course` VALUES ('9', 'WebService深入学习');
INSERT INTO `course` VALUES ('10', '深入理解Java虚拟机');
INSERT INTO `course` VALUES ('11', 'EffectiveJava中文版');
INSERT INTO `course` VALUES ('12', '疯狂android讲义');
INSERT INTO `course` VALUES ('13', '室内家具设计');

-- ----------------------------
-- Table structure for courtyard
-- ----------------------------
DROP TABLE IF EXISTS `courtyard`;
CREATE TABLE `courtyard` (
  `i_id` int(11) NOT NULL auto_increment,
  `iname` varchar(20) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`i_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of courtyard
-- ----------------------------
INSERT INTO `courtyard` VALUES ('1', '数计学院');
INSERT INTO `courtyard` VALUES ('2', '音乐学院');
INSERT INTO `courtyard` VALUES ('3', '美术学院');
INSERT INTO `courtyard` VALUES ('4', '外国语学院');
INSERT INTO `courtyard` VALUES ('5', '建工学院');
INSERT INTO `courtyard` VALUES ('6', '管理学院');
INSERT INTO `courtyard` VALUES ('7', '体育学院');
INSERT INTO `courtyard` VALUES ('8', '化工学院');
INSERT INTO `courtyard` VALUES ('9', '经政院');
INSERT INTO `courtyard` VALUES ('10', '机汽学院');
INSERT INTO `courtyard` VALUES ('11', '物电学院');
INSERT INTO `courtyard` VALUES ('12', '教育学院');
INSERT INTO `courtyard` VALUES ('13', '医学院');

-- ----------------------------
-- Table structure for courtyard_grade
-- ----------------------------
DROP TABLE IF EXISTS `courtyard_grade`;
CREATE TABLE `courtyard_grade` (
  `grade` varchar(15) collate utf8_bin NOT NULL,
  `i_id` int(11) NOT NULL,
  PRIMARY KEY  (`grade`,`i_id`),
  KEY `i_id` (`i_id`),
  CONSTRAINT `grade` FOREIGN KEY (`grade`) REFERENCES `student` (`grade`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `i_id` FOREIGN KEY (`i_id`) REFERENCES `courtyard` (`i_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of courtyard_grade
-- ----------------------------
INSERT INTO `courtyard_grade` VALUES ('数学1311班', '1');
INSERT INTO `courtyard_grade` VALUES ('设计1311班', '1');
INSERT INTO `courtyard_grade` VALUES ('软件工程1311班', '1');
INSERT INTO `courtyard_grade` VALUES ('软件工程1311班', '2');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `e_id` int(11) NOT NULL auto_increment,
  `result` int(11) NOT NULL,
  `s_id` int(20) NOT NULL,
  `c_id` int(20) NOT NULL,
  `content` varchar(400) collate utf8_bin default NULL,
  `grade` varchar(50) collate utf8_bin NOT NULL,
  `cname` varchar(20) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '85', '2013193102', '1', null, '软件1311班', '数据结构');
INSERT INTO `evaluate` VALUES ('2', '29', '2013193102', '2', '老师讲得不错，要是再大声点儿就好了。', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('3', '30', '2013193102', '2', '很不错', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('4', '50', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('5', '60', '2013193102', '3', null, '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('6', '30', '2013193102', '2', '老师讲得不错，要是再大声点儿就好了。', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('7', '55', '2013193102', '2', '老师讲得不错，要是再大声点儿就好了。', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('8', '30', '2013193102', '2', '老师讲得不错，要是再大声点儿就好了。', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('9', '50', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('10', '50', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('11', '50', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('12', '50', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('13', '60', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('14', '70', '2013193102', '10', '可以可以', '软件1311班', '深入理解Java虚拟机');
INSERT INTO `evaluate` VALUES ('15', '70', '2013193102', '1', '可以可以', '软件1311班', '数据结构');
INSERT INTO `evaluate` VALUES ('16', '30', '2013193102', '1', '可以可以', '软件1311班', '数据结构');
INSERT INTO `evaluate` VALUES ('17', '45', '2013193102', '1', '可以可以', '软件1311班', '数据结构');
INSERT INTO `evaluate` VALUES ('18', '30', '2013193102', '1', '可以可以', '软件1311班', '数据结构');
INSERT INTO `evaluate` VALUES ('19', '30', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('20', '60', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('21', '20', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('22', '40', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('23', '30', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('24', '85', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('25', '95', '2013193102', '5', '可以可以', '软件1311班', '软件项目管理');
INSERT INTO `evaluate` VALUES ('26', '95', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('27', '30', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('28', '20', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('29', '10', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('30', '20', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('31', '30', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('32', '25', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('33', '60', '2013193102', '3', '可以可以', '软件1311班', '计算机网络');
INSERT INTO `evaluate` VALUES ('34', '60', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('35', '30', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('36', '15', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('37', '45', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('38', '15', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('39', '85', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('40', '60', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('41', '85', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('42', '10', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('43', '5', '2013193102', '9', '可以可以', '软件1311班', 'WebService深入学习');
INSERT INTO `evaluate` VALUES ('44', '30', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('45', '25', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('46', '30', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('47', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('48', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('49', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('50', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('51', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('52', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('53', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('54', '10', '2013193102', '6', '可以可以', '软件1311班', 'XML实用教程');
INSERT INTO `evaluate` VALUES ('55', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('56', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('57', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('58', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('59', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('60', '10', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('61', '25', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('62', '25', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('63', '25', '2013193102', '8', '可以可以', '软件1311班', 'XML理论教程');
INSERT INTO `evaluate` VALUES ('64', '25', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('65', '25', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('66', '25', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('67', '25', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('68', '25', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('69', '40', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('70', '40', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('71', '40', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('72', '40', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('73', '10', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('74', '10', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('75', '10', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('76', '10', '2013193102', '12', '可以可以', '软件1311班', '疯狂android讲义');
INSERT INTO `evaluate` VALUES ('77', '10', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('78', '10', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('79', '10', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('80', '10', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('81', '40', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('82', '40', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('83', '40', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('84', '40', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('85', '40', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('86', '60', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('87', '60', '2013193102', '7', '可以可以', '软件1311班', '设计师的故事');
INSERT INTO `evaluate` VALUES ('88', '60', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('89', '60', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('90', '60', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('91', '10', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('92', '10', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('93', '10', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('94', '10', '2013193102', '4', '可以可以', '软件1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('95', '10', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('96', '10', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('97', '10', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('98', '10', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('99', '40', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('100', '40', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('101', '40', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('102', '40', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('103', '40', '2013193102', '13', '可以可以', '软件1311班', '室内家具设计');
INSERT INTO `evaluate` VALUES ('104', '27', '2013193102', '2', '萨达', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('105', '25', '2013193102', '2', '', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('106', '72', '2013193102', '2', '很不错', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('107', '72', '2013193102', '3', '很不错', '软件工程1311班', '计算机组成');
INSERT INTO `evaluate` VALUES ('108', '72', '2013193102', '2', '很不错', '软件工程1311班', '软件设计模式与体系结构');
INSERT INTO `evaluate` VALUES ('109', '72', '2013193102', '2', '很不错', '软件工程1311班', '软件设计模式与体系结构');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `m_id` int(20) NOT NULL,
  `password` varchar(15) collate utf8_bin NOT NULL,
  `mname` varchar(15) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1311', '1311', 'admin');
INSERT INTO `manager` VALUES ('1312', 'as1314allg', 'admin2');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL auto_increment,
  `content` varchar(100) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '教学准备充分');
INSERT INTO `questions` VALUES ('2', '讲课内容充实，态度严谨');
INSERT INTO `questions` VALUES ('3', '讲课重点突出');
INSERT INTO `questions` VALUES ('4', '详略得当，讲解难点深入浅出');
INSERT INTO `questions` VALUES ('5', '普通话标准，语言生动，逻辑性强');
INSERT INTO `questions` VALUES ('6', '富有启发性，引导学生积极思维');
INSERT INTO `questions` VALUES ('7', '合理使用教具，用多媒体等电器授课');
INSERT INTO `questions` VALUES ('8', '能够严格要求学生，尊重学生意见');
INSERT INTO `questions` VALUES ('9', '关心爱护学生，对学生一视同仁，注重能力培养');
INSERT INTO `questions` VALUES ('10', '板书工整，汉字规范，书写版面美观');
INSERT INTO `questions` VALUES ('11', '爱护学生，关爱学生，关爱生命');
INSERT INTO `questions` VALUES ('14', '遵守学校法规法纪');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(20) NOT NULL,
  `sname` varchar(15) collate utf8_bin NOT NULL,
  `sex` varchar(4) collate utf8_bin NOT NULL,
  `grade` varchar(15) collate utf8_bin NOT NULL,
  `status` int(1) NOT NULL,
  `date` datetime default NULL,
  `password` varchar(15) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`s_id`),
  KEY `grade` (`grade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2013181201', '李军', '男', '设计1311班', '0', null, '2013181201');
INSERT INTO `student` VALUES ('2013181202', '李敏', '女', '设计1311班', '0', null, '2013181202');
INSERT INTO `student` VALUES ('2013181203', '王浩', '男', '设计1311班', '0', null, '2013181203');
INSERT INTO `student` VALUES ('2013193102', '李大鹏', '男', '软件工程1311班', '0', null, '2013193102');
INSERT INTO `student` VALUES ('2013193103', '李天一', '男', '数学1311班', '0', null, '2013193103');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course` (
  `grade` varchar(15) collate utf8_bin NOT NULL,
  `c_id` int(11) NOT NULL,
  PRIMARY KEY  (`grade`,`c_id`),
  KEY `c_id1` (`c_id`),
  CONSTRAINT `c_id1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grade1` FOREIGN KEY (`grade`) REFERENCES `student` (`grade`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('设计1311班', '1');
INSERT INTO `student_course` VALUES ('软件工程1311班', '2');
INSERT INTO `student_course` VALUES ('软件工程1311班', '3');
INSERT INTO `student_course` VALUES ('设计1311班', '4');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(20) NOT NULL,
  `tname` varchar(15) collate utf8_bin NOT NULL,
  `sex` varchar(4) collate utf8_bin NOT NULL,
  `nation` varchar(8) collate utf8_bin NOT NULL,
  `date` varchar(20) collate utf8_bin default NULL,
  `Idcard` varchar(20) collate utf8_bin NOT NULL,
  `census` varchar(80) collate utf8_bin NOT NULL,
  `politics` varchar(10) collate utf8_bin NOT NULL,
  `background` varchar(8) collate utf8_bin NOT NULL,
  `i_id` int(20) default NULL,
  `password` varchar(15) collate utf8_bin NOT NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('38698', '宁彬', '男', '汉族', '1970-08-06', '422144197609060453', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '38698');
INSERT INTO `teacher` VALUES ('107254', '李三天', '男', '汉族', '1961-09-08', '422122196109080356', '湖北省-襄阳市-襄城区', '团员', '教授', '3', '107254');
INSERT INTO `teacher` VALUES ('372064', '李天一', '男', '侗族', '1984-06-04', '422133198406042314', '湖北省-襄阳市-襄城区', '团员', '本科', '3', '372064');
INSERT INTO `teacher` VALUES ('455383', '谷琼', '女', '汉族', '1972-10-10', '422144197609060454', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '455383');
INSERT INTO `teacher` VALUES ('640068', '李天号', '男', '汉族', '1972-10-10', '422122196109080356', '湖北省-襄阳市-襄城区', '团员', '教授', '3', '640068');
INSERT INTO `teacher` VALUES ('745420', '熊启军', '男', '汉族', '1965-08-07', '122147196508070453', '湖北省-襄阳市-襄城区', '党员', '教授', '1', '745420');
INSERT INTO `teacher` VALUES ('745421', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745422', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745423', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745424', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745425', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745426', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745427', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745428', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745429', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745430', '高俊弼 ', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745431', '高俊捷 ', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745432', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '2', '745421');
INSERT INTO `teacher` VALUES ('745433', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745434', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745435', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745436', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745437', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745438', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745439', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745440', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745441', '高俊弼 ', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745442', '高俊捷 ', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745443', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '1', '745421');
INSERT INTO `teacher` VALUES ('745444', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745445', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745446', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745447', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745448', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745449', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745450', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745451', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745452', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745453', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745454', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '4', '745421');
INSERT INTO `teacher` VALUES ('745455', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745456', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745457', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745458', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745459', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745460', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745461', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745462', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745463', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745464', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '745421');
INSERT INTO `teacher` VALUES ('745465', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745466', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745467', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745468', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745469', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745470', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745471', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745472', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745473', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745474', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745475', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '6', '745421');
INSERT INTO `teacher` VALUES ('745476', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745477', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745478', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745479', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745480', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745481', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745482', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745483', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745484', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745485', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745486', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '7', '745421');
INSERT INTO `teacher` VALUES ('745487', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745488', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745489', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745490', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745491', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745492', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745493', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745494', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745495', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745496', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745497', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '8', '745421');
INSERT INTO `teacher` VALUES ('745498', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745499', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745500', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745501', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745502', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745503', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745504', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745505', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745506', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745507', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745508', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '9', '745421');
INSERT INTO `teacher` VALUES ('745509', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745510', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745511', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745512', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745513', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745514', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745515', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745516', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745517', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745518', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745519', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '10', '745421');
INSERT INTO `teacher` VALUES ('745520', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745521', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745522', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745523', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745524', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745525', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745526', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745527', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745528', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745529', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745530', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '11', '745421');
INSERT INTO `teacher` VALUES ('745531', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745532', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745533', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745534', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745535', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745536', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745537', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745538', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745539', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745540', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745541', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '12', '745421');
INSERT INTO `teacher` VALUES ('745542', '高建弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745543', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745544', '高建德', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745545', '高建明', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745546', '高建茗', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745547', '高建同', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745548', '高建业', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745549', '高红三', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745550', '高俊弼', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745551', '高俊捷', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('745552', '高俊语', '男', '布依族', '1971-06-05', '322122197106052347', '湖北省-襄阳市-襄城区', '中共党员', '博士', '13', '745421');
INSERT INTO `teacher` VALUES ('880249', '李文龙', '男', '汉族', '1975-06-04', '322122199406080324', '湖北省-襄阳市-襄城区', '中共党员', '博士', '5', '880249');

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `t_id` int(20) NOT NULL,
  `c_id` int(11) NOT NULL,
  PRIMARY KEY  (`t_id`,`c_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('455383', '1');
INSERT INTO `teacher_course` VALUES ('745420', '1');
INSERT INTO `teacher_course` VALUES ('745433', '1');
INSERT INTO `teacher_course` VALUES ('38698', '2');
INSERT INTO `teacher_course` VALUES ('745456', '2');
INSERT INTO `teacher_course` VALUES ('745420', '3');
INSERT INTO `teacher_course` VALUES ('745422', '3');
INSERT INTO `teacher_course` VALUES ('745447', '3');
INSERT INTO `teacher_course` VALUES ('745456', '3');
INSERT INTO `teacher_course` VALUES ('745447', '4');
INSERT INTO `teacher_course` VALUES ('745467', '4');
INSERT INTO `teacher_course` VALUES ('455383', '5');
INSERT INTO `teacher_course` VALUES ('745440', '5');
INSERT INTO `teacher_course` VALUES ('745446', '5');
INSERT INTO `teacher_course` VALUES ('745430', '6');
INSERT INTO `teacher_course` VALUES ('745445', '7');
INSERT INTO `teacher_course` VALUES ('745456', '7');
INSERT INTO `teacher_course` VALUES ('745433', '8');
INSERT INTO `teacher_course` VALUES ('745422', '9');
INSERT INTO `teacher_course` VALUES ('38698', '10');
INSERT INTO `teacher_course` VALUES ('745420', '10');
INSERT INTO `teacher_course` VALUES ('745434', '10');
INSERT INTO `teacher_course` VALUES ('745445', '10');
INSERT INTO `teacher_course` VALUES ('745440', '12');
INSERT INTO `teacher_course` VALUES ('745446', '12');
INSERT INTO `teacher_course` VALUES ('745463', '13');
SET FOREIGN_KEY_CHECKS=1;
