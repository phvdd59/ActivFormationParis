package com.formation.thde.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	private boolean sortie;

	public ListePersonne() {
		//		 * faire un g�n�rateur de personnes al�atoires
		//		 * 		- �tage de d�part
		//		 * 		- �tage d'arriv�
		//		 * 		cr�ation personne � des temps al�atoires
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
