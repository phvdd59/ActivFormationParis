/* alors là je sais pas trop ce qu'il se passe */
alter table produit add constraint idMFK
foreign key (idMarchand) references marchand (idMarchand);
/* ca va lier marchand et produit. Produit doit avoir une idMarchand */

delete marchand where idMarchand = 2;
/* marche pas si le marchand a des produits */

update marchand set idMarchand = 40 where idMarchand=2;
/* là encore, marche pas si le marchand a des produits */

select * from produit as p inner join marchand as m on p.idMarchand = m.idMarchand;
/* chopper tous les produit qui ont la même ID que le marchand ?*/
/* outer join aurait chopper tous les marchands sans produits */

select * from produit as p inner join marchand as m on p.idMarchand = m.idMarchand where m.idMarchand=2
order by p.qteProduit asc limit 5 offset 1; 
/* dadada on organise */

select p.nomProduit, count (m.agreMarchand)from produit as p inner join marchand as m on (p.idMarchand = m.idMarchand) group by p.idMarchand;