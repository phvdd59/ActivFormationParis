package com.formation.issa.metier;

import java.util.Date;

public class ExoIssa {
	private String nom;
	private String adresseMail;
	private String dateEmbauche;// JJ-MM-YYYY
	private String tel;// +336612345678
	private String mdp;// Majsucule minuscule chiffre
	
	public ExoIssa(){
		
	}

	public ExoIssa(String nom) {
		//TODO
	}

	public void setDate(Date date) {

	}

	public void setCoordonnee(String adressMail, String tel) {

	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {

	}

	public String getNom() {
		return nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public String getTel() {
		return tel;
	}

	public String getMdp() {
		return mdp;
	}

}
