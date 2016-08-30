package com.formation.issa.pages;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public class Coordonnees {
	private static final String CHAMP_ADRESSE = "adresse";
	private static final String CHAMP_CP = "cp";
	private static final String CHAMP_VILLE = "ville";
	private static final String CHAMP_TEL = "tel";
	private static final String CHAMP_EMAIL = "email";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Candidat definirCoordonnees(HttpServletRequest request) {
		String adresse = getValeurChamp(request, CHAMP_ADRESSE);
		String codePostal = getValeurChamp(request, CHAMP_CP);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String tel = getValeurChamp(request, CHAMP_TEL);
		String email = getValeurChamp(request, CHAMP_EMAIL);
		Candidat candidat = new Candidat();
		try {
			validationAdresse(adresse);
		} catch (Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}
		try {
			validationCodePostal(codePostal);
		} catch (Exception e) {
			setErreur(CHAMP_CP, e.getMessage());
		}
		try {
			validationVille(ville);
		} catch (Exception e) {
			setErreur(CHAMP_VILLE, e.getMessage());
		}
		try {
			validationTel(tel);
		} catch (Exception e) {
			setErreur(CHAMP_TEL, e.getMessage());
		}
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		return candidat;

	}

	private void validationAdresse(String adresse) throws Exception {
		if (adresse != null) {
			if (!adresse.matches("^[a-zA-ZÀ-ÿ0-9//-'s]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir une adresse correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre adresse postale.");
		}

	}

	private void validationCodePostal(String codePostal) throws Exception {
		if (codePostal != null) {
			if (!codePostal.matches(".*\\d+.*") && codePostal.length() != 5) {
				throw new Exception("Merci de bien vouloir saisir un code postal selon le format fixé.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre code postal.");
		}

	}

	private void validationVille(String ville) throws Exception {
		if (ville != null) {
			if (!ville.matches("^[a-zA-ZÀ-ÿ\\-'s]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir une ville correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir le nom de votre ville.");
		}

	}

	private void validationTel(String tel) throws Exception {
		if (tel != null) {
			if (!tel.matches("^(\\+[0-9]{2}([0-9]{9})([\\-.s/]*)|([0-9]{10}[\\-.s/]*|([0-9]{4}([0-9]{9})[\\-.s/]*)")) {
				throw new Exception("Merci de bien vouloir saisir un numéro de téléphone correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre numéro de téléphone.");
		}

	}

	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")) {
				throw new Exception("Merci de bien vouloir une adresse email correcte.");
			}
		}else{
			throw new Exception("Merci de bien vouloir saisir votre adresse email.");
		}

	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);

	}

	private static String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}

}
