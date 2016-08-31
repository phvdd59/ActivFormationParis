select tetga.PRENOM,produit.nomProduit 
from dbetga.tetga 
inner join dbetga.produit 
ON tetga.ID = produit.idtetga
where tetga.PRENOM = "etga"
;