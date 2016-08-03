package com.formation.anfr.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExoAnfr {
	private String nom;
	private String adresseMail;
	private String dateEmbauche; // jj-MM-aaaa
	private String tel; // +33 6 12 34 56 78
	private String mdpCache; // majuscule minuscule chiffre

	public ExoAnfr() {
	}

	public ExoAnfr(String nom) {
		setNom(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setDateEmbauche(Date date) {
		SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yyyy");
		if (date != null) {
			String s = fd.format(date);
			this.dateEmbauche = s;
		} else {
			this.dateEmbauche = null;
		}

	}

	public void setCoordonee(String adresseMail, String tel) {
		if (tel != null) {
			char[] tab = tel.trim().toCharArray();
			if ((tab[0] == '+') && (tab.length == 12)) {
				boolean allInteger = true;
				for (int i = 1; i < tab.length; i++) {
					if ((tab[i] < '0') || (tab[i] > '9')) {
						allInteger = false;
					}
				}
				if (allInteger) {
					this.tel = tel;
				} else {
					this.tel = null;
				}

			} else {
				this.tel = null;
			}
		}
		if (adresseMail != null) {
			if (adresseMail.contains("@")) {
				String[] mail = adresseMail.split("@");

				if ((mail[1].contains(".com") || mail[1].contains(".fr")) && (mail.length == 2)) {
					boolean charanommage = true;
					char[] tab1 = mail[0].trim().toCharArray();

					for (char c : tab1) {
						c = Character.toLowerCase(c);
						if ((c < 'a') || (c > 'z')) {
							if ((c < '0') || (c > '9')) {
								if ((c != '.') && (c != '_')) {
									charanommage = false;
								}
							}
						}
					}
					if (charanommage) {
						this.adresseMail = adresseMail;
					} else {
						this.adresseMail = null;
					}

				} else {
					this.adresseMail = null;
				}
			} else {
				this.adresseMail = null;
			}
		} else {
			this.adresseMail = null;
		}

	}

	/**
	 * permutation 2 en deux du mdp; ABcdEf --> BAdcfE
	 **/
	public void setMdpCache(String motDePasse) {
		mdpCache = null;
		if (motDePasse != null) {

			char[] tab1 = motDePasse.trim().toCharArray();
			boolean majuscule = false;
			boolean minuscule = false;
			boolean chiffre = false;
			boolean pasDeCharacteresSpeciaux = true;
			for (char c : tab1) {
				if ((c >= 'a') && (c <= 'z')) {
					minuscule = true;
				}
				if ((c >= '0') && (c <= '9')) {
					chiffre = true;
				}
				if ((c >= 'A') && (c <= 'Z')) {
					majuscule = true;
				}
				if ((c < 'a') || (c > 'z')) {
					if ((c < '0') || (c > '9')) {
						if ((c < 'A') && (c > 'Z')) {
							pasDeCharacteresSpeciaux = false;
						}
					}
				}
			}
			if (majuscule && minuscule && chiffre && pasDeCharacteresSpeciaux) {
				char[] tab2 = new char[tab1.length];
				int longTab = 0;
				if (tab1.length % 2 == 0) {
					longTab = tab1.length;
				} else {
					longTab = tab1.length - 1;
				}
				for (int i = 0; i < longTab; i += 2) {
					tab2[i] = tab1[i + 1];
					tab2[i + 1] = tab1[i];
				}
				mdpCache = "";
				for (char c : tab2) {
					mdpCache += c;
				}

			}

		}
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
		return mdpCache;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
