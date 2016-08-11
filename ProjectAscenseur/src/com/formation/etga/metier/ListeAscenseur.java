package com.formation.etga.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private InterListPersonne lstPersonne;
	private InterAffichage affichage;

	public ListeAscenseur(ListePersonne lstPersonne) {

		this.lstPersonne = lstPersonne;
		affichage = new Affichage(this);
		int nbAscenseur = 5;
		for (int i = 0; i <= nbAscenseur; i++) {
			InterAscenseur Ascenseur = new Ascenseur(lstPersonne, affichage);
			add(Ascenseur);
			Ascenseur.start();
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
