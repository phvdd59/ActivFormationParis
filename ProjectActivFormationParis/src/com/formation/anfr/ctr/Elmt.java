package com.formation.anfr.ctr;

import java.util.ArrayList;

public class Elmt implements Comparable<Elmt> {
	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longeur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> materiaux;

	public Elmt(TRI tri, int numero, String nom, int nb, String unite, float longeur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		if (unite.equals("cm")) {
			this.longeur = longeur * 10;
			this.largeur = largeur * 10;
			this.hauteur = hauteur * 10;
		} else if (unite.equals("m")) {
			this.longeur = longeur * 100;
			this.largeur = largeur * 100;
			this.hauteur = hauteur * 100;
		} else if (unite.equals("i")) {
			this.longeur = longeur * 25.4f;
			this.largeur = largeur * 25.4f;
			this.hauteur = hauteur * 25.4f;
		} else {
			this.longeur = longeur;
			this.largeur = largeur;
			this.hauteur = hauteur;
		}
	}
	public Elmt(TRI tri, int numero, String nom, int nb, float longeur, float largeur, float hauteur) {
		super();
		this.tri = tri;
		this.numero = numero;
		this.nom = nom;
		this.nb = nb;
		this.longeur = longeur;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	public float volume(){
		float volume = hauteur*largeur*longeur;
		return volume;
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
	public float getLongeur() {
		return longeur;
	}
	public void setLongeur(float longeur) {
		this.longeur = longeur;
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
	public int compareTo(Elmt arg0) {
		int compare = 0;
		if(tri.equals(TRI.ALPHA)){
			compare = this.getNom().compareTo(arg0.getNom());
		}
		else if(tri.equals(TRI.REF)){
			if (this.getNumero()>arg0.getNumero()){
				compare = 1;
			} else if (this.getNumero()<arg0.getNumero()){
				compare = -1;
			}
		}
		else {
			if (this.volume()>arg0.volume()){
				compare = 1;
			} else if (this.volume()<arg0.volume()){
				compare = -1;
			}
		}
		
		return compare;
	}
	
	@Override
	public String toString() {
		return "Element [nom=" + nom + ", nb=" + nb + "]";
	}

}
