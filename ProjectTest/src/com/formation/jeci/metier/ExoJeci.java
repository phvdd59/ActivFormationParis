package com.formation.jeci.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoJeci {
	private String nom;
	private String adresseMail;
	private String dateEmbauche;// jj-MM-YYYYY
	private String tel; // +336123456789
	private String mdp;// majuscule minuscule chiffre

	public ExoJeci() {
		nom = "lalala";
		adresseMail = "chatroulette@gmail.fr";
		dateEmbauche = "22-06-2016";
		tel = "+33625948231";
		mdp = "2bM8ez00";

	}

	public ExoJeci(String nom) {
		setNom(nom);
	}

	public void setDate(Date date) {
		DateFormat fd = new SimpleDateFormat("dd-MM-yyyy");

		setDateEmbauche(fd.format(date));

	}

	public void setCoordonnee(String adressMail, String tel) {
		setAdresseMail(adressMail);
		setTel(tel);

	}

	/*
	 * 
	 * permutation deux en deux du motdepasse
	 * 
	 * @param mdpCache
	 * 
	 * 
	 */
	public void setMdpCache(String mdpCache) {
		String o = getMdp();
		if (mdpCache != null) {
			for (int i = 0; i < o.length(); i+=2) {
				char a = ' ';
				a = o.charAt(i);
				char b = o.charAt(i + 1);
				o.replace(o.charAt(i), a);
				o.replace(o.charAt(i + 1), b);
			}

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
		this.adresseMail = null;
		if (adresseMail.contains("@" + ".")) {
			if (adresseMail.indexOf('@') < adresseMail.indexOf('.')) {
				this.adresseMail = adresseMail;
			}
		} else {
			this.adresseMail = null;
		}

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
		this.tel = null;
		if (tel.indexOf("+") == 0) {
			String tel1 = tel.substring(1);

			if (tel1.contains("\\d") == true) {
				if (tel1.length() == 9) {
					this.tel = tel;
				}

			}
		}

	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		if (mdp.length() >= 3 && mdp.contains("\\d") && mdp.contains("\\w") && mdp.contains("\\W")) {
			this.mdp = mdp;
		}
		this.mdp = null;
	}
}
