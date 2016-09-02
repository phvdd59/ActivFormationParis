package com.formation.issa.pages;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.formation.issa.beans.Candidat;

public class Coordonnees {
	private static String CHAMP_ADRESSE = "adresse";
	private static String CHAMP_CP = "cp";
	private static String CHAMP_VILLE = "ville";
	private static String CHAMP_TELFIXE = "telFixe";
	private static String CHAMP_TELPORT = "telPort";
	private static String CHAMP_EMAIL = "email";
	private static String CHAMP_FAX = "fax";

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
		String CP = getValeurChamp(request, CHAMP_CP);
		String ville = getValeurChamp(request, CHAMP_VILLE);
		String telFixe = getValeurChamp(request, CHAMP_TELFIXE);
		String telPort = getValeurChamp(request, CHAMP_TELPORT);
		String fax = getValeurChamp(request, CHAMP_FAX);
		String email = getValeurChamp(request, CHAMP_EMAIL);
		Candidat candidat = new Candidat();
		try {
			validationAdresse(adresse);
		} catch (Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}
		try {
			validationCodePostal(CP);
		} catch (Exception e) {
			setErreur(CHAMP_CP, e.getMessage());
		}
		try {
			validationVille(ville);
		} catch (Exception e) {
			setErreur(CHAMP_VILLE, e.getMessage());
		}
		try {
			validationTelFixe(telFixe);
		} catch (Exception e) {
			setErreur(CHAMP_TELFIXE, e.getMessage());
		}
		try {
			validationTelPort(telPort);
		} catch (Exception e) {
			setErreur(CHAMP_TELPORT, e.getMessage());
		}
		try {
			validationFax(fax);
		} catch (Exception e) {
			setErreur(CHAMP_FAX, e.getMessage());
		}

		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		return candidat;

	}

	public boolean validationTelFixe(String telFixe) {
		boolean retour = false;
		if (telFixe != null) {
			if (telFixe.matches("^[\\+][0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$") 
					|| (telFixe.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))
					|| (telFixe.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))) {
				retour = true;

			}
		}
		return retour;

	}

	public boolean validationAdresse(String adresse){
		boolean retour=false;
		if (adresse != null) {
			if (adresse.matches("^[a-zA-ZÀ-ÿ0-9//-' ]*[a-zA-Z]+$")) {
				retour=true;
			}
		}
		return retour; 

	}

	public boolean validationCodePostal(String codePostal){
		boolean retour=false;
		if (codePostal != null) {
			if (codePostal.matches(".*\\d+.*") && codePostal.length() != 5) {
				retour=true;
			}
		} 
		return retour;

	}

	public boolean validationVille(String ville) {
		boolean retour=false;
		if (ville != null) {
			if (ville.matches("^[a-zA-ZÀ-ÿ\\-' ]*[a-zA-Z]+$")) {
				retour=true;
			}
		}
		return retour;

	}

	public boolean validationTelPort(String telPort) {
		boolean retour = false;
		if (telPort != null) {
			if (telPort.matches("^[\\+][0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$") || (telPort.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))
					|| (telPort.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))) {
				retour = true;
			} 
		}
		return retour;

	}

	public boolean validationFax(String fax) {
		boolean retour = false;
		if (fax != null) {
			if (fax.matches("^[\\+][0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$") || (fax.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))
					|| (fax.matches("^[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{1}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}[\\-./ ]?[0-9]{2}$"))) {
				retour = true;
			}
		}
		return retour;

	}

	public boolean validationEmail(String email) {
		boolean retour=false;
		if (email != null) {
			if (email.matches("^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$")) {
				retour=true;
			}
		}
		return retour;

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
