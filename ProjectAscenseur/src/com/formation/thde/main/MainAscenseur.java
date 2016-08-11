package com.formation.thde.main;

import com.formation.thde.metier.ListeAscenseur;
import com.formation.thde.metier.ListePersonne;

public class MainAscenseur {

	public static void main(String[] args) {

		MainAscenseur main = new MainAscenseur();
		main.init();
	}

	private void init() {
		ListePersonne listPersonne = new ListePersonne();
		ListeAscenseur listAscenseur = new ListeAscenseur(listPersonne);
		Thread thread = new Thread(listPersonne);
		thread.start();
	}
}
