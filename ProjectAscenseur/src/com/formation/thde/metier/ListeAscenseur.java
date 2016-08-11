package com.formation.thde.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	public InterListPersonne listPersonne;
	private InterAffichage affichage;

	public ListeAscenseur(ListePersonne listPersonne) {

		this.listPersonne = listPersonne;
		affichage = new Affichage(this);
		for (int i = 0; i < 6; i++) {

			InterAscenseur asc = new Ascenseur(0, 0, false, null, listPersonne,affichage);
			asc.setName(Integer.toString(i));
			asc.start();
			this.add(asc);

		}

	}

	@Override
	public String toString() {
		return "ListeAscenseur []";
	}

}
