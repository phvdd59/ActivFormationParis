create table ajee.DocPerso (
	idDoc BIGINT(19) primary key auto_increment,
	idPersonne BIGINT(19),
	nomDocUtil VARCHAR(50),
	type VARCHAR(10),
	nomDocFile VARCHAR(50),
	time BIGINT (19),
	commentaire VARCHAR(100)
);