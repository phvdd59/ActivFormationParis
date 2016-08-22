package com.formation.thde.ctr;

import java.util.ArrayList;

public class Elmt implements Comparable<Elmt> {
	Tri tri;
	int numero;
	String nom;
	int nb;
	String unite;
	float longueur;
	float largeur;
	float hauteur;
	ArrayList<MATERIAUX> materiaux;

	public Elmt(Tri tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur, ArrayList<MATERIAUX> materiaux) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.unite = unite;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.materiaux = materiaux;
	}

	public Elmt(Tri tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur, ArrayList<MATERIAUX> materiaux) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.unite = "mm";
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.materiaux = materiaux;
	}

	public float volume() {
		return this.longueur * this.largeur * this.hauteur;
	}

	public Tri getTri() {
		return tri;
	}

	public void setTri(Tri tri) {
		this.tri = tri;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	public float getHauteur() {
		return hauteur;
	}

	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public ArrayList<MATERIAUX> getMateriaux() {
		return materiaux;
	}

	public void setMateriaux(ArrayList<MATERIAUX> materiaux) {
		this.materiaux = materiaux;
	}

	@Override
	public String toString() {
		return "Elmt [tri=" + tri + ", numero=" + numero + ", nom=" + nom + ", nb=" + nb + ", unite=" + unite + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", materiaux=" + materiaux + "]";
	}

	@Override
	public int compareTo(Elmt o) {
		int result = 0;

		if (this.tri == Tri.ALPHA) {
			result = (int) this.getNom().compareTo(o.getNom());
		} else if (this.tri == Tri.REF) {
			if (Integer.valueOf(this.getNumero()) < Integer.valueOf(o.getNumero())) {
				result = -1;
			} else if (Integer.valueOf(this.getNumero()) > Integer.valueOf(o.getNumero())) {
				result = 1;
			} else {
				result = 0;
			}
		} else if (this.tri == Tri.VOLUME) {
			if (this.volume() < o.volume()) {
				result = -1;
			} else if (this.volume() > o.volume()) {
				result = 1;
			} else {
				result = 0;
			}
		}
		return result;
	}

}
