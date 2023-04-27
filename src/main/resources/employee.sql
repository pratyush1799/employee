drop database if exists employeeDB;
create database employeeDB;

use employeeDB;

drop table if exists employee;
create table employee (
	id int(11) unsigned NOT NULL AUTO_INCREMENT,
	name varchar(25) DEFAULT NULL,
	department varchar(25) DEFAULT NULL,
	salary double DEFAULT NULL,
	PRIMARY KEY (id)
);