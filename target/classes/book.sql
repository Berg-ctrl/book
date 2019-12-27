/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : book

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-12-27 13:26:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `book_author` varchar(20) DEFAULT NULL,
  `book_publish` varchar(20) DEFAULT NULL,
  `book_category` int(11) DEFAULT NULL,
  `book_price` double DEFAULT NULL,
  `book_introduction` varchar(100) DEFAULT NULL,
  `book_copyNum` int(10) DEFAULT NULL,
  `book_roomNo` int(10) DEFAULT NULL,
  `book_state` varchar(10) DEFAULT '',
  PRIMARY KEY (`book_id`),
  KEY `book_category` (`book_category`),
  CONSTRAINT `book_category` FOREIGN KEY (`book_category`) REFERENCES `book_category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '巨人的陨落', '肯.福莱特', '江苏凤凰文艺出版社', '1', '129', '在第一次世界大战中发生的故事', null, null, '不可借');
INSERT INTO `book` VALUES ('2', '三体', '刘慈欣', '南京大学出版社', '1', '68', '科幻小说', null, null, '可借');
INSERT INTO `book` VALUES ('3', '复活', '列夫.托尔斯泰', '上海译文出版社', '1', '19', '俄国小说', null, null, '可借');
INSERT INTO `book` VALUES ('6', '平凡的世界', '路遥', '上海文艺出版社', '1', '88', '孙少平和孙少安两兄弟...', null, null, '可借');
INSERT INTO `book` VALUES ('15', '白鹿原', '陈忠实', '南京出版社', '1', '36', '当代小说', null, null, '可借');
INSERT INTO `book` VALUES ('16', '计算机网络', '谢希仁', '电子工业出版社', '3', '49', '计算机专业书籍', null, null, '可借');
INSERT INTO `book` VALUES ('17', '霍乱时期的爱情', '加西亚·马尔克斯', '译林出版社', '9', '39', '外国小说', null, null, '不可借');
INSERT INTO `book` VALUES ('18', '天才在左疯子在右', '高铭', '北京联合出版公司', '1', '39.8', '心理学', null, null, '不可借');
INSERT INTO `book` VALUES ('19', '废都', '贾平凹', '商务印书馆', '8', '29', '当代小说', null, null, '不可借');
INSERT INTO `book` VALUES ('20', 'jQuery', 'Ryan', '中国电力出版社', '3', '78', 'js库', null, null, '不可借');
INSERT INTO `book` VALUES ('21', '123', '123', '123', '3', '123', '123', null, null, null);

-- ----------------------------
-- Table structure for `book_category`
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES ('1', '小说');
INSERT INTO `book_category` VALUES ('2', '历史');
INSERT INTO `book_category` VALUES ('3', '计算机');
INSERT INTO `book_category` VALUES ('4', '哲学');
INSERT INTO `book_category` VALUES ('5', '社会科学');
INSERT INTO `book_category` VALUES ('6', '政治法律');
INSERT INTO `book_category` VALUES ('7', '军事科学');
INSERT INTO `book_category` VALUES ('8', '中国文学');
INSERT INTO `book_category` VALUES ('9', '外国文学');
INSERT INTO `book_category` VALUES ('10', '外国传记');
INSERT INTO `book_category` VALUES ('11', '英语');
INSERT INTO `book_category` VALUES ('12', '俄国小说');
INSERT INTO `book_category` VALUES ('13', '心理学');
INSERT INTO `book_category` VALUES ('14', '言情小说');
INSERT INTO `book_category` VALUES ('15', '武侠小说');
INSERT INTO `book_category` VALUES ('16', '环境科学');
INSERT INTO `book_category` VALUES ('17', '纪实文学');

-- ----------------------------
-- Table structure for `borrowingbooks`
-- ----------------------------
DROP TABLE IF EXISTS `borrowingbooks`;
CREATE TABLE `borrowingbooks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `true_back_date` date DEFAULT NULL,
  `should_back_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `p_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowingbooks
-- ----------------------------
INSERT INTO `borrowingbooks` VALUES ('3', '1', '3', '2018-10-14', '2019-12-16', null);
INSERT INTO `borrowingbooks` VALUES ('9', '5', '1', '2018-10-16', null, null);
INSERT INTO `borrowingbooks` VALUES ('24', '1', '6', '2018-10-16', '2019-12-16', null);
INSERT INTO `borrowingbooks` VALUES ('25', '1', '15', '2018-10-31', '2019-12-13', null);
INSERT INTO `borrowingbooks` VALUES ('26', '1', '2', '2018-10-31', '2019-12-17', null);
INSERT INTO `borrowingbooks` VALUES ('28', '5', '19', '2018-11-03', null, null);
INSERT INTO `borrowingbooks` VALUES ('29', '1', '16', '2018-11-04', null, null);
INSERT INTO `borrowingbooks` VALUES ('31', '2', '20', '2018-11-04', null, null);
INSERT INTO `borrowingbooks` VALUES ('32', '1', '6', '2018-10-16', '2019-12-16', null);
INSERT INTO `borrowingbooks` VALUES ('38', '1', '2', '2019-12-11', '2019-12-17', null);
INSERT INTO `borrowingbooks` VALUES ('39', '1', '2', '2019-12-11', '2019-12-17', null);
INSERT INTO `borrowingbooks` VALUES ('40', '1', '3', '2019-12-11', '2019-12-16', null);

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '信息工程学院');
INSERT INTO `dept` VALUES ('2', '体育学院');
INSERT INTO `dept` VALUES ('3', '美术学院');
INSERT INTO `dept` VALUES ('4', '电子工程学院');

-- ----------------------------
-- Table structure for `fine`
-- ----------------------------
DROP TABLE IF EXISTS `fine`;
CREATE TABLE `fine` (
  `fine_id` int(10) NOT NULL DEFAULT '0',
  `user_id` int(10) DEFAULT NULL,
  `book_id` int(10) DEFAULT NULL,
  `deal_time` date DEFAULT NULL,
  `fine_money` int(20) DEFAULT NULL,
  `is_handin` varchar(10) DEFAULT NULL,
  `admin_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`fine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of fine
-- ----------------------------

-- ----------------------------
-- Table structure for `p_admin`
-- ----------------------------
DROP TABLE IF EXISTS `p_admin`;
CREATE TABLE `p_admin` (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) DEFAULT NULL,
  `admin_pwd` varchar(20) DEFAULT NULL,
  `admin_email` varchar(20) DEFAULT NULL,
  `admin_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_admin
-- ----------------------------
INSERT INTO `p_admin` VALUES ('1', 'admin', 'root', '1324688478@qq.com', null);

-- ----------------------------
-- Table structure for `p_user`
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_pwd` varchar(20) DEFAULT NULL,
  `user_email` varchar(30) DEFAULT NULL,
  `user_sex` varchar(5) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `dept_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES ('1', 'yxc', '123456', 'for@163.com', null, null, null);
INSERT INTO `p_user` VALUES ('2', 'zhangfei', '123456', 'forzf@163.com', null, null, null);
INSERT INTO `p_user` VALUES ('5', '李四', '123456', null, null, null, null);
INSERT INTO `p_user` VALUES ('6', 'LeBronJames', '123456', '1111@qq.com', null, null, null);
INSERT INTO `p_user` VALUES ('7', '科比', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('8', '柏拉图', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('9', '拿破仑', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('10', '欧文', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('11', '库兹马', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('12', '球哥', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('13', '魔术师', null, null, null, null, null);
INSERT INTO `p_user` VALUES ('16', '周杰伦', null, null, null, null, null);

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(10) NOT NULL,
  `room_address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '101');

-- ----------------------------
-- Table structure for `seat`
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `seat_id` int(10) NOT NULL AUTO_INCREMENT,
  `seat_num` int(10) DEFAULT NULL,
  `seat_state` varchar(10) DEFAULT NULL,
  `room_id` int(10) DEFAULT NULL,
  `seat_used_num` int(10) DEFAULT NULL,
  PRIMARY KEY (`seat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES ('1', '1', '空闲', '101', '6');
INSERT INTO `seat` VALUES ('2', '2', '空闲', '101', '6');
INSERT INTO `seat` VALUES ('3', '4', '空闲', '101', '1');
INSERT INTO `seat` VALUES ('4', '3', '空闲', '101', '1');
INSERT INTO `seat` VALUES ('5', '5', '空闲', '101', '1');
INSERT INTO `seat` VALUES ('6', '6', '空闲', '101', '1');
INSERT INTO `seat` VALUES ('7', '7', '空闲', '201', '1');
INSERT INTO `seat` VALUES ('8', '8', '空闲', '201', '3');

-- ----------------------------
-- Table structure for `user_seat`
-- ----------------------------
DROP TABLE IF EXISTS `user_seat`;
CREATE TABLE `user_seat` (
  `user_seat_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `seat_id` int(10) DEFAULT NULL,
  `use_time` date DEFAULT NULL,
  `clear_time` date DEFAULT NULL,
  PRIMARY KEY (`user_seat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_seat
-- ----------------------------
INSERT INTO `user_seat` VALUES ('1', '1', '1', null, '2019-12-14');
INSERT INTO `user_seat` VALUES ('3', '1', '2', '2019-12-14', '2019-12-14');
INSERT INTO `user_seat` VALUES ('4', '1', '1', '2019-12-14', '2019-12-15');
INSERT INTO `user_seat` VALUES ('5', '1', '1', '2019-12-17', '2019-12-17');
INSERT INTO `user_seat` VALUES ('6', '1', '8', '2019-12-17', '2019-12-17');
INSERT INTO `user_seat` VALUES ('7', '1', '8', '2019-12-17', '2019-12-17');

-- ----------------------------
-- Table structure for `wy`
-- ----------------------------
DROP TABLE IF EXISTS `wy`;
CREATE TABLE `wy` (
  `wy_id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `admin_id` int(10) DEFAULT NULL,
  `book_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`wy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of wy
-- ----------------------------
INSERT INTO `wy` VALUES ('1', '1', '1', '1');
INSERT INTO `wy` VALUES ('2', '1', '2', '3');

-- ----------------------------
-- View structure for `查询书籍`
-- ----------------------------
DROP VIEW IF EXISTS `查询书籍`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询书籍` AS select `book`.`book_id` AS `book_id`,`book`.`book_name` AS `book_name`,`book`.`book_author` AS `book_author`,`book`.`book_publish` AS `book_publish`,`book`.`book_category` AS `book_category`,`book`.`book_price` AS `book_price`,`book`.`book_introduction` AS `book_introduction`,`book`.`book_copyNum` AS `book_copyNum`,`book`.`book_roomNo` AS `book_roomNo`,`book`.`book_state` AS `book_state` from `book` ;

-- ----------------------------
-- View structure for `查询借书记录`
-- ----------------------------
DROP VIEW IF EXISTS `查询借书记录`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询借书记录` AS select `borrowingbooks`.`user_id` AS `user_id`,`borrowingbooks`.`book_id` AS `book_id`,`borrowingbooks`.`date` AS `date`,`borrowingbooks`.`true_back_date` AS `true_back_date`,`book`.`book_name` AS `book_name` from (`borrowingbooks` join `book`) where (`borrowingbooks`.`book_id` = `book`.`book_id`) ;

-- ----------------------------
-- View structure for `查询用户`
-- ----------------------------
DROP VIEW IF EXISTS `查询用户`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询用户` AS select `p_user`.`user_id` AS `user_id`,`p_user`.`user_name` AS `user_name`,`p_user`.`user_pwd` AS `user_pwd`,`p_user`.`user_email` AS `user_email`,`p_user`.`user_sex` AS `user_sex`,`p_user`.`user_type` AS `user_type`,`p_user`.`dept_id` AS `dept_id` from `p_user` ;

-- ----------------------------
-- View structure for `查询空余座位`
-- ----------------------------
DROP VIEW IF EXISTS `查询空余座位`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询空余座位` AS select `seat`.`seat_id` AS `seat_id`,`seat`.`seat_num` AS `seat_num`,`seat`.`seat_state` AS `seat_state`,`seat`.`room_id` AS `room_id`,`seat`.`seat_used_num` AS `seat_used_num` from `seat` where (`seat`.`seat_state` = '空闲') ;

-- ----------------------------
-- View structure for `查询违约记录`
-- ----------------------------
DROP VIEW IF EXISTS `查询违约记录`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询违约记录` AS select `wy`.`wy_id` AS `wy_id`,`wy`.`user_id` AS `user_id`,`wy`.`admin_id` AS `admin_id`,`wy`.`book_id` AS `book_id` from `wy` ;

-- ----------------------------
-- View structure for `查询预约记录`
-- ----------------------------
DROP VIEW IF EXISTS `查询预约记录`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `查询预约记录` AS select `user_seat`.`user_seat_id` AS `user_seat_id`,`user_seat`.`user_id` AS `user_id`,`user_seat`.`seat_id` AS `seat_id`,`user_seat`.`use_time` AS `use_time`,`user_seat`.`clear_time` AS `clear_time` from `user_seat` ;

-- ----------------------------
-- Procedure structure for `查询书籍`
-- ----------------------------
DROP PROCEDURE IF EXISTS `查询书籍`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `查询书籍`()
BEGIN
SELECT * FROM book;
END
;;
DELIMITER ;
