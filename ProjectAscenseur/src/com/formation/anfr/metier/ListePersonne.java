package com.formation.anfr.metier;

import java.util.ArrayList;
import java.util.Arrays;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<Personne> implements Runnable, InterListPersonne {
	private boolean sortie = false;

	public ListePersonne() {
		super();
	}

	@Override
	public void run() {
		while (!isSortie()) {
			try {
				Thread.sleep(500l + (long) Math.random() * 5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Personne p = new Personne();
			synchronized (this) {
				if (size() >= 0 && size() < 10) {
					add(p);
				}
				if (Personne.CPT > 2000)
					setSortie(true);
			}
		}

		// System.err.println(this.toString());
		// System.out.println(this.toString());

	}



	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public String toString() {
		String s = "";
		for (Personne p : this) {
			s += p.toString();
		}
		return s;
	}
	 
	@Override
	public void remove(InterPersonne p) {
		super.remove(p);
	}

}
