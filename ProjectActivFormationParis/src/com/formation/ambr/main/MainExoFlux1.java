package com.formation.ambr.main;

import com.formation.ambr.exo.ExoFlux1;

public class MainExoFlux1 {

	public static void main(String[] args) {
		MainExoFlux1 m = new MainExoFlux1();
		m.init();

	}

	private void init() {
		//File file = new File("./src/com/formation/ambr/data/saisie.json");

		ExoFlux1 exoFlux1 = new ExoFlux1();
		exoFlux1.saisie();
		exoFlux1.save();

	}

}
