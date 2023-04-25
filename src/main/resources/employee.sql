drop database if exists employeeDB;
create database employeeDB;

use employeeDB;

drop table if exists employee;
create table Student (
	id int(11) primary key,
	name varchar(25) not null,
	department varchar(25) not null,
	salary double not null
);