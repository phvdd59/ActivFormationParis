package com.formation.beba.metier;

import java.util.ArrayList;
import java.util.Arrays;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	private boolean sortie;

	public void ListePeronne() {

		for (int i = 0; i < 20; i++) {

			this.add(new Personne());
		}
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
