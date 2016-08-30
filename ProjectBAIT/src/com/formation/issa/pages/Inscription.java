package com.formation.issa.pages;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public final class Inscription {

	private static final String CHAMP_ID = "identifiant";
	private static final String CHAMP_MOTDEPASSE = "mdp1";
	private static final String CHAMP_CONFIRMATION = "mdp2";
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

	private void validationMotsdePasse(String motDePasse, String verifMotDePasse) throws Exception {
		if (motDePasse != null && verifMotDePasse != null) {
			if (!motDePasse.matches("[\\w]") && (!motDePasse.matches(".*\\d+.*"))) {
				throw new Exception("Le mot de passe doit contenir au moins une lettre et un chiffre.");

			} else if (!motDePasse.equals(verifMotDePasse)) {
				throw new Exception("Le mot de passe et sa confirmation doivent être identiques.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir et confirmer un mot de passe.");
		}

	}

	private void validationIdentifiant(String identifiant) throws Exception {
		if (identifiant != null) {
			if (!identifiant.matches("[\\w]") && (!identifiant.matches(".*\\d+.*"))) {
				throw new Exception("L'identifiant doit contenir au moins une lettre et un chiffre.");
			} else if (identifiant.length() < 3) {
				throw new Exception("L'identifiant doit contenir au moins trois caractères.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir un identifiant.");
		}

	}

	private static String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		}
		return valeur.trim();
	}

}
