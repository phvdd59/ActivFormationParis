package com.formation.soka.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		// TODO 
		this.mot = mot;
		plusUn();
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void plusUn() {
		// TODO Auto-generated method stub
		nb++;

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
		// TODO Auto-generated method stub
		return mot;
	}
}
