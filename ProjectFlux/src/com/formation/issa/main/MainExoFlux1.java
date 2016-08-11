package com.formation.issa.main;

import com.formation.issa.metier.ExoFlux1;

public class MainExoFlux1 {

	public static void main(String[] args) {
		MainExoFlux1 mainExoFlux1 = new MainExoFlux1();
		mainExoFlux1.init();

	}

	private void init() {
		ExoFlux1 exoFlux1 = new ExoFlux1();
		exoFlux1.saisie();

	}
}
