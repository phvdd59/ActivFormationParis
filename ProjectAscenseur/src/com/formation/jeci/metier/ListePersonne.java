package com.formation.jeci.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private static final long serialVersionUID = 1L;

	private boolean sortie;

	public ListePersonne() {
		
		this.sortie = false;
	}

	public Personne genererUnePersonneAle() {
		String nom = Integer.toString(Personne.CPT);
		int etat = 0;
		int depart = (int) (Math.random() * 20);
		int arrive = (int) (Math.random() * 20);
		while (depart == arrive) {
			arrive = (int) (Math.random() * 20);

		}
		Personne.CPT++;

		Personne per = new Personne(nom, etat, depart, arrive);
		return per;

	}

	@Override
	public void run() {
		try {
			while (Personne.CPT<10) {
				long temps = (long) (Math.random() * 2000);
				Personne a = genererUnePersonneAle();
			synchronized (this) {
				this.add(a);
			}
				

				Thread.sleep(temps);
			}System.out.println(this);
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
