package com.formation.beba.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.mot = mot;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	@Override
	public int compareTo(Mot o) {
		int renvoi = 0;
		if (this.nb < getNb()) {
			renvoi = 1;
		} else if (this.nb > getNb()) {
			renvoi = -1;
		} else if (this.nb == getNb()) {
			renvoi = (int) this.toString().compareTo(o.toString());
		}
		return renvoi;
	}

	@Override
	public void plusUn() {
		nb++;

	}

	@Override
	public boolean equals(Object obj) {
		return this.getMot().equals((Mot) obj);
	}

	@Override
	public String toString() {

		return this.mot.toString();
	}
}
