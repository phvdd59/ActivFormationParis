package com.formation.joca.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ExoJoca {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-mm-yyyy
	private String tel; // +33612345678
	private String mdp; // majuscule minuscule chiffre

	public String getNom() {

		return nom;

	}

	public void setNom(String nom) {
		if (nom.matches("[a-zA-Z\\s]+")) {
			this.nom = nom;
		} else {
			this.nom = "nom non valide";
		}
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		if (!(adresseMail.indexOf('@') == -1) && !(adresseMail.indexOf('.') == -1)
				&& adresseMail.indexOf('@') < adresseMail.lastIndexOf('.')
				&& adresseMail.lastIndexOf("@") == adresseMail.indexOf("@")) {
			this.adresseMail = adresseMail;
		} else {
			this.adresseMail = "adresse mail non valide";
		}
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		if (tel.toCharArray()[0] == '0' && tel.length() == 10 && tel.matches("[0-9]+")) {
			String temp = "";
			temp = "+33" + tel.substring(1);
			this.tel = temp;
		} else if (tel.toCharArray()[0] == '+' && tel.length() == 12 && tel.substring(0).matches("[0-9+]+")) {
			this.tel = tel;
		} else {
			this.tel = "numero de telephone non valide";
		}

	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		if (mdp.matches("[0-9a-zA-Z]+") && Pattern.compile("[0-9]").matcher(mdp).find()
				&& Pattern.compile("[a-z]").matcher(mdp).find() && Pattern.compile("[A-Z]").matcher(mdp).find()) {
			this.mdp = mdp;
		} else {
			this.mdp = "mot de passe non valide";
		}

	}

	public void setDate(Date date) {
		SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
		this.dateEmbauche = fd.format(date);
	}

	public void setCoordonnee(String adresseMail, String tel) {

		this.setTel(tel);
		this.setAdresseMail(adresseMail);
	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		char[] tabMdp = new char[mdpCache.length()];
		tabMdp = mdpCache.toCharArray();
		for (int i = 0; i < tabMdp.length; i += 2) {
			if (i != tabMdp.length - 1) {
				char temp = tabMdp[i];
				tabMdp[i] = tabMdp[i + 1];
				tabMdp[i + 1] = temp;
			}
		}
		String mdpfinal = "";
		for (int i = 0; i < tabMdp.length; i++) {
			mdpfinal += tabMdp[i];
		}
		this.mdp = mdpfinal;
	}

	public ExoJoca() {

		this.nom = "cassagne";
		this.adresseMail = "jojolatruite@gmail.com";
		this.dateEmbauche = "26-09-2016"; // jj-mm-yyyy
		this.tel = "0654879625"; // +33612345678
		this.mdp = "lemotdepasse";

	}

	public ExoJoca(String nom) {
		this.nom = nom;
	}
}
