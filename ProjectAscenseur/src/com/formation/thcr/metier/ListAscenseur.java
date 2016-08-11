package com.formation.thcr.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur{
	
	private InterAffichage affichage;
	private InterListPersonne listPersonne;
	
	public ListAscenseur(ListPersonne listPersonne) {
		this.listPersonne = listPersonne;
		InterAscenseur ascenseur = new Ascenseur(listPersonne, affichage);
		affichage = new Affichage(this); 
		for (int i = 0; i < 6; i++) {
			this.add(ascenseur);
			ascenseur.start();
		}
	}
	
	@Override
	public String toString() {
		String s= "";
		for (InterAscenseur ascenseur : this) {
			s += ascenseur.toString();
		}
		return this.getClass().getSimpleName() + " " + s ;
	}
	

}
