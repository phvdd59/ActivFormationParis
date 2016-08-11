package com.formation.etga.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<InterPersonne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListePersonne() {
		sortie = false;
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
			long delais = (long) (Math.random() * 2000);
			try {
				Thread.sleep(delais);
			} catch (InterruptedException e) {
			}
			InterPersonne personne = new Personne();
			synchronized (this) {
				if (size() >= 0 && size() < 10) {
					add(personne);
					System.out.println(personne);
					if (Personne.CPT >= 20) {
						sortie = true;
						System.err.println("FIN DE CREATION DE PERSONNE");
					}
				}
			}
		}
	}

	@Override
	public void remove(InterPersonne personne) {
		super.remove(personne);
	}
}
