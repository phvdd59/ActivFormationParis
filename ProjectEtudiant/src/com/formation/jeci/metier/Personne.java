package com.formation.jeci.metier;

public class Personne {
	private String nom;
	private String prenom;
	private boolean sexe;

	public Personne(String nom, String prenom, boolean sexe) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
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

	public boolean isSexe() {
		return sexe;
	}

	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public void setSexe(String sexe) {
	
	}
	public void getSexe() {
		return null;
	}
}
