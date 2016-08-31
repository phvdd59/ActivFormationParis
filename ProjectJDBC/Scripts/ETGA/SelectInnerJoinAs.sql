select * from dbetga.produit as p inner join dbetga.tetga as m on p.idTetga = m.ID where m.PRENOM = "etga" order by p.qteProduit asc /*ou desc*/; /*tous les produits avec ou sans marchand */
--select * from dbetga.produit as p left outer join dbetga.tetga as m on p.idTetga = m.ID; /*tous les produits avec ou sans marchand */
--select * from dbetga.produit as p right outer join dbetga.tetga as m on p.idTetga = m.ID; /*tous les marchand avec ou sans produit */

--offset 1 /*on saute la premiere valeur affichée*/