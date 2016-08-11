package com.formation.beba.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<Personne>implements Runnable, InterListPersonne {
	private boolean sortie;

	public void ListePeronne() {
		sortie = false;
	}

	@Override
	public void run() {
		while (!sortie) {
			long delais = (long) (Math.random() * 5000);
			try {
				Thread.sleep(delais);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.add(new Personne());
			if (Personne.CPT >= 770) {
				sortie = true;
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

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);

	}

}
