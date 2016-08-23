package com.formation.emma.metier;

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

	String unite = "mm";

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
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
		return "Elmt [numero=" + numero + ", nom=" + nom + ", nb=" + nb + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + "]";
	}

	public float volume() {

		float a = this.longueur * this.largeur * this.hauteur;
		return a;
	}

	@Override
	public int compareTo(Elmt o) {
		int compare = 2;
		if (tri == TRI.ALPHA) {
			if (getNom().compareTo(o.getNom()) < 0) {
				compare = -1;
			} else if (getNom().compareTo(o.getNom()) > 0) {
				compare = 1;
			}
		} else if (tri == TRI.REF) {
			if (getNumero() < o.getNumero()) {
				compare = -1;
			} else if (getNumero() > o.getNumero()) {
				compare = 1;
			}
		} else if (tri == TRI.VOLUME) {
			if (this.volume() < o.volume()) {
				compare = -1;
			} else if (this.volume() > o.volume()) {
				compare = 1;
			}
		}

		return compare;
	}

}