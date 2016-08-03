package com.formation.thcr.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoThcr {

	private String	nom;			//no number/punct
	private String	adresseMail;	//skqhdgs.azjh7AZE@ksdkfj.azfho
	private String	dateEmbauche;	// jj-mm-xxx
	private String	tel;			// +33607302229
	private String	mdp;			// Majuscule minuscule chiffre

	public ExoThcr() {

	}

	public ExoThcr(String nom) {

		if (nom != null) {
			if (nom.matches(
					"^((?:[a-zA-Z]|[\\-_ ](?![\\-_ ])|[\\u00C0\\u00C1\\u00C2\\u00C3\\u00C4\\u00C5\\u00C6\\u00C7\\u00C8\\u00C9\\u00CA\\u00CB\\u00CC\\u00CD\\u00CE\\u00CF\\u00D0\\u00D1\\u00D2\\u00D3\\u00D4\\u00D5\\u00D6\\u00D8\\u00D9\\u00DA\\u00DB\\u00DC\\u00DD\\u00DF\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u00E7\\u00E8\\u00E9\\u00EA\\u00EB\\u00EC\\u00ED\\u00EE\\u00EF\\u00F0\\u00F1\\u00F2\\u00F3\\u00F4\\u00F5\\u00F6\\u00F9\\u00FA\\u00FB\\u00FC\\u00FD\\u00FF\\u0153])+)$")) {
				this.nom = nom;
			} else {
				this.nom = "";
			}
		}
	}

	public void setDate(Date date) {
		if (date != null) {
			Date date2 = new Date();
			SimpleDateFormat fd = new SimpleDateFormat("dd-mm-yyyy");
			fd.setLenient(false);
			if (date.compareTo(date2) < 0) {
				this.dateEmbauche = fd.format(date);
			}
		}

	}

	public void setCoordonnee(String adresseMail, String tel) {
		if (adresseMail != null) {
			if (adresseMail.matches("[a-zA-Z_0-9.]{1,}@[a-zA-Z0-9]{1,}\\.[a-zA-Z]{1,}")) {
				this.adresseMail = adresseMail.toLowerCase();
				//Mise en forme sous minuscule
			} else {
				setAdresseMail("");
			}
		}
		if (tel != null) {
			if (tel.matches("\\+33[1-9]{1}[0-9]{8}")) {
				this.tel = tel;
			} else {
				setTel("");
			}
		}
	}

	/**
	 * permutation deux en deux les lettres du mot de passe ex abcDeF89 ->
	 * baDcFe98
	 * 
	 * @param MdpCache
	 */
	public void setMdpCache(String MdpCache) {
		if (MdpCache != null) {
			char[] c = MdpCache.toCharArray();
			boolean lc = false;
			boolean uc = false;
			boolean nu = false;
			boolean o = false;
			boolean b = false;
			String s = "";
			for (int i = 0; i < c.length; i++) {
				if (Character.isUpperCase(c[i])) {
					uc = true;
					break;
				}
			}
			for (int i = 0; i < c.length; i++) {
				if (Character.isLowerCase(c[i])) {
					lc = true;
					break;
				}
			}
			for (int i = 0; i < c.length; i++) {
				if (Character.isDigit(c[i])) {
					nu = true;
					break;
				}
			}
			if (!MdpCache.matches("[^a-zA-Z0-9]")) {
				o = true;
			}
			if (nu && lc && uc && o) {
				b = true;
			}
			if (c.length % 2 == 0 && b) {
				for (int i = 0; i < c.length - 1; i = i + 2) {
					char tmp = c[i];
					c[i] = c[i + 1];
					c[i + 1] = tmp;
					s += c[i];
					s += c[i + 1];
				}
			} else if (b) {
				for (int i = 0; i < c.length - 2; i = i + 2) {
					char tmp = c[i];
					c[i] = c[i + 1];
					c[i + 1] = tmp;
					s += c[i];
					s += c[i + 1];
				}
				s += c[c.length - 1];
			}

			this.setMdp(s);
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
