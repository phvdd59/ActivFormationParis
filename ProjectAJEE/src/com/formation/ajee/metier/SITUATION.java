package com.formation.ajee.metier;

public enum SITUATION {
SALARIE("salarie"),AUTO_ENTREPRENEUR("auto entrepreneur"),FREELANCE ("freelance"),DEMANDEUR("demandeur d'emplois"),RETRAITE("retraite"),AUTRE("autre");

private String nom;

private SITUATION(String nom){
	this.nom=nom;
}

public String getNom() {
	return nom;
}

}
