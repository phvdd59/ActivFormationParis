package com.formation.thcr.metier;

import java.util.ArrayList;

public class ListAscenseur extends ArrayList<Ascenseur> {
	
//	public ListAscenseur() {
//		for (int i = 0; i < 6; i++) {
//			this.add(new Ascenseur());
//			this.get(this.size()-1).setName("ascenseur " + i);
//			this.get(this.size()-1).start();
//		}
//	}

	public ListAscenseur(ListPersonne listPersonne) {
		for (int i = 0; i < 6; i++) {
			this.add(new Ascenseur(listPersonne));
			this.get(this.size()-1).setName("ascenseur " + i);
			this.get(this.size()-1).start();
		}
	}
	
	@Override
	public String toString() {
		String s= "";
		for (Ascenseur ascenseur : this) {
			s += ascenseur.toString();
		}
		return this.getClass().getSimpleName() + " " + s ;
	}
	

}
