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

	public int[] rallongerTableauDeUnElement2(int[] tab, int a) {
		if (tab == null) {
			tab = new int[0];
		}
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
				tmp[i] = tab[i - p - 1];
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
		int[][] tmp = new int[0][0];
		if (tab.length % d == 0) {
			tmp = new int[tab.length / d][d];
			for (int i = 0; i < tab.length / d; i++) {
				for (int j = 0; j < d; j++) {
					tmp[i][j] = tab[i * d + j];
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
	public int[] tabBaseDeux(int v) {
		int[] intToBit = null;
		String vToBinStr = Integer.toBinaryString(Integer.valueOf(v));
		char[] bit = vToBinStr.toCharArray();
		intToBit = new int[bit.length];
		for (int i = 0; i < bit.length - 1; i++) {
			intToBit[i] = Integer.valueOf(vToBinStr.substring(i, i + 1));

		}
		return intToBit;
	}

	public int[] tabBaseDeux2(int v) {
		int[] intToBit = null;
		int r1 = 0;
		int r2 = 0;

		while (v != 0 || v != 1) {
			r1 = v % 2;
			if (r1 != 0)
				r2 = v / 2 + 1;
			else
				r2 = v / 2;
			v = r2;
			this.rallongerTableauDeUnElement2(intToBit, r1);
		}
		this.rallongerTableauDeUnElement2(intToBit, v);
		return intToBit;
	}
}