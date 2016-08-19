package com.formation.anfr.ctr;

public enum MATERIAUX {
	BOIS((float) 0.6, SOLIDITE.NORMAL), COMPENSE((float) 0.9, SOLIDITE.NORMAL), STRATIFIE((float) 0.8, SOLIDITE.NORMAL), FER((float) 7.4,
			SOLIDITE.SOLIDE), BRONZE((float) 9.2, SOLIDITE.SOLIDE), VERRE((float) 2.5, SOLIDITE.FRAGILE), TISSU((float) 1.1,
					SOLIDITE.SOLIDE), CARTON( (float)0.5, SOLIDITE.FRAGILE), VIDE(0, SOLIDITE.FRAGILE), PLASTIQUE((float) 0.5,
							SOLIDITE.NORMAL), CAOUTCHOUC((float) 1.1, SOLIDITE.NORMAL), BAMBOU((float) 0.6, SOLIDITE.FRAGILE);
	
	private final float densite;
	private final SOLIDITE solidite;
	private int pourcent;
	
	private MATERIAUX(float f, SOLIDITE sol){
		this.densite = f;
		this.solidite = sol;
	}


	public int getPourcent() {
		return pourcent;
	}

	public void setPourcent(int pourcent) {
		this.pourcent = pourcent;
	}


	public float getDensite() {
		return densite;
	}


	public SOLIDITE getSolid() {
		return solidite;
	}

}
