package com.formation.issa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VerificationsInscriptionPage2 {
	String nom;
	String prenom;
	String dateDeNaissance;
	String lieu;
	String nationalite;
	String numeroDeSecuriteSociale;

	public boolean fonctionNom(String nom) {
		boolean retour = false;
		char[] tab = nom.toCharArray();
		for (int i = 0; i < tab.length; i++) {
			if (Character.isLetter(tab[i])) {
				retour = true;
			} else {
				retour = false;
				break;
			}
		}
		return retour;

	}

	public boolean fonctionPrenom(String prenom) {
		boolean retour = false;
		char[] tab = prenom.toCharArray();
		for (int i = 0; i < tab.length; i++) {
			if (Character.isLetter(tab[i])) {
				retour = true;
			} else {
				retour = false;
				break;
			}
		}

		return retour;

	}

	public boolean fonctionDateDeNaissance(String dateDeNaissance) {
		boolean retour = false;

		final DateFormat df = new SimpleDateFormat("DD/MM/YYYY");
		try {
			final Date date = df.parse(dateDeNaissance);
			if (dateDeNaissance.length() == 10) {
				System.out.println(dateDeNaissance);
				retour = true;
			} else {
				System.out.println("Date refusée");
				retour = false;
			}

		} catch (ParseException e) {

			System.out.println("Date refusée");
			retour = false;
		}

		return retour;

	}

	public boolean fonctionLieu(String lieu) {
		boolean retour = false;
		if (lieu.matches("[\\w]+") && (!lieu.matches(".*\\d+.*"))) {
			retour = true;
		}
		return retour;

	}

	public boolean fonctionNationalite(String nationalite) {
		boolean retour = false;
		if (nationalite.matches("[\\w]+") && (!nationalite.matches(".*\\d+.*"))) {
			retour = true;
		}
		return retour;

	}

	public boolean fonctionNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) {
		boolean retour = false;
		if (numeroDeSecuriteSociale.matches(".*\\d+.*") && numeroDeSecuriteSociale.length() == 15) {
			retour = true;

		}
		return retour;

	}

}
