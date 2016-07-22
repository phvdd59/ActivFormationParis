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

		System.out.println("*Tableau Rempli*");
		ExoTableau1 exoTableau1 = new ExoTableau1();
		int[] tableauRempli = exoTableau1.remplirTableau(7, 5, 3);
		for (int i = 0; i < tableauRempli.length; i++) {
			System.out.println(tableauRempli[i]);
		}

		//2. intervertirDeuxElementsTableau
		System.out.println("*Intervertion de tableaux*");
		ExoTableau1 exoTableau2 = new ExoTableau1();
		//int[] tabOrig = exoTableau2.remplirTableau(7, 9, 3);
		int[] tabOrig = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig.length; i++) {
			System.out.println(tabOrig[i]);
		}
		int[] tabInterv = exoTableau2.intervertirDeuxElementsTableau(tabOrig, 3, 8);
		System.out.println("Tableau Interverti");
		for (int i = 0; i < tabInterv.length; i++) {
			System.out.println(tabInterv[i]);
		}

		//3. insererUnElementDansTableau
		System.out.println("*Insertion d'un élément dans un tableau*");
		ExoTableau1 exoTableau3 = new ExoTableau1();
		int[] tabOrig2 = { 1, 4, 6, 2, 4, 6 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig2.length; i++) {
			System.out.println(tabOrig2[i]);
		}
		int[] tabRes2 = exoTableau3.insererUnElementDansTableau(tabOrig2, 3, 8);
		System.out.println("Tableau Résultat");
		for (int i = 0; i < tabRes2.length; i++) {
			System.out.println(tabRes2[i]);
		}

		//4. insererUnTableauDansUnAutreAvecRemplacement
		System.out.println("*insererUnTableauDansUnAutreAvecRemplacement*");
		ExoTableau1 exoTableau4 = new ExoTableau1();
		int[] tabOrig3 = { 1, 4, 6, 2, 4, 7 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig3.length; i++) {
			System.out.println(tabOrig3[i]);
		}
		int[] tabDeRemp = { 4, 9, 0 };
		System.out.println("Tableau de remplacement");
		for (int i = 0; i < tabDeRemp.length; i++) {
			System.out.println(tabDeRemp[i]);
		}
		int[] tabRes3 = exoTableau4.insererUnTableauDansUnAutreAvecRemplacement(tabOrig3, 2, tabDeRemp);
		System.out.println("Tableau Résultat");
		for (int i = 0; i < tabRes3.length; i++) {
			System.out.println(tabRes3[i]);
		}

		//5. rotationTableau
		System.out.println("*rotationTableau*");
		ExoTableau1 exoTableau5 = new ExoTableau1();
		int[] tabOrig4 = { 1, 4, 6, 2, 4, 6 };
		System.out.println("Tableau Originel");
		for (int i = 0; i < tabOrig4.length; i++) {
			System.out.println(tabOrig4[i]);
		}
		System.out.println("Tableau Rotaté");
		int[] tabRota=exoTableau5.rotationTableau(tabOrig4, 2);
		for (int i = 0; i < tabRota.length; i++) {
			System.out.println(tabRota[i]);
		}
		
	}

}
