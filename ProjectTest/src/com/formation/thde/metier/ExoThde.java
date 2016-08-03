package com.formation.thde.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoThde {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; //jj-mm-yyyy
	private String tel; //+33612345678
	private String mdp; //majuscule minuscule chiffre

	public ExoThde() {
	}

	public ExoThde(String nom) {
		this.nom = nom;
		this.adresseMail = "eleve@wanadoo.fr";
		this.dateEmbauche = "01-01-1999";
		this.tel = "+33000000000";
		this.mdp = "1234";
	}

	public void setDate(Date date) {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		this.dateEmbauche = fd.format(date);
	}

	public void setCoordonnees(String adresseMail, String tel) {

		if (adresseMail.contains("@") && adresseMail.contains("."))
			this.adresseMail = adresseMail;
		else {
			this.adresseMail = "pasbon@gmail.com";
		}

		char charTemp = 'a';
		if (tel.length() != 12 || tel.charAt(0) != '+') {
			this.tel = "+336000000";
		} else {
			for (int i = 1; i < tel.length(); i++) {
				charTemp = tel.charAt(i);
				if (Character.isDigit(charTemp) == false) {
					this.tel = "+336000000";
					break;
				} else {
					this.tel = tel;
				}
			}
		}
	}

	/*
	 * permutation deux en deux du mot de passe
	 * cache => clair
	 * abcdef => badcfe
	 */
	public void setMdpCache(String mdp) {
		boolean lowercpt = false;
		boolean uppercpt = false;
		boolean numbercpt = false;
		char[] mdpChar = new char[mdp.length()];
		mdpChar = mdp.toCharArray();
		for (int i = 1; i < mdpChar.length; i += 2) {
			if (Character.isLowerCase(mdpChar[i]) || Character.isLowerCase(mdpChar[i - 1])) {
				lowercpt = true;
			}
			if (Character.isUpperCase(mdpChar[i]) || Character.isUpperCase(mdpChar[i - 1])) {
				uppercpt = true;
			}
			if (Character.isDigit(mdpChar[i]) || Character.isDigit(mdpChar[i - 1])) {
				numbercpt = true;
			}
			if (i % 2 == 1 && i != 0) {
				char temp = mdpChar[i];
				mdpChar[i] = mdpChar[i - 1];
				mdpChar[i - 1] = temp;
			}
		}
		if (lowercpt == true && uppercpt == true && numbercpt == true) {
			String newMdp = "";
			for (int j = 0; j < mdpChar.length; j++) {
				newMdp = newMdp.concat(Character.toString(mdpChar[j]));
			}
			this.mdp = newMdp;
		} else {
			this.mdp = "Abc0";
		}
	}

	public String getNom() {
		return this.nom;
	}

	public void setTel(int numero) {
		tel = Integer.toString(numero);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return this.adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
