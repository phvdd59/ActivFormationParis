package com.formation.etga.metier;

public abstract class WagonVoyageur extends Wagon {

	public WagonVoyageur() {
		super();
	}

	public WagonVoyageur(int nbSieges) {
		super(nbSieges);
		if (super.getNbSieges() < 40) {
			super.setNbSieges(40);
			//super.setLng(((float) nbSieges) / 4f);
		} else if (super.getNbSieges() > 200) {
			super.setNbSieges(200);
		}
	}

	public void setNbSieges(int nbSieges) {
		super.setNbSieges(nbSieges);
		if (nbSieges < 40) {
			super.setNbSieges(40);
		} else if (nbSieges > 200) {
			super.setNbSieges(200);
		}
	}
}
