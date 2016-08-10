package com.formation.frva.metier;

public class Personne {
	public static int CPT =0;
	public static int NBMAXPERS = 2;
	public static int NB_ETAGE=20;
	
	private String nom;
	private Etat etat;
	private int depart;
	private int arrivee;
	
	public Personne() {
		this.nom = new Integer(CPT).toString();
		CPT++;
		this.etat = Etat.ATTENTE;
		depart = (int) (Math.random()*20);
		arrivee = (int) (Math.random()*20);
		while (arrivee == depart){
			arrivee = (int) (Math.random()*20);
		}
	}
	
	public Personne(String nom, int depart, int arrivee) {
		super();
		this.nom = nom;
		this.etat = Etat.ATTENTE;
		this.depart = depart;
		this.arrivee = arrivee;
	}
	
	
	@Override
	public String toString() {
		return ("( "+ nom + " " + etat.name() + "  depart " + depart + " arrivée " + arrivee + " )" );
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDepart() {
		return depart;
	}
	public void setDepart(int depart) {
		this.depart = depart;
	}
	public int getArrivee() {
		return arrivee;
	}
	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	} 

}
