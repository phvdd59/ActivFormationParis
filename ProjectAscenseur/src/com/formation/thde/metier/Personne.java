package com.formation.thde.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {

	public static int CPT = 0;
	public static int NB_ETAGE = 20;
	private String nom;
	private InterETAT etat;
	private int depart;
	private int arrive;

	public Personne() {
	}

	public Personne(String nom, InterETAT etat, int depart, int arrive) {
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

	@Override
	public int getArrivee() {
		return this.arrive;
	}

	@Override
	public InterETAT getEtat() {
		return this.etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
		this.etat = etat;
	}

}
