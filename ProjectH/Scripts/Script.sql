drop database hikae;
create database hikae;
use hikae;
select * from materiaux;
select * from elmt;
select * from meuble;


select * from materiaux as m inner join elmt as e 
	on m.elmt_id_elmt = e.id_elmt where e.id_elmt = 2
	order by m.id_materiaux asc; 
	
SELECT b.id_meuble,b.refAbrege,b.nomCommercial,e.id_elmt,e.nom,m.id_materiaux,m.nom 
		FROM materiaux as m
                INNER JOIN 
                (elmt e INNER JOIN 
                (meuble ON (e.meuble_id_meuble = b.id_meuble))
			ON (m.elmt_id_elmt = e.id_elmt));
