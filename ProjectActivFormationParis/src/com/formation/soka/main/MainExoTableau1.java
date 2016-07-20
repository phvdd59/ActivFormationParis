package com.formation.soka.main;

import com.formation.soka.exo.ExoTableau1;

public class MainExoTableau1 {

	public static void main(String[] args) {
		MainExoTableau1 m = new MainExoTableau1();
		m.init();

	}

	private void init() {
		ExoTableau1 exoTableau1 = new ExoTableau1();
		int[] tablo = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		//exoTableau1.remplirTableau(7, 5, 3);
		//exoTableau1.intervertirDeuxElementsTableau(tablo, 3, 8);
		int[] tab = { 1, 4, 6, 2, 4, 6 };
		//exoTableau1.insererUnElementDansTableau(tab, 3, 8);
		int[] tabo = { 1, 4, 6, 2, 4, 7, 23, 255, 897 };
		int[] tab1 = { 4, 9, 0 };
		//exoTableau1.insererUnTableauDansUnAutreAvecRemplacement(tabo, 2, tab1);
		int[] nuevoTablo = { 1, 4, 6, 2, 4, 6 };
		exoTableau1.rotationTableau(nuevoTablo, 2);
	}

}
