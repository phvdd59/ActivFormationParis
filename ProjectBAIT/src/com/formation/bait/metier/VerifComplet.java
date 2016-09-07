package com.formation.bait.metier;

import javax.servlet.http.HttpSession;

public class VerifComplet {
	
	public boolean validTotal(HttpSession session){
		Personne personne = (Personne) session.getAttribute("Personne");
		int somme=0;
		boolean ok=false;
		if (!personne.getAdresse().equals("") && personne.getAdresse()!= null) {
			somme+=1;
		}
//		if (!personne.getCoeff().equals("") && personne.getCoeff()!=null) {
//			somme+=1;
//		}
		if (personne.getDateNaissance().equals("")&& personne.getDateNaissance()!=null) {
			somme+=1;
		}
		if (personne.getEmail().equals("") && personne.getEmail()!=null) {
			somme+=1;
		}
		if (personne.getFonction().equals("") && personne.getFonction()!= null) {
			somme+=1;
		}
//		if (personne.getLieuNaissance().equals("") && personne.getLieuNaissance()!= null) {
//			somme+=1;
//		}
//		if (personne.getNationalite().equals("") && personne.getNationalite()!=null) {
//			somme+=1;
//		}
//		if (personne.getNumSecu().equals("") && personne.getNumSecu()!=null) {
//			somme+=1;
//		}

//		if (personne.getPosition().equals("") && personne.getPosition()!=null) {
//			somme+=1;
//		}
//		if (personne.getSalaire().equals("") && personne.getSalaire()!=null) {
//			somme+=1;
//		}
//		if (personne.getSituation().equals("") && personne.getSituation()!=null) {
//			somme+=1;
//		}
		if ((personne.getTelFixe().equals("") || personne.getTelPort().equals(""))&&personne.getTelFixe() !=null && personne.getTelPort()!=null) {
			somme+=1;
		}
		if (personne.getVille().equals("") && personne.getVille()!=null) {
			somme+=1;
		}
		if (personne.getcP().equals("") && personne.getcP()!=null) {
			somme+=1;
		}
		
		if (somme>=1) {
			ok=true;
		}
		
		return ok;
		
	}

}
