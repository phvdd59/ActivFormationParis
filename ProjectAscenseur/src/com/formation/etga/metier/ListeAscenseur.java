package com.formation.etga.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;

public class ListeAscenseur extends ArrayList<Ascenseur> implements InterListeAscenseur {

	private InterListPersonne lstPersonne;

	public ListeAscenseur(ListePersonne lstPersonne) {

		this.lstPersonne = lstPersonne;
		int nbAscenseur = 6;
		for (int i = 1; i <= nbAscenseur; i++) {
			Ascenseur Ascenseur = new Ascenseur(lstPersonne);
			Ascenseur.setName("Ascenseur" + i);
			add(Ascenseur);
			Ascenseur.start();
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
