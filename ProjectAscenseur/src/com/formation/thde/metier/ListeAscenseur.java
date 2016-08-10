package com.formation.thde.metier;

import java.util.ArrayList;

public class ListeAscenseur extends ArrayList<Ascenseur> {

	public ListeAscenseur() {

		for (int i = 0; i < 6; i++) {

			this.add(new Ascenseur(0, 0, false, null));

		}

	}

	@Override
	public String toString() {
		return "ListeAscenseur []";
	}

}
