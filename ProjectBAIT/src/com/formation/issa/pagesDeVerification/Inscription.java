package com.formation.issa.pagesDeVerification;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public final class Inscription {

	private static String CHAMP_ID = "identifiant";
	private static String CHAMP_MOTDEPASSE = "mdp1";
	private static String CHAMP_CONFIRMATION = "mdp2";
	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Candidat inscrireCandidat(HttpServletRequest request) {
		String identifiant = getValeurChamp(request, CHAMP_ID);
		String motDePasse = getValeurChamp(request, CHAMP_MOTDEPASSE);
		String verifMotDePasse = getValeurChamp(request, CHAMP_CONFIRMATION);
		Candidat candidat = new Candidat();
		try {
			validationMotsdePasse(motDePasse, verifMotDePasse);
		} catch (Exception e) {
			setErreur(CHAMP_MOTDEPASSE, e.getMessage());
			setErreur(CHAMP_CONFIRMATION, null);
		}
		try {
			validationIdentifiant(identifiant);
		} catch (Exception e) {
			setErreur(CHAMP_ID, e.getMessage());
		}

		return candidat;

	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);

	}

	public boolean validationMotsdePasse(String motDePasse, String verifMotDePasse) {
		boolean retour=false;
		if (motDePasse != null && verifMotDePasse != null && motDePasse.length()>6 && motDePasse.length()<20){
			if (motDePasse.matches("^[A-Za-z0-9]+[A-Za-z]*$")&& motDePasse.equals(verifMotDePasse)){
				retour=true;
			} 
		}
		return retour; 

	}

	public boolean validationIdentifiant(String identifiant){
		boolean retour=false;
		if (identifiant != null && identifiant.length()>4 && identifiant.length()<30) {
			if (identifiant.matches("^[0-9]*[A-Za-z]+[0-9]*[a-z]*$")) {
				retour=true;;
			} 
		}
		return retour; 
	}

	private static String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		}
		return valeur.trim();
	}

}
