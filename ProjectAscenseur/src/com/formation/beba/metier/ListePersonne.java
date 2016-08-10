package com.formation.beba.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne>implements Runnable {
	private boolean sortie;

	public void ListePeronne() {
	}

	@Override
	public void run() {
		this.add(new Personne());
		this.add(new Personne());
		this.add(new Personne());
		this.add(new Personne());
		this.add(new Personne());
		this.add(new Personne());
		for (int i = 0; i < 20; i++) {
			this.add(new Personne());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
