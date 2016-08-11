package com.formation.jeci.metier;

import com.formation.jeci.enume.ETAT;
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
		this.etat = ETAT.ATTENTE;
		this.nom = Integer.toString(CPT);
		this.depart = (int) (Math.random() * 20);
		this.arrive = (int) (Math.random() * 20);
		while (depart == arrive) {
			arrive = (int) (Math.random() * 20);

		}
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

		return "Personne:" + nom + ", etat:" + etat + ", depart:" + depart + ", arrive:" + arrive;
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
