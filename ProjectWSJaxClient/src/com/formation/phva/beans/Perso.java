package com.formation.phva.beans;

import java.io.Serializable;

public class Perso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom2;
	private String prenom;
	private int age;
	private int autre;

	public Perso() {
	}

	public Perso(int id, String nom, String prenom, int age) {
		super();
		this.id = id;
		this.nom2 = nom;
		this.prenom = prenom;
		this.age = age;
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
		return "Perso [id=" + id + ", nom=" + nom2 + ", prenom=" + prenom + ", age=" + age + "]";
	}

	public int getAutre() {
		return autre;
	}

	public void setAutre(int autre) {
		this.autre = autre;
	}

	public String getNom2() {
		return nom2;
	}

	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}

}
