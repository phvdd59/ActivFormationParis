package com.formation.phva.beans;

import java.io.Serializable;

public class PersoClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String prenom;
	private int age;

	public PersoClient() {
	}

	public PersoClient(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Perso [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + "]";
	}

}
