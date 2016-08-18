package com.formation.jeci.ctr;

public enum ENUMMATERIAUX {
	BOIS(0.6f,ENUMSOLIDITE.NORMAL,0),
	COMPENSE(0.9f,ENUMSOLIDITE.NORMAL,0),
	STRATIFIE(0.8f,ENUMSOLIDITE.NORMAL,0),
	PLASTIQUE(0.5f,ENUMSOLIDITE.NORMAL,0),
	CAOUTCHOUC(1.1f,ENUMSOLIDITE.NORMAL,0),
	BAMBOU(0.6f,ENUMSOLIDITE.FRAGILE,0),
	FER(7.4f,ENUMSOLIDITE.SOLIDE,0),
	BRONZE(9.2f,ENUMSOLIDITE.SOLIDE,0),
	TISSU(1.1f,ENUMSOLIDITE.SOLIDE,0),
	VERRE(2.5f,ENUMSOLIDITE.FRAGILE,0),
	CARTON(0.5f,ENUMSOLIDITE.FRAGILE,0),
	VIDE(0f,ENUMSOLIDITE.FRAGILE,0);
	
	
//	Les matériaux SOLIDE  sont : FER,BRONZE,TISSU
//	Les matériaux FRAGILE sont : VERRE,CARTON,VIDE,BAMBOU
//	 BOIS -> 0.6
//		- COMPENSE -> 0.9
//		- STRATIFIE -> 0.8
//		- FER -> 7.4
//		- BRONZE -> 9.2
//		- VERRE -> 2.5
//		- TISSU -> 1.1	
//		- CARTON -> 0.5
//		- VIDE -> 0
//		- PLASTIQUE -> 0.5
//		- CAOUTCHOUC -> 1.1
//		- BAMBOU -> 0.6
	private float densite;
	private ENUMSOLIDITE solidite;
	private int pourcent;

	private ENUMMATERIAUX(float densite, ENUMSOLIDITE solidite, int pourcent) {
		this.solidite=solidite;
		this.densite = densite;
		this.pourcent = pourcent;
	}

	public float getDensite() {
		return densite;
	}

	public void setDensite(float densite) {
		this.densite = densite;
	}

	public ENUMSOLIDITE getSolidite() {
		return solidite;
	}

	public void setSolidite(ENUMSOLIDITE solidite) {
		this.solidite = solidite;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}
}
