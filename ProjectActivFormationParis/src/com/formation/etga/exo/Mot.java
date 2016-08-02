package com.formation.etga.exo;

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
		int result = 0;
		if (this.getNb() > o.getNb()) {
			result = -1;
		} else if (this.getNb() < o.getNb()) {
			result = 1;
		} else {
			result = this.getMot().toString().compareTo(o.getMot().toString());
		}
		return result;
	}

	@Override
	public void plusUn() {
		nb += 1;

	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Mot mot = (Mot) obj;
		if (this.getMot().equals(mot.getMot())) {
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Le mot : " + mot + ", a un poids de " + nb;
	}
}
