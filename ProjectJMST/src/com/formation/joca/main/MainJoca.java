package com.formation.joca.main;

import com.formation.thcr.metier.SITUATION;

import controleur.CtrlPersonne;

public class MainJoca {

	public static void main(String[] args) {
		MainJoca m = new MainJoca();
		m.test();
	}

	private void test() {
		CtrlPersonne ctrlPerso = new CtrlPersonne();
		String test = null;
		System.out.println(ctrlPerso.ctrlMdp(test));
		SITUATION sit=SITUATION.AUTOENTREPRENEUR;
		System.out.println(sit.name());
	}

}
