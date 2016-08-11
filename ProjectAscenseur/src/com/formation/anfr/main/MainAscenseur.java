package com.formation.anfr.main;

import com.formation.anfr.metier.ListeAscenceur;
import com.formation.anfr.metier.ListePersonne;

public class MainAscenseur {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MainAscenseur main = new MainAscenseur();
		main.init();
		
	}

	private void init() {
		ListePersonne listePersonne = new ListePersonne();
		Thread thread1 = new Thread(listePersonne);
		thread1.	start();
		ListeAscenceur listeAsc = new ListeAscenceur(listePersonne);
	}
}
