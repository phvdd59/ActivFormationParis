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

	}

	public void setCoordonnee(String adresseMail, String tel) {

	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {

	}
	
	public ExoJoca() {

	}

}
