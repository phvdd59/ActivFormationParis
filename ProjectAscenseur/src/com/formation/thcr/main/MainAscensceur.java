package com.formation.thcr.main;

import com.formation.thcr.metier.ListAscenseur;
import com.formation.thcr.metier.ListPersonne;

public class MainAscensceur {

	public static void main(String[] args) {
		MainAscensceur main = new MainAscensceur();
		main.init();
	}

	private void init() {

		ListPersonne listPersonne = new ListPersonne();
		Thread listPersonneThread = new Thread(listPersonne, "LISTE DE PERSONNE");
		listPersonneThread.start();
		ListAscenseur listAscenseur = new ListAscenseur(listPersonne);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!listPersonne.isEmpty()) {
		}
		System.out.println("FIN main");
	}
}
