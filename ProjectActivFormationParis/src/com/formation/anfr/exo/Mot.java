package com.formation.anfr.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.setMot(mot);
		setNb(1);
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
		int compare = 0;
		if (this.getNb() > o.getNb()){
			compare = -1;
		} else if (this.getNb() < o.getNb()) {
			compare = 1;
		} else {
			compare =this.getMot().compareTo(o.getMot());
		}
		return compare;
	}

	@Override
	public void plusUn() {
		nb++;		
	}

	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (this.getClass().equals(obj.getClass())) {
			bool = this.getMot().equals(((Mot) obj).getMot());
		}
		return bool;
	}

	@Override
	public String toString() {
		return getMot()+ "("+getNb()+")";
	}
}
