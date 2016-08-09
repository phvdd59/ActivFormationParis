package com.formation.etga.metier;

public class Personne {

	public static int CPT = 0;
	public static int NB_ETAGE = 20;
		
	private String nom;
	private int etat;
	private int depart;
	private int arrivee;
	
	public Personne() {	
	}

	public static int getCPT() {
		return CPT;
	}

	public static int getNB_ETAGE() {
		return NB_ETAGE;
	}

	public String getNom() {
		return nom;
	}

	public int getEtat() {
		return etat;
	}

	public int getDepart() {
		return depart;
	}

	public int getArrivee() {
		return arrivee;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static void setNB_ETAGE(int nB_ETAGE) {
		NB_ETAGE = nB_ETAGE;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public void setDepart(int depart) {
		this.depart = depart;
	}

	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}

	@Override
	public String toString() {
		return ("la personne "+nom +" est " + etat + " et veux aller du " + depart + " au " + arrivee);
	}
}
