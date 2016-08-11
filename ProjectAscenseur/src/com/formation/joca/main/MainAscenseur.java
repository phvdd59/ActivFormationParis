package com.formation.joca.main;

import com.formation.joca.metier.ListeAscenseur;
import com.formation.joca.metier.ListePersonne;

public class MainAscenseur {
	public static void main(String[] args) {

		ListePersonne lst = new ListePersonne();
		Thread essai = new Thread(lst);
		essai.start();
		try {
			Thread.currentThread().sleep(30000);
		} catch (InterruptedException e) {
		}
		lst.setSortie(true);
		ListeAscenseur lstAsc = new ListeAscenseur(lst);

	}
}
