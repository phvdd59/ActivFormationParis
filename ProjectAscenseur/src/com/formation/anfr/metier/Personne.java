package com.formation.anfr.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne{
	public static int CPT = 0;
	public static int NB_ETAGE = 15;

	private String nom;
	private InterETAT etat;
	private int depart;
	private int arrivee;

	public Personne() {
		this.setNom(Integer.toString(CPT));
		this.etat = ETAT.ETAT_ATTENTE;
		this.setArrive((int) (Math.random()*NB_ETAGE)); 
		this.setDepart((int) (Math.random()*NB_ETAGE));
		while(this.getArrivee()==this.getDepart()){
			this.setDepart((int) (Math.random()*NB_ETAGE));
		}
		CPT++;
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

	public void setArrive(int arrive) {
		this.arrivee = arrive;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", etat=" + etat + ", etage de depart=" + depart + ", etage d'arrive=" + arrivee + "]";
	}

	@Override
	public InterETAT getEtat() {
		return this.etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
		this.etat=etat;
	}

	@Override
	public int getArrivee() {
		return arrivee;
	}

}
