package com.formation.issa.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public class EtatCivil {
	private static String CHAMP_NOM = "nom";
	private static String CHAMP_PRENOM = "prenom";
	private static String CHAMP_DATE = "date";
	private static String CHAMP_LIEU = "lieu";
	private static String CHAMP_NATIONALITE = "nati";
	private static String CHAMP_NUMEROSECU = "secu";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Candidat definirEtatCivil(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);
		String dateDeNaissance = getValeurChamp(request, CHAMP_DATE);
		String lieuNaissance = getValeurChamp(request, CHAMP_LIEU);
		String nationalite = getValeurChamp(request, CHAMP_NATIONALITE);
		String numSecu = getValeurChamp(request, CHAMP_NUMEROSECU);
		Candidat candidat = new Candidat();

		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		try {
			validationPrenom(prenom);
		} catch (Exception e) {
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		try {
			validationDateDeNaissance(dateDeNaissance);
		} catch (Exception e) {
			setErreur(CHAMP_DATE, e.getMessage());
		}
		try {
			validationLieu(lieuNaissance);
		} catch (Exception e) {
			setErreur(CHAMP_LIEU, e.getMessage());
		}
		try {
			validationNationalite(nationalite);

		} catch (Exception e) {
			setErreur(CHAMP_NATIONALITE, e.getMessage());
		}
		try {
			validationNumeroDeSecuriteSociale(numSecu);
		} catch (Exception e) {
			setErreur(CHAMP_NUMEROSECU, e.getMessage());
		}
		return candidat;
	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);

	}

	private void validationNom(String nom) throws Exception {
		if (nom != null) {
			if (!nom.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir un nom correct.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre nom.");
		}

	}

	private void validationPrenom(String prenom) throws Exception {
		if (prenom != null) {
			if (!prenom.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir un prénom correct.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre prénom.");
		}

	}

	private void validationDateDeNaissance(String dateDeNaissance) throws Exception, ParseException {
		final DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		final Date date = df.parse(dateDeNaissance);
		if (dateDeNaissance != null) {
			if (dateDeNaissance.length() != 10) {
				throw new Exception("Merci de bien vouloir saisir une date de naissance selon le format fixé.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre date de naissance.");
		}

	}

	private void validationLieu(String lieu) throws Exception {
		if (lieu != null) {
			if (!lieu.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir un lieu de naissance correct.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre lieu de naissance.");
		}

	}

	private void validationNationalite(String nationalite) throws Exception {
		if (nationalite != null) {
			if (!nationalite.matches("^[a-zA-ZÀ-ÿ\\- ]*[a-zA-Z]+$")) {
				throw new Exception("Merci de bien vouloir saisir une nationalité correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre nationalité.");
		}

	}

	private void validationNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) throws Exception {
		if (numeroDeSecuriteSociale != null) {
			if (!numeroDeSecuriteSociale.matches("^[1234][\\ ]?[0-9]{2}[\\ ]?[0-9]{2}[\\ ]?[0-9]{2}[\\ ]?[0-9]{3}[\\ ]?[0-9]{3}[\\ ]?[0-9]{2}$")) {
				throw new Exception("Merci de bien vouloir saisir un numéro de sécurité sociale correcte.");
			}
		} else {
			throw new Exception("Merci de bien vouloir saisir votre numéro de sécurité sociale");
		}

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
