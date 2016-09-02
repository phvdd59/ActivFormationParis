package com.formation.thde.metier;

import java.io.Serializable;

public class Personne implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mail;
	String nom;
	String prenom;

	public Personne() {
		this.mail = "";
		this.nom = "";
		this.prenom = "";
	}
	
	public Personne(String mail, String nom, String prenom) {
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [mail=" + mail + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
