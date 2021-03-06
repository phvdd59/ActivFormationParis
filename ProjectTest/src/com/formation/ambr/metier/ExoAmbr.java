package com.formation.ambr.metier;

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
		this.nom = nom;
	}

	public ExoAmbr(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {

	}

	public void setCoordonnee(String adresseMail, String tel) {
		boolean A = adresseMail.contains("@") && adresseMail.contains("."); // returns true if adresseMail contains @ and .
		//boolean B = adresseMail.contains("*@*.*");
		//boolean C = adresseMail.matches("\\b@\\B") && adresseMail.matches("\\b.\\B"); // matches the expression @ on a non-word boundary (\\B). Si c'�tait \\b, il trouve que si le mot est entour� d'espaces. On peut changer des deux c�t�s du mot
		if (A == true) {
			adresseMail = adresseMail;
		} else {
			adresseMail = null;

		}
	}

	public void adrMail(String adresseMail) {

	}

	public void numTel(String tel) {

	}

	/**
	 * permutation deux en deux du mot de passe:
	 * 
	 * cache ---> clair / BAdcfE ---> ABcdEf
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		// protection pour caract�res sp�ciaux et espaces
		String mdpCache2 = mdpCache.replaceAll("\\W", "");
		if (mdpCache2 != mdpCache || mdpCache == "") {
			mdp = null;
		} else {

			// 1.transformer le mdpCache en tableau
			//char[] tab = mdpCache.toCharArray(); // autre m�thode
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
			String mdp2 = new String();
			for (String s : lst) {
				mdp2 += s;
			}
			mdp = mdp2;
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

	public void setTel(String tel) { // objectif de la m�thode: on lui donne un num�ro, elle doit le renvoyer en string
		this.tel = tel;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
