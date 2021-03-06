package com.formation.thde.metier;

public class WagonDouble extends WagonVoyageur {
	public WagonDouble() {
		super();
		super.setLng(super.getLng() / 2f);
	}

	public WagonDouble(int nbSieges) {
		super(nbSieges);
		super.setLng(super.getLng() / 2);
	}

	public void setNbSieges(int nbSieges) {
		super.setNbSieges(nbSieges);
		setLng(getLng() / 2f);
	}

	@Override
	public int getType() {
		return TypeWagon.WAGON_DOUBLE.getType();
	}

	@Override
	public String toString() {
		return "WAGON DOUBLE : " + super.toString();
	}

}
