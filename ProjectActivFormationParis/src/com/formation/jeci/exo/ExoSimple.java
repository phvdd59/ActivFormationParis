package com.formation.jeci.exo;

public class ExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */


	public int sumTableau(int[] tab) {
		int sum1 = 0;

		for (int i = 0; i < tab.length; i++) {

			sum1 = sum1 + tab[i];
		}

		return sum1;
		
	}


}
