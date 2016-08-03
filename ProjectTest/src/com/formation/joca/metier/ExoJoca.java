package com.formation.joca.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		this.nom = nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		if (!(adresseMail.indexOf('@') == -1) && !(adresseMail.indexOf('.') == -1)
				&& adresseMail.indexOf('@') < adresseMail.indexOf('.')) {
			this.adresseMail = adresseMail;
		} else {
			System.out.println("erreur adresse mail");
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
		CharSequence chiffre = "0123456789";
		if (tel.toCharArray()[0] == '0' && tel.length() == 10 && tel.matches("[0-9]+")) {
			String temp = "";
			temp = "+33" + tel.substring(1);
			this.tel = temp;
		} else if (tel.toCharArray()[0] == '+' && tel.length() == 12 && tel.substring(1).matches("[0-9]+")) {
			this.tel = tel;
		} else {
			System.out.println("erreur numero telephone");
		}

	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	}

	public ExoJoca(String nom) {
		this.nom = nom;
	}
}
