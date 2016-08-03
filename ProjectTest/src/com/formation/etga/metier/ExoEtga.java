package com.formation.etga.metier;

import java.text.SimpleDateFormat;
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
		//		Date date = new Date();
		SimpleDateFormat dateEmbauche = new SimpleDateFormat("dd-MM-yyyy");
		this.dateEmbauche = dateEmbauche.format(date);
	}

	public void setCoordonnee(String adresseMail, String tel) {
		if ((adresseMail.contains("@")) && adresseMail.contains("@@") == false && (adresseMail.endsWith(".com")) || (adresseMail.endsWith(".fr"))) {
			this.adresseMail = adresseMail;
		} else {
			this.adresseMail = "pasbon@wanadoo.fr";
		}

		if ((tel.startsWith("+336")) && (tel.length() == 12)) {
			this.tel = tel;
		} else {
			this.tel = "+33600000000";
		}
	}

	/**
	 * permutation 2 en 2 du mdp mdp cache ---> clair BAdcFE --> ABcdEF
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		boolean valide = false;
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean digit = false;
		char[] mdpList = mdpCache.toCharArray();
		for (int i = 0; i < mdpList.length; i++) {
			if (Character.isLowerCase(mdpList[i])) {
				lowerCase = true;
			} else if (Character.isUpperCase(mdpList[i])) {
				upperCase = true;
			} else if (Character.isDigit(mdpList[i])) {
				digit = true;
			}
		}
		if (lowerCase == true && upperCase == true && digit == true) {
			valide = true;
		}
		if (valide == true) {
			for (int i = 0; i < mdpList.length - 1; i += 2) {
				char a = mdpList[i];
				char b = mdpList[i + 1];
				mdpList[i] = b;
				mdpList[i + 1] = a;
			}
			mdpCache = "";
			for (int j = 0; j < mdpList.length; j++) {
				mdpCache = mdpCache.concat(Character.toString(mdpList[j]));
			}
			this.mdp = mdpCache;
		} else {
			this.mdp = "Abc0";
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
