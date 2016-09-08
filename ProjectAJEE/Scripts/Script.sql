use ajee;
delete from personne;
insert into personne select * from emma;
alter table backup modify idPersonne bigint(19) primary key auto_increment; 