select tetga.PRENOM,produit.nomProduit from dbetga.tetga,dbetga.produit where tetga.age = produit.idtetga group by tetga.PRENOM,produit.nomProduit;