package com.formation.joca.sauvegarde;

import java.util.ArrayList;

public class Elmt implements Comparable<Elmt> {
	public static TRI tri;

	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;

	private ArrayList<MATERIAUX> materiaux;

	public Elmt() {
	}

	public Elmt(int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		this(numero, nom, nb, longueur, largeur, hauteur);
		if (unite != null) {
			switch (unite) {
			case "mm":
				this.longueur = longueur;
				this.largeur = largeur;
				this.hauteur = hauteur;
				break;
			case "cm":
				this.longueur = longueur / 10;
				this.largeur = largeur / 10;
				this.hauteur = hauteur / 10;
				break;
			case "m":
				this.longueur = longueur * 1000;
				this.largeur = largeur * 1000;
				this.hauteur = hauteur * 1000;
				break;
			case "i":
				this.longueur = longueur / 25.4f;
				this.largeur = largeur / 25.4f;
				this.hauteur = hauteur / 25.4f;
				break;
			}
		}
	}

	public Elmt(int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		super();
		this.nom = nom;
		this.nb = nb;
		this.numero = numero;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.materiaux = new ArrayList<MATERIAUX>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getLongeur() {
		return longueur;
	}

	public void setLongeur(float longueur) {
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

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
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

	public float volume() {
		return longueur * largeur * hauteur;
	}

	@Override
	public int compareTo(Elmt o) {
		int ret = 0;
		switch (tri) {
		case REF:
			ret = Integer.valueOf(numero).compareTo(Integer.valueOf(o.numero));
			break;
		case VOLUME:
			ret = Float.valueOf(volume()).compareTo(Float.valueOf(o.volume()));
			if (ret == 0) {
				ret = Integer.valueOf(numero).compareTo(Integer.valueOf(o.numero));
			}
			break;
		case ALPHA:
			ret = nom.compareTo(o.getNom());
			break;
		}
		return 0;
	}

	public float volumeL() {
		return longueur * largeur * hauteur / 1000f;
	}

	public float poidMat(MATERIAUX mat) {
		return volumeL()*mat.getDensite()*mat.getPourcent()/100f;
	}

	public float poid() {
		return 0;
	}

	public float prixFarication(float[] prMats) {
		return 0;
	}
}
