package com.formation.etga.metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExoEtga {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; // +33601020304
	private String mdp; // majuscule minuscule chiffre

	public ExoEtga() {
	}

	public ExoEtga(String nom) {
		this.nom = nom;
		this.adresseMail = "etga@gmail.com";
		this.dateEmbauche = "08-03-1990";
		this.tel = "+33634674768";
		this.mdp = "mdpetga8";
	}

	public void setTel(int numero) {
		tel = Integer.toString(numero);
	}

	public void setDate(Date date) {
		SimpleDateFormat dateEmbauche = new SimpleDateFormat("dd-MM-yyyy");
		//		String date = dateFormat.format(new Date());
		//		date = dateFormat.parse(dateEmbauche);
		//		return dateEmbauche;
	}

	public void setCoordonnee(String adresseMail, String tel) {
//		if ((adresseMail.contains("@")) && ((adresseMail.contains(".com")) || (adresseMail.contains(".fr")))) {
			this.adresseMail = adresseMail;
//		}
//		if ((tel.substring(0, 3) == "+336") && (tel.length() == 12)) {
			this.tel = tel;
//		}
	}

	/**
	 * permutation 2 en 2 du mdp mdp cache ---> clair BAdcFE --> ABcdEF
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		char[] mdpList = mdpCache.toCharArray();
		for (int i = 0; i < mdpList.length -1; i+=2) {
			char a = mdpList[i];
			char b = mdpList[i+1];
			mdpList[i] =a;
			mdpList [i+1] = b;
			
		}
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
