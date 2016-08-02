package com.formation.made.exo;

import com.formation.phva.exo.InterExoMot1;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.mot = mot;
		nb=1;
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
	public int compareTo(Mot o) {// longeur du mot si c'est superieur c'est positif, si c'est inférieur c'est négatif, si c'est égal c'est 0
		int res = -Integer.valueOf(getNb()).compareTo((Integer.valueOf(o.getNb()))); // c'est pour trier l'arrayliste de ot l'array liste. on met un met car en temps normal il classe du plus petit au plus grand et la on veut du plus grand au plus petit.
		if (res == 0) {
			res = getMot().compareTo(o.getMot());
		}
		return res;

	}

	@Override
	public void plusUn() {
		this.nb++;

	}

	@Override
	public boolean equals(Object obj) {
		boolean egaux = false;
		if (obj instanceof Mot) {
			Mot objet = (Mot) obj;
			if (this.getMot() == objet.getMot()) {
				egaux = true;
			}
		}
		return egaux;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
