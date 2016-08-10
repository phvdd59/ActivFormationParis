package com.formation.frva.metier;

import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {
	public static int CPT =0;
	public static int NB_ETAGE=20;
	
	private String nom;
	private ETAT etat;
	private int depart;
	private int arrivee;
	
	public Personne() {
		this.nom = new Integer(CPT).toString();
		CPT++;
		this.etat = ETAT.ATTENTE;
		depart = (int) (Math.random()*20);
		arrivee = (int) (Math.random()*20);
		while (arrivee == depart){
			arrivee = (int) (Math.random()*20);
		}
	}
	
	public Personne(String nom, int depart, int arrivee) {
		super();
		this.nom = nom;
		this.etat = ETAT.ATTENTE;
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
	public ETAT getEtat() {
		return etat;
	}
	public void setEtat(ETAT etat) {
		this.etat = etat;
	}

	@Override
	public com.formation.phva.metier.ETAT getEtat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEtat(com.formation.phva.metier.ETAT depart) {
		// TODO Auto-generated method stub
		
	} 

}
