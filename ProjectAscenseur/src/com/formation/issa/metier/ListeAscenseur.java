package com.formation.issa.metier;

import java.util.ArrayList;

import com.formation.issa.metier.Ascenseur;

public class ListeAscenseur extends ArrayList<Ascenseur> {
	
	public ListeAscenseur(){
	for (int i = 0; i < 7; i++) {
			this.add(new Ascenseur());
			System.out.println(this.get(i));
	}
		}
		
	private ListPersonne listPersonne;

	public ListeAscenseur(ListPersonne listPersonne) {
		// TODO Auto-generated constructor stub
		this.listPersonne=listPersonne;
		for (int i = 0; i < 1; i++) {
			Ascenseur ascenseur=new Ascenseur(listPersonne);
			add(ascenseur);
			ascenseur.start();
		}
	}



	@Override
	public String toString() {
		return "ListeAscenseur [toString()=" + super.toString() + "]";
	}
	

}
