/*DROP DATABASE listpersonne;
DROP DATABASE listdocument;*/
CREATE DATABASE listpersonne;
create table listpersonne.personne(
LP_IDPERSONNE BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
LP_NOM VARCHAR(255) NOT NULL,
LP_SEXE VARCHAR(255) NOT NULL,
LP_IDENTIFIANT VARCHAR(255) NOT NULL,
LP_MDP VARCHAR(255) NOT NULL,
LP_EMAIL VARCHAR(255) NOT NULL,
LP_ADRESSE VARCHAR (255) NOT NULL,
LP_CP VARCHAR(255) NOT NULL,
LP_VILLE VARCHAR(255) NOT NULL,
LP_TELFIXE VARCHAR(255) NOT NULL,
LP_TELPORT VARCHAR(255) NOT NULL,
LP_FAX VARCHAR(255),
LP_DATENAISSANCE DATE NOT NULL,
LP_LIEUNAISSANCE VARCHAR(255) NOT NULL,
LP_NUMSECU VARCHAR(255) NOT NULL,
LP_NATIONALITE VARCHAR(255) NOT NULL,
LP_SITUATION VARCHAR(255) NOT NULL,
LP_FONCTION VARCHAR(255) NOT NULL,
LP_CADRE VARCHAR(255) NOT NULL,
LP_COEFF VARCHAR(255) NOT NULL,
LP_SALAIRE VARCHAR(255) NOT NULL,
LP_VISITEMEDICALE DATE NOT NULL,
LP_MONTANTTRANSPORT VARCHAR(255) NOT NULL,
LP_VOITURE VARCHAR(255) NOT NULL,
LP_NBCV INTEGER(6) NOT NULL,
LP_NBKM VARCHAR(255),
LP_MUTUELLE VARCHAR(255) NOT NULL,
LP_TICKETRESTO VARCHAR(255) NOT NULL,
LP_ADMIN VARCHAR(255) NOT NULL,
LP_DATECREATION DATE NOT NULL,
LP_DATEMODIFICATION TIMESTAMP NOT NULL,
LP_BLOQUE VARCHAR(255) NOT NULL,
LP_RAISONBLOCAGE TEXT NOT NULL
);

CREATE TABLE listpersonne.listdocument(
LD_IDPERSONNE BIGINT NOT NULL,
LD_IDDOCUMENT BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
LD_NOMDOCUTIL VARCHAR(255) NOT NULL,
LD_NOMDOCFILE VARCHAR(255) NOT NULL,
LD_TIME	BIGINT(255) NOT NULL,
LD_COMMENTAIRE TEXT(32) NOT NULL, 
LD_DOCUMENT BLOB NOT NULL 
);




