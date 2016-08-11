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

	public ListeAscenseur(ListePersonne lst) {

		for (int i = 0; i < 2; i++) {
			Ascenseur ascenseur = new Ascenseur(lst);
			this.add(ascenseur);
			System.out.println(this);
			ascenseur.start();

		}

	}

	@Override
	public String toString() {

		return super.toString();
	}

}
