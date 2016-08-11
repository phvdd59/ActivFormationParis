package com.formation.etga.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;


public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListePersonne() {
		sortie = false;
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public void run() {
		while (!sortie) {
			long delais = (long) (Math.random() * 5000);
			try {
				Thread.sleep(delais);
			} catch (InterruptedException e) {
			}
			Personne personne = new Personne();
			synchronized (this) {
				if (size() >= 0 && size() < 10) {
					add(personne);
					if (Personne.CPT >= 200) {
						sortie = true;
					}
				}
			}
		}
	}
}
