package com.formation.made.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur{

	private InterListPersonne listePersonne;
	private InterAffichage affichage;
	
	public ListeAscenseur(ListePersonne listePersonne){
		this.listePersonne=listePersonne;
		affichage=new Affichage(this);
		for (int i = 0; i < 3; i++) {
			InterAscenseur ascenseur=new Ascenseur(listePersonne,affichage);
			this.add(ascenseur);
			ascenseur.start();
		}
	}

	@Override
	public String toString() {
		return "ListeAscenseur [toString()=" + super.toString() + "]";
	}
	
}
