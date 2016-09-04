package com.formation.thcr.main;

import java.sql.Date;
import java.sql.Timestamp;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.dao.DAOPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.Sexe;

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
		String stringDate = "06-03-2010";
		ConversionPersonne conv = new ConversionPersonne();
		personne.setDateCreation(conv.conversionDate(stringDate));
		java.util.Date date = new java.util.Date();
		personne.setDateModification(new Timestamp(date.getTime()));
		personne.setDateNaissance(conv.conversionDate(stringDate));
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
		personne.setSexe(new Sexe(Sexe.MASCULIN));
		personne.setSituation("situation test");
		personne.setTelFixe("01");
		personne.setTelPort("06");
		personne.setTicketResto(false);
		personne.setVille("Ville test");
		personne.setVisiteMedicale(conv.conversionDate(stringDate));
		personne.setVoiture(false);
		
		//dao.create(personne);

		String sql = "INSERT INTO jmst.personne"//
				+ "(LP_NOM, LP_PRENOM, LP_SEXE, LP_IDENTIFIANT, LP_MDP, LP_EMAIL, LP_ADRESSE, LP_CP, LP_VILLE, LP_TELFIXE, "
				+ "LP_TELPORT, LP_FAX, LP_DATENAISSANCE, LP_LIEUNAISSANCE, LP_NUMSECU, LP_NATIONALITE, "
				+ "LP_SITUATION, LP_FONCTION, LP_CADRE, LP_COEFF, LP_SALAIRE, LP_VISITEMEDICALE, "
				+ "LP_MONTANTTRANSPORT, LP_VOITURE, LP_NBCV, LP_NBKM, LP_MUTUELLE, LP_TICKETRESTO, LP_ADMIN, "
				+ "LP_DATECREATION, LP_DATEMODIFICATION, LP_BLOQUE, LP_RAISONBLOCAGE)" + "VALUES('" + personne.getNom()
				+ "','" + personne.getPrenom() + "','" + personne.getSexe().getSexe() + "','" + personne.getIdentifiant()
				+ "'," + "'" + personne.getMdp() + "','" + personne.getEmail() + "','" + personne.getAdresse() + "',"
				+ "'" + personne.getCp() + "','" + personne.getVille() + "','" + personne.getTelFixe() + "'," + "'"
				+ personne.getTelPort() + "','" + personne.getFax() + "','" + personne.getDateNaissance() + "'," + "'"
				+ personne.getLieuNaissance() + "','" + personne.getNumSecu() + "','" + personne.getNationalite() + "',"
				+ "'" + personne.getSituation() + "','" + personne.getFonction() + "','" + personne.isCadre() + "',"
				+ "'" + personne.getCoeff() + "','" + personne.getSalaire() + "','" + personne.getVisiteMedicale()
				+ "'," + "'" + personne.getMontantTransport() + "','" + personne.isVoiture() + "','"
				+ personne.getNbCV() + "'," + "'" + personne.getNbKm() + "','" + personne.isMutuelle() + "','"
				+ personne.isTicketResto() + "'," + "'" + personne.isAdmin() + "','" + personne.getDateCreation()
				+ "','" + personne.getDateModification() + "'," + "'" + personne.isBloque() + "','"
				+ personne.getRaisonBlocage() + "');";
		
		personne.setIdentifiant("thcr");
		dao.read(personne);
		personne.setMdp("password");
		personne.setDateModification(new Timestamp(date.getTime()));
		personne.setDateCreation(conv.conversionDate(stringDate));
		
		String sql2 = "UPDATE jmst.personne"//
				+ " SET LP_NOM='" + personne.getNom() //
				+ "', LP_PRENOM='" + personne.getPrenom()//
				+ "', LP_SEXE='" + personne.getSexe().getSexe()//
				+ "', LP_IDENTIFIANT='" + personne.getIdentifiant()//
				+ "', LP_MDP='" + personne.getMdp()//
				+ "', LP_EMAIL='" + personne.getEmail()//
				+ "', LP_ADRESSE='" + personne.getAdresse()//
				+ "', LP_CP='" + personne.getCp()//
				+ "', LP_VILLE='" + personne.getVille()//
				+ "', LP_TELFIXE='" + personne.getTelFixe()//
				+ "', LP_TELPORT='" + personne.getTelPort()//
				+ "', LP_FAX='" + personne.getFax()//
				+ "', LP_DATENAISSANCE='" + personne.getDateNaissance()//
				+ "', LP_LIEUNAISSANCE='" + personne.getLieuNaissance()//
				+ "', LP_NUMSECU='" + personne.getNumSecu()//
				+ "', LP_NATIONALITE='" + personne.getNationalite()//
				+ "', LP_SITUATION='" + personne.getSituation()//
				+ "', LP_FONCTION='" + personne.getFonction()//
				+ "', LP_CADRE='" + personne.isCadre()//
				+ "', LP_COEFF='" + personne.getCoeff()//
				+ "', LP_SALAIRE='" + personne.getSalaire()//
				+ "', LP_VISITEMEDICALE='" + personne.getVisiteMedicale()//
				+ "', LP_MONTANTTRANSPORT='" + personne.getMontantTransport()//
				+ "', LP_VOITURE='" + personne.isVoiture()//
				// |LP_NBCV |LP_NBKM |LP_MUTUELLE |LP_TICKETRESTO |LP_ADMIN
				// |LP_DATECREATION
				// |LP_DATEMODIFICATION |LP_BLOQUE |LP_RAISONBLOCAGE |
				+ "', LP_NBCV='" + personne.getNbCV()//
				+ "', LP_MUTUELLE='" + personne.isMutuelle()//
				+ "', LP_TICKETRESTO='" + personne.isTicketResto()//
				+ "', LP_ADMIN='" + personne.isAdmin()//
				+ "', LP_DATECREATION='" + personne.getDateCreation()//Issues with datecreation
				+ "', LP_DATEMODIFICATION='" + personne.getDateModification()// 
				+ "', LP_BLOQUE='" + personne.isBloque()//
				+ "', LP_RAISONBLOCAGE='" + personne.getRaisonBlocage()//
				+ "' WHERE LP_IDENTIFIANT=" + "'" + personne.getIdentifiant() + "';";//
		
		dao.update(personne);
		System.out.println(sql2);
		System.out.println(sql);

	}

}
