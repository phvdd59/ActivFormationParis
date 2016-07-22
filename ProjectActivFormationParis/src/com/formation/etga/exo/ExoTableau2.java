package com.formation.etga.exo;

public class ExoTableau2 {

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *                tableau en entr�e
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		int[] tabFinal = tab.clone();
		for (int i = 0; i < tabFinal.length; i++) {
			tabFinal[i] = tab[(tab.length - 1) - i];
		}
		return tabFinal;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * 
	 * @param tab
	 *                tableau de d�part
	 * @param a
	 *                valeur � ajouter � la fin
	 * @return
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		int[] tabFinal = new int[tab.length + 1];
		for (int i = 0; i < tabFinal.length; i++) {
			if (i < tab.length) {
				tabFinal[i] = tab[i];
			} else {
				tabFinal[i] = a;
			}
		}
		return tabFinal;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * 
	 * @param tab
	 *                tableau de d�part
	 * @param p
	 *                position o� il faut ins�rer le 2�me tableau
	 * @param tab1
	 *                tableau � ins�rer
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		int[] tabFinal = new int[tab.length + tab1.length];
		if ((0 <= p) && (p < tab.length)) {
			for (int i = 0; i < tabFinal.length; i++) {
				if (i < p) {
					tabFinal[i] = tab[i];
				} else if ((i >= p) && (i < (tab1.length + p))) {
					tabFinal[i] = tab1[i - p];
				} else {
					tabFinal[i] = tab[i - tab1.length];
				}
			}
		}
		return tabFinal;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *                tableau en entr�e
	 * @param d
	 *                dimension de base
	 * @return tableau de n dimensions de base
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tabFinal = new int[tab.length / d][d];
		int val = 0;
		if ((0 < d) && (tab.length % d == 0) && (d < tab.length)) {
			for (int i = 0; i < (tab.length / d); i++) {
				for (int j = 0; j < d; j++) {
					tabFinal[i][j] = tab[val];
					val++;
				}
			}
		}
		return tabFinal;
	}

	/**
	 * Exemple v=18 --> r�sultat [1,0,0,1,0]
	 * 
	 * @param v
	 *                valeur en entr�e
	 * @return tableau repr�sentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tabFinal = new int[32];
		System.out.println("A MORT LOUIS [1 0 0 0] !");
		return tabFinal;
	}
}