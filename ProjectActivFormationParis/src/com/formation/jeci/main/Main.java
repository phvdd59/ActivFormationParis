package com.formation.jeci.main;

import com.formation.jeci.exo.ExoSimple;

public class Main {

	public static void main(String[] args) {
		Main tab = new Main();
		tab.init();
	}

	private void init() {
		ExoSimple exo1 = new ExoSimple();
		int tableau1[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		System.out.println(exo1.sumTableau(tableau1));
	}
}
