package com.formation.etga.main;

import com.formation.etga.exo.ExoTableau1;

public class MainGasp {

	public static void main(String[] args) {
		MainGasp mainGasp = new MainGasp();
		mainGasp.init();
	}

	private void init() {

		ExoTableau1 exo1 = new ExoTableau1();
		int[] tab = exo1.remplirTableau(7, 5, 3);
		int[] test = { 1, 2, 4, 6, 47, 28, 26 };
		int tab1 = exo1.insererUnElementDansTableau(test, 2, 5);

	}
}
