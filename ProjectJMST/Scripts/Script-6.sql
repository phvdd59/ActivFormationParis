/*ALTER TABLE listpersonne.personne
ADD ADRESSE VARCHAR(255);*/
UPDATE listpersonne.personne
SET ADRESSE = 'adresse de Johann'
/*SET NOM = 'Kadri'*/
WHERE LOGIN='joca';