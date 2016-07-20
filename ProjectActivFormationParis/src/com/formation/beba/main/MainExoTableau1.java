package com.formation.beba.main;

import com.formation.beba.exo.ExoTableau1;

public class MainExoTableau1 {

	public static void main(String[] args) {
		MainExoTableau1 mainExoTableau1 = new MainExoTableau1();
		mainExoTableau1.init();
	}

	private void init() {

		System.out.println(new ExoTableau1().remplirTableau(5, 5, 5));

		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		int i1 = 3;
		int i2 = 8;
		System.out.println(new ExoTableau1().intervertirDeuxElementsTableau(tab, i1, i2));
	}
}