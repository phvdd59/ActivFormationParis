package com.formation.thde.metier;

public enum Meuble {
	TABLE(160, 80, 70, false), //
	CHAISE(60, 60, 100, false), //
	ARMOIRE(250, 80, 80, true), //
	TABLEAU(30, 30, true);

	private int longueur;
	private int largeur;
	private int hauteur;
	private boolean dansLaCuisine;

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

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public boolean isDansLaCuisine() {
		return dansLaCuisine;
	}

	public void setDansLaCuisine(boolean dansLaCuisine) {
		this.dansLaCuisine = dansLaCuisine;
	}
}
