package com.formation.joca.ctr;

import java.util.ArrayList;

public class Elmt implements Comparable<Object> {

	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> materiaux;

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

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;

		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;

		if (unite.equals("cm")) {
			this.longueur = longueur / 10;
			this.largeur = largeur / 10;
			this.hauteur = hauteur / 10;
		} else if (unite.equals("m")) {
			this.longueur = longueur / 1000;
			this.largeur = largeur / 1000;
			this.hauteur = hauteur / 1000;
		} else if (unite.equals("i")) {
			this.longueur = longueur / (float) 25.4;
			this.largeur = largeur / (float) 25.4;
			this.hauteur = hauteur / (float) 25.4;
		}
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

	public double volume() {
		return largeur * longueur * hauteur;
	}

	@Override
	public String toString() {
		return "Elmt [tri=" + tri + ", numero=" + numero + ", nom=" + nom + ", nb=" + nb + ", longueur=" + longueur
				+ ", largeur=" + largeur + ", hauteur=" + hauteur + ", materiaux=" + materiaux + "]";
	}

	@Override
	public int compareTo(Object o) {
		int result = 0;
		Elmt obj = (Elmt) o;
		if (this.tri.equals(TRI.ALPHA)) {

			result = this.nom.compareTo(obj.getNom());

		} else if (this.tri.equals(TRI.REF)) {

			if (this.numero < obj.getNumero()) {
				result = -1;
			} else if (this.numero > obj.getNumero()) {
				result = 1;
			} else if (this.numero == obj.getNumero()) {
				result = 0;
			}

		} else if (this.tri.equals(TRI.VOLUME)) {

			if (this.volume() < obj.volume()) {
				result = -1;
			} else if (this.volume() > obj.volume()) {
				result = 1;
			} else if (this.volume() == obj.volume()) {
				result = 0;
			}

		}
		return result;
	}

}
