package com.formation.frva.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.inter.InterPersonne;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur>implements InterListeAscenseur {
	
	public ListeAscenseur(InterListPersonne listePersonne) {

		InterAffichage affichage = new Affichage(this);
		int nbAscenceurs = 5;
		for (int i = 0; i < nbAscenceurs; i++) {
			String nom = "Asc"+ new Integer(i).toString();
			InterAscenseur asc = new Ascenseur(listePersonne);
			asc.start();
		}
		
	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public InterAscenseur get(int i) {
		return super.get(i);
	}

}
