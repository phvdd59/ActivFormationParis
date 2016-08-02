package com.formation.ambr.metier;

import java.util.Date;

public class ExoAmbr {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; // +33612345678
	private String mdp; // majuscule minuscule chiffre

	public ExoAmbr() {

	}

	public ExoAmbr(String nom) {
		// TODO
	}

	public void setDate(Date date) {

	}

	public void setCoordonnee(String adresseMail, String tel) {

	}

	/**
	 * permutation deux en deux du mot de passe: ABcdEf ---> BAdcfE
	 * 
	 * @param mdpCache
	 */

	public void setMdp(String mdpCache) {

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
