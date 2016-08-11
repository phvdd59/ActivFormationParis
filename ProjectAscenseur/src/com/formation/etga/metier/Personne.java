package com.formation.etga.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {

	public static int CPT = 0;
	public static int NB_ETAGE = 20;

	private String nom;
	private InterETAT etat;
	private int depart;
	private int arrivee;

	public Personne() {
		nom = Integer.toString(CPT);
		CPT++;
		etat = ETAT.ATTENTE;
		depart = (int) (Math.random() * 20);
		arrivee = (int) (Math.random() * 20);
		while (arrivee == depart) {
			arrivee = (int) (Math.random() * 20);
		}
	}

	public String getNom() {
		return nom;
	}

	public InterETAT getEtat() {
		return etat;
	}

	public int getDepart() {
		return depart;
	}

	public int getArrivee() {
		return arrivee;
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEtat(InterETAT etat) {
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
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrivee=" + arrivee + "]";
	}
}
