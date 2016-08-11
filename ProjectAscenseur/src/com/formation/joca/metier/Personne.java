package com.formation.joca.metier;

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

		this.nom = Integer.toString(CPT);
		this.etat = ETAT.ATTENTE;
		this.depart = (int) (Math.random() * 20);
		this.arrivee = (int) (Math.random() * 20);
		while (depart == arrivee) {
			this.arrivee = (int) (Math.random() * 20);
		}
		this.CPT++;
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

	public void setArrivee(int arrive) {
		this.arrivee = arrive;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrive=" + arrivee + ", CPT ="
				+ CPT + "]";
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
