package com.formation.thcr.metier;

public class Personne {

	private String	nom;
	private String	login;
	private String	motDePasse;
	private boolean admin; 

	public Personne(String nom, String login, String motDePasse, boolean admin) {
		this.nom = nom;
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin=admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
