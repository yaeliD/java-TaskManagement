create database javaSql
go
use javaSql
go
create table friends(
   code int primary key,
   fullName varchar(50),
   email varchar(50)
);
create table task(
	code int,
	taskTitle varchar(20),
	taskDescription varchar(50),
	taskStatus varchar(20),
	belongTo int foreign key REFERENCES friends(code),
	estimatedHour float,
	startDate date,
	endDate date
);
create table statuses(
	taskStatus varchar(20)
);
