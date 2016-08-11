package com.formation.frva.main;

import com.formation.frva.metier.ListeAscenseur;
import com.formation.frva.metier.ListePersonne;

public class MainAscenseur2 {

	public static void main(String[] args) {
		MainAscenseur2 m = new MainAscenseur2();
		m.init();
	}
	
	private void init() {
		ListePersonne.FREQUENCE = 100;
		ListePersonne.NBMAXPERS = 10;
		ListePersonne listeP = new ListePersonne();
		Thread threadListPers = new Thread (listeP, "Liste de Personnes");
		threadListPers.start();
				
		ListeAscenseur listAscenseur = new ListeAscenseur(listeP);
		
	}
}