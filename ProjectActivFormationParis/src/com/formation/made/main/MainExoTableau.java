package com.formation.made.main;

import com.formation.made.exo.ExoTableau1;
import com.formation.made.exo.ExoTableau2;

public class MainExoTableau {

	public static void main(String[] args) {
		MainExoTableau mainexotableau = new MainExoTableau();
		mainexotableau.init();

	}

	private void init() {
		ExoTableau1 exotableau = new ExoTableau1();
		exotableau.remplirTableau(48, 16, -8);
		int[] tab = { 7, 10, 13, 16, 19, 21, 24, 27, 30 };
		exotableau.intervertirDeuxElementsTableau(tab, 3, 44448);
		int[] tab2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		exotableau.insererUnElementDansTableau(tab2, -3, 7);
		int[] tableau1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] tableau2 = { 10,20,30,40,50 };
		exotableau.insererUnTableauDansUnAutreAvecRemplacement(tableau1, 2, tableau2);
		int[] tableaurotate = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		exotableau.rotationTableau(tableaurotate, 1);
	}

	private void init1() {
		ExoTableau2 exotableau2 = new ExoTableau2();
		int[] tabnull=null;
		int[] tableau1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};
		int[] tableau2 = { 10, 20, 30, 40, 50 };// 60, 70, 80, 90 };
		exotableau2.inverserTableau(tableau1);
		exotableau2.rallongerTableauDeUnElement(tabnull, 10);
		exotableau2.insererUnTableauDansUnAutre(tableau1, 3, tableau2);
		exotableau2.changerDimensionTableau(tableau1, 6);
		exotableau2.tabBaseDeux(18);
		int[] tabessai=new int[0];
		
		
	}
}
