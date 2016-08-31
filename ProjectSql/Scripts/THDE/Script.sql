/* alors là je sais pas trop ce qu'il se passe */
alter table produit add constraint idMFK
foreign key (idMarchand) references marchand (idMarchand);
/* ca va lier marchand et produit. Produit doit avoir une idMarchand */

delete marchand where idMarchand = 2;
/* marche pas si le marchand a des produits */

update marchand set idMarchand = 40 where idMarchand=2;
/* là encore, marche pas si le marchand a des produits */