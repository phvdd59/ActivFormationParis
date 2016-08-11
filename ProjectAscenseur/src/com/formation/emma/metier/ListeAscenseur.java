package com.formation.emma.metier;

import java.util.ArrayList;

public class ListeAscenseur extends ArrayList<Ascenseur> {

	private ListePersonne lstP;

	public ListeAscenseur(ListePersonne lstP) {

		for (int i = 0; i < 6; i++) {
			Ascenseur ascenseur = new Ascenseur(lstP);
			add(ascenseur);
			ascenseur.start();
		}
	}

}
