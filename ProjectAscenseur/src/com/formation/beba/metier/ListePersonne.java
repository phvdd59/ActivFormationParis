package com.formation.beba.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne>implements Runnable {
	private boolean sortie;

	public void ListePeronne() {
		sortie = false;
	}

	@Override
	public void run() {
		int ct = 0;
		while (!sortie) {
			long delais = (long) (Math.random() * 5000);
			try {
				Thread.sleep(delais);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.add(new Personne());
			if (Personne.CPT >= 20) {
				sortie = true;
			}
		}

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
