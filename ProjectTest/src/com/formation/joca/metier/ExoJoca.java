package com.formation.joca.metier;

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

	public void setDate(Date date) {
		this.dateEmbauche = date.toString();
	}

	public void setCoordonnee(String adresseMail, String tel) {
		this.tel = tel;
		this.adresseMail = adresseMail;
	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		char[] tabMdp = new char[mdpCache.length()];
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
