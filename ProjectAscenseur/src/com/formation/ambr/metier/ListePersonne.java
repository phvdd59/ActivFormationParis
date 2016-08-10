package com.formation.ambr.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;

	public ListePersonne() {
	}

	@Override
	public void run() {
		//Personne personne0 = new Personne("Aristote", 0, 2, 5);
		//lst.add(personne0); // pas obligé de mettre le this
		//System.out.println(this);

		ArrayList<Personne> lst = new ArrayList<Personne>();

		sortie = false;
		while (!sortie) {
			try {
				int indxAb = (int) (Math.random() * 25);
				String ab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				int etDep = (int) (Math.random() * 19);
				int etArr = (int) (Math.random() * 19);
				int sleepTime = (int) (Math.random() * 10_000);
				Personne personne = new Personne(ab.substring(indxAb, indxAb + 1), ETAT.ETAT_ATTENTE.ordinal(), etDep, etArr);
				lst.add(personne);
				System.out.println(lst); // appelle le toString de Personne
				Thread.sleep(sleepTime);
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
		return "ListePersonne [sortie=" + sortie + "]";
	}

}
