package com.formation.made.metier;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterPersonne;

public class Personne implements InterPersonne {
	public static int CPT = 0;
	public static int NB_ETAGE = 20;

	public String nom;
	public InterETAT etat;
	public int depart;
	public int arrivee;

	public Personne() {
		this.nom = "Personne" + Integer.toString(CPT);
		this.etat = ETAT.ATTENTE;
		// arrivee = (int) (Math.random() * 20);
		// depart = (int) (Math.random() * 20);
		while (depart == arrivee) {
			depart = (int) (Math.random() * 20);
			arrivee = (int) (Math.random() * 20);
		}
		CPT++;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", etat=" + etat + ", depart=" + depart + ", arrivee=" + arrivee + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public InterETAT getEtat() {
		return etat;
	}

	public void setEtat(InterETAT etat) {
		this.etat = etat;
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

	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}

}
