package com.formation.beba.exo;

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
		int compareCleD = 0;
		compareCleD = this.getLettre().compareTo(o.getLettre());
		if (compareCleD == 0) {
			if (this.getLngMot() < o.getLngMot()) {
				compareCleD = -1;
			} else {
				if (this.getLngMot() > o.getLngMot()) {
					compareCleD = 1;
				} else {
					compareCleD = 0;
				}
			}
		}
		return compareCleD;
	}

}
