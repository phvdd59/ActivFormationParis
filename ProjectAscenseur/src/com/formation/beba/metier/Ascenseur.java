package com.formation.beba.metier;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_Etage = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;
	
	
	public Ascenseur() {
		// TODO Auto-generated constructor stub
	}


	public static int getCPT() {
		return CPT;
	}


	public static void setCPT(int cPT) {
		CPT = cPT;
	}


	public static int getTEMPS() {
		return TEMPS;
	}


	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}


	public static int getHAUTEUR_Etage() {
		return HAUTEUR_Etage;
	}


	public static void setHAUTEUR_Etage(int hAUTEUR_Etage) {
		HAUTEUR_Etage = hAUTEUR_Etage;
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
}
