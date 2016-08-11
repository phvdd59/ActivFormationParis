package com.formation.thcr.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne{

	public static int	CPT			= 0;
	public static int	NB_ETAGE	= 20;

	private String		nom;
	private InterETAT	etat;
	private int			depart;
	private int			arrive;

	public Personne() {
		this.etat = ETAT.ATTENTE;
		while (this.depart == this.arrive) {
			this.depart = Integer.valueOf((int) (Math.random() * NB_ETAGE)).intValue();
			this.arrive = Integer.valueOf((int) (Math.random() * NB_ETAGE)).intValue();
		}
		this.nom = String.valueOf(CPT);
		CPT++;
		/**
		 * faire un générateur de personnes aléatoires - étage de départ - étage
		 * d'arrivé création personne à des temps aléatoires
		 */

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
		this.arrive = arrive;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrive=" + arrive + " ";
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
		// TODO Auto-generated method stub
		
	}

}
