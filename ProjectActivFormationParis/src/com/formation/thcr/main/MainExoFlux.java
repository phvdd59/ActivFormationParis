package com.formation.thcr.main;

import com.formation.thcr.exo.ExoFlux1;

public class MainExoFlux {

	public static void main(String[] args) {
		MainExoFlux main = new MainExoFlux();
		main.init();
	}

	private void init() {
		ExoFlux1 exo = new ExoFlux1();
		exo.saisie();
	}

}
