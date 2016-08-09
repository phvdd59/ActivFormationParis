package com.formation.thde.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	private boolean sortie;

	public ListePersonne() {

	}

	@Override
	public void run() {
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public String toString() {
		return "ListePersonne [sortie=" + sortie + "]";
	}

}
