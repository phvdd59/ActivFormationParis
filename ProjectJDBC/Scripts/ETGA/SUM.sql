select nomProduit, qteProduit, SUM(qteProduit), tetga.prenom
from dbetga.produit inner join dbetga.tetga 
on ID = idTetga group by nomProduit;