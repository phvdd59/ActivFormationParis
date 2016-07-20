package com.formation.made.main;

import com.formation.made.exo.ExoTableau1;

public class MainExoTableau {

	public static void main(String[] args) {
		MainExoTableau mainexotableau = new MainExoTableau();
		mainexotableau.init();

	}

	private void init() {
		ExoTableau1 exotableau=new ExoTableau1();
		exotableau.remplirTableau(7, 5, 3);
		int[] tab = {7,10,13,16,19,21,24,27,30};
		exotableau.intervertirDeuxElementsTableau(tab, 3, 8);
		int[]tab2={1,4,6,2,4,6,9,0,0,0};
		exotableau.insererUnElementDansTableau(tab2, 9, 7);
		int[]tableau1={1,2,3,4,5,6,7,8,9};
		int[]tableau2={10,20,30,40,50,60,70,80,90,100,110};
		exotableau.insererUnTableauDansUnAutreAvecRemplacement(tableau1, 0, tableau2);
		int[]tableaurotate={1,2,3,4,5,6,7,8,9,10};
		exotableau.rotationTableau(tableaurotate, 9);
	}

}
