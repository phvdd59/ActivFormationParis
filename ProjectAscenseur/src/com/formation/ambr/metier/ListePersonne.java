package com.formation.ambr.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListePersonne() {
		sortie = false;
	}

	@Override
	public void run() {

		sortie = false;
		while (!sortie) {
			try {
				long sleepTime = (long) (Math.random() * 5_000);
				Personne personne = new Personne();
				personne.CPT++;
				//this.add(personne);

				synchronized (this) {
					if (size() >= 0 && size() < 10) {
						this.add(personne);
						if (personne.CPT >= 200) {
							sortie = true;
						}
					}
				}

				System.out.println(personne);
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
	public void remove(InterPersonne p) {
		super.remove(p);
	}
}
