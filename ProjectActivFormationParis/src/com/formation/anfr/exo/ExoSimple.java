package com.formation.anfr.exo;

import com.formation.phva.exo.InterExoSimple;

public class ExoSimple implements InterExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] r�sultat : 45
	 * 
	 * @param tab
	 * @return
	 */

	public int sumTableau(int[] tab) {
		int somme = 0;
		for (int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}
		return somme;
	}
}