package com.formation.thcr.metier;

import java.util.ArrayList;

public class ListPersonne extends ArrayList<Personne> implements Runnable {

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
			synchronized (this) {
				if (this.size() >= 0 && this.size() < 20) {
					this.add(new Personne());
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
		for (Personne personne : this) {
			s += personne.toString();
		}
		return s;
	}

}
