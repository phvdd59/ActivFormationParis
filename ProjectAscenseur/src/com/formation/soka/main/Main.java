package com.formation.soka.main;

import com.formation.soka.metier.ListeAscenseur;
import com.formation.soka.metier.ListePersonne;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.init();
	}

	private void init() {

		//InterPersonne p = new Personne(); // La on n'a que les méthodes de InterPersonne!! On n'instancie pas une interface

		ListePersonne listePersonne = new ListePersonne();
		Thread thread = new Thread(listePersonne, "ListePersonne");
		thread.start();

		ListeAscenseur listeAscenseur = new ListeAscenseur(listePersonne);
		//	Ascenseur ascenseur = new Ascenseur(listePersonne);
		//	ascenseur.start();
	}
}
