package com.formation.soka.metier;

import java.util.Date;

public class ExoSoka {
	
	private String nom; 
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; //+336xxxxxxxx
	private String mdp; // majuscule minuscule chiffre
	
	public ExoSoka(){
		
	}
	
	public ExoSoka(String nom){
		this.nom = nom;
	}
	
	
	public void setDate(Date date){
		
	}
	
	public void setCoordonnee(String adresseMail, String tel){
		
	}
	/**
	 * permutation deux en deux du mdp 
	 * @param mdpCache
	 */
	public void setMdp(String mdpCache){
		
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
