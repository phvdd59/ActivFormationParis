package com.formation.issa.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class ListPersonne extends ArrayList<InterPersonne> implements Runnable, InterListPersonne {
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
					synchronized (this) {
						this.add(new Personne());
						System.out.println(this);
					}
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


	@Override
	public String toString() {
		return "ListPersonne [toString()=" + super.toString() + "]";
	}

	@Override
	public boolean isSortie() {
		// TODO Auto-generated method stub
		return sortie;
	}

	@Override
	public void remove(InterPersonne p) {
		super.remove(p);
		
	}
	

}
