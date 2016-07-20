package com.formation.anfr.main;

import com.formation.anfr.exo.ExoSimple;

public class MainGit {

	public static void main(String[] args) {
		MainGit mainGit = new MainGit();
		mainGit.init();

	}
	public void init() {
		int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		System.out.println("Résultat : " + new ExoSimple().sumTableau(tab));
		int[] tableau = { -1, 3, 5, 9, 5, 14, 28, 3, 6, 9 };
		System.out.println("Résultat : " + new ExoSimple().sumTableau(tableau));
	}


}
