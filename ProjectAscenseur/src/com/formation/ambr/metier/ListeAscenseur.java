package com.formation.ambr.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private InterListPersonne listPers;
	private InterAffichage affichage;

	public ListeAscenseur() {
	}

	public ListeAscenseur(InterListPersonne listPers) {
		this.listPers = listPers;
		affichage = new Affichage(this);

		for (int i = 0; i < 6; i++) {
			InterAscenseur asc = new Ascenseur(listPers, affichage);
			add(asc);
			asc.start();

		}
	}

}
