package com.formation.beba.metier;

import java.util.Date;

public class ExoBeba {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; // +33712345678
	private String mdp; // majuscule minuscule chiffre

	public ExoBeba() {

	}

	public ExoBeba(String nom) {
		// TODO
		this.nom = nom;
	}

	public void setDate(Date date) {
	}

	public void setCoordonnee(String addressMail, String tel) {
		// todo
	}

	/**
	 * permutation de 2 en 2 du mot de passe
	 * 
	 * @param mdpCache
	 **/
	public void setMdpCache(String mdpCache) {

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
