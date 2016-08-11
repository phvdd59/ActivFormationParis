package com.formation.issa.metier;

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

		nom = String.valueOf(CPT);
		// nom=Integer.toString(CPT);
		while (depart == arrivee) {
			this.depart = (int) (Math.random() * NB_ETAGE);
			this.arrivee = (int) (Math.random() * NB_ETAGE);
		}
		etat = ETAT.ATTENTE;;
		CPT++;

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
		// depart=(int)Math.random()*
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


}
