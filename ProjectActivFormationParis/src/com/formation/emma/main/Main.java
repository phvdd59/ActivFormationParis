package com.formation.emma.main;

import com.formation.emma.exo.ExoSimple;
import com.formation.emma.exo.ExoTableau1;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		main.init();

	}

	private void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo = new ExoSimple();

		int somme = exo.sumTableau(tab);
		System.out.println(somme);

		System.out.println("exo1 tableau1");
		int d = 7;
		int n = 5;
		int p = 3;
		ExoTableau1 exoTableau1 = new ExoTableau1();
		int[] tableau = exoTableau1.remplirTableau(d, n, p);
		for (int i = 0; i < tableau.length; i++) {
			System.out.println(tableau[i]);
		}

		System.out.println("exo2 tableau1");
		int[] tab1 = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1 = 2;
		int i2 = 7;
		ExoTableau1 exo2Tableau1 = new ExoTableau1();
		int[] tableau2 = exo2Tableau1.intervertirDeuxElementsTableau(tab1, i1, i2);
		for (int i = 0; i < tableau2.length; i++) {
			System.out.println(tableau2[i]);
		}

		System.out.println("exo3 tableau1");
		int[] tab2 = { 1, 4, 6, 2, 4, 6 };
		int a = 8;
		int p1 = 3;
		ExoTableau1 exo3Tableau1 = new ExoTableau1();
		int[] tableau3 = exo3Tableau1.insererUnElementDansTableau(tab2, p1, a);
		for (int i = 0; i < tableau3.length; i++) {
			System.out.println(tableau3[i]);
		}

		System.out.println("exo4 tableau1");
		int[] tab3 = { 1, 4, 6, 2, 4, 7 };
		int[] tab4 = { 4, 9, 0 };
		int p3 = 2;
		ExoTableau1 exo4Tableau1 = new ExoTableau1();
		int[] tableau4 = exo4Tableau1.insererUnTableauDansUnAutreAvecRemplacement(tab3, p3, tab4);
		for (int i = 0; i < tableau4.length; i++) {
			System.out.println(tableau4[i]);
		}

		System.out.println("exo5 tableau1");
		int[] tab6 = { 1, 4, 6, 2, 4, 6 };
		int p4 = 4;
		ExoTableau1 exo5Tableau1 = new ExoTableau1();
		int[] tableau5 = exo5Tableau1.rotationTableau(tab6, p4);
		for (int i = 0; i < tableau5.length; i++) {
			System.out.println(tableau5[i]);
		}
	}
}
