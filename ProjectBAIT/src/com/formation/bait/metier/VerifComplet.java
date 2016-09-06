package com.formation.bait.metier;

import javax.servlet.http.HttpSession;

public class VerifComplet {
	
	public boolean validTotal(HttpSession session){
		Personne personne = (Personne) session.getAttribute("Personne");
		int somme=0;
		boolean ok=false;
		if (personne.getAdresse()!=""&& personne.getAdresse()!= null) {
			somme+=1;
		}
		if (personne.getCoeff() !="" && personne.getCoeff()!=null) {
			somme+=1;
		}
		if (personne.getDateNaissance() !=""&& personne.getDateNaissance()!=null) {
			somme+=1;
		}
		if (personne.getEmail() !="" && personne.getEmail()!=null) {
			somme+=1;
		}
		if (personne.getFonction() !="" && personne.getFonction()!= null) {
			somme+=1;
		}
		if (personne.getLieuNaissance() !="" && personne.getLieuNaissance()!= null) {
			somme+=1;
		}
		if (personne.getNationalite() !="" && personne.getNationalite()!=null) {
			somme+=1;
		}
		if (personne.getNumSecu() !="" && personne.getNumSecu()!=null) {
			somme+=1;
		}

		if (personne.getPosition() !="" && personne.getPosition()!=null) {
			somme+=1;
		}
		if (personne.getSalaire() !="" && personne.getSalaire()!=null) {
			somme+=1;
		}
		if (personne.getSituation() !="" && personne.getSituation()!=null) {
			somme+=1;
		}
		if ((personne.getTelFixe() !="" || personne.getTelPort()!="")&&personne.getTelFixe() !=null && personne.getTelPort()!=null) {
			somme+=1;
		}
		if (personne.getVille() !="" && personne.getVille()!=null) {
			somme+=1;
		}
		
		if (somme==13) {
			ok=true;
		}
		
		return ok;
		
	}

}
