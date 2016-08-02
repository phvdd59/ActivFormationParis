package com.formation.made.metier;

import java.util.Date;

public class ExoMade {
	private String nom;
	private String adresseMail;
	private String dateEmbauche;     //jj--mm--yyyy
	private String tel; // +33612345678
	private String mdp; //majuscule minuscule chiffre
	
	public ExoMade(){
	}
	
	public ExoMade(String nom){
		this.nom=nom;
	}
	
	public void setDate(Date date){
		
	}
	
	public void setCoordonnes(String adresseMail, String tel){
		
	}
	
	/**
	 * permutation deux en deux des caractères du mot de passe
	 * @param mdpCache
	 */
	
public void setMdpCache(String mdpCache){
		
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
