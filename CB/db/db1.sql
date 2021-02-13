/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - db_cloud_abe
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `db_cloud_abe`;

USE `db_cloud_abe`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_acess_control` */

DROP TABLE IF EXISTS `m_acess_control`;

CREATE TABLE `m_acess_control` (
  `ac_code` int(5) NOT NULL auto_increment,
  `f_code` int(5) NOT NULL,
  `dept_code` int(5) NOT NULL,
  `desig_code` int(5) NOT NULL,
  PRIMARY KEY  (`ac_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_acess_control` */

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `adminid` varchar(20) NOT NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`,`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`name`,`password`,`adminid`,`address`,`phone`,`email`) values (1,'menaka','admin','admin','J. P. Nagar','9916876545','menakareddyso@gmail.com');

/*Table structure for table `m_cloud` */

DROP TABLE IF EXISTS `m_cloud`;

CREATE TABLE `m_cloud` (
  `c_id` int(10) NOT NULL auto_increment,
  `c_name` varchar(200) NOT NULL,
  `c_protocol` varchar(200) default NULL,
  `c_ip` varchar(200) default NULL,
  `c_username` varchar(200) NOT NULL,
  `c_password` varchar(200) NOT NULL,
  `c_status` varchar(50) default NULL,
  `c_remarks` varchar(200) default NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_cloud` */

insert into `m_cloud` (`c_id`,`c_name`,`c_protocol`,`c_ip`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (1,'cloud1','FTP','ftp.drivehq.com','cloudblr1','cloudblr1','Active','First cloud space');
insert into `m_cloud` (`c_id`,`c_name`,`c_protocol`,`c_ip`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (2,'cloud2','FTP','ftp.drivehq.com','cloudblr2','cloudblr2','Active','second cloud space');
insert into `m_cloud` (`c_id`,`c_name`,`c_protocol`,`c_ip`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (3,'cloud3','FTP','ftp.drivehq.com','cloudblr3','cloudblr3','Active','third cloud space');
insert into `m_cloud` (`c_id`,`c_name`,`c_protocol`,`c_ip`,`c_username`,`c_password`,`c_status`,`c_remarks`) values (4,'cloud4','FTP','ftp.drivehq.com','cloudblr4','cloudblr4','Active','fourth cloud space');

/*Table structure for table `m_department` */

DROP TABLE IF EXISTS `m_department`;

CREATE TABLE `m_department` (
  `dept_code` int(10) NOT NULL auto_increment,
  `dept_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`dept_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_department` */

insert into `m_department` (`dept_code`,`dept_name`) values (1,'All');
insert into `m_department` (`dept_code`,`dept_name`) values (2,'Banking');
insert into `m_department` (`dept_code`,`dept_name`) values (3,'Insurance');
insert into `m_department` (`dept_code`,`dept_name`) values (4,'Health Care');
insert into `m_department` (`dept_code`,`dept_name`) values (5,'Telecom');
insert into `m_department` (`dept_code`,`dept_name`) values (6,'Trading');
insert into `m_department` (`dept_code`,`dept_name`) values (7,'Maintainance');

/*Table structure for table `m_designation` */

DROP TABLE IF EXISTS `m_designation`;

CREATE TABLE `m_designation` (
  `desig_code` int(10) NOT NULL auto_increment,
  `desig_name` varchar(100) NOT NULL,
  PRIMARY KEY  (`desig_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_designation` */

insert into `m_designation` (`desig_code`,`desig_name`) values (1,'All');
insert into `m_designation` (`desig_code`,`desig_name`) values (2,'Tr. Programmer');
insert into `m_designation` (`desig_code`,`desig_name`) values (3,'Sr. Programmer');
insert into `m_designation` (`desig_code`,`desig_name`) values (4,'Test Enggineer');
insert into `m_designation` (`desig_code`,`desig_name`) values (5,'Team Lead');
insert into `m_designation` (`desig_code`,`desig_name`) values (6,'Project Leader');
insert into `m_designation` (`desig_code`,`desig_name`) values (7,'Project Manager');

/*Table structure for table `m_file_one` */

DROP TABLE IF EXISTS `m_file_one`;

CREATE TABLE `m_file_one` (
  `file_no` int(11) NOT NULL auto_increment,
  `file_name` varchar(20) default NULL,
  `file_size1` int(11) default NULL,
  `file_size2` int(11) default NULL,
  `padding` int(11) default NULL,
  `no_blocks` int(11) default NULL,
  `hash_blk_nos` varchar(1000) default NULL,
  `user_id` int(11) default NULL,
  `date` varchar(10) default NULL,
  `time` varchar(10) default NULL,
  `day` varchar(10) default NULL,
  PRIMARY KEY  (`file_no`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_file_one` */

insert into `m_file_one` (`file_no`,`file_name`,`file_size1`,`file_size2`,`padding`,`no_blocks`,`hash_blk_nos`,`user_id`,`date`,`time`,`day`) values (1,'ddd.txt',4636,0,0,3,'1-2-3-',2,'24-04-2018','17:49:47','TUESDAY');
insert into `m_file_one` (`file_no`,`file_name`,`file_size1`,`file_size2`,`padding`,`no_blocks`,`hash_blk_nos`,`user_id`,`date`,`time`,`day`) values (2,'dog.png',39268,0,0,20,'4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20-21-22-23-',2,'24-04-2018','18:00:19','TUESDAY');

/*Table structure for table `m_file_upload` */

DROP TABLE IF EXISTS `m_file_upload`;

CREATE TABLE `m_file_upload` (
  `f_code` int(5) NOT NULL auto_increment,
  `f_name` varchar(100) NOT NULL,
  `f_type` varchar(50) NOT NULL,
  `f_upload_date` varchar(50) NOT NULL,
  `owner_id` int(10) NOT NULL,
  `f_size` varchar(100) NOT NULL,
  `f_encrpted_size` varchar(100) NOT NULL,
  `cloud_id` int(10) default NULL,
  PRIMARY KEY  (`f_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_file_upload` */

insert into `m_file_upload` (`f_code`,`f_name`,`f_type`,`f_upload_date`,`owner_id`,`f_size`,`f_encrpted_size`,`cloud_id`) values (1,'ddd.txt','.txt','24-04-2018',2,'653','4636',NULL);
insert into `m_file_upload` (`f_code`,`f_name`,`f_type`,`f_upload_date`,`owner_id`,`f_size`,`f_encrpted_size`,`cloud_id`) values (2,'dog.png','.png','24-04-2018',2,'5473','39268',NULL);

/*Table structure for table `m_hash_code` */

DROP TABLE IF EXISTS `m_hash_code`;

CREATE TABLE `m_hash_code` (
  `hash_unique_code` int(11) NOT NULL auto_increment,
  `hash_code` varchar(40) default NULL,
  `blk_name` varchar(20) default NULL,
  `no_instnce` int(11) default NULL,
  `uploaded_status` varchar(5) default 'no',
  `block_size` varchar(100) default NULL,
  PRIMARY KEY  (`hash_unique_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_hash_code` */

insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (1,'7654b05dd32b079880b0ea03f18401b','1blk_0',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (2,'292ce0095ab3f3408ba2a2be8e309b6','2blk_1',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (3,'438ace12fef679cbb1cda43de0ef1554','3blk_2',1,'yes','636');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (4,'93c3d74801d5e495beca1391571e4bc8','4blk_0',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (5,'a33255d6d5c731ac2042e40ad7228efe','5blk_1',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (6,'2928281cbfe2eca437b166db18f3faf9','6blk_2',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (7,'73b316842d87b7e84df9dd7c29895a50','7blk_3',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (8,'b004c30cdf679436a8200ac2ba1a04c1','8blk_4',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (9,'62bb47daa8523a23c06e6597622469cb','9blk_5',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (10,'ad967cc91862884b05c24f378f8883de','10blk_6',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (11,'39f283e3ab8c4d4e2dab5d89f081c1b6','11blk_7',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (12,'aa37be10bacb26867b439a3539dbc060','12blk_8',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (13,'20b197a6596fbe63e0aa1e4705e2fbab','13blk_9',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (14,'b68de4138eb0fe3bb845aad5bdf42a02','14blk_10',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (15,'fe3d47c7e2cc8de7277312efe69558d0','15blk_11',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (16,'b6ba6242b1e32240beb66b13d8650390','16blk_12',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (17,'f489ae40925eb799f783ca77852abcca','17blk_13',1,'no','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (18,'e3334e3d46e2e1fa59b70954894afa9f','18blk_14',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (19,'49fdcd177a13a952ad9018651f4221cd','19blk_15',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (20,'8cb8fcfd697d56ea191100e38be99691','20blk_16',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (21,'f31b4915163fed4e275fae58ee63a9a7','21blk_17',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (22,'ac8c1597c1434088f7ba2df00858220a','22blk_18',1,'yes','2000');
insert into `m_hash_code` (`hash_unique_code`,`hash_code`,`blk_name`,`no_instnce`,`uploaded_status`,`block_size`) values (23,'416cdf3149a364a79f5bbad9d6403777','23blk_19',1,'yes','1268');

/*Table structure for table `m_level1` */

DROP TABLE IF EXISTS `m_level1`;

CREATE TABLE `m_level1` (
  `m_l1_code` int(11) NOT NULL default '0',
  `m_l1_byte` varchar(4) default 'NULL',
  PRIMARY KEY  (`m_l1_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_level1` */

insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (0,'00');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (1,'01');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (2,'02');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (3,'03');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (4,'04');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (5,'05');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (6,'06');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (7,'07');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (8,'08');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (9,'09');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (10,'0a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (11,'0b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (12,'0c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (13,'0d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (14,'0e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (15,'0f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (16,'10');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (17,'11');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (18,'12');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (19,'13');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (20,'14');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (21,'15');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (22,'16');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (23,'17');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (24,'18');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (25,'19');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (26,'1a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (27,'1b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (28,'1c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (29,'1d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (30,'1e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (31,'1f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (32,'20');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (33,'21');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (34,'22');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (35,'23');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (36,'24');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (37,'25');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (38,'26');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (39,'27');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (40,'28');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (41,'29');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (42,'2a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (43,'2b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (44,'2c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (45,'2d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (46,'2e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (47,'2f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (48,'30');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (49,'31');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (50,'32');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (51,'33');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (52,'34');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (53,'35');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (54,'36');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (55,'37');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (56,'38');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (57,'39');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (58,'3a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (59,'3b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (60,'3c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (61,'3d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (62,'3e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (63,'3f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (64,'40');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (65,'41');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (66,'42');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (67,'43');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (68,'44');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (69,'45');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (70,'46');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (71,'47');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (72,'48');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (73,'49');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (74,'4a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (75,'4b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (76,'4c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (77,'4d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (78,'4e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (79,'4f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (80,'50');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (81,'51');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (82,'52');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (83,'53');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (84,'54');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (85,'55');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (86,'56');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (87,'57');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (88,'58');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (89,'59');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (90,'5a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (91,'5b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (92,'5c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (93,'5d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (94,'5e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (95,'5f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (96,'60');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (97,'61');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (98,'62');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (99,'63');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (100,'64');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (101,'65');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (102,'66');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (103,'67');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (104,'68');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (105,'69');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (106,'6a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (107,'6b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (108,'6c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (109,'6d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (110,'6e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (111,'6f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (112,'70');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (113,'71');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (114,'72');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (115,'73');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (116,'74');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (117,'75');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (118,'76');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (119,'77');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (120,'78');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (121,'79');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (122,'7a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (123,'7b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (124,'7c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (125,'7d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (126,'7e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (127,'7f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (128,'80');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (129,'81');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (130,'82');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (131,'83');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (132,'84');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (133,'85');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (134,'86');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (135,'87');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (136,'88');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (137,'89');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (138,'8a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (139,'8b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (140,'8c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (141,'8d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (142,'8e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (143,'8f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (144,'90');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (145,'91');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (146,'92');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (147,'93');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (148,'94');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (149,'95');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (150,'96');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (151,'97');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (152,'98');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (153,'99');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (154,'9a');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (155,'9b');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (156,'9c');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (157,'9d');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (158,'9e');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (159,'9f');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (160,'a0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (161,'a1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (162,'a2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (163,'a3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (164,'a4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (165,'a5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (166,'a6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (167,'a7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (168,'a8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (169,'a9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (170,'aa');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (171,'ab');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (172,'ac');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (173,'ad');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (174,'ae');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (175,'af');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (176,'b0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (177,'b1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (178,'b2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (179,'b3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (180,'b4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (181,'b5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (182,'b6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (183,'b7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (184,'b8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (185,'b9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (186,'ba');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (187,'bb');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (188,'bc');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (189,'bd');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (190,'be');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (191,'bf');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (192,'c0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (193,'c1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (194,'c2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (195,'c3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (196,'c4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (197,'c5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (198,'c6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (199,'c7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (200,'c8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (201,'c9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (202,'ca');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (203,'cb');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (204,'cc');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (205,'cd');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (206,'ce');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (207,'cf');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (208,'d0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (209,'d1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (210,'d2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (211,'d3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (212,'d4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (213,'d5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (214,'d6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (215,'d7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (216,'d8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (217,'d9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (218,'da');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (219,'db');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (220,'dc');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (221,'dd');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (222,'de');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (223,'df');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (224,'e0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (225,'e1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (226,'e2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (227,'e3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (228,'e4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (229,'e5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (230,'e6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (231,'e7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (232,'e8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (233,'e9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (234,'ea');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (235,'eb');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (236,'ec');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (237,'ed');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (238,'ee');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (239,'ef');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (240,'f0');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (241,'f1');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (242,'f2');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (243,'f3');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (244,'f4');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (245,'f5');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (246,'f6');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (247,'f7');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (248,'f8');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (249,'f9');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (250,'fa');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (251,'fb');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (252,'fc');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (253,'fd');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (254,'fe');
insert into `m_level1` (`m_l1_code`,`m_l1_byte`) values (255,'ff');

/*Table structure for table `m_level2` */

DROP TABLE IF EXISTS `m_level2`;

CREATE TABLE `m_level2` (
  `m_l2_code` int(11) NOT NULL auto_increment,
  `m_l1_code` int(11) default NULL,
  `m_l2_byte` varchar(4) default NULL,
  PRIMARY KEY  (`m_l2_code`),
  KEY `m_l1_code` (`m_l1_code`),
  CONSTRAINT `m_level2_ibfk_1` FOREIGN KEY (`m_l1_code`) REFERENCES `m_level1` (`m_l1_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_level2` */

insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (1,63,'24');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (2,87,'4c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (3,181,'58');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (4,64,'66');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (5,193,'c1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (6,20,'c1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (7,241,'cc');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (8,118,'54');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (9,41,'2c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (10,67,'8a');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (11,93,'0a');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (12,21,'d4');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (13,123,'73');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (14,70,'a5');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (15,56,'87');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (16,50,'82');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (17,81,'bd');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (18,139,'b2');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (19,111,'8c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (20,86,'da');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (21,183,'b6');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (22,147,'c3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (23,163,'32');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (24,41,'28');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (25,115,'b3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (26,176,'04');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (27,98,'bb');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (28,173,'96');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (29,57,'f2');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (30,170,'37');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (31,32,'b1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (32,182,'8d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (33,254,'3d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (34,182,'ba');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (35,244,'89');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (36,227,'33');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (37,73,'fd');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (38,140,'b8');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (39,243,'1b');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (40,172,'8c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (41,65,'6c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (42,76,'5b');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (43,23,'a3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (44,199,'8f');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (45,139,'df');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (46,162,'b1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (47,96,'3c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (48,139,'c2');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (49,186,'f0');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (50,211,'05');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (51,164,'3d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (52,116,'35');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (53,69,'d8');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (54,164,'aa');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (55,66,'9a');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (56,109,'8b');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (57,138,'c9');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (58,95,'97');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (59,239,'61');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (60,168,'37');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (61,204,'c3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (62,57,'89');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (63,112,'b9');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (64,73,'67');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (65,251,'b5');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (66,22,'0d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (67,82,'46');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (68,131,'13');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (69,74,'f1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (70,246,'4e');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (71,250,'75');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (72,24,'12');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (73,99,'dd');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (74,67,'d6');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (75,197,'95');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (76,66,'ad');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (77,217,'2e');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (78,94,'14');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (79,250,'45');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (80,221,'94');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (81,222,'d3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (82,255,'25');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (83,214,'b9');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (84,254,'6c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (85,239,'72');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (86,165,'c5');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (87,209,'91');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (88,246,'d1');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (89,254,'bc');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (90,157,'69');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (91,180,'8f');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (92,201,'b8');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (93,99,'9e');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (94,253,'e8');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (95,186,'34');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (96,155,'19');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (97,204,'1d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (98,217,'db');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (99,117,'26');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (100,61,'89');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (101,92,'d6');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (102,109,'14');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (103,120,'29');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (104,164,'11');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (105,187,'a6');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (106,172,'07');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (107,86,'ae');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (108,239,'6d');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (109,124,'c9');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (110,204,'1e');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (111,201,'30');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (112,103,'75');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (113,228,'63');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (114,203,'90');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (115,199,'8b');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (116,239,'3c');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (117,134,'50');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (118,47,'d6');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (119,23,'3f');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (120,135,'c3');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (121,29,'63');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (122,112,'cd');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (123,50,'dc');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (124,121,'53');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (125,185,'4f');
insert into `m_level2` (`m_l2_code`,`m_l1_code`,`m_l2_byte`) values (126,152,'01');

/*Table structure for table `m_level3` */

DROP TABLE IF EXISTS `m_level3`;

CREATE TABLE `m_level3` (
  `m_l3_code` int(11) NOT NULL auto_increment,
  `m_l2_code` int(11) default NULL,
  `m_l3_bytes` varchar(30) default NULL,
  `hash_uniq_code` int(11) default NULL,
  PRIMARY KEY  (`m_l3_code`),
  KEY `m_l2_code` (`m_l2_code`),
  CONSTRAINT `m_level3_ibfk_1` FOREIGN KEY (`m_l2_code`) REFERENCES `m_level2` (`m_l2_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_level3` */

insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (1,8,'b05dd32b079880b0ea03f18401b',1);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (2,9,'e0095ab3f3408ba2a2be8e309b6',2);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (3,10,'ce12fef679cbb1cda43de0ef1554',3);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (4,22,'d74801d5e495beca1391571e4bc8',4);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (5,23,'55d6d5c731ac2042e40ad7228efe',5);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (6,24,'281cbfe2eca437b166db18f3faf9',6);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (7,25,'16842d87b7e84df9dd7c29895a50',7);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (8,26,'c30cdf679436a8200ac2ba1a04c1',8);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (9,27,'47daa8523a23c06e6597622469cb',9);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (10,28,'7cc91862884b05c24f378f8883de',10);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (11,29,'83e3ab8c4d4e2dab5d89f081c1b6',11);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (12,30,'be10bacb26867b439a3539dbc060',12);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (13,31,'97a6596fbe63e0aa1e4705e2fbab',13);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (14,32,'e4138eb0fe3bb845aad5bdf42a02',14);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (15,33,'47c7e2cc8de7277312efe69558d0',15);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (16,34,'6242b1e32240beb66b13d8650390',16);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (17,35,'ae40925eb799f783ca77852abcca',17);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (18,36,'4e3d46e2e1fa59b70954894afa9f',18);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (19,37,'cd177a13a952ad9018651f4221cd',19);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (20,38,'fcfd697d56ea191100e38be99691',20);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (21,39,'4915163fed4e275fae58ee63a9a7',21);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (22,40,'1597c1434088f7ba2df00858220a',22);
insert into `m_level3` (`m_l3_code`,`m_l2_code`,`m_l3_bytes`,`hash_uniq_code`) values (23,41,'df3149a364a79f5bbad9d6403777',23);

/*Table structure for table `m_owner` */

DROP TABLE IF EXISTS `m_owner`;

CREATE TABLE `m_owner` (
  `id` int(5) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `ownerid` varchar(20) NOT NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(15) default NULL,
  `email` varchar(50) default NULL,
  `u_credit` int(10) default NULL,
  PRIMARY KEY  (`id`,`ownerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_owner` */

insert into `m_owner` (`id`,`name`,`password`,`ownerid`,`address`,`phone`,`email`,`u_credit`) values (2,'menaka','123','menaka','Bangalore','7411105260','menakareddyso@gmail.com',-239);
insert into `m_owner` (`id`,`name`,`password`,`ownerid`,`address`,`phone`,`email`,`u_credit`) values (3,'priya','priya','priya','Bangalore','7411105260','menakareddyso@gmail.com',NULL);
insert into `m_owner` (`id`,`name`,`password`,`ownerid`,`address`,`phone`,`email`,`u_credit`) values (4,'priyanka','priyanka','priyanka','bangalore','7411105260','menakareddyso@gmail.com',NULL);

/*Table structure for table `m_recharge` */

DROP TABLE IF EXISTS `m_recharge`;

CREATE TABLE `m_recharge` (
  `r_id` int(10) NOT NULL auto_increment,
  `r_code` int(10) default NULL,
  `r_cost` int(10) default NULL,
  `r_status` varchar(10) default NULL,
  PRIMARY KEY  (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_recharge` */

insert into `m_recharge` (`r_id`,`r_code`,`r_cost`,`r_status`) values (12,56789,500,'Invalid');

/*Table structure for table `m_rnskey` */

DROP TABLE IF EXISTS `m_rnskey`;

CREATE TABLE `m_rnskey` (
  `userid` int(30) default NULL,
  `key1` varchar(50) NOT NULL,
  `key2` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_rnskey` */

insert into `m_rnskey` (`userid`,`key1`,`key2`) values (2,'499','479');
insert into `m_rnskey` (`userid`,`key1`,`key2`) values (3,'467','503');
insert into `m_rnskey` (`userid`,`key1`,`key2`) values (4,'521','541');

/*Table structure for table `m_spconfig` */

DROP TABLE IF EXISTS `m_spconfig`;

CREATE TABLE `m_spconfig` (
  `s_code` int(10) NOT NULL auto_increment,
  `s_id` int(10) default NULL,
  `s_size` double default NULL,
  `s_cost` double default NULL,
  `s_qty` int(5) default NULL,
  `s_status` varchar(10) default NULL,
  PRIMARY KEY  (`s_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_spconfig` */

insert into `m_spconfig` (`s_code`,`s_id`,`s_size`,`s_cost`,`s_qty`,`s_status`) values (20,1,10201.16015625,5,0,'Active');
insert into `m_spconfig` (`s_code`,`s_id`,`s_size`,`s_cost`,`s_qty`,`s_status`) values (27,2,10137.4089355471,5,1,'Active');
insert into `m_spconfig` (`s_code`,`s_id`,`s_size`,`s_cost`,`s_qty`,`s_status`) values (28,3,10201.16015625,15,2,'Active');
insert into `m_spconfig` (`s_code`,`s_id`,`s_size`,`s_cost`,`s_qty`,`s_status`) values (32,4,9811.8215332033,5,3,'Active');

/*Table structure for table `m_transaction` */

DROP TABLE IF EXISTS `m_transaction`;

CREATE TABLE `m_transaction` (
  `t_no` int(10) NOT NULL auto_increment,
  `t_date` varchar(100) NOT NULL,
  `t_time` varchar(100) NOT NULL,
  `u_code` int(10) NOT NULL,
  `f_code` int(10) NOT NULL,
  `dept_code` int(10) NOT NULL,
  `design_code` int(10) NOT NULL,
  `t_status` varchar(50) default NULL,
  PRIMARY KEY  (`t_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_transaction` */

insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`u_code`,`f_code`,`dept_code`,`design_code`,`t_status`) values (1,'21-04-2018','14:06:41',1,1,2,2,'Allowed');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`u_code`,`f_code`,`dept_code`,`design_code`,`t_status`) values (2,'21-04-2018','14:25:51',1,2,2,2,'Allowed');
insert into `m_transaction` (`t_no`,`t_date`,`t_time`,`u_code`,`f_code`,`dept_code`,`design_code`,`t_status`) values (3,'21-04-2018','14:26:24',1,1,2,2,'Allowed');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_code` int(10) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `u_name` varchar(100) NOT NULL,
  `dept_code` int(10) NOT NULL,
  `design_code` int(10) NOT NULL,
  `u_address` varchar(200) NOT NULL,
  `u_city` varchar(100) default NULL,
  `u_cell` varchar(100) default NULL,
  `u_phone` bigint(20) default NULL,
  `u_email` varchar(100) default NULL,
  `u_hashcode` varchar(200) default NULL,
  `user_credit` varchar(200) default NULL,
  PRIMARY KEY  (`u_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_code`,`username`,`password`,`u_name`,`dept_code`,`design_code`,`u_address`,`u_city`,`u_cell`,`u_phone`,`u_email`,`u_hashcode`,`user_credit`) values (1,'menaka','1234','menaka123',2,2,'bangalore','bangalore','7411105260',7411105260,'menakareddyso@gmail.com','99d11896dd4268378e3ee4b3b384af32',NULL);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
