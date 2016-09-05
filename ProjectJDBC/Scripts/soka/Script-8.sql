CREATE TABLE jmst.listePersonne(ID bigint not null primary key auto_increment, 
					NOM varchar(30) not null,
					PRENOM varchar(30) not null, 
					IDENTIFIANT varchar(30) not null, 
					MAIL varchar(30) not null, 
					ADRESSE varchar(255) not null); 