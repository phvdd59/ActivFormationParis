package com.formation.joca.main;

import com.formation.joca.controleur.CtrlPersonne;

public class MainJoca {

	public static void main(String[] args) {
		MainJoca m = new MainJoca();
		m.test();
	}

	private void test() {
		CtrlPersonne ctrlPerso = new CtrlPersonne();
		String test = "logintest";
		System.out.println(ctrlPerso.ctrlIdentifiant(test));

	}

}
