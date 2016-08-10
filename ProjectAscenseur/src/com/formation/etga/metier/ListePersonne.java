package com.formation.etga.metier;

import java.util.ArrayList;
import java.util.Collection;

public class ListePersonne extends ArrayList<Personne> implements Runnable {

	private boolean sortie;
	
	public ListePersonne() {
	}

	public boolean isSortie() {
		return sortie;
	}

	public void setSortie(boolean sortie) {
		this.sortie = sortie;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
