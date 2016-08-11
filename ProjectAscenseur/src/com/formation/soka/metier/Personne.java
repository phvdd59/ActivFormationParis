package com.formation.soka.metier;

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
		etat = Etat.ETAT_ATTENTE;
		depart = (int) (Math.random() * NB_ETAGE);
		arrive = (int) (Math.random() * NB_ETAGE);
		while (depart == arrive) {
			arrive = (int) (Math.random() * NB_ETAGE);
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
		// TODO Auto-generated method stub
		return arrive;
	}

	@Override
	public InterETAT getEtat() {
		// TODO Auto-generated method stub
		return etat;
	}

	@Override
	public void setEtat(InterETAT etat) {
		// TODO Auto-generated method stub
		this.etat = etat;

	}
}
