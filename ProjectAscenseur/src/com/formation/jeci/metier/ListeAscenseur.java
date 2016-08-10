package com.formation.jeci.metier;

import java.util.ArrayList;

public class ListeAscenseur extends ArrayList<Ascenseur> {

	private static final long serialVersionUID = 1L;
	// * ---------------------------------------------------
	// * | ListeAscenseur hérite de ArrayList<Ascenseur> |
	// * |-------------------------------------------------|
	// * |-------------------------------------------------|
	// * | +ListeAscenseur() |
	// * |-------------------------------------------------|
	// * | toString() |

	public ListeAscenseur() {
		int etage = 0;
		int progression = 0;
		boolean fin = false;
		Personne personne = null;
		Ascenseur a = new Ascenseur(etage, progression, fin, personne);
		for (int i = 0; i < 6; i++) {
			this.add(a);
		}
	}

	@Override
	public String toString() {

		return super.toString();
	}

}
