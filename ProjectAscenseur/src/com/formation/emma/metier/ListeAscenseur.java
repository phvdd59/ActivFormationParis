package com.formation.emma.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private InterListPersonne lstP;
	private InterAffichage affichage;

	public ListeAscenseur(InterListPersonne lstP) {
		affichage = new Affichage(this);
		for (int i = 0; i < 6; i++) {
			InterAscenseur ascenseur = new Ascenseur(lstP,affichage);
			add(ascenseur);
			ascenseur.start();
		}
	}

}
