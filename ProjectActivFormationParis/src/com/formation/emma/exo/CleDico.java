package com.formation.emma.exo;



public class CleDico implements Comparable<CleDico> {

	private String lettre;
	private int lngMot;

	public CleDico(String lettre, int lngMot) {
		super();
		this.lettre = lettre;
		this.lngMot = lngMot;
	}

	public String getLettre() {
		return lettre;
	}

	public void setLettre(String lettre) {
		this.lettre = lettre;
	}

	public int getLngMot() {
		return lngMot;
	}

	public void setLngMot(int lngMot) {
		this.lngMot = lngMot;
	}

	@Override
	public int compareTo(CleDico o) {
		if (getLettre().compareTo(o.getLettre()) < 0) {
			return -1;
		} else if (getLettre().compareTo(o.getLettre()) > 0) {
			return 1;
		} else if (getLettre().compareTo(o.getLettre()) == 0) {
			if (getLngMot() < o.getLngMot()) {
				return -1;
			} else if (getLngMot() > o.getLngMot()) {
				return 1;
			} else if (getLngMot() == o.getLngMot()) {
				return 0;
			}
		}
		return 0;
	}
}
