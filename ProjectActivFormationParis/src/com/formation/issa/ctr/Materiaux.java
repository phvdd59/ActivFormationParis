package com.formation.issa.ctr;

//Les matériaux SOLIDE  sont : FER,BRONZE,TISSU
//Les matériaux FRAGILE sont : VERRE,CARTON,VIDE,BAMBOU

public enum Materiaux {
	BOIS(0.6f, Solidite.normal, 75), 
	COMPENSE(0.9f, Solidite.normal, 85), 
	STRATIFIE(0.8f, Solidite.normal, 80), 
	FER(7.4f, Solidite.solide, 95), 
	BRONZE(9.2f, Solidite.solide, 95), 
	VERRE(2.5f, Solidite.fragile, 80), 
	TISSU(1.1f, Solidite.solide, 70), 
	CARTON(0.5f, Solidite.fragile, 65), 
	VIDE(0f, Solidite.fragile, 60), 
	PLASTIQUE(0.5f, Solidite.normal, 55), 
	CAOUTCHOUC(1.1f, Solidite.normal, 70), 
	BAMBOU(0.6f, Solidite.fragile, 95);

	private float densite;
	private Solidite solidite;
	private int pourcent;

	private Materiaux(float densite, Solidite solidite, int pourcent) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = pourcent;
	}

	public float getDensite() {
		return densite;
	}

	public void setDensite(float densite) {
		this.densite = densite;
	}

	public Solidite getSolidite() {
		return solidite;
	}

	public void setSolidite(Solidite solidite) {
		this.solidite = solidite;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}
}
