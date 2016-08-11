package com.formation.joca.metier;

import java.util.ArrayList;

import com.formation.phva.inter.InterListeAscenseur;

public class ListeAscenseur extends ArrayList<Ascenseur> implements InterListeAscenseur {

	private ListePersonne lstPersonne;

	public ListeAscenseur(ListePersonne lstPersonne) {
		for (int i = 0; i < 6; i++) {
			Ascenseur asc = new Ascenseur(lstPersonne);
			this.add(asc);
		}
		this.lstPersonne = lstPersonne;

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

		for (Ascenseur asc : this) {
			System.out.println(asc.toString());
		}
		return "";
	}
}
