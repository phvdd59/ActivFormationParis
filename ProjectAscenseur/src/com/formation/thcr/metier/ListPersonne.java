package com.formation.thcr.metier;

import java.util.ArrayList;

public class ListPersonne extends ArrayList<Personne> implements Runnable {
	
	private boolean sortie;
	
	public ListPersonne() {

	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public void run() {

	}

	@Override
	public String toString() {
		return null;
	}

}
