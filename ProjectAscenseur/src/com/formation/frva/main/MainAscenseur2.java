package com.formation.frva.main;

import com.formation.frva.metier.Ascenceur;
import com.formation.frva.metier.ListePersonne;
import com.formation.frva.metier.Personne;

public class MainAscenseur2 {

	public static void main(String[] args) {
		MainAscenseur2 m = new MainAscenseur2();
		m.init();
	}
	
	private void init() {
		ListePersonne listeP = new ListePersonne(false);
		Thread threadListPers = new Thread (listeP, "Liste de Personnes");
		threadListPers.start();
		
		int nbAscenceurs = 5;
		for (int i = 0; i < nbAscenceurs; i++) {
			String nom = "Asc"+ new Integer(i).toString();
			Ascenceur asc = new Ascenceur(nom,0, 100, false, listeP);
			asc.start();
		}
	}
}