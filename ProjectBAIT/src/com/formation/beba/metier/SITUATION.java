package com.formation.beba.metier;

public enum SITUATION {
	SALARIE("Salarie"), AUTOENTREPRENEUR("auto entrepreneur"), FREELANCE("freelance"), DEMANDEUR(
			"demandeur d'emploi"), RETRAITE("retraite"), AUTRE("");

	private String nom;

	private SITUATION(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

}
