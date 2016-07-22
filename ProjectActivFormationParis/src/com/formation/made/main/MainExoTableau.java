package com.formation.made.main;

import com.formation.made.exo.ExoTableau1;
import com.formation.made.exo.ExoTableau2;


public class MainExoTableau {

	public static void main(String[] args) {
		MainExoTableau mainexotableau = new MainExoTableau();
		mainexotableau.init();

	}

	private void init1() {
		ExoTableau1 exotableau = new ExoTableau1();
		exotableau.remplirTableau(48, 16, -8);
		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		exotableau.intervertirDeuxElementsTableau(tab, 3, 44448);
		int[] tab2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		exotableau.insererUnElementDansTableau(tab2, -3, 7);
		int[] tableau1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] tableau2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		exotableau.insererUnTableauDansUnAutreAvecRemplacement(tableau1, 0, tableau2);
		int[] tableaurotate = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		exotableau.rotationTableau(tableaurotate, 1);
	}

	private void init() {
		ExoTableau2 exotableau2 = new ExoTableau2();
		int[] tableau1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] tableau2 = { 10, 20, 30, 40, 50};// 60, 70, 80, 90 };
		exotableau2.inverserTableau(tableau1);
		exotableau2.rallongerTableauDeUnElement(tableau1, 10);
		exotableau2.insererUnTableauDansUnAutre(tableau1, 1, tableau2);
		exotableau2.changerDimensionTableau(tableau1, 2);
	}
}
