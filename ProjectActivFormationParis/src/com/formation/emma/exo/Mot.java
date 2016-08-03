package com.formation.emma.exo;

import java.util.TreeMap;

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
	// tri les mots suivant le nombre de fois ou ils sortent et apres la longueur du mot
	public int compareTo(Mot o) {
		int res = -Integer.valueOf(getNb()).compareTo(Integer.valueOf(o.getNb())); // le "-" permet de faire du plus grd au plus petit
		if (res == 0) {
			res = getMot().compareTo(o.getMot());
		}
		return res;
	}

	@Override
	public void plusUn() {
		nb++;
	}

	@Override

	// compare sur la chaine de caractere et non sur l'occurence
	public boolean equals(Object obj) {
		boolean bRet = false;
		if (obj instanceof Mot) {
			Mot mMot = (Mot) obj;
			bRet = getMot().equals(mMot.getMot());
		}
		return bRet;
	}

	@Override
	public String toString() {
		return mot + " : " + nb;
	}
}
