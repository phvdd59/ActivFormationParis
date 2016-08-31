use marchand;
alter table produit add constraint idMFK foreign key
(IDMARCHAND, references ID);