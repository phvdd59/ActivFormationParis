package com.formation.emma.exo;

public enum MATERIAUX {

	FER(7.4f, SOLIDITE.SOLIDE), BRONZE(9.2f, SOLIDITE.SOLIDE), TISSU(1.1f, SOLIDITE.SOLIDE),

	VERRE(2.5f, SOLIDITE.FRAGILE), CARTON(0.5f, SOLIDITE.FRAGILE), VIDE(0f, SOLIDITE.FRAGILE), BAMBOU(0.6f, SOLIDITE.FRAGILE),

	BOIS(0.6f, SOLIDITE.NORMAL), COMPENSE(0.9f, SOLIDITE.NORMAL), STRATIFIE(0.8f, SOLIDITE.NORMAL), PLASTIQUE(0.5f, SOLIDITE.NORMAL), CAOUTCHOUC(1.1f, SOLIDITE.NORMAL);

	private float densite;
	private SOLIDITE solidite;
	private int pourcent;

	private MATERIAUX(float densite, SOLIDITE solidite, int pourcent) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = pourcent;
	}

	private MATERIAUX(float densite, SOLIDITE solidite) {
		this.densite = densite;
		this.solidite = solidite;
	}

	public float getDensite() {
		return densite;
	}

	public void setDensite(float densite) {
		this.densite = densite;
	}

	public SOLIDITE getSolidite() {
		return solidite;
	}

	public void setSolidite(SOLIDITE solidite) {
		this.solidite = solidite;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}

}
