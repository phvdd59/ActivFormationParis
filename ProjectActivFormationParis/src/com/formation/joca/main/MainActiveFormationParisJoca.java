package com.formation.joca.main;

import com.formation.joca.exo.ExoSimple;

public class MainActiveFormationParisJoca {

	public static void main(String[] arg) {
		MainActiveFormationParisJoca test = new MainActiveFormationParisJoca();
		test.init();
	}

	private void init() {
		int[] tabTest = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo1 = new ExoSimple();
		System.out.println(exo1.sumTableau(tabTest));

	}

}
