package com.formation.thde.metier;

public class Personne {

	public static int CPT = 0;
	public static int NB_ETAGE = 20;
	private String nom;
	private int etat;
	private int depart;
	private int arrive;

	public Personne() {
	}

	public Personne(String nom, int etat, int depart, int arrive) {
		this.nom = nom;
		this.etat = etat;
		this.depart = depart;
		this.arrive = arrive;
	}

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static int getNB_ETAGE() {
		return NB_ETAGE;
	}

	public static void setNB_ETAGE(int nB_ETAGE) {
		NB_ETAGE = nB_ETAGE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int getDepart() {
		return depart;
	}

	public void setDepart(int depart) {
		this.depart = depart;
	}

	public int getArrive() {
		return arrive;
	}

	public void setArrive(int arrive) {
		this.arrive = arrive;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrive=" + arrive + "]";
	}

}
