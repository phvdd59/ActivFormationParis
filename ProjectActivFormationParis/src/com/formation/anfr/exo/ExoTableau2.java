package com.formation.anfr.exo;

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
		int[] nouveauTableau = null;
		if (tab != null) {
			nouveauTableau = tab.clone();
			for (int i = 0; i < nouveauTableau.length; i++) {
				nouveauTableau[i] = tab[tab.length - (i + 1)];
			}
		} else {
			nouveauTableau = tab;
		}

		return nouveauTableau;
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
		int[] nouveauTableau = null;
		if (tab != null) {
			nouveauTableau = new int[tab.length + 1];
			for (int i = 0; i < nouveauTableau.length - 1; i++) {
				nouveauTableau[i] = tab[i];
			}
			nouveauTableau[nouveauTableau.length - 1] = a;
		} else {
			nouveauTableau = tab;
		}
		return nouveauTableau;
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
		int[] nouveauTableau = null;
		if ((tab != null) && (tab1 != null)) {
			if ((p >= 0) && (p < tab.length)) {
				nouveauTableau = new int[tab.length + tab1.length];
				for (int i = 0; i < p; i++) {
					nouveauTableau[i] = tab[i];
				}
				for (int i = 0; i < tab1.length; i++) {
					nouveauTableau[p + i] = tab1[i];
				}
				for (int i = 0; i < tab.length - p; i++) {
					nouveauTableau[i + p + tab1.length] = tab[i + p];
				}
			} else {
				nouveauTableau = tab.clone();
			}
		}
		return nouveauTableau;
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
		int[][] nouveauTableau = null;
		int k = 0;
		if ((tab != null) && (d > 0) && (tab.length % d == 0)) {
			nouveauTableau = new int[tab.length / d][d];
			for (int i = 0; i < tab.length / d; i++) {
				for (int j = 0; j < d; j++) {
					nouveauTableau[i][j] = tab[k++];
				}
			}
		}
		return nouveauTableau;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] nouveauTableau = null;
		int reste = 0;
		if (v == 0) {
			nouveauTableau = new int[1];
			nouveauTableau[0] = 0;
		} else if (v < 0) {
			nouveauTableau = new int[32];
			if (v != Integer.MIN_VALUE) {
				reste = -v - 1;
				for (int i = nouveauTableau.length - 1; i >= 0; i--) {
					nouveauTableau[nouveauTableau.length - i - 1] = reste / (int) Math.pow(2, i);
					reste = reste % (int) Math.pow(2, i);
				}
				for (int i = 0; i < nouveauTableau.length; i++) {
					if (nouveauTableau[i] == 1) {
						nouveauTableau[i] = 0;
					} else {
						nouveauTableau[i] = 1;
					}

				}
			} else {
				nouveauTableau[0] = 1;
			}
		} else {
			reste = v;
			int cpt = 0;
			while (reste != 0) {
				reste /= 2;
				cpt++;
			}
			reste = v;
			nouveauTableau = new int[cpt];
			for (int i = nouveauTableau.length - 1; i >= 0; i--) {
				nouveauTableau[nouveauTableau.length - i - 1] = reste / (int) Math.pow(2, i);
				reste = reste % (int) Math.pow(2, i);
			}
		}

		return nouveauTableau;
	}
}