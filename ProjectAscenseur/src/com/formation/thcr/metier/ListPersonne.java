package com.formation.thcr.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListPersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

	private boolean sortie;

	public ListPersonne() {
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
			long randomSleepTime = (long) (Math.random() * 3000);
			try {
				Thread.sleep(randomSleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Personne personne = new Personne();
			synchronized (this) {
				if (this.size() >= 0 && this.size() < 20) {
					this.add(personne);
				}
				if (Personne.CPT > 40) {
					this.setSortie(true);
				}
			}
		}
		System.out.println("FIN ListPersonne");
	}

	@Override
	public String toString() {
		String s = "";
		for (InterPersonne personne : this) {
			s += personne.toString();
		}
		return s;
	}

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);

	}

}
