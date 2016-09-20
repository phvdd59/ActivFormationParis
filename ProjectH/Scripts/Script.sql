drop database hikae;
create database hikae;
use hikae;
select * from materiaux;
select * from elmt;

`hikae`.`materiaux`, CONSTRAINT `FK6xu1paxwll1sytj193wwpr4qd` FOREIGN KEY (`id_materiaux`) REFERENCES `elmt` (`id_elmt`))