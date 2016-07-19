package com.formation.thde.exo;

/**
 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
 * 
 * @param tab
 * @return
 */

public class ExoSimple {
	private int[] tab = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };

	public static void main(String[] args) {
		ExoSimple exoSimple = new ExoSimple();
		exoSimple.init();
	}

	private void init() {
		int resultat = this.sumTableau(tab);
		System.out.println(resultat);
	}

	public int sumTableau(int[] tab) {
		int sum = 0;
		for (int i : tab) {
			sum += i;
		}
		return sum;
	}
}
