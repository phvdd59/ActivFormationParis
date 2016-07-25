package com.formation.jeci.exo;

import com.formation.phva.exo.InterExoTableau2;

public class ExoTableau2 implements InterExoTableau2 {

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		int[] tab1 = null;
		if (tab == null) {
			tab1 = null;
		} else {
			tab1 = new int[tab.length];
			for (int i = tab.length - 1; i >= 0; i--) {
				tab1[tab.length - 1 - i] = tab[i];
			}
		}

		return tab1;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param a
	 *            valeur à ajouter à la fin
	 * @return
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		int[] tab1 = null;
		if (tab == null) {
			tab1 = null;
		} else {
			tab1 = new int[tab.length + 1];
			for (int i = 0; i < tab1.length; i++) {
				if (i < tab.length) {
					tab1[i] = tab[i];
				} else {
					tab1[i] = a;
				}

			}

		}

		return tab1;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position où il faut insérer le 2ème tableau
	 * @param tab1
	 *            tableau à insérer
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		int[] tab2 = null;
		if (tab == null || tab1 == null) {
			tab2 = null;
		} else if (p < 0 || p > tab.length) {
			tab2 = tab;
		} else {
			tab2 = new int[tab.length + tab1.length];
			for (int i = 0; i < tab2.length; i++) {
				if (i < p) {
					tab2[i] = tab[i];
				} else if (i >= p && i < p + tab1.length) {
					tab2[i] = tab1[i - p];
				} else if (i >= p + tab1.length && i < tab2.length) {
					tab2[i] = tab[i - tab1.length];
				}

			}
		}
		return tab2;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            dimension de base
	 * @return tableau de n dimensions de base
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tabo = null;
		if (tab == null) {
			tabo = null;
		} else if (d < 0 || d > tab.length) {
			tabo = null;
		} else if (tab.length % d != 0) {
			tabo = null;
		} else if (tab.length % d == 0) {
			tabo = new int[tab.length / d][d];
			int cptTab = 0;
			for (int i = 0; i < tab.length / d; i++) {
				for (int j = 0; j < d; j++) {
					tabo[i][j] = tab[cptTab];
					cptTab++;
				}
			}
		}

		return tabo;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {

		int[] tab = null;

		String a = Integer.toBinaryString(v);
		char[] tabChar = a.toCharArray();
		tab = new int[tabChar.length];
		for (int i = 0; i < tabChar.length; i++) {
			tab[i] = Character.getNumericValue(tabChar[i]);
		}

		return tab;
	}
}