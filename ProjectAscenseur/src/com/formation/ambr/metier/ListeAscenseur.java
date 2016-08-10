package com.formation.ambr.metier;

import java.util.ArrayList;

public class ListeAscenseur extends ArrayList<Ascenseur> {

	public ListeAscenseur() {
	}

	// new ascenseur. Quand je fais ça, je crée obligatoirement un thread
	// faire un nouveau constructeur si besoin. Le nom de l'ascenceur sera super(nom)
	// ascenseur.start
	// et ensuite tout se fait dans le run

	// ArrayList<Personne>.remove(personne)

	private ListePersonne listPers;

	public ListeAscenseur(ListePersonne listPers) {
		this.listPers = listPers;

		for (int i = 0; i < 1; i++) {
			Ascenseur asc = new Ascenseur(listPers);
			this.add(asc);
			asc.start();

		}
	}

}
