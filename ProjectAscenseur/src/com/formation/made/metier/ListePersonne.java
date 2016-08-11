package com.formation.made.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

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
		while (!sortie) {
			long delais = (long) (Math.random() * 1000);
			try {
				Thread.sleep(delais);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Personne personne = new Personne();
			this.add(personne);
			if (personne.CPT > 2) {
				sortie = true;
			}
		}
		System.out.println(this);
	}
	
	public void remove(InterPersonne p){
		this.remove(p);
	}
}
