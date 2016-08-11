package com.formation.frva.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListePersonne extends ArrayList<InterPersonne> implements Runnable, InterListPersonne {
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

	public ListePersonne() {
		this.sortie = false;
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

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);
	}

}
