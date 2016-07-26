package com.formation.anfr.metier;

public enum typeWagon {
	WAGON_RESTO(3,14), WAGON_SIMPLE1(2,14), WAGON_SIMPLE2(0,44), WAGON_DOUBLE(1,28);
	private int valeur;
	private int pourcent;

	private typeWagon(int valeur,int pourcent) {
		this.valeur = valeur;
		this.pourcent = pourcent;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}
	
	
}
