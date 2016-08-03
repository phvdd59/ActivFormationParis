package com.formation.emma.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.core.SubstringMatcher;

public class ExoEmma {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; //+33612121212 
	private String mdp; // majuscule minuscule chiffre

	public ExoEmma() {
		this.nom = nom;
		this.mdp = mdp;
		this.adresseMail = adresseMail;
		this.tel = tel;
		this.dateEmbauche = dateEmbauche;

	}

	public ExoEmma(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {
		this.dateEmbauche = dateEmbauche;

	}

	public void setCoordonnee(String adresseMail, String tel) {
		this.adresseMail = adresseMail;
		
		String numero = "+33";
		if(numero.length()>10 ){
			this.tel = null;
		}else{
		for (int j = 1; j < tel.length(); j++) {
			numero = numero + tel.substring(j, j + 1);
		}}
		this.tel = numero;
	}

	/**
	 * permutation deux en deux du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		String mot = "";
		String mdpCache2 = mdpCache.replaceAll("\\W", "");
			
		if (mdpCache2 != mdpCache || mdpCache==null || mdpCache=="") {
			mdp = null;
		} else {
			if (mdpCache.length() % 2 == 0) {
				for (int i = 0; i < mdpCache.length(); i++) {
					String lettre1 = mdpCache.substring(i + 1, i + 2);
					String lettre2 = mdpCache.substring(i, i + 1);
					mot = mot + lettre1 + lettre2;
					i++;
				}
			} else {
				for (int i = 0; i < mdpCache.length() - 1; i++) {
					String lettre1 = mdpCache.substring(i + 1, i + 2);
					String lettre2 = mdpCache.substring(i, i + 1);
					mot = mot + lettre1 + lettre2;
					i++;
				}
				mot = mot + mdpCache.substring(mdpCache.length() - 1);
			}
			mdp=mot;
		}	
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
