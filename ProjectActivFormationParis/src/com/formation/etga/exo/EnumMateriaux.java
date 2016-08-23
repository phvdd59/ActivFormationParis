package com.formation.etga.exo;

public enum EnumMateriaux {
	BOIS(0.6f, EnumSolidite.NORMAL, 0), //
	COMPENSE(0.9f, EnumSolidite.NORMAL, 0), //
	STRATIFIE(0.8f, EnumSolidite.NORMAL, 0), //
	FER(7.4f, EnumSolidite.SOLIDE, 0), //
	BRONZE(9.2f, EnumSolidite.SOLIDE, 0), //
	VERRE(2.5f, EnumSolidite.FRAGILE, 0), //
	TISSU(1.1f, EnumSolidite.SOLIDE, 0), //
	CARTON(0.5f, EnumSolidite.FRAGILE, 0), //
	VIDE(0f, EnumSolidite.FRAGILE, 0), //
	PLASTIQUE(0.5f, EnumSolidite.NORMAL, 0), //
	CAOUTCHOUC(1.1f, EnumSolidite.NORMAL, 0), //
	BAMBOU(0.6f, EnumSolidite.FRAGILE, 0); //

	private float densite;
	private EnumSolidite solidite;
	private int pourcent;

	private EnumMateriaux(float densite, EnumSolidite solidite, int pourcent) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = pourcent;
	}

	public float getDensite() {
		return densite;
	}

	public EnumSolidite getSolidite() {
		return solidite;
	}

	public int getPourcent() {
		return pourcent;
	}

	public void setDensite(float densite) {
		this.densite = densite;
	}

	public void setSolidite(EnumSolidite solidite) {
		this.solidite = solidite;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}
}
