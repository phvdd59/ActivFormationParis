drop database hikae;
create database hikae;
use hikae;
select * from materiaux;
select * from elmt;


ALTER TABLE produit ADD CONSTRAINT idMFK 
	FOREIGN KEY(idMarchand) REFERENCES marchand(idMarchand);

ALTER TABLE materiaux ADD CONSTRAINT idMFK 
	FOREIGN KEY(elmt_id_elmt) REFERENCES elmt(id_elmt);

materiaux`, CONSTRAINT `FK6xu1paxwll1sytj193wwpr4qd` FOREIGN KEY (`id_materiaux`) REFERENCES `elmt` (`id_elmt`));