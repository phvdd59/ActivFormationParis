package com.formation.etga.main;

import com.formation.etga.metier.ListeAscenseur;
import com.formation.etga.metier.ListePersonne;

public class MainAscenseur {

	public static void main(String[] args) {
		ListePersonne lstPersonne = new ListePersonne();
		Thread threadLstP = new Thread(lstPersonne, "LISTE DE PERSONNE");
		threadLstP.start();
		ListeAscenseur lstAscenseur = new ListeAscenseur(lstPersonne);
	}
}
