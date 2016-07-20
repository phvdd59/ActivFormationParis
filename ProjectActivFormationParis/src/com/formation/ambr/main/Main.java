package com.formation.ambr.main;

import com.formation.ambr.exo.ExoSimple;
import com.formation.ambr.exo.ExoTableau1;

public class Main {

	public static void main(String[] args) { // main method

		Main main = new Main();
		main.init();

	}

	private void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		//int a = 5;
		ExoSimple exoSimple = new ExoSimple(); // on construit un ExoSimple qui s'appelle exoSimple

		int autreSomme = exoSimple.sumTableau(tab);// on dit que autreSomme c'est sumTableau de tab, dans la méthode exoSimple, qui est une méthode (un patron) de type ExoSimple. Et sumTableau nous retourne une somme
		System.out.println(autreSomme); // on lui demande de nous afficher autreSomme

		/////////

		//ExoTableau1
		//1. remplirTableau

		//int[] tab1 = { 7, 10, 13, 16, 19 };
		ExoTableau1 tableauRempli = new ExoTableau1();
		int[] monTableauRempli = tableauRempli.remplirTableau(7, 5, 3);
		for (int i = 0; i < monTableauRempli.length; i++) {
			System.out.println(monTableauRempli[i]);
		}

		//2. intervertirDeuxElementsTableau
		ExoTableau1 tab2 = new ExoTableau1();
		//tab2 = tab1.intervertirDeuxElementsTableau()

	}

}
