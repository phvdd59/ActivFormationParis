package com.formation.beba.main;

import java.util.Arrays;

import com.formation.beba.exo.ExoTableau2;

public class MainTab2 {

	public static void main(String[] args) {
		MainTab2 mainTab2 = new MainTab2();
		mainTab2.init();
	}

	private void init() {
		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		System.out.println(Arrays.toString(tab));

		ExoTableau2 exoTab2 = new ExoTableau2();

		int[] test = exoTab2.inverserTableau(tab);
		System.out.println(Arrays.toString(test));

		int[] test2 = exoTab2.rallongerTableauDeUnElement(tab, 8);
		System.out.println(Arrays.toString(test2));

		int[] tabInt = { 8, 8, 8 };
		int[] test3 = exoTab2.insererUnTableauDansUnAutre(tab, 2, tabInt);
		System.out.println(Arrays.toString(test3));

		int[][] test4 = exoTab2.changerDimensionTableau(tab, 5);
		for (int i = 0; i < test4.length; i++) {
			System.out.print(Arrays.toString(test4[i]));
		}
		int[] test5 = exoTab2.tabBaseDeux(-55);
		System.out.println();
		System.out.println(Arrays.toString(test5));
	}

}
