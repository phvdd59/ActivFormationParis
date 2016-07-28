package com.formation.joca.exo;

public class CleDico {

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

	public int compareTo(CleDico cle) {
		int result = 0;
		if (this.getLettre().compareTo(cle.getLettre()) != 0) {
			result = this.getLettre().compareTo(cle.getLettre());
		} else {
			if (this.getLngMot() > cle.getLngMot()) {
				result = -1;
			} else if (this.getLngMot() < cle.getLngMot()) {
				result = 1;
			}
		}
		return result;
	}
}