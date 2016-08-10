package com.formation.ambr.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;

	public ListePersonne() {
		sortie = false;
	}

	@Override
	public void run() {
		//Personne personne0 = new Personne("Aristote", 0, 2, 5);
		//lst.add(personne0); // pas obligé de mettre le this
		//System.out.println(this); // print une liste vide

		sortie = false;
		while (!sortie) {
			try {
				int indxAb = (int) (Math.random() * 25);
				String ab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				int etDep = (int) (Math.random() * 19);
				int etArr = (int) (Math.random() * 19);
				long sleepTime = (long) (Math.random() * 5_000);
				Personne personne = new Personne(ab.substring(indxAb, indxAb + 1), ETAT.ATTENTE.ordinal(), etDep, etArr);
				personne.CPT++;
				//this.add(personne);
				
				synchronized (this) {
					if (size()>=0 && size()<10) {
						this.add(personne);
						if (personne.CPT>=200) {
							sortie=true;
						}
					}
				}
				System.out.println(this);
				System.out.println(personne.CPT);
				//System.out.println(personne);
				
				//System.out.println(this.toString()); // si on laisse le toString de cette classe, quand on lui demande de print this.toString, il print sortie = false
				//System.out.println(this); // appelle le toString de Personne. On aurait pu écrire this.toString(), ou juste toString()
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	//		@Override
	//		public String toString() {
	//			return "ListePersonne [sortie=" + sortie + "]";
	//		}

}
