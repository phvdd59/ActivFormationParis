package com.formation.thde.metier;

import com.formation.thde.inter.Egale;

public abstract class Animal implements Egale {

	private int poids;
	private String couleur;

	public Animal() {
		this.poids = 0;
		this.couleur = null;
	}

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

	@Override
	public String toString() {
		return "Animal [poids=" + poids + ", couleur=" + couleur + "]";
	}

	@Override
	public abstract boolean egale(Animal animal);
}
