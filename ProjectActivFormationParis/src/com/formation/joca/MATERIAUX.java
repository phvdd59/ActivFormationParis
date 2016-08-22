package com.formation.joca;

@SuppressWarnings("unused")
public enum MATERIAUX {
	BOIS(0.6f, SOLIDITE.NORMAL, 0), //
	COMPENSE(0.9f, SOLIDITE.NORMAL, 0), //
	STRATIFIE(0.8f, SOLIDITE.NORMAL, 0), //
	FER(7.4f, SOLIDITE.SOLIDE, 0), //
	BRONZE(9.2f, SOLIDITE.SOLIDE, 0), //
	VERRE(2.5f, SOLIDITE.FRAGILE, 0), //
	TISSU(1.1f, SOLIDITE.SOLIDE, 0), //
	CARTON(0.5f, SOLIDITE.FRAGILE, 0), //
	VIDE(0, SOLIDITE.FRAGILE, 0), //
	PLASTIQUE(0.5f, SOLIDITE.NORMAL, 0), //
	CAOUTCHOU(1.1f, SOLIDITE.NORMAL, 0), //
	BAMBOU(0.6f, SOLIDITE.FRAGILE, 0);

	private final float densite;
	private final SOLIDITE solidite;
	private int qte;

	private MATERIAUX(float densite, SOLIDITE solidite, int pourcent) {
		this.densite = densite;
		this.solidite = solidite;
		this.qte = pourcent;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getDensite() {
		return densite;
	}

	public SOLIDITE getSolidite() {
		return solidite;
	}

}
