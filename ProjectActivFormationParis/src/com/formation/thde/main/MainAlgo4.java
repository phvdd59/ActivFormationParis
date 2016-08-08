package com.formation.thde.main;

import com.formation.thde.exo.ExoFlux1;

public class MainAlgo4 {

	public static void main(String[] args) {
		MainAlgo4 mainException1 = new MainAlgo4();
		mainException1.init();
	}

	public void init() {
		ExoFlux1 exo = new ExoFlux1();
		exo.saisie();
		System.out.println(exo);
		exo.save();
		exo.recup();
	}

}
