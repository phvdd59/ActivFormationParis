package com.formation.etga.main;

import com.formation.etga.exo.ExoArrayList1;
import com.formation.etga.exo.ExoTableau1;

public class MainGasp {

	public static void main(String[] args) {
		MainGasp mainGasp = new MainGasp();
		mainGasp.init();
	}

	private void init() {

		ExoTableau1 exo1 = new ExoTableau1();
		exo1.remplirTableau(7, 5, 3);

		ExoArrayList1 exo2 = new ExoArrayList1();
		int[] tab = { 1, 2, 3, 4, 5, 6 };

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
