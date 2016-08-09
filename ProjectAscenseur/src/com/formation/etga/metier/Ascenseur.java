package com.formation.etga.metier;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;
	
	private int etage;
	private  int progression;
	private boolean fin;
	private Personne personne;
	
	public Ascenseur() {	
	}

	public static int getCPT() {
		return CPT;
	}

	public static int getTEMPS() {
		return TEMPS;
	}

	public static int getHAUTEUR_ETAGE() {
		return HAUTEUR_ETAGE;
	}

	public int getEtage() {
		return etage;
	}

	public int getProgression() {
		return progression;
	}

	public boolean isFin() {
		return fin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}

	public static void setHAUTEUR_ETAGE(int hAUTEUR_ETAGE) {
		HAUTEUR_ETAGE = hAUTEUR_ETAGE;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return ("l'ascenseur est au " + etage +", va vers " +progression +" contient "+ personne+" personne");
	}
	
}