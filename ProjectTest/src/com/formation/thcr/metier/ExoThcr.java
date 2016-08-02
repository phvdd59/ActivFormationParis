package com.formation.thcr.metier;

import java.util.Date;

public class ExoThcr {

	private String	nom;
	private String	adresseMail;
	private String	dateEmbauche;	//jj-mm-xxx
	private String	tel;			// +33607302229
	private String	mdp;			//Majuscule minuscule chiffre

	public ExoThcr() {
		
	}

	public ExoThcr(String nom) {
		//TODO
	}
	
	public ExoThcr(Date date){
		
	}
	
	public void setCoordonnee(String adresseMail, String tel){
		
	}
	/**
	 * permutation deux en deux du mot de passe
	 * @param MdpCache
	 */
	public void setMdpCache(String MdpCache){
		
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
