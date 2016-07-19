package com.formation.beba.exo;

public class ExoSimple {

	// tab[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */

	public int sumTableau(int[] tabT) {
		int sum = 0;
		for (int i = 0; i < tabT.length; i++) {
			sum = sum + tabT[i];
		}
		return sum;
	}
}
