package com.formation.joca.ctr;

public enum Materiaux {

	BOIS((float) 0.6, Solidite.NORMAL), // -> 0.6
	COMPENSE((float) 0.9, Solidite.NORMAL), // -> 0.9
	STRATIFIE((float) 0.8, Solidite.NORMAL), // -> 0.8
	FER((float) 7.4, Solidite.SOLIDE), // solide-> 7.4
	BRONZE((float) 9.2, Solidite.SOLIDE), // solide -> 9.2
	VERRE((float) 2.5, Solidite.FRAGILE), // fragile -> 2.5
	TISSU((float) 1.1, Solidite.SOLIDE), // solide-> 1.1
	CARTON((float) 0.5, Solidite.FRAGILE), // fragile -> 0.5
	VIDE(0, Solidite.FRAGILE), // fragile-> 0
	PLASTIQUE((float) 0.5, Solidite.NORMAL), // -> 0.5
	CAOUTCHOUC((float) 1.1, Solidite.NORMAL), // -> 1.1
	BAMBOU((float) 0.6, Solidite.FRAGILE);// fragile-> 0.6

	private float densite;
	private Solidite solidite;
	private int pourcent;

	Materiaux(float densite, Solidite solidite) {
		this.densite = densite;
		this.solidite = solidite;
		this.pourcent = 0;
	}

	public void setPourcent(int pourcent) {
		if (pourcent >= 0 && pourcent <= 100) {
			this.pourcent = pourcent;
		}
	}
}
