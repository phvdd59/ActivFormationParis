package com.formation.anfr.main;

import com.formation.anfr.exo.ExoSimple;

public class MainGit {

	public static void main(String[] args) {
		MainGit mainGit = new MainGit();
		mainGit.init();

	}

	private void init() {
		ExoSimple exo = new ExoSimple();
		System.out.println("Résultat : " + exo.sumTableau());
		 int[] tableau = {-1,3,5,9,5,14,28,3,6,9};
		ExoSimple exo2 = new ExoSimple(tableau);
		System.out.println("Résultat : " + exo2.sumTableau());
	}

}
