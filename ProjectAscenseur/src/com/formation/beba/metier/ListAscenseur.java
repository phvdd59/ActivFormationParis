package com.formation.beba.metier;

import java.util.ArrayList;

public class ListAscenseur extends ArrayList<Ascenseur> {

	public ListAscenseur(ListePersonne lst) {

		this.add(new Ascenseur("1", lst));
		this.add(new Ascenseur("2", lst));
		this.add(new Ascenseur("3", lst));
		this.add(new Ascenseur("4", lst));
		this.add(new Ascenseur("5", lst));
		this.add(new Ascenseur("6", lst));
		this.get(0).start();
		this.get(1).start();
		this.get(2).start();
		this.get(3).start();
		this.get(4).start();
		this.get(5).start();


	}

	@Override
	public String toString() {
		return "ListeAscenseur []";
	}
}
