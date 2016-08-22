package com.formation.issa.ctr;

import java.util.ArrayList;

public class Elmt {
	private TRI tri;
	private int numero;
	private String nom;
	private int nb;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ArrayList<MATERIAUX> mot;
	
	public Elmt(TRI tri, int numero, String nom, int nb, float longueur, float largeur, float hauteur){
		this.tri=tri;
		this.numero=numero;
		this.nom=nom;
		this.nb=nb;
		this.longueur=longueur;
		this.largeur=largeur;
		this.hauteur=hauteur;
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

	public ArrayList<MATERIAUX> getMot() {
		return mot;
	}

	public void setMot(ArrayList<MATERIAUX> mot) {
		this.mot = mot;
	}
	public int compareTo(Elmt o){
		int retour=0;
		float volume=longueur*largeur*hauteur;
		
		if(this.getNom().compareTo(o.getNom())>0){
			retour=1;
		}else if(this.getNom().compareTo(o.getNom())<0){
			retour=-1;
		}else{
			if(this.getNumero()<o.getNumero()){
				retour=-1;
			}else if(this.getNumero()>o.getNumero()){
				retour=1;
			}else{
				if((int)this.getHauteur()*getLargeur()*getLongueur()>o.getHauteur()*getLargeur()*getLongueur()){
					retour=1;
				}else if((int) this.getHauteur()*getLargeur()*getLongueur()<o.getHauteur()*getLargeur()*getLongueur()){
					retour=-1;
				}else{
					retour=0;
				}
			}
		
		}
		return retour;
	}

}
