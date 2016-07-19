package com.formation.emma.main;

import com.formation.emma.exo.ExoSimple;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		main.init();

	}

	private void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exo = new ExoSimple();

		int somme = exo.sumTableau(tab);
		System.out.println(somme);
	}
}
