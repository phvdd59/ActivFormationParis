package com.formation.thcr.metier;

public class Sexe {

	public static final String FEMININ = "feminin";
	public static final String MASCULIN = "masculin";

	private String sexe;
	
	public Sexe(String sexe) {
		this.sexe=sexe;

	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	
}
