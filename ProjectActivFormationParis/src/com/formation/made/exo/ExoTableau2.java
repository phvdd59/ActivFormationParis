package com.formation.made.exo;

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
		int[] tabInverse = null;
		if (tab == null) {
		} else {
			for (int i = 0; i < tab.length; i++) {
				tabInverse = tab.clone();
				tabInverse[i] = tab[tab.length - 1 - i];
				// System.out.println(tabInverse[i]);
			}
		}
		return tabInverse;

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
		int[] tableaurallonge = null;
		if (tab == null) {
		} else {
			tableaurallonge = new int[tab.length + 1];
			for (int i = 0; i < tab.length; i++) {
				tableaurallonge[i] = tab[i];
			}
			tableaurallonge[tab.length] = a;
			for (int i = 0; i < tableaurallonge.length; i++) {
				// System.out.println(tableaurallonge[i]);
			}
		}
		return tableaurallonge;
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
		int[] tableauinsere = null;
		if (p > tab.length || p < 0) {
		} else {

			tableauinsere = new int[tab.length + tab1.length];
			for (int i = 0; i < p; i++) {
				tableauinsere[i] = tab[i];
			}
			for (int i = p; i < tab1.length + p; i++) {
				tableauinsere[i] = tab1[i - p];
			}
			for (int i = tab1.length + p; i < tableauinsere.length; i++) {
				tableauinsere[i] = tab[i - tab1.length];
			}
			for (int i = 0; i < tableauinsere.length; i++) {
				// System.out.println(tableauinsere[i]);
			}
		}
		return tableauinsere;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2 [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param d
	 *            dimension de base
	 * @return tableau de n dimensions de base
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		int[][] tableaudim = null;
		if (tab == null || tab.length % 2 != 0) {
		} else if (d == 2) {
			tableaudim = new int[tab.length / 2][d];
			for (int i = 0; i < tab.length / 2; i++) {
				for (int j = 0; j < 2; j++) {
					tableaudim[i][j] = tab[2 * i + j];
					// System.out.println(tableaudim[i][j]);
				}
			}
		} else if (d == tab.length / 2) {
			tableaudim = new int[2][tab.length / 2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < d; j++) {
					tableaudim[i][j] = tab[((tab.length / 2) * i) + j];
					// System.out.println(tableaudim[i][j]);
				}

			}
		}
		return tableaudim;
	}

	/**
	 * Exemple v=18 --> résultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entrée
	 * @return tableau représentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		int[] tableaubinaire = null;
		int puissance = 31;
		while (v % Math.pow(2, puissance) == v) {
			puissance--;
		}
		tableaubinaire = new int[puissance + 1];
		for (int i = puissance; i >= 0; i--) {
			if (v % Math.pow(2, i) != 0) {
				tableaubinaire[puissance - i] = 1;
				v = v % (int) Math.pow(2, i);
			} else {
				tableaubinaire[puissance + 1 - i] = 0;
			}

		}
		for (int i = 0; i < tableaubinaire.length; i++) {
			// System.out.println(tableaubinaire[i]);

		}
		return tableaubinaire;
	}
}