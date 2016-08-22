package com.formation.anfr.ctr;

public class MeubleExo5 implements Comparable<MeubleExo5> {

	private String reference;
	private int nbVendu;

	public MeubleExo5(String lettre, int nbVendu) {
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
	public int compareTo(MeubleExo5 o) {
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
		if ((obj instanceof MeubleExo5)) {
			if (this.getRef().equals(((MeubleExo5) obj).getRef())) {
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