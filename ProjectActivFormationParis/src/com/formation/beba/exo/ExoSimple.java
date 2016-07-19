package com.formation.beba.exo;

public class ExoSimple {
	private int tab[];
	// tab[] = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };

	public ExoSimple(int[] tab) {
		this.setTab(tab);
	}

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */

	public int sumTableau(int[] w) {
		int sum = 0;
		for (int i = 0; i < tab.length; i++) {
			sum = sum + tab[i];
		}
		return sum;
	}

	public int[] getTab() {
		return tab;
	}

	public void setTab(int tab[]) {
		this.tab = tab;
	}
}
