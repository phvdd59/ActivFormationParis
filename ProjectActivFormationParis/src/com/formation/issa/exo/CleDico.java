package com.formation.issa.exo;

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
		int retour = 0;
		if (this.lettre.equals(getLettre()) && this.lngMot==getLngMot()) {
			retour = 0;
		} else if (this.lettre.compareTo(getLettre()) < 0 && this.lngMot<getLngMot()) {
			retour = -1;
		} else {
			retour = 1;
		}

		return retour;

	}

}
