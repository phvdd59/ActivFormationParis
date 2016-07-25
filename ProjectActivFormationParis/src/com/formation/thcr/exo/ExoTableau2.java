package com.formation.thcr.exo;

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
		int[] tmp = new int[tab.length];
		for (int i = 0; i < tab.length; i++) {
			tmp[i] = tab[tab.length - 1 - i];
		}
		return tmp;
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
		int[] tmp = new int[tab.length + 1];
		for (int i = 0; i < tab.length; i++) {
			tmp[i] = tab[i];
		}
		tmp[tmp.length - 1] = a;
		return tmp;
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
		int[] tmp = new int[tab.length + tab1.length];
		if (p >= 0 && p < tab.length) {
			for (int i = 0; i < p; i++)
				tmp[i] = tab[i];
			for (int i = p; i < tab1.length + p; i++)
				tmp[i] = tab1[i - p];
			for (int i = p + tab1.length; i < tmp.length; i++)
				tmp[i] = tab[i - tab1.length];
		} else {
			tmp = tab;
		}
		return tmp;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            dimension de base
	 * 
	 * @return tableau de 2 dimensions de base
	 */

	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tmp;
		if (d <= 0 || d > tab.length) {
			tmp = new int[1][tab.length];
			for (int i = 0; i < tab.length; i++) {
				tmp[0][i] = tab[i];
			}
		} else if (tab.length % d == 0) {
			tmp = new int[tab.length / d][d];
			for (int i = 0; i < tab.length / d; i++) {
				for (int j = 0; j < d; j++) {
					tmp[i][j] = tab[i * d + j];
				}
			}
		} else {
			tmp = new int[tab.length / d + 1][d];
			for (int i = 0; i < tab.length / d + 1; i++) {
				for (int j = 0; j < d; j++) {
					if (i * d + j < tab.length)
						tmp[i][j] = tab[i * d + j];
					else
						tmp[i][j] = 0;
				}

			}
		}
		return tmp;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 * 
	 */
	public int[] tabBaseDeux2(int v) {
		int[] intToBit = null;
		String vToBinStr = Integer.toBinaryString(Integer.valueOf(v));
		char[] bit = vToBinStr.toCharArray();
		intToBit = new int[bit.length];
		for (int i = 0; i < bit.length; i++) {
			intToBit[i] = Integer.valueOf(vToBinStr.substring(i, i + 1));
		}
		return intToBit;
	}

	public int[] tabBaseDeux(int v) {
		int[] intToBit = { 0 };
		int tmpr = 0;
		int r1 = 0;
		int r2 = 0;
		int cpt = 0;
		int i = 0;
		int v2 = v;

		while (v != 0) {
			tmpr = v / 2;
			v = tmpr;
			cpt++;
		}
		if (v2 > 0) {
			intToBit = new int[cpt];
			while (v2 != 0) {
				r1 = v2 % 2;
				r2 = v2 / 2;
				v2 = r2;
				if (v2 == 1 && r1 == 1) {
					intToBit[intToBit.length - i - 1] = 1;
				} else {
					intToBit[intToBit.length - i - 1] = r1;
				}
				i++;
			}
		} else if (v2 < 0) {
			intToBit = new int[32];
			v2 = Math.abs(v2);
			v2 = Integer.MAX_VALUE - v2 + 1; // complément à 2
			while (v2 != 0) {
				r1 = v2 % 2;
				r2 = v2 / 2;
				v2 = r2;
				if (v2 == 1 && r1 == 1) {
					intToBit[intToBit.length - i - 1] = 1;
				} else {
					intToBit[intToBit.length - i - 1] = r1;
				}
				i++;
			}
			intToBit[0] = 1;
		}
		return intToBit;
	}
}