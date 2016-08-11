package com.formation.soka.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private InterListPersonne listePersonne;
	private InterAffichage affichage;

	public ListeAscenseur(ListePersonne listePersonne) {

		for (int i = 0; i < 6; i++) {
			this.listePersonne = listePersonne;
			affichage = new Affichage(this);
			InterAscenseur a = new Ascenseur(listePersonne, affichage);
			this.add(a);
			a.start();
			System.out.println("Liste Ascenseur : " + i + " done");
		}
	}
}