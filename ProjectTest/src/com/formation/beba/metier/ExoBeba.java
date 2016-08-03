package com.formation.beba.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoBeba {

	private String nom;
	private String addresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; // +33712345678
	private String mdp; // majuscule minuscule chiffre

	public ExoBeba() {

	}

	public ExoBeba(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {

		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");

		String s = fd.format(date);
		this.dateEmbauche = s;
		if (s.length() != 10) {
			dateEmbauche = null;
		}
	}

	public void setCoordonnee(String addressMail, String tel) {

		this.addresseMail = addressMail;
		boolean correct = true;
		char[] data = addressMail.toCharArray();
		for (int i = 0; i < data.length; i++) {

			if ((data[i] < 'a' || data[1] > 'z') && (data[i] < '0' || data[1] > '9')) {

				if (data[i] != '_' && data[i] != '@' && data[i] != '.') {
					correct = false;
				}
			}
		}
		boolean secondCorrect = false;
		int nbAt = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] == ('@')) {
				secondCorrect = true;
				nbAt++;
			}
			if (nbAt > 1) {
				secondCorrect = false;
			}
		}
		boolean troisiemeCorrect = false;
		if ((data[data.length - 3] == '.' && data[data.length - 2] == 'f' && data[data.length - 1] == 'r') || (data[data.length - 4] == '.' && data[data.length - 3] == 'c' && data[data.length - 2] == 'o' && data[data.length - 1] == 'm')) {
			troisiemeCorrect = true;
		}
		if (troisiemeCorrect && secondCorrect && correct) {
			this.addresseMail = addressMail;
		} else {
			this.addresseMail = null;
		}
		if (tel.length() == 12) {
			this.tel = tel;
		} else {
			this.tel = null;
		}
		if (tel.charAt(0) != '+') {
			this.tel = null;
		}
		for (int i = 1; i < tel.length(); i++) {
			if (tel.charAt(i) < '0' || tel.charAt(i) > '9') {
				this.tel = null;
			}
		}
	}

	/**
	 * permutation de 2 en 2 du mot de passe
	 * 
	 * @param mdpCache
	 **/
	public void setMdpCache(String mdpCache) {
		char[] data = mdpCache.toCharArray();
		for (int i = 0; i < data.length; i += 2) {
			char tampon = data[i];
			data[i] = data[i + 1];
			data[i + 1] = tampon;
		}
		mdpCache = Character.toString(data[0]);
		for (int i = 1; i < data.length; i++) {
			mdpCache = mdpCache.concat(Character.toString(data[i]));
		}
		this.mdp = mdpCache;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return addresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.addresseMail = adresseMail;
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

		this.tel = tel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
