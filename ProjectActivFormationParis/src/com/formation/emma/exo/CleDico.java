package com.formation.emma.exo;

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
}
