package com.formation.jeci.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.mot = mot;
		this.nb = 1;
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
		int result = 0;
		if (this.getNb() < o.getNb()) {
			result = 1;
		} else if (this.getNb() > o.getNb()) {
			result = -1;
		} else if (this.getNb() == o.getNb()) {
			if (this.getMot().toString().compareTo(o.getMot().toString()) < 0) {
				result = this.getMot().toString().compareTo(o.getMot().toString());

			} else if (this.getMot().toString().compareTo(o.getMot().toString()) > 0) {
				result = this.getMot().toString().compareTo(o.getMot().toString());
			}

		}
		return result;
	}

	@Override
	public void plusUn() {
		nb += 1;

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {

		return "mot: " + mot + ", poids " + nb;
	}// a
}
