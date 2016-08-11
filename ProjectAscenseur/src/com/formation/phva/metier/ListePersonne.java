package com.formation.phva.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	public boolean sortie;

	public ListePersonne() {
		sortie = false;
		//		for (int i = 0; i < 2; i++) {
		//			add(new Personne());
		//		}
	}

	@Override
	public void run() {
		while (!sortie) {
			long delais = (long) (Math.random() * 5000);
			try {
				Thread.sleep(delais);
			} catch (InterruptedException e) {
			}
			Personne p = new Personne();
			synchronized (this) {
				if (size() >= 0 && size() < 10) {
					add(p);
					if (Personne.CPT >= 200) {
						sortie=true;
					}
				}
			}
		}
		
	}
}
