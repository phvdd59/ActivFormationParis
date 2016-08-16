package com.formation.jeci.ctr;

public class Poids implements Comparable<Poids> {
	private String mot;
	private int nb;

	public Poids(String mot) {
		this.setMot(mot);
		this.setNb(1);
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
	public int compareTo(Poids o) {
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

}
