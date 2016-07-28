package com.formation.thde.exo;

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
		int result = 0;
		if (this.getLettre().compareTo(o.getLettre()) != 0) {
			result = this.getLettre().compareTo(o.getLettre());
		} else {
			if (this.getLngMot() > o.getLngMot()) {
				result = -1;
			} else if (this.getLngMot() < o.getLngMot()) {
				result = 1;
			}
		}
		return result;
	}
}
