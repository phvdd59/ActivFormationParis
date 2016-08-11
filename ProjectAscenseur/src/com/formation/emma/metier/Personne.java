package com.formation.emma.metier;

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
		nom = Integer.toString(CPT);
		CPT++;
		etat = Etat.ATTENTE;
		depart = (int) (Math.random() * 20);
		arrive = (int) (Math.random() * 20);

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public InterETAT getEtat() {
		return etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
			
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
		return arrive;
	}

}
