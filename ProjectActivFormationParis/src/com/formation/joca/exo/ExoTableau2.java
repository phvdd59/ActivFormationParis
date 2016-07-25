package com.formation.joca.exo;

import com.formation.phva.exo.InterExoTableau2;;

public class ExoTableau2 implements InterExoTableau2 {

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		int[] tabModif = null;
		if (tab != null) {
			tabModif = new int[tab.length];
			for (int i = 0; i < tab.length; i++) {
				tabModif[i] = tab[tab.length - 1 - i];
			}
		}
		return tabModif;
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
		int[] tabModif = null;
		if (tab != null) {
			tabModif = new int[tab.length + 1];
			for (int i = 0; i < tab.length; i++) {
				tabModif[i] = tab[i];
			}
			tabModif[tabModif.length - 1] = a;
		}
		return tabModif;
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
		int[] tabModif = null;
		if (tab != null) {
			if (tab1 == null) {
				tabModif = tab;
			} else if (p >= 0 && p < tab.length) {
				tabModif = new int[tab.length + tab1.length];
				int i = 0;
				for (int k = 0; k < tab.length; k++) {
					if (i == p) {
						for (int j = 0; j < tab1.length; j++) {
							tabModif[i] = tab1[j];
							i++;
						}
						k--;
					} else {
						tabModif[i] = tab[k];
						i++;
					}
				}
			} else if (p == tab.length) {
				tabModif = new int[tab.length + tab1.length];
				for (int i = 0; i < tab.length; i++) {
					tabModif[i] = tab[i];
				}
				for (int i = tab.length; i < tabModif.length; i++) {
					tabModif[i] = tab1[i - tab.length];
				}
			}
		}
		return tabModif;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            nb element
	 * @return tableau de 2 dimensions de d elements
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tabModif = null;
		if (tab != null) {
			if (tab.length % d == 0) {
				tabModif = new int[tab.length / d][d];
				for (int i = 0; i < tab.length / d; i++) {
					for (int j = 0; j < d; j++) {
						tabModif[i][j] = tab[i * d + j];
					}
				}
			}
		}
		return tabModif;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tabModif = new int[32];
		if (v >= 0) {
			int temp = Math.abs(v);
			tabModif[0] = 0;
			for (int i = 1; i < tabModif.length; i++) {
				tabModif[i] = temp / ((int) Math.pow(2, 31 - i));
				temp = temp % ((int) Math.pow(2, 31 - i));
			}
			int p = 0;
			while (tabModif[p] == 0) {
				p++;
			}
			int[] tabFinal = new int[32 - p];
			for (int i = 0; i < tabFinal.length; i++) {
				tabFinal[i] = tabModif[32 - tabFinal.length + i];
			}
			tabModif = tabFinal;

		} else {
			int temp = Math.abs(v) - 1;
			tabModif[0] = 1;
			for (int i = 1; i < tabModif.length; i++) {
				tabModif[i] = temp / ((int) Math.pow(2, 31 - i));
				temp = temp % ((int) Math.pow(2, 31 - i));
				if (tabModif[i] == 1) {
					tabModif[i] = 0;
				} else if (tabModif[i] == 0) {
					tabModif[i] = 1;
				}
			}
		}

		return tabModif;
	}
}