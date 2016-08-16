package com.formation.anfr.ctr;

public class Meuble implements Comparable<Meuble> {

	private String reference;
	private int nbVendu;

	public Meuble(String lettre, int nbVendu) {
		super();
		this.reference = lettre;
		this.nbVendu = nbVendu;
	}

	public void plusUn() {
		nbVendu++;
	}

	public String getRef() {
		return reference;
	}

	public void setRef(String lettre) {
		this.reference = lettre;
	}

	public int getNbVendu() {
		return nbVendu;
	}

	public void setnbVendu(int nbVendu) {
		this.nbVendu = nbVendu;
	}

	@Override
	public int compareTo(Meuble o) {
		int compare = 0;
		if (this.getNbVendu() > o.getNbVendu()) {
			compare = -1;
		} else if (this.getNbVendu() < o.getNbVendu()) {
			compare = 1;
		}
		return compare;
	}

	@Override
	public boolean equals(Object obj) {
		boolean egal = false;
		if ((obj instanceof Meuble)) {
			if (this.getRef().equals(((Meuble) obj).getRef())) {
				egal = true;
			}
		}
		return egal;
	}

	@Override
	public String toString() {
		return "Meuble [" + reference + ",  " + nbVendu + "]";
	}

}