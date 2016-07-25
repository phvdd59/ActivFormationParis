package com.formation.emma.exo;

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
		int[] tableau = null;
		if (tab == null) {
			tableau = tab;
		} else {
			tableau = new int[tab.length];
			for (int i = 0; i < tableau.length; i++) {
				tableau[i] = tab[tab.length - i - 1];
			}
		}
		return tableau;
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
		int[] tableau = null;
		if (tab == null) {
			tableau = tab;
		} else {
			tableau = new int[tab.length + 1];
			for (int i = 0; i < tab.length; i++) {
				tableau[i] = tab[i];
			}
			tableau[tab.length] = a;
		}
		return tableau;
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
		int[] tableauFinal = null;
		int k = p;

		if (tab1 == null || tab == null || p < 0 || p > tab.length || p - 1 + tab1.length >= tab.length) {
			tableauFinal = tab;
		} else {
			tableauFinal = new int[tab.length + tab1.length];
			for (int i = 0; i < tableauFinal.length; i++) {
				if (i < p) {
					tableauFinal[i] = tab[i];
				} else if (i == p) {
					for (int j = 0; j < tab1.length; j++) {
						tableauFinal[i] = tab1[j];
						k++;
						i++;
					}
					i--;
				} else if (i >= k) {
					tableauFinal[i] = tab[p];
					p++;
				}
			}
		}
		return tableauFinal;
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
		int[][] tableauFinal = null;
		int k = 0;
		if (tab == null || d > tab.length || tab.length % d != 0) {
			return null;
		} else {
			int nbDeLigne = tab.length / d;
			tableauFinal = new int[nbDeLigne][d];
			for (int i = 0; i < nbDeLigne; i++) {
				for (int j = 0; j < d; j++) {
					tableauFinal[i][j] = tab[k];
					k++;
				}
			}
		}
		return tableauFinal;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */

	//128 + 64 + 32+ 16 + 8 + 4 + 2 + 1
	public int[] tabBaseDeux(int v) {
		int[] valeurBinaire = null;

		if (v < Integer.MIN_VALUE || v > Integer.MAX_VALUE) {
			valeurBinaire = null;
		} else {
			valeurBinaire = new int[32];
			for (int i = 0; i < valeurBinaire.length; i++) {

				if (v - Math.pow(2, 31 - i) > 0) {
					valeurBinaire[i] = 1;
					v = (int) (v - Math.pow(2, 31 - i));
				} else if (v - Math.pow(2, 31 - i) == 0) {
					valeurBinaire[i] = 1;
					break;
				} else {
					valeurBinaire[i] = 0;
				}
			}
		}
		return valeurBinaire;
	}
	
}
