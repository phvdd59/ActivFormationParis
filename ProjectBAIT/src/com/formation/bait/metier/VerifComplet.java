package com.formation.bait.metier;

import javax.servlet.http.HttpSession;

public class VerifComplet {
	
	public boolean validTotal(HttpSession session){
		Personne personne = (Personne) session.getAttribute("Personne");
		int somme=0;
		boolean ok=false;
		if (personne.getAdresse()!="") {
			somme+=1;
		}
		if (personne.getCoeff() !="") {
			somme+=1;
		}
		if (personne.getDateNaissance() !="") {
			somme+=1;
		}
		if (personne.getEmail() !="") {
			somme+=1;
		}
		if (personne.getFonction() !="") {
			somme+=1;
		}
		if (personne.getLieuNaissance() !="") {
			somme+=1;
		}
		if (personne.getNationalite() !="") {
			somme+=1;
		}
		if (personne.getNumSecu() !="") {
			somme+=1;
		}

		if (personne.getPosition() !="") {
			somme+=1;
		}
		if (personne.getSalaire() !="") {
			somme+=1;
		}
		if (personne.getSituation() !="") {
			somme+=1;
		}
		if (personne.getTelFixe() !="" || personne.getTelPort()!="") {
			somme+=1;
		}
		if (personne.getVille() !="") {
			somme+=1;
		}
		
		if (somme==13) {
			ok=true;
		}
		
		return ok;
		
	}

}
