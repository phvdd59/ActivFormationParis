package com.formation.ambr.ctrSave;

import java.util.ArrayList;

public class Elmt {
	
	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> materiaux;
	
	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longueur, float largeur, float hauteur){
		
	}
	
	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur){
		
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
		return super.toString();
	}
}
