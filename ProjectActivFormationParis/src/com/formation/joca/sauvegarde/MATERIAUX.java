package com.formation.joca.sauvegarde;

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
	private int pourcent;

	private MATERIAUX(float densite, SOLIDITE solidite, int qte) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = qte;
	}

	public int getQte() {
		return pourcent;
	}

	public void setQte(int pourcent) {
		this.pourcent = pourcent;
	}

	public float getDensite() {
		return densite;
	}

	public SOLIDITE getSolidite() {
		return solidite;
	}

}
