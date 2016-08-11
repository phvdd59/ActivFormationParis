package com.formation.issa.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	public ListeAscenseur() {
		for (int i = 0; i < 6; i++) {
			this.add(new Ascenseur());
			System.out.println(this.get(i));
		}
	}

	private InterListPersonne listPersonne;
	private InterAffichage affichage;

	public ListeAscenseur(ListPersonne listPersonne) {
		// TODO Auto-generated constructor stub
		this.listPersonne = listPersonne;
		affichage = new Affichage(this);
		for (int i = 0; i < 6; i++) {
			InterAscenseur ascenseur = new Ascenseur(listPersonne, affichage);
			this.add(ascenseur);
			ascenseur.start();
		}
	}

	@Override
	public String toString() {
		return "ListeAscenseur [toString()=" + super.toString() + "]";
	}

}
