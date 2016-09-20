drop database hikae;
create database hikae;
use hikae;
select * from materiaux;
select * from elmt;
select * from meuble;


select * from materiaux as m inner join elmt as e 
	on m.elmt_id_elmt = e.id_elmt where e.id_elmt = 2
	order by m.id_materiaux asc; 
	
SELECT e.id_elmt,e.nom,m.id_materiaux,m.nom 
		FROM materiaux as m
                INNER JOIN elmt as e
			ON (m.elmt_id_elmt = e.id_elmt);

	
SELECT b.id_meuble,b.refAbrege,b.nomCommercial,e.id_elmt,e.nom,m.id_materiaux,m.nom 
		FROM materiaux as m
                INNER JOIN elmt as e ON (m.elmt_id_elmt = e.id_elmt) 
                INNER JOIN meuble ON (e.meuble_id_meuble = b.id_meuble);

                
// https://docs.jboss.org/hibernate/orm/3.3/reference/fr-FR/html/querycriteria.html