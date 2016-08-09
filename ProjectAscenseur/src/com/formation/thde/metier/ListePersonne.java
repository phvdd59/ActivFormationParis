package com.formation.thde.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	private boolean sortie;

	public ListePersonne() {
//		 * faire un générateur de personnes aléatoires
//		 * 		- étage de départ
//		 * 		- étage d'arrivé
//		 * 		création personne à des temps aléatoires
//		 *  
//		 * @param args
		
		for (int i = 0; i < 20; i++) {
			String nom = "personne " + i;
			int etat = 0;
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (arrive == depart) {
				arrive = (int) (Math.random()) * 20;
			}
			this.add(new Personne(nom, etat, depart, arrive));
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
		return "ListePersonne [sortie=" + sortie + "]";
	}

}
