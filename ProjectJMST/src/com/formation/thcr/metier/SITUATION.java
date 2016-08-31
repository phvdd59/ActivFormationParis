package com.formation.thcr.metier;

public enum SITUATION {
	SALARIE("Salarie"), AUTOENTREPRENEUR("auto entrepreneur"), FREELANCE("freelance"), DEMANDEUR(
			"demandeur d'emploi"), RETRAITE("retraite"), AUTRE("placeholder");

	private String nom;

	private SITUATION(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

}
