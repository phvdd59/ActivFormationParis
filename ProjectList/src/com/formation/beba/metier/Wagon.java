package com.formation.beba.metier;

public abstract class Wagon implements Comparable<Wagon> {

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

	@Override
	public int compareTo(Wagon w) {
		int[] ordreDeTri = { 3, 2, 0, 1 };
		if (ordreDeTri[getType()] < ordreDeTri[w.getType()]) {
			return -1;
		} else if (ordreDeTri[getType()] > ordreDeTri[w.getType()]) {
			return 1;
		} else {
			return 0;
		}
	}
}
