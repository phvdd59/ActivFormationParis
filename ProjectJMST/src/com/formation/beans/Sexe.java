package com.formation.beans;

import java.io.Serializable;

public class Sexe implements Serializable{

	private static final long serialVersionUID = 1L;
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
