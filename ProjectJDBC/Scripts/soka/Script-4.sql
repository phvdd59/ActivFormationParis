select marchandsoka.marchand.nom, marchandsoka.marchand.id, marchandsoka.produit.nomProduit, marchandsoka.produit.idMarchand
from marchandsoka.marchand
inner join marchandsoka.produit
on (marchandsoka.marchand.id = marchandsoka.produit.idMarchand); 