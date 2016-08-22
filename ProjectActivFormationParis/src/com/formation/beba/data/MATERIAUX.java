package com.formation.beba.data;

public enum MATERIAUX {
	BOIS(0.6f, SOLIDITE.NORMAL, 0), COMPENSE(0.9f, SOLIDITE.NORMAL, 0), //
	STRATIFIE(0.8f, SOLIDITE.NORMAL, 0), FER(7.4f, SOLIDITE.SOLIDE, 0), //
	BRONZE(9.2f, SOLIDITE.SOLIDE, 0), VERRE(2.5f, SOLIDITE.FRAGILE, 0), //
	TISSU(1.1f, SOLIDITE.SOLIDE, 0), CARTON(0.5f, SOLIDITE.FRAGILE, 0), //
	VIDE(0f, SOLIDITE.FRAGILE, 0), PLASTIQUE(0.5f, SOLIDITE.NORMAL, 0), //
	CAOUTCHOUC(1.1f, SOLIDITE.NORMAL, 0), BAMBOU(0.6f, SOLIDITE.FRAGILE, 0);

	private int pourcent;
	private final float densite;
	private final SOLIDITE solidite;

	private MATERIAUX(float densite, SOLIDITE solidite, int pourcent) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = pourcent;
	}

	public void setPourcent(int pourcent) {
		if (pourcent >= 0 && pourcent <= 100) {
			this.pourcent = pourcent;
		}

	}

}