package com.formation.phva.exo;

public class ExoSimple implements InterExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	public int sumTableau(int[] tab) {
		int sum = 0;
		for (int i : tab) {
			sum += i;
		}
		return sum;
	}
}
