package com.formation.thcr.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoThcr {

	private String	nom;
	private String	adresseMail;
	private String	dateEmbauche;	// jj-mm-xxx
	private String	tel;			// +33607302229
	private String	mdp;			// Majuscule minuscule chiffre

	public ExoThcr() {

	}

	public ExoThcr(String nom) {
		
		if(nom.matches("\\p{IsLatin}")){
			this.nom = nom;
		}else{
			this.nom = null;
		}
		
		
	}

	public ExoThcr(Date date) {
		if (date != null) {
			SimpleDateFormat fd = new SimpleDateFormat("dd-mm-yyyy");
			fd.setLenient(false);
			dateEmbauche = fd.format(date);
		}

	}

	public void setCoordonnee(String adresseMail, String tel) {
		if (adresseMail != null && tel != null) {
			if (adresseMail.matches("[a-zA-Z_0-9]{1,32}@[a-zA-Z]{1,32}\\.[a-zA-Z]{1,32}")) {
				this.adresseMail = adresseMail.toLowerCase();
				//Mise en forme sous minuscule
			} else {

			}
			if (tel.matches("\\+33[0-9]{9}")) {
				this.tel = tel;
			} else {

			}
		}
	}

	/**
	 * permutation deux en deux les lettres du mot de passe ex abcDeF89 ->
	 * baDcFe98
	 * 
	 * @param MdpCache
	 */
	public void setMdpCache(String MdpCache) {
		if (MdpCache != null) {
			char[] c = MdpCache.toCharArray();
			boolean lc = false;
			boolean uc = false;
			boolean nu = false;
			boolean o = false;
			boolean b = false;
			String s = "";
			for (int i = 0; i < c.length; i++) {
				if (Character.isUpperCase(c[i])) {
					uc = true;
					break;
				}
			}
			for (int i = 0; i < c.length; i++) {
				if (Character.isLowerCase(c[i])) {
					lc = true;
					break;
				}
			}
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
					nu = true;
					break;
				}
			}
			for (int i = 0; i < c.length; i++) {
				if (!MdpCache.matches("[^a-zA-Z0-9]")) {
					o = true;
					break;
				}
			}
			if (nu && lc && uc && o)
				b = true;
			if (c.length % 2 == 0 && b) {
				for (int i = 0; i < c.length - 1; i = i + 2) {
					char tmp = c[i];
					c[i] = c[i + 1];
					c[i + 1] = tmp;
					s += c[i];
					s += c[i + 1];
				}
			} else if (b) {
				for (int i = 0; i < c.length - 2; i = i + 2) {
					char tmp = c[i];
					c[i] = c[i + 1];
					c[i + 1] = tmp;
					s += c[i];
					s += c[i + 1];
				}
				s += c[c.length - 1];
			}

			this.setMdp(s);
		}
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

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
