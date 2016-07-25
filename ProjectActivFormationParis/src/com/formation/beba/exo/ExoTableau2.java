package com.formation.beba.exo;

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
		int tab2[];
		tab2 = null;
		if (tab.length == 1) {
			tab2 = tab;
		} else if (tab != null) {
			tab2 = new int[tab.length];
			for (int i = 0; i < tab2.length; i++) {
				tab2[i] = tab[tab.length - i - 1];
			}
		}
		return tab2;
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
		int[] tab2;
		if (tab == null) {
			tab2 = null;
		} else {
			tab2 = new int[tab.length + 1];
			for (int i = 0; i < tab.length; i++) {
				tab2[i] = tab[i];
			}
			tab2[tab.length] = a;
		}
		return tab2;
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
		int[] tab2;
		if (p < 0 || p > tab.length) {
			tab2 = null;
		} else {
			if (tab == null) {
				tab2 = null;
			} else if (tab1 == null) {
				tab2 = tab;
			} else {
				tab2 = new int[tab.length + tab1.length];
				for (int i = 0; i < tab2.length; i++) {
					if (i < p) {
						tab2[i] = tab[i];
					} else if (i >= p && i < p + tab1.length) {
						tab2[i] = tab1[i - p];
					} else {
						tab2[i] = tab[i - p - 1];
					}
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
		int[][] tab2;
		int cpt = 0;
		if (tab == null || d <= 0) {
			tab2 = null;
		} else if (tab.length % d != 0) {
			tab2 = null;
		} else {
			tab2 = new int[tab.length / d][d];
			for (int i = 0; i < tab2.length; i++) {
				for (int j = 0; j < d; j++) {

					tab2[i][j] = tab[cpt];
					cpt++;
				}
			}
		}
		return tab2;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tab2;
		int reste = v;
		int tailleTab = 1;
		if (v > 0) {
			for (int i = 0; reste != 0 && reste != 1; i++) {
				reste = reste / 2;
				tailleTab = i + 2;
			}
			tab2 = new int[tailleTab];
			reste = v;
			for (int i = 0; i < tab2.length; i++) {
				if (reste % 2 == 0) {
					tab2[tab2.length - i - 1] = 0;
					reste = reste / 2;
				} else {
					tab2[tab2.length - 1 - i] = 1;
					reste = reste / 2;
				}
			}
		} else {
			tab2 = new int[32];
			v = -v - 1;
			reste = v;
			tab2[0] = 1;
			for (int i = 0; reste != 0 && reste != 1; i++) {
				reste = reste / 2;
				tailleTab = i + 2;
			}
			tab2 = new int[32];
			reste = v;
			for (int i = 0; i < tab2.length; i++) {
				if (reste % 2 == 0) {
					tab2[tab2.length - i - 1] = 0;
					reste = reste / 2;
				} else {
					tab2[tab2.length - 1 - i] = 1;
					reste = reste / 2;
				}
			}
			for (int i = 0; i < tab2.length; i++) {
				if (tab2[i] == 0) {
					tab2[i] = 1;
				} else {
					tab2[i] = 0;
				}
			}
		}

		return tab2;
	}
}