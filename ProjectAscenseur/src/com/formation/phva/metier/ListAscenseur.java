package com.formation.phva.metier;

import java.util.ArrayList;

public class ListAscenseur extends ArrayList<Ascenseur> {

	private ListePersonne listePersonne;

	public ListAscenseur(ListePersonne listePersonne) {
		this.listePersonne = listePersonne;
		for (int i = 0; i < 1; i++) {
			Ascenseur ascenseur = new Ascenseur(listePersonne);
			add(ascenseur);
			ascenseur.start();
		}
	}

}
