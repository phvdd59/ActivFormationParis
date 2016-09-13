
create table springbdd.customer(
cust_id bigint auto_increment primary key,
name varchar(30),
age int(10)
);
use springbdd;

insert into customer (cust_id,name,age) values (1,"aa",15);
insert into customer (cust_id,name,age) values (2,'Julien',18);