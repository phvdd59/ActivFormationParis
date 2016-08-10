package com.formation.joca.metier;

public class Personne {
	public static int CPT = 0;
	public static int NB_ETAGE = 20;

	private String nom;
	private int etat;
	private int depart;
	private int arrive;

	public Personne(String nom, int etat, int depart, int arrive) {
		super();
		this.nom = nom;
		this.etat = etat;
		this.depart = depart;
		this.arrive = arrive;
		this.CPT++;
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
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrive=" + arrive + ", CPT =" + CPT
				+ "]";
	}

}
