package com.formation.anfr.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenceur extends ArrayList<InterAscenseur> implements InterListeAscenseur {
	
	private InterAffichage affichage;
	
	public ListeAscenceur(InterListPersonne lst){
		affichage = new Affichage(this);
	for (int i = 0; i < 6; i++) {
			InterAscenseur ascenceur = new Ascenceur(lst,affichage);
			this.add(ascenceur);
			ascenceur.start();
		}

	}
}
