package com.formation.emma.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;

public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListePersonne() {
	}

	@Override
	public void run() {

		while (!sortie) {
			try {
				long tpsAttente = (long) (Math.random() * 1000);
				Thread.sleep(tpsAttente);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Personne personne = new Personne();
			add(personne);
			if (personne.CPT >= 50) {
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
