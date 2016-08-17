package com.formation.jeci.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private static final long serialVersionUID = 1L;
	private InterListPersonne lstPersonne;
	private InterAffichage affichage;

	public ListeAscenseur(InterListPersonne lst) {
		this.lstPersonne = lst;
		affichage = new Affichage(this);
		for (int i = 0; i < 6; i++) {
			InterAscenseur ascenseur = new Ascenseur(lst, affichage);
			this.add(ascenseur);
			System.out.println(this);
			ascenseur.start();

		}

	}

	@Override
	public String toString() {

		return super.toString();
	}

}
