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
			Personne personne = new Personne(String.valueOf(nb), ETAT.ETAT_ATTENTE.ordinal(), (int) (Math.random() * 20),
					(int) (Math.random() * 20));
			System.out.println("j'ai créé la personne " + nb);
			this.add(personne);
			nb++;
		}

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
