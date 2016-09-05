use marchandsoka;
alter table produit add constraint idmfk foreign key(idMarchand) references marchand(idMarchand);
