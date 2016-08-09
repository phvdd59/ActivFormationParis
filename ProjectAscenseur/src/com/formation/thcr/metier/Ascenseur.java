package com.formation.thcr.metier;

public class Ascenseur extends Thread {

	public static int	CPT				= 0;
	public static int	TEMPS			= 10;
	public static int	HAUTEUR_ETAGE	= 30;
	private int			etage;
	private int			progression;
	private boolean		fin;
	private Personne	personne;

	public Ascenseur() {

	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Ascenseur [etage=" + etage + ", progression=" + progression + ", fin=" + fin + ", personne=" + personne + "]";
	}

}
