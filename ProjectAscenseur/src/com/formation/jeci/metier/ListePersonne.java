package com.formation.jeci.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean sortie;

	public ListePersonne(boolean sortie) {
		super();
		this.sortie = sortie;
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

		return super.toString();
	}
}
