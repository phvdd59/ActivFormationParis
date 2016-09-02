USE marchandphva;
drop table produit;
drop table marchand;
drop table marchand2;
create table marchand (
	idMarchand bigint primary key auto_increment,
	nomMarchand varchar(30),
	ageMarchand varchar(3)
);

create table produit (
idProduit bigint primary key auto_increment ,
idMarchand bigint,
nomProduit varchar(255),
qteProduit int 
);

insert into marchand values 
	(null,"ambr","0"),
	(null,"anfr","1"),
	(null,"beba","2"),
	(null,"emma","3"),
	(null,"etga","4"),
	(null,"issa","5"),
	(null,"jeci","6"),
	(null,"joca","7"),
	(null,"made","8"),
	(null,"soka","9"),
	(null,"thcr","10"),
	(null,"thde","11")
;

INSERT INTO produit (idMarchand, nomProduit, qteProduit)VALUES (1,'prdDEambr','0');

update produit set idMarchand = "1" where idMarchand = "12";
update produit set idMarchand = "2" where idMarchand = "13";
update produit set idMarchand = "3" where idMarchand = "14";
update produit set idMarchand = "4" where idMarchand = "15";
update produit set idMarchand = "5" where idMarchand = "16";
update produit set idMarchand = "6" where idMarchand = "17";
update produit set idMarchand = "7" where idMarchand = "18";
update produit set idMarchand = "8" where idMarchand = "19";
update produit set idMarchand = "9" where idMarchand = "20";
update produit set idMarchand = "10" where idMarchand = "21";
update produit set idMarchand = "11" where idMarchand = "22";

select * from marchand;
select * from produit;
-- sum groupe
-- alias
-- int�grit�s
ALTER TABLE produit ADD CONSTRAINT idMFK 
	FOREIGN KEY(idMarchand) REFERENCES marchand(idMarchand);

delete from produit where idMarchand = 1;
delete from marchand where idMarchand = 1;	

insert into marchand values (null,"ambr","0");

update marchand set idMarchand = 1 where idMarchand = 13;

insert into produit values(1,1,"Prd Ambr","0");
update produit set qteProduit = 100 where idProduit = 1;
update marchand set ageMarchand =  20 where idMarchand = 1;
update marchand set idMarchand = 30 where idMarchand = 1;

select * from produit as p inner join marchand as m 
	on p.idMarchand = m.idMarchand where m.idMarchand = 2
	order by p.idProduit asc limit 5 offset 1; 




drop table marchand2;
create table marchand2 (
	idMarchand bigint primary key auto_increment,
	nomMarchand varchar(30),
	ageMarchand varchar(3)
);

ALTER TABLE marchand2 ADD CONSTRAINT idPFK FOREIGN KEY(idMarchand) REFERENCES marchand(idMarchand);


delete from marchand2;
insert into marchand2 (nomMarchand,ageMarchand) select nomMarchand,ageMarchand from marchand where idMarchand < 6;
-- inner join multiple
--delete from marchand where marchand.prenom="anfr";
--delete select

select * from marchand;
select * from produit;
select * from marchand2;



delete from produit where (
	select p.idProduit from produit as p inner join marchand as m
		on (p.idMarchand = m.ID) where m.age = "10" and p.idProduit > 106) > 100;

select p.idProduit from produit as p inner join marchand as m
	on (p.idMarchand = m.idMarchand) where m.age = "10" and p.idProduit > 106;


	
select m.prenom,m.AGE,m.id,p.nomProduit 
	from produit as p inner join marchand as m 
	on (p.idMarchand = m.ID);

select m.prenom,m.AGE,m.id,p.nomProduit
	from produit as p left outer join marchand as m 
	on (p.idMarchand = m.ID);
	
insert into produit (idMarchand) select id from marchand where prenom="thde";

update marchand set nomMarchand = "toto" where idMarchand = 4;

update produit set nomProduit = "premier" where idProduit = 31;

SELECT p.nomProduit,p.qteProduit,SUM(p.qteProduit),m.nomMarchand  
	FROM produit as p inner join marchand as m on 
	p.idMarchand = m.idMarchand 
	GROUP BY m.nomMarchand;

SELECT p.nomProduit,p.qteProduit,SUM(p.qteProduit),m.nomMarchand  
	FROM produit as p inner join marchand as m on 
	p.idMarchand = m.idMarchand 
	GROUP BY p.nomProduit;

SELECT p.nomProduit,p.qteProduit,COUNT(m.ageMarchand) 
	FROM produit as p inner join marchand as m 
	on (p.idMarchand = m.idMarchand)
	GROUP BY p.idMarchand;


delete from produit;

CREATE USER 'tous'@'%' IDENTIFIED BY '***';

GRANT USAGE ON * . * TO 'tous'@'%' IDENTIFIED BY '***' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;

GRANT ALL PRIVILEGES ON `marchandphva` . * TO 'tous'@'%';

	
	