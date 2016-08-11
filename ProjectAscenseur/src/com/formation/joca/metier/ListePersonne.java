package com.formation.joca.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;

	public ListePersonne() {
		this.sortie = false;
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public void run() {
		int nb = 0;
		while (!sortie) {

			Personne personne = new Personne();

			synchronized (this) {
				this.add(personne);
			}

			try {
				Thread.currentThread().sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}

			nb++;
		}

	}

	@Override
	public String toString() {
		for (Personne per : this) {
			System.out.println(per.toString());
		}
		return "";
	}

}
