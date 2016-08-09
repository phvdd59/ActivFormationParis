package com.formation.joca.metier;

import java.util.ArrayList;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;
	
	public ListePersonne() {
		this.sortie=false;
	}
	
	
	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}



	@Override
	public void run() {

	}


	@Override
	public String toString() {
		return "ListePersonne [sortie=" + sortie + "]";
	}
	
	
}
