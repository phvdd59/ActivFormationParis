package com.formation.anfr.metier;

import java.util.Date;

public class ExoAnfr {
	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-aaaa
	private String tel; //+33612345678
	private String mdp; // majuscule minuscule chiffre
	
	public ExoAnfr(){
		
	}
	
	public ExoAnfr(String nom){
			//TODO
	}

	public String getNom() {
		return nom;
	}

	public void setDateEmbauche(Date date) {
	
	}
	public void setCoordonee(String adresseMail, String tel){

	}
	public void setMdpCache(String motDePasse){
		/** permutation 2 en deux du mdp;
		 * ABcdEf  --> BAdcfE
		 * **/
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

	public void setNom(String nom) {
		this.nom = nom;
	}
}
