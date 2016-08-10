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
		this.sortie = sortie;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			String nom = "personne " + i;
			int etat = 0;
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (arrive == depart) {
				arrive = (int) (Math.random()) * 20;
			}
			//System.out.println(new Personne(nom, etat, depart, arrive));
			this.add(new Personne(nom, etat, depart, arrive));
			Personne.CPT++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
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
		return "ListePersonne [sortie=" + sortie + "]";
	}

}
