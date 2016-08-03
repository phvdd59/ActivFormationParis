package com.formation.thde.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoThde {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; //jj-mm-yyyy
	private String tel; //+33612345678
	private String mdp; //majuscule minuscule chiffre

	public ExoThde() {
	}

	public ExoThde(String nom) {
		this.nom = nom;
		this.adresseMail = "eleve@wanadoo.fr";
		this.dateEmbauche = "01-01-1999";
		this.tel = "+33600000000";
		this.mdp = "1234";
	}

	public void setDate(Date date) {
		//mettre sous la forme jj-mm-yyyy
		SimpleDateFormat fd = new SimpleDateFormat("ddMMyyyy");
		this.dateEmbauche = fd.format(date);
	}

	public void setCoordonnees(String adresseMail, String tel) {
		this.adresseMail = adresseMail;
		this.tel = tel;
	}

	/*
	 * permutation deux en deux du mot de passe
	 * cache => clair
	 * abcdef => badcfe
	 */
	public void setMdpCache(String mdp) {
		//		String mdp2 = mdp;
		//		for (int i = 0; i < mdp.length(); i += 2) {
		//
		//			mdp2.charAt(i) = mdp.charAt(i + 1);
		//		}
		//		this.mdp = mdp2;
	}

	public String getNom() {
		return nom;
	}

	public void setTel(int numero) {
		tel = Integer.toString(numero);
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
