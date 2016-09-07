package com.formation.beans;

import java.sql.Timestamp;

public class ConversionPersoToPersonne {

	public Personne conv(Perso p) {
		Personne pers=new Personne();
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
		pers.setDateNaissance(date);
		pers.setLieuNaissance(p.getLieuNaissance());
		pers.setNumSecu(p.getNumSecu());
		pers.setNationalite(p.getNationalite());
		pers.setSituation(p.getSituation());
		pers.setFonction(p.getFonction());
		pers.setPosition(p.getPos());
		pers.setCadre(p.isCadre());
		pers.setCoeff(p.getCoeff());
		pers.setSalaire(p.getSalaire());
		java.sql.Date date2 = new java.sql.Date(p.getDateNaissance().getTime());
		pers.setVisiteMedicale(date2);
		pers.setMontantTransport(p.getMontantTransport());
		pers.setVoiture(p.isVoiture());
		pers.setNbCV(p.getNbCV());
		pers.setNbKm(p.getNbKm());
		pers.setMutuelle(p.isMutuelle());
		pers.setTicketResto(p.isTicketResto());
		pers.setAdmin(p.isAdmin());
		java.sql.Date date3 = new java.sql.Date(p.getDateNaissance().getTime());
		pers.setDateCreation(date3);
		pers.setDateModification(new Timestamp(p.getDateModification().getTime())); //
		pers.setBloque(p.isBloque());
		pers.setRaisonBlocage(p.getRaisonBlocage());
		
		return pers;
	}

}
