package com.formation.jeci.main;

import com.formation.jeci.exo.ExoTableau1;

public class Main {

	public static void main(String[] args) {
		Main tab = new Main();
		tab.init();

	}

	private void init() {
		// ExoSimple exo1 = new ExoSimple();
		// int tableau1[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		// System.out.println(exo1.sumTableau(tableau1));
		ExoTableau1 exo2 = new ExoTableau1();
		exo2.remplirTableau(2, 5, 6);
		// int []tab={0,1,2,3,4,5,6,7,8,9};
		// int[]tab1={6,6,6,6};
		// exo2.intervertirDeuxElementsTableau(tab, 3, 4);
		// exo2.insererUnElementDansTableau(tab, 5, 10);
		// exo2.insererUnTableauDansUnAutreAvecRemplacement(tab, 3, tab1);
		// exo2.rotationTableau(tab, 2);
	}
}
