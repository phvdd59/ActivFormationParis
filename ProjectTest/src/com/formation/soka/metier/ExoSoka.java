package com.formation.soka.metier;

import java.util.Date;

public class ExoSoka {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; //+336xxxxxxxx
	private String mdp; // majuscule minuscule chiffre

	public ExoSoka() {

	}

	public ExoSoka(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {

	}

	public void setCoordonnee(String adresseMail, String tel) {
		if (adresseMail.contains("@")) {
			// il faut un .frou .com ou autre??! 
			this.adresseMail = adresseMail;
		}
		if (tel.length() == 11) {
			// dire aussi qu'il faut qu'il commence par +
			this.tel = tel;
		}

	}

	/**
	 * permutation deux en deux du mdp abcdeF --> badcFe
	 * 
	 * @param mdpCache
	 */

	public void setMdp(String mdpCache) {

		//Doit donc contenir au moins une minuscule, une maj et un chiffre
		char[] tabChar = mdpCache.toCharArray();
		char[] tabChar2 = new char[tabChar.length];
		String s = "";
		if (tabChar.length % 2 == 0) {
			for (int i = 0; i < tabChar.length; i++) {
				if (i % 2 == 0) {
					tabChar2[i] = tabChar[i + 1];
				} else {
					tabChar2[i] = tabChar[i - 1];
				}
				s = s.concat(Character.toString(tabChar2[i]));
			}
		} else {
			
			for (int i = 0; i < tabChar2.length - 1; i++) {
				tabChar2[tabChar.length - 1] = tabChar[tabChar.length - 1];
				if (i % 2 == 0) {
					tabChar2[i] = tabChar[i + 1];
				} else {
					tabChar2[i] = tabChar[i - 1];
				}

				s = s.concat(Character.toString(tabChar2[i]));
			}

		}
		this.mdp = s;
	}

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
		this.adresseMail = adresseMail;
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

}
