package com.formation.beba.main;

import java.util.Arrays;

import com.formation.beba.exo.ExoTableau1;

public class MainExoTableau1 {

	public static void main(String[] args) {
		MainExoTableau1 mainExoTableau1 = new MainExoTableau1();
		mainExoTableau1.init();
	}

	private void init() {
		ExoTableau1 exoTab = new ExoTableau1();
		System.out.println(Arrays.toString(new ExoTableau1().remplirTableau(5, 5, 5)));

		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		System.out.println(Arrays.toString(tab) + ".......");
		int i1 = 3;
		int i2 = 8;
		System.out.println(Arrays.toString(new ExoTableau1().intervertirDeuxElementsTableau(tab, i1, i2)));

		int[] test2 = exoTab.insererUnElementDansTableau(tab, 4, 2);
		System.out.println(Arrays.toString(test2));

		int[] tab6 = { 1, 2, 3 };
		int[] test4 = exoTab.insererUnTableauDansUnAutreAvecRemplacement(tab, 2, tab6);
		System.out.println("eeeee"+Arrays.toString(test4));

		int[] test3 = exoTab.rotationTableau(tab, 5);
		System.out.println(Arrays.toString(test3));
	}
}