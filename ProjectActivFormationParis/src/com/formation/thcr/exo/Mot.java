package com.formation.thcr.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String	mot;
	private int		nb;

	public Mot(String mot) {

		this.setMot(mot);
		this.plusUn();
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
		int r = 0;
		if (this.getNb() < o.getNb())
			r = 1;
		else if (this.getNb() > o.getNb())
			r = -1;
		else
			r = this.toString().compareTo(o.getMot().toString());
		return r;
	}

	@Override
	public void plusUn() {
		this.nb++;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Mot) {
			Mot mot = (Mot) obj;
			b = this.getMot().toString().equals(mot.getMot().toString());
		}
		return b;
	}

	@Override
	public String toString() {
		return this.mot;
	}
}
