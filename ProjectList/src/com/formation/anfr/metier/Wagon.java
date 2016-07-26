package com.formation.anfr.metier;

public abstract class Wagon implements Comparable<Wagon>{
	public static final int WAGON_RESTO = 0;
	public static final int WAGON_SIMPLE1 = 1;
	public static final int WAGON_SIMPLE2 = 2;
	public static final int WAGON_DOUBLE = 3;

	public static int idIdentification = 0;

	private int id;
	private int nbSieges;
	private float lng;

	public Wagon() {
		this.id = idIdentification;
		idIdentification++;
		nbSieges = 80;
		lng = 20;
	}

	public Wagon(int nbSieges) {
		this.id = idIdentification;
		idIdentification++;
		setNbSieges(nbSieges);
		lng = ((float) nbSieges) / 4f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbSieges() {
		return nbSieges;
	}

	public void setNbSieges(int nbSieges) {
		if (nbSieges >= 0) {
			this.nbSieges = nbSieges;
			lng = ((float) nbSieges) / 4f;
		}
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Wagon " + id + " : (" + nbSieges + "," + lng + ")";
	}

	public abstract int getType();
	public abstract int getValeur();
	
	@Override
	public int compareTo(Wagon w) {
		if (this.getValeur() < w.getValeur()) {
			return -1;
		} else if (this.getValeur() > w.getValeur()) {
			return 1;
		} else {
			return 0;
		}
//		return toString().compareTo(w.toString());
	//	return Float.valueOf(getLng()).compareTo(Float.valueOf(w.getLng()));
	
	}
}
