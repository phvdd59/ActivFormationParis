package com.formation.phva.metier;

public enum Meuble {
	TABLE(160, 80, 70, false), //
	CHAISE(60, 60, 100, false), //
	ARMOIRE(250, 80, 80, true), //
	TABLEAU(30,30,true), //
	AUTRE;

	private int longueur;
	private int largeur;
	private int hauteur;
	private boolean dansLaCuisine;

	private Meuble() {
		this.longueur = 0;
		this.largeur = 0;
		this.hauteur = 0;
		this.dansLaCuisine = false;
	}

	private Meuble(int longueur, int largeur, int hauteur, boolean dansLaCuisine) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.dansLaCuisine = dansLaCuisine;
	}
	
	private Meuble(int longueur, int largeur, boolean dansLaCuisine) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = 0;
		this.dansLaCuisine = dansLaCuisine;
	}

	public boolean estDansLaCuisine() {
		return dansLaCuisine;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public boolean isDansLaCuisine() {
		return dansLaCuisine;
	}

	public void setDansLaCuisine(boolean dansLaCuisine) {
		this.dansLaCuisine = dansLaCuisine;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
}
