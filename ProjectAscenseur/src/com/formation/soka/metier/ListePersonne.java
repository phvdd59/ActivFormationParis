package com.formation.soka.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<InterPersonne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListePersonne() {
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

			InterPersonne p = new Personne();
			synchronized (this) {
				if (size() >= 0 && size() < 10) {
					add(p);
					System.out.println("nom : " + p.getNom() + " Etat : " + p.getEtat() + " Depart : " + p.getDepart() + " Arrive : " + p.getArrivee());
					if (Personne.CPT >= 200) {
						sortie = true;
					}
				}
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
	public void remove(InterPersonne p) {
		super.remove(p);
	}
}
