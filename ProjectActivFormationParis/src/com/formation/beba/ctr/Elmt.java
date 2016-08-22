package com.formation.beba.ctr;

import java.util.ArrayList;

public class Elmt implements Comparable<Elmt> {
	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> materiaux;

	public Elmt(TRI tri, int numero, String nom, int nb, //
			String unite, //
			float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		if (unite.equals("cm")) {
			this.longueur = longueur * 10;
			this.largeur = largeur * 10;
			this.hauteur = hauteur * 10;
		}
		if (unite.equals("m")) {
			this.longueur = longueur * 1000;
			this.largeur = largeur * 1000;
			this.hauteur = hauteur * 1000;
		}
		if (unite.equals("1")) {
			this.longueur = longueur * 2.54f;
			this.largeur = largeur * 2.54f;
			this.hauteur = hauteur * 2.54f;
		}
	}

	public Elmt(TRI tri, int numero, String nom, int nb, //
			float longuer, float largeur, float hauteur, float longueur) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;

		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;

	}

	public float volume() {
		float vol;
		vol = this.longueur * this.largeur * this.hauteur;
		return vol;
	}

	@Override
	public int compareTo(Elmt o) {
		int compare = 0;
		if (this.tri.equals(TRI.ALPHA)) {
			compare = this.getNom().compareTo(o.getNom());
		} else if (this.tri.equals(TRI.REF)) {
			compare = this.getNumero() - (o.getNumero());
		} else if (this.tri.equals(TRI.VOLUME)) {
			if (this.volume() < o.volume()) {
				compare = 1;
			} else if (this.volume() > o.volume()) {
				compare = -1;
			} else if (this.volume() == o.volume()) {
				compare = 0;
			}
		}
		return compare;

	}

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
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
		return "Elmt [tri=" + tri + ", numero=" + numero + ", nom=" + nom + ", nb=" + nb + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", materiaux=" + materiaux + "]";
	}
}
