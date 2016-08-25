package com.formation.phva.exo;

import com.formation.etga.exo.main;

public class CleDico implements Comparable<CleDico> {
main
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
	public int compareTo(CleDico arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
