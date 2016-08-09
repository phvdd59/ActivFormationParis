package com.formation.anfr.main;

import java.io.IOException;

import com.formation.anfr.exo.ExoFlux1;

public class MainFlux {
	public static void main(String[] args) {
		MainFlux mainFlux = new MainFlux();
		mainFlux.init();

	}

	public void init() {
		ExoFlux1 exoFlux = new ExoFlux1();
		exoFlux.saisie();
			exoFlux.save();
	}
}
