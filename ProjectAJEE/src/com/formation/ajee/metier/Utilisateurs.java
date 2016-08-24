package com.formation.ajee.metier;

public class Utilisateurs {

	private String nom;
	private String prenom;
	private String identifiant;
	private String mdp;

	public Utilisateurs(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;

		String nom2 = nom.replace(" ", "");
		identifiant = prenom.substring(0, 1) + "." + nom2;
		while (mdp.length() != 8) {
			int a = (int) (Math.random() * 123);
			char lettre = (char) a;
			if (a > 47 && a < 58) {
				mdp = mdp + lettre;
			} else if (a > 96 && a < 123) {
				mdp = mdp + lettre;
			} else if (a > 64 && a < 91) {
				mdp = mdp + lettre;
			}
		}
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
