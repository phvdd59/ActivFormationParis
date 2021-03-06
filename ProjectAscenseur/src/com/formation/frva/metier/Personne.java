package com.formation.frva.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {
	public static int CPT =0;
	public static int NB_ETAGE=20;
	
	private String nom;
	private InterETAT etat;
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
		return ("( "+ nom + " " + getEtat().toString() + "  depart " + depart + " arriv�e " + arrivee + " )" );
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

	@Override
	public InterETAT getEtat() {
		return etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
		this.etat = etat;
		
	}
	


}
