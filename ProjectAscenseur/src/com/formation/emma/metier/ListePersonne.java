package com.formation.emma.metier;

import java.util.ArrayList;
import java.util.Collections;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;

	public ListePersonne() {
	}

	@Override
	public void run() {

		while (!sortie) {
			try {
				long tpsAttente = (long) (Math.random() * 5);
				Thread.sleep(tpsAttente);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Personne personne = new Personne();
			add(personne);
			if (personne.CPT >= 200) {
				setSortie(true);
			}
		}
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

}
