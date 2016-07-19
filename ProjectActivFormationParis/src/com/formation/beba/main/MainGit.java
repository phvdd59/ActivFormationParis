package com.formation.beba.main;

import com.formation.beba.exo.ExoSimple;

public class MainGit {

	public static void main(String[] args) {
		MainGit mainGit = new MainGit();
		mainGit.init();
	}

	private void init() {
		// TODO Auto-generated method stub

		int tab[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		ExoSimple exotab = new ExoSimple();
		System.out.println(exotab.sumTableau(tab));
	}
}
