package com.formation.joca.exos;

public class Exos {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	public int sumTableau(int[] tab) {
		int result = 0;
		for (int i = 0; i < tab.length; i++) {
			result = result + tab[i];
		}
		return result;
	}
}
