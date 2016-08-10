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
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (depart == arrive) {
				arrive = (int) (Math.random() * 20);
			}

			Personne personne = new Personne(Integer.toString(Personne.CPT), ETAT.ETAT_ATTENTE.ordinal(), depart,
					arrive);
			System.out.println("j'ai créé la personne " + nb);

			synchronized (this) {
				this.add(personne);
			}

			try {
				Thread.currentThread().sleep((int) (Math.random() * 5000));
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
