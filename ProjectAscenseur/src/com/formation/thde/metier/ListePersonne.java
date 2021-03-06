package com.formation.thde.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterETAT;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<InterPersonne> implements Runnable, InterListPersonne {
	public boolean sortie;

	public ListePersonne() {
		//		 * faire un g�n�rateur de personnes al�atoires
		//		 * 		- �tage de d�part
		//		 * 		- �tage d'arriv�
		//		 * 		cr�ation personne � des temps al�atoires
		//		 *  
		//		 * @param args
		sortie=false;
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
			String nom = Integer.toString(Personne.CPT);
			InterETAT etat = ETAT.ATTENTE;
			int depart = (int) (Math.random() * 20);
			int arrive = (int) (Math.random() * 20);
			while (arrive == depart) {
				arrive = (int) (Math.random()) * 20;
			}
			this.add(new Personne(nom, etat, depart, arrive));
			if (Personne.CPT == 20) {
				sortie = true;
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

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);
	}

}
