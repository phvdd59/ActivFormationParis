package com.formation.frva.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {
	public static int FREQUENCE;
	public static int NBMAXPERS;
	private boolean sortie;

	@Override
	public void run() {
		while (!sortie){
			long delai = (long) Math.random()*FREQUENCE;
			try {
				Thread.sleep(delai);
			} catch (InterruptedException e) {
			}
			if (size()<20){
				Personne p = new Personne();
				add(p);
				System.out.println(p.toString());
				if (Personne.CPT == NBMAXPERS){
					sortie = true;
				}
			}
		}
	}

	public ListePersonne(boolean sortie) {
		this.sortie = sortie;
	}

	public boolean isSortie() {
		return sortie;
	}
	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}
	public void afficheListe(){
		for (int i = 0; i < size(); i++) {
			System.out.println(get(i));
		}
	}

}
