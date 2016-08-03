package com.formation.soka.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ExoSoka {

	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-yyyy
	private String tel; //+336xxxxxxxx
	private String mdp; // majuscule minuscule chiffre

	public ExoSoka() {

	}

	public ExoSoka(String nom) {
		if (nom != null) {
			if (nom.matches(
					"^((?:[a-zA-Z][\\-_ ](?![\\-_ ])|[\\u00C0\\u00C1\\u00C2\\u00C3\\u00C4\\u00C5\\u00C6\\u00C7\\u00C8\\u00C9\\u00CA\\u00CB\\u00CC\\u00CD\\u00CE\\u00CF\\u00D0\\u00D1\\u00D2\\u00D3\\u00D4\\u00D5\\u00D6\\u00D8\\u00D9\\u00DA\\u00DB\\u00DC\\u00DD\\u00DF\\u00E0\\u00E1\\u00E2\\u00E3\\u00E4\\u00E5\\u00E6\\u00E7\\u00E8\\u00E9\\u00EA\\u00EB\\u00EC\\u00ED\\u00EE\\u00EF\\u00F0\\u00F1\\u00F2\\u00F3\\u00F4\\u00F5\\u00F6\\u00F9\\u00FA\\u00FB\\u00FC\\u00FD\\u00FF\\u0153])+)$")) {
				this.nom = nom;
			} else {
				this.nom = "";
			}
		} else {
			nom = null;
		}
	}

	public void setDate(Date date) {
		if (date != null) {
			SimpleDateFormat fd = new SimpleDateFormat("dd-mm-yyyy", Locale.FRENCH);
			String s = fd.format(date);
			this.dateEmbauche = s;
		} else {
			this.dateEmbauche = null;
		}

	}

	public void setCoordonnee(String adresseMail, String tel) {
		if (adresseMail != null) {
			if (adresseMail.contains("@") && (adresseMail.endsWith(".fr") || adresseMail.endsWith(".com"))) {
				this.adresseMail = adresseMail.toLowerCase();
			} else {
				this.adresseMail = "";
			}
		} else {
			this.adresseMail = null;
		}

		//
		if (tel != null) {
			char[] tabChar = tel.toCharArray();

			for (int i = 3; i < tabChar.length; i++) {
				if (tel.length() == 12 && tel.startsWith("+33") && Character.isDigit(tabChar[i])) {
					if (tabChar[i] >= 0 || tabChar[i] <= 9) {
						this.tel = tel;
					}
				} else {
					this.tel = "";
				}
			}
		} else {
			this.tel = null;
		}

	}

	/**
	 * permutation deux en deux du mdp abcdeF --> badcFe
	 * 
	 * @param mdpCache
	 */

	public void setMdp(String mdpCache) {
		if (mdpCache != null) {
			//Doit donc contenir au moins une minuscule, une maj et un chiffre
			char[] tabChar = mdpCache.toCharArray();
			char[] tabChar2 = new char[tabChar.length];
			String s = "";
			boolean caracMaj = false;
			boolean caracMin = false;
			boolean caracDigit = false;

			for (int i = 0; i < tabChar.length; i++) {
				if (Character.isUpperCase(tabChar[i])) {
					caracMaj = true;
				}
				if (Character.isLowerCase(tabChar[i])) {
					caracMin = true;
				}
				if (Character.isDigit(tabChar[i])) {
					caracDigit = true;
				}
			}
			if (caracMaj == true && caracMin == true && caracDigit == true) {
				if (tabChar.length % 2 == 0) {
					for (int i = 0; i < tabChar.length; i++) {
						if (i % 2 == 0) {
							tabChar2[i] = tabChar[i + 1];
						} else {
							tabChar2[i] = tabChar[i - 1];
						}
						s = s.concat(Character.toString(tabChar2[i]));
					}
				} else {

					for (int i = 0; i < tabChar2.length - 1; i++) {
						tabChar2[tabChar.length - 1] = tabChar[tabChar.length - 1];
						if (i % 2 == 0) {
							tabChar2[i] = tabChar[i + 1];
						} else {
							tabChar2[i] = tabChar[i - 1];
						}

						s = s.concat(Character.toString(tabChar2[i]));
					}
					s = s.concat(Character.toString(tabChar2[tabChar.length - 1]));
				}
				this.mdp = s;
			} else {
				this.mdp = "";
			}
		} else {
			this.mdp = null;
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

}
