package com.formation.beba.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {
	public static int CPT = 0;
	public static int NB_ETAGE = 20;

	private String nom;
	private InterETAT etat;
	private int depart;
	private int arrivee;
	/*
	 * faire un générateur de personnes aléatoires - étage de départ - étage
	 * d'arrivé création personne à des temps aléatoires
	 * 
	 */

	public Personne() {
		setNom(NOM_PERSONNE.getRandomNom().toString());
		// setNom(String.valueOf(CPT));
		setEtat(ETAT.ETAT_ATTENTE);
		setArrivee((int) (Math.random() * NB_ETAGE));
		setDepart((int) (Math.random() * NB_ETAGE));
		while (this.arrivee == this.depart) {
			this.setArrivee((int) (Math.random() * NB_ETAGE));
		}
		CPT++;
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

	// public InterETAT getEtat() {
	// return etat;
	// }
	//
	// public void setEtat(interETAT etat) {
	// this.etat = etat;
	// }

	public int getDepart() {
		return depart;
	}

	public void setDepart(int depart) {
		this.depart = depart;
	}

	// public int getArrivee() {
	// return arrivee;
	// }

	public void setArrivee(int arrive) {
		this.arrivee = arrive;
	}

	@Override
	public String toString() {
		return "Personne [nom= " + nom + ", etat= " + etat.toString() + ", depart= " + depart + ", arrive= " + arrivee + "]";
	}

	@Override
	public int getArrivee() {
		return arrivee;
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
