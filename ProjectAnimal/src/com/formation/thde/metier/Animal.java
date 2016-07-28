package com.formation.thde.metier;

public abstract class Animal {

	private int poids;
	private String couleur;

	public Animal(int poids, String couleur) {
		this.poids = poids;
		this.couleur = couleur;
	}

	public abstract void manger();

	public abstract void boire();

	public abstract void deplacement();

	public abstract void crier();

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}
