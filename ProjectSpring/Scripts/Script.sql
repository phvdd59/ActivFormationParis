/*create database springbdd;*/

create table springbdd.customer(
cust_id bigint auto_increment primary key,
name varchar(30),
age int(10)
);
use springbdd;

insert into customer (cust_id,name,age) values (1,"aa",15);