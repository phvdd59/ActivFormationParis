package com.formation.jeci.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean sortie;

	public ListePersonne() {

		this.sortie = false;
	}

	@Override
	public void run() {
		try {
			while (Personne.CPT < 10) {
				long temps = (long) (Math.random() * 2000);
				Personne a = new Personne();
				synchronized (this) {
					this.add(a);
				}

				Thread.sleep(temps);
			}
			System.out.println(this);
		} catch (Exception e) {

			e.printStackTrace();
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
}
