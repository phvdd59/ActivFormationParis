package com.formation.thcr.metier;

public class Personne {

	public static int	CPT			= 0;
	public static int	NB_ETAGE	= 20;

	private String		nom;
	private int			etat;
	private int			depart;
	private int			arrive;

	public Personne() {
		 /** faire un générateur de personnes aléatoires
		 * 		- étage de départ
		 * 		- étage d'arrivé
		 * 		création personne à des temps aléatoires
		 */
		
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
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

}
