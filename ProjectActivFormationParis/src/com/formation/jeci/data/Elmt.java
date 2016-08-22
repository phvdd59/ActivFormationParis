package com.formation.jeci.data;

import java.util.ArrayList;

public class Elmt {

	private TRI tri;
	private int numero;
	private int nb;
	private String nom;
	private float longueur;
	private float hauteur;
	private float largeur;
	private ArrayList<MATERIAUX> materiaux;

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur) {
		this.nb=nb;
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.longueur = longueur;
		this.largeur=largeur;
		this.hauteur = hauteur;
	}

	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur) {
		this.nb=nb;
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.longueur = longueur;
		this.largeur=largeur;
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
}
