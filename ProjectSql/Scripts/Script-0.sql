create table test.meuble (
	id INT(10) not null	,
	nom VARCHAR(255) not null,
	hauteur DECIMAL(6,2) default 0, 
	largeur DECIMAL(6,2) default 0,
	longueur DECIMAL(6,2) default 0
);
