package com.formation.thde.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterETAT;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	public boolean sortie;

	public ListePersonne() {
		//		 * faire un générateur de personnes aléatoires
		//		 * 		- étage de départ
		//		 * 		- étage d'arrivé
		//		 * 		création personne à des temps aléatoires
		//		 *  
		//		 * @param args
		this.sortie = sortie;
	}

	//______________________________
	//supprimer une personne ARRIVEE

	@Override
	public void run() {
		while (isSortie() == false) {
			try {
				Thread.sleep((long) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
			String nom = "personne " + Personne.CPT;
			InterETAT etat = ETAT.ATTENTE;
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (arrive == depart) {
				arrive = (int) (Math.random()) * 20;
			}
			this.add(new Personne(nom, etat, depart, arrive));
			System.err.println(new Personne(nom, etat, depart, arrive));
			if (Personne.CPT == 20) {
				sortie = true;
				System.err.println("FIN DE LA CREATION DE PERSONNE");
			} else {
				Personne.CPT++;
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
