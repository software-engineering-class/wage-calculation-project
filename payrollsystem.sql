/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.5.27 : Database - payrollsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`payrollsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `payrollsystem`;

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `departmentphone` varchar(11) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `department` */

insert  into `department`(`departmentid`,`departmentname`,`departmentphone`,`address`) values (1,'财务部','12312312345','北苑'),(2,'人力资源部','15461234765','南苑'),(4,'后期部','12245674156','学校北门附近');

/*Table structure for table `salary` */

DROP TABLE IF EXISTS `salary`;

CREATE TABLE `salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `staffname` varchar(20) NOT NULL,
  `dates` varchar(20) NOT NULL,
  `base_wage` double DEFAULT NULL,
  `class_fee` double DEFAULT NULL,
  `base_performance` double DEFAULT NULL,
  `age_pay` double DEFAULT NULL,
  `phone_subsidy` double DEFAULT NULL,
  `traffic_subsidy` double DEFAULT NULL,
  `overtime_subsidy` double DEFAULT NULL,
  `labour_insurance` double DEFAULT NULL,
  `unemployment_insurance` double DEFAULT NULL,
  `medical_insurance` double DEFAULT NULL,
  `income_tax` double DEFAULT NULL,
  `accumulation_fund` double DEFAULT NULL,
  `should_wage` double DEFAULT NULL,
  `deduct_wage` double DEFAULT NULL,
  `real_wage` double DEFAULT NULL,
  PRIMARY KEY (`salary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `salary` */

insert  into `salary`(`salary_id`,`username`,`staffname`,`dates`,`base_wage`,`class_fee`,`base_performance`,`age_pay`,`phone_subsidy`,`traffic_subsidy`,`overtime_subsidy`,`labour_insurance`,`unemployment_insurance`,`medical_insurance`,`income_tax`,`accumulation_fund`,`should_wage`,`deduct_wage`,`real_wage`) values (1,'user','1','2022/8',1,1,1,1,1,1,1,1,1,1,1,1,7,5,2),(3,'user','1','2022/7',1,1,1,1,1,1,1,1,1,1,1,1,7,5,2);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pay_card` varchar(20) DEFAULT NULL,
  `ID_card` varchar(20) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `departmentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`password`,`name`,`pay_card`,`ID_card`,`status`,`phone`,`departmentid`) values (1,'admin','1234','admin','10001','10001',1,'15689003493',1),(2,'user','1234','user','10003','10003',0,'15689001493',2);

/*Table structure for table `wagedetail` */

DROP TABLE IF EXISTS `wagedetail`;

CREATE TABLE `wagedetail` (
  `username` varchar(20) NOT NULL,
  `projectid` int(11) NOT NULL,
  `projectamount` double NOT NULL,
  `dates` varchar(20) NOT NULL,
  PRIMARY KEY (`username`,`projectid`,`dates`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wagedetail` */

insert  into `wagedetail`(`username`,`projectid`,`projectamount`,`dates`) values ('user',1,2000,'2022/8'),('user',2,400,'2022/8'),('user',3,100,'2022/8'),('user',4,450,'2022/8'),('user',5,300,'2022/8'),('user',6,700,'2022/8'),('user',7,400,'2022/8');

/*Table structure for table `wageproject` */

DROP TABLE IF EXISTS `wageproject`;

CREATE TABLE `wageproject` (
  `projectid` int(11) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(20) DEFAULT NULL,
  `types` int(11) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`projectid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `wageproject` */

insert  into `wageproject`(`projectid`,`projectname`,`types`,`note`) values (1,'固定工资',0,'无'),(2,'全勤奖',1,'无'),(3,'加班工资',2,'无'),(4,'失业保险',3,'无'),(5,'医疗保险',3,'无'),(6,'工龄工资',0,'无'),(7,'课时费',0,'无'),(13,'111',1,'111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
