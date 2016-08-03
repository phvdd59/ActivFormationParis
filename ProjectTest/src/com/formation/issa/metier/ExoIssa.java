package com.formation.issa.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoIssa {
	private String nom;
	private String adresseMail;
	private String dateEmbauche;// JJ-MM-YYYY
	private String tel;// +336612345678
	private String mdp;// Majsucule minuscule chiffre

	public ExoIssa() {
		nom = "Dupont";
	}

	public ExoIssa(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {
		SimpleDateFormat fd = new SimpleDateFormat("DD-MM-YYYY");
		String s = fd.format(new Date());

		try {
			Date d = fd.parse("24-04-2016");
			System.out.println(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void setCoordonnee(String adressMail, String tel) {
		
		if (tel.length() == 12 && tel.startsWith("+3")) {
			this.tel = tel;
		}
		else{
			this.tel=null;
		}
		if (adressMail.contains("@") && adressMail.contains("fr") || adressMail.contains("com")) {
			this.adresseMail = adressMail;
		}
		else{
			this.adresseMail=null;
		}

	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		if(mdpCache==null){
			this.setMdpCache(null);
		}
		mdpCache = "Acdef9";
		char[] charArray = mdpCache.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		char[] charArray1 = new char[charArray.length];

		for (int j = 0; j < charArray.length; j++) {

			if (j == 0 || j % 2 == 0) {
				charArray1[j + 1] = charArray[j];
			} else {
				charArray1[j - 1] = charArray[j];
			}

		}
		System.out.println(charArray1);
		String mdp = new String(charArray1);
		System.out.println(mdp);
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
