package com.formation.etga.main;

import com.formation.thde.exo.ExoTableau1;

public class MainGasp {

	public static void main(String[] args) {
		MainGasp mainGasp = new MainGasp();
		mainGasp.init();
	}

	private void init() {

		ExoTableau1 exo1 = new ExoTableau1();
		exo1.remplirTableau(7, 5, 3);
		System.out.println(exo1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
