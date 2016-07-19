package com.formation.frva.exo;

import com.formation.phva.exo.InterExoSimple;

public class ExoSimple implements InterExoSimple{

	/**
	 * Exemple 
	 * 		tab = [1,5,7,6,8,9,4,2,3]
	 * 		résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	public int sumTableau(int[] tab) {
		int retour = 0;
		for (int valtab : tab) {
			retour += valtab;
		}
		return retour;
	}
}
