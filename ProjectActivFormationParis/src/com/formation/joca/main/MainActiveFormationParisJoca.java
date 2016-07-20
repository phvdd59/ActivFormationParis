package com.formation.joca.main;

import com.formation.joca.exo.ExoSimple;
import com.formation.joca.exo.ExoTableau1;

public class MainActiveFormationParisJoca {

	public static void main(String[] arg) {
		MainActiveFormationParisJoca test = new MainActiveFormationParisJoca();
		test.init2();
	}

	public void afficherTableau(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println(" ");
	}

	private void init() {
		int[] tabTest = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo1 = new ExoSimple();
		System.out.println(exo1.sumTableau(tabTest));

	}

	private void init2() {
		ExoTableau1 exo1 = new ExoTableau1();
		int[] tabTest = exo1.remplirTableau(7, 5, 3);
		this.afficherTableau(tabTest);

		tabTest = exo1.intervertirDeuxElementsTableau(tabTest, 2, 5);
		this.afficherTableau(tabTest);

		tabTest = exo1.insererUnElementDansTableau(tabTest, 3, 5);
		this.afficherTableau(tabTest);

		int[] tab2 = { 2, 8 };
		tabTest = exo1.insererUnTableauDansUnAutreAvecRemplacement(tabTest, 2, tab2);
		this.afficherTableau(tabTest);

		tabTest = exo1.rotationTableau(tabTest, 2);
		this.afficherTableau(tabTest);
	}

}
