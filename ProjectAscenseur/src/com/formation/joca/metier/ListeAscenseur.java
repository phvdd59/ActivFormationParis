package com.formation.joca.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListeAscenseur;
import com.formation.phva.met.Affichage;

public class ListeAscenseur extends ArrayList<InterAscenseur> implements InterListeAscenseur {

	private ListePersonne lstPersonne;
	private InterAffichage affichage;

	public ListeAscenseur(ListePersonne lstPersonne) {

		this.lstPersonne = lstPersonne;
		affichage = new Affichage(this);

		for (int i = 0; i < 6; i++) {
			InterAscenseur asc = new Ascenseur(lstPersonne, affichage);
			this.add(asc);
		}
		for (int i = 0; i < this.size(); i++) {
			this.get(i).start();
		}

	}

	public ListePersonne getLstPersonne() {
		return lstPersonne;
	}

	public void setLstPersonne(ListePersonne lstPersonne) {
		this.lstPersonne = lstPersonne;
	}

	@Override
	public String toString() {

		for (InterAscenseur asc : this) {
			System.out.println(asc.toString());
		}
		return "";
	}
}
