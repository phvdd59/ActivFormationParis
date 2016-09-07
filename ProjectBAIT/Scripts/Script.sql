/*USE marchandissa;

drop table produitissa;


/*drop table marchand;
drop table marchand2;*/
/*create table marchandissa2 (
	idMarchand bigint primary key auto_increment,
	nomMarchand varchar(30),
	ageMarchand varchar(3)
);

create table produitissa2 (
idProduit bigint primary key auto_increment ,
idMarchand bigint,
nomProduit varchar(255),
qteProduit int 
);*/

/*insert into marchandissa2 values 
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
;*/

/*INSERT INTO produitissa2 (idMarchand, nomProduit, qteProduit)VALUES (1,'prdDEambr','0');*/

/*update produitissa2 set idMarchand = "1" where idProduit = "1";
update produitissa2 set idMarchand = "2" where idProduit = "2";
update produitissa2 set idMarchand = "3" where idProduit = "3";
update produitissa2 set idMarchand = "4" where idProduit = "4";
update produitissa2 set idMarchand = "5" where idProduit = "5";
update produitissa2 set idMarchand = "6" where idProduit = "6";
update produitissa2 set idMarchand = "7" where idProduit = "7";
update produitissa2 set idMarchand = "8" where idProduit = "8";
update produitissa2 set idMarchand = "9" where idProduit = "9";
update produitissa2 set idMarchand = "10" where idProduit = "10";
update produitissa2 set idMarchand = "11" where idProduit = "11";
update produitissa2 set idMarchand = "12" where idProduit = "12";*/

/*select * from marchandissa2;
select * from produitissa2;
-- sum groupe
-- alias
-- int�grit�s
ALTER TABLE produitissa2 ADD CONSTRAINT idMFK 
	FOREIGN KEY(idMarchand) REFERENCES marchandissa2 (idMarchand);*/

/*delete from produitissa2 where idMarchand = 1;
delete from marchandissa2 where idMarchand = 1;	

insert into marchandissa2 values (null,"ambr","0");

/*update marchandissa2 set idMarchand = 1 where idMarchand = 25;

insert into produitissa2 values(1,1,"Prd Ambr","0");*/
/*update produitissa2 set qteProduit = 100 where idProduit = 1;
update marchandissa2 set ageMarchand =  20 where idMarchand = 1;
update marchandissa2 set idMarchand = 30 where idMarchand = 1;

select * from produitissa2 as p inner join marchandissa2 as m 
	on p.idMarchand = m.idMarchand where m.idMarchand = 2
	order by p.idProduit asc limit 5 offset 1;




drop table marchand2;*/
/*create table marchandissa3 (
	idMarchand bigint primary key auto_increment,
	nomMarchand varchar(30),
	ageMarchand varchar(3)
);

ALTER TABLE marchandissa3 ADD CONSTRAINT idPFK FOREIGN KEY(idMarchand) REFERENCES marchandissa2(idMarchand);


delete from marchandissa3;
insert into marchandissa3 (nomMarchand,ageMarchand) select nomMarchand,ageMarchand from marchandissa2 where idMarchand < 6;
-- inner join multiple
--delete from marchand where marchand.prenom="anfr";
--delete select*/

select * from marchandissa2;
select * from produitissa2;
select * from marchandissa3;



delete from produitissa2 where (
	select p.idProduitissa2 from produitissa2 as p inner join marchandissa2 as m
		on (p.idMarchand = m.ID) where m.age = "10" and p.idProduit > 106) > 100;

select p.idProduitissa2 from produitissa2 as p inner join marchandissa2 as m
	on (p.idMarchandissa2 = m.idMarchandissa2) where m.age = "10" and p.idProduit > 106;


	
select m.prenom,m.AGE,m.id,p.nomProduit 
	from produitissa2 as p inner join marchandissa2 as m 
	on (p.idMarchand = m.ID);

select m.prenom,m.AGE,m.id,p.nomProduit
	from produitissa2 as p left outer join marchandissa2 as m 
	on (p.idMarchand = m.ID);
	
insert into produitissa2 (idMarchand) select id from marchandissa2 where PRENOM="thde";

update marchandissa2 set nomMarchand = "toto" where idMarchand = 4;

update produitissa2 set nomProduit = "premier" where idProduit = 31;

SELECT p.nomProduit,p.qteProduit,SUM(p.qteProduit),m.nomMarchand  
	FROM produitissa2 as p inner join marchandissa2 as m on 
	p.idMarchand = m.idMarchand 
	GROUP BY m.nomMarchand;

SELECT p.nomProduit,p.qteProduit,SUM(p.qteProduit),m.nomMarchand  
	FROM produitissa2 as p inner join marchandissa2 as m on 
	p.idMarchand = m.idMarchand 
	GROUP BY p.nomProduit;

SELECT p.nomProduit,p.qteProduit,COUNT(m.ageMarchand) 
	FROM produitissa2 as p inner join marchandissa2 as m 
	on (p.idMarchand = m.idMarchand)
	GROUP BY p.idMarchand;


	
	
	
	
	
delete from produitissa2;	
	
	