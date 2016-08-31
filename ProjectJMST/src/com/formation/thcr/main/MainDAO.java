package com.formation.thcr.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.SEXE;

public class MainDAO {

	public static void main(String[] args) {
		DAOPersonne dao = new DAOPersonne();
		Personne personne = new Personne();
		personne.setAdmin(false);
		personne.setAdresse("testadresse");
		personne.setBloque(false);
		personne.setCadre(false);
		personne.setCoeff("1");
		personne.setCp("cp");
		String StringDateCreation = "2010-03-06";
		ConversionPersonne conv = new ConversionPersonne();
		personne.setDateCreation(conv.conversionDate(StringDateCreation));
		java.util.Date date = new java.util.Date();
		personne.setDateModification(new Timestamp(date.getTime()));
		personne.setDateNaissance(conv.conversionDate(StringDateCreation));
		personne.setEmail("test.test@test.fr");
		personne.setFax("");
		personne.setFonction("fonction");
		personne.setIdentifiant("test");
		personne.setLieuNaissance("lieu de naissance");
		personne.setMdp("password");
		personne.setMontantTransport("70");
		personne.setMutuelle(false);
		personne.setNationalite("fr");
		personne.setNbCV(20);
		personne.setNbKm("200");
		personne.setNom("Nomtest");
		personne.setNumSecu("190");
		personne.setPosition("position de test");
		personne.setPrenom("Prenomtest");
		personne.setRaisonBlocage("pas de raison");
		personne.setSalaire("32000");
		personne.setSexe(SEXE.MASCULIN);
		personne.setSituation("situation test");
		personne.setTelFixe("01");
		personne.setTelPort("06");
		personne.setTicketResto(false);
		personne.setVille("Ville test");
		personne.setVisiteMedicale(conv.conversionDate(StringDateCreation));
		personne.setVoiture(false);
		
		dao.create(personne);


	}

}
