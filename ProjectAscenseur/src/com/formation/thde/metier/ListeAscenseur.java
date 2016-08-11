package com.formation.thde.metier;

import java.util.ArrayList;

public class ListeAscenseur extends ArrayList<Ascenseur> {

	public ListePersonne listPersonne;

	public ListeAscenseur(ListePersonne listPersonne) {

		this.listPersonne = listPersonne;
		for (int i = 1; i <= 6; i++) {
			//un ascenseur

			Ascenseur asc = new Ascenseur(0, 0, false, null, listPersonne);
			asc.setName("Ascenseur " + i);
			asc.start();
			this.add(asc);

		}

	}

	@Override
	public String toString() {
		return "ListeAscenseur []";
	}

}
