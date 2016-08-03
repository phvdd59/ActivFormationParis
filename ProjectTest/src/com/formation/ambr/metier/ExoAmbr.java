package com.formation.ambr.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ExoAmbr {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; // +33612345678
	private String mdp; // majuscule minuscule chiffre

	public ExoAmbr() {

	}

	public ExoAmbr(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {
		
		
		
	}

	public void setCoordonnee(String adresseMail, String tel) {

	}

	/**
	 * permutation deux en deux du mot de passe:
	 * 
	 * cache ---> clair / BAdcfE ---> ABcdEf
	 * 
	 * @param mdpCache
	 */

	public String setMdp(String mdpCache) {
		// protection pour caractères spéciaux et espaces
		String mdpCache2 = mdpCache.replaceAll("\\W", "");
		if (mdpCache2 != mdpCache) {
			return null;
		}

		// 1.transformer le mdpCache en tableau
		//char[] tab = mdpCache.toCharArray(); // autre méthode
		String[] tab = mdpCache.split("");

		// 2.ranger les valeurs du tableau dans une liste
		ArrayList<String> lst = new ArrayList<String>();
		for (int i = 0; i < tab.length; i++) {
			lst.add(tab[i]);
		}

		// 3.permuter
		for (int i = 0; i < lst.size() - 1; i += 2) {
			int j = i + 1;
			Collections.swap(lst, i, j);
		}

		//4. reformer le mot de passe
		String mdp = new String();
		for (String s : lst) {
			mdp += s;
		}
		return mdp;

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

	public void setTel(String tel) { // objectif de la méthode: on lui donne un numéro, elle doit le renvoyer en string
		this.tel = tel;
	}

	public String getMdp() {
		return mdp;
	}

}
