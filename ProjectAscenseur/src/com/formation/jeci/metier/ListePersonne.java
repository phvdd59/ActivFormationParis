package com.formation.jeci.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {

	private static final long serialVersionUID = 1L;

	private boolean sortie;

	public ListePersonne() {

		this.sortie = false;
	}

	@Override
	public void run() {
		try {
			while (!sortie) {
				long temps = (long) (Math.random() * 500);
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

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);
	}
}
