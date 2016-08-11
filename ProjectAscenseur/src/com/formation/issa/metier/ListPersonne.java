package com.formation.issa.metier;

import java.util.ArrayList;

public class ListPersonne extends ArrayList<Personne> implements Runnable {
	private boolean sortie;

	public ListPersonne() {
		Personne personne = new Personne();
		sortie = false;

	}

	@Override
	public void run() {

		while (!sortie) {
			if (this.size() < 50) {

				try {

					this.add(new Personne());
					long temps = (long) (Math.random() * 3000);
					Thread.sleep(temps);
					if (this.size() != 0 && this.size()!=1) {
						System.out.println(this.get(this.size() - 1));
					} else {
						System.out.println(" ");
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Personne.CPT >= 200) {
				sortie = true;
			}

		}

	}

	boolean issortie() {

		return sortie;
	}

	@Override
	public String toString() {
		return "ListPersonne [toString()=" + super.toString() + "]";
	}

}
