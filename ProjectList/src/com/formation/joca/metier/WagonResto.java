package com.formation.joca.metier;

public class WagonResto extends Wagon {

	private float lngResto;

	public WagonResto() {
		super();
		lngResto = 3 * getLng() / 4;
		super.setNbSieges(super.getNbSieges() * 1 / 4);
		setLng(getLng()*4);
	}
	
	public WagonResto(int nbSieges) {
		super(nbSieges);
		lngResto = 3 * getLng() / 4;
		super.setNbSieges(super.getNbSieges() * 1 / 4);
		setLng(getLng()*4);
	}

	public WagonResto(int nbSieges,float lngResto) {
		super(nbSieges);
		this.lngResto = lngResto;
		float rapport=1f-lngResto/super.getLng();
		super.setNbSieges((int)((float)super.getNbSieges() * rapport));
		setLng(getLng()*4);
	}


	public float getLngResto() {
		return lngResto;
	}

	public void setLngResto(float lngResto) {
		this.lngResto = lngResto;
	}
	
	public float getLng() {
		return super.getLng();
	}

	@Override
	public String toString() {
		return "WAGON RESTO  : "+super.toString();
	}
	
	@Override
	public int getType() {
		return Wagon.WAGON_RESTO;
	}
}
