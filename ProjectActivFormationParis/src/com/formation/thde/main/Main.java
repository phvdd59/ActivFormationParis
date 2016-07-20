package com.formation.thde.main;

import com.formation.thde.exo.ExoTableau1;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.init();
	}

	private void init() {
		ExoTableau1 exo1 = new ExoTableau1();
		int[] tab1 = exo1.remplirTableau(7, 5, 3);
		for (int i = 0; i < tab1.length; i++) {
			System.out.print(tab1[i] + ", ");
		}
		System.out.print("\n");
		int[] test = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int[] tab2 = exo1.intervertirDeuxElementsTableau(test, 3, 8);
		for (int i = 0; i < tab2.length; i++) {
			System.out.print(tab2[i] + ", ");
		}
		System.out.print("\n");
		int[] test2 = { 1, 4, 6, 2, 4, 6 };
		int[] tab3 = exo1.insererUnElementDansTableau(test2, 3, 8);
		for (int i = 0; i < tab3.length; i++) {
			System.out.print(tab3[i] + ", ");
		}
		System.out.print("\n");
		int[] test3 = { 22, 11, 0, 77, 88, 99 };
		int[] test4 = { 3, 4, 5, 6 };
		int[] tab4 = exo1.insererUnTableauDansUnAutreAvecRemplacement(test3, 2, test4);
		for (int i = 0; i < tab4.length; i++) {
			System.out.print(tab4[i] + " ");
		}
		System.out.print("\n");
		int[] test5 = { 1, 4, 6, 2, 4, 6 };
		int[] tab5 = exo1.rotationTableau(test5, 2);
		for (int i = 0; i < tab5.length; i++) {
			System.out.print(tab5[i] + ", ");
		}
	}
}
