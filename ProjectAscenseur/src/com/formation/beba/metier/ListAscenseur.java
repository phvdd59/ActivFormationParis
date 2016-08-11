package com.formation.beba.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListAscenseur extends ArrayList<InterAscenseur>implements InterListeAscenseur {

	private InterListPersonne listePersonne;
	private InterAffichage affichage;

	public ListAscenseur(InterListPersonne lst) {
		this.listePersonne = lst;
		affichage = new Affichage(this);
		for (int i = 0; i < 6; i++) {
			InterAscenseur ascenseur = new Ascenseur(Integer.toString(i), lst, affichage);
			this.add(ascenseur);
		}

		// this.add(new Ascenseur("1", lst, affichage));
		// this.add(new Ascenseur("2", lst, affichage));
		// this.add(new Ascenseur("3", lst, affichage));
		// this.add(new Ascenseur("4", lst, affichage));
		// this.add(new Ascenseur("5", lst, affichage));
		// this.add(new Ascenseur("6", lst, affichage));
		this.get(0).start();
		this.get(1).start();
		this.get(2).start();
		this.get(3).start();
		this.get(4).start();
		this.get(5).start();

	}

	@Override
	public String toString() {
		return "ListeAscenseur []";
	}
}
