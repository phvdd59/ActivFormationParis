package com.formation.beans;

import java.sql.Timestamp;

import com.formation.thcr.conversion.ConversionPersonne;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.Sexe;

public class ConversionPersoToPersonne {

	public Personne conv(Perso p) {
		ConversionPersonne conv = new ConversionPersonne();
		Personne pers=new Personne();
		pers.setIdPersonne(p.getIdPersonne());
		pers.setNom(p.getNom());
		pers.setPrenom(p.getPrenom());
		if (p.getSexe()==Perso.FEMININ){
			pers.setSexe(new Sexe(Sexe.FEMININ));
		} else {
			pers.setSexe(new Sexe(Sexe.MASCULIN));
		}
		pers.setIdentifiant(p.getIdentifiant());
		pers.setMdp(p.getMdp());
		pers.setEmail(p.getEmail());
		pers.setAdresse(p.getAdresse());
		pers.setCp(p.getCp());
		pers.setVille(p.getVille());
		pers.setTelFixe(p.getTelFixe());
		pers.setTelPort(p.getTelPort());
		pers.setFax(p.getFax());
		java.sql.Date date = new java.sql.Date(p.getDateNaissance().getTime());
		
		try {
			pers.setDateNaissance(date);
		} catch (Exception e) {
			pers.setDateNaissance(conv.conversionDate("01-01-1970"));
		}
		pers.setLieuNaissance(p.getLieuNaissance());
		pers.setNumSecu(p.getNumSecu());
		pers.setNationalite(p.getNationalite());
		pers.setSituation(p.getSituation());
		pers.setFonction(p.getFonction());
		pers.setPosition(p.getPos());
		pers.setCadre(p.isCadre());
		pers.setCoeff(p.getCoeff());
		pers.setSalaire(p.getSalaire());
		java.sql.Date date2 = new java.sql.Date(p.getVisiteMedicale().getTime());
		try {
			pers.setVisiteMedicale(date2);
		} catch (Exception e) {
			pers.setVisiteMedicale(conv.conversionDate("01-01-1970"));
		}
		pers.setMontantTransport(p.getMontantTransport());
		pers.setVoiture(p.isVoiture());
		pers.setNbCV(p.getNbCV());
		pers.setNbKm(p.getNbKm());
		pers.setMutuelle(p.isMutuelle());
		pers.setTicketResto(p.isTicketResto());
		pers.setAdmin(p.isAdmin());
		java.sql.Date date3 = new java.sql.Date(p.getDateCreation().getTime());
		try {
			pers.setDateCreation(date3);
		} catch (Exception e) {
			pers.setDateCreation(conv.conversionDate("01-01-1970"));
		}
		try {
			pers.setDateModification(new Timestamp(p.getDateModification().getTime()));
		} catch (Exception e) {
			pers.setDateModification(conv.conversionTimestamp("01-01-1970"));
		} //
		pers.setBloque(p.isBloque());
		pers.setRaisonBlocage(p.getRaisonBlocage());
		
		return pers;
	}

}
