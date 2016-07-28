package com.formation.thde.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.mot = mot;
		nb = 1;
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
		if (this.getNb() > o.getNb()) {
			result = -1;
		} else if (this.getNb() < o.getNb()) {
			result = 1;
		} else {
			result = (int) this.getMot().compareTo(o.getMot());
		}
		return result;
	}

	@Override
	public void plusUn() {
		this.nb += 1;

	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Mot temp = (Mot) obj;
		if (this.getMot().equals(temp.getMot())) {
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return "[" + mot +" "+ nb + "]";
	}
}
