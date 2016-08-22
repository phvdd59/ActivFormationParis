package com.formation.jeci.ctr;

import java.util.ArrayList;

public class Elmt implements Comparable<Elmt> {

	private TRI tri;
	private int numero;
	private int nb;
	private String nom;
	private float longueur;
	private float hauteur;
	private float largeur;
	private ArrayList<MATERIAUX> materiaux;

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		this.nb = nb;
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		switch (unite) {
		case "cm":
			this.longueur = longueur / 10;
			this.largeur = largeur / 10;
			this.hauteur = hauteur / 10;
			break;
		case "m":
			this.longueur = longueur / 1000;
			this.largeur = largeur / 1000;
			this.hauteur = hauteur / 1000;
			break;
		case "i":
			this.longueur = longueur * 25.4f;
			this.largeur = largeur * 25.4f;
			this.hauteur = hauteur * 25.4f;
			break;
		default:
			this.longueur = longueur;
			this.largeur = largeur;
			this.hauteur = hauteur;
			break;
		}

	}

	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		this.nb = nb;
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
public float volume() {
	float retour=longueur*largeur*hauteur;
	
	return retour;
	
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

	public float getLongueur() {
		return longueur;
	}

	public void setLongueur(float longueur) {
		this.longueur = longueur;
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

	public float getLargeur() {
		return largeur;
	}

	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	@Override
	public int compareTo(Elmt o) {
		int retour = -1;
		switch (o.getTri()) {
		case ALPHA:
			if (this.getNom().toString().compareTo(o.getNom().toString()) < 0) {
				retour = -1;
			} else if (this.getNom().toString().compareTo(o.getNom().toString()) > 0) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;
		case REF:
			if (this.getNumero()>(o.getNumero())) {
				retour = -1;
			} else if (this.getNumero()>(o.getNumero())) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;

		case VOLUME:

			if (this.volume() < (o.volume())) {
				retour = -1;
			} else if (this.volume() > (o.volume())) {
				retour = 1;
			} else {
				retour = 0;
			}
			break;

		default:
			break;
		}

		return retour;
	}
}
