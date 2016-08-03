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
		int ret = -Integer.valueOf(getNb()).compareTo(Integer.valueOf(o.getNb()));
		if (ret == 0) {
			ret = getMot().compareTo(o.getMot());
		}

		return ret;
		//		int x = 0;
		//		if (getNb() < o.getNb()) {
		//			x = 1;
		//		} else if (getNb() > o.getNb()) {
		//			x = -1;
		//		} else {
		//			x = getMot().compareTo(o.getMot());
		//		}
		//		return x;
	}

	@Override
	public void plusUn() {
		nb++;

	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if (obj instanceof Mot) {
			Mot mot = (Mot) obj;
			b = this.getMot().equals(mot.getMot());
		}
		return b;
	}

	@Override
	public String toString() {
//		return getMot() + " , " + getNb()
		return mot;
	}
}
