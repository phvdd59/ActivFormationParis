package com.formation.joca.main;

import com.formation.thcr.metier.SITUATION;

import controleur.CtrlDocPerso;
import controleur.CtrlPersonne;

public class MainJoca {

	public static void main(String[] args) {
		MainJoca m = new MainJoca();
		m.test();
	}

	private void test() {
		CtrlDocPerso ctrlPerso = new CtrlDocPerso();
		String test = "5555\55555";
		System.out.println(ctrlPerso.ctrlNomDocUtil(test));

	}

}
