package com.formation.ambr.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {

	public static int CPT = 0;
	public static int NB_ETAGE = 20;

	private String nom;
	private InterETAT etat; // e.g. ETAT.ETAT_ATTENTE.ordinal() -> 0
	private int depart;
	private int arrivee;

	public Personne() { // constructeur de Philippe

		nom = Integer.toString(CPT);
		CPT++;
		etat = ETAT.ATTENTE;
		depart = (int) (Math.random() * 20);
		arrivee = (int) (Math.random() * 20);
		while (arrivee == depart) {
			arrivee = (int) (Math.random() * 20);

		}
	}

	public Personne(String nom, InterETAT etat, int depart, int arrivee) {
		this.nom = nom;
		this.etat = etat;
		this.depart = depart;
		this.arrivee = arrivee;

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

//	public InterETAT getEtat() {
//		return etat;
//	}
//
//	public void setEtat(InterETAT etat) {
//		this.etat = etat;
//	}

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
	public String toString() {
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrivee=" + arrivee + "]";
	}

	@Override
	public InterETAT getEtat() {
		return etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
		this.etat=etat;
	}

}
