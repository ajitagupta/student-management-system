create database studentdata;
use studentdata;
create table students(id int primary key auto_increment,name varchar(255),phoneno varchar(255),city varchar(255));
select * from students;
drop table students;