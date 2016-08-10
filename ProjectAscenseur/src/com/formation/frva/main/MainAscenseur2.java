package com.formation.frva.main;

import com.formation.ambr.metier.ListeAscenseur;
import com.formation.frva.metier.Ascenseur;
import com.formation.frva.metier.ListePersonne;
import com.formation.frva.metier.Personne;
import com.formation.phva.inter.InterListPersonne;

public class MainAscenseur2 {

	public static void main(String[] args) {
		MainAscenseur2 m = new MainAscenseur2();
		m.init();
	}
	
	private void init() {
		ListePersonne.FREQUENCE = 100;
		ListePersonne.NBMAXPERS = 2;
		InterListPersonne listeP = new ListePersonne();
		Thread threadListPers = new Thread (listeP, "Liste de Personnes");
		threadListPers.start();
				
		ListeAscenseur listAscenseur = new ListeAscenseur(listeP);
		
	}
}