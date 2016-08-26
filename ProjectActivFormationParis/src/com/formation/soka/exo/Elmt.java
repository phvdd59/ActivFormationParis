package com.formation.soka.exo;

import java.util.ArrayList;

import com.formation.soka.a.TRI;

public class Elmt implements Comparable<Elmt> {
	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> materiaux;

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		unite = "mm";
	}

	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public float volume() {
		float volume = this.getLongueur() * this.getLargeur() * this.getHauteur();
		return volume;
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

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
		this.tri = tri;
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

	@Override
	public int compareTo(Elmt o) {
		int x = 0;
		if (tri.equals(TRI.VOLUME)) {
			if (volume() < o.volume()) {
				x = 1;
			} else if (volume() > o.volume()) {
				x = -1;
			} else {
				x = 0;
			}

		} else if (tri.equals(TRI.ALPHA)) {
			x = this.getNom().compareTo(o.getNom());
		} else if (tri.equals(TRI.REF)) {
			if (getNumero() < o.getNumero()) {
				x = 1;
			} else if (getNumero() > o.getNumero()) {
				x = -1;
			} else {
				x = 0;
			}
		}
		return x;
	}

}
