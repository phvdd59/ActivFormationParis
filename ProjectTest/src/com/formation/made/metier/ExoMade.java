package com.formation.made.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoMade {
	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj--mm--yyyy
	private String tel; // +33612345678
	private String mdp; // majuscule minuscule chiffre

	public ExoMade() {
	}

	public ExoMade(String nom) {
		this.nom = nom;
	}

	public void setDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // simpledateformat
		String s = sdf.format(new Date());
		// Date d=sdf.parse("20-04-2010");

	}

	public void setCoordonnees(String adresseMail, String tel) {
		if (adresseMail != null) {
			if ((adresseMail.contains("@")) && (adresseMail.contains(".com") || adresseMail.contains(".fr"))) {
				this.adresseMail = adresseMail;
			} else {
				this.adresseMail = null;
			}
		}
		if (tel != null) {
			if (tel.length() == 12 && tel.startsWith("+3")) {
				if (Long.valueOf(tel.substring(2)) instanceof Long) {
					Long i = (Long) Long.valueOf(tel.substring(2));
					setTel(tel);
				}
			} else {
				setTel(null);
			}
		}

	}

	/**
	 * permutation deux en deux des caractères du mot de passe
	 * 
	 * @param mdpCache
	 */

	public void setMdpCache(String mdpCache) {
		if (mdpCache == null) {
			this.mdp = null;
		}

		char[] tabchar = mdpCache.toCharArray();

		for (int i = 0; i < tabchar.length; i++) {
			if (Character.isDigit(tabchar[i])) {
				break;
			}
		}

		if (!mdpCache.toLowerCase().equals(mdpCache) || !mdpCache.toUpperCase().equals(mdpCache)) {

			String[] tabstring = new String[mdpCache.length()];
			for (int i = 0; i < tabstring.length; i++) {
				tabstring[i] = mdpCache.substring(i, i + 1);
			}

			String[] tabMdpCache = tabstring.clone();
			for (int i = 0; i < (int) tabstring.length / 2; i++) {
				tabMdpCache[2 * i] = tabstring[(2 * i) + 1];
				tabMdpCache[(2 * i) + 1] = tabstring[2 * i];
			}
			String stringMdp = "";
			for (int i = 0; i < tabMdpCache.length; i++) {
				stringMdp += tabMdpCache[i];
			}
			this.mdp = stringMdp;
		} else {
			this.mdp = null;
			System.out.println("le mdp doit contenir des maj et des min");
		}
	}

	public void setTel(int numero) { // ceci est un exemple
		tel = Integer.toString(numero);
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
