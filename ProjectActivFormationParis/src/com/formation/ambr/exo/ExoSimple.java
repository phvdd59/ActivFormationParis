package com.formation.ambr.exo;

import com.formation.phva.exo.InterExoSimple;

public class ExoSimple implements InterExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */

	public int sumTableau(int[] tab) {
		int somme = 0;
		for (int i = 0; i < tab.length; i++) {
			somme = somme + tab[i];
		}

		return somme;

	}

}
